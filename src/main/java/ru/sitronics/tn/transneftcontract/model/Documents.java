//package ru.sitronics.tn.transneftcontract.model;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.util.Arrays;
//import java.util.Objects;
//
//@Entity
//public class Documents {
//    private int idDoc;
//    private String typeDoc;
//    private String serialNumber;
//    private Object createDate;
//    private String createUser;
//    private String curatorUser;
//    private byte[] content;
//    private String status;
//    private String access;
//    private String comment;
//
//    private String dataDocuments;
//
//    private String dataType;
//    private String historyDoc;
//    private String contract;
//    private String object;
//    private String pidNumber;
//    private String factoryNumber;
//    private String signatureStatus;
//    private String signatoryPerson;
//    private String readStatus;
//    private String readPerson;
//
//    @Id
//    @Column(name = "idDoc")
//    public int getIdDoc() {
//        return idDoc;
//    }
//
//    public void setIdDoc(int idDoc) {
//        this.idDoc = idDoc;
//    }
//
//    @Basic
//    @Column(name = "typeDoc")
//    public String getTypeDoc() {
//        return typeDoc;
//    }
//
//    public void setTypeDoc(String typeDoc) {
//        this.typeDoc = typeDoc;
//    }
//
//    @Basic
//    @Column(name = "serialNumber")
//    public String getSerialNumber() {
//        return serialNumber;
//    }
//
//    public void setSerialNumber(String serialNumber) {
//        this.serialNumber = serialNumber;
//    }
//
//    @Basic
//    @Column(name = "createDate")
//    public Object getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Object createDate) {
//        this.createDate = createDate;
//    }
//
//    @Basic
//    @Column(name = "createUser")
//    public String getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(String createUser) {
//        this.createUser = createUser;
//    }
//
//    @Basic
//    @Column(name = "curatorUser")
//    public String getCuratorUser() {
//        return curatorUser;
//    }
//
//    public void setCuratorUser(String curatorUser) {
//        this.curatorUser = curatorUser;
//    }
//
//    @Basic
//    @Column(name = "content")
//    public byte[] getContent() {
//        return content;
//    }
//
//    public void setContent(byte[] content) {
//        this.content = content;
//    }
//
//    @Basic
//    @Column(name = "status")
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Basic
//    @Column(name = "access")
//    public String getAccess() {
//        return access;
//    }
//
//    public void setAccess(String access) {
//        this.access = access;
//    }
//
//    @Basic
//    @Column(name = "comment")
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    @Basic
//    @Column(name = "dataDocuments")
//    public String getDataDocuments() {
//        return dataDocuments;
//    }
//
//    public void setDataDocuments(String dataDocuments) {
//        this.dataDocuments = dataDocuments;
//    }
//
//    @Basic
//    @Column(name = "dataType")
//    public String getDataType() {
//        return dataType;
//    }
//
//    public void setDataType(String dataType) {
//        this.dataType = dataType;
//    }
//
//    @Basic
//    @Column(name = "historyDoc")
//    public String getHistoryDoc() {
//        return historyDoc;
//    }
//
//    public void setHistoryDoc(String historyDoc) {
//        this.historyDoc = historyDoc;
//    }
//
//    @Basic
//    @Column(name = "contract")
//    public String getContract() {
//        return contract;
//    }
//
//    public void setContract(String contract) {
//        this.contract = contract;
//    }
//
//    @Basic
//    @Column(name = "object")
//    public String getObject() {
//        return object;
//    }
//
//    public void setObject(String object) {
//        this.object = object;
//    }
//
//    @Basic
//    @Column(name = "pidNumber")
//    public String getPidNumber() {
//        return pidNumber;
//    }
//
//    public void setPidNumber(String pidNumber) {
//        this.pidNumber = pidNumber;
//    }
//
//    @Basic
//    @Column(name = "factoryNumber")
//    public String getFactoryNumber() {
//        return factoryNumber;
//    }
//
//    public void setFactoryNumber(String factoryNumber) {
//        this.factoryNumber = factoryNumber;
//    }
//
//    @Basic
//    @Column(name = "signatureStatus")
//    public String getSignatureStatus() {
//        return signatureStatus;
//    }
//
//    public void setSignatureStatus(String signatureStatus) {
//        this.signatureStatus = signatureStatus;
//    }
//
//    @Basic
//    @Column(name = "signatoryPerson")
//    public String getSignatoryPerson() {
//        return signatoryPerson;
//    }
//
//    public void setSignatoryPerson(String signatoryPerson) {
//        this.signatoryPerson = signatoryPerson;
//    }
//
//    @Basic
//    @Column(name = "readStatus")
//    public String getReadStatus() {
//        return readStatus;
//    }
//
//    public void setReadStatus(String readStatus) {
//        this.readStatus = readStatus;
//    }
//
//    @Basic
//    @Column(name = "readPerson")
//    public String getReadPerson() {
//        return readPerson;
//    }
//
//    public void setReadPerson(String readPerson) {
//        this.readPerson = readPerson;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Documents documents = (Documents) o;
//        return idDoc == documents.idDoc &&
//                Objects.equals(typeDoc, documents.typeDoc) &&
//                Objects.equals(serialNumber, documents.serialNumber) &&
//                Objects.equals(createDate, documents.createDate) &&
//                Objects.equals(createUser, documents.createUser) &&
//                Objects.equals(curatorUser, documents.curatorUser) &&
//                Arrays.equals(content, documents.content) &&
//                Objects.equals(status, documents.status) &&
//                Objects.equals(access, documents.access) &&
//                Objects.equals(comment, documents.comment) &&
//                Objects.equals(dataDocuments, documents.dataDocuments) &&
//                Objects.equals(dataType, documents.dataType) &&
//                Objects.equals(historyDoc, documents.historyDoc) &&
//                Objects.equals(contract, documents.contract) &&
//                Objects.equals(object, documents.object) &&
//                Objects.equals(pidNumber, documents.pidNumber) &&
//                Objects.equals(factoryNumber, documents.factoryNumber) &&
//                Objects.equals(signatureStatus, documents.signatureStatus) &&
//                Objects.equals(signatoryPerson, documents.signatoryPerson) &&
//                Objects.equals(readStatus, documents.readStatus) &&
//                Objects.equals(readPerson, documents.readPerson);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(idDoc, typeDoc, serialNumber, createDate, createUser, curatorUser, status, access, comment, dataDocuments, dataType, historyDoc, contract, object, pidNumber, factoryNumber, signatureStatus, signatoryPerson, readStatus, readPerson);
//        result = 31 * result + Arrays.hashCode(content);
//        return result;
//    }
//}
