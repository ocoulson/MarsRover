import org.scalatest.{FunSpec, Matchers}

class GridSpec extends FunSpec with Matchers{

  describe("A grid is created with dimensions") {
    val grid = new Grid(3,3)
    it("isOnGrid determines if a point is on the grid") {
      grid.isOnGrid(Point(1,2)) shouldEqual true

      grid.isOnGrid(Point(4,3)) shouldEqual false
    }
  }

}
