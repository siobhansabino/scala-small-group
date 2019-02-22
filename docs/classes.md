# Classes

## Today’s abuse of the English language
- Basic class
- Constructor
- Default constructor values
- Member values
- Functions
- Abstract class
- Inheritance
- Override parent definition

## Basic class

```scala
/** Our sample class.
  */
class GraphObject {
  
}
```

## Constructor

```scala
/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
class GraphObject(val id: String, signature: String) {
  require(isValid(signature, { "Signature wasn't valid." } )
}
```

## Default constructor values

```scala
/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
class GraphObject(
  val id: String = java.util.UUID.randomUUID.toString,
  signature: String = defaultSignature
) {
  require(isValid(signature, { "Signature wasn't valid." } )
}
```

## Member values

```scala
/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
class GraphObject(
  val id: String = java.util.UUID.randomUUID.toString,
  signature: String = defaultSignature
) {
  require(isValid(signature, { "Signature wasn't valid." } )
  
  val createdAt = generateTimestamp
  val createdBy = clientBy(signature)
}
```

## Functions

```scala
/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
class GraphObject(
  val id: String = java.util.UUID.randomUUID.toString,
  signature: String = defaultSignature
) {
  require(isValid(signature, { "Signature wasn't valid." } )
  
  val createdAt = generateTimestamp
  val createdBy = clientBy(signature)
  
  def asMap: Map[String, String] = Map("id" -> id,  "createdAt" -> createdAt, "createdBy" -> createdBy)
  
  override def toString: String = s"Graph object $id"
}
```

## Abstract class

```scala
/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
abstract class GraphObject(
  val id: String,
  signature: String = defaultSignature
) {
  require(isValid(signature, { "Signature wasn't valid." } )
  
  val createdAt = generateTimestamp
  val createdBy = clientBy(signature)
  
  def asMap: Map[String, String] = Map("id" -> id,  "createdAt" -> createdAt, "createdBy" -> createdBy)
  
  override def toString: String = s"Graph object $id"
}
```

## Inheritance

```scala
abstract class GraphObject(
  val id: String,
  signature: String = defaultSignature
) {
  require(isValid(signature, { "Signature wasn't valid." } )
  
  val createdAt = generateTimestamp
  val createdBy = clientBy(signature)
  
  def asMap: Map[String, String] = Map("id" -> id,  "createdAt" -> createdAt, "createdBy" -> createdBy)
  
  override def toString: String = s"Graph object $id"
}

class Node(id: String) extends GraphObject(id)

class Edge(id: String, val source: String, val target: String) extends GraphObject(id)
```

## Override parent definition

```scala
abstract class GraphObject(
  val id: String,
  signature: String = defaultSignature
) {
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

