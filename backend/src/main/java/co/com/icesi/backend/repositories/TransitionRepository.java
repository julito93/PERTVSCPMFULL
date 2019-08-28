package co.com.icesi.backend.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import co.com.icesi.backend.model.Transition;

public interface TransitionRepository extends Repository<Transition, Integer> {

List<Transition> findAll();
	
	Transition findById(int id);
	
	Transition save(Transition transition);
	
	void delete(Transition transition);  
	
}
