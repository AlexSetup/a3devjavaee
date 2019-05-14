package fr.imie.contact.servlets;

import fr.imie.contact.*;
import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.time.*;
import java.util.*;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

  @Inject
  private PersonRepository repository;

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getMethod().equalsIgnoreCase("post")) {
      Person person = new Person();
      if (request.getParameter("id") != null) {
        person.setId(Integer.parseInt(request.getParameter("id")));
      }
      person.setFirstName(request.getParameter("firstName"));
      person.setLastName(request.getParameter("lastName"));
      person.setEmail(request.getParameter("email"));

      String text = request.getParameter("birthDate");
      LocalDate date = DateUtils.toLocalDate(text);
      person.setBirthDate(date);

      repository.save(person);
    }

    if (request.getPathInfo() != null && request.getPathInfo().startsWith("/delete/")) {
      Integer id = Integer.parseInt(request.getPathInfo().substring(request.getPathInfo().lastIndexOf('/') + 1));
      repository.deleteById(id);
    } else if (request.getPathInfo() != null && request.getPathInfo().matches("/[0-9]+")) {
      Integer id = Integer.parseInt(request.getPathInfo().substring(request.getPathInfo().lastIndexOf('/') + 1));
      request.setAttribute("id", id);
    }

    List<Person> persons = repository.findAll();
    request.setAttribute("persons", persons);
    request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
  }

}
