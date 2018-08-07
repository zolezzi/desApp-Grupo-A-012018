package edu.unq.desapp.grupo_a.backend.utils;

public class WrappedValue<T> {

	private T value;

	public WrappedValue() { }

	public WrappedValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
