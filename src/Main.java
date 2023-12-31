public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
        moveRobot(robot, 10, 12);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            } else if (dir == Direction.DOWN) {
                y--;
            } else if (dir == Direction.LEFT) {
                x--;
            } else if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX > robot.getX()) {
            robot.turnRight();
            while (robot.getX() != toX) {
                robot.stepForward();
            }
            if (toY > robot.getY()) {
                robot.turnLeft();
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            } else if (toY < robot.getY()) {
                robot.turnRight();
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        } else if (toX < robot.getX()) {
            robot.turnLeft();
            while (robot.getX() != toX) {
                robot.stepForward();
            }
            if (toY > robot.getY()) {
                robot.turnRight();
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            } else if (toY < robot.getY()) {
                robot.turnLeft();
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        }
    }
}