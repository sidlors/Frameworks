Ext.define("AdminEquiposFutbol.view.ToolbarPrincipal", {
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.toolbarPrincipal',
	// width : 500,
	items : [ {
		// xtype: 'button', // default for Toolbars
		text : 'Administrar',

		menu : Ext.create('Ext.menu.Menu', {
			items : [ {
				xtype : 'menuitem',
				itemId : 'toolbarPrincipal_menu_menuitem_Administrar_Equipos',
				text : 'Equipos',
				iconCls : 'calendar'
			}, {
				itemId : 'toolbarPrincipal_menu_menuitem_Administrar_Jugadores',
				text : 'Jugadores'
			} ]
		})
	}, {
		itemId : 'button_Ayuda',
		text : 'Ayuda',

		menu : Ext.create('Ext.menu.Menu', {
			items : [ {
				xtype : 'menuitem',
				itemId : 'toolbarPrincipal_menu_menuitem_Ayuda_Bienvenida',
				text : 'Bienvenida',
				iconCls : 'calendar'
			} ]
		})
	} ]
});
