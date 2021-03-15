package com.esamusenko.tasks

import org.scalatest.{FunSuite, Matchers}

class ImprovedIteratorSpec extends FunSuite with Matchers {

  test("should not advance the pointer") {
    val list = (1 to 100).toIterator
    val improvedIterator = new ImprovedIterator(list)
    improvedIterator.peek shouldBe improvedIterator.peek
  }

  test("peek should return the same value as next") {
    val list = (1 to 100).toIterator
    val improvedIterator = new ImprovedIterator(list)
    while (improvedIterator.hasNext)
      improvedIterator.peek shouldBe improvedIterator.next
  }

  test("should throw exception when iterator ends") {
    val list = (1 to 10).toIterator
    val improvedIterator = new ImprovedIterator(list)

    an[NoSuchElementException] should be thrownBy {
      while (true) {
        improvedIterator.next
      }
    }
  }
}
