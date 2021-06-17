package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

import java.util.List;

public class TestClassDiscoverLernejoTests
{
    @TestMethod
    public void class_scanning_returns_only_classes_with_test_methods()
    {
        List<TestClassDescription> desc = new TestClassDiscover("fr.lernejo.tester").listTestClasses();

        Assertions.assertThat(desc.size() == 3);
        Assertions.assertThat(desc.contains(new TestClassDescription(TestClassDiscoverLernejoTests.class)));
        Assertions.assertThat(desc.contains(new TestClassDescription(TestClassDescriptionLernejoTests.class)));
        Assertions.assertThat(desc.contains(new TestClassDescription(SomeLernejoTests.class)));
    }
}
