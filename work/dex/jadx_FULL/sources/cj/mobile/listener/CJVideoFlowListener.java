package cj.mobile.listener;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface CJVideoFlowListener {
    void onClick(View view);

    void onError(String str, String str2);

    void onLoad(View view);

    void onShow(View view);

    void onVideoCompleted(View view);

    void onVideoPaused(View view);

    void onVideoResume(View view);

    void onVideoStart(View view);
}
