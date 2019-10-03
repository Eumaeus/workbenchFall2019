import scala.io.Source

:load utilities.sc

/* The above is an SBT command (note the ':') that pre-loads 
   a number of Functions and Values that you might 
   find helpful. (SBT commands need to come _first_
   in a script, for some reason.)
*/


// Let's get a text!
val myLines: Vector[String] = loadFile("texts/ulysses.txt")
showMe(myLines)

/* .map lets us do SOMETHING to EVERTHING in a Vector.
	There are two ways to do this: 
	-	using the '_' character ("fill in the blank")
	- using a Value representing _each_ element of the Vector
*/

// Using '_'

//val ucUlysses: Vector[String] = myLines.map( _.toUpperCase )
//showMe( ucUlysses )

// Using a value representing each element

//val lcUlysses: Vector[String] = myLines.map( ln => ln.toLowerCase ) 
//showMe( lcUlysses )

// Multi-line .map routines

/*
val summarizedUlysses: Vector[String] = myLines.map( ln => {
	val firstEight: String = ln.take(8)
	val lastEight: String = ln.takeRight(8)
	val shortened: String = s"${firstEight}...${lastEight}"
	shortened	
})
showMe( summarizedUlysses )
*/

/* .filter

	.filter lets you _select some_ elements in a Vector.
	A "filter" function must include a statement, or statements
	that result in a Boolean value: true or false.

	That test is the "filter": If, for an element, the result is
	"true", it passes through the filter. "false" and it is rejected.
*/

// Simple filters
//val nums: Vector[Int] = Vector(1,2,3,4,5,6,7,8,9,10)
//val lessThanFive: Vector[Int] = nums.filter( _ < 5 )
//val evenNums: Vector[Int] = nums.filter( _ % 2 == 0 )
//val oddNums: Vector[Int] = nums.filter( _ % 2 != 0 )

/* Fancy, if you are interested:

	First, the isPrime() Function is not built into Scala.
	See the bottom of utilities.sc

	Second, the Option[Boolean] is a Scala thing.
	What if you want a Boolean, but your function might
	not be able to deliver one? What is _neither_ true nor false?

	Likewise, what if a Function is supposed to return an Int or
	a String, but for some reason can't? 

	Other languages use 'nil' or 'null', but there are
	problems with this. What *type* is 'nil'?
*/
/*
val moreNums: Vector[Int] = ( 1 to 100 ).toVector
val primeNums: Vector[Int] = moreNums.filter( n => {
	val primeOption: Option[Boolean] = isPrime(n)
	primeOption match {
		case Some(b) => b
		case None => false
	}
})
*/

// More complex filters
/*
val whereUTalksAboutHimself: Vector[String] = myLines.filter( ln => {
	val words:Vector[String] = ln.split("[ .,;—]").toVector
	words.contains("I")
})
showMe(whereUTalksAboutHimself)
*/

// What does words.contains("I") do? Try…
/*
val v: Vector[String] = Vector( "a", "b", "c", "d", "ee" )
v.contains("d")
v.contains("e")
v.contains("ee")
*/

// And some stats?
/*
val allLines: Int = myLines.size - 2 // why?
val iLines: Int = whereUTalksAboutHimself.size
val iPercent: Int = {
	val dbl: Double = (iLines.toDouble / allLines ) * 100
	dbl.toInt
}
println(s"""The poem uses "I" in ${iPercent}% of lines.""")
*/

// About that .split method that I snuck in…

/*
val firstLine: String = myLines.head
val splitLine = firstLine.split(" ")
val whatClass: String = splitLine.getClass.toString
*/

/* .split() results in an Array[A] (and that means "Array of type Any")
	 …So we always want to go ahead and turn it into a Vector with .toVector
*/



