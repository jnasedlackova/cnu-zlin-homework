package dk.cngroup.university;

public enum Direction {
	NORTH {
		@Override
		Direction getDirectionOnRight() {
			return EAST;
		}
	},
	SOUTH {
		@Override
		Direction getDirectionOnRight() {
			return WEST;
		}
	},
	WEST {
		@Override
		Direction getDirectionOnRight() {
			return NORTH;
		}
	},
	EAST {
		@Override
		Direction getDirectionOnRight() {
			return SOUTH;
		}
	};

	abstract Direction getDirectionOnRight();

}
