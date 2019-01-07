package dk.cngroup.university;

public enum Direction {
	NORTH {
		@Override
		Direction getDirectionOnRight() {
			return EAST;
		}

		@Override
		Direction getDirectionOnLeft() {
			return WEST;
		}

		@Override
		Direction getOpositeDirection() {
			return SOUTH;
		}
	},
	SOUTH {
		@Override
		Direction getDirectionOnRight() {
			return WEST;
		}

		@Override
		Direction getDirectionOnLeft() {
			return EAST;
		}

		@Override
		Direction getOpositeDirection() {
			return NORTH;
		}

	},
	WEST {
		@Override
		Direction getDirectionOnRight() {
			return NORTH;
		}

		@Override
		Direction getDirectionOnLeft() {
			return SOUTH;
		}

		@Override
		Direction getOpositeDirection() {
			return EAST;
		}
	},
	EAST {
		@Override
		Direction getDirectionOnRight() {
			return SOUTH;
		}

		@Override
		Direction getDirectionOnLeft() {
			return NORTH;
		}

		@Override
		Direction getOpositeDirection() {
			return WEST;
		}
	};

	abstract Direction getDirectionOnRight();

	abstract Direction getDirectionOnLeft();

	abstract Direction getOpositeDirection();

}
