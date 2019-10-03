import scala.io.Source
import edu.holycross.shot.cite._
import edu.holycross.shot.scm._
import edu.holycross.shot.ohco2._
import java.io._
import scala.annotation.tailrec

def showMe(v:Any):Unit = {
  v match {
    case _:Vector[Any] => println(s"""\n----\n${v.asInstanceOf[Vector[Any]].mkString("\n")}\n----\n""")
    case _:Iterable[Any] => println(s"""\n----\n${v.asInstanceOf[Iterable[Any]].mkString("\n")}\n----\n""")
    case _ => println(s"\n-----\n${v}\n----\n")
  }
}

def loadLibrary(fp:String):CiteLibrary = {
	val library = CiteLibrary(Source.fromFile(fp).getLines.mkString("\n"))
	library
}

def loadFile(fp:String):Vector[String] = {
	Source.fromFile(fp).getLines.toVector
}

def saveStringVec(sv:Vector[String], filePath:String = "texts/", fileName:String = "temp.txt"):Unit = {
	val pw = new PrintWriter(new File(filePath + fileName))
	for (s <- sv){
		pw.append(s)
		pw.append("\n")
	}
	pw.close
}

def saveString(s:String, filePath:String = "texts/", fileName:String = "temp.txt"):Unit = {
	val pw = new PrintWriter(new File(filePath + fileName))
	pw.append(s)
	pw.close
}

def splitWithSplitter(text: String, puncs: String =  """[()\[\]·⸁.,; "?·!–—⸂⸃]"""): Vector[String] = {
	val regexWithSplitter = s"((?<=${puncs})|(?=${puncs}))"
	text.split(regexWithSplitter).toVector.filter(_.size > 0)
}

val punctuation: String = """[“”()\[\]·…⸁.,:; "?·!⸂⸃–—-]"""
val alphabet: String = """[A-Za-z]"""

val stopWords: Vector[String] = Vector("i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now")


/* Some functions implementing the AKS Test for prime numbers (http://rosettacode.org/wiki/AKS_test_for_primes). Offered here just in case it is ever useful! */

def powerMin1(n: BigInt) = if (n % 2 == 0) BigInt(1) else BigInt(-1)

val limitForPascal: Int = 100 // the test takes forever as n gets bigger
 
val pascal = (( (1 to limitForPascal).foldLeft(Vector(Vector(BigInt(1))))) { (rows, i) =>
    val v = rows.head
    val newVector = ((1 until v.length) map (j =>
        powerMin1(j+i) * (v(j-1).abs + v(j).abs))
    ).toVector
    (powerMin1(i) +: newVector :+ powerMin1(i+v.length)) +: rows
}).reverse
 
def poly2String(poly: Vector[BigInt]) = ((0 until poly.length) map { i =>
    (i, poly(i)) match {
        case (0, c) => c.toString
        case (_, c) =>
            (if (c >= 0) "+" else "-") +
            (if (c == 1) "x" else c.abs + "x") +
            (if (i == 1) "" else "^" + i)
    }
}) mkString ""
 
def isPrime(n: Int): Option[Boolean] = {
	try {
		if ( n > limitForPascal) {
			throw new Exception(s"The parameter-Int cannot be greater than ${limitForPascal}. ${n} is greater.")
		}
    val poly = pascal(n)
    Some(poly.slice(1, poly.length - 1).forall(i => i % n == 0))
  } catch {
  	case e: Exception => println(s"Exception in isPrime: ${e}")
		None
  }
}

/* End AKS Prime test stuff */
