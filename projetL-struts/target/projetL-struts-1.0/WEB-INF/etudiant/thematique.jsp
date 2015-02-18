<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="Head.jsp"/>

<body id="page">
<ul class="cb-slideshow">
    <li>
        <span id="span"  style="background-image: url(../images/3.jpg)"></span>

<div>
            <s:iterator value="listOfThematic" var="item">

                <s:form action="question" id="form">
                <s:hidden name="id" value="%{#item.id}" />
                <s:submit value="%{#item.nom}" id="submit" />
                </s:form>
            </s:iterator>
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