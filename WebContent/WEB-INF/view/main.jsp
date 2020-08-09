<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>

<script>
	$(function() {
		$('#exampleModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget);
			var recipient = button.data('message-id');
			var modal = $(this);
			modal.find('#recipient-name').val(recipient);
		});
	});
</script>
</head>
<body class="bg-light">
	

	<div class="container my-3 shadow p-3" >
		<my:alert />
		<h1>댓글</h1>
		<form action="write" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">이름:</label> <input
					required="required" type="text" name="name" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>

			<div class="form-group">
				<label for="exampleFormControlTextarea1">메시지:</label>
				<textarea required="required" name="message" class="form-control"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">메시지 등록</button>
		</form>
	</div>




	<hr />

	<div class="container my-3  shadow p-3">
		<c:forEach var="message" items="${list.messageList }">
			<div class="media border p-3">
				<span class="mr-3">${message.id }</span>

				<div class="media-body">
					<h5 class="mt-0">${message.guestName }</h5>
					${message.message }

					<a data-toggle="modal" href="#exampleModal"
						data-message-id="${message.id }" class="btn-delete">삭제하기</a>
				</div>
			</div>
		</c:forEach>
	</div>





	
</body>
</html>