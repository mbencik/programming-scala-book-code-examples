// BEGIN DEFAULT
// src/script/scala/progscala3/implicits/ImplicitParameters.scala
import scala.language.implicitConversions
import math.Ordering

case class SortableSeq[A](seq: Seq[A]) {
  def sortBy1[B](transform: A => B)(implicit ord: Ordering[B]): Seq[A] =
    seq.sortBy(transform)(ord)

  def sortBy2[B : Ordering](transform: A => B): Seq[A] =
    seq.sortBy(transform)(implicitly[Ordering[B]])
}

val seq = SortableSeq(Seq(1,3,5,2,4))

assert(seq.sortBy1(i => -i) == Seq(5, 4, 3, 2, 1))
assert(seq.sortBy2(i => -i) == Seq(5, 4, 3, 2, 1))
// BEGIN DEFAULT
// BEGIN CUSTOM
implicit val EvenOdd: Ordering[Int] = new Ordering[Int] {
	def compare(i: Int, j: Int): Int = i%2 compare ((j+1)%2)
}

assert(seq.sortBy1(i => -i) == Seq(5, 3, 1, 2, 4))
assert(seq.sortBy2(i => -i) == Seq(5, 3, 1, 2, 4))
// END CUSTOM
