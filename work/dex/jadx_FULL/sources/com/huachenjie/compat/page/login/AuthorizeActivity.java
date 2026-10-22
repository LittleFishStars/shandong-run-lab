package com.huachenjie.compat.page.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.StudentInfo;
import com.huachenjie.compat.page.login.AuthorizeActivity;
import com.huachenjie.compat.page.login.vm.AuthorizeVM;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.m25;
import com.zj.adlib.wk0;
import com.zj.adlib.ys8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.c)
public class AuthorizeActivity extends BaseVmActivity<AuthorizeVM> {
    public static final int K = 1001;

    public class a {
        public a() {
        }

        public void a(View view) {
            ARouter.getInstance().build(RoutePathConstants.Compat.e).navigation(((BaseVmActivity) AuthorizeActivity.this).c, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        n0();
    }

    public static /* synthetic */ void m0(StudentInfo studentInfo) {
        if (studentInfo == null) {
            return;
        }
        ARouter.getInstance().build(RoutePathConstants.Compat.d).withParcelable(UserConstants.LOGIN_PARAMS.c, studentInfo.getSchoolInfo()).withString(UserConstants.LOGIN_PARAMS.d, studentInfo.getStudentNumber()).navigation();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(false).u1(i).G1(false).g0(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_authorize), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        j0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((AuthorizeVM) ((BaseVmActivity) this).f8507a).l.observe(this, new Observer() { // from class: com.zj.adlib.hh0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorizeActivity.m0((StudentInfo) obj);
            }
        });
    }

    public final void j0() {
        ((AuthorizeVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((AuthorizeVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setBackShow(true).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.fh0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41672a.k0(view);
            }
        }).setTitleName(ys8.e(R.string.auth_title_v2)).setShowRightText(true).setRightButtonText("下一步").setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.gh0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41904a.l0(view);
            }
        }));
    }

    public final void n0() {
        if (ai9.n()) {
            m25.b(this);
        }
        finish();
    }

    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final void l0(View view) {
        Q q = ((BaseVmActivity) this).f8507a;
        if (q == 0) {
            return;
        }
        if (((AuthorizeVM) q).j == null) {
            fv5.b("请先选择学校");
        } else if (((AuthorizeVM) q).k == null || TextUtils.isEmpty(((AuthorizeVM) q).k.getValue())) {
            fv5.b("请输入学号");
        } else {
            ((AuthorizeVM) ((BaseVmActivity) this).f8507a).h();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2 && i == 1001) {
            ((AuthorizeVM) ((BaseVmActivity) this).f8507a).j.setValue((SchoolInfo) intent.getParcelableExtra("selectedSchool"));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        n0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        n0();
        return true;
    }
}
