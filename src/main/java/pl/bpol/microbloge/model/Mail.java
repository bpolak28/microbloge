package pl.bpol.microbloge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Mail {

    @Id
    @GeneratedValue
    private long id;
    private String address;
    private String Subject;
    private String note;
    private LocalDateTime dateOfMailSending;

    public Mail() {
    }

    public Mail(String address, String subject, String note) {
        this.address = address;
        Subject = subject;
        this.note = note;
    }

    public LocalDateTime getDateOfMailSending() {
        return dateOfMailSending;
    }

    public void setDateOfMailSending(LocalDateTime dateOfMailSending) {
        this.dateOfMailSending = dateOfMailSending;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(address, mail.address) &&
                Objects.equals(Subject, mail.Subject) &&
                Objects.equals(note, mail.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(address, Subject, note);
    }

    @Override
    public String toString() {
        return "Mail{" +
                "address='" + address + '\'' +
                ", Subject='" + Subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
