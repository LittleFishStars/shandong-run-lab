package com.huachenjie.compat.page.login;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.KeyNameInfo;
import com.huachenjie.compat.bean.StudentInfo;
import com.huachenjie.compat.databinding.ActivityAuthorizeVerifyBinding;
import com.huachenjie.compat.page.login.vm.AuthorizeVerifyVM;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.pd6;
import com.zj.adlib.rd6;
import com.zj.adlib.t14;
import com.zj.adlib.wk0;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.d)
public class AuthorizeVerifyActivity extends BaseVmActivity<AuthorizeVerifyVM> {
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Autowired(name = UserConstants.LOGIN_PARAMS.c)
    public SchoolInfo f9223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPickerLauncher f9224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rd6 f9225a;

    @Autowired(name = UserConstants.LOGIN_PARAMS.d)
    public String x;
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnOptionsSelectListener f9222a = new OnOptionsSelectListener() { // from class: com.zj.adlib.oh0
        @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
        public final void a(int i, int i2, int i3, View view) {
            this.f43744a.X0(i, i2, i3, view);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f34104a = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AuthorizeVerifyActivity.this.f9225a != null) {
                AuthorizeVerifyActivity.this.f9225a.onClick(view);
            }
        }
    }

    public class b implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f34106a = "submit";
        public static final String b = "cancel";

        public b() {
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(View view) {
            Button button = (Button) view.findViewById(R.id.btnSubmit);
            Button button2 = (Button) view.findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(AuthorizeVerifyActivity.this.f34104a);
            button2.setOnClickListener(AuthorizeVerifyActivity.this.f34104a);
        }
    }

    public class c {
        public c() {
        }

        public void a(View view) {
            ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).m.setValue("");
        }

        public void b(View view) {
            ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).n.setValue("");
        }

        public void c(View view) {
            ArrayList<KeyNameInfo> classInfoList;
            if (((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getStudentStatus() == 2 || (classInfoList = ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getClassInfoList()) == null || classInfoList.size() == 0) {
                return;
            }
            String departmentName = !TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getDepartmentName()) ? ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getDepartmentName() : "";
            String className = !TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getClassName()) ? ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getClassName() : "";
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < classInfoList.size(); i3++) {
                KeyNameInfo keyNameInfo = classInfoList.get(i3);
                arrayList.add(keyNameInfo.getName());
                if (departmentName.equals(keyNameInfo.getName())) {
                    i = i3;
                }
                ArrayList arrayList3 = new ArrayList();
                if (keyNameInfo.getChildren() != null && keyNameInfo.getChildren().size() > 0) {
                    for (int i4 = 0; i4 < keyNameInfo.getChildren().size(); i4++) {
                        KeyNameInfo keyNameInfo2 = keyNameInfo.getChildren().get(i4);
                        arrayList3.add(keyNameInfo2.getName());
                        if (className.equals(keyNameInfo2.getName())) {
                            i2 = i4;
                        }
                    }
                }
                if (arrayList3.isEmpty()) {
                    arrayList3.add("");
                }
                arrayList2.add(arrayList3);
            }
            AuthorizeVerifyActivity.this.K = 3;
            AuthorizeVerifyActivity.this.O0().G(0, 0);
            AuthorizeVerifyActivity.this.O0().D(arrayList, arrayList2);
            AuthorizeVerifyActivity.this.O0().G(i, i2);
            AuthorizeVerifyActivity.this.O0().t();
        }

        public void d(View view) {
            if (((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getStudentStatus() == 1) {
                return;
            }
            ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).n();
        }

        public void e(View view) {
            ArrayList<KeyNameInfo> subSchoolList;
            if (((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getStudentStatus() == 2 || (subSchoolList = ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getSubSchoolList()) == null || subSchoolList.size() == 0) {
                return;
            }
            String subSchoolName = !TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getSubSchoolName()) ? ((AuthorizeVerifyVM) ((BaseVmActivity) AuthorizeVerifyActivity.this).f8507a).j.getValue().getSubSchoolName() : "";
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < subSchoolList.size(); i2++) {
                KeyNameInfo keyNameInfo = subSchoolList.get(i2);
                arrayList.add(keyNameInfo.getName());
                if (subSchoolName.equals(keyNameInfo.getName())) {
                    i = i2;
                }
            }
            AuthorizeVerifyActivity.this.K = 2;
            AuthorizeVerifyActivity.this.O0().F(0);
            AuthorizeVerifyActivity.this.O0().C(arrayList);
            AuthorizeVerifyActivity.this.O0().F(i);
            AuthorizeVerifyActivity.this.O0().t();
        }

        public void f(View view) {
            AuthorizeVerifyActivity.this.Y0(1);
        }

        public void g(View view) {
            AuthorizeVerifyActivity.this.Y0(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(RadioGroup radioGroup, int i) {
        if (i == R.id.authorize_sex_man) {
            StudentInfo value = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue();
            if (value != null) {
                value.setSex(2);
            }
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.setValue(value);
            return;
        }
        if (i == R.id.authorize_sex_woman) {
            StudentInfo value2 = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue();
            if (value2 != null) {
                value2.setSex(1);
            }
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.setValue(value2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(MediaPickerResult mediaPickerResult) {
        if (!(mediaPickerResult instanceof MediaPickerResult.Success)) {
            if (mediaPickerResult instanceof MediaPickerResult.Error) {
                fv5.b(((MediaPickerResult.Error) mediaPickerResult).f());
            }
        } else {
            List<String> listG = ((MediaPickerResult.Success) mediaPickerResult).g();
            if (listG == null || listG.isEmpty()) {
                return;
            }
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).q(this, listG.get(0), this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(View view) {
        if (M0()) {
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        t14.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.K = 1;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((KeyNameInfo) it.next()).getName());
        }
        O0().C(arrayList);
        O0().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(int i, int i2, int i3, View view) {
        KeyNameInfo keyNameInfo;
        KeyNameInfo keyNameInfo2;
        KeyNameInfo keyNameInfo3;
        KeyNameInfo keyNameInfo4;
        Q q = ((BaseVmActivity) this).f8507a;
        if (q == 0 || ((AuthorizeVerifyVM) q).j.getValue() == null) {
            return;
        }
        int i4 = this.K;
        if (i4 == 1) {
            if (((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).l.getValue() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).l.getValue().size() <= i || (keyNameInfo4 = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).l.getValue().get(i)) == null) {
                return;
            }
            String name = keyNameInfo4.getName();
            String key = keyNameInfo4.getKey();
            StudentInfo value = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue();
            value.setGradeName(name);
            value.setGradeCode(key);
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.setValue(value);
            return;
        }
        if (i4 == 2) {
            if (((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSubSchoolList() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSubSchoolList().size() <= i || (keyNameInfo3 = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSubSchoolList().get(i)) == null) {
                return;
            }
            String name2 = keyNameInfo3.getName();
            String key2 = keyNameInfo3.getKey();
            StudentInfo value2 = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue();
            value2.setSubSchoolName(name2);
            value2.setSubSchoolCode(key2);
            ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.setValue(value2);
            return;
        }
        if (i4 != 3 || ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getClassInfoList() == null || ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getClassInfoList().size() <= i || (keyNameInfo = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getClassInfoList().get(i)) == null) {
            return;
        }
        String name3 = keyNameInfo.getName();
        String key3 = keyNameInfo.getKey();
        StudentInfo value3 = ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue();
        value3.setDepartmentName(name3);
        value3.setDepartmentCode(key3);
        if (keyNameInfo.getChildren() != null && keyNameInfo.getChildren().size() > i2 && (keyNameInfo2 = keyNameInfo.getChildren().get(i2)) != null) {
            value3.setClassName(keyNameInfo2.getName());
            value3.setClassCode(keyNameInfo2.getKey());
        }
        ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.setValue(value3);
    }

    public final boolean L0() {
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSchoolInfo().getSchoolCode())) {
            fv5.b("学校信息异常");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getStudentNumber())) {
            fv5.b("学号数据异常");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getUserName())) {
            fv5.b("学生姓名异常");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSubSchoolCode())) {
            fv5.b("请选择正确的学区");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getDepartmentCode())) {
            fv5.b("请选择正确的院系");
            return false;
        }
        if (!TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getClassCode())) {
            return true;
        }
        fv5.b("请选择正确的班级");
        return false;
    }

    public final boolean M0() {
        Q q = ((BaseVmActivity) this).f8507a;
        if (q == 0 || ((AuthorizeVerifyVM) q).j.getValue() == null) {
            return false;
        }
        if (((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getStudentStatus() == 1) {
            return L0();
        }
        if (((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getStudentStatus() == 2) {
            return N0();
        }
        return true;
    }

    public final boolean N0() {
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSchoolInfo().getSchoolCode())) {
            fv5.b("学校信息异常");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getStudentNumber())) {
            fv5.b("学号数据异常");
            return false;
        }
        if (TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getUserName())) {
            fv5.b("请输入姓名");
            return false;
        }
        if (((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getSex() == 0) {
            fv5.b("请选择性别");
            return false;
        }
        if (!TextUtils.isEmpty(((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).j.getValue().getGradeCode())) {
            return true;
        }
        fv5.b("请选择正确的年级");
        return false;
    }

    public final rd6 O0() {
        if (this.f9225a == null) {
            this.f9225a = new pd6(this, this.f9222a).r(R.layout.pickerview_custom_options, new b()).f(true).C(Color.parseColor("#650aec")).D(Color.parseColor("#cc333333")).n(Color.parseColor("#E8E8E8")).p(7).s(3.0f).k(18).b();
        }
        return this.f9225a;
    }

    public final void P0() {
        this.f9224a = MediaPicker.w(this, new MediaPickerListener() { // from class: com.zj.adlib.nh0
            @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
            public final void b(MediaPickerResult mediaPickerResult) {
                this.f43521a.S0(mediaPickerResult);
            }
        });
    }

    public final void Q0() {
        ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setBackShow(true).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.lh0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43062a.T0(view);
            }
        }).setTitleName(ys8.e(R.string.auth_title_confirm)).setShowRightText(true).setRightButtonText("提交").setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.mh0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43297a.U0(view);
            }
        }));
    }

    public final void Y0(int i) {
        this.L = i;
        this.f9224a.T("为了能够正常拍摄学生卡，我们需要访问您终端设备的相机权限", 1, 1080, 1024);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(false).u1(i).G1(false).g0(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_authorize_verify), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new c());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        RadioGroup radioGroup;
        Q0();
        P0();
        ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).o(this.f9223a, this.x);
        ViewDataBinding binding = getBinding();
        if (binding == null || !(binding instanceof ActivityAuthorizeVerifyBinding) || (radioGroup = ((ActivityAuthorizeVerifyBinding) binding).f9022a) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.zj.adlib.kh0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                this.f42817a.R0(radioGroup2, i);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).k.observe(this, new Observer() { // from class: com.zj.adlib.ih0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f42356a.V0((Boolean) obj);
            }
        });
        ((AuthorizeVerifyVM) ((BaseVmActivity) this).f8507a).l.observe(this, new Observer() { // from class: com.zj.adlib.jh0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f42584a.W0((List) obj);
            }
        });
    }
}
