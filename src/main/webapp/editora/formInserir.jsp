<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Filmes</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/resources/templates/navbar.jsp" />	<!-- incluí a página navbar.jsp -->

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Inserir nova Editora</h1>
      </div>
      
      <form method="post" name="myform" class="form-horizontal" 
      		action="<%=request.getContextPath()%>/editora/inserir">
      		
      		<div class="form-group">
      			<div class="col-sm-offset-2 col-sm-10">
					<ul >
						<c:forEach items="${erros}" var="msg">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>		
      			</div>
      		</div>
      		
      		<div class="form-group">
      			<label class="col-sm-2 control-label" for="nome">Nome:</label>
      			<div>
      				<input type="text" name="nome" id="nome" value="${item.nome}"
      				required="required" class="form-control">
      			</div>
      		</div>      		
      		<!--repete acima caso tenha mais campos  -->
      		
      		<div class="form-group">
      			<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/editora/listarEditora" class="btn btn-default">Voltar</a>      			
      			</div>
      		</div>
      </form>
    </div>

	<jsp:include page="/resources/templates/rodape.jsp"/> <!-- incluí a página rodape.jsp -->

    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>