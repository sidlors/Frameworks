Ext.define("AdminEquiposFutbol.view.jugador.PanelJugadores", {
	extend : 'Ext.panel.Panel',
	alias : 'widget.panelJugadores',

    bodyPadding: 20,
	layout : 'border',
    bodyStyle:{"background-color":"white"}, 
	items : [ {
		xtype : 'panelEncabezadoJugadores',
		//html: '<h1>Equipos</h1>',
		border: false,
		region : 'north'
	}, {
		xtype : 'gridJugadores',
		border: false,
		region : 'center'
	}, {
		xtype : 'panelDetalleJugador',
		border: false,
		region : 'south',
		height : 180
	} ]

});