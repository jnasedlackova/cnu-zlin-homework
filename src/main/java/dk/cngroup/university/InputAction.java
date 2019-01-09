package dk.cngroup.university;

public enum InputAction {
    R {
        @Override
        public Action getActionFromLetter() {
            return Action.RIGHT;
        }
    },
    L {
        @Override
        public Action getActionFromLetter() {
            return Action.LEFT;
        }
    },
    F {
        @Override
        public Action getActionFromLetter() {
            return Action.FORWARD;
        }
    },
    B {
        @Override
        public Action getActionFromLetter() {
            return Action.BACKWARD;
        }
    };

    public abstract Action getActionFromLetter();
}

