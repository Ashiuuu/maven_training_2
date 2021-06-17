package com.bidule;

import fr.lernejo.tester.api.TestMethod;

public class FactTester
{
    @TestMethod
    public void basic()
    {
        if (new Fact().fact(4) != 24)
            throw new IllegalStateException();
    }
}
