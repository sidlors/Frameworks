Ext.define('AdminEquiposFutbol.model.JugadorModel', {
	extend : 'Ext.data.Model',
	// fields : [ 'idJugador', 'idEquipo', 'nombre', 'apellidoPaterno',
	// 'apellidoMaterno', 'fechaNacimiento', 'numeroCamiseta' ],
	fields : [ 'idJugador', 'nombre', 'apellidoPaterno', 'apellidoMaterno',
			'fechaNacimiento', 'numeroCamiseta' ],

	/*- belongsTo marca obsolete en extjs5 aunque si deberia funcionar porque sustityendo por 
	 * associations si funciona y es exactamente lo mismo. -*/
	// belongsTo : {
	// model : 'AdminEquiposFutbol.model.EquipoModel',
	// primaryKey : 'idEquipo', // primaryKey name in associated-model
	// foreignKey : 'idEquipo', // foreignKey name in owner-model
	// getterName : 'getEquipoModel',
	// setterName : 'setEquipoModel',
	// associationKey : 'equipo' /*-The name of the property in the data to read
	// the association from*/
	// },
	associations : [ {
		type : 'belongsTo',
		model : 'AdminEquiposFutbol.model.EquipoModel',
		// primaryKey : 'idEquipo', /*- primaryKey name in associated-model -*/
		// foreignKey : 'idEquipo', /*- foreignKey name in owner-model -*/
		getterName : 'getEquipoModel',
		setterName : 'setEquipoModel',
		associationKey : 'equipo'
	/*-associationKey, The name of the property in the data to read the association from.
	 * Usar en caso cuando los modelos asociados vienen incluidos en datos-*/

	} ]

});