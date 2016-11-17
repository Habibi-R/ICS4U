function maxNum(num1, num2){
var num1 = document.getElementsByClassName("num1")[0].value;
var num2 = document.getElementsByClassName("num2")[0].value;
if(num1>num2){
	console.log(num1);
}else{
	console.log(num2); 
}
}

function maxOfThree(num1, num2, num3){
var num1 = document.getElementsByClassName("num1")[1].value;
var num2 = document.getElementsByClassName("num2")[1].value;
var num3 = document.getElementsByClassName("num3")[0].value;

if(num1>num2 && num1>num3){
	console.log(num1);
}else if(num2> num1 && num2>num3){
	console.log(num2);
}else{
	console.log(num3);
}

}	

function isVowel(checkThis){
	var checkThis = document.getElementsByClassName("str")[0].value;

	if(checkThis == 'a' || checkThis == 'e' || checkThis == 'i' || checkThis == 'o' || checkThis == 'u'){
		console.log("Vowel");
}else{
	console.log("Not vowel");
}
}

