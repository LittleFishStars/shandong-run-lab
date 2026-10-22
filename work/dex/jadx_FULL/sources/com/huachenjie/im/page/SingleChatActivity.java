package com.huachenjie.im.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.zj.adlib.ai9;
import com.zj.adlib.dj1;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Route(path = RoutePathConstants.IM.b)
public class SingleChatActivity extends BaseVmActivity<BaseTitleVM> {
    public String x = "";
    public int K = 0;
    public String y = "SingleChatFragment";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.white;
        eVarP3.G2(i).T2(true).u1(i).G1(true).q1(true).a1();
    }

    public final void g0(Intent intent) {
        this.x = intent.getStringExtra(UserConstants.CHAT_PARAMS.f33725a);
        this.K = intent.getIntExtra(UserConstants.CHAT_PARAMS.b, 0);
        CommonUserInfo commonUserInfoE = ai9.e();
        dj1.I(commonUserInfoE.getAvatar(), commonUserInfoE.getAvatarFrameImgUrl(), this.K);
        h0();
        j0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_chat), Integer.valueOf(yk0.L), ((BaseVmActivity) this).f8507a);
    }

    public final void h0() {
        ((BaseTitleVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((BaseTitleVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setBackIconResId(R.mipmap.ic_message_back).setTitleName("").setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ih8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f42358a.i0(view);
            }
        }).setTitleTextColor(zn1.a(R.color.color_2C3E50)));
        View viewFindViewById = findViewById(R.id.ivReport);
        if (viewFindViewById != null) {
            if (this.K == 4) {
                viewFindViewById.setVisibility(8);
            } else {
                viewFindViewById.setVisibility(0);
            }
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(Bundle bundle) {
        g0(getIntent());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        SingleChatFragment singleChatFragment = new SingleChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(UserConstants.CHAT_PARAMS.f33725a, this.x);
        bundle.putInt(UserConstants.CHAT_PARAMS.b, this.K);
        singleChatFragment.setArguments(bundle);
        fragmentTransactionBeginTransaction.add(R.id.flContainer, singleChatFragment, this.y);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    public void k0() {
        BindingTitleBean value;
        String strS = dj1.s(this.x);
        if (TextUtils.isEmpty(strS) || (value = ((BaseTitleVM) ((BaseVmActivity) this).f8507a).i.getValue()) == null) {
            return;
        }
        value.setTitleName(strS);
        ((BaseTitleVM) ((BaseVmActivity) this).f8507a).i.setValue(value);
    }

    public void startReportUser(View view) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.y);
        if (fragmentFindFragmentByTag != null && (fragmentFindFragmentByTag instanceof SingleChatFragment)) {
            ((SingleChatFragment) fragmentFindFragmentByTag).startReportUser(view);
        }
    }

    public void updateTitle(String str) {
        BindingTitleBean value;
        Q q = ((BaseVmActivity) this).f8507a;
        if (q == 0 || (value = ((BaseTitleVM) q).i.getValue()) == null) {
            return;
        }
        value.setTitleName(str);
        ((BaseTitleVM) ((BaseVmActivity) this).f8507a).i.setValue(value);
    }
}
