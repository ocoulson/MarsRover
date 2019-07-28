class AutoPilot(grid: Grid) {

  val nodeMap: Map[Point, Set[Point]] = generateNodeMap(grid: Grid)

  private def generateNodeMap(grid: Grid): Map[Point, Set[Point]] = {
    grid.getAllPoints.map(
      point =>
        point -> getNeigbours(point)
    ).toMap
  }

  private def getNeigbours(point: Point): Set[Point] = {
    val north = point.copy(y = point.y + 1)
    val south = point.copy(y = point.y - 1)
    val east = point.copy(x = point.x + 1)
    val west = point.copy(x = point.x - 1)
    Set(north,south,east,west).map(
      point => {
        if(point.x < 0) point.copy(x = grid.xMax)
        else if (point.x > grid.xMax) point.copy(x = 0)
        else if (point.y < 0) point.copy(y = grid.yMax)
        else if (point.y > grid.yMax) point.copy(y = 0)
        else point
      }
    )
  }
}
