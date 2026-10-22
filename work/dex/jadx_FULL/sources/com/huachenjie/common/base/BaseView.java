package com.huachenjie.common.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface BaseView {
    void dismissLoadingDialogs();

    Context getContext();

    void hideInputForce();

    void showInput(View view);

    Dialog showLoadingDialog(String message, boolean cancelable);

    Dialog showLoadingDialog(boolean cancelable);

    void showToast(String text);
}
