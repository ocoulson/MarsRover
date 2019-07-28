import org.scalatest.{FunSpec, Matchers}

class AutoPilotSpec extends FunSpec with Matchers {

  describe("An autopilot") {
    describe("When constructed with a grid builds a node map") {

      it("grid size 1, 1") {

        val grid = Grid(1,1)
        val rover = Rover(Point(0,0), North, grid, Nil)
        val pilot = new AutoPilot(rover)

        pilot.nodeMap shouldEqual Map(
          Point(0, 0) -> Neighbours(Point(0,1), Point(0,1), Point(1,0), Point(1,0)),
          Point(0, 1) -> Neighbours(Point(0,0), Point(0,0), Point(1,1), Point(1,1)),
          Point(1, 0) -> Neighbours(Point(1,1), Point(1,1), Point(0,0), Point(0,0)),
          Point(1, 1) -> Neighbours(Point(1,0), Point(1,0), Point(0,1), Point(0,1))
        )
      }

      it("grid size 2,2") {
        val grid = Grid(2,2)
        val rover = Rover(Point(0,0), North, grid, Nil)
        val pilot = new AutoPilot(rover)

        pilot.nodeMap shouldEqual Map(
          Point(0,0) -> Neighbours(Point(0,1),Point(0,2),Point(1,0),Point(2,0)),
          Point(0,1) -> Neighbours(Point(0,2),Point(0,0),Point(1,1),Point(2,1)),
          Point(1,0) -> Neighbours(Point(1,1),Point(1,2),Point(2,0),Point(0,0)),
          Point(1,1) -> Neighbours(Point(1,2),Point(1,0),Point(2,1),Point(0,1)),
          Point(0,2) -> Neighbours(Point(0,0),Point(0,1),Point(1,2),Point(2,2)),
          Point(2,0) -> Neighbours(Point(2,1),Point(2,2),Point(0,0),Point(1,0)),
          Point(1,2) -> Neighbours(Point(1,0),Point(1,1),Point(2,2),Point(0,2)),
          Point(2,1) -> Neighbours(Point(2,2),Point(2,0),Point(0,1),Point(1,1)),
          Point(2,2) -> Neighbours(Point(2,0),Point(2,1),Point(0,2),Point(1,2))
        )
      }
    }

    describe("findShortestPath") {

      it("Should return None if the destination point is not on the grid") {
        val grid = Grid(2,2)
        val rover = Rover(Point(0,0), North, grid, Nil)
        val autoPilot = new AutoPilot(rover)

        autoPilot.findShortestPath(Point(5,5)) shouldBe None
      }

      it("should return an empty list if the destination point is the current point") {
        val grid = Grid(2,2)
        val rover = Rover(Point(0,0), North, grid, Nil)
        val autoPilot = new AutoPilot(rover)

        autoPilot.findShortestPath(Point(0,0)) shouldBe Some(Nil)
      }
    }
  }
}
