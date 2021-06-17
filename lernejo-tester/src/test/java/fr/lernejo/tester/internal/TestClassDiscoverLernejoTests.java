package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

public class TestClassDiscoverLernejoTests
{
    @TestMethod
    public void class_scanning_returns_only_classes_with_test_methods()
    {
        TestClassDiscover discoverer = new TestClassDiscover("fr.lernejo.tester");

        Assertions.assertThat(discoverer.listTestClasses())
            .extracting(m -> m.getClassName())
            .containsExactlyInAnyOrder("SomeLernejoTests", "TestClassDiscoverLernejotests",
                "TestClassDescriptionLernejoTests");
    }
}
