package com.huachenjie.base.aliyun.detect_face;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.aliyun.detect_face.LivingFaceCallback;
import com.zj.adlib.bl2;
import com.zj.adlib.i4a;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$detectLivingFace$2", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceDelegate$detectLivingFace$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ String $filePath;
    final /* synthetic */ UserFaceBean $userFaceBean;
    int label;
    final /* synthetic */ DetectFaceDelegate this$0;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J&\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceDelegate$detectLivingFace$2$a", "Lcom/huachenjie/common/aliyun/detect_face/LivingFaceCallback;", "", "requestId", "label", "", "rate", "", "b", "code", "message", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements LivingFaceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetectFaceDelegate f32772a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UserFaceBean f6940a;

        public a(DetectFaceDelegate detectFaceDelegate, UserFaceBean userFaceBean) {
            this.f32772a = detectFaceDelegate;
            this.f6940a = userFaceBean;
        }

        @Override // com.huachenjie.common.aliyun.detect_face.LivingFaceCallback
        public void a(@Nullable String requestId, @Nullable String code, @Nullable String message) {
            this.f32772a.u("->failed");
            i4a.a("detectLivingFace onFailed:" + code + " -> " + message);
            this.f32772a.bodyRequestId = requestId;
            this.f32772a.bodyCheckErrorCode = code;
            this.f32772a.w("B-" + requestId);
            this.f32772a.v(false);
        }

        @Override // com.huachenjie.common.aliyun.detect_face.LivingFaceCallback
        public void b(@NotNull String requestId, @Nullable String label, float rate) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.f32772a.u("->success");
            this.f32772a.bodyRequestId = requestId;
            this.f32772a.w("B-" + requestId + '-' + rate);
            this.f32772a.detectLabel = label;
            this.f32772a.detectRate = Float.valueOf(rate);
            if (TextUtils.equals("liveness", label) && rate >= ((float) this.f6940a.getBodyRate())) {
                this.f32772a.v(false);
            } else {
                this.f32772a.v(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceDelegate$detectLivingFace$2(DetectFaceDelegate detectFaceDelegate, ContentResolver contentResolver, String str, UserFaceBean userFaceBean, Continuation<? super DetectFaceDelegate$detectLivingFace$2> continuation) {
        super(2, continuation);
        this.this$0 = detectFaceDelegate;
        this.$contentResolver = contentResolver;
        this.$filePath = str;
        this.$userFaceBean = userFaceBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceDelegate$detectLivingFace$2(this.this$0, this.$contentResolver, this.$filePath, this.$userFaceBean, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.u("->living");
        this.this$0.w("living");
        bl2.k().h(this.$contentResolver, Uri.fromFile(new File(this.$filePath)), new a(this.this$0, this.$userFaceBean));
        return Unit.INSTANCE;
    }
}
