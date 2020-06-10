package com.lab.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentId implements Serializable{
	
	private static final long serialVersionUID = -2070306194508856082L;

	@Column(name = "customer_number")
	private Long customerNumber;
	
	@Column(name = "check_number")
	private String checkNumber;
	
	public PaymentId() {}

	public PaymentId(Long customerNumber, String checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
		return result;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentId)) return false;
        PaymentId that = (PaymentId) o;
        return Objects.equals(getCustomerNumber(), that.getCustomerNumber()) &&
                Objects.equals(getCheckNumber(), that.getCheckNumber());
    }
	
	
}
