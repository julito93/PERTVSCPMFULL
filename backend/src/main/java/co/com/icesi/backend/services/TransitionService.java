package co.com.icesi.backend.services;

import java.util.List;

import co.com.icesi.backend.model.Transition;


public interface TransitionService {

	List<Transition> list();

	Transition findById(int id);

	Transition add(Transition Transition);

	Transition edit(Transition Transition);

	Transition delete(int id);

}
