package groupwork.refactor

import scala.util.Try

case class Movie(name: String, priceCode: MoviePriceCodes) extends DomainObject

object Movie {
  private val category = "Movies"
  
  def persist(movie: Movie): Try[Unit] = Registrar.add(category, movie)
  
  def get(name: String): Option[Movie] = Registrar.get(category, name) match {
    case result: Movie => Some(result)
    case _ => None
  }
}
