# Classes continued

## Today we’ll crank it up to 11 by
- Auxiliary constructors
- Companion objects
- `apply` function
- Case class
- `match case` statement
- `unapply` function

## Where we left our class

```scala
abstract class GraphObject(val id: String) {
  require(id.nonEmpty, { "Graph object id cannot be empty." } )
  
  def asMap: Map[String, String] = Map("id" -> id)

  override def toString: String = s"Graph object $id"
}

class Node(id: String) extends GraphObject(id) {
  override def toString: String = s"Node $id"
}

class Edge(id: String, val source: String, val target: String) extends GraphObject(id) {
  override def asMap: Map[String, String] = super.asMap ++ Map("source" -> source, "target" -> target)

  override def toString: String = s"Edge $id from $source -> $target"
}
```

## Auxiliary constructors

```scala
class Edge(id: String, val source: String, val target: String) extends GraphObject(id) {
  def this(source: String, target: String) = this(java.util.UUID.randomUUID.toString, source, target)
  
  override def asMap: Map[String, String] = super.asMap ++ Map("source" -> source, "target" -> target)

  override def toString: String = s"Edge $id from $source -> $target"
}
```

## Companion objects

```scala
abstract class GraphObject(val id: String) {
  require(id.nonEmpty, { "Graph object id cannot be empty." } )
  
  def asMap: Map[String, String] = Map("id" -> id)

  override def toString: String = s"Graph object $id"
}

object GraphObject {
  
}
```

## `apply` function

```scala
object GraphObject {
  def apply(id: String): GraphObject = new Node(id)
  
  def apply(id: String, source: String, target: String): GraphObject = new Edge(id, source, target)
  
  /** Replaces auxiliary constructor. */
  def apply(source: String, target: String): GraphObject = new Edge(java.util.UUID.randomUUID.toString, source, target)
}
```

```scala
object GraphObject {
  def apply(
    id: Option[String] = None,
    source: Option[String] = None,
    target: Option[String] = None
  ): GraphObject = {
    val idSend = {
      if (id.isEmpty) java.util.UUID.randomUUID.toString else id.get
    }
    if (source.isDefined && target.isDefined) new Edge(idSend, source.get, target.get)
    else new Node(idSend)
  }
  def apply(
    id: String,
    source: Option[String],
    target: Option[String]
  ): GraphObject = apply(Some(id), source, target)
}
```

## Case class

```scala
case class Graph(members: Set[GraphObject], name: Option[String])
```

## `match case` statement

```scala
case class Graph(members: Set[GraphObject], name: Option[String])

object Graph {
  def apply(input: Option[Set[GraphObject]] = None): Graph = input match {
    case Some(graphObjects) => new Graph(graphObjects, None)
    case None => new Graph(Set(), None)
  }
  
  def describe(graph: Graph): String = graph match {
    case Graph(members, name) if name.isDefined => s"Graph ${graph.name.get} with ${members.size} members"
    case Graph(members, _) => s"Graph with no name and ${members.size} members"
  }
}
```

```scala
object GraphObject {
  def apply(
    id: Option[String] = None,
    source: Option[String] = None,
    target: Option[String] = None
  ): GraphObject = {
    val idSend = id match {
      case Some(idSent) => idSent
      case None => java.util.UUID.randomUUID.toString
    }
    
    if (source.isDefined && target.isDefined) new Edge(idSend, source.get, target.get)
    else new Node(idSend)
  }
}
```

## `unapply` function

```scala
case class Graph(members: Set[GraphObject], name: Option[String])

object Graph {
  def apply(input: Option[Set[GraphObject]] = None): Graph = input match {
    case Some(graphObjects) => new Graph(graphObjects, None)
    case None => new Graph(Set(), None)
  }
  
  def unapply(graph: Graph): (Set[GraphObject], Option[String]) = (graph.members, graph.name)
}
```

## Exercise

- Make a case class that takes in

- - A graph object
  - An action (create, update, delete)
  - An optional timestamp

- Make an apply function that

- - Takes in the above case class
  - Returns a graph
  - Prints out the timestamp if present
  - Prints out something different for each action