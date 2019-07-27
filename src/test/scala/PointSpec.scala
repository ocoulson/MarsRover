import org.scalatest.{FunSpec, Matchers}

class PointSpec extends FunSpec with Matchers{

  describe("A point") {
    val grid = Grid(3,3)
    it("isOnGrid determines if the point is on a specified grid") {
      Point(1,2).isOnGrid(grid) shouldEqual true

      Point(4,3).isOnGrid(grid) shouldEqual false
    }
  }

}
