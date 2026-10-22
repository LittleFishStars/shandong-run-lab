package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.EmptyCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z);

    View getView();

    void onShow();

    void release();

    void setCustomBottomView(View view);

    void setOnDislikeCallback(EmptyCallback emptyCallback);

    void stream(String str);
}
