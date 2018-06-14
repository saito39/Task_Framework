<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
  float: left;
}

.col-clear {
  clear: both;
}

#arrow {
  margin-top: 60px;
}
</style>
</head>
<body>
<p>これでよろしいですか？</p>

<form:form modelAttribute="updateForm" action="updateInput" method="POST">
  <fieldset>
    <div>
      <label>ID</label><form:input path="updId" name="id" value="" readonly />
    </div>
  </fieldset>

  <fieldset class="col">
    <legend>変更前</legend>
    <div>
      <label>名前</label><form:input path="text" value="" disabled />
    </div>
    <div>
      <label>TEL</label><form:input path="text" value="" disabled />
    </div>
    <div>
      <label>PASS</label><form:input path="password" value="" disabled />
    </div>
  </fieldset>

  <div id="arrow" class="col">⇒</div>

  <fieldset class="col label-110">
    <legend>変更後</legend>
    <div>
      <label>名前</label><input type="text" name="newName" value="" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="" readonly>
    </div>
    <div>
      <label>PASS(再入力)</label><input type="password" name="rePass">
    </div>
  </fieldset>

  <div class="col-clear">
   <form:button>更新</form:button>
    <input type="submit" name="button" value="戻る" onclick="location.href='updateInput.html'; return false;">
  </div>
</form:form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
