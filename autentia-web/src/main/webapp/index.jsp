<%--@elvariable id="principalPost" type="com.autentia.demo.ejb.domain.Post"--%>
<%@ include file="header.jspf" %>

<div class="ym-column linearize-level-1">

    <c:choose>
        
        <c:when test="${!empty principalPost}">
            <div class="ym-cbox">
                <section class="box info">
                    <c:url var="postUrl" value="/posts?view&id=${principalPost.id}" />

                    <h2><a href="${postUrl}">${principalPost.titulo}</a></h2>
                    <p>${principalPost.contenido}</p>
                        <%--<a class="ym-button ym-next" href="#">Read More</a>--%>
                </section>

                    <%--@elvariable id="posts" type="java.util.List<com.autentia.demo.ejb.domain.Post>"--%>
                <c:forEach  items="${posts}" step="2"  varStatus="status">

                    <section class="ym-grid linearize-level-2">
                        <article class="ym-g50 ym-gl">
                            <div class="ym-gbox">
                                <!-- content -->
                                <h3>${posts[status.index].titulo}</h3>
                                <p>${posts[status.index].contenido}</p>
                            </div>
                        </article>
                        <article class="ym-g50 ym-gr">
                            <div class="ym-gbox">
                                <!-- content -->
                                <h3>${posts[status.index + 1 ].titulo}</h3>
                                <p>${posts[status.index + 1 ].contenido}</p>
                            </div>
                        </article>
                    </section>

                </c:forEach>



            </div>
        </c:when>
        <c:otherwise>
            <div class="error box">
                No hay entradas que mostrar
            </div>
        </c:otherwise>
    </c:choose>



</div>
<%--&lt;%&ndash;@elvariable id="posts" type="java.util.List<com.autentia.demo.ejb.domain.Post>"&ndash;%&gt;--%>
<%--<c:forEach var="post" items="${posts}">--%>
    <%--<tr>--%>
        <%--<td>${post.titulo}</td>--%>
        <%--<td>${post.contenido}</td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>

<%@ include file="footer.jsp" %>

