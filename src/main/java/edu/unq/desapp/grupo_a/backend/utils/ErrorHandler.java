package edu.unq.desapp.grupo_a.backend.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.error.CarpndError;

@Service
public class ErrorHandler {

	private List<CarpndError> errors = new ArrayList<CarpndError>();
	
//	@Autowired
//	Logger logger;

	public boolean hasErrors() {
		return !isEmpty();
	}
	
	public boolean isEmpty() {
		return errors.isEmpty();
	}

	public boolean add(CarpndError e) {
		
		return errors.add(e);
	}

	public boolean addAll(Collection<? extends CarpndError> c) {
		return errors.addAll(c);
	}

	public int size() {
		return errors.size();
	}

	public Iterator<CarpndError> iterator() {
		return errors.iterator();
	}

	public Stream<CarpndError> stream() {
		return errors.stream();
	}
	
	public List<CarpndError> getErrors() {
		return errors;
	}

	public void clear() {
		errors.clear();
	}
	
	
}
