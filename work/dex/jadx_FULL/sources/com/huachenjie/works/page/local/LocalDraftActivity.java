package com.huachenjie.works.page.local;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksActivityLocalDraftBinding;
import com.huachenjie.works.page.local.LocalDraftActivity;
import com.zj.adlib.cr2;
import com.zj.adlib.qk0;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.WORKS_DRAFT)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/local/LocalDraftActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "W", "U", "Landroid/view/ViewGroup;", "fragmentContainer", "X", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "T", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class LocalDraftActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    public static final void V(LocalDraftActivity localDraftActivity, View view) {
        Intrinsics.checkNotNullParameter(localDraftActivity, "this$0");
        localDraftActivity.finish();
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> T() {
        return this.titleBean;
    }

    public final void U() {
        MutableLiveData<BindingTitleBean> mutableLiveData = this.titleBean;
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(getString(R.string.works_local_draft_title));
        int i = R.color.color_2C3E50;
        mutableLiveData.setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.gz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalDraftActivity.V(this.f42015a, view);
            }
        }).setStatusBarHeight(cr2.b(this, e.H0(this))));
    }

    public final void W() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    public final void X(ViewGroup fragmentContainer) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.add(fragmentContainer.getId(), new LocalWorksFragment(), LocalWorksFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        W();
        WorksActivityLocalDraftBinding worksActivityLocalDraftBinding = (WorksActivityLocalDraftBinding) DataBindingUtil.setContentView(this, R.layout.works_activity_local_draft);
        worksActivityLocalDraftBinding.setLifecycleOwner(this);
        worksActivityLocalDraftBinding.setVariable(qk0.p0, this);
        U();
        FrameLayout frameLayout = worksActivityLocalDraftBinding.f36784a;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flContainer");
        X(frameLayout);
    }
}
