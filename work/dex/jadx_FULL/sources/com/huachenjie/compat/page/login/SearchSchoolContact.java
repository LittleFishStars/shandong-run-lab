package com.huachenjie.compat.page.login;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.compat.bean.SchoolListEntity;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public interface SearchSchoolContact {

    public static abstract class Presenter extends BasePresenter<SearchSchoolView> {
        public abstract Subscription f(String str, int i);
    }

    public interface SearchSchoolView extends BaseView {
        void c(SchoolListEntity schoolListEntity);

        void d(SchoolListEntity schoolListEntity);

        void o(String str);
    }
}
