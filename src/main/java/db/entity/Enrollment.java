package db.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Enrollment_ID")
    private int id;

    @Column(name="Enrollment_String")
    private String string;

    @Column(name="Enrollment_UserID")
    private int userId;

    @Column(name="Enrollment_TokenType")
    private int tokenType;

    @Column(name="Enrollment_TokenID")
    private int tokenId;

    @Column(name="Enrollment_OrgID")
    private int  orgId;

    @Column(name="Enrollment_StartDateTime")
    private LocalDate startDate;

    @Column(name="Enrollment_StopDateTime")
    private LocalDate stopDate;

    @Column(name="Enrollment_FailedAttempts")
    private int failedAttempts;

    @Column(name="Enrollment_OwnerID")
    private int ownerId;

    public Enrollment() {
    }

    public Enrollment(String string, int userId, int tokenType, int orgId, LocalDate startDate, LocalDate stopDate, int ownerId) {
        this.string = string;
        this.userId = userId;
        this.tokenType = tokenType;

        this.orgId = orgId;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", string='" + string + '\'' +
                ", userId=" + userId +
                ", tokenType=" + tokenType +
                ", tokenId=" + tokenId +
                ", orgId=" + orgId +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                ", failedAttempts=" + failedAttempts +
                ", ownerId=" + ownerId +
                '}';
    }
}
