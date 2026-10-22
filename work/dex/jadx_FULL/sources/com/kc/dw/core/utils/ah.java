package com.kc.dw.core.utils;

import android.content.Intent;
import com.kc.dw.core.domain.ar;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ah extends ar {
    public Object c(Intent intent, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            return cls.getDeclaredMethod(this.d, cls, CharSequence.class).invoke(null, intent, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
