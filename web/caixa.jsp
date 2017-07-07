<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <header>
        <meta charset="UTF-8" />
        <title>Bem vindo ao Squad - Caixa</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/select2.min.css" type="text/css">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/select2.full.min.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
                $(".select2").select2({
                    placeholder: "Selecione um produto",
                    theme: "classic"
                });
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
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function showAlterarQtd() {
                $('#alterarQtd').modal('show');
            }

            function excluirLin() {
                if (confirm("Tem certeza que deseja excluir esse produto?")) {
                    alert("Feito!");
                }
            }

            function limparCompras() {
                if (confirm("Tem certeza que deseja limpar as compras?")) {
                    alert("Feito!");
                }
            }

            function finalizarCompra() {
                if (confirm("Finalizar compra?")) {
                    alert("Ok.");
                }
            }

            function adicionarProduto() {
                var produto = $("#produto").val();
                var quantidade = $("#quantidade").val();
                if (produto != "") {
                    if (quantidade != "") {
                        alert("Produto: " + produto + ".\nQuantidade: " + quantidade + ".");
                    } else {
                        alert("Preencha uma quantidade válida.");
                    }
                } else {
                    alert("Escolha pelo menos um produto");
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
                    <a href="caixa.html" class="navbar-brand">
                        <img src="imagens/logo.png" class="img-logo">
                    </a>
                </div>
                <div class="collapse navbar-collapse" id="barranavegacao">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container conteudo">
            <div class="row">
                <!-- Conteudo -->
                <div class="col-md-8 col-md-offset-2 col-lg-12 col-lg-offset-0">
                    <div role="tabpanel">
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="produtos">
                                <div class="container " style="padding-top: 30px"> 
                                    <form id="formVenda" method="post" action="${pageContext.request.contextPath}/AdicionarVenda" role = "form">
                                        <div class="col-md-8 form-inline">
                                            <div class="form-group">
                                                <label for="produto">Produto:</label>
                                                <select name = "produto" id="produto" class="form-control select2" style="width: 250px">

                                                    <c:forEach var="p" items="${listaProduto}">
                                                        <option value=${p.id}>${p.nome}</option>
                                                    </c:forEach>

                                                </select>    
                                            </div>
                                            <label for="example-number-input" class="col-2 col-form-label">Quantidade</label>
                                            <input class="form-control" type="number" min="1" name= "quantidade" id="quantidade" style="width: 70px">
                                        </div>
                                        <div class="col-md-4" align="right">
                                            <div class="form-group">
                                                <button class="btn btn-primary" type="submit">Adicionar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="container"> 
                                    <div class="col-md-12">
                                        <table id="myTable" class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Imagem</th>
                                                    <th>Produto</th>
                                                    <th>Quantidade</th>
                                                    <th>Valor por Unidade</th>
                                                    <th>Valor</th>
                                                    <th>% Desconto</th>
                                                    <th>Desconto</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody >
                                                <c:forEach var="item" items="${lista}">
                                                    <tr id="${item.nome}_${item.quantidade}">
                                                        <td><img src="imagens/${item.nome}.png" class="img-responsive miniatureImage"></td>
                                                        <td>${item.nome}</td>
                                                        <td>${item.quantidadeVendida}</td>
                                                        <td>${item.valorUnidade}</td>
                                                        <td>${item.valorUnidade * item.quantidadeVendida}</td>
                                                        <td>${item.porcentagemPromocao}</td>
                                                        <td>${item.valorUnidade * item.quantidadeVendida * item.porcentagemPromocao}</td>
                                                        <td class="text-center">
                                                            <a href="AdicionarVenda?action=delete&id=${item.id}" type="button" class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Excluir">
                                                                <i class="fa fa-times"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div> 
                            </div>
                            <div role="tabpanel" class="tab-pane" id="relatorio">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-12  texto-capa">
                                            <div id="container2" style="min-width: 30px; height: 400px; margin: 0 auto"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container"> 
                        <div class="col-md-6" >
                        </div>
                        <div class="col-md-6" align="right">
                            <div class="form-group">

                                <a href="AdicionarVenda?action=limpar" name = "Excluir" type="button" class="btn btn-danger" data-toggle="modal">Limpar</a>
                                <a href="AdicionarVenda?action=finalizar" tname = "Excluir" type="button" class="btn btn-primary" data-toggle="modal">Finalizar Compra</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fim conteudo -->
        </div>
        <footer id="rodape">
            <div class="container">
                <div class="row">
                    <div class="col-md-6" style="margin-top: 25px; color: white;">
                        <label>Squad Turtle</label>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Modal -->
        <div class="modal fade" id="alterarQtd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Alterar Quantidade</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <label for="nome">Nome produto:</label>
                                <input id="nome" value='Maçâ' disabled type="text" class="form-control" />
                            </div>
                        </div>
                        <br />
                        <div class="row">
                            <div class="col-md-5">
                                <label for="nome">Quantidade por Unidade:</label>
                            </div>
                            <div class="col-md-2">
                                <input id="nome" value='5' type="number" class="form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Editar</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>