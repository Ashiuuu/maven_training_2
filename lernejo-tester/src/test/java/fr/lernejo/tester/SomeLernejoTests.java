package fr.lernejo.tester;

import fr.lernejo.tester.api.TestMethod;

public class SomeLernejoTests
{
    @TestMethod
    public void ok()
    {

    }

    @TestMethod
    public ko()
    {
        throw new IllegalStateException();
    }

    public void none()
    {

    }
}
