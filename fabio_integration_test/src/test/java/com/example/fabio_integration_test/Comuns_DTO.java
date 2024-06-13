package com.example.fabio_integration_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Comuns_DTO {
	
	private Integer productCode;
	private Integer paymentDate;
	private Integer dueDate;
	private float value;
	private String paymentType;
	//@JsonIgnore
	private boolean active;

}
