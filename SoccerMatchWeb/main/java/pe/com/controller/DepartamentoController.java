package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IDepartamentoService;
import pe.com.model.entity.Departamento;
import pe.com.util.Message;

@Named
@ViewScoped
public class DepartamentoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IDepartamentoService DepartamentoService;
	
	private Departamento Departamento;
	private Departamento DepartamentoSelec;
	
	private List<Departamento> Departamentos;
	
	@PostConstruct
	public void init() {
		Departamento = new Departamento();
		DepartamentoSelec = new Departamento();
		this.loadDepartamentos();
				
	}
	
	public void loadDepartamentos()  {
		
		try {
			this.Departamentos = DepartamentoService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Departamento:" + e.getMessage());
		}
		
	}
	
	public void saveDepartamento() {
		try {
			//if(Departamento.getId() != null)
			Message.messageInfo("Departamento guardada exitosamente");
			DepartamentoService.Insert(Departamento);
			loadDepartamentos();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Departamento:" + e.getStackTrace());
		}
	}
	
	public void editDepartamento() {
		
		try {
			if(this.DepartamentoSelec!= null) {
				this.Departamento = DepartamentoSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Departamento");
			}
		} catch (Exception e) {
			Message.messageError("Error Departamento:" + e.getMessage());
		}
	}
	
	public void selectDepartamento(SelectEvent e) {
		this.DepartamentoSelec = (Departamento) e.getObject();
	}
	
	public void clearForm() {
		this.Departamento = new Departamento();
		this.DepartamentoSelec = null;
	}

	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento Departamento) {
		this.Departamento = Departamento;
	}

	public Departamento getDepartamentoSelec() {
		return DepartamentoSelec;
	}

	public void setDepartamentoSelec(Departamento DepartamentoSelec) {
		this.DepartamentoSelec = DepartamentoSelec;
	}

	public List<Departamento> getDepartamentos() {
		return Departamentos;
	}

	public void setDepartamentos(List<Departamento> Departamentos) {
		this.Departamentos = Departamentos;
	}
	
	
	
}

