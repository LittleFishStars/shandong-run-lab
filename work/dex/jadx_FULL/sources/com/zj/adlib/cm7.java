package com.zj.adlib;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/zj/adlib/cm7;", "", "Landroid/content/Context;", "context", "", "bannerName", "", "a", "Ljava/lang/String;", "CLICK_RUN_SUCCESS_BANNER_EVENT_ID", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class cm7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cm7 f40999a = new cm7();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String CLICK_RUN_SUCCESS_BANNER_EVENT_ID = "click_run_success_banner";

    @JvmStatic
    public static final void a(@Nullable Context context, @NotNull String bannerName) {
        Intrinsics.checkNotNullParameter(bannerName, "bannerName");
        try {
            HashMap map = new HashMap();
            map.put("bannerName", bannerName);
            kq5.b(context, CLICK_RUN_SUCCESS_BANNER_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }
}
