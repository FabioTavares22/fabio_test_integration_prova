package com.example.fabio_integration_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import com.example.fabio_integration_test.Comuns_DTO;
import com.example.fabio_integration_test.Comuns_New_DTO;
import com.example.fabio_integration_test.Comuns;

public class TestIntegration {
	
	//private ObjectMapper mapper = new ObjectMapper();
	private final String URLPayment = "http://localhost:8080/api/payment";

	//@Test
	/*public void testPostPayment() {
		int productCode = 20;
		
		try {
			Response resp = RestAssured.get(orderURL + "/" + productCode);
			assertEquals(HttpStatus.OK.value(), resp.getStatusCode());
			
			String jsonBody = resp.getBody().asString();
			ComunsDTO order = mapper.readValue(jsonBody, ComunsDTO.class);
			
			assertNotNull(order);
			assertEquals(1, order.getNumber());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Fail to get order with id: " + productCode, e);
		}
	}*/

	@Test
	public void testPostPayment() {
		//Caso de sucesso
		Comuns_New_DTO payment = new Comuns_New_DTO(31052023, 3.5F, "C", true, 31052023);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payment)
				.post(URLPayment);
		assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
	}
	
	@Test
	public void testPostErrorPayment() {
		//Caso de erro quando já existe o objeto
		Comuns_New_DTO payment = new Comuns_New_DTO(31052023, 3.5F, "C", true, 31052023);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payment)
				.post(URLPayment);
		assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
		
	}
	
	@Test
	public void testPostErrorJSON() {
		//Caso de erro quando dado no json estiver inválido
		Comuns_New_DTO payment = new Comuns_New_DTO(31052023, 3.5F, "C", true);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payment)
				.post(URLPayment);
		assertEquals(HttpStatus.CONFLICT.isError(), resp.getStatusCode());		
	}
	
	@Test
	public void testPutDesactive() {
		//Desativar um objeto
		Comuns_New_DTO payment = new Comuns_New_DTO(31052023, 3.5F, "C", false, 31052023);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payment)
				.put(URLPayment);
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		
	}
	
	@Test
	public void testPutActive() {
		//Ativar um objeto
		Comuns_New_DTO payment = new Comuns_New_DTO(31052023, 3.5F, "C", true, 31052023);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payment)
				.put(URLPayment);
		assertEquals(HttpStatus.OK, resp.getStatusCode());
		
	}

}
