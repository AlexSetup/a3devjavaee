package fr.imie.contact.servlets;

import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

  @Inject
  private PersonRepository repository;

  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    List<Person> persons = repository.findAll();
    request.setAttribute("persons", persons);
    request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
  }

}
