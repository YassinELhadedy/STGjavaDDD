package com.nextbit.yassin.stg2.infrastructure.cache.implement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nextbit.yassin.stg2.domain.entity.Sheet;
import com.nextbit.yassin.stg2.infrastructure.cache.DaoMaster;
import com.nextbit.yassin.stg2.infrastructure.cache.DaoSession;
import com.nextbit.yassin.stg2.infrastructure.cache.SheetDao;

import java.util.List;

import io.reactivex.Observable;

import static org.greenrobot.greendao.test.DbTest.DB_NAME;



public class SheetCache implements EntityCache<Sheet> {

    private final Context context;

    public SheetCache(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public Observable<Sheet> get(int Id) {

        return getEntity(Id);
    }

    @Override
    public Observable<List<Sheet>> getAll() {
        return getListFromGreenDao();
    }

    @Override
    public void put(Sheet Entity) {
     insert(Entity);

    }

    @Override
    public boolean isCached(int Id) {

        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {
        deleteAll();

    }

    @Override
    public void delete(Sheet entity) {
        deleteEntity(entity);

    }

    @Override
    public void update(Sheet entity) {
        updateEntity(entity);
    }


    public SheetDao setupDb(){
        DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null); //create database db file if not exist
        SQLiteDatabase db = masterHelper.getWritableDatabase();  //get the created database db file
        DaoMaster master = new DaoMaster(db);//create masterDao
        DaoSession masterSession=master.newSession(); //Creates Session session
        return masterSession.getSheetDao();
    }

    public  Observable<List<Sheet>> getListFromGreenDao(){
         SheetDao sheetDao=setupDb(); // Sql access object

        List<Sheet>sheetList= sheetDao.queryBuilder().orderDesc(SheetDao.Properties.Id).build().list();
        Observable<List<Sheet>>sheetObservable=Observable.just(sheetList);


        return sheetObservable;

    }

    public void insert(Sheet sheet) {
        SheetDao sheetDao=setupDb(); // Sql access object


        sheetDao.insert(sheet);
    }
    public void deleteEntity(Sheet sheet){
        SheetDao sheetDao=setupDb(); // Sql access object
        sheetDao.delete(sheet);

    }
    public void updateEntity(Sheet sheet){
        SheetDao sheetDao=setupDb(); // Sql access object

        sheetDao.update(sheet);


    }
    public void deleteAll(){
        SheetDao sheetDao=setupDb(); // Sql access object
        sheetDao.deleteAll();


    }
    public Observable<Sheet> getEntity(int id){
        SheetDao sheetDao=setupDb(); // Sql access object
        Sheet sheet= sheetDao.queryBuilder()
                .where(SheetDao.Properties.Id.eq(id))
                .orderAsc(SheetDao.Properties.Id)
                .list().get(0);

 Observable<Sheet>sheetObservable=Observable.just(sheet);
        return sheetObservable;


    }
}
