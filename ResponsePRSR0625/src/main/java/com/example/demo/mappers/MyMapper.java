package com.example.demo.mappers;

public interface MyMapper<T, S> {
	public T map(S s);
}
