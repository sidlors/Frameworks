Ext
		.define(
				"AdminEquiposFutbol.view.equipo.ToolbarEncabezadoEquipos",
				{
					extend : 'Ext.toolbar.Toolbar',
					alias : 'widget.toolbarEncabezadoEquipos',
					// width : 500,
					items : [
							{
								// xtype: 'button', // default for Toolbars
								itemId : 'toolbarEncabezadoEquipos_button_Consultar',
								text : 'Consultar',
								menu : {
									xtype : 'menu',

									items : [

									{
										xtype : 'menuitem',
										itemId : 'toolbarEncabezadoEquipos_Consultar_menu_menuitem_Todos',
										text : 'Todos con Resumen Estandar'

									} ]

								}
							// menu : Ext
							// .create(
							// 'Ext.menu.Menu',
							// {
							// items : [
							//
							// {
							// xtype : 'menuitem',
							// itemId :
							// 'toolbarEncabezadoEquipos_Consultar_menu_menuitem_Todos',
							// text : 'Todos con Resumen Estandar'
							//
							// } ]
							// })

							},

							{
								// xtype: 'button', // default for Toolbars
								itemId : 'toolbarEncabezadoEquipos_button_Agregar',
								text : 'Agregar'
							},
							{
								// xtype: 'button', // default for Toolbars
								itemId : 'toolbarEncabezadoEquipos_button_Editar',
								text : 'Editar'
							},
							{
								itemId : 'toolbarEncabezadoEquipos_button_Borrar',
								text : 'Borrar'
							},
							{
								itemId : 'toolbarEncabezadoEquipos_button_Reportes',
								text : 'Reportes',

								menu : {
									xtype : 'menu',
									items : [
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_ResumenEquipos',
									// text : 'Del Resumen Equipos',
									//
									// menu : {
									// items : [
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_ResumenEquipos_menu_menuitem_txt',
									// text : 'txt',
									//
									// },
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_ResumenEquipos_menu_menuitem_xls',
									// text : 'xls'
									// } ]
									// }
									//
									// },

									{
										xtype : 'menuitem',
										itemId : 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_DetalleEquipo',
										text : 'Del Detalle Equipo',

										menu : {
											items : [
													{
														xtype : 'menuitem',
														itemId : 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_DetalleEquipo_menu_menuitem_txt',
														text : 'txt'

													}
											// {
											// xtype : 'menuitem',
											// itemId :
											// 'toolbarEncabezadoEquipos_Reportes_menu_menuitem_DetalleEquipo_menu_menuitem_xls',
											// text : 'xls'
											// }
											]
										}

									} ]
								}

							} ]
				});
