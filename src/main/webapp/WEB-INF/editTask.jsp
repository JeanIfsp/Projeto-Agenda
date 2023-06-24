<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <title>Cadastro de Tarefa</title>
</head>
<body class="bg-dark text-white">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <div class="container">
    <h1 class="mt-5 mb-3">Editar Tarefa</h1>
    <c:forEach items="${list}" var="task">
	    <form  action="<%= request.getContextPath() %>/EditTask" method="post">
	      <div class="mb-3">
	        <label for="titulo" class="form-label">Título</label>
	        <input type="text" class="form-control" id="titulo" value="${task.getTitulo()}" name="titulo" readonly="true">
	      </div>
	      <div class="mb-3">
	        <input type="text" class="form-control" id="idtask" value="${task.getId()}" name="idtask" hidden>
	      </div>
	      <div class="mb-3">
	        <input type="text" class="form-control" id="iduser" value="${task.getId_user()}" name="iduser" hidden>
	      </div>
	      <div class="mb-3">
	        <label for="descricao" class="form-label">Descrição</label>
	        <textarea class="form-control" id="descricao" value="oi mundo lindo" name="descricao"  rows="3" >${task.getDescricao()}</textarea>
	      </div>
	      <div class="mb-3">
	        <label for="data_conclusao" class="form-label">Data de Conclusão</label>
	        <input type="date" class="form-control" id="data_conclusao"  name="data_conclusao">
	      </div>
	      <div class="mb-3">
	        <label for="status" class="form-label">Status</label>
	        <select class="form-select" id="status"name="status" required>
	          <option value="Em andamento">Em andamento</option>
	          <option value="Concluída">Concluida</option>
	          <option value="Pendente">Pendente</option>
	        </select>
	      </div>
	    	 <input type="submit" value="Submit" />
	    </form>
	   </c:forEach>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
  	document.getElementById("descricao").innerHTML="valor"
  </script>
</body>
</html>