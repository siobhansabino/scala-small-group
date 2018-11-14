package groupwork.refactor

sealed trait MoviePriceCodes {
  def value: Double
}

case object Childrens extends MoviePriceCodes {
  val value = 1.5
}

case object Regular extends MoviePriceCodes {
  val value = 2
}

case object NewRelease extends MoviePriceCodes {
  val value = 3
}
