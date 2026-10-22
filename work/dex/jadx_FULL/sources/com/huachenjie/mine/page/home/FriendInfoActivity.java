package com.huachenjie.mine.page.home;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.h.OTHER_HOME)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mine/page/home/FriendInfoActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/view/ViewGroup;", "fragmentContainer", "S", "", "t", "Ljava/lang/String;", "appUserCode", "x", MineFragment.SKIP_TARGET, "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class FriendInfoActivity extends FragmentActivity {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Autowired(name = "appUserCode")
    @JvmField
    @Nullable
    public String appUserCode;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "target")
    @JvmField
    @Nullable
    public String skipTarget;

    public final void S(ViewGroup fragmentContainer) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.add(fragmentContainer.getId(), MineFragment.INSTANCE.a(true, this.appUserCode, this.skipTarget), MineFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
        ARouter.getInstance().inject(this);
        super.onCreate(savedInstanceState);
        ViewGroup frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.view_fl_container);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(frameLayout);
        S(frameLayout);
    }
}
