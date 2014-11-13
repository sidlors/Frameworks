Ext.define("AdminEquiposFutbol.view.equipo.PanelEquipos", {
	extend : 'Ext.panel.Panel',
	alias : 'widget.panelEquipos',

    bodyPadding: 20,
	layout : 'border',
    bodyStyle:{"background-color":"white"}, 
	items : [ {
		xtype : 'panelEncabezadoEquipos',
		//html: '<h1>Equipos</h1>',
		border: false,
		region : 'north'
	}, {
		xtype : 'gridEquipos',
		border: false,
		region : 'center'
	}, {
		xtype : 'panelDetalleEquipo',
		border: false,
		region : 'south',
		height : 180
	} ]

});