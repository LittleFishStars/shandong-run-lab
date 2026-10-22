package com.huachenjie.im.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.databinding.ActivityChatTeamBinding;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = RoutePathConstants.IM.e)
public class TeamChatActivity extends BaseVmActivity<BaseVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TeamChatFragment f34555a;
    public String x;
    public String y;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        this.f34555a.startTeamMemberActivity();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.white).G1(true).q1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_chat_team), Integer.valueOf(yk0.L), ((BaseVmActivity) this).f8507a);
    }

    public final void h0(Intent intent) {
        if (intent != null) {
            this.x = intent.getStringExtra("accountId");
            this.y = intent.getStringExtra(UserConstants.CHAT_TEAM_PARAMS.b);
        }
        l0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(Bundle bundle) {
        h0(getIntent());
        if (getBinding() == null || !(getBinding() instanceof ActivityChatTeamBinding)) {
            return;
        }
        ActivityChatTeamBinding activityChatTeamBinding = (ActivityChatTeamBinding) getBinding();
        activityChatTeamBinding.f9648a.setText(this.y);
        activityChatTeamBinding.f9647a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.q19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44104a.i0(view);
            }
        });
        activityChatTeamBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.r19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44344a.j0(view);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public void k0(int i) {
        if (getBinding() == null || !(getBinding() instanceof ActivityChatTeamBinding)) {
            return;
        }
        ((ActivityChatTeamBinding) getBinding()).f9648a.setText(String.format("%s(%d)", this.y, Integer.valueOf(i)));
    }

    public final void l0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        TeamChatFragment teamChatFragmentNewInstance = TeamChatFragment.newInstance(this.x);
        this.f34555a = teamChatFragmentNewInstance;
        fragmentTransactionBeginTransaction.add(R.id.flContainer, teamChatFragmentNewInstance, TeamChatFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
