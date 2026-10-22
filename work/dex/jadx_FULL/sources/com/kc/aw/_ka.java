package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ka implements Comparator<String> {
    @Override // java.util.Comparator
    public final int compare(String str, String str2) {
        return Integer.compare(Integer.parseInt(str), Integer.parseInt(str2));
    }
}
