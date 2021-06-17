package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassDescription
{
    private final Class<?> cl;

    public TestClassDescription(Class<?> c)
    {
        this.cl = c;
    }

    public List<Method> listTestMethods()
    {
        Method[] met = this.cl.getDeclaredMethods();
        return Arrays.stream(met)
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .filter(m -> m.getReturnType().equals(void.class))
            .filter(m -> m.getParameterCount() == 0)
            .filter(m -> m.isAnnotationPresent(TestMethod.class))
            .collect(Collectors.toList());
    }
}
