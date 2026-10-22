package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010 \u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006#"}, d2 = {"Lcom/zj/adlib/il2;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "b", "", "text", "c", "runRecordCode", "Lcom/huachenjie/base/bean/RunFaceCheckExtendBean;", il2.DETECT_EXTEND_BEAN, "", il2.DETECT_FACE_CHECK_INDEX, "a", "Ljava/lang/String;", "RECEIVER_DETECT_FACE", "DETECT_FACE_TYPE", "DETECT_FACE_RESULT", "d", "DETECT_SIDE_TEXT", "e", "DETECT_RUN_RECORD_CODE", "f", "DETECT_EXTEND_BEAN", y6b.f, "DETECT_FACE_CHECK_INDEX", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class il2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final il2 f42385a = new il2();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_DETECT_FACE = "com.huachenjie.shandong_school.receiver.face.detectFace";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_FACE_TYPE = "detectFaceType";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_FACE_RESULT = "detectFaceResult";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_SIDE_TEXT = "detectSideText";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_RUN_RECORD_CODE = "runRecordCode";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_EXTEND_BEAN = "extendBean";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final String DETECT_FACE_CHECK_INDEX = "faceCheckIndex";

    @JvmStatic
    public static final void registerReceiver(@NotNull Context context, @NotNull DetectFaceReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(RECEIVER_DETECT_FACE));
    }

    @JvmStatic
    public static final void unregisterReceiver(@NotNull Context context, @NotNull DetectFaceReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }

    public final void a(@NotNull Context context, @NotNull String runRecordCode, @NotNull RunFaceCheckExtendBean extendBean, int faceCheckIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        Intrinsics.checkNotNullParameter(extendBean, DETECT_EXTEND_BEAN);
        Intent intent = new Intent(RECEIVER_DETECT_FACE);
        intent.putExtra(DETECT_FACE_TYPE, 3);
        intent.putExtra("runRecordCode", runRecordCode);
        intent.putExtra(DETECT_EXTEND_BEAN, extendBean);
        intent.putExtra(DETECT_FACE_CHECK_INDEX, faceCheckIndex);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void b(@NotNull Context context, @NotNull DetectResultBean result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Intent intent = new Intent(RECEIVER_DETECT_FACE);
        intent.putExtra(DETECT_FACE_TYPE, 1);
        intent.putExtra(DETECT_FACE_RESULT, result);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intent = new Intent(RECEIVER_DETECT_FACE);
        intent.putExtra(DETECT_FACE_TYPE, 2);
        intent.putExtra(DETECT_SIDE_TEXT, text);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
