package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import pe.com.model.business.IAlquilerService;
import pe.com.model.entity.Alquiler;
import pe.com.model.repository.IAlquilerRepository;
import pe.com.model.repository.impl.*;
@Named
public class AlquilerService implements IAlquilerService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAlquilerRepository alquilerrp=new AlquilerRepository();
	public Integer Insert(Alquiler t) throws Exception {
		return alquilerrp.Insert(t);
	}

	@Override
	public Integer Update(Alquiler t) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrp.Update(t);
	}

	@Override
	public Integer Delete(Alquiler t) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrp.Delete(t);
	}

	@Override
	public List<Alquiler> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerrp.FindAll();
	}

	@Override
	public Alquiler FindById(Alquiler t) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrp.FindById(t);
	}

}
