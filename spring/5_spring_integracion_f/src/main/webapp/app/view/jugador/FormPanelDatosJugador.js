Ext
		.define(
				'AdminEquiposFutbol.view.jugador.FormPanelDatosJugador',
				{
					extend : 'Ext.form.Panel',
					alias : 'widget.formPanelDatosJugador',

					// url:'save-form.php',
					// frame:true,
					bodyStyle : 'padding:5px 5px 0',
					defaultType : 'textfield',

					items : [ {
						fieldLabel : '*Nombre',
						name : 'jugador.nombre',
						allowBlank : false
					}, {
						fieldLabel : '*Apellido Paterno',
						name : 'jugador.apellidoPaterno',
						allowBlank : false
					}, {
						fieldLabel : 'Apellido Materno',
						name : 'jugador.apellidoMaterno'
					}, {
						fieldLabel : '*Fecha de Nacimiento',
						name : 'fechaNacimiento',
						xtype : 'datefield',
						// emptyText: 'aaaa/mm/dd',
						// maskRe: /[0-9\-]/,
						format : 'Y-m-d',
						altFormats : 'Y-m-d',
						allowBlank : false
					}, {
						fieldLabel : '*Numero Camiseta',
						name : 'jugador.numeroCamiseta',
						allowBlank : false
					}, {
						fieldLabel : '*Equipo',
						name : 'jugador.equipo.idEquipo',
						allowBlank : false,
						// queryMode : 'local',
						xtype : 'combo',
						displayField : 'nombre',
						valueField : 'idEquipo'
					}, {
						name : 'jugador.idJugador',
						xtype : 'hiddenfield',
						value : '0'
					}

					],

					setValuesFromJugadoresModel : function(jugadoresModel) {

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - setValuesFromJugadoresModel - entro');

						var values = {
							"jugador.nombre" : jugadoresModel.get('nombre'),
							"jugador.apellidoPaterno" : jugadoresModel
									.get('apellidoPaterno'),
							"jugador.apellidoMaterno" : jugadoresModel
									.get('apellidoMaterno'),
							"fechaNacimiento" : jugadoresModel
									.get('fechaNacimiento'),
							"jugador.numeroCamiseta" : jugadoresModel
									.get('numeroCamiseta'),
							// "jugador.equipo.idEquipo" : jugadoresModel
							// .getEquipoModel().get('idEquipo'),
							"jugador.idJugador" : jugadoresModel
									.get('idJugador')
						};
						this.getForm().setValues(values);

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - setValuesFromJugadoresModel - idEquipo:'
										+ jugadoresModel.getEquipoModel().get(
												'idEquipo'));
						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - setValuesFromJugadoresModel - getXType:'
										+ this.down('combo').getXType());

						var combo = this.down('combo');

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - '
										+ 'setValuesFromJugadoresModel - combo.store.getCount:'
										+ combo.store.getCount());

						combo.setValue(jugadoresModel.getEquipoModel().get(
								'idEquipo'));

						// combo.store
						// .on(
						// 'load',
						// function(store) {
						//
						// ExtUtil.Conzole
						// .log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador
						// - '
						// + 'setValuesFromJugadoresModel -
						// combo.store.getCount:'
						// + combo.store
						// .getCount());
						//
						// combo.setValue(jugadoresModel
						// .getEquipoModel().get(
						// 'idEquipo'));
						//
						// });

					},

					/**
					 * Se puede mejorar recibiendo rutaStoreComboEquipo. El
					 * problema es referenciar items[combo]?? para setar
					 * rutaStoreComboEquipo
					 */
					initComponent : function() {

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - initComponent - entro');

						// var equiposStore = Ext
						// .create('AdminEquiposFutbol.store.EquiposStore');
						// equiposStore.proxy.url =
						// 'AdminEquiposAction_findAllEquipoSinJugadores.action';
						// equiposStore.load();

						// ??
						// ExtUtil.Conzole
						// .log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador
						// - initComponent - combo.xtype:'
						// + this.down('combo').getXType());

						// ExtUtil.Conzole
						// .log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador
						// - initComponent - combo.xtype:'
						// + this.down('item').getXType());
						// ExtUtil.Conzole
						// .log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador
						// - initComponent - combo.xtype:'
						// + this.items.item[5].getXType());

						// this.down('combo').store = equiposStore;

						// call the superclass's initComponent implementation
						this.callParent(arguments);
					},

					/**
					 * Lo mejor seria quitar este metodo y dejar la misma logica
					 * dentro de contructor o initComponent
					 */
					asignarRutaStoreComboEquipo : function(rutaStoreComboEquipo) {

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - asignarRutaStoreComboEquipo - entro');

						var equiposStore = Ext
								.create('AdminEquiposFutbol.store.EquiposStore');
						equiposStore.proxy.url = rutaStoreComboEquipo;

						equiposStore.load();

						// var states = Ext.create('Ext.data.Store', {
						// fields: ['abbr', 'name'],
						// data : [
						// {"abbr":"AL", "name":"Alabama"},
						// {"abbr":"AK", "name":"Alaska"},
						// {"abbr":"AZ", "name":"Arizona"}
						// //...
						// ]
						// });

						//this.down('combo').store = equiposStore;
						this.down('combo').setStore(equiposStore); //Actualizacion ExtJS5

						ExtUtil.Conzole
								.log('AdminEquiposFutbol.view.jugador.FormPanelDatosJugador - asignarRutaStoreComboEquipo - store.getCount:'
										+ this.down('combo').store.getCount());

					}

				});