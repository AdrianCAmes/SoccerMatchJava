package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IDistritoService;
import pe.com.model.business.IEquipoService;
import pe.com.model.entity.Distrito;
import pe.com.model.entity.Equipo;
import pe.com.util.Message;

@Named
@ViewScoped
public class EquipoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IEquipoService EquipoService;
	
	@Inject
	private IDistritoService DistritoService;
	
	private Equipo Equipo;
	private Equipo EquipoSelec;
	private List<Equipo> Equipos;
	
	private Distrito Distrito;
	private List<Distrito> Distritos;
	
	@PostConstruct
	public void init() {
		Equipo = new Equipo();
		EquipoSelec = new Equipo();
		this.loadEquipos();
				
	}
	
	public void loadEquipos()  {
		
		try {
			this.Equipos = EquipoService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Equipo:" + e.getMessage());
		}
		
	}
	
	public void saveEquipo() {
		try {
			//if(Equipo.getId() != null)
			Equipo.setDistrito(Distrito);
			EquipoService.Insert(Equipo);
			Message.messageInfo("Equipo guardada exitosamente");
			loadEquipos();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Equipo:" + e.getStackTrace());
		}
	}
	
	public void editEquipo() {
		
		try {
			if(this.EquipoSelec!= null) {
				this.Equipo = EquipoSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Equipo");
			}
		} catch (Exception e) {
			Message.messageError("Error Equipo:" + e.getMessage());
		}
	}
	
	public void selectEquipo(SelectEvent e) {
		this.EquipoSelec = (Equipo) e.getObject();
	}
	
	public void clearForm() {
		this.Equipo = new Equipo();
		this.EquipoSelec = null;
	}

	public Equipo getEquipo() {
		return Equipo;
	}

	public void setEquipo(Equipo Equipo) {
		this.Equipo = Equipo;
	}

	public Equipo getEquipoSelec() {
		return EquipoSelec;
	}

	public void setEquipoSelec(Equipo EquipoSelec) {
		this.EquipoSelec = EquipoSelec;
	}

	public List<Equipo> getEquipos() {
		return Equipos;
	}

	public void setEquipos(List<Equipo> Equipos) {
		this.Equipos = Equipos;
	}
	
	
	
}

