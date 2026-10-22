package com.huachenjie.im.page;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.page.base.BaseSignalTowerFragment;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = RoutePathConstants.IM.c)
public class SignalTowerActivity extends BaseVmActivity<BaseVM> {
    public String x;
    public String y;
    public String z;
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String> f9892a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f34524a = Boolean.FALSE;
    public int M = 0;
    public int N = -1;
    public int O = -1;

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.white).G1(true).q1(true).a1();
    }

    public final void f0(Intent intent) {
        if (intent != null) {
            this.x = intent.getStringExtra("teamId");
            this.y = intent.getStringExtra(UserConstants.CHAT_PARAMS.j);
            this.K = intent.getIntExtra(UserConstants.CHAT_PARAMS.o, 0);
            this.L = intent.getIntExtra(UserConstants.CHAT_PARAMS.p, 0);
            this.f9892a = intent.getStringArrayListExtra(UserConstants.CHAT_PARAMS.k);
            this.z = intent.getStringExtra(UserConstants.CHAT_PARAMS.l);
            this.f34524a = Boolean.valueOf(intent.getBooleanExtra(UserConstants.CHAT_PARAMS.q, false));
            this.M = intent.getIntExtra(UserConstants.CHAT_PARAMS.n, 0);
            this.N = intent.getIntExtra(BaseSignalTowerFragment.TAB_INDEX, -1);
            this.O = intent.getIntExtra(BaseSignalTowerFragment.OVERT_TYPE, -1);
        }
        g0();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out);
    }

    public final void g0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(R.id.flContainer, SignalTowerFragment.newInstance(this.x, this.y, this.K, this.L, this.f9892a, this.z, this.f34524a, this.M, this.N, this.O), SingleChatFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_signal_tower), Integer.valueOf(yk0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(Bundle bundle) {
        f0(getIntent());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }
}
