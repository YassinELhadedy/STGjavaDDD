package com.nextbit.yassin.stg2.domain.entity;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "SHIPMENT".
 */
@Entity
public class Shipment {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String shipmentBarcode;
    private int shipmentPickupid;

    @NotNull
    private String consigneeName;

    @NotNull
    private String consigneeAdd;

    @NotNull
    private String senderName;

    @NotNull
    private String notes;

    @NotNull
    private java.util.Date shipmentDate;
    private float cashcollect;
    private int status;
    private long sheetId;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public Shipment() {
    }

    public Shipment(Long id) {
        this.id = id;
    }

    @Generated
    public Shipment(Long id, String shipmentBarcode, int shipmentPickupid, String consigneeName, String consigneeAdd, String senderName, String notes, java.util.Date shipmentDate, float cashcollect, int status, long sheetId) {
        this.id = id;
        this.shipmentBarcode = shipmentBarcode;
        this.shipmentPickupid = shipmentPickupid;
        this.consigneeName = consigneeName;
        this.consigneeAdd = consigneeAdd;
        this.senderName = senderName;
        this.notes = notes;
        this.shipmentDate = shipmentDate;
        this.cashcollect = cashcollect;
        this.status = status;
        this.sheetId = sheetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getShipmentBarcode() {
        return shipmentBarcode;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setShipmentBarcode(@NotNull String shipmentBarcode) {
        this.shipmentBarcode = shipmentBarcode;
    }

    public int getShipmentPickupid() {
        return shipmentPickupid;
    }

    public void setShipmentPickupid(int shipmentPickupid) {
        this.shipmentPickupid = shipmentPickupid;
    }

    @NotNull
    public String getConsigneeName() {
        return consigneeName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setConsigneeName(@NotNull String consigneeName) {
        this.consigneeName = consigneeName;
    }

    @NotNull
    public String getConsigneeAdd() {
        return consigneeAdd;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setConsigneeAdd(@NotNull String consigneeAdd) {
        this.consigneeAdd = consigneeAdd;
    }

    @NotNull
    public String getSenderName() {
        return senderName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setSenderName(@NotNull String senderName) {
        this.senderName = senderName;
    }

    @NotNull
    public String getNotes() {
        return notes;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNotes(@NotNull String notes) {
        this.notes = notes;
    }

    @NotNull
    public java.util.Date getShipmentDate() {
        return shipmentDate;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setShipmentDate(@NotNull java.util.Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public float getCashcollect() {
        return cashcollect;
    }

    public void setCashcollect(float cashcollect) {
        this.cashcollect = cashcollect;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getSheetId() {
        return sheetId;
    }

    public void setSheetId(long sheetId) {
        this.sheetId = sheetId;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}