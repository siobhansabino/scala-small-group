package groupwork.refactor

import scala.util.Try

case class Customer(name: String, rentals: List[Rental]) extends DomainObject {
  def add(rental: Rental): Customer = copy(rentals = rental :: rentals)
  
  lazy val statement: String = ??? //todo
}

object Customer {
  private val category = "Customers"
  
  def persist(customer: Customer): Try[Unit] = Registrar.add(category, customer)
  
  //todo: update customers since case class isn't mutable
  
  def get(name: String): Option[Customer] = Registrar.get(category, name) match {
    case result: Customer => Some(result)
    case _ => None
  }
}
