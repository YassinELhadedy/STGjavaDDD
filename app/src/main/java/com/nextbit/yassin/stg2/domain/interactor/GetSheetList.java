package com.nextbit.yassin.stg2.domain.interactor;

import com.nextbit.yassin.stg2.domain.entity.Sheet;
import com.nextbit.yassin.stg2.domain.executor.PostExecutionThread;
import com.nextbit.yassin.stg2.domain.executor.ThreadExecutor;
import com.nextbit.yassin.stg2.infrastructure.repository.SheetRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/17/17.
 */

public class GetSheetList extends UseCase<List<Sheet>, Void> {

    private final SheetRepository sheetRepository;


    GetSheetList(SheetRepository sheetRepository, ThreadExecutor threadExecutor,
                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.sheetRepository = sheetRepository;
    }

    @Override
    Observable<List<Sheet>> buildUseCaseObservable(Void unused) {
        return this.sheetRepository.getAllOfEntiny();
    }
}
