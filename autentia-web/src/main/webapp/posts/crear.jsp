<%@ include file="../header.jspf" %>


<form action="posts?crear" method="post" class="ym-form">

    <div class="ym-fbox-text">
        <label for="titulo">Titulo</label>
        <input id="titulo" type="text" name="titulo"/>

    </div>

    <div class="ym-fbox-text">
        <label for="contenido">Contenido</label>
        <textarea rows="20" cols="20" name="contenido" id="contenido">

        </textarea>

    </div>


    <div class="ym-fbox-button">
        <input type="submit"  />
    </div>
</form>

<%@ include file="../footer.jsp" %>

