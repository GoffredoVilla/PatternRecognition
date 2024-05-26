package patternrecognition;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/patternrecognition")
public class PatternRecognitionRest {
	
	public ArrayList<Line> lines_in_space = new ArrayList<Line>();
	public ArrayList<Point> points_in_space = new ArrayList<Point>();

	@POST
	@Path("point")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//public PatternRecognitionJsonResponse postPoint(PatternRecognitionJsonRequest request) {
	public String postPoint(PatternRecognitionJsonRequest request) {
		PatternRecognitionJsonResponse response = new PatternRecognitionJsonResponse();
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.toString();
		*/
		
		String jsonRequest = request.getJson();
		PatternRecognitionBean prb = new PatternRecognitionBean();
		prb = (PatternRecognitionBean) new Gson().fromJson(jsonRequest, prb.getClass());
		
		Integer x = prb.getX();
		Integer y = prb.getY();
		
		Point p = new Point(x, y);
		
		//Check if the point can be added to an existing line
		//if(lines_in_space.size() > 0) {
			for(Line ls : lines_in_space) {
				if(ls.containsPoint(p)) {
					ls.points.add(p);
				}
			}
		//}
		
		//Add line with new point and every point in the space
		//if(points_in_space.size() > 0) {
			for(Point ps : points_in_space) {
				Line ls = new Line(ps, p);
				lines_in_space.add(ls);
			}
		//}
		
		points_in_space.add(p);
		
		String result_msg = "Point {" + p.getX() + "," + p.getY() + "} added in the space";
		response.setResult_msg(result_msg);
		
		//return response;
		
		String jsonResponse = new Gson().toJson(response);
		
		return jsonResponse;
	}
	
	@GET
	@Path("space")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//public PatternRecognitionJsonResponse getSpace(PatternRecognitionJsonRequest request) {
	public String getSpace(PatternRecognitionJsonRequest request) {
		PatternRecognitionJsonResponse response = new PatternRecognitionJsonResponse();
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.toString();
		*/
		
		String result_msg = "Points in the space: ";
		
		for(int i=0; i<points_in_space.size(); i++) {
			if(i!=0) {
				result_msg += ",";
			}
			
			result_msg += "{" + points_in_space.get(i).getX() + "," + points_in_space.get(i).getY() + "}";
		}
		
		response.setResult_msg(result_msg);
		
		//return response;
		
		String jsonResponse = new Gson().toJson(response);
		
		return jsonResponse;
	}
	
	@GET
	@Path("lines/{n}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//public PatternRecognitionJsonResponse getLines(PatternRecognitionJsonRequest request, @PathParam("n") Integer n) {
	public String getLines(PatternRecognitionJsonRequest request, @PathParam("n") Integer n) {
		PatternRecognitionJsonResponse response = new PatternRecognitionJsonResponse();
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.toString();
		*/
		
		ArrayList<Line> linesWithAtListNPoints = new ArrayList<Line>();

		for(Line l : lines_in_space) {
		    if(l.points.size() >= n) {
		    	linesWithAtListNPoints.add(l);
		    }
		}
		
		String result_msg = "Lines with at least " + n + " points: " + "\n";
		
		for(int i=0; i<linesWithAtListNPoints.size(); i++) {
			ArrayList<Point> p = linesWithAtListNPoints.get(i).points;
			
			result_msg += "Line number " + i + ", with " + p.size() + " points: ";
			
			for(int j=0; j<p.size(); j++) {
				if(j!=0) {
					result_msg += ",";
				}
				
				result_msg += "{" + p.get(j).getX() + "," + p.get(j).getY() + "}";
			}
			
			result_msg += "\n";
		}
		
		response.setResult_msg(result_msg);
		
		//return response;
		
		String jsonResponse = new Gson().toJson(response);
		
		return jsonResponse;
	}
	
	@DELETE
	@Path("space")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//public PatternRecognitionJsonResponse deleteSpace(PatternRecognitionJsonRequest request) {
	public String deleteSpace(PatternRecognitionJsonRequest request) {
		PatternRecognitionJsonResponse response = new PatternRecognitionJsonResponse();
		
		/*
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.toString();
		*/
		
		lines_in_space = new ArrayList<Line>();
		points_in_space = new ArrayList<Point>();
		
		String result_msg = "Points in the space have been removed";
		
		response.setResult_msg(result_msg);
		
		//return response;
		
		String jsonResponse = new Gson().toJson(response);
		
		return jsonResponse;
	}
	
}
