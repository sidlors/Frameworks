Ext.define('AdminEquiposFutbol.view.jugador.GridJugadores', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.gridJugadores',// NOTE for alias: widget.*

	initComponent : function() {

		this.store = 'JugadoresStore';// Err detectado!!

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

	definirColumnasEstandar : function() {

		var columns = [
				{
					text : "Nombre",
					flex : 1,
					dataIndex : 'nombre',
					sortable : false,
					menuDisabled : true
				},
				{
					text : "Apellido Paterno",
					flex : 1,
					dataIndex : 'apellidoPaterno',
					sortable : false,
					menuDisabled : true
				},
				{
					text : "Numero Camiseta",
					flex : 1,
					dataIndex : 'numeroCamiseta',
					sortable : false,
					menuDisabled : true
				},
				{
					text : "Equipo",
					flex : 1,
					//dataIndex : 'EquipoModel.nombre',
					sortable : false,
					menuDisabled : true,
					renderer : function(value, metaData, record, row, col,
							store, gridView) {
						
						ExtUtil.Conzole.log('AdminEquiposFutbol.view.jugador.GridJugadores - definirColumnasEstandar - nombre:'+
								record.get('nombre'));
						ExtUtil.Conzole.log('AdminEquiposFutbol.view.jugador.GridJugadores - definirColumnasEstandar - record.getEquipoModel:'+
								record.getEquipoModel().get('nombre'));
						ExtUtil.Conzole.log('AdminEquiposFutbol.view.jugador.GridJugadores - definirColumnasEstandar - row:'+row);
						
						return record.getEquipoModel().get('nombre');
						//return record.get('equipo').get('nombre');
					}
				} ];

		this.reconfigure(this.store, columns);

	}

});