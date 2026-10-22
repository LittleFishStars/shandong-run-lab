package com.huachenjie.compat.page.login.vm;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.compat.bean.KeyNameInfo;
import com.huachenjie.compat.bean.StudentInfo;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.k25;
import com.zj.adlib.n76;
import com.zj.adlib.u66;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class AuthorizeVerifyVM extends BaseVM {
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<StudentInfo> j = new MutableLiveData<>(null);
    public MutableLiveData<Boolean> k = new MutableLiveData<>(Boolean.FALSE);
    public MutableLiveData<List<KeyNameInfo>> l = new MutableLiveData<>();
    public MutableLiveData<String> m = new MutableLiveData<>();
    public MutableLiveData<String> n = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k25 f9237a = new k25();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseModel f34121a = new BaseModel();

    public class a extends DialogVMSubscriber<StudentInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SchoolInfo f34122a;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpVmDialog httpVmDialog, boolean z, SchoolInfo schoolInfo, String str) {
            super(httpVmDialog, z);
            this.f34122a = schoolInfo;
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
            studentInfo.setSchoolInfo(this.f34122a);
            studentInfo.setStudentNumber(this.f);
            AuthorizeVerifyVM.this.j.setValue(studentInfo);
            return true;
        }

        public void onCCSuccess(StudentInfo studentInfo) {
            if (studentInfo == null) {
                return;
            }
            studentInfo.setStudentStatus(1);
            studentInfo.setSchoolInfo(this.f34122a);
            studentInfo.setStudentNumber(this.f);
            AuthorizeVerifyVM.this.j.setValue(studentInfo);
        }
    }

    public class b extends DialogVMSubscriber<StudentInfo> {
        public b(HttpVmDialog httpVmDialog, boolean z, boolean z2) {
            super(httpVmDialog, z, z2);
        }

        public void onCCSuccess(StudentInfo studentInfo) {
            AuthorizeVerifyVM.this.p("学生卡认证成功");
        }
    }

    public class c extends DialogVMSubscriber<StudentInfo> {
        public c(HttpVmDialog httpVmDialog, boolean z, boolean z2) {
            super(httpVmDialog, z, z2);
        }

        public void onCCSuccess(StudentInfo studentInfo) {
            AuthorizeVerifyVM.this.p("信息提交成功");
        }
    }

    public class d extends DialogVMSubscriber<List<KeyNameInfo>> {
        public d(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(List<KeyNameInfo> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            AuthorizeVerifyVM.this.l.setValue(list);
        }
    }

    public class e extends BizSubscriber<CommonUserInfo> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z, String str) {
            super(z);
            this.f = str;
        }

        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onCCSuccess(CommonUserInfo commonUserInfo) {
            if (commonUserInfo != null) {
                commonUserInfo.setToken(ai9.e().getToken());
                commonUserInfo.setSatoken(ai9.e().getSatoken());
                ai9.s(commonUserInfo);
                com.huachenjie.base.app_widget.a.c();
            }
            AuthorizeVerifyVM.this.k(this.f);
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            AuthorizeVerifyVM.this.k(this.f);
        }
    }

    public class f implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f34127a;

        public f(int i) {
            this.f34127a = i;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int i, String str) {
            AuthorizeVerifyVM.this.d.setValue(Boolean.FALSE);
            fv5.b("图片上传失败");
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(String str) {
            AuthorizeVerifyVM.this.d.setValue(Boolean.FALSE);
            int i = this.f34127a;
            if (i == 1) {
                AuthorizeVerifyVM.this.m.setValue(str);
            } else if (i == 2) {
                AuthorizeVerifyVM.this.n.setValue(str);
            }
        }
    }

    public void j() {
        if (this.j.getValue() == null || this.j.getValue().getSchoolInfo() == null || TextUtils.isEmpty(this.j.getValue().getSchoolInfo().getSchoolCode()) || TextUtils.isEmpty(this.j.getValue().getStudentNumber()) || TextUtils.isEmpty(this.j.getValue().getUserName()) || TextUtils.isEmpty(this.j.getValue().getSubSchoolCode()) || TextUtils.isEmpty(this.j.getValue().getDepartmentCode()) || TextUtils.isEmpty(this.j.getValue().getClassCode())) {
            return;
        }
        n76.e(this, this.f9237a.a(this.j.getValue().getSchoolInfo().getSchoolCode(), this.j.getValue().getUserName(), this.j.getValue().getStudentNumber(), this.j.getValue().getSubSchoolCode(), this.j.getValue().getDepartmentCode(), this.j.getValue().getClassCode())).p5(new b(this, true, true));
    }

    public final void k(String str) {
        a();
        fv5.b(str);
        this.i.setValue(this.i.getValue().setBackShow(false));
        this.k.setValue(Boolean.TRUE);
    }

    public void l() {
        if (this.j.getValue() == null || this.j.getValue().getSchoolInfo() == null || TextUtils.isEmpty(this.j.getValue().getSchoolInfo().getSchoolCode()) || TextUtils.isEmpty(this.j.getValue().getStudentNumber()) || TextUtils.isEmpty(this.j.getValue().getUserName()) || TextUtils.isEmpty(this.j.getValue().getGradeCode()) || this.j.getValue().getSex() == 0) {
            return;
        }
        n76.e(this, this.f9237a.b(this.j.getValue().getSchoolInfo().getSchoolCode(), this.j.getValue().getUserName(), this.j.getValue().getStudentNumber(), this.j.getValue().getSex(), this.j.getValue().getGradeCode(), this.m.getValue() != null ? this.m.getValue() : "", this.n.getValue() != null ? this.n.getValue() : "")).p5(new c(this, true, true));
    }

    public void m() {
        if (this.j.getValue() == null) {
            return;
        }
        if (this.j.getValue().getStudentStatus() == 1) {
            j();
        } else if (this.j.getValue().getStudentStatus() == 2) {
            l();
        }
    }

    public void n() {
        n76.e(this, this.f9237a.c()).p5(new d(this, true));
    }

    public void o(SchoolInfo schoolInfo, String str) {
        n76.d(this.f9237a.f(schoolInfo.getSchoolCode(), str, 1)).c(this).p5(new a(this, true, schoolInfo, str));
    }

    public final void p(String str) {
        n76.e(this, this.f34121a.g()).p5(new e(false, str));
    }

    public void q(Context context, String str, int i) {
        if (!new File(str).exists()) {
            fv5.b("图片不存在");
        } else {
            this.d.setValue(Boolean.TRUE);
            u66.d(context, UploadFileType.UPLOAD_VISITOR, str, new f(i));
        }
    }
}
