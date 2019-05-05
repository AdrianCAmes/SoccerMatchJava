package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICiudadService;
import pe.com.model.business.IDistritoService;
import pe.com.model.entity.Ciudad;
import pe.com.model.entity.Distrito;
import pe.com.util.Message;

@Named
@ViewScoped
public class DistritoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IDistritoService DistritoService;
	
	@Inject
	private ICiudadService CiudadService;
	
	private Distrito Distrito;
	private Distrito DistritoSelec;
	
	private List<Distrito> Distritos;
	
	private Ciudad Ciudad;
	private List<Ciudad> Ciudads;
	
	@PostConstruct
	public void init() {
		Distrito = new Distrito();
		DistritoSelec = new Distrito();
		this.loadDistritos();
				
	}
	
	public void loadDistritos()  {
		
		try {
			this.Distritos = DistritoService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Distrito:" + e.getMessage());
		}
		
	}
	
	public void saveDistrito() {
		try {
			//if(Distrito.getId() != null)
			Distrito.setCiudad(Ciudad);
			DistritoService.Insert(Distrito);
			Message.messageInfo("Distrito guardada exitosamente");
			loadDistritos();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Distrito:" + e.getStackTrace());
		}
	}
	
	public void editDistrito() {
		
		try {
			if(this.DistritoSelec!= null) {
				this.Distrito = DistritoSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Distrito");
			}
		} catch (Exception e) {
			Message.messageError("Error Distrito:" + e.getMessage());
		}
	}
	
	public void selectDistrito(SelectEvent e) {
		this.DistritoSelec = (Distrito) e.getObject();
	}
	
	public void clearForm() {
		this.Distrito = new Distrito();
		this.DistritoSelec = null;
	}

	public Distrito getDistrito() {
		return Distrito;
	}

	public void setDistrito(Distrito Distrito) {
		this.Distrito = Distrito;
	}

	public Distrito getDistritoSelec() {
		return DistritoSelec;
	}

	public void setDistritoSelec(Distrito DistritoSelec) {
		this.DistritoSelec = DistritoSelec;
	}

	public List<Distrito> getDistritos() {
		return Distritos;
	}

	public void setDistritos(List<Distrito> Distritos) {
		this.Distritos = Distritos;
	}
	
	
	
}

