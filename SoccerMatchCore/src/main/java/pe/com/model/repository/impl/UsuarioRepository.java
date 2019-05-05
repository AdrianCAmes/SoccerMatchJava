package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Usuario;
import pe.com.model.repository.IUsuarioRepository;
@Named
public class UsuarioRepository implements IUsuarioRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="SoccerMatchPU")
	public EntityManager em;
	@Override
	public Integer Insert(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Usuario t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Usuario t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Usuario> FindAll() throws Exception {
		List<Usuario> usuarios=new ArrayList<>();
		TypedQuery<Usuario> query=em.createQuery("select*from Usuario",Usuario.class);
		usuarios=query.getResultList();
		return usuarios;
	}

	public Usuario FindById(Usuario t) throws Exception {
		List<Usuario> usuarios=new ArrayList<>();
		TypedQuery<Usuario> query=em.createQuery("select*from Usuario where t.id=?1",Usuario.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Usuario();
	}

}
