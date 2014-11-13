Ext.define('AdminEquiposFutbol.view.equipo.FormPanelDatosEquipo', {
	extend : 'Ext.form.Panel',
	alias : 'widget.formPanelDatosEquipo',

	// url:'save-form.php',
	// frame:true,
	bodyStyle : 'padding:5px 5px 0',
	defaultType : 'textfield',

	items : [ {
		fieldLabel : '*Nombre',
		name : 'equipo.nombre',
		allowBlank : false
	}, {
		fieldLabel : 'Apodo',
		name : 'equipo.apodo'
	}, {
		fieldLabel : 'Propietario',
		name : 'equipo.propietario'
	}, {
		fieldLabel : 'Director Tecnico',
		name : 'equipo.directorTecnico'
	}, {
		fieldLabel : 'Pagina Web',
		name : 'equipo.paginaWeb'
	}, {
		fieldLabel : 'Estadio de Casa Nombre',
		name : 'equipo.estadioCasaNombre'
	}, {
		fieldLabel : 'Estadio de Casa Direcci&oacute;n',
		name : 'equipo.estadioCasaDireccion'
	}, {
		fieldLabel : 'Fecha Fundaci&oacute;n',
		// name : 'equipo.fechaFundacion'
		name : 'fechaFundacion',
		xtype : 'datefield',
		// emptyText: 'aaaa/mm/dd',
		// maskRe: /[0-9\-]/,
		format : 'Y-m-d',
		altFormats : 'Y-m-d'	
	}, {
		fieldLabel : 'Fecha Baja',
		// name : 'equipo.fechaBaja'
		name : 'fechaBaja',
		xtype : 'datefield',
		// emptyText: 'aaaa/mm/dd',
		// maskRe: /[0-9\-]/,
		format : 'Y-m-d',
		altFormats : 'Y-m-d'			
	}, {
		name : 'equipo.idEquipo',
		xtype : 'hiddenfield',
		value: '0'
	}

	],

	setValuesFromEquiposModel : function(equiposModel) {
		var values = {
			"equipo.nombre" : equiposModel.get('nombre'),
			"equipo.apodo" : equiposModel.get('apodo'),
			"equipo.propietario" : equiposModel.get('propietario'),
			"equipo.directorTecnico" : equiposModel.get('directorTecnico'),
			"equipo.paginaWeb" : equiposModel.get('paginaWeb'),
			"equipo.estadioCasaNombre" : equiposModel.get('estadioCasaNombre'),
			"equipo.estadioCasaDireccion" : equiposModel
					.get('estadioCasaDireccion'),
			// "equipo.fechaFundacion" : equiposModel.get('fechaFundacion'),
			"fechaFundacion" : equiposModel.get('fechaFundacion'),
			// "equipo.fechaBaja" : equiposModel.get('fechaBaja'),
			"fechaBaja" : equiposModel.get('fechaBaja'),
			"equipo.idEquipo" : equiposModel.get('idEquipo')
		};
		this.getForm().setValues(values);
	}

});