package com.lab.common;

public interface BiConverter<T, R> {
	R toDto(T entity);
	T toEntity(R dto); 
}