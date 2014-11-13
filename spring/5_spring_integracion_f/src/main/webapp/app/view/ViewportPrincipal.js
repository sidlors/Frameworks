Ext.define("AdminEquiposFutbol.view.ViewportPrincipal", {
	extend : 'Ext.container.Viewport',
	alias : 'widget.viewportPrincipal',

	layout : 'border',
	items : [

	{
		region : 'north',
		// xtype: 'miToolbar',
		xtype : 'panelEncabezadoPrincipal'

	},

	{
		region : 'center',
		// border: true,
		xtype : 'panelBienvenida'
	// xtype : 'panelEquipos'
	} ]
});