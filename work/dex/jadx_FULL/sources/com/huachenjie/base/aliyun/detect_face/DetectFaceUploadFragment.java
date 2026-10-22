package com.huachenjie.base.aliyun.detect_face;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.camera.view.PreviewView;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment;
import com.huachenjie.base.broadcast.detect_face.DetectFaceListener;
import com.huachenjie.base.broadcast.detect_face.DetectFaceReceiver;
import com.huachenjie.base.databinding.FragmentDetectFaceUploadBinding;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.util.DialogUtil;
import com.igexin.push.g.o;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\bH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment;", "Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceUploadBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceUploadVM;", "", "initTitle", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "findDetectFaceFragment", "", "fileUrl", "uploadPictureSuccess", "onDetectResult", "", "", "", "getVariables", "getLayoutResID", "onViewCreated", "onDestroyView", "initView", "onResume", "initDataObservable", "onPermissionDenied", "onClickBack", "Landroidx/camera/view/PreviewView;", "getPreviewView", "getLoadingTip", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "getUploadFileType", "message", "onCameraError", "onTakePictureError", "filePath", "onTakePicture", "picturePath", "Ljava/lang/String;", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver$delegate", "Lkotlin/Lazy;", "getDetectReceiver", "()Lcom/huachenjie/base/broadcast/detect_face/DetectFaceReceiver;", "detectReceiver", "", "firstResume", "Z", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDetectFaceUploadFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetectFaceUploadFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,189:1\n470#2:190\n*S KotlinDebug\n*F\n+ 1 DetectFaceUploadFragment.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment\n*L\n77#1:190\n*E\n"})
public final class DetectFaceUploadFragment extends FaceCameraFragment<FragmentDetectFaceUploadBinding, DetectFaceUploadVM> {

    /* JADX INFO: renamed from: detectReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detectReceiver = LazyKt.lazy(new Function0<DetectFaceReceiver>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment$detectReceiver$2

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment$detectReceiver$2$a", "Lcom/huachenjie/base/broadcast/detect_face/DetectFaceListener;", "Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "result", "", "a", "", "text", "c", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DetectFaceListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DetectFaceUploadFragment f32780a;

            public a(DetectFaceUploadFragment detectFaceUploadFragment) {
                this.f32780a = detectFaceUploadFragment;
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void a(@NotNull DetectResultBean result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Dialog loadingDialog = this.f32780a.getLoadingDialog();
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
                if (!result.getSuccess() || TextUtils.isEmpty(result.getCompareFaceUrl())) {
                    fv5.b("图片上传失败");
                    this.f32780a.resumeCamera();
                    this.f32780a.unlockCommit();
                } else {
                    DetectFaceUploadFragment detectFaceUploadFragment = this.f32780a;
                    String compareFaceUrl = result.getCompareFaceUrl();
                    Intrinsics.checkNotNull(compareFaceUrl);
                    detectFaceUploadFragment.uploadPictureSuccess(compareFaceUrl);
                }
            }

            @Override // com.huachenjie.base.broadcast.detect_face.DetectFaceListener
            public void c(@NotNull String text) {
                Intrinsics.checkNotNullParameter(text, "text");
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DetectFaceReceiver m203invoke() {
            return new DetectFaceReceiver(new a(this.this$0));
        }
    });
    private boolean firstResume;

    @Nullable
    private String picturePath;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/aliyun/detect_face/DetectFaceUploadFragment;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DetectFaceUploadFragment detectFaceUploadFragment = DetectFaceUploadFragment.this;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            detectFaceUploadFragment.takePhoto(context);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f32779a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f32779a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f32779a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f32779a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment$uploadPictureSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment$uploadPictureSuccess$1", f = "DetectFaceUploadFragment.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileUrl;
        int label;

        /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment$uploadPictureSuccess$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment$uploadPictureSuccess$1$1", f = "DetectFaceUploadFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C07841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ DetectFaceUploadFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C07841(DetectFaceUploadFragment detectFaceUploadFragment, Continuation<? super C07841> continuation) {
                super(2, continuation);
                this.this$0 = detectFaceUploadFragment;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C07841(this.this$0, continuation);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14541(String str, Continuation<? super C14541> continuation) {
            super(2, continuation);
            this.$fileUrl = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DetectFaceUploadFragment.this.new C14541(this.$fileUrl, continuation);
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
                C07841 c07841 = new C07841(DetectFaceUploadFragment.this, null);
                this.label = 1;
                if (v41.h(coroutineDispatcherC, c07841, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DetectFaceUploadFragment.access$getMViewModel(DetectFaceUploadFragment.this).k(this.$fileUrl);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ DetectFaceUploadVM access$getMViewModel(DetectFaceUploadFragment detectFaceUploadFragment) {
        return (DetectFaceUploadVM) detectFaceUploadFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DetectFaceFragment findDetectFaceFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof DetectFaceFragment)) {
            return (DetectFaceFragment) parentFragment;
        }
        return null;
    }

    private final DetectFaceReceiver getDetectReceiver() {
        return (DetectFaceReceiver) this.detectReceiver.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initTitle() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = ((DetectFaceUploadVM) getMViewModel()).i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((DetectFaceUploadVM) getMViewModel()).e().b().getValue();
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
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.jl2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceUploadFragment.initTitle$lambda$3$lambda$2(this.f42612a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$3$lambda$2(DetectFaceUploadFragment detectFaceUploadFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceUploadFragment, "this$0");
        detectFaceUploadFragment.onClickBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCameraError$lambda$4(DetectFaceUploadFragment detectFaceUploadFragment, View view) {
        Intrinsics.checkNotNullParameter(detectFaceUploadFragment, "this$0");
        detectFaceUploadFragment.onDetectResult();
    }

    private final void onDetectResult() {
        DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = findDetectFaceFragment();
        if (detectFaceFragmentFindDetectFaceFragment != null) {
            detectFaceFragmentFindDetectFaceFragment.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.common.reconfig.mvvm.BaseViewModel] */
    public final void uploadPictureSuccess(String fileUrl) {
        BaseViewModelExtKt.b(getMViewModel(), false, false, null, null, new C14541(fileUrl, null), 15, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_face_upload;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public String getLoadingTip() {
        return "绑定中…";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @Nullable
    public PreviewView getPreviewView() {
        FragmentDetectFaceUploadBinding fragmentDetectFaceUploadBinding = (FragmentDetectFaceUploadBinding) getMBinding();
        if (fragmentDetectFaceUploadBinding != null) {
            return fragmentDetectFaceUploadBinding.f7083a;
        }
        return null;
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    @NotNull
    public UploadFileType getUploadFileType() {
        return UploadFileType.UPLOAD_FACE_USER;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        ((DetectFaceUploadVM) getMViewModel()).j().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment.initDataObservable.1
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
                if (TextUtils.equals("error", str)) {
                    DetectFaceUploadFragment.this.resumeCamera();
                    DetectFaceUploadFragment.this.unlockCommit();
                    return;
                }
                DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = DetectFaceUploadFragment.this.findDetectFaceFragment();
                if (detectFaceFragmentFindDetectFaceFragment != null) {
                    Intrinsics.checkNotNullExpressionValue(str, o.f);
                    detectFaceFragmentFindDetectFaceFragment.updateFaceUrl(str);
                }
                DetectFaceFragment detectFaceFragmentFindDetectFaceFragment2 = DetectFaceUploadFragment.this.findDetectFaceFragment();
                if (detectFaceFragmentFindDetectFaceFragment2 != null) {
                    detectFaceFragmentFindDetectFaceFragment2.showLastFaceFragment();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View view;
        initTitle();
        FragmentDetectFaceUploadBinding fragmentDetectFaceUploadBinding = (FragmentDetectFaceUploadBinding) getMBinding();
        if (fragmentDetectFaceUploadBinding == null || (view = fragmentDetectFaceUploadBinding.f32848a) == null) {
            return;
        }
        nj7 nj7Var = new nj7(-1, SizeUtils.b(138.0f), 0, 0, 0, 0, 60, null);
        nj7Var.o(SizeUtils.b(8.0f));
        nj7Var.n(SizeUtils.b(138.0f));
        nj7Var.m(Color.parseColor("#FFF5F5F5"));
        view.setBackground(nj7Var);
    }

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onCameraError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        i4a.a("onCameraError");
        Context context = getContext();
        if (context == null) {
            return;
        }
        ft1.A(context, "非常抱歉，我们暂时无法使用相机，请检查前置相机是否可用后，再进行人脸认证", "退出认证", new View.OnClickListener() { // from class: com.zj.adlib.kl2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectFaceUploadFragment.onCameraError$lambda$4(this.f42847a, view);
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

    @Override // com.huachenjie.base.aliyun.detect_face.FaceCameraFragment
    public void onTakePicture(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.picturePath = filePath;
        setLoadingDialog(DialogUtil.n(getActivity(), getLoadingTip()));
        Dialog loadingDialog = getLoadingDialog();
        if (loadingDialog != null) {
            loadingDialog.show();
        }
        new DetectFaceDelegate().y(filePath, getUploadFileType(), null);
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
