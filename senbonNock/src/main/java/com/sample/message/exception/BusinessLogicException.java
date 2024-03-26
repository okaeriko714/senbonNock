/**
 * 業務処理エラーのユーザ定義
 */

package com.sample.message.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogicException extends RuntimeException{
	  private List<String> errorMessages;

	    public BusinessLogicException(String message) {
	        super(message);
	        this.errorMessages = new ArrayList<>();
	    }

//	    public void addErrorMessage(String errorMessage) {
//	        errorMessages.add(errorMessage);
//	    }

	    public List<String> getErrorMessages() {
	        return errorMessages;
	    }
	}
