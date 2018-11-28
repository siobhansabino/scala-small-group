package groupwork.refactor

import scala.util.Try

case class Customer(name: String, rentals: List[Rental], frequentPoints: Int = 0) extends DomainObject {
  def add(rental: Rental): Customer = copy(rentals = rental :: rentals)
  
  lazy val statement: String = {
    /* todo
    for each rental, calculate individual cost as days rented * cost of rental type
    add a frequent renter point — need to store somewhere
    for each new release rented over one day, add a frequent renter point
    output amount owed and renter points
     */
    
    ??? //todo
  }
}

object Customer {
  private val category = "Customers"
  
  def persist(customer: Customer): Try[Unit] = Registrar.add(category, customer)
  
  def get(name: String): Option[Customer] = Registrar.get(category, name) match {
    case result: Customer => Some(result)
    case _ => None
  }
}
