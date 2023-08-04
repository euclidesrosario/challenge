package com.challenge.webapp.Model;

import java.math.BigDecimal;

public class Exchange {
	
	public String result;
	public String base_code;
	public String documentation;
	public String terms_of_use;
	public BigDecimal conversion_rate;
	
	
	
	public String getBase_code() {
		return base_code;
	}
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public String getTerms_of_use() {
		return terms_of_use;
	}
	public void setTerms_of_use(String terms_of_use) {
		this.terms_of_use = terms_of_use;
	}
	public BigDecimal getConversion_rate() {
		return conversion_rate;
	}
	public void setConversion_rate(BigDecimal conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	@Override
	public String toString() {
		return "Exchange [result=" + result + ", documentation=" + documentation + ", terms_of_use=" + terms_of_use
				+ ", conversion_rate=" + conversion_rate + ", getResult()=" + getResult() + ", getDocumentation()="
				+ getDocumentation() + ", getTerms_of_use()=" + getTerms_of_use() + ", getConversion_rate()="
				+ getConversion_rate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

	
	
}
