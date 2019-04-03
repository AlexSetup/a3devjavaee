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

@WebServlet("/bankaccount/*")
public class BankAccountServlet extends HttpServlet {

  @Inject
  private BankAccountRepository repository;

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<BankAccount> accounts = repository.findAll();
    request.setAttribute("accounts", accounts);
    request.getRequestDispatcher("/WEB-INF/views/bankaccount.jsp").forward(request, response);
  }

}
