package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import com.acse.ottn.service.MainService;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h4 f23033a = null;
    public static String b = "ServiceUtils";

    public static h4 a() {
        if (f23033a == null) {
            synchronized (h4.class) {
                if (f23033a == null) {
                    f23033a = new h4();
                }
            }
        }
        return f23033a;
    }

    public final Object b() throws ObjectStreamException {
        return f23033a;
    }

    public boolean a(Service service) {
        if (service instanceof AccessibilityService) {
            return false;
        }
        boolean z = service instanceof MainService;
        return true;
    }
}
