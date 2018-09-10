package groupwork.exercises

/** Class problem
  *
  * Write me classes to represent the following objects. You may do this in whatever way you like.
  *
  * 1. A graph is made of nodes and edges.
  * 1. Nodes and edges have ids and maybe the date created (which can be stored as a string or an epoch, your choice).
  * 1. Edges also have a source and target id.
  * 1. Nodes might have properties which can be represented in a map with string keys and unknown value types.
  */

class Graph(val members: Set[GraphObject]) {
  def add(member: GraphObject): Graph = new Graph(members + member)
}

abstract class GraphObject(val id: String, val date: Option[String])

class Node(
  id: String,
  date: Option[String] = None,
  val properties: Map[String, Any] = Map()
) extends GraphObject(id, date)

class Edge(
  id: String,
  val source: String,
  val target: String,
  date: Option[String] = None
) extends GraphObject(id, date)

/*
Option[String] is either Some(stringValue) or None
date = None
date = Some(now)
 */
