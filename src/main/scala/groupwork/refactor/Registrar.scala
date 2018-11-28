package groupwork.refactor

import scala.util.Try

object Registrar {
  private var cache: Map[String, Set[DomainObject]] = Map()
  
  def add(category: String, value: DomainObject): Try[Unit] = Try({
    cache ++ Map(category -> (cache.getOrElse(category, Set()) + value))
  })
  
  def get(category: String, name: String): Option[DomainObject] = cache
    .getOrElse(category, Set())
    .filter(domainObject => domainObject.name == name)
    .headOption
}
