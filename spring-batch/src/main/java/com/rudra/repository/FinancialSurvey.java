package com.rudra.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinancialSurvey {
    @Id
    Integer id;
    String year;
    String industry_aggregation_NZSIOC;
    Long industry_code_NZSIOC;
    String industry_name_NZSIOC;
    String units;
    String variable_code;
    String variable_name;
    String variable_category;
    Long value;
    String industry_code_ANZSIC06;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIndustry_aggregation_NZSIOC() {
        return industry_aggregation_NZSIOC;
    }

    public void setIndustry_aggregation_NZSIOC(String industry_aggregation_NZSIOC) {
        this.industry_aggregation_NZSIOC = industry_aggregation_NZSIOC;
    }

    public Long getIndustry_code_NZSIOC() {
        return industry_code_NZSIOC;
    }

    public void setIndustry_code_NZSIOC(Long industry_code_NZSIOC) {
        this.industry_code_NZSIOC = industry_code_NZSIOC;
    }

    public String getIndustry_name_NZSIOC() {
        return industry_name_NZSIOC;
    }

    public void setIndustry_name_NZSIOC(String industry_name_NZSIOC) {
        this.industry_name_NZSIOC = industry_name_NZSIOC;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getVariable_code() {
        return variable_code;
    }

    public void setVariable_code(String variable_code) {
        this.variable_code = variable_code;
    }

    public String getVariable_name() {
        return variable_name;
    }

    public void setVariable_name(String variable_name) {
        this.variable_name = variable_name;
    }

    public String getVariable_category() {
        return variable_category;
    }

    public void setVariable_category(String variable_category) {
        this.variable_category = variable_category;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getIndustry_code_ANZSIC06() {
        return industry_code_ANZSIC06;
    }

    public void setIndustry_code_ANZSIC06(String industry_code_ANZSIC06) {
        this.industry_code_ANZSIC06 = industry_code_ANZSIC06;
    }


}
