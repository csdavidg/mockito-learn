package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertTrue;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressSuperConstructor.class)
public class SuppressSuperConstructorTest {

    @Test
    public void suppressSuperConstructor() {
        suppress(constructor(DontExtendMePlease.class));
        new SuppressSuperConstructor();
        assertTrue(true);

    }

}
