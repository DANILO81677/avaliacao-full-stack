package br.com.tokiomarine.evaluationbackend.exception;

public class EvaluationBackendException extends Exception {

	private static final long serialVersionUID = 1L;

	private String customMessageError;

	public EvaluationBackendException(String customMessageError) {
		super();
		this.setCustomMessage(customMessageError);
	}

	public String getCustomMessage() {
		return customMessageError;
	}

	public void setCustomMessage(String customMessageError) {
		this.customMessageError = customMessageError;
	}

}
