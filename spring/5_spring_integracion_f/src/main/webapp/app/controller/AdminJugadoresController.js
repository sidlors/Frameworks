Ext
		.define(
				'AdminEquiposFutbol.controller.AdminJugadoresController',
				{
					extend : 'Ext.app.Controller',

					/*- can be used required */
					// requires : [ 'Ext.form.field.Time' ],
					windowInteraccion : null,
					stores : [ 'JugadoresStore' ],

					models : [ 'JugadorModel' ],

					views : [ 'jugador.PanelJugadores',
							'jugador.PanelEncabezadoJugadores',
							'jugador.ToolbarEncabezadoJugadores',
							'jugador.GridJugadores',
							'jugador.PanelDetalleJugador',
							'jugador.FormPanelDatosJugador' ],

					refs : [
							{
								ref : 'viewport',
								selector : 'viewport'
							},
							{
								ref : 'panelEncabezadoJugadores',
								selector : 'viewport > panelJugadores > panelEncabezadoJugadores'
							},
							{
								ref : 'gridJugadores',
								selector : 'viewport > panelJugadores > gridJugadores'
							},
							{
								ref : 'panelDetalleJugador',
								selector : 'viewport > panelJugadores > panelDetalleJugador'
							} ],

					init : function() {
						ExtUtil.Conzole.log('AdminJugadoresController - init - entro');

						// ////////////////////////////////////////////////////////////
						// /inicio
						// toolbarPrincipal_menu_menuitem_Administrar_Jugadores//
						// ////////////////////////////////////////////////////////////

						this
								.control({
									'menuitem[itemId=toolbarPrincipal_menu_menuitem_Administrar_Jugadores]' : {
										click : this.displayResumenJugadores
									}
								});

						// /////////////////////////////////////////////////////////
						// /fin
						// toolbarPrincipal_menu_menuitem_Administrar_Jugadores//
						// /////////////////////////////////////////////////////////

						// ///////////////////////
						// /inicio gridJugadores//
						// ///////////////////////

						this
								.control({
									'viewport > panelJugadores > gridJugadores dataview' : {
										itemclick : this.bindGridToPanel
									}
								});

						// ////////////////////
						// /fin gridJugadores//
						// ////////////////////

						// ////////////////////////////////////
						// /inicio toolbarEncabezadoJugadores//
						// ////////////////////////////////////

						this
								.control({
									'button[itemId=toolbarEncabezadoJugadores_button_Agregar]' : {
										click : this.displayAgregarDatosJugador
									}
								});

						this
								.control({
									'button[itemId=toolbarEncabezadoJugadores_button_Editar]' : {
										click : this.displayEditarDatosJugador
									}
								});

						this
								.control({
									'button[itemId=toolbarEncabezadoJugadores_button_Borrar]' : {
										click : this.displayBorrarDatosJugador
									}
								});

						this
								.control({
									'menuitem[itemId=toolbarEncabezadoJugadores_Consultar_menu_menuitem_Todos]' : {
										click : this.displayConsultarTodosResumenEstandar
									}
								});

						this
								.control({
									'menuitem[itemId=toolbarEncabezadoJugadores_Reportes_menu_menuitem_DetalleJugador_menu_menuitem_txt]' : {
										click : this.generateReporteDetalleJugador
									}
								});

						// /////////////////////////////////
						// /fin toolbarEncabezadoJugadores//
						// /////////////////////////////////

						// ///////////////////////////////
						// /inicio window_AgregarJugador//
						// ///////////////////////////////

						this
								.control({
									'button[itemId=window_AgregarJugador_button_Agregar]' : {
										click : this.agregarDatosJugador
									}
								});

						this
								.control({
									'button[itemId=window_AgregarJugador_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// ////////////////////////////
						// /fin window_AgregarJugador//
						// ////////////////////////////

						// //////////////////////////////
						// /inicio window_EditarJugador//
						// //////////////////////////////

						this
								.control({
									'button[itemId=window_EditarJugador_button_Editar]' : {
										click : this.editarDatosJugador
									}
								});

						this
								.control({
									'button[itemId=window_EditarJugador_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// ///////////////////////////
						// /fin window_EditarJugador//
						// ///////////////////////////

						// //////////////////////////////
						// /inicio window_BorrarJugador//
						// //////////////////////////////

						// ///////////////////////////
						// /fin window_BorrarJugador//
						// ///////////////////////////

						// //////////////////////////////////////////////
						// /inicio window_ConsultarTodosResumenEstandar//
						// //////////////////////////////////////////////

						this
								.control({
									'button[itemId=window_ConsultarTodosResumenEstandarJugadores_button_Aceptar]' : {
										click : this.consultarTodosResumenEstandar
									}
								});

						this
								.control({
									'button[itemId=window_ConsultarTodosResumenEstandarJugadores_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// ///////////////////////////////////////////
						// /fin window_ConsultarTodosResumenEstandar//
						// ///////////////////////////////////////////

					},// init

					displayResumenJugadores : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayResumenJugadores - entro');

						var panelJugadores = Ext
								.create('AdminEquiposFutbol.view.jugador.PanelJugadores');

						var panelCenter = this.getViewport().down(
								'panel[region=center]');
						this.getViewport().remove(panelCenter);
						this.getViewport().add({
							region : 'center',
							xtype : 'panelJugadores'
						});

					},// displayResumenJugadores

					bindGridToPanel : function(grid, record) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - bindGridToPanel - entro');

						var data = {
							'nombre' : record.get('nombre'),
							'apellidoPaterno' : record.get('apellidoPaterno'),
							'apellidoMaterno' : record.get('apellidoMaterno'),
							'fechaNacimiento' : record.get('fechaNacimiento'),
							'numeroCamiseta' : record.get('numeroCamiseta'),
							'equipoNombre' : record.getEquipoModel().get(
									'nombre')
						};

						// this.getPanelDetalleJugador().updateDetail(record.data);
						this.getPanelDetalleJugador().updateDetail(data);
					},// bindGridToPanel

					displayAgregarDatosJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayAgregarDatosJugador - entro');
						// TRACE-EXTRA!!
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayAgregarDatosJugador - antes create');

						var formPanelDatosJugador = Ext
								.create(
										'AdminEquiposFutbol.view.jugador.FormPanelDatosJugador',
										{
											border : false
										});
						/*-Solo para forma jugadores que tiene combo equipos*/
						formPanelDatosJugador
								.asignarRutaStoreComboEquipo('AdminEquiposAction_findAllEquipoSinJugadores.action');

						// ExtUtil.Conzole
						// .log('AdminJugadoresController -
						// displayAgregarDatosJugador - combo.xtype:'
						// + formPanelDatosJugador.down('combo').getXType());
						// ExtUtil.Conzole
						// .log('AdminJugadoresController -
						// displayAgregarDatosJugador - combo.xtype:'
						// + formPanelDatosJugador.items[5].getXType());

						ExtUtil.Conzole
								.log('AdminJugadoresController - displayAgregarDatosJugador - despues create');

						this.windowInteraccion = Ext
								.create(
										'Ext.window.Window',
										{
											title : 'Agregar Jugador',
											modal : true,
											closable : true,
											resizable : false,

											// items : {
											// xtype : 'formPanelDatosJugador',
											// border : false
											// },
											items : formPanelDatosJugador,
											buttons : [
													{
														itemId : 'window_AgregarJugador_button_Agregar',
														text : 'Agregar'
													},
													{
														itemId : 'window_AgregarJugador_button_Cancelar',
														text : 'Cancelar'
													} ]

										}).show();

					},// displayAgregarDatosJugador

					displayEditarDatosJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayEditarDatosJugador - entro');

						var selectedRecordsArray = this.getGridJugadores()
								.getView().getSelectionModel().getSelection();

						if (selectedRecordsArray.length <= 0) {

							Ext.Msg.show({
								title : 'Aviso',
								msg : 'Debe seleccionar un item del grid',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING
							});

						} else {

							var formPanelDatosJugador = Ext
									.create(
											'AdminEquiposFutbol.view.jugador.FormPanelDatosJugador',
											{
												border : true
											});

							/*-Solo para forma jugadores que tiene combo equipos*/
							formPanelDatosJugador
									.asignarRutaStoreComboEquipo('AdminEquiposAction_findAllEquipoSinJugadores.action');

							/*-Codigo que requiere la finalizacion de la carga del store*/
							formPanelDatosJugador.down('combo').store
									.on(
											'load',
											function(store) {

												ExtUtil.Conzole
														.log('AdminJugadoresController - displayEditarDatosJugador - combo.store - load');

												formPanelDatosJugador
														.setValuesFromJugadoresModel(selectedRecordsArray[0]);

											});

							this.windowInteraccion = Ext
									.create(
											'Ext.window.Window',
											{
												title : 'Editar Jugador',
												modal : true,
												closable : true,
												resizable : false,

												items : formPanelDatosJugador,
												buttons : [
														{
															itemId : 'window_EditarJugador_button_Editar',
															text : 'Editar'
														},
														{
															itemId : 'window_EditarJugador_button_Cancelar',
															text : 'Cancelar'
														} ]

											}).show();
						}

					},// displayEditarDatosJugador

					displayBorrarDatosJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayBorrarDatosJugador - entro');

						var selectedRecordsArray = this.getGridJugadores()
								.getView().getSelectionModel().getSelection();

						if (selectedRecordsArray.length <= 0) {

							// Ext.Msg.alert('Aviso',
							// 'Debe seleccionar un item del grid');
							Ext.Msg.show({
								title : 'Aviso',
								msg : 'Debe seleccionar un item del grid',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING
							});

						} else {
							var jugadoresStoreLocal = this
									.getStore('JugadoresStore');
							var panelDetalleJugadorLocal = this
									.getPanelDetalleJugador();

							Ext.Msg
									.show({
										title : 'Confirmar',
										msg : 'Desea borrar el jugador seleccionado?',
										buttonText : {
											yes : 'Si',
											cancel : 'Cancelar'
										},
										buttons : Ext.Msg.YESCANCEL,
										icon : Ext.Msg.QUESTION,
										fn : function(btn) {
											if (btn == 'yes') {
												ExtUtil.Conzole
														.log('AdminJugadoresController - displayBorrarDatosJugador - borrar..');

												var formPanelDatosJugador = Ext
														.create(
																'AdminEquiposFutbol.view.jugador.FormPanelDatosJugador',
																{
																	border : true
																});

												/*-Solo para forma jugadores que tiene combo equipos*/
												formPanelDatosJugador
														.asignarRutaStoreComboEquipo('AdminEquiposAction_findAllEquipoSinJugadores.action');

												/*-Codigo que requiere la finalizacion de la carga del store*/
												formPanelDatosJugador
														.down('combo').store
														.on(
																'load',
																function(store) {

																	formPanelDatosJugador
																			.setValuesFromJugadoresModel(selectedRecordsArray[0]);

																	Ext.Ajax
																			.request({
																				url : 'AdminJugadoresAction_remove.action',
																				params : formPanelDatosJugador
																						.getForm()
																						.getFieldValues(),
																				// form
																				// :
																				// "form1",
																				success : function(
																						response,
																						opts) {

																					if (Ext
																							.decode(response.responseText).success != null) {
																						Ext.Msg
																								.show({
																									title : 'Información',
																									msg : 'Los datos han sido borrados.',
																									buttons : Ext.Msg.OK,
																									icon : Ext.Msg.INFO,
																									fn : function(
																											btn) {
																									}
																								});
																						if (jugadoresStoreLocal.proxy.url != null) {
																							jugadoresStoreLocal
																									.load();
																						}
																						panelDetalleJugadorLocal
																								.updateLimpio();

																					} else {
																						Ext.MessageBox
																								.show({
																									title : 'Error',
																									msg : 'Ocurrio un error en el servidor.',
																									buttons : Ext.MessageBox.OK,
																									icon : Ext.MessageBox.ERROR
																								});
																					}

																				},
																				failure : function(
																						response,
																						opts) {
																					Ext.Msg
																							.show({
																								title : 'Error',
																								msg : 'El envio ajax tuvo errores.',
																								buttons : Ext.Msg.OK,
																								icon : Ext.Msg.ERROR
																							});

																				}
																			});

																});

											}
										}
									});

						}

					},// displayBorrarDatosJugador

					displayConsultarTodosResumenEstandar : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - displayConsultarTodosResumenEstandar - entro');

						var gridJugadores = this.getGridJugadores();
						var jugadoresStore = this.getStore('JugadoresStore');
						var panelEncabezadoJugadores = this
								.getPanelEncabezadoJugadores();

						this.windowInteraccion = Ext
								.create(
										'Ext.window.Window',
										{
											title : 'Confirmar',
											modal : true,
											closable : true,
											resizable : false,

											items : {

												xtype : 'panel',
												border : false,
												bodyPadding : 20,
												html : 'Desea consultar todos los jugadores con resumen estandar?'
														+ '<br>(Nombre,Apellido Paterno,Apellido Materno,Equipo)'

											},
											buttons : [
													{
														itemId : 'window_ConsultarTodosResumenEstandarJugadores_button_Aceptar',
														text : 'Aceptar'
													},
													{
														itemId : 'window_ConsultarTodosResumenEstandarJugadores_button_Cancelar',
														text : 'Cancelar'
													} ]

										}).show();

					},// displayConsultarTodosResumenEstandar

					generateReporteDetalleJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - generateReporteDetalleJugador - entro');

						var selectedRecordsArray = this.getGridJugadores()
								.getView().getSelectionModel().getSelection();

						if (selectedRecordsArray.length <= 0) {

							Ext.Msg.show({
								title : 'Aviso',
								msg : 'Debe seleccionar un item del grid',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING
							});

						} else {

							ExtUtil.Conzole
									.log('AdminJugadoresController - generateReporteDetalleJugador - reporte..');

							var peticion = './AdminJugadoresAction_reporteDetalleJugadorTxt.action?jugador.idJugador='
									+ selectedRecordsArray[0].get('idJugador');

							ExtUtil.Conzole
									.log('AdminJugadoresController - generateReporteDetalleJugador - response:'+peticion);

							//document.location.href = response;
							newWindow = window.open(peticion,'',
									'height=768,width=1024,scrollbars=yes,left=0,alwaysRaised=yes,menubar=yes,toolbar=no,location=no,resizable=yes');
					 		newWindow.resizeTo(screen.availWidth/2,screen.availHeight/2);
							//window.open('http://www.pageresource.com/jscript/jex5.htm','mywindow','width=400,height=200');

						}

					},// generateReporteDetalleJugador

					agregarDatosJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - agregarDatosJugador - entro');

						var formPanelDatosJugador = this.windowInteraccion
								.down("formPanelDatosJugador");
						if (formPanelDatosJugador.getForm().isValid()) {

							var windowInteraccionLocal = this.windowInteraccion;
							var jugadoresStoreLocal = this
									.getStore('JugadoresStore');
							var panelDetalleJugadorLocal = this
									.getPanelDetalleJugador();
							Ext.Ajax
									.request({
										url : 'AdminJugadoresAction_persist.action',
										params : formPanelDatosJugador
												.getForm().getFieldValues(),
										// form : formPanelDatosEquipo,
										success : function(response, opts) {

											if (Ext
													.decode(response.responseText).success != null) {
												Ext.Msg
														.show({
															title : 'Información',
															msg : 'Los datos han sido almacenados.',
															buttons : Ext.Msg.OK,
															icon : Ext.Msg.INFO,
															fn : function(btn) {
																windowInteraccionLocal
																		.close();
															}
														});
												if (jugadoresStoreLocal.proxy.url != null) {
													jugadoresStoreLocal.load();
												}
												panelDetalleJugadorLocal
														.updateLimpio();
											} else {
												Ext.MessageBox
														.show({
															title : 'Error',
															msg : 'Ocurrio un error en el servidor.',
															buttons : Ext.MessageBox.OK,
															icon : Ext.MessageBox.ERROR
														});
											}

										},
										failure : function(response, opts) {
											Ext.Msg
													.show({
														title : 'Error',
														msg : 'El envio ajax tuvo errores.',
														buttons : Ext.Msg.OK,
														icon : Ext.Msg.ERROR
													});
										}
									});

						} else {

							Ext.Msg.show({
								title : 'Error',
								msg : 'La forma tiene errores.',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});

						}

					},// agregarDatosJugador

					cancelarWindow : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - cancelarWindow - entro');

						this.windowInteraccion.close();

					},// cancelarWindow

					editarDatosJugador : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - editarDatosJugador - entro');

						var formPanelDatosJugador = this.windowInteraccion
								.down("formPanelDatosJugador");

						if (formPanelDatosJugador.getForm().isValid()) {

							var windowInteraccionLocal = this.windowInteraccion;
							var jugadoresStoreLocal = this
									.getStore('JugadoresStore');
							var panelDetalleJugadorLocal = this
									.getPanelDetalleJugador();

							Ext.Ajax
									.request({
										url : 'AdminJugadoresAction_merge.action',
										params : formPanelDatosJugador
												.getForm().getFieldValues(),
										// form : "form1",
										success : function(response, opts) {

											if (Ext
													.decode(response.responseText).success != null) {
												Ext.Msg
														.show({
															title : 'Información',
															msg : 'Los datos han sido editados.',
															buttons : Ext.Msg.OK,
															icon : Ext.Msg.INFO,
															fn : function(btn) {
																windowInteraccionLocal
																		.close();
															}
														});
												if (jugadoresStoreLocal.proxy.url != null) {
													jugadoresStoreLocal.load();
												}
												panelDetalleJugadorLocal
														.updateLimpio();
											} else {
												Ext.MessageBox
														.show({
															title : 'Error',
															msg : 'Ocurrio un error en el servidor.',
															buttons : Ext.MessageBox.OK,
															icon : Ext.MessageBox.ERROR
														});
											}

										},
										failure : function(response, opts) {
											Ext.Msg
													.show({
														title : 'Error',
														msg : 'El envio ajax tuvo errores.',
														buttons : Ext.Msg.OK,
														icon : Ext.Msg.ERROR
													});

										}
									});

						} else {

							Ext.Msg.show({
								title : 'Error',
								msg : 'La forma tiene errores.',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});

						}

					},// editarDatosJugador

					consultarTodosResumenEstandar : function(item, e) {
						ExtUtil.Conzole
								.log('AdminJugadoresController - consultarTodosResumenEstandar - entro');

						this.getGridJugadores().definirColumnasEstandar();
						this
								.getPanelEncabezadoJugadores()
								.updateConsulta(
										{
											"criterioConsultaTexto" : 'Todos con resumen estandar'
										});

						this.getStore('JugadoresStore').proxy.url = 'AdminJugadoresAction_findAllJugadores.action';

						this.getStore('JugadoresStore').load();

						this.windowInteraccion.close();
					}// consultarTodosResumenEstandar

				});
