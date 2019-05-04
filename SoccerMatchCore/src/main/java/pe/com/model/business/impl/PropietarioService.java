package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import pe.com.model.business.IPropietarioService;
import pe.com.model.entity.Propietario;
import pe.com.model.repository.IPropietarioRepository;
import pe.com.model.repository.impl.PropietarioRepository;

public class PropietarioService implements IPropietarioService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPropietarioRepository propietariorp=new PropietarioRepository();
	@Override
	public Integer Insert(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorp.Insert(t);
	}

	@Override
	public Integer Update(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorp.Update(t);
	}

	@Override
	public Integer Delete(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorp.Delete(t);
	}

	@Override
	public List<Propietario> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return propietariorp.FindAll();
	}

	@Override
	public Propietario FindById(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return propietariorp.FindById(t);
	}

}
