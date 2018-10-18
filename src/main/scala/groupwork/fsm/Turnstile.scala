package groupwork.fsm

import groupwork.examples.{Graph, GraphObject}
import groupwork.fsm.Turnstile._
import scala.util.{Failure, Success, Try}

class Turnstile(startingState: FsmState = startState) {
  require(allStates.contains(startingState))
  
  private var currentState = startingState
  
  private def toggleState: Unit = currentState match {
    case LockedState => currentState = UnlockedState
    case UnlockedState => currentState = LockedState
  }
  
  def insertCoin: Try[Unit] = currentState match {
    case LockedState => Success(toggleState)
    case UnlockedState => Failure(throw new IllegalStateException("I have eaten your coin. I am a coin monster."))
  }
  
  def enter: Try[Unit] = currentState match {
    case LockedState => Failure(throw new IllegalStateException("Whoa buddy, you need to pay there first."))
    case UnlockedState => Success(toggleState)
  }
  
  def current: FsmState = currentState
}

object Turnstile {
  val allStates = Graph(
    Set(LockedState, UnlockedState, LockedToUnlocked, UnlockedToLocked),
    name = Some("Turnstile FSM")
  )
  val startState = LockedState
}
