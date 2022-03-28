//package ru.sitronics.tn.transneftcontract.model;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.sql.Date;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//public class Report {
//    private long id;
//    private Long reportTypeId;
//    private Date createDate;
//
//
//
//    @Id
//    @Column(name = "id")
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "report_type_id")
//    public Long getReportTypeId() {
//        return reportTypeId;
//    }
//
//    public void setReportTypeId(Long reportTypeId) {
//        this.reportTypeId = reportTypeId;
//    }
//
//    @Basic
//    @Column(name = "create_date")
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Report report = (Report) o;
//        return id == report.id &&
//                Objects.equals(reportTypeId, report.reportTypeId) &&
//                Objects.equals(createDate, report.createDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, reportTypeId, createDate);
//    }
//}
