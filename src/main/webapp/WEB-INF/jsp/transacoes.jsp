<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Transacoes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</head>

<body>
<form method="post" action="<c:url value="/transacoes"/>">
			<div class="form-group">
				<label>TICKER</label>
				<input name="ticker" class="form-control">
			</div>
			
			
			<div class="form-group">
				<label>PRECO</label>
				<input name="preco" class="form-control">
			</div>
			
			<div class="form-group">
				<label>QUANTIDADE</label>
				<input name="quantidade" class="form-control">
			</div>
			
			<div class="form-group">
				<label>DATA(dd/mm/yyyy)</label>
				<input name="data" class="form-control">
			</div>
			
			<div class="form-group">
				<label>TIPO(COMPRA OU VENDA)</label>
				<input name="tipo" class="form-control">
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary mt-1">
		</form>


<h1 class="text-center">LISTA</h1>
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th>TICKER</th>
					<th>DATA</th>
					<th>PRECO</th>
					<th>QUANTIDADE</th>
					<th>TIPO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transacoes }" var="transacao">
					<tr>
						<td>${transacao.ticker }</td>
						<td>${transacao.data }</td>
						<td>${transacao.preco }</td>
						<td>${transacao.quantidade }</td>
						<td>${transacao.tipo }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>