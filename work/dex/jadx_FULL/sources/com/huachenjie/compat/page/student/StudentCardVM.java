package com.huachenjie.compat.page.student;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.compat.bean.MyCourseInfo;
import com.huachenjie.compat.bean.StudentCard;
import com.zj.adlib.ai9;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class StudentCardVM extends BaseVM {
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<CommonUserInfo> j = new MutableLiveData<>();
    public MutableLiveData<StudentCard> k = new MutableLiveData<>();
    public MutableLiveData<Boolean> l = new MutableLiveData<>(Boolean.FALSE);
    public MutableLiveData<UserFaceBean> m = new MutableLiveData<>();
    public MutableLiveData<StudentCourseAdapter> n = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rq1 f34174a = new rq1();

    public class a extends BizSubscriber<StudentCard> {
        public a(boolean z) {
            super(z);
        }

        public void onCCSuccess(StudentCard studentCard) {
            if (studentCard == null) {
                return;
            }
            StudentCardVM.this.k.setValue(studentCard);
        }
    }

    public class b extends BizSubscriber<MyCourseInfo> {
        public b(boolean z) {
            super(z);
        }

        public void onCCSuccess(MyCourseInfo myCourseInfo) {
            if (myCourseInfo == null || myCourseInfo.getList().isEmpty() || StudentCardVM.this.n.getValue() == null) {
                return;
            }
            StudentCardVM.this.n.getValue().setList(myCourseInfo.getList());
        }
    }

    public class c extends DialogVMSubscriber<UserFaceBean> {
        public c(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(UserFaceBean userFaceBean) {
            StudentCardVM.this.m.setValue(userFaceBean);
        }
    }

    public void h() {
        n76.e(this, this.f34174a.c()).p5(new b(true));
    }

    public void i() {
        n76.e(this, this.f34174a.k()).p5(new a(true));
    }

    public void j() {
        n76.e(this, this.f34174a.l()).p5(new c(this, true));
    }

    public void k() {
        this.j.setValue(ai9.e());
    }
}
