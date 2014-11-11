<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba AJAX con ExtJS</title>

<link rel="stylesheet" type="text/css"
	href="./js/frameworks/ext-5.0.1-gpl/ext-5.0.1/build/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" />
<script type="text/javascript"
	src="./js/frameworks/ext-5.0.1-gpl/ext-5.0.1/build/ext-all.js"></script>
<script type="text/javascript"
	src="./js/frameworks/ext-5.0.1-gpl/ext-5.0.1/build/packages/ext-theme-classic/build/ext-theme-classic.js"></script>



<script type="text/javascript">

	Ext
			.onReady(function() {

				Ext.get('completar con referencia a boton de bloque alert!!').on(
						'click',
						function(e) {
					        Ext.MessageBox.alert('El titulo', 'Hola querido y odiado DF!!');
						});

				Ext.get('completar con referencia a boton de bloque ajax1!!').on('click', function(e) {

					Ext.Ajax.request({
						url : 'servidorAJAX.jsp',
						form : "form1",
						success : function(response, opts) {
							alert(response.responseText);
						},
						failure : function(response, opts) {
							alert("error");
						}
					});

				});

				Ext
						.get('completar con referencia a boton de bloque ajax2!!')
						.on(
								'click',
								function(e) {
									var img = document
											.getElementById('ajaxImg1');
									img.style.display = "inline";
									alert("en proceso..");
									Ext.Ajax
											.request({
												url : 'servidorAJAX.jsp',
												form : "form2",
												//params : Ext.get('form2').getForm().getValues(),
												success : function(response,
														opts) {
													//alert(response.responseText);
													document
															.getElementById("ajaxContenido1").innerHTML = response.responseText;
												},
												failure : function(response,
														opts) {
													alert("error");
												}
											});
									img.style.display = "none";
								});

			});
</script>

</head>
<body>

	<h1>Prueba AJAX con ExtJS</h1>

	<br />
	<br />

	<h2>Alert</h2>
	Standard alert message dialog. &nbsp;
	<button id="button1">Show</button>


	<br />
	<br />

	<h2>Ajax1</h2>
	<form id="form1">
		Activar AJAX-><input type="button" id="ajax1" value="ajax" />
	</form>


	<br />
	<br />

	<h2>Ajax2</h2>
	<form id="form2">
		Datos a enviar:<input type="text" name="valor1"> <br />
		Activar AJAX-><input type="button" id="ajax2" value="ajax" /> <img
			id="ajaxImg1" style="display: none;" src="spinner.gif" /> <br /> <span
			id="ajaxContenido1" style="background-color: #D3D3D3;"></span>
	</form>

</body>
</html>