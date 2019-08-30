import scala.io.Source
import edu.holycross.shot.cite._


val filepath:String = "/vagrant/iliad_alignment/iliad_pope.txt"
val myLines:Vector[String] = Source.fromFile(filepath).getLines.toVector

println(s"\n\nThere are ${myLines.size} lines in myLines\n")

val noBlanks:Vector[String] = myLines.filter(_.size > 0)

println(s"\n\nThere are ${noBlanks.size} lines in noBlanks\n")

val myFavorite:String = noBlanks(1)

// Characters and Strings

val aChar = 'a'

val aString = "a"

val anotherString = aChar.toString

// Tokenizing

val myChars:Vector[Char] = myFavorite.toVector

// What would you use to change every one of those Chars to Strings? Map or Filter?

val myShortStrings:Vector[String] = myChars.map(_.toString)

val myWords:Array[String] = myFavorite.split(" ")

myWords(0)
myWords(1)
myWords(2)
myWords(3)

// Before we can write our own spell checker, we need to get rid of punctuation

myFavorite.replaceAll("e","X")

myFavorite.replaceAll(",","")





