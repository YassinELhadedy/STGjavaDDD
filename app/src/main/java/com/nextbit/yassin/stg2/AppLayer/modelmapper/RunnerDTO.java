package com.nextbit.yassin.stg2.AppLayer.modelmapper;

import com.nextbit.yassin.stg2.domain.entity.Sheet;

import java.util.List;

/**
 * Created by yassin on 9/11/17.
 */

public class RunnerDTO {
    private  Long id;

    private String runnerName;


    private String runnerCode;


    private String runnerPassword;

    private List<Sheet> runnerSheet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sheet> getRunnerSheet() {
        return runnerSheet;
    }

    public void setRunnerSheet(List<Sheet> runnerSheet) {
        this.runnerSheet = runnerSheet;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public String getRunnerCode() {
        return runnerCode;
    }

    public void setRunnerCode(String runnerCode) {
        this.runnerCode = runnerCode;
    }

    public String getRunnerPassword() {
        return runnerPassword;
    }

    public void setRunnerPassword(String runnerPassword) {
        this.runnerPassword = runnerPassword;
    }
}
