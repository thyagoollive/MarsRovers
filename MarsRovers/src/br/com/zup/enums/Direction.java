package br.com.zup.enums;


/**
 * CardinalDirection
 * @author thyago
 * Represents direction
 */
public enum Direction {
	NORTH(0,1) {
        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },

    SOUTH(0,-1) {
    	@Override
        public Direction turnLeft() {
            return EAST;
        }
    	
        @Override
        public Direction turnRight() {
            return WEST;
        }
    },

    EAST(1,0) {
    	@Override
        public Direction turnLeft() {
            return NORTH;
        }
    	
    	@Override
        public Direction turnRight() {
            return SOUTH;
        }
    },

    WEST(-1,0) {
    	@Override
        public Direction turnLeft() {
            return SOUTH;
        }
    	
        @Override
        public Direction turnRight() {
            return NORTH;
        }
    };
	
	private final int axisX;
    private final int axisY;

    Direction(final int axisX, final int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public abstract Direction turnLeft();
    public abstract Direction turnRight();
	
    public int getAxisX() {
        return this.axisX;
    }

    public int getAxisY() {
        return this.axisY;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
    	return String.valueOf(super.toString().charAt(0));
    }
    
    public static Direction fromString(String stringDirection){
    	switch (stringDirection) {
		case "N":
			return NORTH;
		case "S":
			return SOUTH;
		case "E":
			return EAST;
		case "W":
			return WEST;
		default:
			throw new IllegalArgumentException("Invalid direction [" + stringDirection + "]!");
		}
    }
}
