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
  
  def setsExample: Unit = {
    println("\n\n***\tSET EXAMPLE\t***")
    
    println("\n\nBasic set creation")
    val setBasic = Set(1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 8, 9, 7, 3, 2)
    println(setBasic)
  
    println("\n\nStringifying sets")
    println(setBasic.mkString(", "))
    println(setBasic.mkString("[", ", ", "]"))
    
    println("\n\nList to set")
    val listWithDuplicates = List(1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 8, 9, 7, 3, 2)
    println(listWithDuplicates)
    val setFromList = listWithDuplicates.toSet
    println(setFromList)
  
    println("\n\nBasic set information")
    println("Size:\t" + setBasic.size)
    println("Is empty:\t" + setBasic.isEmpty)
    println("Is non empty:\t" + setBasic.nonEmpty)
    
    println("\n\nAdding and removing sets")
    val setFruit = Set("apples", "oranges", "pears", "tomato")
    println("Fruit:\t" + setFruit)
    val setVeg = Set("cucumbers", "broccoli", "cabbage", "tomato")
    println("Veg:\t" + setVeg)
    val itemWeirdProduce = "tomato"
    println("Weird:\t" + itemWeirdProduce)
    val setAllProduce = setFruit ++ setVeg
    println("All produce:\t" + setAllProduce)
    val setAllNotWeirdProduce = setAllProduce - itemWeirdProduce
    println("All not weird produce:\t" + setAllNotWeirdProduce)
    val setCommonProduce = setFruit.intersect(setVeg)
    println("All common produce:\t" + setCommonProduce)
    val setNotCommonProduce = setFruit.diff(setVeg) ++ setVeg.diff(setFruit)
    println("All not common produce:\t" + setNotCommonProduce)
  
    println("\n\nTake and drop")
    println("Full:\t" + setAllProduce)
    println("Take 1:\t" + setAllProduce.take(1))
    println("Drop 1:\t" + setAllProduce.drop(1))
    
    println("\n\nHigher order functions")
    println("Filter to keep only even elements:")
    val setEven = setBasic.filter(element => element % 2 == 0)
    println(setEven)
    println("Map to triply all elements:")
    val setTriple = setBasic.map(element => element * 3)
    println(setTriple)
  }
  
  def mapsExample: Unit = println("\n\nmaps: tbd") //todo
  
  def forExample: Unit = println("\n\nfor: tbd") //todo
  
  def runAll: Unit = {
    listsExample
    setsExample
    mapsExample
    forExample
  }
}
