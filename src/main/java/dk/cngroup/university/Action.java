package dk.cngroup.university;

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
			boolean outOfBounds = isOutOfBounds(landscape, position);
			if (outOfBounds == false) {
				if (landscape.isAccessible(position)) {
					return new Rover(direction, position);
				}
			}
			return rover;
		}
	},
	BACKWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
            Direction direction = rover.getDirection();
            Direction opositeDirection = direction.getOpositeDirection();
            Position position =
                    rover.getPosition().getNeighbour(opositeDirection);
			boolean outOfBounds = isOutOfBounds(landscape, position);
			if (outOfBounds == false) {
				if (landscape.isAccessible(position)) {
					return new Rover(direction, position);
				}
			}
            return rover;
		}
	};

	public abstract Rover perform(Rover rover, Landscape landscape);

	public static boolean isOutOfBounds(Landscape landscape, Position position) {
		if (position.x >= landscape.getFields().length || position.y >= landscape.getFields().length
				|| position.x < 0 || position.y < 0) {
			return true;
		} else return false;
	}
}
