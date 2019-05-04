package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.IParticipanteService;
import pe.com.model.entity.Participante;
import pe.com.model.repository.IParticipanteRepository;
import pe.com.model.repository.impl.ParticipanteRepository;
@Named
public class ParticipanteService implements IParticipanteService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IParticipanteRepository participanterp=new ParticipanteRepository();
	@Override
	public Integer Insert(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterp.Insert(t);
	}

	@Override
	public Integer Update(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterp.Update(t);
	}

	@Override
	public Integer Delete(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterp.Delete(t);
	}

	@Override
	public List<Participante> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return participanterp.FindAll();
	}

	@Override
	public Participante FindById(Participante t) throws Exception {
		// TODO Auto-generated method stub
		return participanterp.FindById(t);
	}

}
