package com.huachenjie.base.aliyun.detect_face;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.broadcast.detect_face.DetectFaceListener;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import com.huachenjie.base.databinding.FragmentDetectFaceLocalCheckBinding;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.FaceResult;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.en6;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.il2;
import com.zj.adlib.jo2;
import com.zj.adlib.nj7;
import com.zj.adlib.nl8;
import com.zj.adlib.sk0;
import com.zj.adlib.v41;
import com.zj.adlib.vw3;
import com.zj.adlib.zn1;
import java.io.File;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001LB\u0007¢\u0006\u0004\bI\u0010JJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0016J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment;", "Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceLocalCheckBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthVM;", "", "initTitle", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "findDetectFaceFragment", "dealOnDetectSuccess", "dealOnDetectFail", "dealLastFaceData", "Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "detectStatus", "sendDetectStatus", "", "success", "onDetectResult", "setMaxBrightness", "restoreBrightness", "", "", "getVariables", "getLayoutResID", "onViewCreated", "onDestroyView", "initView", "onResume", "onPermissionDenied", "onClickBack", "Landroidx/camera/view/PreviewView;", "getPreviewView", "", "getLoadingTip", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "getUploadFileType", "message", "onCameraError", "isFaceAnalysis", "bodyEnable", "getFaceImg", "getSimilarityValue", "tip", "onFaceQualityTip", "onStartBodyDetection", "onEndBodyDetection", "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "onAnalyzerSuccess", "", "time", "setCountdown", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean$delegate", "Lkotlin/Lazy;", "getUserFaceBean", "()Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceLocalCheckFragment.USER_FACE_BEAN, "picturePath", "Ljava/lang/String;", "Landroid/app/Dialog;", "errorDialog", "Landroid/app/Dialog;", "originalBrightness", "Ljava/lang/Float;", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver$delegate", "getDetectReceiver", "()Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver", "firstResume", "Z", "<init>", "()V", "Companion", "a", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDetectFaceLocalCheckFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetectFaceLocalCheckFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,348:1\n470#2:349\n*S KotlinDebug\n*F\n+ 1 DetectFaceLocalCheckFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment\n*L\n111#1:349\n*E\n"})
public final class DetectFaceLocalCheckFragment extends FaceCameraFragment<FragmentDetectFaceLocalCheckBinding, DetectFaceAuthVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String USER_FACE_BEAN = "userFaceBean";

    @Nullable
    private Dialog errorDialog;
    private boolean firstResume;

    @Nullable
    private Float originalBrightness;

    @Nullable
    private String picturePath;

    /* JADX INFO: renamed from: userFaceBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userFaceBean = LazyKt.lazy(new Function0<UserFaceBean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$userFaceBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserFaceBean m202invoke() {
            Bundle arguments = this.this$0.getArguments();
            UserFaceBean userFaceBean = arguments != null ? (UserFaceBean) arguments.getParcelable("userFaceBean") : null;
            return userFaceBean == null ? new UserFaceBean(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null) : userFaceBean;
        }
    });

    /* JADX INFO: renamed from: detectReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detectReceiver = LazyKt.lazy(new Function0<DetectFaceReceiver>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$detectReceiver$2

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment$detectReceiver$2$a", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "", "a", "", "text", "c", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DetectFaceListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetectFaceLocalCheckFragment f32775a;

            public a(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment) {
                this.f32775a = detectFaceLocalCheckFragment;
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void a(@NotNull DetectResultBean result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Dialog loadingDialog = this.f32775a.getLoadingDialog();
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
                if (result.getSuccess()) {
                    this.f32775a.dealOnDetectSuccess();
                } else {
                    this.f32775a.dealOnDetectFail();
                }
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void c(@NotNull String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.f32775a.setSideText(text);
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DetectFaceReceiver m201invoke() {
            return new DetectFaceReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment$a;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceLocalCheckFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceLocalCheckFragment;", "a", "", "USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetectFaceLocalCheckFragment a(@NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(userFaceBean, DetectFaceLocalCheckFragment.USER_FACE_BEAN);
            DetectFaceLocalCheckFragment detectFaceLocalCheckFragment = new DetectFaceLocalCheckFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DetectFaceLocalCheckFragment.USER_FACE_BEAN, userFaceBean);
            detectFaceLocalCheckFragment.setArguments(bundle);
            return detectFaceLocalCheckFragment;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectFail$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectFail$1", f = "DetectFaceLocalCheckFragment.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectFail$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectFail$1$1", f = "DetectFaceLocalCheckFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ DetectFaceLocalCheckFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07821(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment, Continuation<? super C07821> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceLocalCheckFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07821(this.this$0, continuation);
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
            return DetectFaceLocalCheckFragment.this.new AnonymousClass1(continuation);
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
                C07821 c07821 = new C07821(DetectFaceLocalCheckFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07821, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            fv5.b("您未通过校验，请尝试重新校验。");
            DetectFaceLocalCheckFragment.access$getMViewModel(DetectFaceLocalCheckFragment.this).m().setValue("重新校验");
            DetectFaceLocalCheckFragment.this.resumeCamera();
            DetectFaceLocalCheckFragment.this.unlockCommit();
            DetectFaceLocalCheckFragment.this.reAnalyzer();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectSuccess$1", f = "DetectFaceLocalCheckFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectSuccess$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceLocalCheckFragment$dealOnDetectSuccess$1$1", f = "DetectFaceLocalCheckFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DetectFaceLocalCheckFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07831(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment, Continuation<? super C07831> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceLocalCheckFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07831(this.this$0, continuation);
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

        public C14531(Continuation<? super C14531> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DetectFaceLocalCheckFragment.this.new C14531(continuation);
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
                C07831 c07831 = new C07831(DetectFaceLocalCheckFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07831, this) == coroutine_suspended) {
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
    public static final /* synthetic */ DetectFaceAuthVM access$getMViewModel(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment) {
        return (DetectFaceAuthVM) detectFaceLocalCheckFragment.getMViewModel();
    }

    private final void dealLastFaceData() {
        if (getBestFaceData() == null) {
            sendDetectStatus(getDetectStatus());
            return;
        }
        this.picturePath = en6.K() + File.separator + "face_" + System.currentTimeMillis() + FileTypes.F;
        DetectFaceDelegate detectFaceDelegate = new DetectFaceDelegate();
        float bestSimilarity = getBestSimilarity();
        Pair<FaceResult, TrackingInfo> bestFaceData = getBestFaceData();
        Intrinsics.checkNotNull(bestFaceData);
        TrackingInfo trackingInfo = (TrackingInfo) bestFaceData.getSecond();
        String str = this.picturePath;
        Intrinsics.checkNotNull(str);
        detectFaceDelegate.x(false, bestSimilarity, trackingInfo, str, 256, 256, getUploadFileType(), getUserFaceBean().getRunRecordCode(), getUserFaceBean().getFaceCheckIndex(), getDetectStatus(), true);
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
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new C14531(null), 15, null);
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
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.gl2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceLocalCheckFragment.initTitle$lambda$3$lambda$2(this.f41931a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$3$lambda$2(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceLocalCheckFragment, "this$0");
        detectFaceLocalCheckFragment.onClickBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCameraError$lambda$4(DetectFaceLocalCheckFragment detectFaceLocalCheckFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceLocalCheckFragment, "this$0");
        detectFaceLocalCheckFragment.onDetectResult(false);
    }

    private final void onDetectResult(boolean success) {
        i4a.a("onDetectResult:" + success);
        DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = findDetectFaceFragment();
        if (detectFaceFragmentFindDetectFaceFragment != null) {
            detectFaceFragmentFindDetectFaceFragment.dismissAllowingStateLoss();
        }
    }

    private final void restoreBrightness() {
        Window window;
        Float f = this.originalBrightness;
        if (f != null) {
            float fFloatValue = f.floatValue();
            FragmentActivity activity = getActivity();
            if (activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(window, "window");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = fFloatValue;
            window.setAttributes(attributes);
        }
    }

    private final void sendDetectStatus(RunFaceDetectStatus detectStatus) {
        RunFaceCheckExtendBean runFaceCheckExtendBean = new RunFaceCheckExtendBean(vw3.u(detectStatus), null, null, 6, null);
        il2 il2Var = il2.f42385a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2Var.a(contextRequireContext, getUserFaceBean().getRunRecordCode(), runFaceCheckExtendBean, getUserFaceBean().getFaceCheckIndex());
    }

    private final void setMaxBrightness() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.originalBrightness = Float.valueOf(attributes.screenBrightness);
        attributes.screenBrightness = 1.0f;
        window.setAttributes(attributes);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public boolean bodyEnable() {
        return getUserFaceBean().getBodyEnable();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public String getFaceImg() {
        return getUserFaceBean().getFaceImg();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_face_local_check;
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
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        if (fragmentDetectFaceLocalCheckBinding != null) {
            return fragmentDetectFaceLocalCheckBinding.f7067a;
        }
        return null;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public int getSimilarityValue() {
        return getUserFaceBean().getSimilarityValue();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public UploadFileType getUploadFileType() {
        return UploadFileType.UPLOAD_FACE_RUN;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, DetectFaceAuthVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View view;
        initTitle();
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        if (fragmentDetectFaceLocalCheckBinding != null && (view = fragmentDetectFaceLocalCheckBinding.f32842a) != null) {
            nj7 nj7Var = new nj7(-1, SizeUtils.b(138.0f), 0, 0, 0, 0, 60, null);
            nj7Var.o(SizeUtils.b(8.0f));
            nj7Var.n(SizeUtils.b(138.0f));
            nj7Var.m(Color.parseColor("#FFF5F5F5"));
            view.setBackground(nj7Var);
        }
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding2 = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        TextView textView = fragmentDetectFaceLocalCheckBinding2 != null ? fragmentDetectFaceLocalCheckBinding2.b : null;
        if (textView != null) {
            textView.setText("*温馨提示：开始校验后可以停止跑步安心校验哦~如果校验不通过，请再校验下，要在" + getUserFaceBean().getFaceTime() + "s内完成。校验重复失败可联系客服，如果不校验或校验不通过，即使完成跑步也将无效！");
        }
        setCountdown(getUserFaceBean().getLeftTime());
        setSideText(getDetectStatus().statusString());
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public boolean isFaceAnalysis() {
        return getUserFaceBean().getFaceModelType() == 2;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onAnalyzerSuccess(float sim, @NotNull TrackingInfo trackingInfo) {
        Intrinsics.checkNotNullParameter(trackingInfo, "trackingInfo");
        this.picturePath = en6.K() + File.separator + "face_" + System.currentTimeMillis() + FileTypes.F;
        setLoadingDialog(DialogUtil.n(getActivity(), getLoadingTip()));
        Dialog loadingDialog = getLoadingDialog();
        if (loadingDialog != null) {
            loadingDialog.show();
        }
        DetectFaceDelegate detectFaceDelegate = new DetectFaceDelegate();
        String str = this.picturePath;
        Intrinsics.checkNotNull(str);
        detectFaceDelegate.x(true, sim, trackingInfo, str, 256, 256, getUploadFileType(), getUserFaceBean().getRunRecordCode(), getUserFaceBean().getFaceCheckIndex(), getDetectStatus(), true);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onCameraError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.errorDialog = ft1.A(context, "非常抱歉，我们暂时无法使用相机，请检查前置相机是否可用后，再进行人脸认证", "退出认证", new View.OnClickListener() { // from class: com.zj.adlib.hl2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceLocalCheckFragment.onCameraError$lambda$4(this.f42151a, view);
            }
        });
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onClickBack() {
        i4a.a("onClickBack");
        dealLastFaceData();
        onDetectResult(false);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2.unregisterReceiver(contextRequireContext, getDetectReceiver());
        restoreBrightness();
        try {
            nl8.e(requireContext()).u();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onEndBodyDetection() {
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        TextView textView = fragmentDetectFaceLocalCheckBinding != null ? fragmentDetectFaceLocalCheckBinding.f7066a : null;
        if (textView == null) {
            return;
        }
        textView.setText("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onFaceQualityTip(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        TextView textView = fragmentDetectFaceLocalCheckBinding != null ? fragmentDetectFaceLocalCheckBinding.f7066a : null;
        if (textView == null) {
            return;
        }
        textView.setText(tip);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onStartBodyDetection() {
        FragmentDetectFaceLocalCheckBinding fragmentDetectFaceLocalCheckBinding = (FragmentDetectFaceLocalCheckBinding) getMBinding();
        TextView textView = fragmentDetectFaceLocalCheckBinding != null ? fragmentDetectFaceLocalCheckBinding.f7066a : null;
        if (textView != null) {
            textView.setText(getString(R.string.detect_face_local_check_action_tip));
        }
        try {
            nl8.e(requireContext()).q(R.raw.base_run_face_action_shake);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2.registerReceiver(contextRequireContext, getDetectReceiver());
        setMaxBrightness();
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
            dealLastFaceData();
            onDetectResult(false);
        }
    }
}
