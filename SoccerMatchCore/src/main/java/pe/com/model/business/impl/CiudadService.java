package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.ICiudadService;
import pe.com.model.entity.Ciudad;
import pe.com.model.repository.ICiudadRepository;
import pe.com.model.repository.impl.CiudadRepository;
@Named
public class CiudadService implements ICiudadService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICiudadRepository ciudadrp=new CiudadRepository();
	@Override
	public Integer Insert(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrp.Insert(t);
	}

	@Override
	public Integer Update(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrp.Update(t);
	}

	@Override
	public Integer Delete(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrp.Delete(t);
	}

	@Override
	public List<Ciudad> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return ciudadrp.FindAll();
	}

	@Override
	public Ciudad FindById(Ciudad t) throws Exception {
		// TODO Auto-generated method stub
		return ciudadrp.FindById(t);
	}

}
