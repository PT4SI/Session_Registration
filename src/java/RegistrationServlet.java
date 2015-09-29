/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ckc
 */
public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        String firstname = request.getParameter("fname");
        PrintWriter out = response.getWriter();
       
        String lastname = request.getParameter("lname");
        String email = request.getParameter("email");
        String usrname = request.getParameter("usrname");
        String pw = request.getParameter("pw");
        String cpw = request.getParameter("cpw");
        

        
        HttpSession session = request.getSession(true);
        
        session.setAttribute("Sessionfname",firstname);
        session.setAttribute("Sessionlname",lastname);
        session.setAttribute("Sessionemail",email);
        session.setAttribute("Sessionusrname",usrname);
        session.setAttribute("Sessionpw",pw);
        
        response.setContentType("text/html;charset=UTF-8"); 
        try {
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet LoginSessionServlet</title>"); out.println("</head>");
out.println("<body>");
out.println("<h1>Servlet LoginSessionServlet at " + request.getContextPath()
+ "</h1>");
out.println("<p>Are you really want to confirm the following infomation? <p>First Name :");

if(request.getParameter("fname") != null){
             out.println( firstname );
        } else {
             out.println("Please input your First Name!");
          }
        
out.println("<p>Last Name: " + lastname + "<p>Email: " + email + "<p>Username: " + usrname + "<p>Password: ");

if (request.getParameter("pw")==null){
    out.println(pw);
}else if (pw.equals(cpw)){
            out.println("Please input password - <a href=\"javascript:history.back()\">Go Back</a>");
            }else{
    out.println("Your password not match with confirm's ! - <a href=\"javascript:history.back()\">Go Back</a>");
}


out.println("<form action=\"" + request.getContextPath() + "/ProgressRegistration\" method=\"post\"><p><input type=\"submit\" value=\"Yes\"></form>"); out.println("</body>");
out.println("</html>"); } finally {
out.close(); }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
