package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.IDetalleParticipanteService;
import pe.com.model.entity.DetalleParticipante;
import pe.com.model.repository.IDetalleParticipanteRepository;
import pe.com.model.repository.impl.DetalleParticipanteRepository;
@Named
public class DetalleParticipanteService implements IDetalleParticipanteService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDetalleParticipanteRepository detalleparticipanterp=new DetalleParticipanteRepository();
	@Override
	public Integer Insert(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterp.Insert(t);
	}

	@Override
	public Integer Update(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterp.Update(t);
	}

	@Override
	public Integer Delete(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterp.Delete(t);
	}

	@Override
	public List<DetalleParticipante> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterp.FindAll();
	}

	@Override
	public DetalleParticipante FindById(DetalleParticipante t) throws Exception {
		// TODO Auto-generated method stub
		return detalleparticipanterp.FindById(t);
	}

}
