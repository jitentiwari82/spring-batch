package com.rudra.batch;

import com.rudra.repository.FinancialSurvey;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<FinancialSurvey, FinancialSurvey> {
    @Override
    public FinancialSurvey process(FinancialSurvey item) throws Exception {
        System.out.println("Processing..");
        return item;
    }
}
