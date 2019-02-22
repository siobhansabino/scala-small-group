# Traits

## Because inheritance is overrated

- Traits
- Method overloading
- Operator override
- Composing with traits
- Traits in classes
- `lazy` values

## Traits

```scala
trait Temporal {
  def start: Option[Date]
  def end: Option[Date]
  
  def wasActive(point: Date): Boolean = ???
  
  def isActive: Boolean = wasActive(now)
}

object Temporal {
  type Date = Long
  
  def now: Date = Instant.now.getEpochSecond
}
```

## Method overloading

```scala
object GraphObject {
  def apply(
    id: Option[String] = None,
    source: Option[String] = None,
    target: Option[String] = None
  ): GraphObject
  
  def apply(
    id: String,
    source: Option[String],
    target: Option[String]
  ): GraphObject
}
```

## Operator override

```scala
case class Graph(members: Set[GraphObject], name: Option[String]) {
  def +(that: Graph): Graph = {
    val newName = this.name match {
      case Some(thisName) => thisName
      case None => that.name
    }
    new Graph(this.members ++ that.members, newName)
  }
}
```

## Composing with traits

```scala
//extend a class
class SampleSuite 
  extends FunSuite

//mix in a trait with no extended class
//  this is an edge case you have to remember
class SampleSuite 
  extends GivenWhenThen

//extend a class, mix in a trait
class SampleSuite 
  extends FunSuite 
  with GivenWhenThen 

//extend a class, mix in multiple traits
class SampleSuite 
  extends FunSuite 
  with GivenWhenThen 
  with BeforeAndAfter
```

## Traits in classes

```scala
abstract class TemporalGraphObject(
  id: String,
  val start: Option[Date],
  val end: Option[Date]
) extends GraphObject(id) with Temporal

class TemporalNode(id: String, start: Option[Date], end: Option[Date]) extends TemporalGraphObject(id, start, end)

class TemporalEdge(
  id: String,
  val source: String,
  val target: String,
  start: Option[Date],
  end: Option[Date]
) extends TemporalGraphObject(id, start, end)
```

## `lazy` values

```scala
trait Temporal {
  def start: Option[Date]
  def end: Option[Date]
  
  lazy val startStr = start match {
    case Some(startPoint) => "start: " + startPoint
    case None => "no start"
  }
  lazy val endStr = end match {
    case Some(endPoint) => "end: " + endPoint
    case None => "no end"
  }
}
```

## Exercise

- Finish `Temporal` trait’s `wasActive` function
- Override an operator in a class
- Write a test suite using several traits to assist you

