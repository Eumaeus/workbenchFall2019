import scala.io.Source
import edu.holycross.shot.cite._

:load utilities.sc

// Characters and Strings

val aChar = 'a'

val aString = "a"

val anotherString = aChar.toString

val filepath:String = "texts/pride_and_prejudice.txt"
val myLines:Vector[String] = Source.fromFile(filepath).getLines.toVector

println(s"There are ${myLines.size} lines in ${filepath}")

val noBlanks:Vector[String] = myLines.filter(_.size > 0)

println(s"\n\nThere are ${noBlanks.size} lines in noBlanks\n")

val myFavorite:String = noBlanks(1)


// Tokenizing

val myChars: Vector[Char] = myFavorite.toVector

val myWords: Array[String] = myFavorite.split(" ")
val myWordVec: Vector[String] = myWords.toVector

myWords(0)
myWords(1)
myWords(2)
myWords(3)

// Before we can write our own spell checker, we need to get rid of punctuation

myFavorite.replaceAll("e","X")

myFavorite.replaceAll(",","")





