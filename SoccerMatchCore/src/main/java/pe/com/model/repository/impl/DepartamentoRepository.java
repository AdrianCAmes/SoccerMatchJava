package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Departamento;
import pe.com.model.repository.IDepartamentoRepository;
@Named
public class DepartamentoRepository implements IDepartamentoRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Departamento t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Departamento t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Departamento t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Departamento> FindAll() throws Exception {
		List<Departamento> cursos = new ArrayList<Departamento>();

		TypedQuery<Departamento> query = em.createQuery("SELECT c FROM Departamento c", Departamento.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Departamento FindById(Departamento t) throws Exception {
		List<Departamento> usuarios=new ArrayList<>();
		TypedQuery<Departamento> query=em.createQuery("select*from Departamento where t.id=?1",Departamento.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Departamento();
	}

}
