package model;

public class Participant {
    private String name, phone, email, address, gender, dob, degree, picturePath;
    private String position, interDept, experience;

    public Participant(String name, String phone, String email, String address, String gender,
                       String dob, String degree, String picturePath,
                       String position, String interDept, String experience) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.degree = degree;
        this.picturePath = picturePath;
        this.position = position;
        this.interDept = interDept;
        this.experience = experience;
    }

    public String toString() {


        return String.join("\n",
                name, phone, email, address, gender, dob, degree, picturePath,
                position, interDept, experience
        )+"\n";
    }
}
