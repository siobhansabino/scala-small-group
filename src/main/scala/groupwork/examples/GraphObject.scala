package groupwork.examples

import groupwork.examples.GraphObject._

/** Our sample class.
  * 
  * @param id Value kept around in the class.
  * @param signature Temp value only available in constructor.
  */
abstract class GraphObject(
  val id: String = java.util.UUID.randomUUID.toString,
  signature: String = defaultSignature
) {
  require(isValid(signature), { "Signature wasn't valid." } )

  val createdAt = generateTimestamp
  val createdBy = clientBy(signature)

  def aßMap: Map[String, String] = Map("id" -> id, "createdAt" -> createdAt, "createdBy" -> createdBy)

  override def toString: String = s"Graph object $id"
}

class Node(nid: String) extends GraphObject(nid) {
  override def toString: String = s"Node $id"
}

class Edge(eid: String, val source: String, val target: String) extends GraphObject(eid) {
  override def aßMap: Map[String, String] = super.aßMap ++ Map("source" -> source, "target" -> target)

  override def toString: String = s"Edge $id from $source -> $target"
}

object GraphObject {
  val defaultSignature: String = ""
  def isValid(sig: String): Boolean = true
  def generateTimestamp: String = ""
  def clientBy(sig: String): String = ""
}
