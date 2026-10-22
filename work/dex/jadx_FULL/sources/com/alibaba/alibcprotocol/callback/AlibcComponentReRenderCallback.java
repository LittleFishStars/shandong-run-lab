package com.alibaba.alibcprotocol.callback;

import android.os.Bundle;
import com.alibaba.alibcprotocol.container.callback.AlibcComponentRenderCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AlibcComponentReRenderCallback extends AlibcComponentRenderCallback {
    Bundle getRestoreBundle();

    void onRefresh();
}
