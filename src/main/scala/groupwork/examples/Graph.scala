package groupwork.examples

case class Graph(members: Set[GraphObject], name: Option[String]) {
  def +(that: Graph): Graph = {
    val newName = this.name match {
      case Some(thisName) => thisName
      case None => that.name.get
    }
    new Graph(this.members ++ that.members, newName)
  }
}

object Graph {
  def apply(input: Option[Set[GraphObject]] = None): Graph = input match {
    case Some(graphObjects) => new Graph(graphObjects, None)
    case None => new Graph(Set(), None)
  }
  
  def unapply(graph: Graph): (Set[GraphObject], Option[String]) = (graph.members, graph.name)
}
