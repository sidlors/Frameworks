Ext.define('AdminEquiposFutbol.view.equipo.PanelDetalleEquipo', {
        extend: 'Ext.Panel',
        
        alias: 'widget.panelDetalleEquipo',
        // add tplMarkup as a new property
        tplMarkup: [
            '<b>-Detalle-</b><br/>',                    
			'<b>Nombre:</b> {nombre}<br/>',
			'<b>Apodo:</b> {apodo}<br/>',
			'<b>Propietario:</b> {propietario}<br/>',
			'<b>Director Tecnico:</b> {directorTecnico}<br/>',
			'<b>Pagina Web:</b> {paginaWeb}<br/>',
			'<b>Estacio de Casa Nombre:</b> {estadioCasaNombre}<br/>',
			'<b>Estadio de Casa Direccion:</b> {estadioCasaDireccion}<br/>',
			'<b>Fecha Funcacion:</b> {fechaFundacion}<br/>',
			'<b>Fecha Baja:</b> {fechaBaja}<br/>'
        ],
        // startingMarup as a new property
        startingMarkup: 'Seleccione un Equipo para ver sus detalles.',

        bodyPadding: 20,
        // override initComponent to create and compile the template
        // apply styles to the body of the panel and initialize
        // html to startingMarkup
        initComponent: function() {
            this.tpl = Ext.create('Ext.Template', this.tplMarkup);
            this.html = this.startingMarkup;

            this.bodyStyle = {
                background: '#D0D0D0'
            };
            // call the superclass's initComponent implementation
            this.callParent(arguments);
        },
        // add a method which updates the details
        updateDetail: function(data) {
            this.tpl.overwrite(this.body, data);
        },
        updateLimpio: function(){
        	this.update(this.startingMarkup);
        }
        
    });