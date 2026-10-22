package com.bytedance.android.openliveplugin.process;

import android.content.Context;
import com.bytedance.android.live.base.api.ILiveHostContextParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ILiveInit {
    void initLiveInMain(ILiveHostContextParam iLiveHostContextParam, String str, Boolean bool);

    void initLiveProcess(Context context);

    void registerSubProcessStub();
}
