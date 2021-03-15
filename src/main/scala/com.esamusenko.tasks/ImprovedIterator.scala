package com.esamusenko.tasks

/** * Class extending Iterator
 * which wraps another iterator
 * and also adds a peek() method
 *
 * @param innerIterator inner iterator on which we iterate
 * @tparam T
 */
class ImprovedIterator[T](innerIterator: Iterator[T]) extends Iterator[T] {

  var _next: Option[T] = None

  /**
   * Returns next element inner iterator
   * but does not advance its pointer
   *
   * @return
   */
  def peek(): T = {
    // if we have already got next element, we will get it,
    // otherwise we get next element from inner iterator
    _next match {
      case Some(value) => value
      case None => {
        _next = Some(innerIterator.next)
        _next.get
      }
    }
  }

  override def hasNext: Boolean = innerIterator.hasNext

  override def next(): T = {
    val ret = peek()
    //reset inner next element because we advance the pointer inside inner iterator
    _next = None
    ret
  }


}
