import org.scalatest.{FunSpec, Matchers}

class AutoPilotSpec extends FunSpec with Matchers {

  describe("An autopilot") {
    describe("When constructed with a grid builds a node map") {

      it("grid size 1, 1") {

        val grid = Grid(1,1)
        val pilot = new AutoPilot(grid)

        pilot.nodeMap shouldEqual Map(
          Point(0, 0) -> Set(Point(0,1), Point(1,0)),
          Point(0, 1) -> Set(Point(0,0), Point(1,1)),
          Point(1, 0) -> Set(Point(0,0), Point(1,1)),
          Point(1, 1) -> Set(Point(0,1), Point(1,0))
        )
      }

      it("grid size 2,2") {
        val grid = Grid(2,2)
        val pilot = new AutoPilot(grid)

        pilot.nodeMap shouldEqual Map(
          Point(0, 0) -> Set(Point(0, 1), Point(1, 0), Point(0, 2), Point(2, 0)),
          Point(0, 1) -> Set(Point(0, 0), Point(1, 1), Point(0, 2), Point(2, 1)),
          Point(1, 0) -> Set(Point(0,0), Point(1,1), Point(2,0), Point(1,2)),
          Point(1,1) -> Set(Point(0,1), Point(1,0), Point(1,2), Point(2,1)),
          Point(0,2) -> Set(Point(0,1), Point(1,2), Point(0,0), Point(2,2)),
          Point(2,0) -> Set(Point(1,0), Point(2,1), Point(0,0), Point(2,2)),
          Point(2,1) -> Set(Point(1,1), Point(2,2), Point(2,0), Point(0,1)),
          Point(1,2) -> Set(Point(1,1), Point(2,2), Point(0,2), Point(1,0)),
          Point(2,2) -> Set(Point(1,2), Point(2,1), Point(2,0), Point(0,2))
        )
      }

    }
  }
}
