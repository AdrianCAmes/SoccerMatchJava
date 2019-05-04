package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.IDistritoService;
import pe.com.model.entity.Distrito;
import pe.com.model.repository.IDistritoRepository;
import pe.com.model.repository.impl.DistritoRepository;

@Named
public class DistritoService implements IDistritoService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDistritoRepository distritorp=new DistritoRepository();
	@Override
	public Integer Insert(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorp.Insert(t);
	}

	@Override
	public Integer Update(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorp.Update(t);
	}

	@Override
	public Integer Delete(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorp.Delete(t);
	}

	@Override
	public List<Distrito> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return distritorp.FindAll();
	}

	@Override
	public Distrito FindById(Distrito t) throws Exception {
		// TODO Auto-generated method stub
		return distritorp.FindById(t);
	}

}
