<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Go2itemActionで取得したitemlistをiteratorを使って表示 -->

<table>
<tr>
<td>商品番号</td><td>商品名</td><td>価格</td>
</tr>

<s:iterator value="itemlist">
<tr>
<td><s:property value="id"/></td><td><s:property value="name"/></td><td><s:property value="price"/></td>
</tr>
</s:iterator>
</table>
<form action="IteminCart">
<input type="text" name="id" value="id">
<input type="text" name="number" value="number">
<input type="submit" name="submit">
</form>


<form action="Go2Cart">
<input type="submit" value="Go2Cart">
</form>
</body>
</html>