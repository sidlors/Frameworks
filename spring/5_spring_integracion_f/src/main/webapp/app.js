/**
 * Inicio de aplicacion ExtJs-MVC
 * 
 * INICIO NOTA1
 * 
 * Se usa Ext.Loader con: ExtUtil. En particular los mensajes de consola son
 * manejados con ExtUtil.Conzole. Deshabilitar en produccion.
 * 
 * FIN NOTA1
 */

Ext.Loader.setConfig({
	enabled : true,
	paths : {
		ExtUtil : "./app/extutil"
	}
});

// Requeridos para nuestras clases
// Ext.syncRequire('ExtUtil.Conzole');
Ext.require('ExtUtil.Conzole');
// Ext.require('ExtUtil.*');

//Optimizacion con uso de ext con Dynamic Class Loader
//Ext.require('Ext.container.Viewport');
//Ext.require('Ext.layout.container.Border');
//Ext.require('Ext.form.field.Date');
//Ext.require('Ext.form.field.Hidden');
//Ext.require('Ext.form.field.ComboBox');


Ext.application({
	name : 'AdminEquiposFutbol',

	appFolder : 'app',

	// requires:['ExtUtil.Conzole'],
	controllers : [ 'InitController', 'BienvenidaController',
			'AdminEquiposController', 'AdminJugadoresController' ],

	launch : function() {

		ExtUtil.Conzole.log('Ext.application - launch');

		Ext.create('AdminEquiposFutbol.view.ViewportPrincipal');
		
		



	}
});
