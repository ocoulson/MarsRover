class Grid(xMax: Int, yMax: Int) {

  def isOnGrid(point: Point): Boolean = {
    point.x <= xMax && point.x >= 0 &&
    point.y <= yMax && point.y >= 0
  }
}


case class Point(x: Int, y: Int)