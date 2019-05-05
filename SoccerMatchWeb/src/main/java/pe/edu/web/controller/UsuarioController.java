package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IUsuarioService;
import pe.com.model.entity.Usuario;
import pe.com.util.Message;

@Named
@ViewScoped
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IUsuarioService UsuarioService;
	
	private Usuario Usuario;
	private Usuario UsuarioSelec;
	
	private List<Usuario> Usuarios;
	
	@PostConstruct
	public void init() {
		Usuario = new Usuario();
		UsuarioSelec = new Usuario();
		this.loadUsuarios();
				
	}
	
	public void loadUsuarios()  {
		
		try {
			this.Usuarios = UsuarioService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Usuario:" + e.getMessage());
		}
		
	}
	
	public void saveUsuario() {
		try {
			//if(Usuario.getId() != null)
			Message.messageInfo("Usuario guardada exitosamente");
			UsuarioService.Insert(Usuario);
			loadUsuarios();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Usuario:" + e.getStackTrace());
		}
	}
	
	public void editUsuario() {
		
		try {
			if(this.UsuarioSelec!= null) {
				this.Usuario = UsuarioSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Usuario");
			}
		} catch (Exception e) {
			Message.messageError("Error Usuario:" + e.getMessage());
		}
	}
	
	public void selectUsuario(SelectEvent e) {
		this.UsuarioSelec = (Usuario) e.getObject();
	}
	
	public void clearForm() {
		this.Usuario = new Usuario();
		this.UsuarioSelec = null;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public Usuario getUsuarioSelec() {
		return UsuarioSelec;
	}

	public void setUsuarioSelec(Usuario UsuarioSelec) {
		this.UsuarioSelec = UsuarioSelec;
	}

	public List<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(List<Usuario> Usuarios) {
		this.Usuarios = Usuarios;
	}
	
	
	
}

