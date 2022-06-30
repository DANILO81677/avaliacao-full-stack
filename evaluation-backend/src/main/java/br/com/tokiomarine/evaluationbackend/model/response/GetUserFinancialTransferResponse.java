package br.com.tokiomarine.evaluationbackend.model.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class GetUserFinancialTransferResponse {
	
	
	private Integer id;
	private String FROM_ACCOUNT;
	private String TO_ACCOUNT;
	private BigDecimal TAXES;
	private BigDecimal VALUE_TRANSFER;
	private LocalDate TRANSFER_DATE;
	private LocalDate SCHEDULED_DATE;
	private String OPERATION_TYPE;

}
