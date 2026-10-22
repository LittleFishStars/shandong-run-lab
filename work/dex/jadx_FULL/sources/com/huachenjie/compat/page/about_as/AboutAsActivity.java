package com.huachenjie.compat.page.about_as;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.zj.adlib.i62;
import com.zj.adlib.uy6;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.j)
public class AboutAsActivity extends BaseVmActivity<AboutAsVM> {

    public class a {
        public a() {
        }

        public void a(View view) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "").withString("url", uy6.b).navigation();
        }

        public void b(View view) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "").withString("url", "https://beian.miit.gov.cn/#/home").navigation();
        }

        public void c(View view) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "").withString("url", uy6.c).navigation();
        }

        public void d(View view) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "").withString("url", uy6.f45250a).navigation();
        }

        public void e(View view) {
            ((AboutAsVM) ((BaseVmActivity) AboutAsActivity.this).f8507a).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_about_as), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
    }

    public final void h0() {
        BindingTitleBean titleName = new BindingTitleBean().setStatusBarHeight(((BaseVM) ((AboutAsVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setBackground(zn1.a(R.color.white)).setTitleName("关于我们");
        int i = R.color.color_2C3E50;
        ((AboutAsVM) ((BaseVmActivity) this).f8507a).i.setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40819a.i0(view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        h0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
