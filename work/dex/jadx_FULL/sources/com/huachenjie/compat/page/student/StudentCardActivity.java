package com.huachenjie.compat.page.student;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.base.aliyun.detect_face.DetectFaceFragment;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.zj.adlib.dq1;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(extras = 1, path = RoutePathConstants.Compat.f)
public class StudentCardActivity extends BaseVmActivity<StudentCardVM> {

    public class a implements Observer<UserFaceBean> {
        public a() {
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UserFaceBean userFaceBean) {
            if (userFaceBean == null) {
                return;
            }
            if (userFaceBean.getFaceEnabled() != 1) {
                fv5.b("您已关闭人脸识别功能，本学期暂不支持上传照片");
            } else if (userFaceBean.getFaceAuth()) {
                UserFaceActivity.c0(StudentCardActivity.this, userFaceBean);
            } else {
                com.huachenjie.base.aliyun.detect_face.a.a(userFaceBean).show(StudentCardActivity.this.getSupportFragmentManager(), DetectFaceFragment.class.getSimpleName());
            }
        }
    }

    public class b {
        public b() {
        }

        public void a(View view) {
            ((StudentCardVM) ((BaseVmActivity) StudentCardActivity.this).f8507a).j();
        }

        public void b(View view) {
            Object objNavigation = ARouter.getInstance().build(RoutePathConstants.Sport.c).navigation();
            if (objNavigation instanceof DialogFragment) {
                ((DialogFragment) objNavigation).show(StudentCardActivity.this.getSupportFragmentManager(), "MINE_QR_CODE");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_student_card), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new b());
    }

    public final void h0() {
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((StudentCardVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setTitleName("学生卡").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackTintColor(-16777216).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ct8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41041a.i0(view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        h0();
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).n.setValue(new StudentCourseAdapter());
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).l.setValue(Boolean.valueOf(dq1.e().getFaceEnable()));
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).k();
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).i();
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).h();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((StudentCardVM) ((BaseVmActivity) this).f8507a).m.observe(this, new a());
    }
}
