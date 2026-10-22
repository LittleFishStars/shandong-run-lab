package com.huachenjie.base.broadcast.detect_face;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.common.constants.ErrorCode;
import com.zj.adlib.il2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "a", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "mListener", "<init>", "(Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectFaceReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DetectFaceListener mListener;

    public DetectFaceReceiver(@NotNull DetectFaceListener detectFaceListener) {
        Intrinsics.checkNotNullParameter(detectFaceListener, "mListener");
        this.mListener = detectFaceListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String stringExtra;
        if (intent != null) {
            int intExtra = intent.getIntExtra(il2.b, 0);
            if (intExtra == 1) {
                DetectResultBean detectResultBean = (DetectResultBean) intent.getParcelableExtra(il2.c);
                if (detectResultBean == null) {
                    detectResultBean = new DetectResultBean(false, null, null, null, null, null, null, null, null, null, 0, ErrorCode.CHECK_START_RUN_ERROR.m, null);
                }
                this.mListener.a(detectResultBean);
                return;
            }
            if (intExtra == 2) {
                String stringExtra2 = intent.getStringExtra(il2.d);
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                Intrinsics.checkNotNullExpressionValue(stringExtra2, "getStringExtra(DetectFac…r.DETECT_SIDE_TEXT) ?: \"\"");
                this.mListener.c(stringExtra2);
                return;
            }
            if (intExtra == 3 && (stringExtra = intent.getStringExtra("runRecordCode")) != null) {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(DetectFac…UN_RECORD_CODE) ?: return");
                RunFaceCheckExtendBean runFaceCheckExtendBean = (RunFaceCheckExtendBean) intent.getParcelableExtra(il2.f);
                if (runFaceCheckExtendBean == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(runFaceCheckExtendBean, "getParcelableExtra<RunFa…                ?: return");
                this.mListener.b(stringExtra, runFaceCheckExtendBean, intent.getIntExtra(il2.g, -1));
            }
        }
    }
}
