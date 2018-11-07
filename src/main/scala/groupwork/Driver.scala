package groupwork

import groupwork.examples.CollectionOfCollections

import scala.util.Try

object Driver extends App {
  override def main(args: Array[String]): Unit = {
    /*val test = Set(1, 2, 3)
    
    test
        .filter(item => item %2 == 0)
        .map(item => {
          println()
          item - 1
        })
        .foreach(item => println(item))*/
    
    println("Hello world!")
  
    CollectionOfCollections.runAll
  } //todo: update with what have done in project
}
