package com.kwad.sdk.api.loader;

import android.app.Application;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class c {
    public static Application HD() {
        try {
            return (Application) Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
