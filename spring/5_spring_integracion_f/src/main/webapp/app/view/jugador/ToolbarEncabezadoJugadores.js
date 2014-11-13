Ext
		.define(
				"AdminEquiposFutbol.view.jugador.ToolbarEncabezadoJugadores",
				{
					extend : 'Ext.toolbar.Toolbar',
					alias : 'widget.toolbarEncabezadoJugadores',
					// width : 500,
					items : [
							{
								// xtype: 'button', // default for Toolbars
								itemId : 'toolbarEncabezadoJugadores_button_Consultar',
								text : 'Consultar',
								menu : {
									xtype : 'menu',

									items : [

									{
										xtype : 'menuitem',
										itemId : 'toolbarEncabezadoJugadores_Consultar_menu_menuitem_Todos',
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
								itemId : 'toolbarEncabezadoJugadores_button_Agregar',
								text : 'Agregar'
							},
							{
								// xtype: 'button', // default for Toolbars
								itemId : 'toolbarEncabezadoJugadores_button_Editar',
								text : 'Editar'
							},
							{
								itemId : 'toolbarEncabezadoJugadores_button_Borrar',
								text : 'Borrar'
							},
							{
								itemId : 'toolbarEncabezadoJugadores_button_Reportes',
								text : 'Reportes',

								menu : {
									xtype : 'menu',
									items : [
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_ResumenJugadores',
									// text : 'Del Resumen Jugadores',
									//
									// menu : {
									// items : [
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_ResumenJugadores_menu_menuitem_txt',
									// text : 'txt',
									//
									// },
									// {
									// xtype : 'menuitem',
									// itemId :
									// 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_ResumenJugadores_menu_menuitem_xls',
									// text : 'xls'
									// } ]
									// }
									//
									// },

									{
										xtype : 'menuitem',
										itemId : 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_DetalleJugador',
										text : 'Del Detalle Jugador',

										menu : {
											items : [
													{
														xtype : 'menuitem',
														itemId : 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_DetalleJugador_menu_menuitem_txt',
														text : 'txt'

													}
											// {
											// xtype : 'menuitem',
											// itemId :
											// 'toolbarEncabezadoJugadores_Reportes_menu_menuitem_DetalleJugador_menu_menuitem_xls',
											// text : 'xls'
											//													} 
													]
										}

									} ]
								}

							} ]
				});
