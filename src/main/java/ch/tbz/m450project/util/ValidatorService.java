package ch.tbz.m450project.util;

public interface ValidatorService<T> {

	boolean validateRequestBody(T body);
}
