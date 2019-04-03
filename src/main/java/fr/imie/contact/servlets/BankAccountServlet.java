package fr.imie.contact.servlets;

import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/bankaccount/*")
public class BankAccountServlet extends HttpServlet {

  @Inject
  private BankAccountRepository bankAccountRepository;

  @Inject
  private PersonRepository personRepository;

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<BankAccount> accounts = bankAccountRepository.findAll();
    List<Person> persons = personRepository.findAll();

    request.setAttribute("accounts", accounts);
    request.setAttribute("persons", persons);

    request.getRequestDispatcher("/WEB-INF/views/bankaccount.jsp").forward(request, response);
  }

}
