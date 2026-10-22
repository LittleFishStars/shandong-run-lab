package com.huachenjie.compat.page.personal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.compat.R;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.p)
public class PhoneModifyActivity extends BaseActivity implements IConfirmPhoneCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConfirmNewPhoneFragment f34157a;

    public class a extends DialogUtil.PositiveNegativeClickListener {
        public a() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            PhoneModifyActivity.super.onBackPressed();
        }
    }

    public class b implements DialogUtil.SingleClickListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
        public void onClicked() {
            PhoneModifyActivity.this.setResult(-1);
            PhoneModifyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        this.f34157a.submit();
    }

    @Override // com.huachenjie.compat.page.personal.IConfirmPhoneCallback
    public void E() {
        setTitle(((BaseActivity) this).c.getString(R.string.modify_phone));
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_confirm_container, this.f34157a).commitNowAllowingStateLoss();
        g0("完成", zn1.a(R.color.white), new View.OnClickListener() { // from class: com.zj.adlib.cq6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41024a.m0(view);
            }
        });
    }

    @Override // com.huachenjie.compat.page.personal.IConfirmPhoneCallback
    public void K() {
        Activity activity = ((BaseActivity) this).c;
        DialogUtil.I(activity, activity.getString(R.string.submit_succeed), ((BaseActivity) this).c.getString(R.string.modify_phone_success), ((BaseActivity) this).c.getString(R.string.ok), false, new b());
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public CharSequence X() {
        return ((BaseActivity) this).c.getString(R.string.confirm_phone);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int Y() {
        return R.color.color_main_v2;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int a0() {
        return R.color.white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.color_main_v2;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.activity_modify_phone;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f34157a = ConfirmNewPhoneFragment.newInstance(this, getIntent().getIntExtra("count", 0));
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        E();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Activity activity = ((BaseActivity) this).c;
        DialogUtil.z(activity, "", activity.getString(R.string.confirm_to_cancel_modify_phone), ((BaseActivity) this).c.getString(R.string.cancel), ((BaseActivity) this).c.getString(R.string.ok), new a());
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
