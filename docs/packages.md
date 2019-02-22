# Packages

## Pack it up

- Package object
- Package functions
- Public, protected, private, package private
- `require` statement
- Sealed class
- Object equality

## Package object

```scala
package object dsl {
  
}
```

## Package functions

```scala
package object dsl {
  def isActive(graphObject: GraphObject): Option[Boolean] = graphObject match {
    case temporalGraphObject: TemporalGraphObject => Some(temporalGraphObject.isActive)
    case regularGraphObject => None
  }
}
```

## Public, protected, private, package private
```scala
abstract class GraphObject(val id: String) {
  private val signature = java.util.UUID.randomUUID.toString
  
  protected val createdAt = Temporal.now
}

package object dsl {
  private[dsl] def makeTemporal(graphObject: GraphObject): TemporalGraphObject = ???
  
  def isActive(graphObject: GraphObject): Option[Boolean] = graphObject match {
    case temporalGraphObject: TemporalGraphObject => Some(temporalGraphObject.isActive)
    case regularGraphObject => None
  }
}
```

## `require` statement

```scala
abstract class GraphObject(val id: String) {
  require(id.nonEmpty, { "Graph object id cannot be empty." } )
}

class Edge(id: String, val source: String, val target: String) extends GraphObject(id) {
  require(source.nonEmpty, { "Source id cannot be empty." })
  require(target.nonEmpty, { "Target id cannot be empty." })
}

trait Temporal {
  def wasActive(point: Date): Boolean = {
    require(point <= now, { "Cannot check if was active in the future." })
    ???
  }
}
```

## Sealed class

```scala
sealed abstract class GraphObject(val id: String)

class Node(id: String) extends GraphObject(id)

class Edge(id: String, val source: String, val target: String) extends GraphObject(id)

//TemporalGraphObject can no longer live in its own file
```

## [Object equality](equality.md)

## Exercise

- Write object equality functions for a class
- Finish the definition for `dsl.isActive`
- Add in `require` and `private[package]` to your package

