package com.huachenjie.run.page.appeal;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public interface AppealContact {

    public interface AppealView extends BaseView {
        void y();

        void z();
    }

    public static abstract class Presenter extends BasePresenter<AppealView> {
        public abstract void f(String runRecordCode, String problemContent, String semesterCode);
    }
}
