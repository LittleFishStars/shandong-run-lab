package com.kwad.components.offline.api.core.adlive;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ILive {
    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j);

    IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i);

    IAdLiveEndRequest mIAdLiveEndRequest(String str);
}
