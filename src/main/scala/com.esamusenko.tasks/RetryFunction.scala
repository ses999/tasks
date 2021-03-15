package com.esamusenko.tasks

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object RetryFunction {

  /** *
   * Method that accepts a function and a number of attempts and throws exception if it cannot execute func successfully for numOfAttemps times
   *
   * @param numOfAttempts number of retry attempts
   * @param func          func that need to retry if previous executions were fail
   * @tparam T
   * @return result of function or throws last exception
   */
  @tailrec
  def retry[T](numOfAttempts: Int, func: => T): T = {
    require(numOfAttempts > 0, "numOfAttempt should be positive number")

    Try(func) match {
      case Success(value) => value
      case Failure(ex) if numOfAttempts == 1 => throw ex
      case _ => retry(numOfAttempts - 1, func)
    }
  }
}
