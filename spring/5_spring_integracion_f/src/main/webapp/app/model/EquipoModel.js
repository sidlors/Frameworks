Ext.define('AdminEquiposFutbol.model.EquipoModel', {
	extend : 'Ext.data.Model',
	fields : [ 'idEquipo', 'nombre', 'apodo', 'propietario', 'directorTecnico',
			'paginaWeb', 'estadioCasaNombre', 'estadioCasaDireccion',
			'fechaFundacion', 'fechaBaja' ],

	/*- inicialmente probado en ExtJS4 -*/
	// hasMany : {
	// model : 'AdminEquiposFutbol.model.JugadorModel',
	// primaryKey : 'idEquipo', /*-primaryKey name in associated-model (must
	// be:owner-model)*/
	// /*- error in hasMany-primaryKey,
	// * see
	// http://docs.sencha.com/extjs/4.2.2/#!/api/Ext.data.association.HasMany*/
	// foreignKey : 'idEquipo', // foreignKey name in associated-model
	// name : 'jugadorModels',
	// associationKey : 'jugadores'/*-The name of the property in the data to
	// read the association from*/
	// }
	hasMany : {
		model : 'AdminEquiposFutbol.model.JugadorModel',
		// primaryKey : 'idEquipo', /*-primaryKey name in associated-model (must
		// be:owner-model) -*/
		/*- error in hasMany-primaryKey, 
		 * see http://docs.sencha.com/extjs/4.2.2/#!/api/Ext.data.association.HasMany -*/
		// foreignKey : 'idEquipo', /*- foreignKey name in associated-model -*/
		name : 'getJugadorModels',
		associationKey : 'jugadores'
	/*-associationKey, The name of the property in the data to read the association from.
	 * Usar en caso cuando los modelos asociados vienen incluidos en datos-*/
	}

});