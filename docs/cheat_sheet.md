# TOC

* [Syntax](#syntax)
* [Testing](#testing)

# Syntax

## `???`

```scala
def incompleteFnc: Int = ???
val incompleteValue: Double = ???
```

* syntax for incomplete definitions
  * type of `Nothing` so compiles without issue
* allows stubbing out of definitions
  * great for when you know the function's signature but not its contents
  * allows you to write the test before the functionality
* is your function not yet done? `???`
* do you not just have this value's value? `???`

## `val`

```scala
val sampleNumber: Int = 5
```

* for immutable values

* just… be immutable

  * don't worry about mutable variables

  * - they will only break your heart

## `println`

```scala
println("Hello world!")
```

* prints a thing out
* has side effects
  * try to limit to your driver and debugging
* protip: as soon as you write `println` follow it up with `//todo: remove` so you don't forget

## Tuples

```scala
val twoTuple = (1, 2)
println(twoTuple._1) // 1
println(twoTuple._2) // 2
val threeTuple = (1, "hello", false)
println(twoTuple._3) // false
```

## `if` statements

```scala
if (boolThis) action else otherAction

if (boolThis) action
else otherAction

if (boolThis) action
else if (boolThat) {
	biggerAction
	multiLineAction
}
else otherAction
```

## Function definition

```scala
def fncName: String = ???
def fncName(pOne: Int, pTwo: Boolean): String = ???
def fncName(pOne: Int, pTwo: Boolean = false): Unit = ???
def fncName(otherFnc: (Int, String) => Boolean): Int = ???
```

## Collections

### List

```scala
val sampleList: List[Int] = List()
val sampleList = List[Int]()
val sampleList = List(1, 2, 3)
```

### Set

```scala
val sampleSet: Set[Int] = Set()
val sampleSet = Set[Int]()
val sampleSet = Set(1, 2, 3)
```

### Map

```scala
val sampleMap: Map[String, Int] = Map()
val sampleMap = Map[String, Int]()
val sampleMap = Map("hello" -> 1, "world" -> 2)
```

## Higher order functions

### `.filter`

Given a collection, keep only members that match a given condition.

```scala
collection.filter(paramName => boolCondition)

collection.filter(paramName => paramName.isDefined)
collection.filter(paramName => paramName.nonEmpty)
collection.filter(paramName => paramName.size > 5)
```

### `.map`

Given a collection, perform the same action to every member with a new member being produced from each action.

```scala
collection.map(paramName => actionProduceNewValue)
collection.map(paramName => {
	multiLineActionProduceNewValue
})

collection.map(paramName => paramName + 2)
collection.map(gamesThisSeason => {
	val currentGames = gamesThisSeason.gamesPlayed
	val lostGames = gamesThisSeason.gamesLost
	val wonGames = currentGames - lostGames
	val updatedSeason = gamesThisSeason.wonGames(wonGames)
	updatedSeason
})
collection.map(paramName => Some(paramName))
```

### `.flatMap`

Given a collection, perform the same action to every member with a new collection of members being producer from each action that are then flattened together.

```scala
collection.flatMap(paramName => actionProduceNewCollection)
collection.flatMap(paramName => {
	multiLineActionProduceNewCollection
})

val collection = Set(
	List(Game(teams = List("Team A", "Team B"))),
	List(
	Game(teams = List("Team B", "Team C")),
	Game(teams = List("Team A", "Team C"))
)
)
val result = collection.flatMap(listOfGames => {
	listOfGames.map(game => game.getTeams)
})
/* result:
Set(
	List("Team A", "Team B"),
	List("Team B," "Team C", "Team A", "Team C")
)
*/
```

### `.forEach`

Given a collection, perform the same action to every member with a Unit result.

```scala
collection.forEach(paramName => actionNoResult)
collection.forEach(paramName => println(paramName))
```

# Testing

## Running tests

From your project in the command line, use the following.

| command | what runs |
| ---------- | --------- |
| `sbt test` | All tests |
|  `sbt testQuick` | Changed/failed tests |
| `sbt "testOnly *NameTestClass*"` | Specific subset of tests |

## Types of tests

### [Feature test](http://doc.scalatest.org/3.0.1/#org.scalatest.FeatureSpec)

Think specification testing and TDD.

```scala
class (WhatTesting)Spec extends FeatureSpec {
	feature("Name of feature grouping") {
		spec("Name of test") {
			//test contents
		}
spec("Name of second test") {
			//test contents
		}
	}
	feature("Name of other feature grouping") {
		spec("Name of test") {
			//test contents
		}
	}
}
```

### [Functional test](http://doc.scalatest.org/3.0.1/#org.scalatest.FunSuite)

Think unit and stateless testing.

```scala
class (WhatTesting)Suite extends FunSuite {
	test("Name of test") {
		//test contents
	}
	ignore("Name of ignored test") {
		//test contents
	}
}
```

## Extensions to tests

### [Given/When/Then](http://doc.scalatest.org/3.0.1/#org.scalatest.GivenWhenThen)

I am going to highly recommend you always use given/when/then in your tests. It breaks the tests up into three logical parts and makes them super readable, plus is outputted onto the command line.

```scala
class (WhatTesting)Suite extends FunSuite with GivenWhenThen {
	test("Thing testing") {
		Given("the input/setup of this test")
		//input/setup
		
		When("I perform the action this test is about")
		//perform action
		
		Then("I have the output I expect")
		//output/assertions
		
		And("if there's more, I'll assert it here too")
		//if this makes sense for you
	}
}

```

### Before and after

#### [Each](http://doc.scalatest.org/3.0.1/#org.scalatest.BeforeAndAfterEach)

Runs before and after each test.

```scala
class (WhatTesting)Suite extends FunSuite with BeforeAndAfterEach {
	override def beforeEach() {
		//optional function
	}
    
	override def afterEach() {
		//optional function
	}
}

```

#### [All](http://doc.scalatest.org/3.0.1/#org.scalatest.BeforeAndAfterAll)

Runs before and after the class of tests.

```scala
class (WhatTesting)Suite extends FunSuite with BeforeAndAfterAll {
	override def beforeAll() {
		//optional function
	}
	
    override def beforeAll() {
		//optional function
	}
}
```

## Common helpers

### Assert

Assert conditions to pass/fail test.

```scala
assert(booleanStatement)
assert(booleanStatement, "Helper message if desired")
```

### **Assume**

Assert preconditions for test, eg the database connection exists and has been seeded. If this fails, the test will be cancelled because it cannot pass without its preconditions.

```scala
assume(booleanStatement)
assume(booleanStatement, "Helper message if desired")
```

### Info

Provides an info tag in the output.

```scala
info("Message")
```

### Note

Provides a note tag in the output.

```scala
note("Message")
```

