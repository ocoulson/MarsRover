case class Grid(xMax: Int, yMax: Int) {
  def getAllPoints: Set[Point] = {
    for {
      x <- 0 to xMax
      y <- 0 to yMax
    } yield Point(x, y)
  }.toSet
}


case class Point(x: Int, y: Int) {
  def isOnGrid(grid: Grid): Boolean =
    x.isBetween(0, grid.xMax) && y.isBetween(0, grid.yMax)

  implicit class Between(target: Int) {
    def isBetween(min: Int, max: Int): Boolean = target <= max && target >= min
  }
}