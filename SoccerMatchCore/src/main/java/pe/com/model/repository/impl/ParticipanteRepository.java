package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.com.model.entity.Participante;
import pe.com.model.repository.IParticipanteRepository;
@Named
public class ParticipanteRepository implements IParticipanteRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	@Override
	public Integer Insert(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Update(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Delete(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participante> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante FindById(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
