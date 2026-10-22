package com.zj.adlib;

import android.os.Build;
import com.huachenjie.step.delegate.StepCounter;
import com.igexin.assist.util.AssistUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/zj/adlib/ir8;", "", "Lcom/huachenjie/step/delegate/StepCounter;", "a", "<init>", "()V", "step_release"}, k = 1, mv = {1, 8, 0})
public final class ir8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ir8 f42427a = new ir8();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    public final StepCounter a() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        switch (lowerCase.hashCode()) {
            case -1206476313:
                if (lowerCase.equals(AssistUtils.BRAND_HW)) {
                    return c34.f40891a;
                }
                break;
            case -759499589:
                if (lowerCase.equals("xiaomi")) {
                    return b6a.f40689a;
                }
                break;
            case 3418016:
                if (lowerCase.equals("oppo")) {
                    return id6.f42339a;
                }
                break;
            case 3620012:
                if (lowerCase.equals("vivo")) {
                    return qs9.f44291a;
                }
                break;
        }
        return li2.f43073a;
    }
}
