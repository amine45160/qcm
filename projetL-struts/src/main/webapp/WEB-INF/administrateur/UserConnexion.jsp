<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../administrateur/Head.jsp"/>

  <body>

    <div class="container">

              <s:form action="connected" id="connectadmin" class="form-signin">
                <h2 class="form-signin-heading">administrator sign in</h2>
                <s:textfield name="identifiantAdmin" placeholder="Identifiant" required="true" id="input-block-level"/>
                <s:textfield name="passwordAdmin" placeholder="Mot de passe" type="password" required="true" class="input-block-levell"/>
                <s:submit value="Se connecter" id="submit" class="btn btn-large btn-primary"/>
              </s:form>
          <div id="error" style="display:none"></div>
          <div id="idG" style="display:none"><img src="../images/G.PNG"/></div>
          <div id="idNG" style="display:none"><img src="../images/NG.PNG"/></div>
          <div id="passG" style="display:none"><img src="../images/G.PNG" /></div>
          <div id="passNG" style="display:none"><img src="../images/NG.PNG" /></div>
    </div>

    <!------------------AJAX------------------->
    <script>
      $(function () {
        $("#connectadmin").keyup(function () {

          var identifiant = $(this).find("input[name=identifiantAdmin]").val();
          var pass = $(this).find("input[name=passwordAdmin]").val();


          if (identifiant.length < 4 || identifiant.length > 21) {
            $("#idG").hide();
            $("#idNG").show();
            $("#submit").disabled;
          } else {
            $("#idG").show();
            $("#idNG").hide();
          }
          if (pass.length < 5 || pass.length > 21) {
            $("#passG").hide();
            $("#passNG").show();
            $("#submit").disabled;
          } else {
            $("#passG").show();
            $("#passNG").hide();
          }
        });
      });
      $(function () {
        $("#connectadmin").submit(function () {
          $("#error").hide();
          var identifiantAdmin = $(this).find("input[name=identifiantAdmin]").val();
          var passwordAdmin = $(this).find("input[name=passwordAdmin]").val();

          $.ajax({

            type: "POST",
            url: "connected.action",
            data: {identifiantAdmin: identifiantAdmin, passwordAdmin: passwordAdmin},
            success: function (response) {

              if (response == "connected") {
                window.location.href = "acceuilAdmin.action";

              } else {
                if (response == "notConnected") {
                  $("#error").empty().append("Identifiant ou Mot de passe errone").show();
                } else {
                  alert("verification de donnees echouee");
                }
              }
            },
            error: function (e) {
              $("#error").empty().append(e).show();
            }
          });
          return false;
        });
      });
    </script>

  </body>
</html>
