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

  case class Node(point: Point, distance: Int)

  /**
    * Start to implement Djikstras algorithm for finding the shortest path,
    * 1) Keep lists of visited and unvisited nodes - set all nodes to unvisited
    * 2) Keep map of nodes to 'tentative distance' - distance in this case I'll consider to be number of instructions
    * 3) Set all initial distances to MaxValue of Int, current node set to 0
    *
    * 4) Visit current node - Look at neighbours of current node, considering current facing determine number of instructions to
    *   get to each (1 for directly ahead, 2 for the ones to left / right, 3 for behind)
    * 5) In the map of nodes to paths, if the path from the current node to each neighbour is less than the distance
    *   already in there, replace it in the map with the shorter one, or just leave the existing value
    * 6) move current node to visited set
    * 7) if destination is now visited, end algorithm, return map value for destination point
    * 8) otherwise visit the unvisited node with the smallest 'tentative distance' and visit it
    */

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
