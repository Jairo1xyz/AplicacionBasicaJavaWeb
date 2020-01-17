package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public final class editar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2 align=\"center\">Editar usuario</h2>\n");
      out.write("        ");

            String codigo=request.getParameter("codigo");
            Connection cnx=null;
            Statement sta=null;
            ResultSet rs=null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection
        ("jdbc:mysql://localhost/cursojsp?user=root&password=");
                sta=cnx.createStatement();
                rs=sta.executeQuery("select * from usuarios where codusu='"+codigo+"'");
                
                while(rs.next()){
        
      out.write("\n");
      out.write("        <form action=\"\">\n");
      out.write("            <table border=\"1\" width=\"250\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Código:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"codigo\" value=\"");
      out.print(rs.getString(1));
      out.write("\" readonly></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"nombre\" value=\"");
      out.print(rs.getString(2));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Edad:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"edad\" value=\"");
      out.print(rs.getString(3));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Sexo:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"sexo\" value=\"");
      out.print(rs.getString(4));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"password\" value=\"");
      out.print(rs.getString(5));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"grabar\" value=\"Grabar Usuario\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        ");

                }
                
            }catch(Exception e){
                
                if(request.getParameter("grabar")!=null){
                    String codigou=request.getParameter("codigo");
                    String nombreu=request.getParameter("nombre");
                    int edadu=Integer.parseInt(request.getParameter("edad"));
                    String sexou= request.getParameter("sexo");
                    String passwordu=request.getParameter("password");
                    
                    sta.executeUpdate("UPDATE USUARIOS SET NOMUSU='"+nombreu+"', EDADUSU='"+edadu+"', SEXOUSU='"+sexou+"', PASSUSU='"+passwordu+"' WHERE CODUSU='"+codigou+"'");
                    
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    out.println("Error al establecer conexión con la base de datos: "+e.getMessage()+" "+e.getCause());
                }
            }
            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
