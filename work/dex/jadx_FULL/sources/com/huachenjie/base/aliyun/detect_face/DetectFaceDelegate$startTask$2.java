package com.huachenjie.base.aliyun.detect_face;

import android.app.Application;
import android.text.TextUtils;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.zj.adlib.i4a;
import com.zj.adlib.u66;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startTask$2", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceDelegate$startTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ UploadFileType $uploadType;
    final /* synthetic */ UserFaceBean $userFaceBean;
    int label;
    final /* synthetic */ DetectFaceDelegate this$0;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceDelegate$startTask$2$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetectFaceDelegate f32774a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UserFaceBean f6943a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f6944a;

        public a(DetectFaceDelegate detectFaceDelegate, UserFaceBean userFaceBean, String str) {
            this.f32774a = detectFaceDelegate;
            this.f6943a = userFaceBean;
            this.f6944a = str;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            this.f32774a.u("->failed");
            this.f32774a.v(false);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            i4a.a(String.valueOf(fileUrl));
            this.f32774a.u("->success");
            this.f32774a.compareFaceUrl = fileUrl;
            if (TextUtils.isEmpty(fileUrl)) {
                this.f32774a.v(false);
                return;
            }
            UserFaceBean userFaceBean = this.f6943a;
            if (userFaceBean == null) {
                this.f32774a.v(true);
            } else {
                this.f32774a.p(this.f6944a, userFaceBean);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceDelegate$startTask$2(DetectFaceDelegate detectFaceDelegate, UploadFileType uploadFileType, String str, UserFaceBean userFaceBean, Continuation<? super DetectFaceDelegate$startTask$2> continuation) {
        super(2, continuation);
        this.this$0 = detectFaceDelegate;
        this.$uploadType = uploadFileType;
        this.$filePath = str;
        this.$userFaceBean = userFaceBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceDelegate$startTask$2(this.this$0, this.$uploadType, this.$filePath, this.$userFaceBean, continuation);
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
        this.this$0.u("uploading");
        this.this$0.w("uploading");
        Application context = this.this$0.getContext();
        UploadFileType uploadFileType = this.$uploadType;
        String str = this.$filePath;
        u66.d(context, uploadFileType, str, new a(this.this$0, this.$userFaceBean, str));
        return Unit.INSTANCE;
    }
}
