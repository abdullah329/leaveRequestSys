/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leaverequest.core.balance;

import java.util.Objects;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/

public class LeaveBalances {

    private int entitledYears;
    private int entitledAmount;
    private int totalDaysTaken;
    private int balance;

    public LeaveBalances(int entitledYears, int entitledAmount, int totalDaysTaken, int balance) {
        this.entitledYears = entitledYears;
        this.entitledAmount = entitledAmount;
        this.totalDaysTaken = totalDaysTaken;
        this.balance = balance;
    }

    public int getEntitledYears() {
        return entitledYears;
    }

    public int getEntitledAmount() {
        return entitledAmount;
    }

    public int getTotalDaysTaken() {
        return totalDaysTaken;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveBalances that = (LeaveBalances) o;
        return entitledYears == that.entitledYears &&
                entitledAmount == that.entitledAmount &&
                totalDaysTaken == that.totalDaysTaken &&
                balance == that.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entitledYears, entitledAmount, totalDaysTaken, balance);
    }

    @Override
    public String toString() {
        return "LeaveBalances{" +
                "entitledYears=" + entitledYears +
                ", entitledAmount=" + entitledAmount +
                ", totalDaysTaken=" + totalDaysTaken +
                ", balance=" + balance +
                '}';
    }
}
