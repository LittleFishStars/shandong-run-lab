package com.huachenjie.compat.page.login.vm;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.compat.bean.StudentInfo;
import com.zj.adlib.fv5;
import com.zj.adlib.k25;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class AuthorizeVM extends BaseVM {
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<SchoolInfo> j = new MutableLiveData<>(null);
    public MutableLiveData<String> k = new MutableLiveData<>("");
    public MutableLiveData<StudentInfo> l = new MutableLiveData<>(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k25 f34119a = new k25();

    public class a extends DialogVMSubscriber<StudentInfo> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            int i = baseEntity.code;
            if (i == 2005) {
                return true;
            }
            if (i != 2007) {
                if (i != 2008) {
                    return super/*huachenjie.sdk.http.subscriber.BizSubscriber*/.onBizError(baseEntity);
                }
                fv5.b("学号已被认证");
                return true;
            }
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentStatus(2);
            studentInfo.setSchoolInfo(AuthorizeVM.this.j.getValue());
            studentInfo.setStudentNumber(this.f.trim());
            AuthorizeVM.this.l.setValue(studentInfo);
            return true;
        }

        public void onCCSuccess(StudentInfo studentInfo) {
            if (studentInfo == null) {
                return;
            }
            studentInfo.setStudentStatus(1);
            studentInfo.setSchoolInfo(AuthorizeVM.this.j.getValue());
            studentInfo.setStudentNumber(this.f.trim());
            AuthorizeVM.this.l.setValue(studentInfo);
        }
    }

    public void h() {
        SchoolInfo value = this.j.getValue();
        String value2 = this.k.getValue();
        if (value == null || value2 == null || TextUtils.isEmpty(value2)) {
            return;
        }
        n76.d(this.f34119a.f(value.getSchoolCode(), value2.trim(), 1)).c(this).p5(new a(this, true, value2));
    }
}
