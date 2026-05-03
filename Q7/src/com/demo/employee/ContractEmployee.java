package com.demo.employee;

public class ContractEmployee extends Employee {

    private int contractDuration;
    private String agencyName;

    public ContractEmployee(int id, String name, double sal, String dept, boolean status,
                            int contractDuration, String agencyName) {
        super(id, name, sal, dept, status);
        this.contractDuration = contractDuration;
        this.agencyName = agencyName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Duration: " + contractDuration + " months, Agency: " + agencyName);
    }
}
