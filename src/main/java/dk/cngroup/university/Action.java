package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;

public enum Action {
	RIGHT{
		@Override
        public Rover perform(Rover rover, Landscape landscape, int numberOfOvercomingFields) {
            Direction direction = rover.getDirection().getDirectionOnRight();
            Position position = rover.getPosition();
            return new Rover(direction, position);
		}
	},
	LEFT {
		@Override
        public Rover perform(Rover rover, Landscape landscape, int numberOfOvercomingFields) {
            Direction direction = rover.getDirection().getDirectionOnLeft();
            Position position = rover.getPosition();
            return new Rover(direction, position);
		}
	},
	FORWARD {
		@Override
        public Rover perform(Rover rover, Landscape landscape, int numberOfOvercomingFields) {
			Direction direction = rover.getDirection();
			Position position =
					rover.getPosition().getNeighbour(direction);
            return getRover(rover, landscape, direction, position, numberOfOvercomingFields);
		}
	},
	BACKWARD {
		@Override
        public Rover perform(Rover rover, Landscape landscape, int numberOfOvercomingFields) {
            Direction direction = rover.getDirection();
            Direction opositeDirection = direction.getOpositeDirection();
            Position position =
                    rover.getPosition().getNeighbour(opositeDirection);
            return getRover(rover, landscape, direction, position, numberOfOvercomingFields);
		}
	};

    static List<Position> listOfDetectedStones = new ArrayList<>();
    static List<Position> listOfOvecomedStones = new ArrayList<>();

    public static List<Position> getListOfDetectedStones() {
        return listOfDetectedStones;
    }

    public static List<Position> getListOfOvecomedStones() {
        return listOfOvecomedStones;
    }

    public abstract Rover perform(Rover rover, Landscape landscape, int numberOfOvercomingFields);

    public Rover getRover(Rover rover, Landscape landscape, Direction direction, Position position, int numberOfOvercomingFields) {
        boolean outOfBounds = Position.isOutOfBounds(landscape, position);
        if (outOfBounds == false) {
            if (landscape.isAccessible(position)) {
                return new Rover(direction, position);
            } else {
                listOfDetectedStones.add(position);
                if (listOfOvecomedStones.size() < numberOfOvercomingFields) {
                    listOfOvecomedStones.add(position);
                    return new Rover(direction, position);
                }
                return rover;
            }
        }
        return rover;
	}
}
