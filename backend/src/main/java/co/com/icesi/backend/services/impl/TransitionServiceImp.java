package co.com.icesi.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.icesi.backend.model.Transition;
import co.com.icesi.backend.model.TransitionId;
import co.com.icesi.backend.repositories.TransitionRepository;
import co.com.icesi.backend.services.TransitionService;

@Service
public class TransitionServiceImp implements TransitionService {

	@Autowired
	TransitionRepository repo;
	
	@Override
	public List<Transition> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Transition findById(TransitionId id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Transition add(Transition transition) {
		// TODO Auto-generated method stub
		return repo.save(transition);
	}

	@Override
	public Transition edit(Transition transition) {
		// TODO Auto-generated method stub
		return repo.save(transition);
	}

	@Override
	public Transition delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
