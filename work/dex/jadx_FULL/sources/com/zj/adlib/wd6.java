package com.zj.adlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/zj/adlib/wd6;", "", "Landroid/content/Context;", "context", "Landroid/content/BroadcastReceiver;", "receiver", "", "a", "c", "", "orderNo", "", "orderOperateType", "b", "Ljava/lang/String;", "REFRESH_ORDER_OPERATE_ACTION", "ORDER_NO_KEY", "ORDER_OPERATE_TYPE_KEY", "I", "ORDER_OPERATE_TYPE_CANCEL", "ORDER_OPERATE_TYPE_PAY", "ORDER_OPERATE_TYPE_RECEIVE", "d", "ORDER_OPERATE_TYPE_COMMENT", "e", "ORDER_OPERATE_TYPE_REFUND", "f", "ORDER_OPERATE_TYPE_PAY_ING", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class wd6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_CANCEL = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final wd6 f20422a = new wd6();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String REFRESH_ORDER_OPERATE_ACTION = "com.huachenjie.shandong_school.mall.order.operate";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_PAY = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ORDER_NO_KEY = "order_no";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_RECEIVE = 3;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ORDER_OPERATE_TYPE_KEY = "order_operate_type";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_COMMENT = 4;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_REFUND = 5;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final int ORDER_OPERATE_TYPE_PAY_ING = 6;

    public final void a(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(receiver, new IntentFilter(REFRESH_ORDER_OPERATE_ACTION));
    }

    public final void b(@NotNull Context context, @NotNull String orderNo, int orderOperateType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intent intent = new Intent(REFRESH_ORDER_OPERATE_ACTION);
        Bundle bundle = new Bundle();
        bundle.putString("order_no", orderNo);
        bundle.putInt(ORDER_OPERATE_TYPE_KEY, orderOperateType);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(receiver);
    }
}
