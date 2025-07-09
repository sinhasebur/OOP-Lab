public class PayRollSystem{
    public static void main(String[] args) {

        Employee[] employees = new Employee[4];

        employees[0]= new SalariedEmployee("Rafiq","Alam","1010101",15000);
        employees[1]= new HourlyEmployee("Romiz","Mia","8081019801",1000,5);
        employees[2]= new CommissionEmployee("Akbar","Rahman","123123412",200000,20);
        employees[3]= new BasePlusCommissionEmployee("Nadir","Islam","13123567632",500000,15,50000);


        for(int i=0;i<employees.length;i++){
            if(employees[i] instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee b = (BasePlusCommissionEmployee)employees[i];
                double oldSalary = b.earnings();
                b.setSalary(oldSalary*1.1);
            }
        }
        for(int i=0;i<employees.length;i++){
            System.out.print(employees[i].toString()+" ");

            System.out.println( "Total weekly earning "+ employees[i].earnings());
        }
    }
}

