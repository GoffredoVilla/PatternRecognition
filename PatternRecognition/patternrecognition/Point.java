package patternrecognition;

public class Point {

	public Integer x;
	public Integer y;
	
	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	public boolean sameVerticalLine(Point p) {
		boolean sameVert = false;
		
		if(this.getX() == p.getX()) {
			sameVert = true;
		}
		
		return sameVert;
	}
	
	public boolean sameHorizontalLine(Point p) {
		boolean sameHor = false;
		
		if(this.getY() == p.getY()) {
			sameHor = true;
		}
		
		return sameHor;
	}
	
	public boolean equals(Point p) {
		boolean equalPoint = false;
		
		if(this.sameVerticalLine(p) && this.sameHorizontalLine(p)) {
			equalPoint = true;
		}
		
		return equalPoint;
	}
	
	public Double calculateSlope(Point p) {
		Double xDiff = p.getX().doubleValue() - this.getX().doubleValue();
		Double yDiff = p.getY().doubleValue() - this.getY().doubleValue();

		Double slope = yDiff / xDiff;
	     
	    return slope;
	}
	
}
