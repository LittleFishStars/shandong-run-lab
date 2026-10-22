package com.huachenjie.base.aliyun.detect_face;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.broadcast.detect_face.DetectFaceListener;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import com.huachenjie.base.databinding.FragmentDetectFaceAuthBinding;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.en6;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.il2;
import com.zj.adlib.jo2;
import com.zj.adlib.nj7;
import com.zj.adlib.sk0;
import com.zj.adlib.v41;
import com.zj.adlib.zn1;
import java.io.File;
import java.util.Map;
import kotlin.Function;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 F2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002GHB\u0007¢\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\u0018\u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u00102¨\u0006I"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment;", "Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceAuthBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthVM;", "", "initTitle", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "findDetectFaceFragment", "", "fileUrl", "dealOnDetectSuccess", "dealOnDetectFail", "onDetectResult", "", "", "", "getVariables", "getLayoutResID", "onViewCreated", "onDestroyView", "initView", "onResume", "initDataObservable", "onPermissionDenied", "onClickBack", "Landroidx/camera/view/PreviewView;", "getPreviewView", "getLoadingTip", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "getUploadFileType", "message", "onCameraError", "onTakePictureError", "filePath", "onTakePicture", "", "isFaceAnalysis", "bodyEnable", "getFaceImg", "getSimilarityValue", "tip", "onFaceQualityTip", "onStartBodyDetection", "onEndBodyDetection", "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "onAnalyzerSuccess", "picturePath", "Ljava/lang/String;", "Landroid/app/Dialog;", "errorDialog", "Landroid/app/Dialog;", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean$delegate", "Lkotlin/Lazy;", "getUserFaceBean", "()Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceAuthFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver$delegate", "getDetectReceiver", "()Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver", "firstResume", "Z", "defaultTip", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDetectFaceAuthFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetectFaceAuthFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,279:1\n470#2:280\n*S KotlinDebug\n*F\n+ 1 DetectFaceAuthFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment\n*L\n105#1:280\n*E\n"})
public final class DetectFaceAuthFragment extends FaceCameraFragment<FragmentDetectFaceAuthBinding, DetectFaceAuthVM> {

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
    private final Lazy userFaceBean = LazyKt.lazy(new Function0<UserFaceBean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$userFaceBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserFaceBean m196invoke() {
            Bundle arguments = this.this$0.getArguments();
            UserFaceBean userFaceBean = arguments != null ? (UserFaceBean) arguments.getParcelable("userFaceBean") : null;
            return userFaceBean == null ? new UserFaceBean(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null) : userFaceBean;
        }
    });

    /* JADX INFO: renamed from: detectReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detectReceiver = LazyKt.lazy(new Function0<DetectFaceReceiver>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$detectReceiver$2

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment$detectReceiver$2$a", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "", "a", "", "text", "c", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DetectFaceListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetectFaceAuthFragment f32767a;

            public a(DetectFaceAuthFragment detectFaceAuthFragment) {
                this.f32767a = detectFaceAuthFragment;
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void a(@NotNull DetectResultBean result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Dialog loadingDialog = this.f32767a.getLoadingDialog();
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
                if (!result.getSuccess() || TextUtils.isEmpty(result.getCompareFaceUrl())) {
                    this.f32767a.dealOnDetectFail();
                    return;
                }
                DetectFaceAuthFragment detectFaceAuthFragment = this.f32767a;
                String compareFaceUrl = result.getCompareFaceUrl();
                Intrinsics.checkNotNull(compareFaceUrl);
                detectFaceAuthFragment.dealOnDetectSuccess(compareFaceUrl);
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void c(@NotNull String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.f32767a.setSideText(text);
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DetectFaceReceiver m195invoke() {
            return new DetectFaceReceiver(new a(this.this$0));
        }
    });

    @NotNull
    private final String defaultTip = "请将脸部正对取景框，并保持光线充足";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DetectFaceAuthFragment detectFaceAuthFragment = DetectFaceAuthFragment.this;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            detectFaceAuthFragment.takePhoto(context);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment$b;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceAuthFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthFragment;", "a", "", "USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetectFaceAuthFragment a(@NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(userFaceBean, DetectFaceAuthFragment.USER_FACE_BEAN);
            DetectFaceAuthFragment detectFaceAuthFragment = new DetectFaceAuthFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DetectFaceAuthFragment.USER_FACE_BEAN, userFaceBean);
            detectFaceAuthFragment.setArguments(bundle);
            return detectFaceAuthFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f32766a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f32766a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f32766a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f32766a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectFail$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectFail$1", f = "DetectFaceAuthFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectFail$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectFail$1$1", f = "DetectFaceAuthFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ DetectFaceAuthFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07781(DetectFaceAuthFragment detectFaceAuthFragment, Continuation<? super C07781> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceAuthFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07781(this.this$0, continuation);
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
            return DetectFaceAuthFragment.this.new AnonymousClass1(continuation);
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
                C07781 c07781 = new C07781(DetectFaceAuthFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07781, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            fv5.b("您未通过人脸认证，请尝试重新绑定人脸或者重新认证。");
            DetectFaceAuthFragment.this.resumeCamera();
            DetectFaceAuthFragment.this.unlockCommit();
            DetectFaceAuthFragment.this.reAnalyzer();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectSuccess$1", f = "DetectFaceAuthFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectSuccess$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment$dealOnDetectSuccess$1$1", f = "DetectFaceAuthFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DetectFaceAuthFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07791(DetectFaceAuthFragment detectFaceAuthFragment, Continuation<? super C07791> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceAuthFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07791(this.this$0, continuation);
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

        public C14501(Continuation<? super C14501> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DetectFaceAuthFragment.this.new C14501(continuation);
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
                C07791 c07791 = new C07791(DetectFaceAuthFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07791, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.common.reconfig.mvvm.BaseViewModel] */
    public final void dealOnDetectFail() {
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new AnonymousClass1(null), 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.huachenjie.common.reconfig.mvvm.BaseViewModel] */
    public final void dealOnDetectSuccess(String fileUrl) {
        ((DetectFaceAuthVM) getMViewModel()).j(fileUrl);
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new C14501(null), 15, null);
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
        bindingTitleBean.setTitleName("人脸认证");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceAuthFragment.initTitle$lambda$3$lambda$2(this.f45374a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$3$lambda$2(DetectFaceAuthFragment detectFaceAuthFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceAuthFragment, "this$0");
        detectFaceAuthFragment.onClickBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCameraError$lambda$4(DetectFaceAuthFragment detectFaceAuthFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceAuthFragment, "this$0");
        detectFaceAuthFragment.onDetectResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDetectResult() {
        DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = findDetectFaceFragment();
        if (detectFaceFragmentFindDetectFaceFragment != null) {
            detectFaceFragmentFindDetectFaceFragment.dismissAllowingStateLoss();
        }
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
        return R.layout.fragment_detect_face_auth;
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
        FragmentDetectFaceAuthBinding fragmentDetectFaceAuthBinding = (FragmentDetectFaceAuthBinding) getMBinding();
        if (fragmentDetectFaceAuthBinding != null) {
            return fragmentDetectFaceAuthBinding.f7041a;
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
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        ((DetectFaceAuthVM) getMViewModel()).k().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.equals("error", str)) {
                    fv5.b("恭喜您已完成人脸认证!");
                    DetectFaceAuthFragment.this.onDetectResult();
                } else {
                    DetectFaceAuthFragment.this.resumeCamera();
                    DetectFaceAuthFragment.this.unlockCommit();
                    DetectFaceAuthFragment.this.reAnalyzer();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View view;
        initTitle();
        FragmentDetectFaceAuthBinding fragmentDetectFaceAuthBinding = (FragmentDetectFaceAuthBinding) getMBinding();
        if (fragmentDetectFaceAuthBinding != null && (view = fragmentDetectFaceAuthBinding.f32834a) != null) {
            nj7 nj7Var = new nj7(-1, SizeUtils.b(138.0f), 0, 0, 0, 0, 60, null);
            nj7Var.o(SizeUtils.b(8.0f));
            nj7Var.n(SizeUtils.b(138.0f));
            nj7Var.m(Color.parseColor("#FFF5F5F5"));
            view.setBackground(nj7Var);
        }
        ((DetectFaceAuthVM) getMViewModel()).m().setValue("人脸认证");
        ((DetectFaceAuthVM) getMViewModel()).n().setValue(Boolean.valueOf(!isFaceAnalysis()));
        if (isFaceAnalysis()) {
            setSideText(getDetectStatus().statusString());
        }
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
        detectFaceDelegate.x(true, sim, trackingInfo, str, 256, 256, getUploadFileType(), getUserFaceBean().getRunRecordCode(), getUserFaceBean().getFaceCheckIndex(), getDetectStatus(), false);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onCameraError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.errorDialog = ft1.A(context, "非常抱歉，我们暂时无法使用相机，请检查前置相机是否可用后，再进行人脸认证", "退出认证", new View.OnClickListener() { // from class: com.zj.adlib.uk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceAuthFragment.onCameraError$lambda$4(this.f45164a, view);
            }
        });
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onClickBack() {
        i4a.a("onClickBack");
        onDetectResult();
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        il2.unregisterReceiver(contextRequireContext, getDetectReceiver());
        super.onDestroyView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onEndBodyDetection() {
        FragmentDetectFaceAuthBinding fragmentDetectFaceAuthBinding = (FragmentDetectFaceAuthBinding) getMBinding();
        TextView textView = fragmentDetectFaceAuthBinding != null ? fragmentDetectFaceAuthBinding.b : null;
        if (textView == null) {
            return;
        }
        textView.setText(this.defaultTip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onFaceQualityTip(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        FragmentDetectFaceAuthBinding fragmentDetectFaceAuthBinding = (FragmentDetectFaceAuthBinding) getMBinding();
        TextView textView = fragmentDetectFaceAuthBinding != null ? fragmentDetectFaceAuthBinding.b : null;
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(tip)) {
            tip = this.defaultTip;
        }
        textView.setText(tip);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onPermissionDenied() {
        i4a.a("onPermissionDenied");
        onDetectResult();
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
        FragmentDetectFaceAuthBinding fragmentDetectFaceAuthBinding = (FragmentDetectFaceAuthBinding) getMBinding();
        TextView textView = fragmentDetectFaceAuthBinding != null ? fragmentDetectFaceAuthBinding.b : null;
        if (textView == null) {
            return;
        }
        textView.setText(getString(R.string.detect_face_local_check_action_tip));
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
}
