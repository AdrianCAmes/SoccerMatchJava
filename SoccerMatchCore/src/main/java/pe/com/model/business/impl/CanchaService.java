package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.ICanchaService;
import pe.com.model.entity.Cancha;
import pe.com.model.repository.ICanchaRepository;
import pe.com.model.repository.impl.CanchaRepository;
@Named
public class CanchaService implements ICanchaService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICanchaRepository cancharp=new CanchaRepository(); 
	@Override
	public Integer Insert(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharp.Insert(t);
	}

	@Override
	public Integer Update(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharp.Update(t);
	}

	@Override
	public Integer Delete(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharp.Delete(t);
	}

	@Override
	public List<Cancha> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return cancharp.FindAll();
	}

	@Override
	public Cancha FindById(Cancha t) throws Exception {
		// TODO Auto-generated method stub
		return cancharp.FindById(t);
	}

}
