<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="java.io.*,java.util.*" %>
<% String login = (String) session.getAttribute("login"); %>
<% String userid = (String) session.getAttribute("iduser"); %>

<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <title>Lista de Tarefas</title>
</head>
<body class="bg-dark text-white">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div class="container">
    <div class="d-flex justify-content-between align-items-center mt-3">
      <h1>Lista de Tarefas da <%=login%></h1>
      <button class="btn btn-primary">Sair</button>
    </div>
    <table class="table table-dark table-striped mt-3">
      <thead>
        <tr>
          <th>ID</th>
          <th>Título</th>
          <th>Descrição</th>
          <th>Data de Criação</th>
          <th>Data de Conclusão</th>
          <th>Status</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="task">
        <tr>
          <td>${task.getId()}</td>
          <td>${task.getTitulo()}</td>
          <td>${task.getDescricao()}</td>
          <td>${task. getData_criacao()}</td>
          <td>${task.getData_conclusao()}</td>
          <td>${task.getStatus()}</td>
          <td>
            <a class="btn btn-primary btn-sm" href="./EditTask?userid=${task.getId_user()}&taskid=${task.getId()}">Editar</a>
            <a class="btn btn-danger btn-sm" href="./Delete?taskid=${task.getId()}">Cancelar</a>
          </td>
        </tr>
       </c:forEach>
      </tbody>
    </table>
    <div class="text-end">
    <a href="./createTask?iduser=${task.getId_user()}">
      <button class="btn btn-primary">
      	Nova Tarefa
      </button>
     </a>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>