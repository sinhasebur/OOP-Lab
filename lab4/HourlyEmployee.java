public class HourlyEmployee extends Employee{
    double hourlySalary;
    double hours;

    HourlyEmployee(String firstName,String lastName,String socialSecurityNumber,double hourlySalary,double hours){
        super(firstName,lastName,socialSecurityNumber);
        this.hourlySalary=hourlySalary;
        this.hours=hours;
    }
    public double getHourlySalary(){
        return hourlySalary;
    }
    public double earnings(){
        return hours*getHourlySalary();
    }
    public String toString(){
        return super.toString()+" Hourly Salary: "+hourlySalary;
    }

}
