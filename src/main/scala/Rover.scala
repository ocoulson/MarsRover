case class Rover(currentPosition: Point, currentFacing: Direction, grid: Grid, history: List[(Point, Direction, Instruction)] = Nil) {

  def issueInstruction(instruction: Instruction): Rover = {
    val currentState = (currentPosition, currentFacing, instruction)
    instruction match {
      case MoveForward =>
        val newPosition = currentFacing match {
          case North => Point(currentPosition.x, currentPosition.y + 1)
          case South => Point(currentPosition.x, currentPosition.y - 1)
          case East => Point(currentPosition.x + 1, currentPosition.y)
          case West => Point(currentPosition.x - 1, currentPosition.y)
        }
        val correctedPosition =
            if (newPosition.x < 0) newPosition.copy(x = grid.xMax)
            else if (newPosition.x > grid.xMax) newPosition.copy(x = 0)
            else if (newPosition.y < 0) newPosition.copy(y = grid.yMax)
            else if (newPosition.y > grid.yMax) newPosition.copy(y = 0)
            else newPosition

        Rover(correctedPosition, currentFacing, grid, history :+ currentState)

      case RotateClockwise =>
        val newFacing = currentFacing.rotate90Clockwise
        Rover(currentPosition, newFacing, grid, history :+ currentState)

      case RotateAntiClockwise =>
        val newFacing = currentFacing.rotate90AntiClockwise
        Rover(currentPosition, newFacing, grid, history :+ currentState)
    }
  }
}


