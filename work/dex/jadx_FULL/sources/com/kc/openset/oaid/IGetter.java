package com.kc.openset.oaid;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IGetter {
    void onOAIDGetComplete(String str);

    void onOAIDGetError(Exception exc);
}
