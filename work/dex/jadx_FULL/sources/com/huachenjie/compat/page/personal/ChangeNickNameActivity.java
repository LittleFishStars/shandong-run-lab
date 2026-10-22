package com.huachenjie.compat.page.personal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.compat.R;
import com.zj.adlib.ai9;
import com.zj.adlib.ft1;
import com.zj.adlib.i62;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.i)
public class ChangeNickNameActivity extends BaseVmActivity<ChangeNickNameVM> {

    @Autowired(name = UserConstants.USER_PARAMS.f33739a)
    public int K = 0;

    @Autowired(name = UserConstants.USER_PARAMS.b)
    public String x = "";

    @Autowired(name = UserConstants.USER_PARAMS.c)
    public String y = "";

    public class a implements Observer<Boolean> {
        public a() {
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                Intent intent = new Intent();
                if (((ChangeNickNameVM) ((BaseVmActivity) ChangeNickNameActivity.this).f8507a).j.getValue() != null) {
                    intent.putExtra(UserConstants.USER_PARAMS.b, ((ChangeNickNameVM) ((BaseVmActivity) ChangeNickNameActivity.this).f8507a).j.getValue().trim());
                    ChangeNickNameActivity.this.setResult(-1, intent);
                }
                ChangeNickNameActivity.this.finish();
            }
        }
    }

    public class b {
        public b() {
        }

        public void a(View view) {
            ((ChangeNickNameVM) ((BaseVmActivity) ChangeNickNameActivity.this).f8507a).j.setValue("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        if (this.K == 0) {
            finish();
        } else if (TextUtils.equals(this.x, ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).j.getValue())) {
            finish();
        } else {
            ft1.p(this, "您修改的好友昵称还未保存，确认退出吗？", new View.OnClickListener() { // from class: com.zj.adlib.ph1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f43980a.m0(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        if (this.K == 0) {
            ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).k();
        } else {
            ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).j(this.x, this.y);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(false).u1(i).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_change_nick_name), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new b());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        l0();
        if (this.K != 0) {
            ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).j.setValue(this.x);
            return;
        }
        CommonUserInfo commonUserInfoE = ai9.e();
        if (commonUserInfoE != null) {
            ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).j.setValue(commonUserInfoE.getNickName());
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).k.observe(this, new a());
    }

    public final void l0() {
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(this.K == 0 ? "输入昵称" : "设置好友备注");
        int i = R.color.white;
        BindingTitleBean rightTextClick = titleName.setTitleTextColor(zn1.a(i)).setBackground(zn1.a(R.color.color_main_v2)).setStatusBarHeight(((BaseVM) ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setRightButtonText("完成").setShowRightText(true).setBackIconResId(R.drawable.ic_back_white).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.nh1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43522a.n0(view);
            }
        }).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.oh1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43745a.o0(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_right_text);
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
        ((ChangeNickNameVM) ((BaseVmActivity) this).f8507a).i.setValue(rightTextClick);
    }
}
