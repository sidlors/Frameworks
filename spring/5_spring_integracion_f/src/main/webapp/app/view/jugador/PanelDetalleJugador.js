Ext
		.define(
				'AdminEquiposFutbol.view.jugador.PanelDetalleJugador',
				{
					extend : 'Ext.Panel',

					alias : 'widget.panelDetalleJugador',
					// add tplMarkup as a new property
					tplMarkup : [ '<b>-Detalle-</b><br/>',
							'<b>Nombre:</b> {nombre}<br/>',
							'<b>Apellido Paterno:</b> {apellidoPaterno}<br/>',
							'<b>Apellido Materno:</b> {apellidoMaterno}<br/>',
							'<b>Fecha Nacimiento:</b> {fechaNacimiento}<br/>',
							'<b>Numero Camiseta:</b> {numeroCamiseta}<br/>',
							'<b>Equipo:</b> {equipoNombre}<br/>' ],
					// startingMarup as a new property
					startingMarkup : 'Seleccione un Jugador para ver sus detalles.',

					bodyPadding : 20,
					// override initComponent to create and compile the template
					// apply styles to the body of the panel and initialize
					// html to startingMarkup
					initComponent : function() {
						this.tpl = Ext.create('Ext.Template', this.tplMarkup);
						this.html = this.startingMarkup;

						this.bodyStyle = {
							background : '#D0D0D0'
						};
						// call the superclass's initComponent implementation
						this.callParent(arguments);
					},
					// add a method which updates the details
					updateDetail : function(data) {
						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.PanelDetalleJugador - updateDetail - data:'
										+ data);

						for ( var key in data) {
							var value = data[key];
							ExtUtil.Conzole
									.log('AdminEquiposFutbol.view.jugador.PanelDetalleJugador - updateDetail - key,value:'
											+ key + "," + value);
						}

						// data.getEquipoModel().get('idEquipo');
						this.tpl.overwrite(this.body, data);
					},
					updateLimpio : function() {
						this.update(this.startingMarkup);
					}

				});