A good chunk of the below is taken from The Big Book: _Programming in Scala, Second Edition_. Except for the spelling errors, that's just me.

# Partially applied

## What is it?

> A partially applied function is an expression in which you don't supply all of the arguments needed by the function. Instead you supply some, or none, of the needed arguments.
>
> —pg 149

## What does it look like?

```scala
def sum(a: Int, b: Int, c: Int): Int = a + b + c

// SUPPLY NONE:
val sumAlias = sum _ // (Int, Int, Int) => Int
sumAlias(1, 2, 3) // OUTPUT: 6
sumAlias(2, 4, 6) // OUTPUT: 12

// SUPPLYE SOME
val sumB = sum(1, _: Int, 3) // (Int) => Int
sumB(2) // OUTPUT: 6
sumB(4) // OUTPUT: 8
```

## What if I hate underscores?

> If you are writing a partially applied function expression in which you leave off all parameters, such as `println _` or `sum _`, you can express it more concisely by leaving off the underscore if a function is required at that point in the code.
>
> —pg 151

```scala
someNumbers.foreach(println _)
someNumbers.foreach(println)
```

## Why would I do this?

This allows you to create new functions off of existing functions, especially where you have some of the parameters earlier than the rest. Instead of needing to continue passing around the parameters you acquired earlier, you can make a partially applied function and share that.

# Closure

## What is it?

Take the function `(x: Int) => x + more`. Looks great — except, what is `more`? It's a _free variable_ — the function literal doesn't give it a meaning. Therefore `more` must exist elsewhere for our function to be able to add `more`.

At runtime, the function value created from this function literal is a _closure_ because it _closes_ the function literal by _capturing_ a binding for its free variables. No more _open term_ — we have filled it with something!

(In constrast, if we had `(x: Int) => x + 1`, that has no free variable so is a _closed term_ — it's already been closed.)

## Can I tweak the free variable outside the closure?

```scala
var more = 0 // NOTE how this is mutable

val addMore = (x: Int) => x + more

var more = 1
addMore(1) // OUTPUT: 2

var more = 100
addMore(1) // OUTPUT: 101
```

>Scala's closures capture variables tehmselves, not the value to which variables refer.
>
>By contrast, Java's inner classes do not allow you to access modificable variables in surrounding scopes at all, so there is no difference between capturing a variable and capturing its currently held value.
>
>—pg 154

## But what if my free variable is removed from the stack?

```scala
def makeIncreaser(more: Int): (Int) => Int = (x: Int) => x + more
```

> It makes no difference that the `more` in this case is a parameter to a method call that has already returned. The Scala compiler rearranges things in cases like this so that the captured paramter lives out on the heap, instead of the stack, and thus can outlive the method call that created it.
>
> —pg 155

# Currying

> Scala allows you to create new control abstractions that "feel like native language support." […] To understand how to make control abstractions that feel more like language extensions, you first need to understand the functional programming technique called _currying_.
>
> —pg 171

## What is it?

> A curried function is applied to multiple argument lists, instead of just one.
>
> —pg 171

```scala
def notSpicyAddition(x: Int, y: Int): Int = x + y
notSpicyAddition(1, 2) // OUTPUT: 3

def curriedAddition(x: Int)(y: Int): Int = x + y
curriedAddition(1)(2) // OUTPUT: 3
```

## How does this happen?

In our `curriedAddition` example, when you invoke `curriedAddition(1)(2)`, you get back the `Int` you expect. What happens in reality is that `curriedAddition(1)` returns a function equivalent to `(Int) => 1 + y` that immediately gets evaluated.

As with partially applied functions, this means you can create functions from functions:

```scala
val curriedLaterAddition = curriedAddition(1) // (y: Int): Int => 1 + y
curriedLaterAddition(2) // OUTPUT: 3
```

## But can you show me an example using sorting?

The below merge sort call is from pg 321:

```scala
def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = ???

val lessThan = (x: Int, y: Int) => x < y
val msortLessThan = msort(lessThan)

val input1 = List(5, 3, 67, 8, 35, 39)
msortLessThan(input1)
val input2 = List(325098350, 32400324, 210095, 903409)
msortLessThan(input2)
```

# Interchanging `val` and `def`

You may have noticed functions being assigned to `val`s and not just `def`s.

* `def` is _evaluted_ when it's _called_
* `val` is _evaluted_ when it's _defined_

If you remember from above what a _function value_ is in relation to closure, then this will make a lot of sense:

* Each time you call a `def` function, a new function value is made
* Each time you call a `val` function, you're using the same function value

# Renaming imports

Say I have an import as belows:

```scala
import groupwork.examples.ReallySpecificNameOfClassOrObject
```

I can give it an alias (rename it) so that calling `ReallySpecificNameOfClassOrObject.fncWant` becomes `NiceAlias.fncWant`.

```scala
import groupwork.examples.{ReallySpecificNameOfClassOrObject => NiceAlias}
```

This is particularly helpful when the name of what you're importing doesn't exactly match up with what it will be used for, for example importing something like a package object that serves as a factory:

```scala
// before
groupwork.examples.database_connectors

database_connectors.getSqlConnection(properties)

// after
groupwork.examples.{database_connectors => DbConnectionFactory }

DbConnectionFactory.getSqlConnection(properties)
```

# Exercise: Make a factory

The below uses database connectors as its example but you can use something else so long as you follow the general pattern.

1. Create a database package. Within that package, create the following:
   1. a package object
   2. at least two traits for database contracts (eg SqlDatabase, TeamDatabase, EdenDatabase, etc)
   3. one abstract database connector class
   4. one dummy implementation, extending the abstract class, for each trait
2. Make your dummy implementations private to the package, eg `private[database] class TeamDatabases`.
3. In your package object, create factory functions to produce database connections based on the contract (trait) want, eg: `def getSqlConnection(properties: Map[String, Any]): DatabaseConnection with SqlDatabase`.
4. Import your package object somewhere and use it as a factory.

Extra credit for including the following:

* Partially applied functions
* Closure
* Curried functions
* Renamed imports

