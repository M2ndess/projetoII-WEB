package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "error_report", schema = "public", catalog = "proj2")
public class ErrorReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_errorreport")
    private int idErrorReport;
    @Basic
    @Column(name = "error_typer")
    private String errorType;
    @Basic
    @Column(name = "description")
    private String description;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}