<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Untitled Document</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body bgcolor="#FFFFFF" text="#000000">
        <div>            
            <jsp:include page="header.jsp" />
        </div>

        <h2 align="center"><font color="#003333">ADMIT ONLINE BOOKSTORE</font></h2>
        <hr>
        <h3><font face="Georgia, Times New Roman, Times, serif">Thank you for shopping 
            with us.</font> </h3>
        <p>&nbsp;</p>
        <c:set var="message" value='${sessionScope.result}'/>
        <table width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr>
                <td bgcolor="#FFFFD7"><c:out value="${message}"/></td>
            </tr>
        </table>
        <% session.invalidate();%>
        <p>&nbsp;</p>
        <div>       
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
