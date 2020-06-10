package com.lab.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable{

	private static final long serialVersionUID = -9033339073422694130L;

	@Column(name = "order_number")
	private Long orderNbr;

	@Column(name = "product_code")
	private String code;
	
	public OrderDetailId() {}

	public OrderDetailId(Long orderNbr, String code) {
		super();
		this.orderNbr = orderNbr;
		this.code = code;
	}

	public Long getOrderNbr() {
		return orderNbr;
	}

	public String getCode() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((orderNbr == null) ? 0 : orderNbr.hashCode());
		return result;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailId)) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(getOrderNbr(), that.getOrderNbr()) &&
                Objects.equals(getCode(), that.getCode());
    }

}
