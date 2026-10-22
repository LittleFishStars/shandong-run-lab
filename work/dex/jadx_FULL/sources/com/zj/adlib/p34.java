package com.zj.adlib;

import com.huachenjie.sport.page.mine.huodong.HuodongStatus;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/p34;", "", "", "id", "Lcom/huachenjie/sport/page/mine/huodong/HuodongStatus;", "b", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "c", "(Ljava/util/Map;)V", "id2object", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class p34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p34 f43883a = new p34();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static Map<Integer, HuodongStatus> id2object;

    @NotNull
    public final Map<Integer, HuodongStatus> a() {
        Map<Integer, HuodongStatus> map = id2object;
        if (map != null) {
            return map;
        }
        Intrinsics.throwUninitializedPropertyAccessException("id2object");
        return null;
    }

    @Nullable
    public final HuodongStatus b(int id) {
        if (id2object == null) {
            c(new HashMap());
            for (HuodongStatus huodongStatus : HuodongStatus.values()) {
                a().put(Integer.valueOf(huodongStatus.getId()), huodongStatus);
            }
        }
        if (a().containsKey(Integer.valueOf(id))) {
            return a().get(Integer.valueOf(id));
        }
        return null;
    }

    public final void c(@NotNull Map<Integer, HuodongStatus> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        id2object = map;
    }
}
