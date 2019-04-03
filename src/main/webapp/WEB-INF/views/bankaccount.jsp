<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8" />
  <title></title>
</head>
<body>
<table>
  <thead>
    <tr>
      <th>Prénom</th>
      <th>Nom</th>
      <th>Solde</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><input /></td>
      <td><input /></td>
      <td><input /></td>
      <td><input /></td>
      <td><input type="submit" /></td>
    </tr>
    <c:forEach var="account" items="${accounts}">
      <tr>
        <td>${account.owner.firstName}</td>
        <td>${account.owner.lastName}</td>
        <td>${account.balance}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
