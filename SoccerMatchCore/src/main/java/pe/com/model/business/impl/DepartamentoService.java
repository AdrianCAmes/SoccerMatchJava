package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import pe.com.model.business.IDepartamentoService;
import pe.com.model.entity.Departamento;
import pe.com.model.repository.IDepartamentoRepository;
import pe.com.model.repository.impl.DepartamentoRepository;
@Named
public class DepartamentoService implements IDepartamentoService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDepartamentoRepository departamentorp=new DepartamentoRepository();
	@Override
	public Integer Insert(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorp.Insert(t);
	}

	@Override
	public Integer Update(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorp.Update(t);
	}

	@Override
	public Integer Delete(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorp.Delete(t);
	}

	@Override
	public List<Departamento> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return departamentorp.FindAll();
	}

	@Override
	public Departamento FindById(Departamento t) throws Exception {
		// TODO Auto-generated method stub
		return departamentorp.FindById(t);
	}

}
