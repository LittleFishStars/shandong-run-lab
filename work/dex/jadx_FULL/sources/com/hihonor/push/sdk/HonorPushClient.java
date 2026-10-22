package com.hihonor.push.sdk;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class HonorPushClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HonorPushClient f32634a = new HonorPushClient();

    public static HonorPushClient getInstance() {
        return f32634a;
    }

    public boolean checkSupportHonorPush(Context context) {
        return l.e.a(context);
    }

    public void deletePushToken(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new g(lVar, honorPushCallback), honorPushCallback);
    }

    public void getNotificationCenterStatus(HonorPushCallback<Boolean> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new h(lVar, honorPushCallback), honorPushCallback);
    }

    public void getPushToken(HonorPushCallback<String> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new f(lVar, honorPushCallback, false), honorPushCallback);
    }

    public void getUnReadMessageBox(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new k(lVar, honorPushCallback), honorPushCallback);
    }

    public void init(Context context, boolean z) {
        l lVar = l.e;
        v vVar = new v();
        vVar.f32677a = context.getApplicationContext();
        vVar.b = z;
        b1.a(new e(lVar, vVar));
    }

    public void turnOffNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new j(lVar, honorPushCallback), honorPushCallback);
    }

    public void turnOnNotificationCenter(HonorPushCallback<Void> honorPushCallback) {
        l lVar = l.e;
        lVar.a(new i(lVar, honorPushCallback), honorPushCallback);
    }
}
