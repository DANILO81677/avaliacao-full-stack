package br.com.tokiomarine.evaluationbackend.model.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CreateUserFinancialTransferRequest {

	private String fromAccount;
	private String toAccount;
	private double value;	
	private LocalDate transferDate;

}
