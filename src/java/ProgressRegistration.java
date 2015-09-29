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
public class ProgressRegistration extends HttpServlet {

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
            out.println("<title>Servlet ProgressRegistration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProgressRegistration at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        
        Object firstname = session.getAttribute("fname");
        Object lastname = session.getAttribute("lname");
        Object email = session.getAttribute("email");
        Object usrname = session.getAttribute("usrname");
        Object pw = session.getAttribute("pw");
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckSessionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckSessionServlet at " + request.getContextPath() 
                    +"</h1>");
            out.println("First Name: " + session.getAttribute("Sessionfname") + "<p>");
            out.println("Last Name: " + session.getAttribute("Sessionlname") + "<p>");
            out.println("Email " + session.getAttribute("Sessionemail") + "<p>");
            out.println("Username: " + session.getAttribute("Sessionusrname") + "<p>");
            out.println("Password: " + session.getAttribute("Sessionpw") + "<p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
