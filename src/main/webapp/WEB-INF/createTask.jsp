<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="java.io.*,java.util.*" %>
<% String login = (String) session.getAttribute("login"); %>

<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <title>Cadastro de Tarefa</title>
</head>
<body class="bg-dark text-white">

  <div class="container">
    <h1 class="mt-5 mb-3">Cadastro de Tarefa <%=login%>></h1>
    <form  action="<%= request.getContextPath() %>/createTask" method="post">
      <div class="mb-3">
        <label for="titulo" class="form-label">Título</label>
        <input type="text" class="form-control" id="titulo" name="titulo" required>
      </div>
      <div class="mb-3">
        <label for="descricao" class="form-label">Descrição</label>
        <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
      </div>
      <div class="mb-3">
        <label for="data_conclusao" class="form-label">Data de Conclusão</label>
        <input type="date" class="form-control" id="data_conclusao" name="data_conclusao">
      </div>
      <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select class="form-select" id="status"name="status" required>
          <option selected disabled value="">Selecione o status</option>
          <option value="Em andamento">Em andamento</option>
          <option value="Concluída">Concluida</option>
          <option value="Pendente">Pendente</option>
        </select>
      </div>
    	 <input class="btn btn-primary btn-sm" type="submit" value="Crear nova tarefa" />
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>