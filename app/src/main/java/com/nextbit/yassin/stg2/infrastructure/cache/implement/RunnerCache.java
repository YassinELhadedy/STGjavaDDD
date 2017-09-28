package com.nextbit.yassin.stg2.infrastructure.cache.implement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.nextbit.yassin.stg2.domain.entity.Runner;
import com.nextbit.yassin.stg2.infrastructure.cache.DaoMaster;
import com.nextbit.yassin.stg2.infrastructure.cache.DaoSession;
import com.nextbit.yassin.stg2.infrastructure.cache.RunnerDao;
import com.nextbit.yassin.stg2.infrastructure.cache.SheetDao;

import java.util.List;

import io.reactivex.Observable;

import static org.greenrobot.greendao.test.DbTest.DB_NAME;

/**
 * Created by yassin on 9/13/17.
 */

public class RunnerCache implements EntityCache<Runner> {
    private final Context context;

    public RunnerCache(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public Observable<Runner> get(int Id) {


        return  getEntity(Id);
    }

    @Override
    public Observable<List<Runner>> getAll() {
        return getListFromGreenDao();
    }

    @Override
    public void put(Runner Entity) {
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
    public void delete(Runner entity) {
        deleteEntity(entity);

    }

    @Override
    public void update(Runner entity) {
        updateEntity(entity);
    }

    public RunnerDao setupDb(){
        DaoMaster.DevOpenHelper masterHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null); //create database db file if not exist
        SQLiteDatabase db = masterHelper.getWritableDatabase();  //get the created database db file
        DaoMaster master = new DaoMaster(db);//create masterDao
        DaoSession masterSession=master.newSession(); //Creates Session session
        return masterSession.getRunnerDao();
    }

    public  Observable<List<Runner>> getListFromGreenDao(){
        RunnerDao runnerDao=setupDb(); // Sql access object

        List<Runner>runnerList= runnerDao.queryBuilder().orderDesc(RunnerDao.Properties.Id).build().list();
        Observable<List<Runner>>observable=Observable.just(runnerList);


        return observable ;

    }

    public void insert(Runner runner) {
        RunnerDao runnerDao=setupDb(); // Sql access object


        runnerDao.insert(runner);
    }
    public void deleteEntity(Runner runner){
        RunnerDao runnerDao=setupDb(); // Sql access object
        runnerDao.delete(runner);

    }
    public void updateEntity(Runner runner){
        RunnerDao runnerDao=setupDb(); // Sql access object

        runnerDao.update(runner);


    }
    public void deleteAll(){
        RunnerDao runnerDao=setupDb(); // Sql access object
        runnerDao.deleteAll();


    }
    public Observable<Runner> getEntity(int id){
        RunnerDao runnerDao=setupDb(); // Sql access object
        Runner runner= runnerDao.queryBuilder()
                .where(RunnerDao.Properties.Id.eq(id))
                .orderAsc(RunnerDao.Properties.Id)
                .list().get(0);

        Observable<Runner>runnerObservable=Observable.just(runner);
        return runnerObservable;


    }
}
