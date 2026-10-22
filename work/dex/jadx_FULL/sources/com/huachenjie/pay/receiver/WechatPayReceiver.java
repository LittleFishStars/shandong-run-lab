package com.huachenjie.pay.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;", "a", "Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;", "mCallback", "<init>", "(Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;)V", "WechatPayCallback", "pay_release"}, k = 1, mv = {1, 8, 0})
public final class WechatPayReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final WechatPayCallback mCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;", "", "", "code", "", "a", "pay_release"}, k = 1, mv = {1, 8, 0})
    public interface WechatPayCallback {
        void a(int code);
    }

    public WechatPayReceiver(@Nullable WechatPayCallback wechatPayCallback) {
        this.mCallback = wechatPayCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("statusCode", -3);
            WechatPayCallback wechatPayCallback = this.mCallback;
            if (wechatPayCallback != null) {
                wechatPayCallback.a(intExtra);
            }
        }
    }
}
