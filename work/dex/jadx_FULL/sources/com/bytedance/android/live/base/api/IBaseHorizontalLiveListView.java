package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.Callback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface IBaseHorizontalLiveListView {
    void refresh();

    View self();

    void setEmptyListener(Callback<Boolean> callback);

    void setErrorListener(Callback<Boolean> callback);

    void setRoomCountListener(Callback<Integer> callback);
}
