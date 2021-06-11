package servlets;

import domain.Note;
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); // get note path
        BufferedReader br = new BufferedReader(new FileReader(new File(path))); // read note path
        Note note = new Note(br.readLine(), br.readLine()); // create note object and use br.readLine() to read each line of note.txt
        request.setAttribute("note", note);
        // this will display the requested JSP as a view
        String edit = request.getParameter("edit"); // getting parameter of edit from viewnote.jsp
        if (edit != null && edit.equals("true")) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response); // if edit is clicked on show editnote page
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); // otherwise just show viewnote page
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("note_title"); // creates a string to read note_title text box from editnote.jsp
        String contents = request.getParameter("contents_title"); // creates a string to read contents_title text box from editnote.jsp

        Note note = new Note(title, contents); //creates a new note object
        request.setAttribute("note", note);

        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); // gets the path for note.txt

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); // prints to the path specified

        pw.println(note.getTitle()); // writes to the first line
        pw.println(note.getContents()); // writes to the second line

        pw.close(); // always close printwriter
        //display the  JSP
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
