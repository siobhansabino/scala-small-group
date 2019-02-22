# General references

- [*Programming in Scala*](https://www.artima.com/pins1ed/) (aka The Big Book), first edition
- [Scala exercises](https://www.scala-exercises.org/)
- [Scala tutorials](http://allaboutscala.com/)

# Week 1: Introduction

## Set up your machine and project

### Prework

1. [Download and install IntelliJ.](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)

2. Install the Scala plugin.

3. Set up the IDE to your heart's content.

4. [Download and install sbt.](https://www.scala-sbt.org/download.html)

5. Create a Scala project in IntelliJ using sbt.

6. - You'll want to make sure you pick `Scala` then `sbt` as your options, not `Java` then `Scala`.

6. In your terminal, navigate into the project and run `sbt name`  to make sure sbt is working.

### Together

1. In your project, install:

2. 1. [ScalaTest](http://www.scalatest.org/install) for testing
   2. [Scoverage](https://github.com/scoverage/sbt-scoverage#how-to-use) for testing coverage
   3. [Scalastyle](http://www.scalastyle.org/sbt.html) for linting

2. Use [provided linting file](../scalastyle-config.xml).

Over the course of the class, you'll develop your own opinions so are welcome to tweak what we start with, but the provided linting file will help to ensure you don't do Very Dangerous Things and that you are strict in formatting from the start so you get used to what you're looking at.

## Writing your first Scala

1. Create the package you'll use.
2. Create [`Hello world` driver file](http://helloworldcollection.de/#Scala).

## Jump into the deep end

- `???` syntax for incomplete definitions
- `val` for immutable values
- `println`
- tuple
- `if` statements
- function
- `List`
- `Set`
- `Map`
- `.filter`
- `.map`
- `.flatMap`
- `.forEach`

## Material

* [Syntax cheat sheet](cheat_sheet.md#syntax)
* [Testing cheat sheet](cheat_sheet.md#testing)

## Reading

* [Scala introduction](https://docs.scala-lang.org/tour/tour-of-scala.html)

## Exercise

* [Scala basics](https://docs.scala-lang.org/tour/basics.html)

# Week 2: Functions vs methods

- What is state?
- What is a side effect?
- What is a method?
- What is a function?
- What is a first class function?
- What is a higher order function?
- Nesting functions
- Default values
- Named arguments
- Writing tests
- Documenting code with Scaladocs

## Material

* [Slides](functions.md)

## Reading

- [Higher order functions](https://docs.scala-lang.org/tour/higher-order-functions.html)
- [Nested functions](https://docs.scala-lang.org/tour/nested-functions.html)
- [By-name parameters](https://docs.scala-lang.org/tour/by-name-parameters.html)
- [Scaladocs](https://docs.scala-lang.org/style/scaladoc.html)

# Summer homework

- [Play with Scala school](https://twitter.github.io/scala_school/)
- [Read through Effective Scala](https://twitter.github.io/effectivescala/)
- [Try your hand at some exercises](https://www.scala-exercises.org/scala_tutorial/terms_and_types)
- Draft what you'd like to build using Scala over this course

# Week 3: Classes

- Basic class
- Constructor
- Default constructor values
- Member values
- Functions
- Abstract class
- Inheritance
- Override parent definition

## Material

* [Slides](classes.md)

## Reading

* [Classes basics](https://docs.scala-lang.org/tour/classes.html)

# Week 4: Classes continued

- Auxiliary constructors
- Companion objects
- `apply` function
- Case class
- `match case` statement
- `unapply`  function

## Material

* [Slides](classes_continued.md)

## Reading

- [Case classes basics](https://docs.scala-lang.org/tour/case-classes.html)
- [Pattern matching basics](https://docs.scala-lang.org/tour/pattern-matching.html)
- [Singleton object basics](https://docs.scala-lang.org/tour/singleton-objects.html)
- [Extractor objects](https://docs.scala-lang.org/tour/extractor-objects.html)
- [Generic classes](https://docs.scala-lang.org/tour/generic-classes.html)

# Week 5: Collections

- Lists
- Sets
- Maps
- `for` loops

## Material

* [Code](https://github.com/siobhansabino/scala-small-group/blob/master/src/main/scala/groupwork/examples/CollectionOfCollections.scala)

## Reading

* [For comprehension basics](https://docs.scala-lang.org/tour/for-comprehensions.html)

# Week 6: Traits

- Traits
- Method overloading
- Operator override
- Composing with traits
- Traits in classes
- `lazy` values

## Material

* [Slides](traits.md)

## Reading

- [Trait basics](https://docs.scala-lang.org/tour/traits.html)
- [Class composition](https://docs.scala-lang.org/tour/mixin-class-composition.html)
- [Here There Be Dragons - Dangers of Initialization Order in Scala](https://www.tapad.com/news/engineering-blog/here-there-be-dragons-dangers-of-initialization-order-in-scala)
- [Operators](https://docs.scala-lang.org/tour/operators.html)

# Week 7: Packages

- Package object
- Package functions
- Public, protected, private, package private
- `require` statement
- Sealed class
- Object equality

## Material

* [Slides](packages.md)
* [Equality howto writeup](equality.md)

# Week 8: Types and tests

## Types

- What are ADT?

- - Either
  - Option
  - Try

- Variance

- Type parameterization

## Testing

- TDD
- Property based testing

## Material

- [Slides](types_and_tests.md)
- [Scala type tree](https://docs.scala-lang.org/resources/images/tour/unified-types-diagram.svg)
- [Testing cheat sheet](https://docs.google.com/document/d/1iWqknpkYGNqxeWKC5bsTQWIZYWOvJ5zGgfpnrE47Gqw/edit?usp=sharing)
- [Property based testing in ScalaTest](http://www.scalatest.org/user_guide/property_based_testing)
- [ScalaCheck](https://www.scalacheck.org/)

## Reading

- [Unified types](https://docs.scala-lang.org/tour/unified-types.html)
- [Everything You Ever Wanted to Know About Sealed Traits in Scala](https://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html)
- [Demystifying the Monad in Scala](https://medium.com/@sinisalouc/demystifying-the-monad-in-scala-cc716bb6f534)
- [Variances](https://docs.scala-lang.org/tour/variances.html)
- [Upper type bounds](https://docs.scala-lang.org/tour/upper-type-bounds.html)
- [Lower type bounds](https://docs.scala-lang.org/tour/lower-type-bounds.html)
- [Abstract types](https://docs.scala-lang.org/tour/abstract-types.html)
- [Compound types](https://docs.scala-lang.org/tour/compound-types.html)
- [Kinds of types in Scala, part 1: types, what are they?](https://kubuszok.com/2018/kinds-of-types-in-scala-part-1/)
- [Kinds of types in Scala, part 2: take type, return type or type parameters](https://kubuszok.com/2018/kinds-of-types-in-scala-part-2/)

# Week 9: Refactor

* Refactor provided Java code using what you've learned

## Material

* [Imperative, mutable OO Java code](https://github.com/siobhansabino/scala-small-group/tree/master/src/main/java/groupwork)

# Week 10: More on functions

- Closure
- Partially applied
- Currying
- Interchanging `val` and `def` definitions
- Renaming imports
- Make a factory

## Material

* [Slides](functions_more.md)

## Reading

- [Currying](https://docs.scala-lang.org/tour/multiple-parameter-lists.html)
- [Polymorphic methods](https://docs.scala-lang.org/tour/polymorphic-methods.html)

# Week 11: Grab bag of fun

- Enumerations

- Case objects

- Common traits

- - Traversable
  - Orderable
  - Iterable
  - Seq

## Material

- [Sample enumerations code](https://github.com/siobhansabino/scala-small-group/tree/master/src/main/scala/groupwork/examples/enumeration)

- [Sample case objects code](https://github.com/siobhansabino/scala-small-group/tree/master/src/main/scala/groupwork/examples/caseobjects)

- [Common traits writeup](https://github.com/siobhansabino/scala-small-group/blob/master/docs/common_traits.md)

- Scala tutorials

- - [Immutable collections](http://allaboutscala.com/#chapter-6-immutable-collection)
  - [Collection functions](http://allaboutscala.com/#chapter-8-collection-functions)

## Reading

* [Difference between case class and case object?](https://stackoverflow.com/questions/32078526/difference-between-case-class-and-case-object)

# Week 12: Combinator parsing

- Combinator parsing

- - Arithmetic expressions
  - (Known) JSON

## Material

- [Combinator parsing in the first edition of The Big Book](https://www.artima.com/pins1ed/combinator-parsing.html)
- [Reference GitHub repo](https://github.com/scala/scala-parser-combinators)
- [Scala exercises/Property testing](https://www.scala-exercises.org/scalacheck/properties)

# Week 13: Functional programming deep dive

## Material

- [Scala exercises/FP in Scala](https://www.scala-exercises.org/fp_in_scala/getting_started_with_functional_programming)

- [Scala tutorials/Futures](http://allaboutscala.com/#chapter-9-futures)

- [scalaz](https://github.com/scalaz/scalaz)

- [Cats Effect — Scala IO monad](https://typelevel.org/cats-effect/)

- - [Diagrams with cats](https://typelevel.org/cats-effect/concurrency/basics.html)

- Tagless Final

- - [blog post about](https://typelevel.org/blog/2017/12/27/optimizing-final-tagless.html)
  - [talk and code about](https://github.com/LukaJCB/tagless-webgl)

# Week 14: Show off and certifications

- Medina's Monad Masterclass
- Final thoughts, questions, comments, heckles
- Certificate ceremony

## Material

* [Certificates](certificates.key)

