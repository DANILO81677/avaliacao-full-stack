package br.com.tokiomarine.evaluationbackend.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tokiomarine.evaluationbackend.entity.UserFinancialTransfer;
import br.com.tokiomarine.evaluationbackend.exception.EvaluationBackendException;
import br.com.tokiomarine.evaluationbackend.model.request.CreateUserFinancialTransferRequest;
import br.com.tokiomarine.evaluationbackend.model.response.CreateUserFinancialTransferResponse;
import br.com.tokiomarine.evaluationbackend.process.CreateValueTaxeTransferProcess;
import br.com.tokiomarine.evaluationbackend.repository.IUserFinancialTransferRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateUserFinancialTransferService {

	@Autowired
	private IUserFinancialTransferRepository repository;

	@Autowired
	private CreateValueTaxeTransferProcess taxeProcess;

	public CreateUserFinancialTransferResponse execute(CreateUserFinancialTransferRequest request)
			throws EvaluationBackendException {
		CreateUserFinancialTransferResponse response = new CreateUserFinancialTransferResponse();
		log.info("Starting register new transfer ...");
		LocalDate currentDate = LocalDate.now();
		try {
			// Calcula Tipos de operação e Taxas
			String typeOperation = taxeProcess.getType(currentDate, request.getTransferDate());
			log.info("Operation Type : "+typeOperation);
			double taxeValue = taxeProcess.getTaxe(typeOperation, request.getValue(), currentDate,
					request.getTransferDate());
			log.info("Taxe Value Calculated : "+taxeValue);
			// Faz inserção dos dados na tabela
			UserFinancialTransfer entity = new UserFinancialTransfer();
			entity.setFROM_ACCOUNT(request.getFromAccount());
			entity.setOPERATION_TYPE(typeOperation);
			entity.setSCHEDULED_DATE(request.getTransferDate());
			entity.setTAXES_TRANSFER(BigDecimal.valueOf(taxeValue));
			entity.setVALUE_TRANSFER(BigDecimal.valueOf(request.getValue()));
			entity.setTRANSFER_DATE(currentDate);
			entity.setTO_ACCOUNT(request.getToAccount());
			repository.save(entity);
			log.info("Register Successfuly : " + entity);
			response.setId(entity.getId().longValue());
			response.setMessage("Register Successfuly");
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO: handle exception

		}
		return response;
	}

}
