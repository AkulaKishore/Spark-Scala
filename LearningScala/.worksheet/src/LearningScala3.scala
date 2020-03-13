object LearningScala3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(226); 
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
 
 def squareIt(x : Int) : Int = {
 			x*x;
 };System.out.println("""squareIt: (x: Int)Int""");$skip(44); 
 
def cubeIt(x : Int) : Int = {

	x*x*x;
	};System.out.println("""cubeIt: (x: Int)Int""");$skip(31); 
 
 
 
 
  println(squareIt(2));$skip(24); 
  
  println(cubeIt(2));$skip(115); 
  
  // Functions can take other functions as parameters
  
 def testIt( x: Int , f: Int => Int): Int = {
 f(x)
 };System.out.println("""testIt: (x: Int, f: Int => Int)Int""");$skip(37); 
 
 val result = testIt(2, squareIt);System.out.println("""result  : Int = """ + $show(result ));$skip(19); ;
 
 println(result);$skip(203); val res$0 = 
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  testIt(3, x => x * x * x);System.out.println("""res0: Int = """ + $show(res$0));$skip(28); val res$1 = 
  
  testIt(10, x => x / 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(44); val res$2 = 
  
  testIt(2, x => {val y = x * 2; y * y});System.out.println("""res2: Int = """ + $show(res$2));$skip(91); val res$3 = 
  
  
  //cubeIt(2, x => x*x*x)
  // This is really important!
  
testIt(2,x => x * x * x);System.out.println("""res3: Int = """ + $show(res$3));$skip(391); 

  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  
  def upperCase ( s : String) :String = {
  
  s.toUpperCase();
  };System.out.println("""upperCase: (s: String)String""");$skip(42); 
  
  var ans : String  = upperCase("foo");System.out.println("""ans  : String = """ + $show(ans ));$skip(15); 
  println(ans);$skip(66); 



def upperCase1(s:String, f:String=> String) :String = {
f(s) };System.out.println("""upperCase1: (s: String, f: String => String)String""");$skip(52); 


println( upperCase1("foo", x => x.toUpperCase()))}
}
