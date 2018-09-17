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
    println("Map to triple all elements:")
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
    println("Map to triple all elements:")
    val setTriple = setBasic.map(element => element * 3)
    println(setTriple)
  }
  
  def mapsExample: Unit = {
    println("\n\n***\tMAP EXAMPLE\t***")
  
    println("\n\nBasic map creation")
    val mapBasic = Map(1 -> "one", 2 -> "four", 3 -> "nine", 4 -> "sixteen")
    println(mapBasic)
  
    println("\n\nStringifying maps")
    println(mapBasic.mkString(", "))
    println(mapBasic.map(tuple => tuple._1 + ": " + tuple._2).mkString(", "))
    println(mapBasic.mkString("[", ", ", "]"))
    println(mapBasic.map(tuple => tuple._1 + ": " + tuple._2).mkString("[", ", ", "]"))
  
    println("\n\nSet of tuples to map")
    println("A set of tuples where the first part of each tuple itself makes a set… is a map.")
    val setOfTuples = Set(
      (1, "one"),
      (2, "four"),
      (3, "nine"),
      (4, "sixteen")
    )
    println(setOfTuples)
    val mapFromList = setOfTuples.toMap
    println(mapFromList)
  
    println("\n\nBasic map information")
    println("Contains '2':\t" + mapBasic.contains(2))
    println("Contains '5':\t" + mapBasic.contains(5))
    println("Size:\t" + mapBasic.size)
    println("Is empty:\t" + mapBasic.isEmpty)
    println("Is non empty:\t" + mapBasic.nonEmpty)
    
    println("\n\nAdding and removing maps")
    val mapSquares = mapBasic
    println("Squares:\t" + mapSquares)
    val mapCubes = Map(1 -> "one", 2 -> "eight", 3 -> "twenty seven", 4 -> "sixty four")
    println("Cubes:\t" + mapCubes)
    val mapSquaresPlusCubes = mapSquares ++ mapCubes
    println("Squares plus cubes:\t" + mapSquaresPlusCubes)
    val mapCubesPlusSquares = mapCubes ++ mapSquares
    println("Cubes plus squares:\t" + mapCubesPlusSquares)
    
    println("\n\nTake and drop")
    println("Full:\t" + mapBasic)
    println("Take 1:\t" + mapBasic.take(1))
    println("Drop 1:\t" + mapBasic.drop(1))
    
    println("\n\nHigher order functions")
    println("Filter to keep only even keys:")
    val mapEvenKeys = mapBasic.filter(tuple => tuple._1 % 2 == 0)
    println(mapEvenKeys)
    println("Map to extend string of each value:")
    val mapExtended = mapBasic.map(element => {
      val (key, value) = element
      val newValue = value + " :tada:"
      (key, newValue)
    })
    println(mapExtended)
  }
  
  def forExample: Unit = println("\n\nfor: tbd") //todo
  
  def runAll: Unit = {
    listsExample
    setsExample
    mapsExample
    forExample
  }
}
