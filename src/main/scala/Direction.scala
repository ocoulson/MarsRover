trait Direction {
  def rotate90Clockwise: Direction
  def rotate90AntiClockwise: Direction
}

case object North extends Direction {
  override def rotate90Clockwise: Direction = East
  override def rotate90AntiClockwise: Direction = West
}
case object South extends Direction {
  override def rotate90Clockwise: Direction = West
  override def rotate90AntiClockwise: Direction = East
}
case object East extends Direction {
  override def rotate90Clockwise: Direction = South
  override def rotate90AntiClockwise: Direction = North
}
case object West extends Direction {
  override def rotate90Clockwise: Direction = North
  override def rotate90AntiClockwise: Direction = South
}