
// This is one-line comment

val s: String = "Dennis sinned."

val sNoSpace: String = s.replaceAll(" ","")
val sNoPunc1: String = s.replaceAll(".","")
val sNoPunc2: String = s.replaceAll("[.]","")
val sPlus: String = s.replaceAll("[ ,.]","").toLowerCase

sPlus == sPlus.reverse

/* A Custom Function
		- Accept a String
		- Do a little clean-up and compression
		- Report whether it is a palindrome.

		Some Palindromes to test:
		"Sit on a potato pan, Otis."
		"A man, a plan, a canal, Panama."	
		"Able was I, ere I saw Elba."
		"In girum imus nocte et consumimur igni"	
		"Sum summus mus."
*/





