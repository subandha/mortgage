package net.apicraft.mortgage.bl;

import net.apicraft.mortgage.model.AmortizationSchedule;
import net.apicraft.mortgage.model.ScheduleItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Amortizer {
    private double principal;
    private double rate;
    private int period;
    private Frequency frequency;
    private AmortizationSchedule amortizationSchedule;

    public enum Frequency {
        MONTHLY, YEARLY
    }

    public Amortizer(double principal, double apr, int period, Frequency frequency) {
        this.principal = principal;
        String freqStr = period == 1 ? " year" : " years";
        switch(frequency) {
            case MONTHLY: {
                this.rate = (apr / 100) / 12.0;
                this.period = period * 12;
                break;
            }
            case YEARLY: {
                this.rate = apr / 100;
                this.period = period;
            }
        }
        this.frequency = frequency;
        this.amortizationSchedule = new AmortizationSchedule(new BigDecimal(this.principal).setScale(2,RoundingMode.HALF_UP), apr, "" + period + freqStr);
    }

    public AmortizationSchedule amortize() {
        List<ScheduleItem> scheduleItemList = new ArrayList<>();

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();

        double divisor = -((1.0 - Math.pow((1.0 + this.rate),this.period))/this.rate);
        double installment =  (this.principal / divisor) + this.principal * this.rate;
        double balance = this.principal;
        double interest = balance * this.rate;

        for (int i = 0; i < this.period; i++) {
            balance = balance - (installment - interest);
            BigDecimal d = new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP);
            calendar.setTime(today);
            switch(this.frequency) {
                case YEARLY: { calendar.add(Calendar.YEAR,i + 1); break; }
                case MONTHLY: { calendar.add(Calendar.MONTH,i + 1); break; }
            }
            ScheduleItem si = new ScheduleItem(
                    new BigDecimal(installment - interest).setScale(2, RoundingMode.HALF_UP),
                    new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP),
                    new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP),
                    calendar.getTime());
            scheduleItemList.add(si);
            interest = balance * this.rate;
        }

        this.amortizationSchedule.setInstallmentAmount(new BigDecimal(installment).setScale(2,RoundingMode.HALF_UP));
        this.amortizationSchedule.setScheduleItems(scheduleItemList);

        return this.amortizationSchedule;
    }
}
