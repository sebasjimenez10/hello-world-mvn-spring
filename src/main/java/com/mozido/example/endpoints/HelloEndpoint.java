package com.mozido.example.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.examples.generated.helloitems.HelloRequest;
import com.mozido.examples.generated.helloitems.HelloResponse;

@Endpoint
public class HelloEndpoint {

	@PayloadRoot(localPart = "helloRequest", namespace = "http://localhost:8080/HelloWorldSpring/hello")
	@ResponsePayload
	public HelloResponse handleRequest(@RequestPayload HelloRequest request)
			throws Exception {

		System.out.println("Received message: " + request.getMessage());

		HelloResponse response = new HelloResponse();
		response.setResponseMessage("Hello, your message was: "
				+ request.getMessage());

		return response;
	}

}
