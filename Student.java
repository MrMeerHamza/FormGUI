// Student Class
class Student {
    private String name, fatherName, city, address, email, gender, image;

    public Student(String name, String fatherName, String city, String address, String email, String gender, String image) {
        this.name = name;
        this.fatherName = fatherName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.image = image;
    }

    // Custom method to display student information in a readable format
    public String displayStudentInfo() {
        return "------ Student Information ------\n" +
                "Name         : " + name + "\n" +
                "Father Name  : " + fatherName + "\n" +
                "City         : " + city + "\n" +
                "Address      : " + address + "\n" +
                "Email        : " + email + "\n" +
                "Gender       : " + gender + "\n" +
                "Image        : " + image + "\n" +
                "---------------------------------\n";
    }
}