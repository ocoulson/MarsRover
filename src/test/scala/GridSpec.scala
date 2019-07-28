import org.scalatest.{FunSpec, Matchers}

class GridSpec extends FunSpec with Matchers {

  describe("GetAllPoints") {

    it("returns a set of all points that are on the grid") {
      val grid1 = Grid(1,1)
      grid1.getAllPoints shouldEqual Set(
        Point(0,0), Point(0,1),
        Point(1,0), Point(1,1)
      )

      val grid2 = Grid(1,3)
      grid2.getAllPoints shouldEqual Set(
        Point(0,0), Point(0,1), Point(0,2), Point(0,3),
        Point(1,0), Point(1,1), Point(1,2), Point(1,3)
      )
    }
  }

}
