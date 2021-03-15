package com.esamusenko.tasks

class ImprovedIterator[T](innerIterator: Iterator[T]) extends Iterator[T] {

  var _next: Option[T] = None

  def peek(): T = _next match {
    case Some(value) => value
    case None => {
      _next = Some(innerIterator.next)
      _next.get //get for Option is bad practice, but here we sure that we get Some
    }
  }

  override def hasNext: Boolean = innerIterator.hasNext

  override def next(): T = {
    val ret = peek()
    _next = None
    ret
  }


}
