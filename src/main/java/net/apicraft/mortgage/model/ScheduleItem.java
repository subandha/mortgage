package net.apicraft.mortgage.model;

import java.util.Date;

public class ScheduleItem {
    private double principal;
    private double interest;
    private double balance;
    private Date scheduleDate;

    public ScheduleItem(double principal, double interest, double balance, Date scheduleDate) {
        this.principal = principal;
        this.interest = interest;
        this.balance = balance;
        this.scheduleDate = scheduleDate;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
