package com.huachenjie.base.aliyun.detect_face;

import android.content.ContentResolver;
import android.net.Uri;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.aliyun.detect_face.CompareFaceCallback;
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
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$compareFace$2", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceDelegate$compareFace$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ UserFaceBean $userFaceBean;
    int label;
    final /* synthetic */ DetectFaceDelegate this$0;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceDelegate$compareFace$2$a", "Lcom/huachenjie/common/aliyun/detect_face/CompareFaceCallback;", "", "requestId", "", "confidence", "", "b", "code", "message", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements CompareFaceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f32771a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DetectFaceDelegate f6937a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UserFaceBean f6938a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f6939a;

        public a(DetectFaceDelegate detectFaceDelegate, UserFaceBean userFaceBean, String str, ContentResolver contentResolver) {
            this.f6937a = detectFaceDelegate;
            this.f6938a = userFaceBean;
            this.f6939a = str;
            this.f32771a = contentResolver;
        }

        @Override // com.huachenjie.common.aliyun.detect_face.CompareFaceCallback
        public void a(@Nullable String requestId, @Nullable String code, @Nullable String message) {
            this.f6937a.u("->failed");
            i4a.a("compareFace onFailed:" + code + " -> " + message);
            this.f6937a.faceRequestId = requestId;
            this.f6937a.faceCheckErrorCode = code;
            this.f6937a.w("A-" + requestId);
            this.f6937a.v(false);
        }

        @Override // com.huachenjie.common.aliyun.detect_face.CompareFaceCallback
        public void b(@NotNull String requestId, float confidence) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.f6937a.u("->success");
            this.f6937a.faceRequestId = requestId;
            this.f6937a.w("A-" + requestId + '-' + confidence);
            this.f6937a.confidenceResult = Float.valueOf(confidence);
            StringBuilder sb = new StringBuilder();
            sb.append("compareFace onSuccess : ");
            sb.append(confidence);
            i4a.a(sb.toString());
            if (confidence < this.f6938a.getSimilarityValue()) {
                this.f6937a.v(false);
                return;
            }
            if (!this.f6938a.getBodyEnable()) {
                this.f6937a.v(true);
                return;
            }
            DetectFaceDelegate detectFaceDelegate = this.f6937a;
            String str = this.f6939a;
            UserFaceBean userFaceBean = this.f6938a;
            ContentResolver contentResolver = this.f32771a;
            Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
            detectFaceDelegate.q(str, userFaceBean, contentResolver);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceDelegate$compareFace$2(DetectFaceDelegate detectFaceDelegate, UserFaceBean userFaceBean, String str, Continuation<? super DetectFaceDelegate$compareFace$2> continuation) {
        super(2, continuation);
        this.this$0 = detectFaceDelegate;
        this.$userFaceBean = userFaceBean;
        this.$filePath = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceDelegate$compareFace$2(this.this$0, this.$userFaceBean, this.$filePath, continuation);
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
        this.this$0.u("->compare");
        this.this$0.w("compare");
        ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
        bl2.k().e(this.$userFaceBean.getFaceImg(), contentResolver, Uri.fromFile(new File(this.$filePath)), new a(this.this$0, this.$userFaceBean, this.$filePath, contentResolver));
        return Unit.INSTANCE;
    }
}
