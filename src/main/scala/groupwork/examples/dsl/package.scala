package groupwork.examples

package object dsl {
  private[dsl] def makeTemporal(graphObject: GraphObject): TemporalGraphObject = ???
  
  def isActive(graphObject: GraphObject): Option[Boolean] = graphObject match {
    case temporalGraphObject: TemporalGraphObject => Some(temporalGraphObject.isActive)
    case regularGraphObject => None
  }
}
