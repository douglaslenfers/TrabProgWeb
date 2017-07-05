$(document).ready(function() {
    $("#formAdmin").validate({
        rules: {
            nome: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            email: {
                required: true,
                email: true
            },
            senha: {
                required: true,
                minlength: 5
            },
            confSenha: {
                required: true,
                minlength: 5,
                equalTo: "#senha"
            },
            perfil: {
                required: true
            }            
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });

    jQuery.extend(jQuery.validator.messages, {
        required: "Esse campo é obrigatório.",
        remote: "Arrume esse campo.",
        email: "Email inválido.",
        url: "URL inválida.",
        date: "Data inválida.",
        dateISO: "Data (ISO) inválida.",
        number: "Número inválido.",
        digits: "Apenas dígitos.",
        creditcard: "Cartão de crédito inválido.",
        equalTo: "Esse campo deve ser igual a Senha.",
        accept: "Extensão não permitida.",
        maxlength: jQuery.validator.format("No máximo {0} caracteres."),
        minlength: jQuery.validator.format("No mínimo {0} caracteres."),
        rangelength: jQuery.validator.format("Valor permitido de {0} à {1} caracteres."),
        range: jQuery.validator.format("Insira um valor entre {0} e {1}."),
        max: jQuery.validator.format("Insira um valor menor ou igual a {0}."),
        min: jQuery.validator.format("Insira um valor maior ou igual a {0}.")
    });

    $("#formAdmin").submit(function() {
        event.preventDefault();
        if ($("#formAdmin").valid()) {
            alert("Sucesso");
        } else {
            return;
        }
    });
});