Ext
		.define(
				'AdminEquiposFutbol.controller.AdminEquiposController',
				{
					extend : 'Ext.app.Controller',

					/*- can be used required */
					// requires : [ 'Ext.form.field.Time' ],
					windowInteraccion : null,
					stores : [ 'EquiposStore' ],

					models : [ 'EquipoModel' ],

					views : [ 'equipo.PanelEquipos',
							'equipo.PanelEncabezadoEquipos',
							'equipo.ToolbarEncabezadoEquipos',
							'equipo.GridEquipos', 'equipo.PanelDetalleEquipo',
							'equipo.FormPanelDatosEquipo' ],

					refs : [
							{
								ref : 'viewport',
								selector : 'viewport'
							},
							{
								ref : 'panelEncabezadoEquipos',
								selector : 'viewport > panelEquipos > panelEncabezadoEquipos'
							},
							{
								ref : 'gridEquipos',
								selector : 'viewport > panelEquipos > gridEquipos'
							},
							{
								ref : 'panelDetalleEquipo',
								selector : 'viewport > panelEquipos > panelDetalleEquipo'
							} ],

					init : function() {
						ExtUtil.Conzole
								.log('AdminEquiposController - init - entro');

						// this.getStore('EquiposStore').load();

						// ////////////////////////////////////////////////////////////
						// /inicio
						// toolbarPrincipal_menu_menuitem_Administrar_Equipos//
						// ////////////////////////////////////////////////////////////

						// '#menuitem_Administrar_Equipos'
						this
								.control({
									'menuitem[itemId=toolbarPrincipal_menu_menuitem_Administrar_Equipos]' : {
										click : this.displayResumenEquipos
									}
								});

						// /////////////////////////////////////////////////////////
						// /fin
						// toolbarPrincipal_menu_menuitem_Administrar_Equipos//
						// /////////////////////////////////////////////////////////

						// /////////////////////
						// /inicio gridEquipos//
						// /////////////////////

						this
								.control({
									'viewport > panelEquipos > gridEquipos dataview' : {
										itemclick : this.bindGridToPanel
									}
								});

						// //////////////////
						// /fin gridEquipos//
						// //////////////////

						// //////////////////////////////////
						// /inicio toolbarEncabezadoEquipos//
						// //////////////////////////////////

						this
								.control({
									'button[itemId=toolbarEncabezadoEquipos_button_Agregar]' : {
										click : this.displayAgregarDatosEquipo
									}
								});

						this
								.control({
									'button[itemId=toolbarEncabezadoEquipos_button_Editar]' : {
										click : this.displayEditarDatosEquipo
									}
								});

						this
								.control({
									'button[itemId=toolbarEncabezadoEquipos_button_Borrar]' : {
										click : this.displayBorrarDatosEquipo
									}
								});

						this
								.control({
									'menuitem[itemId=toolbarEncabezadoEquipos_Consultar_menu_menuitem_Todos]' : {
										click : this.displayConsultarTodosResumenEstandar
									}
								});

						this
								.control({
									'menuitem[itemId=toolbarEncabezadoEquipos_Reportes_menu_menuitem_DetalleEquipo_menu_menuitem_txt]' : {
										click : this.generateReporteDetalleEquipo
									}
								});

						// ///////////////////////////////
						// /fin toolbarEncabezadoEquipos//
						// ///////////////////////////////

						// //////////////////////////////
						// /inicio window_AgregarEquipo//
						// //////////////////////////////

						this
								.control({
									'button[itemId=window_AgregarEquipo_button_Agregar]' : {
										click : this.agregarDatosEquipo
									}
								});

						this
								.control({
									'button[itemId=window_AgregarEquipo_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// ///////////////////////////
						// /fin window_AgregarEquipo//
						// ///////////////////////////

						// /////////////////////////////
						// /inicio window_EditarEquipo//
						// /////////////////////////////

						this
								.control({
									'button[itemId=window_EditarEquipo_button_Editar]' : {
										click : this.editarDatosEquipo
									}
								});

						this
								.control({
									'button[itemId=window_EditarEquipo_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// //////////////////////////
						// /fin window_EditarEquipo//
						// //////////////////////////

						// /////////////////////////////
						// /inicio window_BorrarEquipo//
						// /////////////////////////////

						// //////////////////////////
						// /fin window_BorrarEquipo//
						// //////////////////////////

						// //////////////////////////////////////////////
						// /inicio window_ConsultarTodosResumenEstandar//
						// //////////////////////////////////////////////

						// NOTA: estos eventos podrian renombrarse como se hizo en AdminJugadoresController
						this
								.control({
									'button[itemId=window_ConsultarTodosResumenEstandar_button_Aceptar]' : {
										click : this.consultarTodosResumenEstandar
									}
								});

						this
								.control({
									'button[itemId=window_ConsultarTodosResumenEstandar_button_Cancelar]' : {
										click : this.cancelarWindow
									}
								});

						// ///////////////////////////////////////////
						// /fin window_ConsultarTodosResumenEstandar//
						// ///////////////////////////////////////////

					},// init

					displayResumenEquipos : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - displayResumenEquipos - entro');

						var panelEquipos = Ext
								.create('AdminEquiposFutbol.view.equipo.PanelEquipos');

						var panelCenter = this.getViewport().down(
								'panel[region=center]');
						this.getViewport().remove(panelCenter);
						this.getViewport().add({
							region : 'center',
							xtype : 'panelEquipos'
						});

					},// displayResumenEquipos

					bindGridToPanel : function(grid, record) {
						ExtUtil.Conzole
								.log('AdminEquiposController - bindGridToPanel - entro');
						ExtUtil.Conzole
								.log('AdminEquiposController - bindGridToPanel - record.data:'
										+ record.data);

						this.getPanelDetalleEquipo().updateDetail(record.data);
					},// bindGridToPanel

					displayAgregarDatosEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - displayAgregarDatosEquipo - entro');

						this.windowInteraccion = Ext
								.create(
										'Ext.window.Window',
										{
											title : 'Agregar Equipo',
											modal : true,
											closable : true,
											resizable : false,

											items : {

												xtype : 'formPanelDatosEquipo',
												border : false
											},
											buttons : [
													{
														itemId : 'window_AgregarEquipo_button_Agregar',
														text : 'Agregar'
													},
													{
														itemId : 'window_AgregarEquipo_button_Cancelar',
														text : 'Cancelar'
													} ]

										}).show();

					},// displayAgregarDatosEquipo

					displayEditarDatosEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - displayEditarDatosEquipo - entro');

						var selectedRecordsArray = this.getGridEquipos()
								.getView().getSelectionModel().getSelection();

						if (selectedRecordsArray.length <= 0) {

							Ext.Msg.show({
								title : 'Aviso',
								msg : 'Debe seleccionar un item del grid',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING
							});

						} else {

							var formPanelDatosEquipo = Ext
									.create(
											'AdminEquiposFutbol.view.equipo.FormPanelDatosEquipo',
											{
												border : true
											});

							// si funciona!
							// formPanelDatosEquipo
							// .loadRecord(selectedRecordsArray[0]);

							formPanelDatosEquipo
									.setValuesFromEquiposModel(selectedRecordsArray[0]);

							this.windowInteraccion = Ext
									.create(
											'Ext.window.Window',
											{
												title : 'Editar Equipo',
												modal : true,
												closable : true,
												resizable : false,

												items : formPanelDatosEquipo,
												buttons : [
														{
															itemId : 'window_EditarEquipo_button_Editar',
															text : 'Editar'
														},
														{
															itemId : 'window_EditarEquipo_button_Cancelar',
															text : 'Cancelar'
														} ]

											}).show();
						}

					},// displayEditarDatosEquipo

					displayBorrarDatosEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - displayBorrarDatosEquipo - entro');

						var selectedRecordsArray = this.getGridEquipos()
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
							var equiposStoreLocal = this
									.getStore('EquiposStore');
							var panelDetalleEquipoLocal = this
									.getPanelDetalleEquipo();

							Ext.Msg
									.show({
										title : 'Confirmar',
										msg : 'Desea borrar el equipo seleccionado?'
												+ '<br>(Borrara tambien a los elementos asociados)',
										buttonText : {
											yes : 'Si',
											cancel : 'Cancelar'
										},
										buttons : Ext.Msg.YESCANCEL,
										icon : Ext.Msg.QUESTION,
										fn : function(btn) {
											if (btn == 'yes') {
												ExtUtil.Conzole
														.log('AdminEquiposController - displayBorrarDatosEquipo - borrar..');

												var formPanelDatosEquipo = Ext
														.create(
																'AdminEquiposFutbol.view.equipo.FormPanelDatosEquipo',
																{
																	border : true
																});

												// si funciona!
												// formPanelDatosEquipo
												// .loadRecord(selectedRecordsArray[0]);

												formPanelDatosEquipo
														.setValuesFromEquiposModel(selectedRecordsArray[0]);

												Ext.Ajax
														.request({
															url : 'AdminEquiposAction_remove.action',
															params : formPanelDatosEquipo
																	.getForm()
																	.getFieldValues(),
															// form : "form1",
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
																	if (equiposStoreLocal.proxy.url != null) {
																		equiposStoreLocal
																				.load();
																	}
																	panelDetalleEquipoLocal
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

											}
										}
									});

						}

					},// displayBorrarDatosEquipo

					displayConsultarTodosResumenEstandar : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - displayConsultarTodosResumenEstandar - entro');

						var gridEquipos = this.getGridEquipos();
						var equiposStore = this.getStore('EquiposStore');
						var panelEncabezadoEquipos = this
								.getPanelEncabezadoEquipos();

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
												html : 'Desea consultar todos los equipos con resumen estandar?'
														+ '<br>(Nombre,Apodo,Propietario,Director T&eacute;cnico)'

											},
											buttons : [
													{
														itemId : 'window_ConsultarTodosResumenEstandar_button_Aceptar',
														text : 'Aceptar'
													},
													{
														itemId : 'window_ConsultarTodosResumenEstandar_button_Cancelar',
														text : 'Cancelar'
													} ]

										}).show();

					},// displayConsultarTodosResumenEstandar

					generateReporteDetalleEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - generateReporteDetalleEquipo - entro');

						var selectedRecordsArray = this.getGridEquipos()
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
									.log('AdminEquiposController - generateReporteDetalleJugador - reporte..');

							var peticion = './AdminEquiposAction_reporteDetalleEquipoSinJugadoresTxt.action?equipo.idEquipo='
									+ selectedRecordsArray[0].get('idEquipo');

							ExtUtil.Conzole
									.log('AdminEquiposController - generateReporteDetalleJugador - response:'
											+ peticion);

							// document.location.href = response;
							newWindow = window
									.open(
											peticion,
											'',
											'height=768,width=1024,scrollbars=yes,left=0,alwaysRaised=yes,menubar=yes,toolbar=no,location=no,resizable=yes');
							newWindow.resizeTo(screen.availWidth / 2,
									screen.availHeight / 2);
							// window.open('http://www.pageresource.com/jscript/jex5.htm','mywindow','width=400,height=200');

						}

					},// generateReporteDetalleEquipo

					agregarDatosEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - agregarDatosEquipo - entro');

						var formPanelDatosEquipo = this.windowInteraccion
								.down("formPanelDatosEquipo");
						if (formPanelDatosEquipo.getForm().isValid()) {

							var windowInteraccionLocal = this.windowInteraccion;
							var equiposStoreLocal = this
									.getStore('EquiposStore');
							var panelDetalleEquipoLocal = this
									.getPanelDetalleEquipo();
							Ext.Ajax
									.request({
										url : 'AdminEquiposAction_persist.action',
										params : formPanelDatosEquipo.getForm()
												.getFieldValues(),
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
												if (equiposStoreLocal.proxy.url != null) {
													equiposStoreLocal.load();
												}
												panelDetalleEquipoLocal
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

					},// agregarDatosEquipo

					cancelarWindow : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - cancelarWindow - entro');

						this.windowInteraccion.close();

					},// cancelarWindow

					editarDatosEquipo : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - editarDatosEquipo - entro');

						var formPanelDatosEquipo = this.windowInteraccion
								.down("formPanelDatosEquipo");

						if (formPanelDatosEquipo.getForm().isValid()) {

							var windowInteraccionLocal = this.windowInteraccion;
							var equiposStoreLocal = this
									.getStore('EquiposStore');
							var panelDetalleEquipoLocal = this
									.getPanelDetalleEquipo();

							Ext.Ajax
									.request({
										url : 'AdminEquiposAction_merge.action',
										params : formPanelDatosEquipo.getForm()
												.getFieldValues(),
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
												if (equiposStoreLocal.proxy.url != null) {
													equiposStoreLocal.load();
												}
												panelDetalleEquipoLocal
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

					},// editarDatosEquipo

					consultarTodosResumenEstandar : function(item, e) {
						ExtUtil.Conzole
								.log('AdminEquiposController - consultarTodosResumenEstandar - entro');

						this.getGridEquipos().definirColumnasEstandar();
						this
								.getPanelEncabezadoEquipos()
								.updateConsulta(
										{
											"criterioConsultaTexto" : 'Todos con resumen estandar'
										});

						// this.getStore('EquiposStore').proxy.url =
						// 'data/equipos.json';
						this.getStore('EquiposStore').proxy.url = 'AdminEquiposAction_findAllEquipoSinJugadores.action';
						this.getStore('EquiposStore').load();

						this.windowInteraccion.close();
					}// consultarTodosResumenEstandar

				});
