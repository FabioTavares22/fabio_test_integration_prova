package com.example.fabio_integration_test;

import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comuns_New_DTO {
	
	private Integer paymentDate;
	private float value;
	private String paymentType;
	private boolean active;
	
	
	@NotNull(message = "O código do produto não pode ser vazio")
	private Integer dueDate;
	
}
