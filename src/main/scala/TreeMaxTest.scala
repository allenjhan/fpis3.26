object TreeMaxTest extends App {
  val myTree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))
  println(Tree.max(myTree))
}

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {
  def max(t: Tree[Int]): Int = t match {
    case Branch(left, right) => max(left) max max(right)
    case Leaf(v) => v
  }
}