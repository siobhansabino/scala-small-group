# Functions vs methods

## Vaguely more academic topics will go over today

- What is state?
- What is a side effect?
- What is a method?
- What is a function?
- What is a first class function?
- What is a higher order function?

## What is state?

- State refers to the remembering of data

- If something is stateful, it has state

- - Imperative programming: program state

  - ```scala
    var avg = 0
    def average(input: List[Int]): Unit = {
        avg = input.sum / input.size
    }
    ```

- If something is stateless, it has no state

- - Declarative programming: result of expression

  - ```scala
    def average(input: List[Int]): Int = input.sum / input.size
    ```

## What is a side effect?

- Two distinct types

- - Changes in state outside scope

  - ```scala
    var avg = 0
    def average(input: List[Int]): Unit = {
        avg = input.sum / input.size
    }
    ```

- - Observable interactions with caller/outside world

  - ```scala
    user.pushNotification(numGamesPlayed, now)
    ```

- If there is a `Unit` return type, most likely has side effects

## What is a method?

- Uses state for input or output

- - May have side effects

  - ```scala
    var input: List[Int] = List(1, 2, 3)
    var avg = 0
    def average(): Unit = {
        avg = input.sum / input.size
    }
    ```

## What is a function?

- Function: output depends only on input

- - No side effects
  - Evaluation of an expression

```scala
def average(input: List[Int]): Int = input.sum / input.size
```

## What is a first class function?

- *First class citizenship* means an entity supports all operations generally available to other entities

- - Typically this means it can be

  - - Passed as an argument
    - Returned from a function or method
    - Assigned to a variable

- Entities can be values, collections, objects, etc

- - Functional programming has first class functions

## What is a higher order function?

- Function that either

- - Takes in one or more functions as arguments

    - ```scala
      def countTeams(isTeamWant: (Team) => Boolean): Int = teams
          .filter(team => isTeamWant(team))
          .size
      ```

- - Returns a function as its result

    - ```scala
      def successfulTeams = (team: Team) => {
          team.gamesScored > 5
      }
      ```

- A function that isn’t higher order is first order

## Some practical things

### Nesting functions

```scala
def mainFnc(input: List[String]): List[String] = {
    def helperFnc(member: String): String = ???
    
    input
        .filter(member => member.nonEmpty)
        .map(member => helperFnc(member))
}
```

### Default values

```scala
def complexFnc(
    input: List[String],
    keep: (String) => Boolean,
    minLength: Option[Int] = None,
    beStrict: Boolean = false
): List[String] = ???
```

### Named arguments

```scala
def complexFnc(
    input: List[String],
    keep: (String) => Boolean,
    minLength: Option[Int] = None,
    beStrict: Boolean = false
): List[String] = ???

complexFnc(sampleInput, keepFnc, beStrict = true)
```

## And before we get too far

### Writing tests

- [Use testing cheat sheet](cheat_sheet.md#testing)

- Leverage to help you develop as you work

- - Confirm your function meets your expectations

  - - Functional suite

  - Get down what you want to accomplish with your code

  - - Feature specification

- If what you’re writing is stateless, immutable, and side effect free

- - Then testing is just given inputs, do I get these outputs?

### Documenting code with Scaladocs

- Get in the habit of writing [Scaladocs](https://docs.scala-lang.org/style/scaladoc.html) for yourself

- - Especially as you begin, it helps you think through

- Best things to document

- - What a package does (use the package object)
  - What a class/object/trait represents
  - Custom data structures
  - Is this a function or method? What does it accomplish?

- Use `@note` to mark side effects

- - It will annoy you thus helping you avoid side effects

