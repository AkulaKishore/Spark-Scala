object LearningScala3 {
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
 
 def squareIt(x : Int) : Int = {
 			x*x;
 }                                                //> squareIt: (x: Int)Int
 
def cubeIt(x : Int) : Int = {

	x*x*x;
	}                                         //> cubeIt: (x: Int)Int
 
 
 
 
  println(squareIt(2))                            //> 4
  
  println(cubeIt(2))                              //> 8
  
  // Functions can take other functions as parameters
  
 def testIt( x: Int , f: Int => Int): Int = {
 f(x)
 }                                                //> testIt: (x: Int, f: Int => Int)Int
 
 val result = testIt(2, squareIt);                //> result  : Int = 4
 
 println(result)                                  //> 4
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  testIt(3, x => x * x * x)                       //> res0: Int = 27
  
  testIt(10, x => x / 2)                          //> res1: Int = 5
  
  testIt(2, x => {val y = x * 2; y * y})          //> res2: Int = 16
  
  
  //cubeIt(2, x => x*x*x)
  // This is really important!
  
testIt(2,x => x * x * x)                          //> res3: Int = 8

  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  
  def upperCase ( s : String) :String = {
  
  s.toUpperCase();
  }                                               //> upperCase: (s: String)String
  
  var ans : String  = upperCase("foo")            //> ans  : String = FOO
  println(ans)                                    //> FOO



def upperCase1(s:String, f:String=> String) :String = {
f(s) }                                            //> upperCase1: (s: String, f: String => String)String


println( upperCase1("foo", x => x.toUpperCase())) //> FOO
}