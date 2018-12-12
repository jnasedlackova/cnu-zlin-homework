package dk.cngroup.university;

public enum Action {
	RIGHT{
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			return null;
		}
	},
	LEFT {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			return null;
		}
	},
	FORWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			Direction direction = rover.getDirection();
			Position position =
					rover.getPosition().getNeighbour(direction);
			if (landscape.isAccessible(position)) {
				return new Rover(direction, position);
			}
			return rover;
		}
	},
	BACKWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			return null;
		}
	};

	public abstract Rover perform(Rover rover, Landscape landscape);
}
