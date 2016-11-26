function invalclassInput(whichRunner) { //Function checks formatting, if correct calls calculation function
    var checkIfEmpty = /^\s*$/; //checks if time is empty to avoid unnecessary error messages
    var checkFormat = /^([0-5][0-9]|[0-9]):([0-5][0-9])(:|\.)\d{3}$/ //regular expression for checking in format mm:ss.sss
    var table = document.getElementById("table1");
    var timeOne = document.getElementById("Time1R" + whichRunner).value;
    var timeTwo = document.getElementById("Time2R" + whichRunner).value; //retrieving input values
    var timeTotal = document.getElementById("TimeTotR" + whichRunner).value;
    var T1 = false;
    var T2 = false; //Time booleans, turn true if correct format
    var Ttot = false;
    var error = false; //error boolean, turn true if error alert should be shown
    if (!checkIfEmpty.test(timeOne) && !checkFormat.test(timeOne)) { //First check to see if incorrect format AND not empty
        document.getElementById("Time1R" + whichRunner).style.border = "solid 6px red"; //sets border red if error exists
        error = true; //turns true for alert to show up
        document.getElementById("Time1R" + whichRunner).blur(); //blurs to avoid accidental resubmission, occasionally causes alert spam if not done
    } else if (!checkIfEmpty.test(timeOne) && checkFormat.test(timeOne)) { //Second check if format is correct AND not empty
        document.getElementById("Time1R" + whichRunner).style.border = "solid 1px orange"; //sets border to normal if error was fixed
        T1 = true;
        error = false;
    }
    if (!checkIfEmpty.test(timeTwo) && !checkFormat.test(timeTwo)) { //First check to see if incorrect format AND not empty
        document.getElementById("Time2R" + whichRunner).style.border = "solid 6px red"; //sets border red if error exists
        error = true; //turns true for alert to show up 
        document.getElementById("Time2R" + whichRunner).blur(); //blurs to avoid accidental resubmission, occasionally causes alert spam if not done
    } else if (!checkIfEmpty.test(timeTwo) && checkFormat.test(timeTwo)) { //Second check if format is correct AND not empty
        document.getElementById("Time2R" + whichRunner).style.border = "solid 1px orange"; //sets border to normal if error was fixed
        T2 = true;
        error = false;
    }
    if (!checkIfEmpty.test(timeTotal) && !checkFormat.test(timeTotal)) { //First check to see if incorrect format AND not empty
        document.getElementById("TimeTotR" + whichRunner).style.border = "solid 6px red"; //sets border red if error exists
        error = true; //turns true for alert to show up 
    } else if (!checkIfEmpty.test(timeTotal) && checkFormat.test(timeTotal)) { //Second check if format is correct AND not empty
        Ttot = true;
        error = false;
        document.getElementById("TimeTotR" + whichRunner).blur(); //blurs to avoid accidental resubmission, occasionally causes alert spam if not done 
        document.getElementById("TimeTotR" + whichRunner).style.border = "solid 1px orange"; //sets border to normal if error was fixed
    }
    if (error) { //Sends one error message if one or more errors exist in table
        alert("Wrong Format! (mm:ss.sss)");
    }
    if (T1 && T2 && Ttot) { //If all true (good format), carry on with calculations
        calculations(whichRunner);
    }
}

function helpButton() { //help button, displays instructions
    window.alert("Thank you for using the cross country split calculator. \n \n Please fill out all the times in a row in order to get splits.\n \n Times must be in minutes, seconds, mileseconds format. Ex: 3:55.222 \n");
}
var idNumber = 6; //initial starting num of rows
function removeRunner(r) { //method asks to remove runner while keeping previous submissions in order
    if (confirm("Are you sure you want to delete this runner?")) {
        var i = r.parentNode.parentNode.rowIndex;
        document.getElementById("table1").deleteRow(i);
        var runnerNumOfTimes = document.getElementById("table1").rows.length;
    }
}

function addRunner() {
    var table = document.getElementById("table1");
    var row = table.insertRow(-1); //inserts new row at bottom
    row.id = idNumber; //sets row id for finding which runner
    var removeRunnerButton = row.insertCell(0); //inserts cells needed
    var fNameIn = row.insertCell(1);
    var timeOneIn = row.insertCell(2);
    var timeTwoIn = row.insertCell(3);
    var splitTwoRow = row.insertCell(4);
    var splitThreeRow = row.insertCell(5);
    var totTimeIn = row.insertCell(6);
    removeRunnerButton.innerHTML = ' <input name="remove" onclick="removeRunner(this)" type="button" value="x">';
    fNameIn.innerHTML = ' <input class="name" id="NameR' + idNumber + '" placeholder="Name" type="text">'; //adds id number variable so that id numbers stay in order
    timeOneIn.innerHTML = ' <input class="time" id="Time1R' + idNumber + '" onblur="invalclassInput(' + idNumber + ')" placeholder="Time one" type="text"> ';
    timeTwoIn.innerHTML = ' <input class="time" id="Time2R' + idNumber + '" onblur="invalclassInput(' + idNumber + ')" placeholder="Time two" type="text"> ';
    splitTwoRow.innerHTML = '<input class="results" id="Split2R' + idNumber + '" placeholder="Split Two" type="text" disabled>';
    splitThreeRow.innerHTML = '<input class="results" id="Split3R' + idNumber + '" placeholder="Split Three" type="text" disabled>';
    totTimeIn.innerHTML = ' <input class="time" id="TimeTotR' + idNumber + '" onblur="invalclassInput(' + idNumber + ')" placeholder="Total time" type="text">  ';
    idNumber++; //increments global variable once a new runner added so that next ids are accurate and unique
}

function calculations(whichRunner) { //calculations, same as last year
    var table = document.getElementById("table1");
    var SEC_IN_MIN = 60; //because magic numbers are evil
    var timeOne = document.getElementById("Time1R" + whichRunner).value;
    var timeTwo = document.getElementById("Time2R" + whichRunner).value;
    var timeTotal = document.getElementById("TimeTotR" + whichRunner).value;
    var FirstMIleMin = parseInt(timeOne.split(":")[0]);
    var FirstMileSec = parseFloat(timeOne.split(":")[1]);
    var FirstMTotalSec = SEC_IN_MIN * FirstMIleMin + FirstMileSec;
    var SecondMIleMin = parseInt(timeTwo.split(":")[0]);
    var SecondMileSec = parseFloat(timeTwo.split(":")[1]); //takes inputs raw data for mile 2, converts for math. Splits based on min,sec
    var SecondMTotalSec = SEC_IN_MIN * SecondMIleMin + SecondMileSec;
    var TotalMIleMin = parseInt(timeTotal.split(":")[0]);
    var TotalMileSec = parseFloat(timeTotal.split(":")[1]);
    var TotalMTotalSec = SEC_IN_MIN * TotalMIleMin + TotalMileSec;
    var SplitTwo = SecondMTotalSec - FirstMTotalSec;
    var SplitTwoSecs = SplitTwo % SEC_IN_MIN;
    var SplitThree = TotalMTotalSec - SecondMTotalSec;
    var SplitThreeSecs = SplitThree % SEC_IN_MIN; //this block calculates the splits based on total seconds. 
    var splitTwoSecsFinal = SplitTwoSecs.toFixed(3);
    var splitThreeSecsFinal = SplitThreeSecs.toFixed(3);
    if (splitTwoSecsFinal.split(".")[0].length == 1) { //Fixes formatting for single digit seconds, adds extra 0
        splitTwoSecsFinal = "0" + splitTwoSecsFinal.split(".")[0] + ".000";
    }
    if (splitThreeSecsFinal.split(".")[0].length == 1) { //Fixes formatting for single digit seconds, adds extra 0
        splitThreeSecsFinal = "0" + splitTwoSecsFinal.split(".")[0] + ".000";
    }
    var returnSplitTwo = "Split Two: " + (parseInt(SplitTwo / SEC_IN_MIN)) + ":" + splitTwoSecsFinal; //sets up final return strings, finishes minute conversion
    var returnSplitThree = "Split Three: " + (parseInt(SplitThree / SEC_IN_MIN)) + ":" + splitThreeSecsFinal;
    var tableSplitTwo = document.querySelector("#Split2R" + whichRunner);
    tableSplitTwo.value = returnSplitTwo; //sets as value for text box
    var tableSplitThree = document.querySelector("#Split3R" + whichRunner);
    tableSplitThree.value = returnSplitThree;
}