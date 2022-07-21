package entities;

public class Rent {
    private int roomNumber;
    private String studentName;
    private String studentEmail;

    public Rent(int roomNumber, String studentName, String studentEmail) {
        this.roomNumber = roomNumber;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return  roomNumber +
                ": " +
                studentName + ", " +
                studentEmail;
    }
}
