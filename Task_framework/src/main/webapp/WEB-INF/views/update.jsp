<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>更新を行うデータのIDを入力してください<br>
<span class="required"></span>は必須です</p>

<form:form modelAttribute="updateConfirm" action="update" method="POST">
  <fieldset>
    <div>
      <label class="required">ID</label><form:input path="text" id="updId" name="id" />
    </div>
  </fieldset>
  <form:button>確認</form:button>
</form:form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
