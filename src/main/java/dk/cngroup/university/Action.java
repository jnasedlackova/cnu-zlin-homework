package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public enum Action {
	RIGHT{
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
            Direction direction = rover.getDirection().getDirectionOnRight();
            Position position = rover.getPosition();
            return new Rover(direction, position);
		}
	},
	LEFT {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
            Direction direction = rover.getDirection().getDirectionOnLeft();
            Position position = rover.getPosition();
            return new Rover(direction, position);
		}
	},
	FORWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			Direction direction = rover.getDirection();
			Position position =
					rover.getPosition().getNeighbour(direction);
            return getRover(rover, landscape, direction, position);
		}
	},
	BACKWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
            Direction direction = rover.getDirection();
            Direction opositeDirection = direction.getOpositeDirection();
            Position position =
                    rover.getPosition().getNeighbour(opositeDirection);
            return getRover(rover, landscape, direction, position);
		}
	};

    static List<Position> listOfDetectedStones = new ArrayList<>();

    public static List<Position> getListOfDetectedStones() {
        return listOfDetectedStones;
    }

	public abstract Rover perform(Rover rover, Landscape landscape);

    public Rover getRover(Rover rover, Landscape landscape, Direction direction, Position position) {
        boolean outOfBounds = Position.isOutOfBounds(landscape, position);
        if (outOfBounds == false) {
            if (landscape.isAccessible(position)) {
                return new Rover(direction, position);
            } else {
                listOfDetectedStones.add(position);
                return rover;
            }
        }
        return rover;
	}
}
