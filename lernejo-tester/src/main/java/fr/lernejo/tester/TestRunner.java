package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import fr.lernejo.tester.internal.TestClassDiscover;

import java.lang.reflect.Method;
import java.time.Instant;

public class TestRunner
{
    static public void main(String[] args)
    {
        int nb_tests_total = 0;
        int nb_tests_failed = 0;

        Instant start = Instant.now();

        for (String package_name : args)
        {
            for (TestClassDescription classe : new TestClassDiscover(package_name).listTestClasses())
            {
                for (Method method : classe.listTestMethods())
                {
                    nb_tests_total++;

                    Instant method_before = Instant.now();
                    boolean result = run_and_catch(method);
                    Instant method_after = Instant.now();

                    if (result == false)
                        nb_tests_failed++;

                    System.out.println(classe.getClassName() + "#" + method.getName()
                        + " " + (result ? "OK" : "KO")
                        + " " + (method_after.toEpochMilli() - method_before.toEpochMilli()) + " ms");
                }
            }
        }

        Instant end = Instant.now();
        System.out.println("");
        System.out.println("Ran " + nb_tests_total + " test (" + nb_tests_failed + " failed) in " +
            (end.toEpochMilli() - start.toEpochMilli()) + " ms");
    }

    static private boolean run_and_catch(Method method) {
        try
        {
            Object instance = method.getDeclaringClass().getConstructor().newInstance();
            method.invoke(instance);

            return true;
        }
        catch (Throwable t)
        {
            return false;
        }
    }
}
