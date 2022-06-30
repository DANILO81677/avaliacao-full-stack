package br.com.tokiomarine.evaluationbackend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TRANSFER")
public class UserFinancialTransfer {
	
	@Id
	@GeneratedValue(generator = "TRANSFER_SEQ")
	private Integer id;

	@Column(name = "FROM_ACCOUNT")
	private String FROM_ACCOUNT;

	@Column(name = "TO_ACCOUNT")
	private String TO_ACCOUNT;
	
	@Column(name = "TAXES")
	private BigDecimal TAXES_TRANSFER;
	
	@Column(name = "VALUE_TRANSFER")
	private BigDecimal VALUE_TRANSFER;
	
	@Column(name = "TRANSFER_DATE")
	private LocalDate TRANSFER_DATE;
	
	@Column(name = "SCHEDULED_DATE")
	private LocalDate SCHEDULED_DATE;
	
	@Column(name = "OPERATION_TYPE")
	private String OPERATION_TYPE;
	
}
