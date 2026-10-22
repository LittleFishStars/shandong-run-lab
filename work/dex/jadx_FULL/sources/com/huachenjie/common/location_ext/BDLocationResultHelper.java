package com.huachenjie.common.location_ext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleEventObserver;
import androidx.p002lifecycle.LifecycleOwner;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.baidu.location.BDLocation;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.common.location_ext.BDLocationResultHelper;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.i4a;
import com.zj.adlib.y6b;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b/\u00100J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007J\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0010\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0006H\u0002R\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R#\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001d\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR&\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR*\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/huachenjie/common/location_ext/BDLocationResultHelper;", "", "Landroidx/lifecycle/LifecycleOwner;", "context", "Lkotlin/Function1;", "", "", RenderCallContext.TYPE_CALLBACK, y6b.f, "i", "n", "Lcom/baidu/location/BDLocation;", bo.g, t.d, "customInfo", "k", "j", "a", "Ljava/lang/String;", "BD_LOCATION_RESULT_ACTION", "b", "RESULT_INFO", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "c", "()Ljava/time/format/DateTimeFormatter;", "inputFormatter", "e", "outFormatter", "", "Ljava/util/List;", "callbackList", "", "value", "Z", "d", "()Z", "m", "(Z)V", "locationServiceExit", "locationInfo", "isRegisterBroad", "Lcom/huachenjie/common/location_ext/BDLocationResultHelper$HCJLocationReceiver;", "f", "()Lcom/huachenjie/common/location_ext/BDLocationResultHelper$HCJLocationReceiver;", "receiver", "<init>", "()V", "HCJLocationReceiver", "common_release"}, k = 1, mv = {1, 8, 0})
public final class BDLocationResultHelper {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String BD_LOCATION_RESULT_ACTION = "com.huachenjie.shandong_school.location.result";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String RESULT_INFO = "resultInfo";

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public static boolean isRegisterBroad;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BDLocationResultHelper f33823a = new BDLocationResultHelper();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy inputFormatter = LazyKt.lazy(new Function0<DateTimeFormatter>() { // from class: com.huachenjie.common.location_ext.BDLocationResultHelper$inputFormatter$2
        public final DateTimeFormatter invoke() {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy outFormatter = LazyKt.lazy(new Function0<DateTimeFormatter>() { // from class: com.huachenjie.common.location_ext.BDLocationResultHelper$outFormatter$2
        public final DateTimeFormatter invoke() {
            return DateTimeFormatter.ofPattern("HHmmss");
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final List<Function1<String, Unit>> callbackList = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static boolean locationServiceExit = true;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static String customInfo = "";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static String locationInfo = "";

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy receiver = LazyKt.lazy(new Function0<HCJLocationReceiver>() { // from class: com.huachenjie.common.location_ext.BDLocationResultHelper$receiver$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BDLocationResultHelper.HCJLocationReceiver m349invoke() {
            return new BDLocationResultHelper.HCJLocationReceiver();
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/common/location_ext/BDLocationResultHelper$HCJLocationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBDLocationResultHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BDLocationResultHelper.kt\ncom/huachenjie/common/location_ext/BDLocationResultHelper$HCJLocationReceiver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,137:1\n1855#2,2:138\n*S KotlinDebug\n*F\n+ 1 BDLocationResultHelper.kt\ncom/huachenjie/common/location_ext/BDLocationResultHelper$HCJLocationReceiver\n*L\n130#1:138,2\n*E\n"})
    public static final class HCJLocationReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String stringExtra;
            if (intent == null || (stringExtra = intent.getStringExtra(BDLocationResultHelper.RESULT_INFO)) == null) {
                return;
            }
            Iterator it = BDLocationResultHelper.callbackList.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(stringExtra);
            }
        }
    }

    @JvmStatic
    public static final void g(@NotNull LifecycleOwner context, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (!isRegisterBroad) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BD_LOCATION_RESULT_ACTION);
            LocalBroadcastManager.getInstance(Utils.a()).registerReceiver(f33823a.f(), intentFilter);
            isRegisterBroad = true;
        }
        context.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.zj.adlib.mj0
            @Override // androidx.p002lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                BDLocationResultHelper.h(callback, lifecycleOwner, event);
            }
        });
        callbackList.add(callback);
    }

    public static final void h(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            f33823a.n(function1);
        }
    }

    public final DateTimeFormatter c() {
        return (DateTimeFormatter) inputFormatter.getValue();
    }

    public final boolean d() {
        return locationServiceExit;
    }

    public final DateTimeFormatter e() {
        return (DateTimeFormatter) outFormatter.getValue();
    }

    public final HCJLocationReceiver f() {
        return (HCJLocationReceiver) receiver.getValue();
    }

    public final void i() {
        customInfo = "";
        locationInfo = "";
    }

    public final void j() {
        Intent intent = new Intent(BD_LOCATION_RESULT_ACTION);
        Bundle bundle = new Bundle();
        String str = locationInfo;
        boolean z = locationServiceExit;
        bundle.putString(RESULT_INFO, str + LoginConstants.UNDER_LINE + (z ? 1 : 0) + LoginConstants.UNDER_LINE + customInfo);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(Utils.a()).sendBroadcast(intent);
    }

    public final void k(@NotNull String customInfo2) {
        Intrinsics.checkNotNullParameter(customInfo2, "customInfo");
        customInfo = customInfo2;
        j();
    }

    public final void l(@Nullable BDLocation p0) {
        try {
            if (callbackList.isEmpty()) {
                return;
            }
            String str = LoginConstants.UNDER_LINE;
            if (p0 != null) {
                int locType = p0.getLocType();
                float radius = p0.getRadius();
                int satelliteNumber = p0.getSatelliteNumber();
                float speed = p0.getSpeed();
                int mockGnssProbability = p0.getMockGnssProbability();
                Object objValueOf = p0.getTimeStamp() > 0 ? Long.valueOf(p0.getTimeStamp()) : LocalDateTime.parse(p0.getTime(), c()).format(e());
                str = locType + LoginConstants.UNDER_LINE + radius + LoginConstants.UNDER_LINE + satelliteNumber + LoginConstants.UNDER_LINE + speed + LoginConstants.UNDER_LINE + mockGnssProbability + LoginConstants.UNDER_LINE + objValueOf + LoginConstants.UNDER_LINE + e().format(LocalDateTime.now());
            }
            locationInfo = str;
            j();
        } catch (Exception unused) {
            i4a.c("发送数据异常");
        }
    }

    public final void m(boolean z) {
        locationServiceExit = z;
        j();
    }

    public final void n(@NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        callbackList.remove(callback);
    }
}
