package com.alibaba.ariver.resource.api.prepare;

import androidx.annotation.NonNull;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PrepareController {

    public enum Status {
        INIT,
        EXECUTING,
        ERROR,
        FINISH;

        public boolean canContinue() {
            return this == INIT || this == EXECUTING;
        }
    }

    void finish();

    Status getStatus();

    void lock(Object obj);

    void moveToError(PrepareException prepareException);

    void moveToNext();

    void onGetAppInfo(@NonNull AppModel appModel);

    void postTimeOut(long j);

    void setInterceptors(@NonNull List<StepInterceptor> list);

    void start();

    void unlock(Object obj);
}
