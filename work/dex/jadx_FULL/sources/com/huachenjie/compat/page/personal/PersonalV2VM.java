package com.huachenjie.compat.page.personal;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.compat.bean.ClazzBean;
import com.huachenjie.compat.bean.DepartmentClassBean;
import com.huachenjie.compat.bean.PersonalInfo;
import com.huachenjie.compat.bean.SubSchoolBean;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class PersonalV2VM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rq1 f34148a = new rq1();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<PersonalInfo> j = new MutableLiveData<>();
    public MutableLiveData<Boolean> k;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<List<DepartmentClassBean>> m;
    public MutableLiveData<String> n;
    public MutableLiveData<List<SubSchoolBean>> o;
    public MutableLiveData<List<String>> p;

    public class a extends DialogVMSubscriber<List<DepartmentClassBean>> {
        public a(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onFinish() {
            super.onFinish();
            PersonalV2VM.this.k.setValue(Boolean.FALSE);
        }

        public void onCCSuccess(List<DepartmentClassBean> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            PersonalV2VM.this.m.setValue(list);
        }
    }

    public class b extends DialogVMSubscriber<PageEntity<SubSchoolBean>> {
        public b(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onFinish() {
            super.onFinish();
            PersonalV2VM.this.k.setValue(Boolean.FALSE);
        }

        public void onCCSuccess(PageEntity<SubSchoolBean> pageEntity) {
            if (pageEntity == null || pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
                return;
            }
            PersonalV2VM.this.o.setValue(pageEntity.getList());
        }
    }

    public class c extends DialogVMSubscriber<Object> {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HttpVmDialog httpVmDialog, boolean z, String str, String str2) {
            super(httpVmDialog, z);
            this.f = str;
            this.g = str2;
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            PersonalInfo value = PersonalV2VM.this.j.getValue();
            value.getSchoolInfo().setDepartmentName(this.f);
            value.getSchoolInfo().setClassName(this.g);
            PersonalV2VM.this.j.setValue(value);
        }
    }

    public class d extends DialogVMSubscriber<Object> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            PersonalInfo value = PersonalV2VM.this.j.getValue();
            value.setNation(this.f);
            PersonalV2VM.this.j.setValue(value);
        }
    }

    public class e extends DialogVMSubscriber<Object> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            PersonalInfo value = PersonalV2VM.this.j.getValue();
            value.getSchoolInfo().setSubSchoolName(this.f);
            PersonalV2VM.this.j.setValue(value);
        }
    }

    public class f extends DialogVMSubscriber<Object> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            PersonalInfo value = PersonalV2VM.this.j.getValue();
            value.setBirthday(this.f);
            PersonalV2VM.this.j.setValue(value);
        }
    }

    public class g extends DialogVMSubscriber<PersonalInfo> {
        public g(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(PersonalInfo personalInfo) {
            if (personalInfo == null) {
                return;
            }
            PersonalV2VM.this.j.setValue(personalInfo);
        }
    }

    public class h extends DialogVMSubscriber<PageEntity<String>> {
        public h(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onFinish() {
            super.onFinish();
            PersonalV2VM.this.k.setValue(Boolean.FALSE);
        }

        public void onCCSuccess(PageEntity<String> pageEntity) {
            if (pageEntity == null || pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
                return;
            }
            PersonalV2VM.this.p.setValue(pageEntity.getList());
        }
    }

    public PersonalV2VM() {
        Boolean bool = Boolean.FALSE;
        this.k = new MutableLiveData<>(bool);
        this.l = new MutableLiveData<>(bool);
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new MutableLiveData<>();
    }

    public void h() {
        Boolean bool = Boolean.TRUE;
        if (bool.equals(this.k.getValue())) {
            return;
        }
        this.k.setValue(bool);
        n76.e(this, this.f34148a.f()).p5(new h(this, true));
    }

    public void i() {
        n76.e(this, this.f34148a.h()).p5(new g(this, true));
    }

    public void j() {
        Boolean bool = Boolean.TRUE;
        if (bool.equals(this.k.getValue()) || this.j.getValue() == null) {
            return;
        }
        this.k.setValue(bool);
        n76.e(this, this.f34148a.j(this.j.getValue().getSchoolInfo().getSchoolCode())).p5(new a(this, true));
    }

    public void k() {
        Boolean bool = Boolean.TRUE;
        if (bool.equals(this.k.getValue())) {
            return;
        }
        this.k.setValue(bool);
        n76.e(this, this.f34148a.i()).p5(new b(this, true));
    }

    public void l(String str, String str2) {
        String classCode;
        String str3;
        String str4;
        DepartmentClassBean next;
        if (this.j.getValue() == null || this.m.getValue() == null) {
            return;
        }
        Iterator<DepartmentClassBean> it = this.m.getValue().iterator();
        do {
            classCode = "";
            if (it.hasNext()) {
                next = it.next();
            } else {
                str3 = "";
                str4 = str3;
            }
            n76.e(this, this.f34148a.o(str3, str4, null, null, null, null)).p5(new c(this, true, str, str2));
        } while (!str.equals(next.getDepartmentName()));
        String departmentCode = next.getDepartmentCode();
        if (next.getClassList() != null && next.getClassList().size() > 0) {
            for (ClazzBean clazzBean : next.getClassList()) {
                if (str2.equals(clazzBean.getClassName())) {
                    classCode = clazzBean.getClassCode();
                    break;
                }
            }
        }
        str3 = departmentCode;
        str4 = classCode;
        n76.e(this, this.f34148a.o(str3, str4, null, null, null, null)).p5(new c(this, true, str, str2));
    }

    public void m(String str) {
        if (this.j.getValue() == null) {
            return;
        }
        n76.e(this, this.f34148a.o(null, null, null, null, null, str)).p5(new f(this, true, str));
    }

    public void n(String str) {
        MutableLiveData<List<SubSchoolBean>> mutableLiveData;
        String subSchoolCode;
        if (this.j.getValue() == null || (mutableLiveData = this.o) == null || mutableLiveData.getValue() == null) {
            return;
        }
        for (SubSchoolBean subSchoolBean : this.o.getValue()) {
            if (str.equals(subSchoolBean.getSubSchoolName())) {
                subSchoolCode = subSchoolBean.getSubSchoolCode();
                n76.e(this, this.f34148a.o(null, null, subSchoolCode, null, null, null)).p5(new e(this, true, str));
            }
        }
        subSchoolCode = "";
        n76.e(this, this.f34148a.o(null, null, subSchoolCode, null, null, null)).p5(new e(this, true, str));
    }

    public void o(String str) {
        MutableLiveData<List<String>> mutableLiveData;
        if (this.j.getValue() == null || (mutableLiveData = this.p) == null || mutableLiveData.getValue() == null) {
            return;
        }
        n76.e(this, this.f34148a.o(null, null, null, null, str, null)).p5(new d(this, true, str));
    }
}
