$('#exampleModal').on('show.bs.modal', function (event) {
    alert("modal.js")
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('object-id') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.my').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
})