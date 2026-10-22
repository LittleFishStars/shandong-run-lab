package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alipay.android.phone.mobilesdk.socketcraft.e.c;
import com.alipay.sdk.app.PayTask;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.pay.receiver.WechatPayReceiver;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0017\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015R\u0014\u0010\u001a\u001a\u00020\u00158\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u001b¨\u0006 "}, d2 = {"Lcom/zj/adlib/ln6;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroid/os/Handler;", "handler", "", "orderInfo", "", "b", AliyunLogCommon.LogLevel.INFO, "wechatAppId", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxApi", y6b.f, "Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "receiver", "d", "f", "Landroid/content/Context;", "context", "", "code", "e", "a", "I", c.l, "Ljava/lang/String;", "RECEIVER_WECHAT_PAY", "STATUS_CODE", "<init>", "()V", "pay_release"}, k = 1, mv = {1, 8, 0})
public final class ln6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int CODE = 200;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final ln6 f18003a = new ln6();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_WECHAT_PAY = "com.huachenjie.shandong_school.receiver.pay.wechat";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String STATUS_CODE = "statusCode";

    @JvmStatic
    public static final void b(@NotNull final Activity activity, @Nullable final Handler handler, @NotNull final String orderInfo) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(orderInfo, "orderInfo");
        new Thread(new Runnable() { // from class: com.zj.adlib.kn6
            @Override // java.lang.Runnable
            public final void run() {
                ln6.c(activity, orderInfo, handler);
            }
        }).start();
    }

    public static final void c(Activity activity, String str, Handler handler) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(str, "$orderInfo");
        Map<String, String> mapPayV2 = new PayTask(activity).payV2(str, true);
        Message message = new Message();
        message.what = 200;
        message.obj = mapPayV2;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    @JvmStatic
    public static final void g(@NotNull String info, @Nullable String wechatAppId, @Nullable IWXAPI wxApi) {
        Intrinsics.checkNotNullParameter(info, AliyunLogCommon.LogLevel.INFO);
        if (wxApi == null) {
            Log.d("pay", "wxApi is null");
            return;
        }
        if (TextUtils.isEmpty(wechatAppId)) {
            Log.d("pay", "wechatAppId is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(info);
            PayReq payReq = new PayReq();
            payReq.appId = wechatAppId;
            payReq.partnerId = jSONObject.optString("partnerId");
            payReq.prepayId = jSONObject.optString("prepayId");
            payReq.packageValue = "Sign=WXPay";
            payReq.nonceStr = jSONObject.optString("nonceStr");
            payReq.timeStamp = jSONObject.optString("timeStamp");
            payReq.sign = jSONObject.optString(UserTrackConstant.SIGN);
            wxApi.sendReq(payReq);
        } catch (Exception unused) {
        }
    }

    public final void d(@NotNull Activity activity, @NotNull WechatPayReceiver receiver) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        activity.registerReceiver(receiver, new IntentFilter(RECEIVER_WECHAT_PAY));
    }

    public final void e(@Nullable Context context, int code) {
        Intent intent = new Intent(RECEIVER_WECHAT_PAY);
        intent.putExtra("statusCode", code);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public final void f(@NotNull Activity activity, @NotNull WechatPayReceiver receiver) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        activity.unregisterReceiver(receiver);
    }
}
