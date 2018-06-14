<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>１箇所以上の項目を変更してください<br>
※IDは変更できません</p>

<form:form modelAttribute="updateForm" action="updateConfirm" method="post">
  <fieldset>
    <div>
      <label>ID</label><form:input path="updId" name="id" readonly />
    </div>
    <div>
      <label>名前</label><form:input path="updName" name="newName" />
    </div>
    <div>
      <label>TEL</label><form:input path="updTel" name="newTel" />
    </div>
    <div>
      <label>PASS</label><form:input path="password" name="newPass" />
    </div>
  </fieldset>
  <div>
     <form:button>確認</form:button>
    <input type="submit" name="button" value="戻る" onclick="location.href='update.jsp'; return false;">
  </div>
</form:form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
