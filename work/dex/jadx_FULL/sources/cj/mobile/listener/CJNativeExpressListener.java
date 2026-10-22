package cj.mobile.listener;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface CJNativeExpressListener {
    void loadSuccess(View view);

    void onClick(View view);

    void onClose(View view);

    void onError(String str, String str2);

    void onShow(View view);
}
