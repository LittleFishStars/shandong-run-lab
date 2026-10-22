package com.huachenjie.common.reconfig.baseView;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.zj.adlib.r90;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/huachenjie/common/reconfig/baseView/IBaseView;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "S", "T", "U", "Landroid/content/res/Resources;", "getResources", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    public void T() {
        setContentView(getLayoutResID());
    }

    public void U() {
        initView();
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        Intrinsics.checkNotNullExpressionValue(resources, "res");
        return resources;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (r90.G()) {
            ARouter.getInstance().inject(this);
        }
        S();
        super.onCreate(savedInstanceState);
        b(savedInstanceState);
        T();
        U();
    }
}
