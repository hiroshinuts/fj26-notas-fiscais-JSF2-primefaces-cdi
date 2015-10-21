package br.com.caelum.notasfiscais.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;

@Named
@ViewScoped
public class ListaNotasFiscaisBean {

	@Inject
	private DataModelNotasFiscais dataModel;
	
	@Inject
	public DataModelNotasFiscais getDataModel() {
		return dataModel;
		
	}
	
}
