package com.david.learn;

import com.david.learn.interfaces.TaxService;
import com.david.learn.entities.Person;
import com.david.learn.tax.MeanTaxFactorCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    private static final double TAX_FACTOR = 10;

    @Mock
    private TaxService taxService;

    //@InjectMocks
    private MeanTaxFactorCalculator taxFactorCalculator;

    @Test
    public void shouldCalculateMeanTaxFactor(){
        given(taxService.getCurrentTaxFactorFor(any(Person.class)))
                .willReturn(TAX_FACTOR);

        double meanTaxFactor = taxFactorCalculator.calculateMeanTaxFactorFor(new Person());

        then(meanTaxFactor).equals(TAX_FACTOR);
    }

    @Test
    public void thenTest(){
        taxFactorCalculator = mock(MeanTaxFactorCalculator.class);

        when(taxFactorCalculator.calculateMeanTaxFactorFor(any(Person.class)))
                .thenReturn(1D, 2D, 3D);

        assertEquals(1D, taxFactorCalculator.calculateMeanTaxFactorFor(new Person()));
        assertEquals(2D, taxFactorCalculator.calculateMeanTaxFactorFor(new Person()));
        assertEquals(3D, taxFactorCalculator.calculateMeanTaxFactorFor(new Person()));
        assertEquals(3D, taxFactorCalculator.calculateMeanTaxFactorFor(new Person()));
    }

}
