package com.huachenjie.sport.page.mine.appeallist;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public interface AppealListContact {

    public interface AppealListView extends BaseView {
        void loadMoreAppealListSucceed(SunshineRecordListEntity sunshineRecordListEntity);

        void queryAppealListFailed();

        void refreshAppealListSucceed(SunshineRecordListEntity sunshineRecordListEntity);
    }

    public static abstract class Presenter extends BasePresenter<AppealListView> {
        public abstract Subscription f(int i, int i2);
    }
}
