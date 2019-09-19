package com.david.learn;

import com.david.learn.interfaces.TaxService;
import com.david.learn.pojos.Person;
import com.david.learn.tax.MeanTaxFactorCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    private static final double TAX_FACTOR = 10;

    @Mock
    private TaxService taxService;

    @InjectMocks
    private MeanTaxFactorCalculator taxFactorCalculator;

    @Test
    public void shouldCalculateMeanTaxFactor(){
        given(taxService.getCurrentTaxFactorFor(any(Person.class)))
                .willReturn(TAX_FACTOR);

        double meanTaxFactor = taxFactorCalculator.calculateMeanTaxFactorFor(new Person());

        then(meanTaxFactor).equals(TAX_FACTOR);
    }

}
