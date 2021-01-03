package net.apicraft.mortgage.bl;

import net.apicraft.mortgage.model.ScheduleItem;

import java.util.*;

public class Amortizer {
    private double principal;
    private double rate;
    private int period;
    private Frequency frequency;

    public enum Frequency {
        MONTHLY, YEARLY
    }

    public Amortizer(double principal, double apr, int period, Frequency frequency) {
        this.principal = principal;
        switch(frequency) {
            case MONTHLY: {
                this.rate = apr / 12.0;
                this.period = period * 12;
                break;
            }
            case YEARLY: {
                this.rate = apr;
                this.period = period;
            }
        }
        this.frequency = frequency;
    }

    public List<ScheduleItem> amortize() {
        List<ScheduleItem> scheduleItemList = new ArrayList<>();
        double divisor = -((1.0 - Math.pow((1.0 + this.rate),this.period))/this.rate);
        double installment =  (this.principal / divisor) + this.principal * this.rate;
        double balance = this.principal;
        double interest = balance * this.rate;
        for (int i = 0; i < this.period; i++) {
            balance = balance - (installment - interest);
            ScheduleItem si = new ScheduleItem(installment - interest,interest,balance,new Date());
            scheduleItemList.add(si);
            interest = balance * this.rate;
        }
        return scheduleItemList;
    }
}
