Ext.define('AdminEquiposFutbol.view.equipo.GridEquipos', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridEquipos',// NOTE for alias: widget.*

	initComponent : function() {

		this.store = 'EquiposStore';// Err detectado!!
//		this.columns = [ {
//			text : "Nombre",
//			flex : 1,
//			dataIndex : 'nombre',
//			sortable : false,
//			menuDisabled : true
//		}, {
//			text : "Apodo",
//			flex : 1,
//			dataIndex : 'apodo',
//			sortable : false,
//			menuDisabled : true
//		}, {
//			text : "Propietario",
//			flex : 1,
//			dataIndex : 'propietario',
//			sortable : false,
//			menuDisabled : true
//		}, {
//			text : "Director Tecnico",
//			flex : 1,
//			dataIndex : 'directorTecnico',
//			sortable : false,
//			menuDisabled : true
//		} ];

		this.columns = [ {
			text : " ",
			flex : 1,
			dataIndex : '',
			sortable : false,
			menuDisabled : true
		} ];

		this.viewConfig = {
			forceFit : true
		};

		this.callParent(arguments);
	},


	definirColumnasEstandar: function(){

		var columns = [ {
			text : "Nombre",
			flex : 1,
			dataIndex : 'nombre',
			sortable : false,
			menuDisabled : true
		}, {
			text : "Apodo",
			flex : 1,
			dataIndex : 'apodo',
			sortable : false,
			menuDisabled : true
		}, {
			text : "Propietario",
			flex : 1,
			dataIndex : 'propietario',
			sortable : false,
			menuDisabled : true
		}, {
			text : "Director Tecnico",
			flex : 1,
			dataIndex : 'directorTecnico',
			sortable : false,
			menuDisabled : true
		} ];
		
		this.reconfigure(this.store, columns);
		

	}

});