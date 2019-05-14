package fr.imie.contact.servlets;

import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/transfer/*")
public class TransferServlet extends HttpServlet {

  @Inject
  private BankAccountRepository bankAccountRepository;

  @Inject
  private PersonRepository personRepository;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // bankAccountRepository.save();
    // bankAccountRepository.save();

  }

}
