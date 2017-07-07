<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.squirtlesquad.obj.Pessoa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <meta charset="UTF-8" />
        <title>Bem vindo ao Squad - Gerente</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/select2.min.css" type="text/css">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/select2.full.min.js"></script>
        <script type="text/javascript" src="js/gerente.js"></script>
        <style type="text/css">
            ${demo.css}
        </style>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
                $(".select2").select2();
            });

            function myFunction() {
                // Declare variables 
                var input, filter, table, tr, td, i;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function exibir_ocultar() {
                var valor = $("#promocao").val();

                if (valor == 'Não') {
                    $("#isPromocao").hide();
                    $("#dtPromocao").hide();
                    $("#qtdPromocao").hide();
                } else {
                    $("#isPromocao").show();
                    $("#dtPromocao").show();
                    $("#qtdPromocao").show();
                }
            }
            ;

            function showCadProduto() {
                $('#cadProduto').modal('show');
            }

            function excluirLin() {
                if (confirm("Tem certeza que deseja remover esse produto?")) {
                    alert("Feito!");
                }
            }

            function estoqueProdutos() {
                $("#produto_navbar").click();
                $("#estoque_prods").click();
                var newResult = $("#notify_count")[0].innerHTML;
                if (newResult > 0) {
                    $("#notify_count")[0].innerHTML = $("#notify_count")[0].innerHTML - 1;
                }
            }

            function produtosVencidos() {
                $("#produto_navbar").click();
                $("#prods_vencidos").click();
                var newResult = $("#notify_count")[0].innerHTML;
                if (newResult > 0) {
                    $("#notify_count")[0].innerHTML = $("#notify_count")[0].innerHTML - 1;
                }
            }
        </script>
    </header>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse navbar-transparente">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed btn-lg" data-toggle="collapse" data-target="#barranavegacao">
                        <span class="glyphicon glyphicon-th-list" style="color:#fff" aria-hidden="true"></span>
                    </button>
                    <a href="gerente.html" class="navbar-brand">
                        <img src="imagens/logo.png" class="img-logo">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="barranavegacao">
                    <ul class="nav navbar-nav navbar-right">
                        <li role="presentation" id="prod_navbar" class="active">
                            <a id="produto_navbar" href="#produtos" role="tab" data-toggle="tab">Produtos</a>
                        </li>
                        <li role="presentation" id="rel_navbar">
                            <a href="#relatorio" role="tab" data-toggle="tab">Relatórios</a>
                        </li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
                    </ul>
                    <div class="nav navbar-nav navbar-right">
                        <div class="dropdown">
                            <button class="btn btn-primary btn-md btn-link" style="font-size:24px; color: #428bca; margin-top: 10px;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                <span class="glyphicon glyphicon-bell"></span>
                            </button>
                            <span id="notify_cdount" class="badge badge-notify">3</span>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <c:forEach var="prodPraVencer" items="${listaProdutosPraVencer}">
                                    <li onclick="produtosVencidos();">
                                        <a class="notify_link">
                                            <label>${prodPraVencer.nome}</label> <span class="label label-danger">Vencido</span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container conteudo">
            <div class="row">
                <!-- Conteudo -->
                <div role="tabpanel">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="produtos">
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="nav nav-tabs">
                                        <li role="presentation" class="active">
                                            <a href="#prod_produtos" role="tab" data-toggle="tab">Produtos</a>
                                        </li>
                                    </ul>
                                    <div role="tabpanel">
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="prod_produtos">
                                                <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="container" style="padding-top: 30px"> 
                                                                <div class="col-md-8" >
                                                                    <input  type="text" id="myInput" onkeyup="myFunction()" placeholder="Pesquisar...">
                                                                </div>
                                                                <div class="col-md-4" align="right">
                                                                    <button class="btn btn-success" data-toggle="modal" data-target="#cadProduto">Cadastrar produto</button>
                                                                </div>
                                                            </div>
                                                            <div class="container"> 
                                                                <div class="col-md-12">
                                                                    <table id="myTable" class="table table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Imagem</th>
                                                                                <th>Nome</th>
                                                                                <th>Descrição</th>
                                                                                <th>Valor</th>
                                                                                <th>Quantidade por unidade</th>
                                                                                <th>Unidade de Medida</th>
                                                                                <th>Validade</th>
                                                                                <th>Promoção</th>
                                                                                <th>% Promoção</th>
                                                                                <th>Qtd mínima para desconto</th>
                                                                                <th></th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:forEach var="prod" items="${listaProdutos}">
                                                                                <tr>
                                                                                    <td><img src="imagens/${prod.nome}.png" class="img-responsive miniatureImage" ></td>
                                                                                    <td>${prod.nome}</td>
                                                                                    <td>${prod.descricao}</td>
                                                                                    <td>${prod.valorUnidade}</td>
                                                                                    <td>${prod.quantidade}</td>
                                                                                    <td>${prod.unidadeMedida}</td>
                                                                                    <td>${prod.dataValidade}</td>
                                                                                    <td>${prod.promocao}</td>
                                                                                    <td>${prod.porcentagemPromocao}</td>
                                                                                    <td>${prod.quantidadeMinDesconto}</td>
                                                                                    <td class="text-center">
                                                                                        <button type="button" class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Editar" onclick="showCadProduto(${prod.id})">
                                                                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                                                                        </button>
                                                                                        <a href="ExcluirProduto?action=delete&id=${prod.id}" name = "Excluir" type="button" class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Excluir">
                                                                                            <i class="fa fa-times"></i>
                                                                                        </a>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="relatorio">
                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="nav nav-tabs">
                                        <li role="presentation" class="active">
                                            <a href="#power_bi" role="tab" data-toggle="tab">Dashboard</a>
                                        </li>
                                    </ul>
                                    <div role="tabpanel">
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="power_bi">
                                                <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <iframe width="1180" height="720" src="https://app.powerbi.com/view?r=eyJrIjoiZTAzNTA1NTQtZjllMi00ZjMzLThhNTEtODM4N2JjZjZhYjliIiwidCI6IjYxZjAyODQ3LTEwYmUtNDVjYi1hMGQ3LTUyMzE1M2FlZDU3NiJ9" frameborder="0" allowFullScreen="true"></iframe>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fim conteudo -->
            </div>
        </div>
        <footer id="rodape">
            <div class="container">
                <div class="row">
                    <div class="col-md-6" style="margin-top: 25px; color: white;">
                        <label>Turtle Squad</label>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Modal -->
        <div class="modal fade" id="cadProduto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Cadastrar Produto</h4>
                    </div>
                    <form id="formGerente" method="post" action="${pageContext.request.contextPath}/InserirProduto" role = "form"> 
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="nome_produto">Nome produto:</label>
                                    <input id="nome_produto" name="nome_produto" placeholder="ex: Maçã" type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="descricao">Descrição:</label>
                                    <input id="descricao" name="descricao" placeholder="ex: Sabor de RS" type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label class="control-label">Selecione uma imagem:</label>
                                    <input id="image_produto" name="image_produto" type="file" accept="image/*" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="qtd_produto">Quantidade por Unidade:</label>
                                    <input id="qtd_produto" name="qtd_produto" placeholder="ex: 2" type="number" min="1" class="form-control" />
                                </div>
                                <div class="col-md-6">
                                    <label for="unMedida_produto">Unidade de medida:</label>
                                    <input id="unMedida_produto" name="unMedida_produto" placeholder="ex: KG, unidade" type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="valor">Valor:</label>
                                    <input id="valor" name="valor" placeholder="0.00" type="number" class="form-control" />
                                </div>
                                <div class="col-md-6">
                                    <label for="validade">Validade:</label>
                                    <input id="validade" name="validade" type="date" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="qtd_estoque">Quantidade em estoque:</label>
                                    <input id="qtd_estoque" name="qtd_estoque" min="0" type="number" class="form-control" />
                                </div>
                                <div class="col-md-6">
                                    <label for="qtd_min_estoque">Quantidade min para desconto:</label>
                                    <input id="qtd_min_estoque" name="qtd_min_estoque" min="0" type="number" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label for="promocao">Promoção:</label>
                                    <select id="promocao" name="promocao" class="form-control" onchange="exibir_ocultar()">
                                        <option>N</option>
                                        <option>S</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row" id="isPromocao" style="display: none;">
                                <div class="col-md-4">
                                    <label for="percent_promocao">% Promoção:</label>
                                    <input id="percent_promocao" name="percent_promocao" type="number" min="1" max="99" class="form-control" />
                                </div>
                                <div class="col-md-4">
                                    <label for="qtd_min_promocao">Quantidade Mínima:</label>
                                    <input id="qtd_min_promocao" name="qtd_min_promocao" type="number" min="1" class="form-control" />
                                </div>
                                <div class="col-md-4">
                                    <label for="validade_promocao">Validade Promoção:</label>
                                    <input id="validade_promocao" name="validade_promocao" type="date" class="form-control" />
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Cadastrar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>