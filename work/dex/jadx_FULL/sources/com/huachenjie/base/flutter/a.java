package com.huachenjie.base.flutter;

import android.content.Context;
import android.content.Intent;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.huachenjie.c.HcjNative;
import com.huachenjie.common.constants.Environment;
import com.zj.adlib.h33;
import com.zj.adlib.hq1;
import com.zj.adlib.l43;
import com.zj.adlib.vw3;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/base/flutter/a;", "", "Landroid/content/Context;", "context", "", "a", "", "page", "b", "Ljava/lang/String;", "ENGINE_ID", "STARTUP_CHANNEL", "c", "METHOD_INIT", "d", "PAGE_AI_ENTRANCE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f32932a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ENGINE_ID = "my_engine_id";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String STARTUP_CHANNEL = "HCJApp/startup";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String METHOD_INIT = "init";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String PAGE_AI_ENTRANCE = "aiEntrance";

    @JvmStatic
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!FlutterEngineCache.getInstance().contains(ENGINE_ID) || FlutterEngineCache.getInstance().get(ENGINE_ID) == null) {
            FlutterEngine flutterEngine = new FlutterEngine(context.getApplicationContext());
            flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
            FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine);
        }
    }

    @JvmStatic
    public static final void b(@NotNull Context context, @NotNull String page) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(page, "page");
        HashMap map = new HashMap();
        map.put("pageIndex", page);
        HashMap map2 = new HashMap();
        map2.put("systemVersion", hq1.a().h);
        map2.put("modelName", hq1.a().g);
        map2.put("platform", hq1.a().f);
        map2.put("deviceId", hq1.a().e);
        map2.put("buildVersion", hq1.a().d);
        map2.put("appVersion", hq1.a().c);
        map2.put("appCode", hq1.a().i);
        map2.put("timestamp", "");
        map.put("commonParams", map2);
        map.put("app_debug", Boolean.FALSE);
        map.put("domain", Environment.f33657a);
        map.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, hq1.a().j);
        String strB = h33.b();
        if (strB == null) {
            strB = "";
        }
        String str = hq1.a().a;
        if (str == null) {
            str = "";
        }
        String str2 = hq1.a().b;
        Object objH = vw3.h(HcjNative.buildFlutterSecParams(strB, str, str2 != null ? str2 : "", l43.b()), Map.class);
        Intrinsics.checkNotNull(objH, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        map.put("secParams", new HashMap((Map) objH));
        Intent intentBuild = HcjFlutterActivity.INSTANCE.a(context, ENGINE_ID).build(context);
        intentBuild.putExtra("method", "init");
        intentBuild.putExtra("arguments", vw3.u(map));
        context.startActivity(intentBuild);
    }
}
