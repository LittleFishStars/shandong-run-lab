package com.byazt.gq;

import android.content.Context;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.ou.OnItemClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface sp {
    sp c(long j);

    sp c(IDownloadButtonClickListener iDownloadButtonClickListener);

    sp c(OnItemClickListener onItemClickListener);

    sp c(String str);

    void c();

    void c(boolean z);

    boolean c(int i);

    sp tt(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    sp tt(Context context);

    sp tt(DownloadController downloadController);

    sp tt(DownloadEventConfig downloadEventConfig);

    sp tt(DownloadModel downloadModel);

    void tt(int i);

    boolean tt();

    long uj();

    void x();
}
