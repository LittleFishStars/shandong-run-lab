package com.huachenjie.base.broadcast.detect_face;

import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.zj.adlib.il2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "", "a", "", "runRecordCode", "Lcom/huachenjie/base/bean/RunFaceCheckExtendBean;", il2.f, "", il2.g, "b", "text", "c", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public abstract class DetectFaceListener {
    public abstract void a(@NotNull DetectResultBean result);

    public void b(@NotNull String runRecordCode, @NotNull RunFaceCheckExtendBean extendBean, int faceCheckIndex) {
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        Intrinsics.checkNotNullParameter(extendBean, il2.f);
    }

    public void c(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }
}
