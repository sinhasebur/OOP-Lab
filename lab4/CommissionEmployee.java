public class CommissionEmployee extends Employee {
    int grossSales;
    double commission;

    CommissionEmployee(String firstName,String lastName,String socialSecurityNumber, int grossSales, double commission){
        super(firstName,lastName,socialSecurityNumber);
        this.grossSales=grossSales;
        this.commission=commission;
    }

    double earnings(){
        return commission*this.grossSales*0.01;
    }
    public String toString(){
        return super.toString()+" Commission Salary: "+commission;
    }
}
