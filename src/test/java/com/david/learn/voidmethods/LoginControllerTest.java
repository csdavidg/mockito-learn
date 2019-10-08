package com.david.learn.voidmethods;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    private LoginController loginController;

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private LDAPManager ldapManager;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher dispatcher;

    @Before
    public void beforeEveryTest() {
        MockitoAnnotations.initMocks(this);
        loginController = new LoginController(ldapManager);

        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getParameter(anyString())).thenReturn("user", "pwd");
    }

    @Test
    public void whenValidUserCredentialForLoginThenRouteToHomePage() throws Exception {

        when(ldapManager.isValidUser(anyString(), anyString())).thenReturn(true);
        when(request.getSession(true)).thenReturn(session);


        loginController.process(request, response);

        verify(ldapManager).isValidUser(anyString(), anyString());
        verify(request).getSession(true);
        verify(session).setAttribute(anyString(), anyString());
        verify(request).getRequestDispatcher(eq("home.jsp"));
        verify(dispatcher).forward(request, response);

    }

    @Test
    public void whenInvalidUserCredentialForLoginThenRouteToLoginPage() throws Exception {
        when(ldapManager.isValidUser(anyString(), anyString())).thenReturn(false);

        loginController.process(request, response);

        verify(request).getRequestDispatcher(eq("login.jsp"));
        verify(dispatcher).forward(request, response);
    }

}
