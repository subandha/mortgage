package net.apicraft.mortgage.model;

import java.math.BigDecimal;
import java.util.List;

public class AmortizationSchedule {
    private BigDecimal principal;
    private double apr;
    private String period;
    private BigDecimal installmentAmount;
    private List<ScheduleItem> scheduleItems;

    public AmortizationSchedule(BigDecimal principal, double apr, String period) {
        this.principal = principal;
        this.apr = apr;
        this.period = period;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public List<ScheduleItem> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }
}
