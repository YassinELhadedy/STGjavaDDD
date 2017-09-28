package com.nextbit.yassin.stg2.domain.interactor;

import android.support.v4.util.Preconditions;

import com.nextbit.yassin.stg2.domain.entity.Sheet;
import com.nextbit.yassin.stg2.domain.executor.PostExecutionThread;
import com.nextbit.yassin.stg2.domain.executor.ThreadExecutor;
import com.nextbit.yassin.stg2.infrastructure.repository.SheetRepository;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/17/17.
 */

public class GetSheetId extends UseCase<Sheet, GetSheetId.Params> {

    private final SheetRepository sheetRepository;


    GetSheetId(SheetRepository sheetRepository, ThreadExecutor threadExecutor,
               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.sheetRepository = sheetRepository;
    }

    @Override
    Observable<Sheet> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.sheetRepository.getOfEntiny(params.sheetId);
    }

    public static final class Params {

        private final int sheetId;

        private Params(int sheetId) {
            this.sheetId = sheetId;
        }

        public static Params forSheet(int sheetId) {
            return new Params(sheetId);
        }
    }
}

