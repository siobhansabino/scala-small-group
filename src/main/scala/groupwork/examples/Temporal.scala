package groupwork.examples

import java.time.Instant
import groupwork.examples.Temporal.{Date, now}

trait Temporal {
  def start: Option[Date]
  def end: Option[Date]
  
  lazy val startStr = start match {
    case Some(startPoint) => "start: " + startPoint
    case None => "no start"
  }
  lazy val endStr = end match {
    case Some(endPoint) => "end: " + endPoint
    case None => "no end"
  }
  
  def wasActive(point: Date): Boolean = {
    require(point <= now, { "Cannot check if was active in the future." })
    ???
  }
  
  def isActive: Boolean = wasActive(now)
}

object Temporal {
  type Date = Long
  
  def now: Date = Instant.now.getEpochSecond
}
