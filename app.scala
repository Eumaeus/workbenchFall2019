package edu.furman.csc270

import scala.io.Source
import edu.holycross.shot.cite._

/** 

A template for an "app" that you can compile, and for which SBT will give
decent feeback.

*/

object MyApp {
 
  /** Our main function where the action happens */
  def main(args: Array[String]) {

    def loadFile(fp:String):Vector[String] = {
        Source.fromFile(fp).getLines.toVector
    }

    val punctuation: String = """[“”()\[\]·-…⸁.,; "?·!–—⸂⸃]"""
    val alphabet: String = """[A-Za-z]"""   

    val filepath:String = "texts/pride_and_prejudice.txt"
    val myLines:Vector[String] = Source.fromFile(filepath).getLines.toVector

    println(s"""\n There are ${myLines.size} lines in '${filepath}.\n""")

  }
}
