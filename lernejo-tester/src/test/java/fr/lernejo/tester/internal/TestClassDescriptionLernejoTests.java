package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests
{
    @TestMethod
    public void should_discover_only_marked_methods()
    {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> methods = testClassDescription.listTestMethods();

        Assertions.assertThat(methods)
            .extracting(method -> method.getName())
            .containsExactlyInAnyOrder("ok", "ko");
    }
}
