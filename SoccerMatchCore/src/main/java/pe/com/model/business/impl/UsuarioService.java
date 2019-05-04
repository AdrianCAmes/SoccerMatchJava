package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import pe.com.model.business.IUsuarioService;
import pe.com.model.entity.Usuario;
import pe.com.model.repository.IUsuarioRepository;
import pe.com.model.repository.impl.UsuarioRepository;

public class UsuarioService implements IUsuarioService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUsuarioRepository usuariorp=new UsuarioRepository();
	@Override
	public Integer Insert(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return usuariorp.Insert(t);
	}

	@Override
	public Integer Update(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return usuariorp.Update(t);
	}

	@Override
	public Integer Delete(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return usuariorp.Delete(t);
	}

	@Override
	public List<Usuario> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return usuariorp.FindAll();
	}

	@Override
	public Usuario FindById(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return usuariorp.FindById(t);
	}

}
