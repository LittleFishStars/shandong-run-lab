package com.huachenjie.base.aliyun.detect_face;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.R;
import com.huachenjie.base.aliyun.detect_face.DetectLastFaceFragment;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.databinding.FragmentDetectLaseFaceBinding;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.i4a;
import com.zj.adlib.nj7;
import com.zj.adlib.sk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectLaseFaceBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceVM;", "", "initTitle", "", "", "", "getVariables", "getLayoutResID", "initView", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "findDetectFaceFragment", "onClickBack", "onDetectResult", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean$delegate", "Lkotlin/Lazy;", "getUserFaceBean", "()Lcom/huachenjie/base/bean/UserFaceBean;", DetectLastFaceFragment.USER_FACE_BEAN, "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectLastFaceFragment extends BaseMVVMFragment<FragmentDetectLaseFaceBinding, DetectLastFaceVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String USER_FACE_BEAN = "userFaceBean";

    /* JADX INFO: renamed from: userFaceBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userFaceBean = LazyKt.lazy(new Function0<UserFaceBean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectLastFaceFragment$userFaceBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserFaceBean m204invoke() {
            Bundle arguments = this.this$0.getArguments();
            UserFaceBean userFaceBean = arguments != null ? (UserFaceBean) arguments.getParcelable("userFaceBean") : null;
            return userFaceBean == null ? new UserFaceBean(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null) : userFaceBean;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceFragment$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceFragment;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = DetectLastFaceFragment.this.findDetectFaceFragment();
            if (detectFaceFragmentFindDetectFaceFragment != null) {
                detectFaceFragmentFindDetectFaceFragment.showFaceAuthFragment();
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = DetectLastFaceFragment.this.findDetectFaceFragment();
            if (detectFaceFragmentFindDetectFaceFragment != null) {
                detectFaceFragmentFindDetectFaceFragment.showFaceUploadFragment();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectLastFaceFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceFragment$b;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", DetectLastFaceFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/aliyun/detect_face/DetectLastFaceFragment;", "a", "", "USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetectLastFaceFragment a(@NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(userFaceBean, DetectLastFaceFragment.USER_FACE_BEAN);
            DetectLastFaceFragment detectLastFaceFragment = new DetectLastFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DetectLastFaceFragment.USER_FACE_BEAN, userFaceBean);
            detectLastFaceFragment.setArguments(bundle);
            return detectLastFaceFragment;
        }
    }

    private final UserFaceBean getUserFaceBean() {
        return (UserFaceBean) this.userFaceBean.getValue();
    }

    private final void initTitle() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
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
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ll2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetectLastFaceFragment.initTitle$lambda$3$lambda$2(this.f43092a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitle$lambda$3$lambda$2(DetectLastFaceFragment detectLastFaceFragment, View view) {
        Intrinsics.checkNotNullParameter(detectLastFaceFragment, "this$0");
        detectLastFaceFragment.onClickBack();
    }

    @Nullable
    public final DetectFaceFragment findDetectFaceFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof DetectFaceFragment)) {
            return (DetectFaceFragment) parentFragment;
        }
        return null;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_lase_face;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View view;
        initTitle();
        FragmentDetectLaseFaceBinding mBinding = getMBinding();
        if (mBinding != null && (view = mBinding.f32851a) != null) {
            nj7 nj7Var = new nj7(-1, SizeUtils.b(138.0f), 0, 0, 0, 0, 60, null);
            nj7Var.o(SizeUtils.b(8.0f));
            nj7Var.n(SizeUtils.b(138.0f));
            nj7Var.m(Color.parseColor("#FFF5F5F5"));
            view.setBackground(nj7Var);
        }
        getMViewModel().j().setValue(getUserFaceBean().getFaceImg());
    }

    public final void onClickBack() {
        i4a.a("onClickBack");
        onDetectResult();
    }

    public final void onDetectResult() {
        DetectFaceFragment detectFaceFragmentFindDetectFaceFragment = findDetectFaceFragment();
        if (detectFaceFragmentFindDetectFaceFragment != null) {
            detectFaceFragmentFindDetectFaceFragment.dismissAllowingStateLoss();
        }
    }
}
