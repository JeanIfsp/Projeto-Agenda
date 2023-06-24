<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tela de Login</title>
  
  <!-- Incluir arquivos CSS do Bootstrap 5 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <style>
    /* Estilos personalizados para o tema dark */
    body {
      background-color: #121212;
      color: #fff;
    }

    .form-control {
      background-color: #212529;
      border: none;
      color: #fff;
    }

    .form-control:focus {
      background-color: #212529;
      border-color: #5c5c5c;
      color: #fff;
      box-shadow: none;
    }

    .btn-primary {
      background-color: #007bff;
      border-color: #007bff;
    }

    .btn-primary:hover {
      background-color: #0069d9;
      border-color: #0062cc;
    }
  </style>
</head>
<body>
 <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-4 mt-5">
        <h2 class="mb-4 text-center">Login</h2>
        <form action="login" method="POST">
          <div class="mb-3">
            <label for="username" class="form-label">Usuário</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Digite seu usuário" required>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Senha</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Digite sua senha" required>
          </div>
          <button type="submit" class="btn btn-primary">Entrar</button>
        </form>
        <br>
     	 <a class="btn btn-danger btn-sm" href="./CreateUser">Criar usuario</a>
      </div>
    </div>
  </div>

  <!-- Incluir arquivos JS do Bootstrap 5 -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>