sealed trait Instruction

case object MoveForward extends Instruction
case object RotateClockwise extends Instruction
case object RotateAntiClockwise extends Instruction

