package com.huachenjie.base.aliyun.detect_face;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.broadcast.detect_face.DetectFaceListener;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import com.huachenjie.base.databinding.FragmentDetectFaceCheckBinding;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.il2;
import com.zj.adlib.jo2;
import com.zj.adlib.nj7;
import com.zj.adlib.sk0;
import com.zj.adlib.v41;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002;<B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001aH\u0016J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b3\u00104R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment;", "Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceCheckBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthVM;", "", "initTitle", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "findDetectFaceFragment", "dealOnDetectSuccess", "dealOnDetectFail", "", "success", "onDetectResult", "", "", "", "getVariables", "getLayoutResID", "onViewCreated", "onDestroyView", "initView", "onResume", "onPermissionDenied", "onClickBack", "Landroidx/camera/view/PreviewView;", "getPreviewView", "", "getLoadingTip", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "getUploadFileType", "message", "onCameraError", "onTakePictureError", "filePath", "onTakePicture", "", "time", "setCountdown", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean$delegate", "Lkotlin/Lazy;", "getUserFaceBean", "()Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceCheckFragment.USER_FACE_BEAN, "picturePath", "Ljava/lang/String;", "Landroid/app/Dialog;", "errorDialog", "Landroid/app/Dialog;", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver$delegate", "getDetectReceiver", "()Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver", "firstResume", "Z", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDetectFaceCheckFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetectFaceCheckFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,238:1\n470#2:239\n*S KotlinDebug\n*F\n+ 1 DetectFaceCheckFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment\n*L\n102#1:239\n*E\n"})
public final class DetectFaceCheckFragment extends FaceCameraFragment<FragmentDetectFaceCheckBinding, DetectFaceAuthVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String USER_FACE_BEAN = "userFaceBean";

    @Nullable
    private Dialog errorDialog;
    private boolean firstResume;

    @Nullable
    private String picturePath;

    /* JADX INFO: renamed from: userFaceBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userFaceBean = LazyKt.lazy(new Function0<UserFaceBean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$userFaceBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserFaceBean m198invoke() {
            Bundle arguments = this.this$0.getArguments();
            UserFaceBean userFaceBean = arguments != null ? (UserFaceBean) arguments.getParcelable("userFaceBean") : null;
            return userFaceBean == null ? new UserFaceBean(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null) : userFaceBean;
        }
    });

    /* JADX INFO: renamed from: detectReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detectReceiver = LazyKt.lazy(new Function0<DetectFaceReceiver>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$detectReceiver$2

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment$detectReceiver$2$a", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "", "a", "", "text", "c", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DetectFaceListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetectFaceCheckFragment f32769a;

            public a(DetectFaceCheckFragment detectFaceCheckFragment) {
                this.f32769a = detectFaceCheckFragment;
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void a(@NotNull DetectResultBean result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Dialog loadingDialog = this.f32769a.getLoadingDialog();
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
                if (result.getSuccess()) {
                    this.f32769a.dealOnDetectSuccess();
                } else {
                    this.f32769a.dealOnDetectFail();
                }
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void c(@NotNull String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.f32769a.setSideText(text);
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DetectFaceReceiver m197invoke() {
            return new DetectFaceReceiver(new a(this.this$0));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DetectFaceCheckFragment detectFaceCheckFragment = DetectFaceCheckFragment.this;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            detectFaceCheckFragment.takePhoto(context);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment$b;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceCheckFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceCheckFragment;", "a", "", "USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetectFaceCheckFragment a(@NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(userFaceBean, DetectFaceCheckFragment.USER_FACE_BEAN);
            DetectFaceCheckFragment detectFaceCheckFragment = new DetectFaceCheckFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DetectFaceCheckFragment.USER_FACE_BEAN, userFaceBean);
            detectFaceCheckFragment.setArguments(bundle);
            return detectFaceCheckFragment;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectFail$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectFail$1", f = "DetectFaceCheckFragment.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectFail$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectFail$1$1", f = "DetectFaceCheckFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ DetectFaceCheckFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07801(DetectFaceCheckFragment detectFaceCheckFragment, Continuation<? super C07801> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceCheckFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07801(this.this$0, continuation);
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FileUtils.delete(this.this$0.picturePath));
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DetectFaceCheckFragment.this.new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcherC = jo2.c();
                C07801 c07801 = new C07801(DetectFaceCheckFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07801, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            fv5.b("您未通过校验，请尝试重新校验。");
            DetectFaceCheckFragment.access$getMViewModel(DetectFaceCheckFragment.this).m().setValue("重新校验");
            DetectFaceCheckFragment.this.resumeCamera();
            DetectFaceCheckFragment.this.unlockCommit();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectSuccess$1", f = "DetectFaceCheckFragment.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectSuccess$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment$dealOnDetectSuccess$1$1", f = "DetectFaceCheckFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DetectFaceCheckFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07811(DetectFaceCheckFragment detectFaceCheckFragment, Continuation<? super C07811> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceCheckFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07811(this.this$0, continuation);
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
                FileUtils.delete(this.this$0.picturePath);
                return Unit.INSTANCE;
            }
        }

        public C14521(Continuation<? super C14521> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DetectFaceCheckFragment.this.new C14521(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcherC = jo2.c();
                C07811 c07811 = new C07811(DetectFaceCheckFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07811, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ DetectFaceAuthVM access$getMViewModel(DetectFaceCheckFragment detectFaceCheckFragment) {
        return (DetectFaceAuthVM) detectFaceCheckFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.common.reconfig.mvvm.BaseViewModel] */
    public final void dealOnDetectFail() {
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new AnonymousClass1(null), 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.huachenjie.common.reconfig.mvvm.BaseViewModel] */
    public final void dealOnDetectSuccess() {
        fv5.b("您通过了本次校验，请再接再厉继续运动哦。");
        onDetectResult(true);
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new C14521(null), 15, null);
    }

    private final DetectFaceFragment findDetectFaceFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof DetectFaceFragment)) {
            return (DetectFaceFragment) parentFragment;
        }
        return null;
    }

    private final DetectFaceReceiver getDetectReceiver() {
        return (DetectFaceReceiver) this.detectReceiver.getValue();
    }

    private final UserFaceBean getUserFaceBean() {
        return (UserFaceBean) this.userFaceBean.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initTitle() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = ((DetectFaceAuthVM) getMViewModel()).i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((DetectFaceAuthVM) getMViewModel()).e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("跑步校验");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.wk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceCheckFragment.initTitle$lambda$5$lambda$4(this.f45615a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$5$lambda$4(DetectFaceCheckFragment detectFaceCheckFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceCheckFragment, "this$0");
        detectFaceCheckFragment.onClickBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCameraError$lambda$6(DetectFaceCheckFragment detectFaceCheckFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceCheckFragment, "this$0");
        detectFaceCheckFragment.onDetectResult(false);
    }

    private final void onDetectResult(boolean success) {
        i4a.a("onDetectResult:" + success);
        DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = findDetectFaceFragment();
        if (detectFaceFragmentFindDetectFaceFragment != null) {
            detectFaceFragmentFindDetectFaceFragment.dismissAllowingStateLoss();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_face_check;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public String getLoadingTip() {
        return "人脸认证中…";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @Nullable
    public PreviewView getPreviewView() {
        FragmentDetectFaceCheckBinding fragmentDetectFaceCheckBinding = (FragmentDetectFaceCheckBinding) getMBinding();
        if (fragmentDetectFaceCheckBinding != null) {
            return fragmentDetectFaceCheckBinding.f7057a;
        }
        return null;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public UploadFileType getUploadFileType() {
        return UploadFileType.UPLOAD_FACE_RUN;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        View view;
        initTitle();
        FragmentDetectFaceCheckBinding fragmentDetectFaceCheckBinding = (FragmentDetectFaceCheckBinding) getMBinding();
        if (fragmentDetectFaceCheckBinding != null && (view = fragmentDetectFaceCheckBinding.f32839a) != null) {
            nj7 nj7Var = new nj7(-1, SizeUtils.b(138.0f), 0, 0, 0, 0, 60, null);
            nj7Var.o(SizeUtils.b(8.0f));
            nj7Var.n(SizeUtils.b(138.0f));
            nj7Var.m(Color.parseColor("#FFF5F5F5"));
            view.setBackground(nj7Var);
        }
        FragmentDetectFaceCheckBinding fragmentDetectFaceCheckBinding2 = (FragmentDetectFaceCheckBinding) getMBinding();
        TextView textView = fragmentDetectFaceCheckBinding2 != null ? fragmentDetectFaceCheckBinding2.f7056a : null;
        if (textView != null) {
            textView.setText("*温馨提示：开始校验后可以停止跑步安心校验哦~如果校验不通过，请再校验下，要在" + getUserFaceBean().getFaceTime() + "s内完成。校验重复失败可联系客服，如果不校验或校验不通过，即使完成跑步也将无效！");
        }
        setCountdown(getUserFaceBean().getLeftTime());
        ((DetectFaceAuthVM) getMViewModel()).m().setValue("开始校验");
        FragmentDetectFaceCheckBinding fragmentDetectFaceCheckBinding3 = (FragmentDetectFaceCheckBinding) getMBinding();
        if (fragmentDetectFaceCheckBinding3 == null || (imageView = fragmentDetectFaceCheckBinding3.f7055a) == null) {
            return;
        }
        imageView.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, SizeUtils.b(16.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.start();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onCameraError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.errorDialog = ft1.A(context, "非常抱歉，我们暂时无法使用相机，请检查前置相机是否可用后，再进行人脸认证", "退出认证", new View.OnClickListener() { // from class: com.zj.adlib.xk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceCheckFragment.onCameraError$lambda$6(this.f45837a, view);
            }
        });
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onClickBack() {
        i4a.a("onClickBack");
        onDetectResult(false);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2.unregisterReceiver(contextRequireContext, getDetectReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onPermissionDenied() {
        i4a.a("onPermissionDenied");
        onDetectResult(false);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.firstResume) {
            return;
        }
        this.firstResume = true;
        checkCameraPermission();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onTakePicture(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.picturePath = filePath;
        setLoadingDialog(DialogUtil.n(getActivity(), getLoadingTip()));
        Dialog loadingDialog = getLoadingDialog();
        if (loadingDialog != null) {
            loadingDialog.show();
        }
        new DetectFaceDelegate().y(filePath, getUploadFileType(), getUserFaceBean());
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onTakePictureError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2.registerReceiver(contextRequireContext, getDetectReceiver());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCountdown(long time) {
        if (modelIsInitialized()) {
            MutableLiveData<String> mutableLiveDataL = ((DetectFaceAuthVM) getMViewModel()).l();
            StringBuilder sb = new StringBuilder();
            sb.append(time);
            sb.append('s');
            mutableLiveDataL.setValue(sb.toString());
        }
        if (time == 0) {
            Dialog dialog = this.errorDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            fv5.b("跑步校验时间已经到啦，请继续运动哦~");
            onDetectResult(false);
        }
    }
}
