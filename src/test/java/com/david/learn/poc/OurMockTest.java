package com.david.learn.poc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OurMockTest {

    private ExternalService service = (ExternalService) OurMockito.mock(ExternalService.class);

    private static final String VALUE_THAT_WILL_RETURN_THE_METHOD_STUBBED = "dummy";

    @Test
    public void stubbingMethod() throws Exception {
        final String METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB = "concat";
        OurMockito.stub(service, METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB,
                VALUE_THAT_WILL_RETURN_THE_METHOD_STUBBED);

        String returned = service.concat(null, null);
        assertEquals(VALUE_THAT_WILL_RETURN_THE_METHOD_STUBBED, returned);
    }

    @Test
    public void stubbingErrorConditions() throws Exception {
        final String METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB = "divide";
        OurMockito.stub(service, METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB, 0);

        int returned = service.divide(0, 0);
        assertEquals(0, returned);
    }

    @Test
    public void stubbing_exception() throws Exception {
        final String METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB = "someStrangeOperation";
        OurMockito.stub(service, METHOD_NAME_FROM_EXTERNAL_SERVICE_INTERFACE_TO_STUB, 0,
                new RuntimeException("Just blow this up!"));
        service.someStrangeOperation(null);
    }

}
