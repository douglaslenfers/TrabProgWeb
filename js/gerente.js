$(document).ready(function() {
    $("#formGerente").validate({
        rules: {
            nome_produto: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            image_produto: {
                required: true,
                accept: "image/jpeg, image/pjpeg"
            },
            qtd_produto: {
                required: true,
                min: 1,
                number: true
            },
            unMedida_produto: {
                required: true
            },
            valor: {
                required: true,
                min: 1,
                number: true
            },
            validade: {
                required: true
            },
            percent_promocao: {
                number: true,
                min: 1,
                max: 99
            },
            qtd_min_promocao: {
                number: true,
                min: 1
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

    $("#formGerente").submit(function() {
        event.preventDefault();
        if ($("#formGerente").valid()) {
            alert("Sucesso");
        } else {
            return;
        }
    });
});