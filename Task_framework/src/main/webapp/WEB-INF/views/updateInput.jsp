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

<form:form action="post" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="111" readonly>
    </div>
    <div>
      <label>名前</label><input type="text" name="newName" value="alice">
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="19980406">
    </div>
    <div>
      <label>PASS</label><input type="password" name="newPass" value="alicesos">
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="確認">
    <input type="submit" name="button" value="戻る" onclick="location.href='update.html'; return false;">
  </div>
</form:form>
<div>
  <a href="menu.html">メニューに戻る</a>
</div>
</body>
</html>
