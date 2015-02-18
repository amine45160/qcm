<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../administrateur/Head.jsp"/>

<body>

<div class="container">
  <div class="masthead">
    <h3 class="text-muted">Administrateur</h3>
    <nav>
      <ul class="nav nav-justified">
        <li class="active"><a href="<s:url action="acceuilAdmin"/>">Acceuil</a></li>
        <li><a href="<s:url action="updatingQcm"/>">Gestion des Questionnaires</a></li>
        <li ><a href="<s:url action="updatingsession"/>">Gestion des Sessions</a></li>
      </ul>
    </nav>
  </div>

  <h3 align="center">Informations Administrateur</h3>
  <p>Nom : <s:property value="nomAdmin"/> </p>
  <p>Prénom : <s:property value="prenomAdmin"/></p>

  <div class="row">
    <h3>Liste des Questionnaires</h3>
    <s:iterator value="listOfThematic" var="item">
      <div class="col-lg-4">
        <h2><s:property value="%{#item.nom}"/></h2>
        <p class="text-danger"></p>
        <p><button name="" id=""  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Modifier questionnaire</button></p>
        <p><a class="btn btn-primary" href="#" role="button">Afficher Questions &raquo;</a></p>
      </div>
    </s:iterator>
  </div>

  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="exampleModalLabel">Listes des Questions  1</h4>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <s:iterator value="listQuestions" var="quest">
              <label class="control-label"><s:property value="%{#quest.contenu}"/></label>
              <button type="button" class="glyphicon glyphicon-trash"></button><button type="button" class="glyphicon glyphicon-pencil"></button></br>
              </s:iterator>
              <label>Ajouter nouvelle Question  </label><button type="button" class="glyphicon glyphicon-plus-sign"></button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Valider Modification</button>
        </div>
      </div>
    </div>
  </div>
  <!-- Site footer -->
  <footer class="footer">
    <p>&copy; Projet IHM 2014/2015</p>
  </footer>
</div> <!-- /container -->

</body>

</html>
