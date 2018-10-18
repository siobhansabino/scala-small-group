package groupwork

import groupwork.examples.{Edge, Node}

package object fsm {
  sealed trait FsmState
  
  object LockedState extends Node("locked state") with FsmState
  
  object LockedToUnlocked extends Edge("move from locked to unlocked", LockedState.id, UnlockedState.id)
  
  object UnlockedState extends Node("unlocked state") with FsmState
  
  object UnlockedToLocked extends Edge("move from unlocked to locked", UnlockedState.id, LockedState.id)
  
  //todo: make an example of using the turnstile
}
