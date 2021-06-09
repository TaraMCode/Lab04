package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // this will display the requested JSP as a view
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the parameters from the POST request (the form)
        String userAgeInputted = request.getParameter("user_age");

        // set the attributes for the JSP
        request.setAttribute("userAge", userAgeInputted);

        // int inum = Integer.parseInt(userage);
        // validation: if the parameters don't exist or are empty, show the form again
        if (userAgeInputted == null || userAgeInputted.equals("")) {
            // Create a helpful message to send to the user
            request.setAttribute("message", "You must give your current age.");
            // forward the request and response objects to the JSP
            //display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
            return; // very important! Stop the code call.
        } else if (userAgeInputted.matches("[A-Za-z]{1,50}")) { // regex?
            request.setAttribute("message", "You must enter a number.");
        } else {
            int nextYearsAge = Integer.parseInt(userAgeInputted);
            nextYearsAge++;
            request.setAttribute("message", "Your age next birthday will be " + nextYearsAge);
        }

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        //display the  JSP
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
    }
}
