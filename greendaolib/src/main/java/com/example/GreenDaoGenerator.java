package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
//        Schema schema = new Schema(1, "com.nextbit.yassin.stg2.infrastructure.cashe");
//        schema.enableKeepSectionsByDefault();
//
//        addTables(schema);
//
//        try {
//            /* Use forward slashes if you're on macOS or Unix, i.e. "/app/src/main/java"  */
//            new DaoGenerator().generateAll(schema, "./app/src/main/java");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("Xaxxa");

    }

    private static void addTables(final Schema schema) {
        Entity sheet = addSheet(schema);
        Entity shipment = addShipment(schema);
        Entity runner = addRunner(schema);

        Property sheetId = shipment.addLongProperty("sheetId").notNull().getProperty();
        sheet.addToMany(shipment, sheetId, "sheetShipment");

        Property runnerId = sheet.addLongProperty("runnerId").notNull().getProperty();
        runner.addToMany(sheet, runnerId, "runnerSheet");
    }

    private static Entity addRunner(final Schema schema) {
        Entity runner = schema.addEntity("Runner");
        runner.addIdProperty().primaryKey().autoincrement();
        runner.addStringProperty("runnerName").notNull();
        runner.addStringProperty("runnerCode").notNull();
        runner.addStringProperty("runnerPassword").notNull();


        return runner;
    }

    private static Entity addSheet(final Schema schema) {
        Entity sheet = schema.addEntity("Sheet");
        sheet.addIdProperty().primaryKey().autoincrement();
        sheet.addDateProperty("sheetDate").notNull();



        return sheet;
    }

    private static Entity addShipment(final Schema schema) {
        Entity shipment = schema.addEntity("Shipment");
        shipment.addIdProperty().primaryKey().autoincrement();
        shipment.addStringProperty("shipmentBarcode").notNull();
        shipment.addIntProperty("shipmentPickupid").notNull();
        shipment.addStringProperty("consigneeName").notNull();
        shipment.addStringProperty("consigneeAdd").notNull();
        shipment.addStringProperty("senderName").notNull();
        shipment.addStringProperty("notes").notNull();
        shipment.addDateProperty("shipmentDate").notNull();
        shipment.addFloatProperty("cashcollect").notNull();
        shipment.addIntProperty("status").notNull();



        return shipment;
    }
}
