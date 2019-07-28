class AutoPilot(rover: Rover) {

  val nodeMap: Map[Point, Neighbours] = generateNodeMap(rover.grid)

  private def generateNodeMap(grid: Grid): Map[Point, Neighbours] = {
    grid.getAllPoints.map(
      point => point -> getNeighbours(point)
    ).toMap
  }

  private def getNeighbours(point: Point): Neighbours = {
    val north = getNewPoint(point.x, point.y + 1)
    val south = getNewPoint(point.x, point.y - 1)
    val east = getNewPoint(point.x + 1, point.y)
    val west = getNewPoint(point.x - 1, point.y)
    Neighbours(north,south,east,west)
  }

  private def getNewPoint(x: Int, y: Int): Point = {
    if(x < 0) Point(rover.grid.xMax, y)
    else if (x > rover.grid.xMax) Point(x = 0, y)
    else if (y < 0) Point(x, rover.grid.yMax)
    else if (y > rover.grid.yMax) Point(x, y = 0)
    else Point(x,y)
  }

  def findShortestPath(destination: Point): Option[List[Instruction]] = {
    if (!destination.isOnGrid(rover.grid)) None
    else if (destination == rover.currentPosition) Some(List())
    else {
      None
//      val unvisited = nodeMap.keySet.filterNot(_ == rover.currentPosition)
//      findPath(
//        rover.currentPosition,
//        rover.currentFacing,
//        destination,
//        unvisited,
//        Set(rover.currentPosition),
//        unvisited.map(point => point -> ShortestPath(Int.MaxValue, Nil)).toMap ++
//          Map(rover.currentPosition -> ShortestPath(0, Nil))
//      )
    }
  }

  // Implement Djikstra's algorithm as described in README

  case class ShortestPath(count: Int, instructions: List[Instruction])

  def findPath(currentPosition: Point,
               currentFacing: Direction,
               destination: Point,
               unvisited: Set[Point],
               visited: Set[Point],
               paths: Map[Point, ShortestPath]): List[Instruction] = {
    if (visited.contains(destination)) {
      paths(destination).instructions
    } else {
      val neighbours = nodeMap(rover.currentPosition)
      val unvisitedNeighbours = neighbours.all.values.filter(unvisited)
      Nil
    }
  }


}
