package groupwork.examples

abstract class GraphObject(val id: String) {
  require(id.nonEmpty, { "Graph object id cannot be empty." } )
  
  private val signature = java.util.UUID.randomUUID.toString
  
  protected val createdAt = Temporal.now
  
  def asMap: Map[String, String] = Map("id" -> id)

  override def toString: String = s"Graph object $id"
}

class Node(id: String) extends GraphObject(id) {
  override def toString: String = s"Node $id"
}

class Edge(id: String, val source: String, val target: String) extends GraphObject(id) {
  require(source.nonEmpty, { "Source id cannot be empty." })
  require(target.nonEmpty, { "Target id cannot be empty." })
  
  override def asMap: Map[String, String] = super.asMap ++ Map("source" -> source, "target" -> target)

  override def toString: String = s"Edge $id from $source -> $target"
}

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
  
  def apply(
    id: String,
    source: Option[String],
    target: Option[String]
  ): GraphObject = apply(Some(id), source, target)
}
