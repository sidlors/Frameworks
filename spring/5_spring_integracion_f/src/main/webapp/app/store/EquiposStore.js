Ext.define('AdminEquiposFutbol.store.EquiposStore', {
    extend: 'Ext.data.Store',	
    alias : 'equiposStore',
    model: 'AdminEquiposFutbol.model.EquipoModel',
	proxy: {
		//url: 'data/equipos.json',
		type: 'ajax'
	}
});