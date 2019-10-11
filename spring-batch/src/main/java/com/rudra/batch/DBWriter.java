package com.rudra.batch;

import com.rudra.repository.FinancialSurvey;
import com.rudra.repository.SurveyRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<FinancialSurvey> {
    @Autowired
    private SurveyRepository surveyRepository;



    @Override
    public void write(List<? extends FinancialSurvey> financialSurveys) throws Exception {
        System.out.println("Saving...");
        surveyRepository.save(financialSurveys);
    }
}
