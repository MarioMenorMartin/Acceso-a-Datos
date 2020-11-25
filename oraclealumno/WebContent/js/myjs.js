$(document).ready(function() {
    console.log('ready');
    init();
});

function init(){
   onshowdeletealu();
   onshownewmail();
}

function onshowdeletealu(){
	$('#deletealumno').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var nombre = button.data('nombre')
	  var dni = button.data('dni')
	  var modal = $(this)
	  modal.find('.modal-body span').text(nombre)
	  modal.find('.modal-footer a').attr("href", "Controller?op=deletealumno&dni="+dni);
	})
}
