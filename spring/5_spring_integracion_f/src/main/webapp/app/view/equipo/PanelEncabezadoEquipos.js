Ext
		.define(
				'AdminEquiposFutbol.view.equipo.PanelEncabezadoEquipos',
				{
					extend : 'Ext.Panel',

					alias : 'widget.panelEncabezadoEquipos',
					title : 'Equipos',
					//html : "Critierio de Consulta para Resumen de Equipos:<span name='criterioConsulta'></span>",
					bodyPadding : 5,
					dockedItems : [

					{
						xtype : 'toolbarEncabezadoEquipos'
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
					tplMarkup : [ 'Critierio de Consulta para Resumen de Equipos: {criterioConsultaTexto}' ],
			        startingMarkup: 'Critierio de Consulta para Resumen de Equipos:',
			        updateConsulta: function(data) {
			            this.tpl.overwrite(this.body, data);
			        }

				});