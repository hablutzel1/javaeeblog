<%--@elvariable id="post" type="com.autentia.demo.ejb.domain.Post"--%>
<%@ include file="../header.jspf" %>



<h3>${post.titulo}</h3>

<div>
${post.contenido}
</div>


<%@ include file="../footer.jsp" %>

