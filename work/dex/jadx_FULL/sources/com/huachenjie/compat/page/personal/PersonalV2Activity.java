package com.huachenjie.compat.page.personal;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.ClazzBean;
import com.huachenjie.compat.bean.DepartmentClassBean;
import com.huachenjie.compat.bean.PersonalInfo;
import com.huachenjie.compat.bean.SubSchoolBean;
import com.zj.adlib.e79;
import com.zj.adlib.f79;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.pd6;
import com.zj.adlib.rd6;
import com.zj.adlib.s72;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.k)
public class PersonalV2Activity extends BaseVmActivity<PersonalV2VM> {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f79 f9250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rd6 f9251a;
    public final List<String> c = new ArrayList();
    public final List<List<String>> d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnTimeSelectListener f9249a = new OnTimeSelectListener() { // from class: com.zj.adlib.wp6
        @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
        public final void a(Date date, View view) {
            this.f45654a.N0(date, view);
        }
    };
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnOptionsSelectListener f9248a = new OnOptionsSelectListener() { // from class: com.zj.adlib.xp6
        @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
        public final void a(int i, int i2, int i3, View view) {
            this.f45872a.R0(i, i2, i3, view);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f34142a = new a();
    public final View.OnClickListener b = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalV2Activity.this.f9251a != null) {
                PersonalV2Activity.this.f9251a.onClick(view);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonalV2Activity.this.f9250a != null) {
                PersonalV2Activity.this.f9250a.onClick(view);
            }
        }
    }

    public class c implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f34145a = "submit";
        public static final String b = "cancel";

        public c() {
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(View view) {
            Button button = (Button) view.findViewById(R.id.btnSubmit);
            Button button2 = (Button) view.findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(PersonalV2Activity.this.f34142a);
            button2.setOnClickListener(PersonalV2Activity.this.f34142a);
        }
    }

    public class d implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f34146a = "submit";
        public static final String b = "cancel";

        public d() {
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(View view) {
            Button button = (Button) view.findViewById(R.id.btnSubmit);
            Button button2 = (Button) view.findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(PersonalV2Activity.this.b);
            button2.setOnClickListener(PersonalV2Activity.this.b);
        }
    }

    public class e {
        public e() {
        }

        public void a(View view) {
            Boolean value = ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).l.getValue();
            Boolean bool = Boolean.TRUE;
            if (value == bool) {
                ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).l.setValue(Boolean.FALSE);
            } else {
                ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).l.setValue(bool);
            }
        }

        public void b(View view) {
            PersonalInfo value = ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).j.getValue();
            ARouter.getInstance().build(RoutePathConstants.Compat.l).withParcelable("address", value != null ? value.getAddress() : null).navigation();
        }

        public void c(View view) {
            if (((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).j.getValue() == null) {
                return;
            }
            PersonalV2Activity.this.K = 1;
            PersonalV2Activity.this.E0().t();
        }

        public void d(View view) {
            ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).k();
        }

        public void e(View view) {
            ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).j();
        }

        public void f(View view) {
            ((PersonalV2VM) ((BaseVmActivity) PersonalV2Activity.this).f8507a).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(List list) {
        if (list == null || list.size() == 0) {
            fv5.b("对不起，您现在还没有权限修改自己的‘民族’");
            return;
        }
        this.c.clear();
        this.d.clear();
        String nation = ((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.getValue().getNation();
        if (TextUtils.isEmpty(nation)) {
            nation = "";
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.c.add((String) list.get(i2));
            if (nation.equals(list.get(i2))) {
                i = i2;
            }
        }
        this.K = 4;
        F0();
        this.f9251a.D(this.c, null);
        this.f9251a.F(i);
        this.f9251a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(PersonalInfo personalInfo) {
        if (personalInfo == null || personalInfo.getAddress() == null) {
            return;
        }
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).n.setValue(personalInfo.getAddress().getStudentAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(List list) {
        if (list == null || list.size() == 0) {
            fv5.b("对不起，您现在还没有权限修改自己的‘班级’和‘院系’");
            return;
        }
        String departmentName = ((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.getValue().getSchoolInfo().getDepartmentName();
        String className = ((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.getValue().getSchoolInfo().getClassName();
        if (TextUtils.isEmpty(departmentName)) {
            departmentName = "";
        }
        if (TextUtils.isEmpty(className)) {
            className = "";
        }
        this.c.clear();
        this.d.clear();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            DepartmentClassBean departmentClassBean = (DepartmentClassBean) list.get(i3);
            this.c.add(departmentClassBean.getDepartmentName());
            if (departmentName.equals(departmentClassBean.getDepartmentName())) {
                i = i3;
            }
            ArrayList arrayList = new ArrayList();
            if (departmentClassBean.getClassList() != null && departmentClassBean.getClassList().size() > 0) {
                for (int i4 = 0; i4 < departmentClassBean.getClassList().size(); i4++) {
                    ClazzBean clazzBean = departmentClassBean.getClassList().get(i4);
                    arrayList.add(clazzBean.getClassName());
                    if (className.equals(clazzBean.getClassName())) {
                        i2 = i4;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add("");
            }
            this.d.add(arrayList);
        }
        this.K = 2;
        F0();
        this.f9251a.D(this.c, this.d);
        this.f9251a.G(i, i2);
        this.f9251a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(List list) {
        if (list == null || list.size() == 0) {
            fv5.b("对不起，您现在还没有权限修改自己的‘校区’");
            return;
        }
        this.c.clear();
        this.d.clear();
        String subSchoolName = ((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.getValue().getSchoolInfo().getSubSchoolName();
        if (TextUtils.isEmpty(subSchoolName)) {
            subSchoolName = "";
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            SubSchoolBean subSchoolBean = (SubSchoolBean) list.get(i2);
            this.c.add(subSchoolBean.getSubSchoolName());
            if (subSchoolName.equals(subSchoolBean.getSubSchoolName())) {
                i = i2;
            }
        }
        this.K = 3;
        F0();
        this.f9251a.D(this.c, null);
        this.f9251a.F(i);
        this.f9251a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(String str, View view) {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(Date date, View view) {
        final String strC = s72.c(date.getTime(), "yyyy-MM-dd");
        ft1.g(getContext()).X("确定修改生日为：").Q(strC).O(Color.parseColor("#FF762F")).F("我再想想").N("确定修改").J(new View.OnClickListener() { // from class: com.zj.adlib.op6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f43802a.M0(strC, view2);
            }
        }).Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(String str, String str2, View view) {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).l(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(String str, View view) {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).o(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(String str, View view) {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(int i, int i2, int i3, View view) {
        int i4 = this.K;
        if (i4 == 2) {
            final String str = this.c.get(i);
            final String str2 = this.d.get(i).get(i2);
            ft1.g(getContext()).X("确定修改班级为：").Q(str + "   " + str2).O(Color.parseColor("#FF762F")).F("我再想想").N("确定修改").J(new View.OnClickListener() { // from class: com.zj.adlib.tp6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f44977a.O0(str, str2, view2);
                }
            }).Y();
            return;
        }
        if (i4 == 4) {
            final String str3 = this.c.get(i);
            ft1.g(getContext()).X("确定修改民族为：").Q(str3).O(Color.parseColor("#FF762F")).F("我再想想").N("确定修改").J(new View.OnClickListener() { // from class: com.zj.adlib.up6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f45200a.P0(str3, view2);
                }
            }).Y();
        } else if (i4 == 3) {
            final String str4 = this.c.get(i);
            ft1.g(getContext()).X("确定修改校区为：").Q(str4).O(Color.parseColor("#FF762F")).F("我再想想").N("确定修改").J(new View.OnClickListener() { // from class: com.zj.adlib.vp6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f45411a.Q0(str4, view2);
                }
            }).Y();
        }
    }

    public final f79 E0() {
        if (this.f9250a == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1950, 0, 1);
            this.f9250a = new e79(this, this.f9249a).s(R.layout.pickerview_custom_time, new d()).B(Color.parseColor("#650aec")).C(Color.parseColor("#cc333333")).n(Color.parseColor("#E8E8E8")).q(7).t(3.0f).k(18).x(calendar, Calendar.getInstance()).b();
        }
        Calendar calendar2 = Calendar.getInstance();
        Date dateI = s72.i(((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.getValue().getBirthday(), "yyyy-MM-dd");
        if (dateI == null) {
            calendar2.set(2000, 0, 1);
        } else {
            calendar2.setTime(dateI);
        }
        this.f9250a.E(calendar2);
        return this.f9250a;
    }

    public final rd6 F0() {
        rd6 rd6VarB = new pd6(this, this.f9248a).r(R.layout.pickerview_custom_options, new c()).f(true).C(Color.parseColor("#650aec")).D(Color.parseColor("#cc333333")).n(Color.parseColor("#E8E8E8")).p(7).s(3.0f).k(18).b();
        this.f9251a = rd6VarB;
        return rd6VarB;
    }

    public final void G0() {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((PersonalV2VM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setTitleName("个人资料").setTitleTextColor(Color.parseColor("#2C3E50")).setBackTintColor(Integer.valueOf(Color.parseColor("#000000"))).setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.sp6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44744a.H0(view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        com.gyf.immersionbar.e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(false).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_personal_v2), Integer.valueOf(wk0.L), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new e());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        G0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).j.observe(this, new Observer() { // from class: com.zj.adlib.np6
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f43582a.J0((PersonalInfo) obj);
            }
        });
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).m.observe(this, new Observer() { // from class: com.zj.adlib.pp6
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f44037a.K0((List) obj);
            }
        });
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).o.observe(this, new Observer() { // from class: com.zj.adlib.qp6
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f44271a.L0((List) obj);
            }
        });
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).p.observe(this, new Observer() { // from class: com.zj.adlib.rp6
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f44505a.I0((List) obj);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((PersonalV2VM) ((BaseVmActivity) this).f8507a).i();
    }
}
