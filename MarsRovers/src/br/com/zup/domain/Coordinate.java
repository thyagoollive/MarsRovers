package br.com.zup.domain;


/**
 * AxisCoordinate
 * @author thyago
 * Represents Axis Coordinate
 */
public class Coordinate {

	private int axisX;
    private int axisY;

    public Coordinate(final int axisX, final int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public Coordinate newCoordinatesFor(final int axisX, final int axisY) {
        return new Coordinate(this.axisX + axisX, this.axisY + axisY);
    }

    @Override
    public String toString() {
        return String.valueOf(axisX) + " " + String.valueOf(axisY);
    }
    
    public boolean hasWithinBounds(final Coordinate limitCoordinates) throws NullPointerException {
        return ((this.axisX <= limitCoordinates.axisX) && (this.axisY <= limitCoordinates.axisY));
    }
	
}
