package com.huachenjie.base.aliyun.detect_face;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.gyf.immersionbar.e;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.databinding.FragmentDetectFaceBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.zj.adlib.sk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceVM;", "", "showDarkStatusBar", "Landroidx/fragment/app/Fragment;", "fragment", "showFragment", "", "", "getVariables", "getWidth", "getHeight", "getLayoutResID", "onStart", "onViewCreated", "initData", "initView", "showFaceUploadFragment", "", "url", "updateFaceUrl", "showLastFaceFragment", "showFaceAuthFragment", "showFaceCheckFragment", "", "time", "setCountdown", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean$delegate", "Lkotlin/Lazy;", "getUserFaceBean", "()Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceFragment.USER_FACE_BEAN, "<init>", "()V", "Companion", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectFaceFragment extends BaseMVVMDialogFragment<FragmentDetectFaceBinding, DetectFaceVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String USER_FACE_BEAN = "userFaceBean";

    /* JADX INFO: renamed from: userFaceBean$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userFaceBean = LazyKt.lazy(new Function0<UserFaceBean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceFragment$userFaceBean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UserFaceBean m200invoke() {
            Bundle arguments = this.this$0.getArguments();
            UserFaceBean userFaceBean = arguments != null ? (UserFaceBean) arguments.getParcelable("userFaceBean") : null;
            return userFaceBean == null ? new UserFaceBean(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null) : userFaceBean;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment$a;", "", "Lcom/huachenjie/base/bean/UserFaceBean;", DetectFaceFragment.USER_FACE_BEAN, "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceFragment;", "a", "", "USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetectFaceFragment a(@NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(userFaceBean, DetectFaceFragment.USER_FACE_BEAN);
            DetectFaceFragment detectFaceFragment = new DetectFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DetectFaceFragment.USER_FACE_BEAN, userFaceBean);
            detectFaceFragment.setArguments(bundle);
            return detectFaceFragment;
        }
    }

    private final UserFaceBean getUserFaceBean() {
        return (UserFaceBean) this.userFaceBean.getValue();
    }

    private final void showDarkStatusBar() {
        e eVarX3 = e.x3(this);
        int i = R.color.white;
        eVarX3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    private final void showFragment(Fragment fragment) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R.id.fl_container, fragment, fragment.getClass().getSimpleName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_face;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, DetectFaceVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        if (TextUtils.isEmpty(getUserFaceBean().getFaceImg())) {
            setCancelable(true);
            showFragment(new DetectFaceNoticeFragment());
        } else if (getUserFaceBean().getFaceAuth()) {
            showFaceCheckFragment();
        } else {
            showLastFaceFragment();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(1024);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public void onViewCreated() {
        super.onViewCreated();
        showDarkStatusBar();
    }

    public final void setCountdown(long time) {
        if (isAdded()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(getUserFaceBean().getFaceModelType() == 1 ? DetectFaceCheckFragment.class.getSimpleName() : DetectFaceLocalCheckFragment.class.getSimpleName());
            if (fragmentFindFragmentByTag instanceof DetectFaceCheckFragment) {
                ((DetectFaceCheckFragment) fragmentFindFragmentByTag).setCountdown(time);
            } else if (fragmentFindFragmentByTag instanceof DetectFaceLocalCheckFragment) {
                ((DetectFaceLocalCheckFragment) fragmentFindFragmentByTag).setCountdown(time);
            }
        }
    }

    public final void showFaceAuthFragment() {
        setCancelable(false);
        showFragment(DetectFaceAuthFragment.INSTANCE.a(getUserFaceBean()));
    }

    public final void showFaceCheckFragment() {
        setCancelable(false);
        showFragment(getUserFaceBean().getFaceModelType() == 1 ? DetectFaceCheckFragment.INSTANCE.a(getUserFaceBean()) : DetectFaceLocalCheckFragment.INSTANCE.a(getUserFaceBean()));
    }

    public final void showFaceUploadFragment() {
        setCancelable(false);
        showFragment(new DetectFaceUploadFragment());
    }

    public final void showLastFaceFragment() {
        setCancelable(false);
        showFragment(DetectLastFaceFragment.INSTANCE.a(getUserFaceBean()));
    }

    public final void updateFaceUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        getUserFaceBean().setFaceImg(url);
    }
}
