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
          <li class="active"><a href="<s:url action="updatingQcm"/>">Gestion des Questionnaires</a></li>
          <li><a href="<s:url action="updatingsession"/>">Gestion des Sessions</a></li>
        </ul>
      </nav>
    </div>
    <h1>Page gestion des Qcm</h1>
    <label>Ajouter nouveau Questionnaire </label> <button name="" id=""  type="button" class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#Create"></button>

    <div class="modal fade" id="Create" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="exampleModalLabel">Creation d'un nouveau Questionnaire</h4>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <p><label >Choix de la Thematique </label><select name="choixthematique">
                  <option>Thematique 1</option>
                  <option>Thematique 2</option>
                  <option>Thematique 3</option>
                  <option>Thematique 4</option>
                  <option>Thematique 5</option>
                </select></p>
                <label class="control-label"> Intitule Questionnaire  </label> <input type="text" name="intitule" value=""/></br>
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


    </div>
  </body>

</html>
