package dk.cngroup.university;

import java.util.Objects;

public class Position {
	public final int x;
	public final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position getNeighbour(Direction direction) {
		switch (direction) {
			case SOUTH:
				return new Position(x + 1, y);
            case WEST:
                return new Position(x, y - 1);
            case NORTH:
                return new Position(x - 1, y);
            case EAST:
                return new Position(x, y + 1);
            default:
				return this;
		}
	}

    public static Position changeOutOfBoundsPosition(Position position, int landscapeSize, String string) {
        int x = position.x;
        int y = position.y;
        if (x < 0) {
            x = 0;
        } else if (x >= landscapeSize) {
            x = landscapeSize - 1;
        }
        if (y < 0) {
            y = 0;
        } else if (y >= landscapeSize) {
            y = landscapeSize - 1;
        }
        System.out.println("Coordinates of " + string + " out of Landscape Boundary - changed to the closest Field");
        return new Position(x, y);
    }

    public static boolean isOutOfBounds(Landscape landscape, Position position) {
        if (position.x >= landscape.getFields().length || position.y >= landscape.getFields().length
                || position.x < 0 || position.y < 0) {
            return true;
        } else return false;
    }

	@Override
	public String toString() {
		return "Position{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
