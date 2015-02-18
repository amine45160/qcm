<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="Head.jsp"/>

<body id="page">
<ul class="cb-slideshow">
    <li><span id="span"> </span>

        <div id="form">
            <s:form action="nextQuestion" id="formulaire">
                <h3><s:property value="question"/></h3><br>

                <s:iterator value="listChoice" var="item">
                    <h2><input type="radio" name="reponse"
                               value="<s:property value="%{#item.contenuChoice}"/>">
                        <s:property value="%{#item.contenuChoice}"/><br></h2>
                </s:iterator>
                <s:submit value="Suivant" />
                <button type="submit" value="Repondre" class="ad"  />
            </s:form>


        </div>
    </li>
</ul>


<!--------------- Header ------------------->
<div class="container">
    <div class="codrops-top">
                <span class="right">
                    <a href="http://www.univ-orleans.fr" target="_blank">University Of Orléans -
                        www.univ-orleans.fr </a>
                </span>

        <div class="clr"></div>
    </div>


    <header>
        <h1><span>Department Of Informatics | Master 1 MIAGE</span></h1>

        <h1><span></span></h1>


    </header>
</div>
</body>
</html>