case class Neighbours(private val north: Point, south: Point, east: Point, west: Point) {
  def all: Map[Direction, Point] = Map(
    North -> north,
    South -> south,
    East -> east,
    West -> west)
}

