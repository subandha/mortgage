package net.apicraft.mortgage.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ScheduleItem {
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal balance;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date scheduleDate;

    public ScheduleItem(BigDecimal principal, BigDecimal interest, BigDecimal balance, Date scheduleDate) {
        this.principal = principal;
        this.interest = interest;
        this.balance = balance;
        this.scheduleDate = scheduleDate;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
