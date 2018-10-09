package groupwork

import org.scalatest.{BeforeAndAfter, FunSuite, GivenWhenThen}

class SortSamplerSuite extends FunSuite with GivenWhenThen with BeforeAndAfter {
  test("Bubble sort") {
    Given("unsorted input")
    val input: List[Int] = List(6, 5, 10, 9, 4, 3, 8, 7, 2, 1)
    
    When("I sort it")
    val output = SortSampler.bubble(input)
    
    Then("it's sorted!")
    val expected: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    assert(output == expected, "Womp womp doesn't sort, you have: " + output.mkString(", "))
  }
}
