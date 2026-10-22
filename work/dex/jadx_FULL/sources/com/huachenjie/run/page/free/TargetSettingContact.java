package com.huachenjie.run.page.free;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.bean.UnfinishedRun;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface TargetSettingContact {

    public static abstract class Presenter extends BasePresenter<TargetSettingView> {
        public abstract void f();

        public abstract void g(double lat, double lng, long aimDistance, long aimDuration, long aimCalorie);

        public abstract void h(Map<String, Object> params);

        public abstract void i(Map<String, Object> params);
    }

    public interface TargetSettingView extends BaseView {
        void finishRunFailed(int code, String message);

        void finishRunSucceed();

        void g(String runRecordCode, long aimDistance, long aimDuration, long aimCalorie);

        void haveUnFinishedRun(UnfinishedRun unfinishedRun);

        void noUnFinishedRun();

        void startRunFailed(String message);
    }
}
