package com.esamusenko.tasks

import org.scalatest.{FunSuite, Matchers}

class RetryFunctionSpec extends FunSuite with Matchers {
  test("should execute func") {
    var cnt = 0
    val res = RetryFunction.retry(5, {
      if (cnt < 2) {
        cnt += 1
        throw new TestException
      }
      else cnt
    })

    res shouldBe cnt
  }

  test("should throw exception if func failed after numOfAttempts times") {
    an[TestException] should be thrownBy RetryFunction.retry(5, throw new TestException)
  }

  test("should throw IllegalArgumentException if numOfAttempts is not positive") {
    an[IllegalArgumentException] should be thrownBy RetryFunction.retry(0, () => 100)
  }
}

case class TestException() extends Exception