<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Livraria</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

	<jsp:include page="/resources/templates/navbar.jsp" />	<!-- incluí a página navbar.jsp -->

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Página inicial</h1>
      </div>
      <p class="lead">Sistema de livraria</p>
      <p>Educandoweb - <a href="https://youtube.com/educandoweb">youtube.com/educandoweb</a></p>
    </div>

	<jsp:include page="/resources/templates/rodape.jsp"/> <!-- incluí a página rodape.jsp -->

    <!-- Core JS -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>