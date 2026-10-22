package com.huachenjie.mall.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/utils/RewardOrderHelp;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "receiver", "", "a", "c", "", "orderNo", "exchangeCode", "b", "Ljava/lang/String;", "REWARD_ORDER_FILTER", "KEY_ORDER_NO", "KEY_EXCHANGE_CODE", "<init>", "()V", "RewardOrderReceiver", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RewardOrderHelp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RewardOrderHelp f35274a = new RewardOrderHelp();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String REWARD_ORDER_FILTER = "com.huachenjie.shandong_school.mall.order.reward";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String KEY_ORDER_NO = "order_no";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String KEY_EXCHANGE_CODE = "exchange_code";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B?\u00126\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016RD\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "orderNo", "exchangeCode", "a", "Lkotlin/jvm/functions/Function2;", "mListener", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class RewardOrderReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final Function2<String, String, Unit> mListener;

        /* JADX WARN: Multi-variable type inference failed */
        public RewardOrderReceiver(@NotNull Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "mListener");
            this.mListener = function2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("order_no");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(KEY_ORDER_NO) ?: \"\"");
                String stringExtra2 = intent.getStringExtra(RewardOrderHelp.KEY_EXCHANGE_CODE);
                String str = stringExtra2 != null ? stringExtra2 : "";
                Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(KEY_EXCHANGE_CODE) ?: \"\"");
                this.mListener.invoke(stringExtra, str);
            }
        }
    }

    public final void a(@NotNull Context context, @NotNull RewardOrderReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(receiver, new IntentFilter(REWARD_ORDER_FILTER));
    }

    public final void b(@NotNull Context context, @NotNull String orderNo, @NotNull String exchangeCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(exchangeCode, "exchangeCode");
        Intent intent = new Intent(REWARD_ORDER_FILTER);
        intent.putExtra("order_no", orderNo);
        intent.putExtra(KEY_EXCHANGE_CODE, exchangeCode);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull RewardOrderReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(receiver);
    }
}
