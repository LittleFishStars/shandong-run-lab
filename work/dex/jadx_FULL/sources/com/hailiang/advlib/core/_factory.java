package com.hailiang.advlib.core;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface _factory extends Runnable {
    void appListFromClientNotice();

    IMultiAdRequest createNativeMultiAdRequest();

    void notifyMsg(int i, Bundle bundle);

    @Override // java.lang.Runnable
    void run();

    void setAppList(List<PackageInfo> list);

    void setImageAutoDownload(boolean z);

    void terminate();

    void useDebugServer(int i);

    void useDebugServer(boolean z);

    void whenPermDialogReturns(int i, String[] strArr, int[] iArr);
}
