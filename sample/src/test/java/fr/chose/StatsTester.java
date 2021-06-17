package fr.chose;

import fr.lernejo.tester.api.TestMethod;

public class StatsTester
{
    @TestMethod
    public void basic()
    {
        Stats s = Stats.of(5, 10, 15);

        if (s.min() != 5 || s.max() != 15 || s.sum() != 30 || s.avg() != 10)
            throw new IllegalStateException();
    }
}
