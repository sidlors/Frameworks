Ext.define('AdminEquiposFutbol.controller.BienvenidaController', {
	extend : 'Ext.app.Controller',


	views : [ 'bienvenida.PanelBienvenida' ],

	refs : [ {
		ref : 'viewport',
		selector : 'viewport'
	} ],

	init : function() {
		ExtUtil.Conzole.log('BienvenidaController - init - entro');
		//ExtUtil.Conzole.log('BienvenidaController - init - entro');
		
		// '#menuitem_Administrar_Equipos'
		this.control({
			'menuitem[itemId=toolbarPrincipal_menu_menuitem_Ayuda_Bienvenida]' : {
				click : this.displayPanelBienvenida
			}
		});

	},

	displayPanelBienvenida : function(item, e) {
		// Ext.Msg.alert('Status', 'Changes saved successfully.');
		ExtUtil.Conzole.log('AyudaController - displayPanelBienvenida - entro');

		var panelEquipos = Ext
				.create('AdminEquiposFutbol.view.bienvenida.PanelBienvenida');

		var panelCenter = this.getViewport().down('panel[region=center]');
		this.getViewport().remove(panelCenter);
		//this.getViewport().remove('panel_Bienvenida');
		this.getViewport().add({
			region : 'center',
			xtype : 'panelBienvenida'
		});

	}


});