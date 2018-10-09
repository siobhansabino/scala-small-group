package groupwork.examples

import groupwork.examples.Temporal.Date

abstract class TemporalGraphObject(
  id: String,
  val start: Option[Date],
  val end: Option[Date]
) extends GraphObject(id) with Temporal {
  override def asMap: Map[String, String] = super.asMap ++ Map("start" -> startStr, "end" -> endStr)
  
  override def toString: String = s"Temporal graph object $id from $start to $end"
}

class TemporalNode(id: String, start: Option[Date], end: Option[Date]) extends TemporalGraphObject(id, start, end) {
  override def toString: String = s"Temporal node $id from $start to $end"
}

class TemporalEdge(
  id: String,
  val source: String,
  val target: String,
  start: Option[Date],
  end: Option[Date]
) extends TemporalGraphObject(id, start, end) {
  override def asMap: Map[String, String] = super.asMap ++ Map("source" -> source, "target" -> target)
  
  override def toString: String = s"Temporal edge $id from $source -> $target from $start to $end"
}
