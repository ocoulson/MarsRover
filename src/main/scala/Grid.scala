case class Grid(xMax: Int, yMax: Int)


case class Point(x: Int, y: Int) {
  def isOnGrid(grid: Grid): Boolean = {
    x <= grid.xMax && x >= 0 &&
      y <= grid.yMax && y >= 0
  }
}