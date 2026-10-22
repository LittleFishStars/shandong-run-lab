package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.g.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AssistPushManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37787a = "Assist_OtherPushManager";
    private AbstractPushManager b;
    private AtomicBoolean c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AssistPushManager f37788a = new AssistPushManager(0);

        private a() {
        }
    }

    private AssistPushManager() {
        this.c = new AtomicBoolean(false);
    }

    public /* synthetic */ AssistPushManager(byte b) {
        this();
    }

    public static boolean checkSupportDevice(Context context) {
        return (d.U && b.a(context.getApplicationContext(), AssistUtils.BRAND_HON)) || b.a(context.getApplicationContext(), AssistUtils.BRAND_HW) || b.a(context.getApplicationContext(), "xiaomi") || b.a(context.getApplicationContext(), "oppo") || b.a(context.getApplicationContext(), AssistUtils.BRAND_MZ) || b.a(context.getApplicationContext(), "vivo") || b.a(context);
    }

    public static AssistPushManager getInstance() {
        return a.f37788a;
    }

    public static String getToken() {
        return e.I;
    }

    public void initialize(Context context) {
        this.b = com.igexin.assist.sdk.a.a().a(context);
    }

    public void register(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.register(context);
        }
    }

    public void saveToken(String str) {
        f.a().b(str);
    }

    public void setSilentTime(Context context, int i, int i2) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOffPush(context);
        }
    }

    public void turnOnPush(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOnPush(context);
        }
    }

    public void unregister(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.unregister(context);
        }
    }
}
