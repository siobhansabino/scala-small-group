package groupwork.examples.enumeration

/** 
  * 
  * @note Enumerations are supposedly going to be less dumb in Scala 3.
  */
object ActionEnumeration extends Enumeration {
  val insert = Value("insert")
  val update = Value("update")
  val delete = Value("delete")
  
  def get(action: String): Option[ActionEnumeration.Value] = {
    if (action == insert.toString) Some(insert)
    else if (action == update.toString) Some(update)
    else if (action == delete.toString) Some(delete)
    else None
  }
}
