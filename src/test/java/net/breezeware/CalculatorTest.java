package net.breezeware;

import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@FullOGNL
public class CalculatorTest {

    public int add(int a, int b) {
        System.out.println(a+b);
        return a + b;
    }
}
