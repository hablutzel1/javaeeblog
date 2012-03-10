<%@ include file="header.jspf" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>





<form class="ym-form"  action="login" method="post">

    <div class="ym-fbox-text">
        <label for="usuario">Usuario</label>
        <input id="usuario" type="text" name="usuario" />

    </div>

    <div class="ym-fbox-text">
        <label for="password">Contraseña</label>
        <input id="password" type="password" name="password" />

    </div>


    <div class="ym-fbox-button">
        <input type="submit"  />
    </div>

</form>

<%@ include file="footer.jsp" %>