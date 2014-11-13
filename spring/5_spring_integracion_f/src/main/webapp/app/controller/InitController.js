/*-inicio-Op1*/
//var proxyconzole = {};
//proxyconzole.log = function(msg) {
//	console.log('proxyconzole - ' + msg);
//};
// uncomment for development

// proxyconzole.log = function(msg){};//uncomment for production
/*-fin-Op1-*/

// inicio-Op2
// var console = {};
// console.log = function(){};
// fin-Op2
// inicio-Op3
// if ( ! window.console ) console = { log: function(){} };
// fin-Op3

Ext.define('AdminEquiposFutbol.controller.InitController', {
	extend : 'Ext.app.Controller',

	views : [ 'ViewportPrincipal', 'ToolbarPrincipal',
			'PanelEncabezadoPrincipal' ],

	init : function() {
		
		ExtUtil.Conzole.log('InitController - init- entro...');

	}

});