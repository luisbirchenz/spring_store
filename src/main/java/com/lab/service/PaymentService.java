package com.lab.service;

import java.util.Optional;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.lab.common.AbstractBiConverter;
import com.lab.domain.Payment;
import com.lab.domain.PaymentId;
import com.lab.payment.dto.PaymentDTO;
import com.lab.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService  extends AbstractBiConverter<Payment, PaymentDTO>{
	
	private final PaymentRepository paymentRepository;
	
	public Optional<PaymentDTO> findById(PaymentId id) {
		Optional<PaymentDTO> res = paymentRepository.findById(id).map(this::toDto);
		return res;
	}
	
	@Override
	public PaymentDTO toDto(Payment entity) {
		PropertyMap<Payment, PaymentDTO> paymentMap = new PropertyMap<Payment, PaymentDTO>() {
			  protected void configure() {
			    map().setCustomerNumber(source.getPaymentId().getCustomerNumber());
			    map().setCheckNumber(source.getPaymentId().getCheckNumber());
			  }
		};
		modelMapper.addMappings(paymentMap);
		return modelMapper.map(entity, PaymentDTO.class);
	}

	@Override
	public Payment toEntity(PaymentDTO dto) {
		return modelMapper.map(dto, Payment.class);
	}

}
