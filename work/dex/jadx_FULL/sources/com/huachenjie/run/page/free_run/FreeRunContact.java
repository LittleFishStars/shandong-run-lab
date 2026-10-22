package com.huachenjie.run.page.free_run;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.bean.UnfinishedRun;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface FreeRunContact {

    public interface FreeRunView extends BaseView {
        void finishRunFailed(int code, String message);

        void finishRunSucceed();

        void haveUnFinishedRun(UnfinishedRun unfinishedRun);

        void noUnFinishedRun();

        void queryStaticsFailed();

        void queryStaticsSuccess();

        void startRunFailed(String message);

        void startRunSucceed(String runRecordCode);
    }

    public static abstract class Presenter extends BasePresenter<FreeRunView> {
        public abstract void f();

        public abstract void g(int timeType, int sportType);

        public abstract void h(double lat, double lng, long aimDistance, long aimDuration, int aimCalorie);

        public abstract void i(Map<String, Object> params);
    }
}
