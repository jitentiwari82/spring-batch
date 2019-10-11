package com.rudra.config;

import com.rudra.repository.FinancialSurvey;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class BatchConfigration {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<FinancialSurvey> reader, ItemProcessor<FinancialSurvey, FinancialSurvey> processor, ItemWriter<FinancialSurvey> writer) {
        Step step = stepBuilderFactory.get("ETL-SURVEY").<FinancialSurvey, FinancialSurvey>chunk(1000).reader(reader).processor(processor).writer(writer).build();

        Job job = jobBuilderFactory.get("ETL-LOAD").incrementer(new RunIdIncrementer()).start(step).build();
        return job;
    }

    @Bean
    public FlatFileItemReader reader(@Value("${input}") Resource resource) {
        FlatFileItemReader<FinancialSurvey> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(mapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<FinancialSurvey> mapper() {
        DefaultLineMapper<FinancialSurvey> defaultLineMapper = new DefaultLineMapper();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setStrict(false);
        tokenizer.setNames(new String[]{"id", "year", "industry_aggregation_NZSIOC", "industry_code_NZSIOC", "industry_name_NZSIOC", "units", "variable_code", "variable_name", "variable_category", "value", "industry_code_ANZSIC06"});
        BeanWrapperFieldSetMapper<FinancialSurvey> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(FinancialSurvey.class);
        defaultLineMapper.setLineTokenizer(tokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        return defaultLineMapper;
    }
}


