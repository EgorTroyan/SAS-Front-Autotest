package db.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Enrollment_ID")
    private long id;

    @Column(name="Enrollment_String")
    private String string;

    @Column(name="Enrollment_UserID")
    private long userId;

    @Column(name="Enrollment_TokenType")
    private long tokenType;

    @Column(name="Enrollment_TokenID")
    private long tokenId;

    @Column(name="Enrollment_OrgID")
    private long orgId;

    @Column(name="Enrollment_StartDateTime")
    private LocalDateTime startDate;

    @Column(name="Enrollment_StopDateTime")
    private LocalDateTime stopDate;

    @Column(name="Enrollment_FailedAttempts")
    private long failedAttempts;

    @Column(name="Enrollment_OwnerID")
    private long ownerId;

    public Enrollment() {
    }

    public Enrollment(String string, long userId, long tokenType, long orgId, LocalDateTime startDate, LocalDateTime stopDate, long ownerId) {
        this.string = string;
        this.userId = userId;
        this.tokenType = tokenType;

        this.orgId = orgId;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTokenType() {
        return tokenType;
    }

    public void setTokenType(long tokenType) {
        this.tokenType = tokenType;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDateTime stopDate) {
        this.stopDate = stopDate;
    }

    public long getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(long failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
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
