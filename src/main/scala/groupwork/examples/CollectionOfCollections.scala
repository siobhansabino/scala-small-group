package groupwork.examples

object CollectionOfCollections {
  def listsExample: Unit = {
    println("\n\n***\tLIST EXAMPLE\t***")
    
    println("\n\nBasic list creation")
    val listBasic = List(1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 8, 9, 7, 3, 2)
    println(listBasic)
    
    println("\n\nStringifying lists")
    println(listBasic.mkString(", "))
    println(listBasic.mkString("[", " :: ", "]"))
    
    println("\n\nBasic list information")
    println("Head:\t" + listBasic.head)
    println("Tail:\t" + listBasic.tail)
    println("Size:\t" + listBasic.size)
    println("Is empty:\t" + listBasic.isEmpty)
    println("Is non empty:\t" + listBasic.nonEmpty)
    
    println("\n\nReverse! Reverse!")
    val listReverse = listBasic.reverse
    println(listReverse)
    
    println("\n\nCrazy list creation")
    println("Because `::` ends in a colon, it associates to the right rather than the left apparently.")
    val listFruit = "apples" :: "oranges" :: "pears" :: Nil
    println(listFruit)
    
    println("\n\nConcat two lists")
    val listVeg = List("cucumbers", "broccoli", "cabbage")
    println(listFruit + " + " + listVeg)
    val listFood = listFruit ::: listVeg
    println(listFood)
    
    println("\n\nTake and drop")
    println("Full:\t" + listFood)
    println("Take 1:\t" + listFood.take(1))
    println("Drop 1:\t" + listFood.drop(1))
    
    println("\n\nHigher order functions")
    println("Filter to keep only even elements:")
    val listEven = listBasic.filter(element => element % 2 == 0)
    println(listEven)
    println("Map to triply all elements:")
    val listTriple = listBasic.map(element => element * 3)
    println(listTriple)
  }
  
  def setsExample: Unit = println("\n\nsets: tbd") //todo
  
  def mapsExample: Unit = println("\n\nmaps: tbd") //todo
  
  def forExample: Unit = println("\n\nfor: tbd") //todo
  
  def runAll: Unit = {
    listsExample
    setsExample
    mapsExample
    forExample
  }
}
