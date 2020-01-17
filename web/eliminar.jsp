<%-- 
    Document   : eliminar
    Created on : 14/01/2020, 02:42:26 PM
    Author     : Jairo
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("codigo")!=null){
                String codigo=request.getParameter("codigo");

                Connection cnx=null;
                ResultSet rs=null;
                Statement sta=null;

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    cnx=DriverManager.getConnection
                    ("jdbc:mysql://localhost/cursojsp?user=root&password=");

                    sta=cnx.createStatement();

                    sta.executeUpdate("DELETE FROM USUARIOS WHERE CODUSU='"+codigo+"'");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }catch(Exception e){
                    out.println("Error: "+e.getMessage()+" e:"+e);
                }
            }
        %>
    </body>
</html>
