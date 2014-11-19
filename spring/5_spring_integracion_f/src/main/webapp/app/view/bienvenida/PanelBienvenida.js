
//<--hasta aqui es namespace--><-paquete------><----clase------>
Ext.define("AdminEquiposFutbol.view.bienvenida.PanelBienvenida", {
	extend : 'Ext.panel.Panel',
	alias : 'widget.panelBienvenida',
	//el lenguaje de selectores va a ocupar este nombre
	itemId : 'panel_Bienvenida',
	bodyPadding : 20,
	html : '<h1>Mensaje Bienvenida</h1>' + '<br/>'
			+ 'Esta es una aplicacion para administar equipos de futbol.'
			+ '<br/>'
			+ '<br/>'
			+ 'Contiene el menu "Administrar Equipos", y "Administrar Jugadores"'
});