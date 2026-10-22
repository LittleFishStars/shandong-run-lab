package com.huachenjie.run.page.free_run;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.run.R;
import com.zj.adlib.nl8;
import com.zj.adlib.vo6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.n)
public class FreeRunMainActivity extends BaseActivity<a> implements FreeRunMainContact.FreeRunMainView {
    public static String A = null;
    public static List<String> c = null;
    public static final String z = "fragment_last_fragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RequiredSettingComponent f35862a;
    public String t;
    public String x;
    public String y;

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.run_activity_free_run_main;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void getServerData() {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e.p3(this).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
        this.x = intent.getStringExtra("title");
        this.y = intent.getStringExtra("content");
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        A = FreeRunFragment.class.getName();
        ArrayList arrayList = new ArrayList();
        c = arrayList;
        arrayList.add(A);
        this.f35862a = new RequiredSettingComponent(((BaseActivity) this).c);
        getLifecycle().addObserver(this.f35862a);
        nl8.e(((BaseActivity) this).c);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        if (!vo6.a(((BaseActivity) this).c)) {
            this.f35862a.d(1);
        } else if (vo6.c(this, Permission.POST_NOTIFICATIONS)) {
            k0();
        } else {
            this.f35862a.d(2);
        }
    }

    public final void k0() {
        if (TextUtils.isEmpty(this.y)) {
            return;
        }
        Activity activity = ((BaseActivity) this).c;
        DialogUtil.H(activity, this.x, this.y, activity.getString(R.string.i_know), null);
    }

    public final void l0(String fragmentName) {
        if (TextUtils.isEmpty(fragmentName)) {
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(fragmentName);
        if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isVisible()) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            for (String str : c) {
                if (TextUtils.equals(fragmentName, str)) {
                    Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(str);
                    if (fragmentFindFragmentByTag2 == null) {
                        fragmentTransactionBeginTransaction.add(R.id.fragment_container, Fragment.instantiate(getApplication(), fragmentName, null), fragmentName);
                    } else if (fragmentFindFragmentByTag2.isHidden()) {
                        fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
                    }
                } else {
                    Fragment fragmentFindFragmentByTag3 = supportFragmentManager.findFragmentByTag(str);
                    if (fragmentFindFragmentByTag3 != null && !fragmentFindFragmentByTag3.isHidden()) {
                        fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
                    }
                }
            }
            this.t = fragmentName;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        super.onCreate(savedInstanceState);
        String string = savedInstanceState != null ? savedInstanceState.getString(z) : null;
        if (string == null) {
            l0(c.get(0));
        } else {
            l0(string);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        nl8.e(((BaseActivity) this).c).r();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(z, this.t);
    }

    @Override // com.huachenjie.common.base.BaseActivity, com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public a initPresenter() {
        return new a();
    }
}
