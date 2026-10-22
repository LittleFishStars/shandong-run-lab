package com.zj.adlib;

import com.blankj.utilcode.util.Utils;
import com.huachenjie.base.R;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/zj/adlib/v32;", "", "", "a", "", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class v32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v32 f45280a = new v32();

    public final boolean a() {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager", true, Utils.a().getClassLoader()).getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            return (declaredMethod.invoke(null, "service_mock_location") == null && declaredMethod.invoke(null, "service_fl_ml") == null) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @NotNull
    public final String b() {
        String strE = ys8.e(R.string.run_cheat_type_virtual);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.run_cheat_type_virtual)");
        return strE;
    }
}
