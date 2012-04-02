<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--@elvariable id="post" type="com.autentia.demo.ejb.domain.Post"--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="../header.jspf" %>


<h3>${post.titulo}</h3>
<p>
<pre>
    <%--<spring:escapeBody htmlEscape="true">--%>
        <%--${post.contenido}--%>
    <%--</spring:escapeBody>--%>


</pre>
</p>

<h4>Añadir comentario</h4>


<form>

      <input type="text" />

</form>

<%@ include file="../footer.jsp" %>

