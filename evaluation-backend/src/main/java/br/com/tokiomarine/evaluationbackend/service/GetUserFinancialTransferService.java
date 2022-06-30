package br.com.tokiomarine.evaluationbackend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tokiomarine.evaluationbackend.entity.UserFinancialTransfer;
import br.com.tokiomarine.evaluationbackend.model.response.GetUserFinancialTransferResponse;
import br.com.tokiomarine.evaluationbackend.repository.IUserFinancialTransferRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class GetUserFinancialTransferService {

	@Autowired
	private IUserFinancialTransferRepository repository;
	
	public ArrayList<GetUserFinancialTransferResponse> execute() {
		ArrayList<GetUserFinancialTransferResponse> response = new ArrayList<GetUserFinancialTransferResponse>();
		try {
		List<UserFinancialTransfer> entities = repository.findAll();	
		log.info("Resultado " + entities.toString());
		GetUserFinancialTransferResponse item = null;
		for (UserFinancialTransfer entity : entities) {
			item = new GetUserFinancialTransferResponse();
			item.setFROM_ACCOUNT(entity.getFROM_ACCOUNT());
			item.setId(entity.getId());
			item.setOPERATION_TYPE(entity.getOPERATION_TYPE());
			item.setSCHEDULED_DATE(entity.getSCHEDULED_DATE());
			item.setTAXES(entity.getTAXES_TRANSFER());
			item.setTO_ACCOUNT(entity.getTO_ACCOUNT());
			item.setFROM_ACCOUNT(entity.getFROM_ACCOUNT());
			item.setTRANSFER_DATE(entity.getTRANSFER_DATE());
			item.setVALUE_TRANSFER(entity.getVALUE_TRANSFER());
			response.add(item);
			}
		log.info("Result :"+response);
		} catch (Exception e) {
		log.info(e.getMessage());
			// TODO: handle exception
		}
		return response;
		
	}
}
