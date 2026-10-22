package com.zj.adlib;

import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R4\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/in6;", "", "Lcom/huachenjie/common/run_component/PauseTimerType;", "type", "Lcom/huachenjie/run/utils/time_factory/IPauseTimeChangeListener;", "b", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "productMap", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class in6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final in6 f42394a = new in6();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final HashMap<PauseTimerType, IPauseTimeChangeListener> productMap = new HashMap<>();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42395a;

        static {
            int[] iArr = new int[PauseTimerType.values().length];
            try {
                iArr[PauseTimerType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PauseTimerType.SPEED_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PauseTimerType.FACE_RECOGNITION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PauseTimerType.NFC_CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f42395a = iArr;
        }
    }

    public final void a() {
        productMap.clear();
    }

    @NotNull
    public final IPauseTimeChangeListener b(@Nullable PauseTimerType type) {
        if (type == null) {
            type = PauseTimerType.NONE;
        }
        HashMap<PauseTimerType, IPauseTimeChangeListener> map = productMap;
        if (map.get(type) != null) {
            IPauseTimeChangeListener iPauseTimeChangeListener = map.get(type);
            Intrinsics.checkNotNull(iPauseTimeChangeListener);
            return iPauseTimeChangeListener;
        }
        int i = a.f42395a[type.ordinal()];
        if (i == 1) {
            u76 u76Var = new u76();
            map.put(type, u76Var);
            return u76Var;
        }
        if (i == 2) {
            om8 om8Var = new om8();
            map.put(type, om8Var);
            return om8Var;
        }
        if (i == 3) {
            sd3 sd3Var = new sd3();
            map.put(type, sd3Var);
            return sd3Var;
        }
        if (i != 4) {
            qg7 qg7Var = new qg7();
            map.put(type, qg7Var);
            return qg7Var;
        }
        pv5 pv5Var = new pv5();
        map.put(type, pv5Var);
        return pv5Var;
    }
}
