function exampleController(num){
              if (num == 1)
                             exampleOne();
              else if (num == 2)
                             exampleTwo();
              else if (num == 3)
                             exampleThree();
              else if (num == 4)
                             exampleFour();
              else if (num ==5)
                            exampleFive();
}

function exampleOne(){
              var num = 3;
              var string1 = 'Hello';
              var string2 = "Goodbye";
              /* alert(1); */
              console.log(num);
              console.log(string1);
              console.log(string2);

}

function exampleTwo(){
              //var i=0;
              var sum=0;
              var num=10;

              for (var i=0; i<=num; ++i){
                             sum += i;
              }

              console.log('The numbers 1 to 10 add to ' + sum);

}

function exampleThree(){
              var arr = [];
              var arr2 = new Array(5);
              arr[0] = 10;
              arr[3] = 4;
              arr2[0] = 8;
              arr2[3] = 7;
              arr2[8] = 10;
              arr[1] = 'Good Question';

              for (var i=0; i<=arr.length; ++i){
                             if (arr[i] !== undefined && !isNaN(arr[i])){
                                           console.log(arr[i]);
                             }
              }
}

var exampleFour = function(){
              var obj = {};        // is an object / map
              obj.hello = 7;
              obj.goodbye = 9;
              obj[5] = 3;
              obj['test'] = 12;
              console.log('Test...');
              var arr = [];
              arr[4] = 6;
              obj['morestuff'] = arr;

              obj['func'] = function(){alert(1);};


              console.log(obj);
              var str = JSON.stringify(obj);
              console.log(str);
              var obj2 = JSON.parse(str);
              console.log(obj2);

              obj['func']();
              
}

function exampleFive(){
  var theParagraph = document.querySelectorAll('#myParagraph');
  console.log(theParagraph[0].innerHTML);
  theParagraph[0].innerHTML = 'I like me';
  theParagraph[0].style['text-align'] = 'center';
  theParagraph[0].onmouseover = function(){alert("boom");};
  //theParagraph[0].onkeyp[]
}