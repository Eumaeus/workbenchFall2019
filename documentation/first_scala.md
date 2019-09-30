
# A Very Basic Introduction to Scala




## Types

Scala is all about *types*. Try typing these in SBT Console:

~~~ scala
scala> 'a'
scala> 'abc' // will throw an error; read the error!
scala> "abc"
scala> 1
scala> 1.0
~~~

Common simple types:

- `Int`
- `BigInt`
- `Double`
- `String`
- `Char`
- `Boolean`

## Values, not Variables

You can use *variables* or *values* in Scala:

~~~ scala
scala> var x = 1 // you can change the value of x
scala> val x = 1 // x will always, hereafter, equal 1. Immutable
scala> val y = x * 2
scala> y = x * 3 // will throw an error!
~~~

If you are using a `var` in Scala, you are probably doing it wrong.[^alas]

Immutable values take some getting used to. They are also only realistic now that computers are so mighty.

[^alas]: Alas, in SBT Console, the Console will "helpfully" allow you to re-define a `val`, even though it will (correctly) not let you change the value of a `val` programmatically.

## Some Operators & Symbols

Some basic operators and symbols for you:

~~~ scala
scala> 1 == 1
scala> 1 == 2
scala> 1 != 2
scala> 2 > 1
scala> 2 < 3
scala> 2 <= 3
scala> 2 <= 2
scala> 3 >= 2
scala> 3 >= 3
scala> "dogs" == "cats"
scala> "dogs" == "dogs"
scala> "dogs" > "dog"
scala> "cats" < "horses"
scala> 1 + 1
scala> 1 - 1
scala> 10 * 3 
scala> 10 / 2
scala> 10 % 2
scala> 10 % 3
~~~

## Specifying Types, for Type-Safety

When you define a `val` you can specify its type:

~~~ scala
scala> val i: Int = 3
scala> val j: Int = 10
scala> val k: Int = 2.0 // will throw an error
~~~

You want to do this, for certainty:

~~~ scala
scala> 10 / 3
scala> 10.0 / 3
scala> val i: Int = 10
scala> val j: Int = 3
scala> val k: Int = i / j
scala> val a: Double = 10
scala> val b: Int = 3
scala> val c: Double = a / b
scala> val d: Int = a / b // Will throw an error
scala> val d: Int = a.toInt / b
scala> val e: Double = i.toDouble / j
~~~

## Methods & Functions

Every Type of data in Scala comes with some, or many *methods*, "things you can do" with a value of that type.

~~~ scala
scala> val s = "A man, a plan, a canal, Panama."
s: String = A man a plan a canal Panama
scala> s.size
scala> s.drop(2)
scala> s.dropRight(7)
~~~

You can attach methods to actual literal values:

~~~ scala
scala> "Panama".size
scala> "Panama".toUpperCase
scala> 10.4.intValue
scala> 10.4.ceil
scala> 10.4.floor
scala> 10.max(5)
scala> 10.max(50)
scala> 10.min(5)
scala> 10.min(50)
scala> 10.isInfinite
scala> b: Double = Double.MaxValue
scala> b.isInfinite
scala> val i: Double = Double.PositiveInfinity
scala> i.isInfinite
~~~

Learning all these methods is a long journey. I use about 7% of them. You can see what is available:

~~~ scala
scala> s.<tab> // type x. and then hit the tab-key. You will see every method attached to a String.
scala> s.toLowerCase
scala> s.replaceAll(" ","")
scala> s.replaceAll("[ ,.]","") // regular expressions!
scala> s.reverse
~~~

You can chain methods, kind of like in Unix:

~~~ scala
scala> val s = "A man, a plan, a canal, Panama."
scala> val t = s.replaceAll("[ ,.]","").toLowerCase
scala> t == t.reverse
~~~

A *function* takes input(s) with defined types, and returns an output of a defined type. This is the heart of **Functional Programming**.

~~~ scala
scala> def timesTwo( n: Int ): Int = { n * 2 }
scala> timesTwo(4)
scala> timesTwo(1024)
~~~

~~~ scala
scala> def isPalandrome( s: String ): Boolean = { val t = s.replaceAll("[ ,.]","").toLowerCase; t == t.reverse }
scala> val as: String = "Sit on a potato pan, Otis."
scala> isPalandrome(as)
scala> val bs: String = "Able was I, ere I saw Elba."
scala> isPalandrome(bs)
~~~

When we are working in scripts, we can use prettier formatting, and be more clear:

~~~ scala
def isPalandrome( s: String ): Boolean = {
	val t1: String = s.toLowerCase
	val t2: String = transformation1.replaceAll("[ ,.]","")
	t2 == t1.reverse // the functiong returns the last value named
}

~~~

Note that all of these methods return a *new* value!



