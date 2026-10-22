package com.huachenjie.common.dialog.auth;

import androidx.annotation.NonNull;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public interface AuthDialogContact {

    public interface AuthDialogView extends BaseView {
        void F(@NonNull String schoolAuthUrl);

        void r();
    }

    public static abstract class Presenter extends BasePresenter<AuthDialogView> {
        public abstract void f(@NonNull String schoolCode);
    }
}
