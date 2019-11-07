package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertFalse;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressMethod.class)
public class SuppressMethodTest {

    @Test
    public void suppressMethodGetCurrency() {

        suppress(method(SuppressMethod.class, "getCurrency"));
        SuppressMethod sm = new SuppressMethod();
        assertFalse(sm.format("10").contains("$"));
    }

}
