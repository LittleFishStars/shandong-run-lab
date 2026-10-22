package com.huachenjie.base.util;

import android.app.Application;
import com.huachenjie.base.util.HTProtectUtil;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.netease.htprotect.HTProtect;
import com.netease.htprotect.HTProtectConfig;
import com.netease.htprotect.callback.HTPCallback;
import com.zj.adlib.i4a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/base/util/HTProtectUtil;", "", "Landroid/app/Application;", "application", "", "c", "", "runRecordCode", "b", "a", "Ljava/lang/String;", "TAG", "PRODUCT_ID", "BUSINESS_ID", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class HTProtectUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HTProtectUtil f32959a = new HTProtectUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TAG = "HTProtectUtil";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String PRODUCT_ID = "YD00717730319426";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String BUSINESS_ID = "f82ca827669c5cea035c25041e0d270e";

    @JvmStatic
    public static final void b(@NotNull String runRecordCode) {
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        CoroutineExtKt.c(CoroutineExtKt.a(f32959a), false, null, null, new HTProtectUtil$getToken$1(runRecordCode, null), 6, null);
    }

    @JvmStatic
    public static final void c(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        HTProtect.init(application, PRODUCT_ID, new HTPCallback() { // from class: com.zj.adlib.qx3
            public final void onReceive(int i, String str) {
                HTProtectUtil.d(i, str);
            }
        }, new HTProtectConfig());
    }

    public static final void d(int i, String str) {
        i4a.b(TAG, "code is:" + i + " String is:" + str);
    }
}
