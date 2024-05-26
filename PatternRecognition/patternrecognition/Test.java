package patternrecognition;

import com.google.gson.Gson;

public class Test {

	public void main(String ... args) throws Exception {
		PatternRecognitionJsonRequest request = new PatternRecognitionJsonRequest();
		PatternRecognitionJsonResponse response = new PatternRecognitionJsonResponse();
		
		String jsonRequest = "{\"x\": 0, \"y\": 0}";
		request.setJson(jsonRequest);
		String jsonResponse = "";
		
		PatternRecognitionRest prr = new PatternRecognitionRest();
		
		jsonResponse = prr.postPoint(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonRequest = "{\"x\": 1, \"y\": 1}";
		request.setJson(jsonRequest);
		
		jsonResponse = prr.postPoint(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonRequest = "{\"x\": 2, \"y\": 2}";
		request.setJson(jsonRequest);
		
		jsonResponse = prr.postPoint(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonRequest = "{\"x\": 3, \"y\": 3}";
		request.setJson(jsonRequest);
		
		jsonResponse = prr.postPoint(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonRequest = "{\"x\": 4, \"y\": 4}";
		request.setJson(jsonRequest);
		
		jsonResponse = prr.postPoint(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonResponse = prr.getSpace(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonResponse = prr.getLines(request, 5);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
		jsonResponse = prr.deleteSpace(request);
		response = new Gson().fromJson(jsonResponse, response.getClass());
		System.out.println("Response message: " + response.getResult_msg());
		
	}
	
}
