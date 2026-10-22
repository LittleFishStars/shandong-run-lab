package com.byazt.fk;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface da {

    public interface c {
        void cancel(u uVar, int i);

        void onVideoPreloadFail(u uVar, int i, String str);

        void onVideoPreloadSuccess(u uVar, int i);
    }

    void execVideoPreload(Context context, u uVar, c cVar);
}
