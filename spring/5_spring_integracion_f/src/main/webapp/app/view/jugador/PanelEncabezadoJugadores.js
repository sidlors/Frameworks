Ext
		.define(
				'AdminEquiposFutbol.view.jugador.PanelEncabezadoJugadores',
				{
					extend : 'Ext.Panel',

					alias : 'widget.panelEncabezadoJugadores',
					title : 'Jugadores',
					//html : "Critierio de Consulta para Resumen de Equipos:<span name='criterioConsulta'></span>",
					bodyPadding : 5,
					dockedItems : [

					{
						xtype : 'toolbarEncabezadoJugadores'
					}

					],

					initComponent : function() {
						this.tpl = Ext.create('Ext.Template', this.tplMarkup);
						this.html = this.startingMarkup;

						this.bodyStyle = {
							background : '#D0D0D0'
						};
						// call the superclass's initComponent implementation
						this.callParent(arguments);
					},
					tplMarkup : [ 'Critierio de Consulta para Resumen de Jugadores: {criterioConsultaTexto}' ],
			        startingMarkup: 'Critierio de Consulta para Resumen de Jugadores:',
			        updateConsulta: function(data) {
			            this.tpl.overwrite(this.body, data);
			        }

				});