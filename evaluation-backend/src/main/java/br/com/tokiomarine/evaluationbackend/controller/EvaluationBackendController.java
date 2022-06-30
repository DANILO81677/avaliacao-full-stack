package br.com.tokiomarine.evaluationbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.tokiomarine.evaluationbackend.model.request.CreateUserFinancialTransferRequest;
import br.com.tokiomarine.evaluationbackend.model.response.CreateUserFinancialTransferResponse;
import br.com.tokiomarine.evaluationbackend.model.response.GetUserFinancialTransferResponse;
import br.com.tokiomarine.evaluationbackend.service.CreateUserFinancialTransferService;
import br.com.tokiomarine.evaluationbackend.service.GetUserFinancialTransferService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class EvaluationBackendController {

	@Autowired
	private CreateUserFinancialTransferService createService;

	@Autowired
	private GetUserFinancialTransferService getService;

	/**
	 * Cria uma nova transferencia Financeira
	 */
	@RequestMapping(path = "/userFinancialTransfer/create", method = RequestMethod.POST)
	public ResponseEntity<CreateUserFinancialTransferResponse> createTransfer(
			@RequestBody CreateUserFinancialTransferRequest request) {
		CreateUserFinancialTransferResponse response = new CreateUserFinancialTransferResponse();
		try {
			log.info("Input create financial transfer:{}", request);
			response = createService.execute(request);
			return new ResponseEntity<CreateUserFinancialTransferResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.info(e.getMessage());
			response.setMessage("Problems in create customer !!");
			return new ResponseEntity<CreateUserFinancialTransferResponse>(response, HttpStatus.CONFLICT);
		}

	}

	/**
	 * Lista todas as transferencias Financeiras Cadastradas
	 */
	@RequestMapping(path = "/userFinancialTransfer/get", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<GetUserFinancialTransferResponse>> getTransfers() {
		ArrayList<GetUserFinancialTransferResponse> response = new ArrayList<GetUserFinancialTransferResponse>();
		log.info("List All Transfers...");
		try {
			response = getService.execute();
			return new ResponseEntity<ArrayList<GetUserFinancialTransferResponse>>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.info(e.getMessage());
			return new ResponseEntity<ArrayList<GetUserFinancialTransferResponse>>(response, HttpStatus.CONFLICT);
		}
	}

}
