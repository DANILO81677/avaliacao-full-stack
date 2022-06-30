package br.com.tokiomarine.evaluationbackend.process;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.evaluationbackend.utils.ConstEvaluationBackendTokioMarine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateValueTaxeTransferProcess {

	public double getTaxe(String typeOperation, double transferValue, LocalDate currentDate, LocalDate transferDate) {
		double taxeTransfer = 0;
		log.info("Starting Taxe Calcule Process ...");
		if (!typeOperation.isEmpty()) {
			//Calcula Taxa de Acordo com o tipo de operação
			if (typeOperation.equals(ConstEvaluationBackendTokioMarine.TYPE_A)) {
				log.info("Tipo A");
				taxeTransfer += 3.0;
				double percentual = 3.0 / 100.0; // 3%
				taxeTransfer = taxeTransfer + (percentual * transferValue);

			} else if (typeOperation.equals(ConstEvaluationBackendTokioMarine.TYPE_B)) {
				log.info("Tipo B");
				taxeTransfer = +12.0;

			} else if (typeOperation.equals(ConstEvaluationBackendTokioMarine.TYPE_C)) {
				log.info("Tipo C");

				if (transferDate.isAfter(currentDate.plusDays(10)) && transferDate.isBefore(currentDate.plusDays(20))) {
					double percentual = 8.2 / 100.0; // 8,2%
					taxeTransfer = taxeTransfer + (percentual * transferValue);

				} else if (transferDate.isAfter(currentDate.plusDays(20))
						&& transferDate.isBefore(currentDate.plusDays(30))) {
					double percentual = 6.9 / 100.0; // 6,9%
					taxeTransfer = taxeTransfer + (percentual * transferValue);

				} else if (transferDate.isAfter(currentDate.plusDays(30))
						&& transferDate.isBefore(currentDate.plusDays(40))) {
					double percentual = 4.7 / 100.0; // 4,7%
					taxeTransfer = taxeTransfer + (percentual * transferValue);

				} else if (transferDate.isAfter(currentDate.plusDays(40))) {
					double percentual = 1.7 / 100.0; // 1,7%
					taxeTransfer = taxeTransfer + (percentual * transferValue);
				}

			}

		}
		return taxeTransfer;
	}

	public String getType(LocalDate currentDate, LocalDate skedudeDate) {
		String type = null;
		//Calcula o tipo de operação com base na data
		if (skedudeDate != null) {
			if (currentDate.equals(skedudeDate)) {
				type = "A";
			} else if (!currentDate.equals(skedudeDate) && skedudeDate.isBefore(currentDate.plusDays(10))) {
				type = "B";
			} else if (!currentDate.equals(skedudeDate) && skedudeDate.isAfter(currentDate.plusDays(10))) {
				type = "C";
			}

		}
		return type;
	}

}
