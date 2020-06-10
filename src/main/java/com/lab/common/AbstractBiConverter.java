package com.lab.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBiConverter<T, R> implements BiConverter<T, R>{
	
	@Autowired
	protected ModelMapper modelMapper;

}
