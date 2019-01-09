package dk.cngroup.university;

public enum InputDirection {
    N {
        @Override
        public Direction getDirectionFromLetter() {
            return Direction.NORTH;
        }
    },
    E {
        @Override
        public Direction getDirectionFromLetter() {
            return Direction.EAST;
        }
    },
    S {
        @Override
        public Direction getDirectionFromLetter() {
            return Direction.SOUTH;
        }
    },
    W {
        @Override
        public Direction getDirectionFromLetter() {
            return Direction.WEST;
        }
    };

    public abstract Direction getDirectionFromLetter();
}
