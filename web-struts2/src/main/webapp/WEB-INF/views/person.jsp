<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8" />
  <title></title>
</head>
<body>
<c:url var="context" value="/person/" />
<form method="post" action="${context}save">
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Date de naissance</th>
      </tr>
    </thead>
    <tbody>
      <c:if test="${ empty id }">
        <tr>
          <td>*</td>
          <td><input name="firstName" /></td>
          <td><input name="lastName" /></td>
          <td><input name="email" /></td>
          <td><input name="birthDate" /></td>
          <td><input type="submit" /></td>
        </tr>
      </c:if>
      <c:forEach var="person" items="${persons}">
        <c:if test="${person.id eq id}">
          <tr>
            <td><input type="hidden" name="id" value="${person.id}" />${person.id}</td>
            <td><input name="firstName" value="${person.firstName}" /></td>
            <td><input name="lastName" value="${person.lastName}" /></td>
            <td><input name="email" value="${person.email}" /></td>
            <td><input name="birthDate" value="${person.birthDate}" /></td>
            <td><input type="submit" /></td>
            <td><a href="${context}">annuler</a></td>
          </tr>
        </c:if>
        <c:if test="${person.id ne id}">
          <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.email}</td>
            <td>${person.birthDate}</td>
            <td><a href="${context}${person.id}" !onclick="edit(event);" >modifier</a></td>
            <td><a href="${context}delete/${person.id}">supprimer</a></td>
          </tr>
        </c:if>
      </c:forEach>
    </tbody>
  </table>
</form>
<script>
  function edit(event) {
      event.preventDefault();
      // NOT PRO
      var tr = event.target.parentNode.parentNode;
      var tds = Array.from(tr.children);
      tds.splice(-2,2);
          tds.forEach(function (td, col) {
          if (col === 0) {
              var name = 'id';
          } else {
              var name = document.querySelector('tbody')
                  .firstElementChild.children[col]
                  .firstElementChild.name;
              console.log(name);
          }
        var value = td.textContent;
        td.innerHTML = '<input name="'+name+'" value="'+value+'" />';
      });
  }
</script>
</body>
</html>
