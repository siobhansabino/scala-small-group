package groupwork.examples.caseobjects

trait ActionObject {
  val name: String
}

case object insert extends ActionObject {
  val name = "insert"
}

case object update extends ActionObject {
  val name = "update"
}

case object delete extends ActionObject {
  val name = "delete"
}

object ActionObject {
  def get(action: String): Option[ActionObject] = {
    if (action == insert.name) Some(insert)
    else if (action == update.name) Some(update)
    else if (action == delete.name) Some(delete)
    else None
  }
}
