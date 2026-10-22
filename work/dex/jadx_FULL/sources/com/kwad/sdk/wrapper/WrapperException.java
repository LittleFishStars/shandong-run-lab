package com.kwad.sdk.wrapper;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Keep
public class WrapperException extends RuntimeException {
    private static final long serialVersionUID = 8537326645871049532L;

    public WrapperException(String str, Throwable th) {
        super(str, th);
    }

    public static RuntimeException createFromInflater(LayoutInflater layoutInflater, RuntimeException runtimeException) {
        String str;
        String str2 = "Inflate error: ";
        if (layoutInflater != null) {
            try {
                Context context = layoutInflater.getContext();
                if (context != null) {
                    String str3 = ("Inflate error: inflate Context: " + context.getClass().getName()) + " , classLoader: " + context.getClassLoader().getClass().getName();
                    try {
                        str = str3 + " , view class: " + Class.forName("android.view.View", false, context.getClassLoader());
                    } catch (Exception unused) {
                        str = str3 + " , view class is null";
                    }
                    str2 = str + ", enableInflaterOptimize: " + enableInflaterOptimize();
                }
            } catch (RuntimeException unused2) {
                return runtimeException;
            }
        }
        return new WrapperException(str2, runtimeException);
    }

    private static boolean enableInflaterOptimize() {
        try {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.enableInflaterOptimize();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
