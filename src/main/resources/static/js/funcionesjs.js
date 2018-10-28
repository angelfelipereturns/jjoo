/**
 * Funciones javascript para la aplicación jjoo
 */

$(document).ready(function(){
	
	$('.btn-borrar').each(function(){
		$(this).on('click', function(event){
			var respuesta = confirm("Se va a borrar la Sede. ¿Deseas continuar?");
			if (respuesta==false) {
				event.preventDefault();
				return false;
			} 
		});
	});
	
	$('input[id="ciudad.nombreCiudad"]').on('blur', function(){
		var texto = $(this).val();
		if(texto.length==1){
			texto += "XX";
		}
		else if(texto.length==2){
			texto += "X";
		}
		$(this).val(texto);
	});
	
	$('input[id="ciudad.pais.nombrePais"]').on('blur', function(){
		var texto = $(this).val();
		if(texto.length==1){
			texto += "XX";
		}
		else if(texto.length==2){
			texto += "X";
		}
		$(this).val(texto);
	});
	
	$('input[id="ciudad.pais.codigo_pais"]').on('blur', function(){
		var texto = $(this).val();
		if(texto.length==1){
			texto += "X";
		}
		$(this).val(texto);
	});
	
    $('#volver').on('click', function(){
    	window.history.back();
    });

});