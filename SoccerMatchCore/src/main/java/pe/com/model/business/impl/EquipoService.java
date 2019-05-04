package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.IEquipoService;
import pe.com.model.entity.Equipo;
import pe.com.model.repository.IEquipoRepository;
import pe.com.model.repository.impl.EquipoRepository;
@Named
public class EquipoService implements IEquipoService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IEquipoRepository equiporp=new EquipoRepository();
	@Override
	public Integer Insert(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporp.Insert(t);
	}

	@Override
	public Integer Update(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporp.Update(t);
	}

	@Override
	public Integer Delete(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporp.Delete(t);
	}

	@Override
	public List<Equipo> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return equiporp.FindAll();
	}

	@Override
	public Equipo FindById(Equipo t) throws Exception {
		// TODO Auto-generated method stub
		return equiporp.FindById(t);
	}

}
