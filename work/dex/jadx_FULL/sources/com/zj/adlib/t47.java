package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huachenjie.push.interfaces.PushMessageListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;
import huachenjie.sdk.push.PushActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class t47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IUserLoggerInterface f44844a = new a();

    public class a implements IUserLoggerInterface {
        @Override // com.igexin.sdk.IUserLoggerInterface
        public void log(String str) {
            Log.i("PUSH_LOG", str);
        }
    }

    public static String a(Context context) {
        return PushManager.getInstance().getClientid(context);
    }

    public static void b(Context context) {
        PushManager.getInstance().setScenePush(context, false);
        PushManager.getInstance().setIndividuationPush(context, false);
        PushManager.getInstance().setEmergencyPush(context, false);
        PushManager.getInstance().initialize(context);
    }

    public static void c(Context context) {
        Intent intent = new Intent(context, (Class<?>) PushActivity.class);
        intent.setData(Uri.parse("shandong://huanchenjie.com/push?"));
        intent.setPackage(context.getPackageName());
        intent.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, "payloadStr");
        intent.putExtra("gttask", "");
        intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        Log.d(RemoteMessageConst.Notification.INTENT_URI, intent.toUri(1));
    }

    public static boolean d(Context context) {
        return PushManager.getInstance().areNotificationsEnabled(context);
    }

    public static void e(Context context) {
        PushManager.getInstance().openNotification(context);
    }

    public static void f(Context context) {
        PushManager.getInstance().preInit(context);
    }

    public static void g(Activity activity, String str) {
        PushMessageListener pushMessageListenerB = p47.a().b();
        if (pushMessageListenerB != null) {
            pushMessageListenerB.a(activity, str);
        }
    }

    public static void h(PushMessageListener pushMessageListener) {
        p47.a().c(pushMessageListener);
    }
}
