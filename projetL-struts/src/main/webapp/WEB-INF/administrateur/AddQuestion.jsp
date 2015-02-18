<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<s:include value="Head.jsp"/>

  <body>
    <div class="container">
      <div class="masthead">
        <h3 class="text-muted">Administrateur</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="<s:url action="acceuilAdmin"/>">Acceuil</a></li>
            <li class="active"><a href="<s:url action="updatingQcm"/>">Gestion des Questionnaires</a></li>
            <li><a href="<s:url action="updatingsession"/>">Gestion des Sessions</a></li>
          </ul>
        </nav>
      </div>
    </div>

    <div class="row">
      <h3>Liste des Questionnaires</h3>
      <s:iterator value="questionaireListe">
        <div class="col-lg-4">
          <h2><s:property value="#questionaireListe.thematique"/></h2>
          <p class="text-danger"></p>
          <p>Details du questionnaire</p>
          <p><a class="btn btn-primary" href="" id="<s:property value="#questionaireListe.idQuestion"/>" role="button">Ajouter Nouvelle question &raquo;</a></p>
        </div>
      </s:iterator> </p>
    </div>

    <div id="questionhidden" style="display: none">
      <h3>Ajout nouvelle question :</h3>
      *cocher la bonne reponse !
      <s:form action="AfficheQuestion">
        <S:textarea name="question" key="Question :"/>
        <p><s:textfield name="reponse1" key="Premier Choix de reponse"/><s:checkbox name="first"/></p>
        <P><s:textfield name="reponse2" key="Deuxieme Choix de reponse"/><s:checkbox name="second"/></P>
        <P><s:textfield name="reponse3" key="troisieme Choix de reponse"/><s:checkbox name="third"/></P>
        <P><s:textfield name="reponse4" key="quatrieme Choix de reponse"/><s:checkbox name="fourth"/></P>
        <s:submit/>
      </s:form>
    </div>

  </body>

</html>
