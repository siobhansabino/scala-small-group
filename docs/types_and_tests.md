# Types and tests

## Ttttt-today!

- Types

- - ADT
  - Variance
  - Type parameterization

- Tests

- - TDD
  - Property based testing

## Types

### ADT

>In computer programming, especially functional programming and type theory, an algebraic data type is a kind of composite type, i.e., a type formed by combining other types.
>
>Two common classes of algebraic types are product types (i.e., tuples and records) and sum types (i.e., tagged or disjoint unions or variant types).
>
>Values of algebraic types are analyzed with pattern matching, which identifies a value by its constructor or field names and extracts the data it contains.
>
>— [source](https://en.wikipedia.org/wiki/Algebraic_data_type)

#### In Scala terms

>Despite their fancy name, algebraic data types are just a way of modeling data in terms of two patterns:
>
>* **logical ors**, such as `List`, which is a `::` or `Nil`; and
>* **logical ands**, such as `::`, which has a `head` and a `tail`.
>
>In functional programming lingo we call the **logical or** a **sum type** and the **logical and** a **product type**.
>
>— [source](https://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html)

#### But like, what? Why?

- `List(A)`

- - `Value(a: A)`
  - `List(A)`
  - `Nil`

- `Either(A, B)`

- - `Left(a: A)`
  - `Right(b: B)`

- `Option(A)`

- - `Some(a: A)`
  - `None`

- `Try(A)`

- - `Success(a: A)`
  - `Failure(e: Exception)`

- constructor to build up

- - start with one piece
  - start with a nested self
  - start with “empty”

- pattern match to break down

- - am I at one piece?
  - am I at a nested self?
  - am I at “empty”?

#### But in Scala?

```scala
sealed abstract class List[+A]
final case class ::[B](
  override val head: B,
  private[scala] var tl: List[B]
) extends List[B]
case object Nil extends List[Nothing]

sealed abstract class Either[+A, +B]
final case class Left[+A, +B](value: A) extends Either[A, B]
final case class Right[+A, +B](value: B) extends Either[A, B]

sealed abstract class Option[+A]
final case class Some[+A](value: A) extends Option[A]
case object None extends Option[Nothing]

sealed abstract class Try[+T]
final case class Success[+T](value: T) extends Try[T]
final case class Failure[+T](exception: Throwable) extends Try[T]
```

### Allowing types to come later

- You have a `Wrapper[+A]`
- You have an instance that holds `GraphObjects`
- It can hold other things, it’s not *specific* to `GraphObjects`
- `Wrapper[+A]` is **parameterized** and has **variance**

#### Variance

- **Covariant**: can pass in children types of `A`; `Foo[+A]`

- **Contravariant**: can pass in parent types of `A`; `Foo[-A]`

- **Invariant**: can *only* pass in types of `A`; `Foo[A]`

- - Most Scala collections are invariant

#### Type parameterization

- Allow variable types using variance and bounds

- `def actOn[G <: GraphObject](input: Set[G]): Set[G]`

- - upper bound
  - `G` is a subtype of `GraphObject`

- `def actOn[E >: Edge](input: Set[E]): Set[E]`

- - lower bound
  - `E` is a supertype of `Edge`

- Can also reference contracts over implementations

- - `def sqlConnector: DbConnector with SqlContract`
  - Don’t care if `PsqlConnector` or `MysqlConnector`

## Tests

### TDD

- If output only depends on input

- - **Yo it’s so easy to test!**

- If your functions are pure

- - No state to set up
  - No mocks to inject

- If your types are clear

- - Write the function signature
  - Write the test
  - Implement the function using the test to guide you

### Property based testing

- Does your code behave oddly on the number `19348934`?

- - Are you sure about that?

- Exhaustively generating all useful test/edge cases is

- - Time consuming
  - Mind numbing
  - Not what you came here to do

- How do you know when you’ve covered “enough”?

- Math has rules and stuff, can’t you just leverage that?

- **Yes: property based testing**

#### In ScalaTest terms

>ScalaTest supports property-based testing, where **a property is a high-level specification of behavior that should hold for a range of data points**. […]
>
>The difference between a traditional test and a property is that **tests traditionally verify behavior based on specific data points checked by the test**. A test might pass three or four specific lists of different sizes to a method under test that takes a list, for example, and check the results are as expected. **A property, by contrast, would describe at a high level the preconditions of the method under test** and specify some aspect of the result that should hold no matter what valid list is passed.
>
>— [source](www.scalatest.org/user_guide/property_based_testing)

## Exercise

- Make a `Tree` ADT

- Make the framework of something to manipulate a `Tree`

- Use TDD to fill out your framework

- - Extra points for property based testing

