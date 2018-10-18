package groupwork.examples

case class Graph(members: Set[GraphObject], name: Option[String]) {
  def contains(that: GraphObject): Boolean = members.contains(that)
  
  def +(that: GraphObject): Graph = new Graph(this.members + that, name)
  
  def ++(that: Graph): Graph = new Graph(this.members ++ that.members, this.name.orElse(that.name))
}

object Graph {
  /*def apply(input: Option[Set[GraphObject]] = None): Graph = input match {
    case Some(graphObjects) => new Graph(graphObjects, None)
    case None => new Graph(Set(), None)
  }*/
  
  def unapply(graph: Graph): (Set[GraphObject], Option[String]) = (graph.members, graph.name)
}
