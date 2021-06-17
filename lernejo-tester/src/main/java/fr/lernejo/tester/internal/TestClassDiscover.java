package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClassDiscover
{
    private final String packageName;

    public TestClassDiscover(String packageName)
    {
        this.packageName = packageName;
    }

    public List<TestClassDescription> listTestClasses()
    {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        return allTypes.stream()
            .map(c -> new TestClassDescription(c))
            .filter(c -> !c.listTestMethods().isEmpty())
            .collect(Collectors.toList());
    }
}
