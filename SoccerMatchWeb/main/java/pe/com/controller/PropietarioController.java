package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IPropietarioService;
import pe.com.model.entity.Propietario;
import pe.com.util.Message;

@Named
@ViewScoped
public class PropietarioController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IPropietarioService PropietarioService;
	
	private Propietario Propietario;
	private Propietario PropietarioSelec;
	
	private List<Propietario> Propietarios;
	
	@PostConstruct
	public void init() {
		Propietario = new Propietario();
		PropietarioSelec = new Propietario();
		this.loadPropietarios();
				
	}
	
	public void loadPropietarios()  {
		
		try {
			this.Propietarios = PropietarioService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Propietario:" + e.getMessage());
		}
		
	}
	
	public void savePropietario() {
		try {
			//if(Propietario.getId() != null)
			Message.messageInfo("Propietario guardada exitosamente");
			PropietarioService.Insert(Propietario);
			loadPropietarios();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Propietario:" + e.getStackTrace());
		}
	}
	
	public void editPropietario() {
		
		try {
			if(this.PropietarioSelec!= null) {
				this.Propietario = PropietarioSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Propietario");
			}
		} catch (Exception e) {
			Message.messageError("Error Propietario:" + e.getMessage());
		}
	}
	
	public void selectPropietario(SelectEvent e) {
		this.PropietarioSelec = (Propietario) e.getObject();
	}
	
	public void clearForm() {
		this.Propietario = new Propietario();
		this.PropietarioSelec = null;
	}

	public Propietario getPropietario() {
		return Propietario;
	}

	public void setPropietario(Propietario Propietario) {
		this.Propietario = Propietario;
	}

	public Propietario getPropietarioSelec() {
		return PropietarioSelec;
	}

	public void setPropietarioSelec(Propietario PropietarioSelec) {
		this.PropietarioSelec = PropietarioSelec;
	}

	public List<Propietario> getPropietarios() {
		return Propietarios;
	}

	public void setPropietarios(List<Propietario> Propietarios) {
		this.Propietarios = Propietarios;
	}
	
	
	
}

