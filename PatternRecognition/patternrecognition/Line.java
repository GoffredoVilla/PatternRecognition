package patternrecognition;

import java.util.ArrayList;

public class Line {

	public ArrayList<Point> points = new ArrayList<Point>();
	
	public Line(Point a, Point b) {
        this.points = new ArrayList<Point>();
        this.points.add(a);
        this.points.add(b);
    }
	
	public boolean containsPoint(Point c) {
		boolean contained = false;
		
	    Point a = this.points.get(0);
	    Point b = this.points.get(1);

	    //Same vertical line
	    //if(a.getX() == b.getX() && a.getX() == c.getX()) {
	    if(a.sameVerticalLine(b)) {
	    	contained = true;
	    }
	    //Same horizontal line
	    //else if(a.getY() == b.getY() && a.getY() == c.getY()) {
	    else if(a.sameHorizontalLine(b)) {
	    	contained = true;
	    }
	    //Same diagonal line (same slope)
	    else {
	    	Double slope_ab = a.calculateSlope(b);
	    	Double slope_ac = a.calculateSlope(c);
	    	
	    	if(slope_ab == slope_ac) {
	    		contained = true;
	    	}
	    }
	    
	    return contained;
	}
	
	public boolean intersects(Line l) {
		boolean intersection = false;
		
		ArrayList<Point> points_first_line = this.points;
		ArrayList<Point> points_second_line = l.points;
		
		for(Point p1 : points_first_line) {
			for(Point p2 : points_second_line) {
				if(p1.equals(p2)) {
					intersection = true;
					break;
				}
			}
		}
		
		return intersection;
	}
	
	
	public boolean overlaps(Line l) {
		boolean overlap = true;
		
		ArrayList<Point> points_line = l.points;
		
		for(Point p : points_line) {
			if(!this.containsPoint(p)) {
				overlap = false;
				break;
			}
		}
		
		return overlap;
	}
	
}
