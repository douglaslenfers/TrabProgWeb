<%-- 
    Document   : admin
    Created on : Jul 5, 2017, 8:25:07 AM
    Author     : Douglas
--%>
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
        <title>Bem vindo ao Squad - Admin</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/select2.min.css" type="text/css">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/select2.full.min.js"></script>
        <script type="text/javascript" src="js/admin.js"></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
                $(".select2").select2({
                    placeholder: "Selecione um perfil",
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

            function showCadUsuario() {
                $('#cadUsuario').modal('show');
            }

            function excluirLin() {
                if (confirm("Tem certeza que deseja excluir esse usuário?")) {
                    document.form[]
                    alert("Feito!");
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
                    <a href="admin.jsp.html" class="navbar-brand">
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
                                <div class="container" style="padding-top: 30px"> 
                                    <div class="col-md-8" >
                                        <input  type="text" id="myInput" onkeyup="myFunction()" placeholder="Pesquisar...">
                                    </div>
                                    <div class="col-md-4" align="right">
                                        <button class="btn btn-success" data-toggle="modal" data-target="#cadUsuario">Cadastrar Usuário</button>
                                    </div>
                                </div>
                                <div class="container"> 
                                    <div class="col-md-12">
                                        
                                        <table id="myTable" class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Usuário</th>
                                                    <th>Perfil</th>
                                                    <th>Senha</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach var="p" items="${listaPessoa}">
                                                
                                                <tr>
                                                    <td>${p.nome}</td>
                                                    <td>${p.tipo}</td>
                                                    <td>${p.senha}</td>
                                                    <td class="text-center">
                                                        <button type="button" class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Editar" onclick="showCadUsuario(${login.id})">
                                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                                        </button>
                                                        <a href="ExcluirUsuario?action=delete&id=${p.id}" name = "Excluir" type="button" class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Excluir" onclick="excluirLin(${login.id})">
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
        <div class="modal fade" id="cadUsuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Cadastrar Usuário</h4>
                    </div>
                    <form id="formAdmin" method="post" action="${pageContext.request.contextPath}/CadastrarUsuario" role = "form">
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="nome">Nome:</label>
                                    <input id="nome" name="nome" placeholder="Nome" type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="email">Email:</label>
                                    <input id="email" name="email" placeholder="Email" type="text" class="form-control" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <label for="senha">Senha:</label>
                                    <input id="senha" name="senha" type="password" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="confSenha">Confirmar senha:</label>
                                    <input id="confSenha" name="confSenha" type="password" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label for="perfil">Perfil:</label>
                                    <select id="perfil" name="perfil" class="form-control select2" style="width: 250px;">
                                        <option value=""></option>
                                        <option value="admin">Admin</option>
                                        <option value="gerente">Gerente</option>
                                        <option value="caixa">Caixa</option>
                                    </select>
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
