<%@ include file="../header.jspf" %>


<h3>Lista de posts</h3>

<table class="bordertable">
    
    <tr>
        <th>Titulo</th>
        <th>Contenido</th>
    </tr>

    <%--@elvariable id="posts" type="java.util.List<com.autentia.demo.ejb.domain.Post>"--%>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.titulo}</td>
            <td>${post.contenido}</td>
        </tr>
    </c:forEach>
</table>


<%@ include file="../footer.jsp" %>

