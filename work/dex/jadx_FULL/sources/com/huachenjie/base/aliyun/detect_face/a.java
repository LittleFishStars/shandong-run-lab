package com.huachenjie.base.aliyun.detect_face;

import com.huachenjie.base.bean.UserFaceBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/a;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f32785a = new a();

    @JvmStatic
    @NotNull
    public static final DetectFaceFragment a(@NotNull UserFaceBean userFaceBean) {
        Intrinsics.checkNotNullParameter(userFaceBean, "userFaceBean");
        return DetectFaceFragment.INSTANCE.a(userFaceBean);
    }
}
