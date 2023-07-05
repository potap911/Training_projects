public class EmailAddress {
    private String email;
    private String someData;

    public EmailAddress(String email) {
        this.email = email;
        this.someData = someData;
    }

    public String getEmail() {
        return email;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + '\'' +
                ", someData='" + someData + '\'' +
                '}';
    }
}

