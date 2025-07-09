public class BasePlusCommissionEmployee extends CommissionEmployee {
    double baseSalary;

    BasePlusCommissionEmployee(String firstName,String lastName,String socialSecurityNumber, int grossSales, double commission, double baseSalary){
        super( firstName, lastName, socialSecurityNumber,  grossSales, commission);
        this.baseSalary=baseSalary;
    }
    public double earnings(){
        return super.earnings()+baseSalary;
    }
    public String toString(){
        return super.toString()+" Base Salary: "+baseSalary;
    }
    public void setSalary(double baseSalary){
        this.baseSalary=baseSalary;
    }
}
