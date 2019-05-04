package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.ICalleService;
import pe.com.model.entity.Calle;
import pe.com.model.repository.ICalleRepository;
import pe.com.model.repository.impl.CalleRepository;

@Named
public class CalleService implements ICalleService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICalleRepository callerp=new CalleRepository();
	@Override
	public Integer Insert(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerp.Insert(t);
	}

	@Override
	public Integer Update(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerp.Update(t);
	}

	@Override
	public Integer Delete(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerp.Delete(t);
	}

	@Override
	public List<Calle> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return callerp.FindAll();
	}

	@Override
	public Calle FindById(Calle t) throws Exception {
		// TODO Auto-generated method stub
		return callerp.FindById(t);
	}

}
