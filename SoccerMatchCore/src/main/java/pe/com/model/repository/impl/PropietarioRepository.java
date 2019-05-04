package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.com.model.entity.Propietario;
import pe.com.model.repository.IPropietarioRepository;
@Named
public class PropietarioRepository implements IPropietarioRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	@Override
	public Integer Insert(Propietario t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Propietario t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Propietario t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Propietario> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propietario FindById(Propietario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
