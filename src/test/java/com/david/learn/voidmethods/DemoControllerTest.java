package com.david.learn.voidmethods;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class DemoControllerTest {

    private DemoController demoController;

    @Mock
    private LoginController loginController;
    @Mock
    private ErrorHandler errorHandler;
    @Mock
    private MessageRepository messageRepository;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;

    @Before
    public void beforeEveryTest() {
        MockitoAnnotations.initMocks(this);
        demoController = new DemoController(loginController, errorHandler, messageRepository);
    }

    @Test
    public void whenSubsystemThrowsExceptionThenRoutesToErrorPage() throws Exception {
        doThrow(new IllegalArgumentException("LDAP Error Authentication ")).when(loginController)
                .process(request, response);

        when(request.getServletPath()).thenReturn("/logon.do");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        demoController.doGet(request, response);

        verify(request).getRequestDispatcher(eq("error.jsp"));
        verify(dispatcher).forward(request, response);

    }

    @Test
    public void whenSubsystemThrowsAnyExceptionThenFindsErrorMessageAndRoutesToErrorPage() throws Exception {
        doAnswer((invocation) -> {
            Error error = (Error) invocation.getArguments()[0];
            error.setErrorCode("123");
            return error;
        }).when(loginController).process(request, response);

        doThrow(new IllegalArgumentException("Ldap error")).when(loginController).process(request, response);
        when(request.getServletPath()).thenReturn("/logon.do");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        demoController.doGet(request, response);

        verify(request).getRequestDispatcher(eq("error.jsp"));
        verify(dispatcher).forward(request, response);



    }

}
