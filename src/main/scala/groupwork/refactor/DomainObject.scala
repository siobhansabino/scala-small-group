package groupwork.refactor

trait DomainObject {
  def name: String = "no name"
  
  override def toString: String = name
}
