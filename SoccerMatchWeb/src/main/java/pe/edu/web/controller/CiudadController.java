package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICiudadService;
import pe.com.model.business.IDepartamentoService;
import pe.com.model.entity.Ciudad;
import pe.com.model.entity.Departamento;
import pe.com.util.Message;

@Named
@ViewScoped
public class CiudadController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICiudadService CiudadService;
	
	@Inject
	private IDepartamentoService DepartamentoService;
	
	private Ciudad Ciudad;
	private Ciudad CiudadSelec;
	private List<Ciudad> Ciudads;
	
	private Departamento Departamento;
	private List<Departamento> Departamentos;
	
	@PostConstruct
	public void init() {
		Ciudad = new Ciudad();
		CiudadSelec = new Ciudad();
		this.loadCiudads();
				
	}
	
	public void loadCiudads()  {
		
		try {
			this.Ciudads = CiudadService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Ciudad:" + e.getMessage());
		}
		
	}
	
	public void saveCiudad() {
		try {
			//if(Ciudad.getId() != null)
			Ciudad.setDepartamento(Departamento);
			CiudadService.Insert(Ciudad);
			Message.messageInfo("Ciudad guardada exitosamente");
			loadCiudads();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Ciudad:" + e.getStackTrace());
		}
	}
	
	public void editCiudad() {
		
		try {
			if(this.CiudadSelec!= null) {
				this.Ciudad = CiudadSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Ciudad");
			}
		} catch (Exception e) {
			Message.messageError("Error Ciudad:" + e.getMessage());
		}
	}
	
	public void selectCiudad(SelectEvent e) {
		this.CiudadSelec = (Ciudad) e.getObject();
	}
	
	public void clearForm() {
		this.Ciudad = new Ciudad();
		this.CiudadSelec = null;
	}

	public Ciudad getCiudad() {
		return Ciudad;
	}

	public void setCiudad(Ciudad Ciudad) {
		this.Ciudad = Ciudad;
	}

	public Ciudad getCiudadSelec() {
		return CiudadSelec;
	}

	public void setCiudadSelec(Ciudad CiudadSelec) {
		this.CiudadSelec = CiudadSelec;
	}

	public List<Ciudad> getCiudads() {
		return Ciudads;
	}

	public void setCiudads(List<Ciudad> Ciudads) {
		this.Ciudads = Ciudads;
	}
	
	
	
}

