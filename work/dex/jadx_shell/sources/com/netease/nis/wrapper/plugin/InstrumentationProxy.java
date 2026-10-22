package com.netease.nis.wrapper.plugin;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class InstrumentationProxy extends Instrumentation {
    public static final String EXEC_START_ACTIVITY = "execStartActivity";
    public static final String TAG = "InstrumentationProxy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Instrumentation f14a;
    public static String plist = "";
    public static String nplist = "";

    public InstrumentationProxy(Instrumentation instrumentation) {
        this.f14a = instrumentation;
    }

    private static boolean a(Activity activity) {
        String name = activity.getClass().getName();
        if (!plist.equals("") && !plist.contains(name)) {
            new StringBuilder().append(name).append(a.auu.a.c("bgsbEUEaC24SHAwVFkU=")).append(plist);
            return false;
        }
        if (nplist.equals("") || !nplist.contains(name)) {
            return true;
        }
        new StringBuilder().append(name).append(a.auu.a.c("bgwaRQMfBC0OVA==")).append(nplist);
        return false;
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        boolean z = false;
        this.f14a.callActivityOnCreate(activity, bundle);
        if (activity != null) {
            String name = activity.getClass().getName();
            if (!plist.equals("") && !plist.contains(name)) {
                new StringBuilder().append(name).append(a.auu.a.c("bgsbEUEaC24SHAwVFkU=")).append(plist);
            } else if (nplist.equals("") || !nplist.contains(name)) {
                z = true;
            } else {
                new StringBuilder().append(name).append(a.auu.a.c("bgwaRQMfBC0OVA==")).append(nplist);
            }
            if (z) {
                activity.getWindow().addFlags(8192);
            }
        }
    }
}
