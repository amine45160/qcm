<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../administrateur/Head.jsp"/>

  <body>
  <div class="container">
    <div class="masthead">
      <h3 class="text-muted">Administrateur</h3>
      <nav>
        <ul class="nav nav-justified">
          <li><a href="<s:url action="acceuilAdmin"/>">Acceuil</a></li>
          <li><a href="<s:url action="updatingQcm"/>">Gestion des Questionnaires</a></li>
          <li class="active"><a href="<s:url action="updatingsession"/>">Gestion des Sessions</a></li>
        </ul>
      </nav>
    </div>

     <h3>Page gestion des session</h3>

    </div>
  </body>
</html>
