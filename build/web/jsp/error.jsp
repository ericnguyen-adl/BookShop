<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <body bgcolor="white">
        <div>            
            <jsp:include page="header.jsp" />
        </div>
        <%@ page isErrorPage="true" %>
        <c:set var="msg" value='${sessionScope.result}'/>
        <h3>
            <c:out value="${msg}"/>
        </h3>
        <% session.invalidate();%>
        <div>       
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
