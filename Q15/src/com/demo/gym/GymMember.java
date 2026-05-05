package com.demo.gym;

public class GymMember {

    protected int memberId;
    protected String memberName;
    protected String planType;
    protected double fees;
    protected String status; // active / inactive

    public GymMember(int memberId, String memberName, String planType,
                     double fees, String status) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.planType = planType;
        this.fees = fees;
        this.status = status;
    }

    public int getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
    public String getPlanType() { return planType; }
    public double getFees() { return fees; }
    public String getStatus() { return status; }

    public void setFees(double fees) { this.fees = fees; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "ID=" + memberId + ", Name=" + memberName +
               ", Plan=" + planType + ", Fees=" + fees +
               ", Status=" + status;
    }
}
