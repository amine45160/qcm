<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="Head.jsp"/>

  <body>
  <div class="container">
    <div class="masthead">
      <h3 class="text-muted">Administrateur</h3>
      <nav>
        <ul class="nav nav-justified">
          <li class="active"><a href="<s:url action="acceuilAdmin"/>">Acceuil</a></li>
          <li  class="active"><a href="<s:url action="updatingQcm"/>">Gestion des Questionnaires</a></li>
          <li ><a href="<s:url action="updatingsession"/>">Gestion des Sessions</a></li>
        </ul>
      </nav>
    </div>

  <h3>Create new multiple choice question</h3>
  <s:form action="createQCM">
    <s:textfield name="nom" key="Nom"/>
    <s:select list="thematiques" key="Themarique"/>
    <s:textarea name="question" key="Question"/>
    <p>Cocher la bonne reponse</p>
    <p><s:textfield name="reponse1" id="reponse1" key="Premier Choix de reponse"/><s:checkbox name="first"/></p>
    <P><s:textfield name="reponse2" id="reponse2" key="Deuxieme Choix de reponse"/><s:checkbox name="second"/></P>
    <P><s:textfield name="reponse3" id="reponse3" key="troisieme Choix de reponse"/><s:checkbox name="third"/></P>
    <P><s:textfield name="reponse4" id="reponse4" key="quatrieme Choix de reponse"/><s:checkbox name="fourth"/></P>
    <s:submit/>
  </s:form>
  </div>
  </body>

</htlm>

