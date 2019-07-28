import org.scalatest.{FunSpec, Matchers}

class RoverTest extends FunSpec with Matchers {

  describe("A rover") {

    val grid = Grid(3,3)
    val rover = Rover(Point(0,0), North, grid)
    it("should return the expected new Rover given a MoveForward instruction") {
      rover.issueInstruction(MoveForward) shouldEqual Rover(Point(0, 1), North, grid, List((Point(0,0), North, MoveForward)))
    }

    it("should return the expected new Rover given a RotateClockwise instruction") {
      rover.issueInstruction(RotateClockwise) shouldEqual
        Rover(Point(0, 0), East, grid, List((Point(0, 0), North, RotateClockwise)))
    }

    it("should return the expected new Rover given a RotateAntiClockwise instruction") {
      rover.issueInstruction(RotateAntiClockwise) shouldEqual
        Rover(Point(0, 0), West, grid, List((Point(0, 0), North, RotateAntiClockwise)))
    }

    it("should appear on the opposite side of the grid if it moves off the west ") {
      rover.issueInstruction(RotateAntiClockwise).issueInstruction(MoveForward) shouldEqual
        Rover(Point(3, 0), West, grid, List((Point(0, 0), North, RotateAntiClockwise), (Point(0, 0), West, MoveForward)))
    }

    it("should appear on the opposite side of the grid if it moves off the south") {
      rover.issueInstruction(RotateAntiClockwise).issueInstruction(RotateAntiClockwise).issueInstruction(MoveForward) shouldEqual
        Rover(Point(0, 3), South, grid, List(
          (Point(0, 0), North, RotateAntiClockwise),
          (Point(0, 0), West, RotateAntiClockwise),
          (Point(0, 0), South, MoveForward)))
    }

    it("should appear on the opposite side of the grid if it moves off the north"){
      val grid = Grid(2,2)
      val rover = Rover(Point(0,2), North, grid, List())

      rover.issueInstruction(MoveForward) shouldEqual
        Rover(Point(0,0), North, grid, List((Point(0,2), North, MoveForward)))
    }

    it("should appear on the opposite side of the grid if it moves off the east") {
      val grid = Grid(2,2)
      val rover = Rover(Point(2,2), East, grid, List())

      rover.issueInstruction(MoveForward) shouldEqual
        Rover(Point(0,2), East, grid, List((Point(2,2), East, MoveForward)))
    }


  }
}
