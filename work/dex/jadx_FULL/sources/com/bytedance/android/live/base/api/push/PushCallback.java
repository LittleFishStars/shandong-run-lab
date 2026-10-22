package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface PushCallback {
    void onFailed(Throwable th);

    void onSuccess(PushData pushData);
}
