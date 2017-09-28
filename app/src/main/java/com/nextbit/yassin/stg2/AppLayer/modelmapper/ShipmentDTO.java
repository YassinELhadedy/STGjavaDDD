package com.nextbit.yassin.stg2.AppLayer.modelmapper;

import com.mobandme.android.transformer.compiler.Mapped;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * Created by yassin on 9/11/17.
 */

public class ShipmentDTO {
    private Long id;


    private String shipmentBarcode;
    private int shipmentPickupid;
    private String consigneeName;
    private String consigneeAdd;
    private String senderName;
    private String notes;
    private java.util.Date shipmentDate;
    private float cashcollect;
    private int status;
    private long sheetId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentBarcode() {
        return shipmentBarcode;
    }

    public void setShipmentBarcode(String shipmentBarcode) {
        this.shipmentBarcode = shipmentBarcode;
    }

    public int getShipmentPickupid() {
        return shipmentPickupid;
    }

    public void setShipmentPickupid(int shipmentPickupid) {
        this.shipmentPickupid = shipmentPickupid;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAdd() {
        return consigneeAdd;
    }

    public void setConsigneeAdd(String consigneeAdd) {
        this.consigneeAdd = consigneeAdd;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
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
}

