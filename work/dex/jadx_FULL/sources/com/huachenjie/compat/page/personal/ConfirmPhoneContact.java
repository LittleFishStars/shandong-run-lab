package com.huachenjie.compat.page.personal;

import androidx.annotation.Nullable;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.compat.bean.ConfirmPhoneEntity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
interface ConfirmPhoneContact {

    public interface ConfirmPhoneView extends BaseView {
        void confirmPhoneSucceed(ConfirmPhoneEntity confirmPhoneEntity);

        void needCaptchaCheck(String str);

        void sendSMSFailed(String str);

        void sendSMSSucceed(String str);
    }

    public static abstract class Presenter extends BasePresenter<ConfirmPhoneView> {
        public abstract void f(String str, String str2, String str3, int i);

        public abstract void g(String str, int i, @Nullable String str2);
    }
}
