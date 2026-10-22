package com.huachenjie.im.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.databinding.ActivityChatRoomBinding;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = RoutePathConstants.IM.d)
public class ChatRoomActivity extends BaseVmActivity<BaseVM> {
    public int K = 100;
    public String x;
    public String y;
    public String z;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).u1(R.color.white).G1(true).q1(true).a1();
    }

    public final void g0(Intent intent) {
        if (intent != null) {
            this.x = intent.getStringExtra("accountId");
            this.y = intent.getStringExtra(UserConstants.CHAT_ROOM_PARAMS.b);
            this.z = intent.getStringExtra(UserConstants.CHAT_ROOM_PARAMS.c);
        }
        j0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_chat_room), Integer.valueOf(yk0.L), ((BaseVmActivity) this).f8507a);
    }

    public void i0(int i) {
        if (getBinding() == null || !(getBinding() instanceof ActivityChatRoomBinding)) {
            return;
        }
        ((ActivityChatRoomBinding) getBinding()).f9644a.setText(String.format("%d人在线", Integer.valueOf(i)));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(Bundle bundle) {
        g0(getIntent());
        if (getBinding() == null || !(getBinding() instanceof ActivityChatRoomBinding)) {
            return;
        }
        ActivityChatRoomBinding activityChatRoomBinding = (ActivityChatRoomBinding) getBinding();
        activityChatRoomBinding.f9641a.setText(this.y);
        if (TextUtils.isEmpty(this.z)) {
            activityChatRoomBinding.f9642a.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) activityChatRoomBinding.f9640a.getLayoutParams();
            layoutParams.removeRule(17);
            layoutParams.addRule(13);
            activityChatRoomBinding.f9640a.setLayoutParams(layoutParams);
        } else {
            activityChatRoomBinding.f9642a.setVisibility(0);
            activityChatRoomBinding.f9642a.loadAvatar(this.z);
        }
        activityChatRoomBinding.f9639a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ej1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41446a.h0(view);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(R.id.flContainer, ChatRoomFragment.newInstance(this.x, this.K), SingleChatFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }
}
