<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>

<body>
<form:form action="post" modelAttribute="menu">
  <fieldset>
    <div>
      <label>ID</label><form:input path="text" name="id" />
    </div>
    <div>
      <label>PASS</label><form:input path="text" name="pass" />
    </div>
  </fieldset>
  <form:button>ログイン</form:button>
</form:form>
<div>
  <a href="index.jsp">TOP画面へ</a>
</div>
</body>
</html>
