public class SalariedEmployee extends Employee {
        double weeklySalary;

        SalariedEmployee(String firstName,String lastName,String socialSecurityNumber,double weeklySalary){
            super(firstName,lastName,socialSecurityNumber);
            this.weeklySalary=weeklySalary;
        }

        double getSalary(){
        return weeklySalary;
        }


        double earnings(){
            return getSalary();
        }

        void setSalary(double weeklySalary){
            this.weeklySalary = weeklySalary;
        }

        public String toString(){
            return super.toString()+" Weekly Salary: "+weeklySalary;
        }

}
