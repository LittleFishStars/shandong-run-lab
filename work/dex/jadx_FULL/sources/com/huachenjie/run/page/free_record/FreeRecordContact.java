package com.huachenjie.run.page.free_record;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface FreeRecordContact {

    public interface FreeRecordView extends BaseView {
        void loadMoreFreeRecordSucceed(SunshineRecordListEntity listEntity);

        void queryFreeRecordFailed();

        void queryStaticsFailed();

        void queryStaticsSuccess(SportStatics sportStatics);

        void refreshFreeRecordSucceed(SunshineRecordListEntity listEntity);
    }

    public static abstract class Presenter extends BasePresenter<FreeRecordView> {
        public abstract Subscription f(int timeType, int pageNo);

        public abstract void g(int timeType, int sportType);
    }
}
