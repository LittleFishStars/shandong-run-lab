package com.zj.adlib;

import android.content.Context;
import android.provider.Settings;
import com.kc.openset.constant.DeviceIdType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/zj/adlib/z50;", "", "Landroid/content/Context;", "context", "", "a", "Ljava/lang/String;", DeviceIdType.ANDROID_ID, "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class z50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z50 f46187a = new z50();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static String androidId;

    @JvmStatic
    @NotNull
    public static final String a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (androidId == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                string = "";
            }
            androidId = string;
        }
        String str = androidId;
        Intrinsics.checkNotNull(str);
        return str;
    }
}
