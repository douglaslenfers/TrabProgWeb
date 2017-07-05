<%-- 
    Document   : index
    Created on : Jul 5, 2017, 8:25:48 AM
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <meta charset="UTF-8" />
        <title>Bem vindo ao Squad - Login</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
    </header>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse navbar-transparente">
            <div class="container">
                <div class="navbar-header">
                    <a href="index.html" class="navbar-brand">
                        <img src="imagens/logo.png" class="img-logo">
                    </a>
                </div>
            </div>
        </nav>
        <div class="container conteudo">
            <div class="row">
                <div class="col-md-5 col-md-offset-3">
                    <div class="well telaLogin">
                        <img src="imagens/squirtlequad.png">
                        <form id="formLogin" method="post" action="${pageContext.request.contextPath}/ValidarAcesso" role = "form">
                            <div class="form-group">
                                <label class="control-label" for="user">Usuário</label>
                                <input id="user" name="user" placeholder="Usuário" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="pass">Senha</label>
                                <input id="pass" name="pass" placeholder="Senha" type="password" class="form-control" />
                            </div>
                            <div class="esquecisenha"> 
                                <span class="password_lost"><a href="javascript:void(0)">Esqueceu a senha?</a></span>
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-info btn-block">Entrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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
    </body>
</html>