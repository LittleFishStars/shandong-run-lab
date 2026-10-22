package com.huachenjie.base.aliyun.detect_face;

import android.text.TextUtils;
import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.jo2;
import com.zj.adlib.pm1;
import com.zj.adlib.rw0;
import com.zj.adlib.u66;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startAnalyzer$2", f = "DetectFaceDelegate.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
public final class DetectFaceDelegate$startAnalyzer$2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ RunFaceDetectStatus $detectStatus;
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ int $maxHeight;
    final /* synthetic */ int $maxWidth;
    final /* synthetic */ TrackingInfo $trackingInfo;
    final /* synthetic */ UploadFileType $uploadType;
    int label;
    final /* synthetic */ DetectFaceDelegate this$0;

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startAnalyzer$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startAnalyzer$2$1", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filePath;
        final /* synthetic */ int $maxHeight;
        final /* synthetic */ int $maxWidth;
        final /* synthetic */ TrackingInfo $trackingInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TrackingInfo trackingInfo, int i, int i2, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$trackingInfo = trackingInfo;
            this.$maxWidth = i;
            this.$maxHeight = i2;
            this.$filePath = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$trackingInfo, this.$maxWidth, this.$maxHeight, this.$filePath, continuation);
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
            rw0.f44555a.d(this.$trackingInfo, this.$maxWidth, this.$maxHeight, this.$filePath);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceDelegate$startAnalyzer$2$a", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetectFaceDelegate f32773a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RunFaceDetectStatus f6941a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f6942a;

        public a(RunFaceDetectStatus runFaceDetectStatus, DetectFaceDelegate detectFaceDelegate, boolean z) {
            this.f6941a = runFaceDetectStatus;
            this.f32773a = detectFaceDelegate;
            this.f6942a = z;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            this.f6941a.setUploadImage(2);
            this.f32773a.t(this.f6941a);
            this.f32773a.v(false);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            if (TextUtils.isEmpty(fileUrl)) {
                this.f6941a.setUploadImage(2);
                this.f32773a.t(this.f6941a);
                this.f32773a.v(false);
            } else {
                this.f32773a.compareFaceUrl = fileUrl;
                this.f6941a.setUploadImage(1);
                this.f32773a.t(this.f6941a);
                this.f32773a.v(this.f6942a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectFaceDelegate$startAnalyzer$2(DetectFaceDelegate detectFaceDelegate, UploadFileType uploadFileType, String str, TrackingInfo trackingInfo, int i, int i2, RunFaceDetectStatus runFaceDetectStatus, boolean z, Continuation<? super DetectFaceDelegate$startAnalyzer$2> continuation) {
        super(2, continuation);
        this.this$0 = detectFaceDelegate;
        this.$uploadType = uploadFileType;
        this.$filePath = str;
        this.$trackingInfo = trackingInfo;
        this.$maxWidth = i;
        this.$maxHeight = i2;
        this.$detectStatus = runFaceDetectStatus;
        this.$isSuccess = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetectFaceDelegate$startAnalyzer$2(this.this$0, this.$uploadType, this.$filePath, this.$trackingInfo, this.$maxWidth, this.$maxHeight, this.$detectStatus, this.$isSuccess, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$trackingInfo, this.$maxWidth, this.$maxHeight, this.$filePath, null);
            this.label = 1;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        u66.d(this.this$0.getContext(), this.$uploadType, this.$filePath, new a(this.$detectStatus, this.this$0, this.$isSuccess));
        return Unit.INSTANCE;
    }
}
