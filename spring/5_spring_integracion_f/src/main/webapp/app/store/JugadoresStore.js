Ext.define('AdminEquiposFutbol.store.JugadoresStore', {
	extend : 'Ext.data.Store',
	model : 'AdminEquiposFutbol.model.JugadorModel',
	proxy : {
		// url: 'data/equipos.json',
		type : 'ajax'
		
	// reader: {
	// type: 'json'
	// }
	}

});