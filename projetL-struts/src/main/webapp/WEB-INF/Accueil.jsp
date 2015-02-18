<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<head xmlns="http://www.w3.org/1999/html">
    <meta charset="UTF-8"/>
    <meta http-equiv="content-type" content="text/html"/>
    <meta name="description" lang="fr" content="contenu"/>
    <meta name="keywords" lang="fr" content="qcm , departement informatique , université d'orleans"/>
    <title>QCM : Authentification </title>
    <link rel="shortcut icon" href="../images/logo.ico">
    <script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../css/animation.css"/>
</head>


<body id="page">
<ul class="cb-slideshow">
    <li>
        <span id="span"  style="background-image: url(../images/0.jpg)">
        </span>
        <div id="form">
            <div class="login">
                <s:form action="connexion" id="qcm">
                    <s:textfield name="identifiant" placeholder="Identifiant" required="true" />
                    <s:textfield name="password" placeholder="Mot de passe" type="password" required="true"/>
                    <s:submit value="Se connecter" id="submit"/>
                </s:form>
            </div>
        </div>
        <div id="error" style="display:none"></div>
        <div id="idG" style="display:none"><img src="../images/good.png" id="goodID"/></div>
        <div id="idNG" style="display:none"><img src="../images/notGood.png" id="notgoodID"/></div>
        <div id="passG" style="display:none"><img src="../images/good.png" id="goodPASS"/></div>
        <div id="passNG" style="display:none"><img src="../images/notGood.png" id="notgoodPASS"/></div>
    </li>
</ul>

<!------------------AJAX------------------->
<script>
    $(function () {
        $("#qcm").keyup(function () {

            var identifiant = $(this).find("input[name=identifiant]").val();
            var pass = $(this).find("input[name=password]").val();


            if (identifiant.length < 4 || identifiant.length > 35) {
                $("#idG").hide();
                $("#idNG").show();
                $("#submit").disabled;
            } else {
                $("#idG").show();
                $("#idNG").hide();
            }
            if (pass.length < 4 || pass.length > 21) {
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
        $("#qcm").submit(function () {
            $("#error").hide();
            var identifiant = $(this).find("input[name=identifiant]").val();
            var password = $(this).find("input[name=password]").val();

            $.ajax({

                type: "POST",
                url: "connexion.action",
                data: {identifiant: identifiant, password: password},
                success: function (response) {

                    if (response == "connected") {
                    window.location.href = "thematique.action";

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

<!--------------- Header ------------------>
<div class="container">
    <div class="codrops-top">
                <span class="right">
                    <a href="www.univ-orleans.fr" target="_blank">University Of Orléans -
                        www.univ-orleans.fr </a>
                    <a href="/projetL/user/adminconnect.action" target="_blank">Administrateur</a>
                </span>
        <div class="clr"></div>
    </div>
    <header>
        <h1><span>Struts Application | Department Of Informatics </span></h1>
    </header>
</div>
</body>
</html>