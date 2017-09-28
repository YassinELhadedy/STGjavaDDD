package com.nextbit.yassin.stg2.AppLayer.modelmapper;

import com.nextbit.yassin.stg2.domain.entity.Shipment;

import java.util.Date;
import java.util.List;

/**
 * Created by yassin on 9/11/17.
 */

public class SheetDTO {
    private Long id;
    private long runnerId;

    private java.util.Date sheetDate;
    private List<Shipment> SheetShipment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public Date getSheetDate() {
        return sheetDate;
    }

    public void setSheetDate(Date sheetDate) {
        this.sheetDate = sheetDate;
    }

    public List<Shipment> getSheetShipment() {
        return SheetShipment;
    }

    public void setSheetShipment(List<Shipment> sheetShipment) {
        SheetShipment = sheetShipment;
    }
}
