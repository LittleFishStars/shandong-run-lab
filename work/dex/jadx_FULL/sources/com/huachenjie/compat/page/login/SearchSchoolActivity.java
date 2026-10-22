package com.huachenjie.compat.page.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.SchoolListEntity;
import java.lang.ref.WeakReference;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.e)
public class SearchSchoolActivity extends BaseActivity<com.huachenjie.compat.page.login.a> implements SearchSchoolContact.SearchSchoolView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f34113a = 500;
    public static final String t = "selectedSchool";
    public static final String x = "SearchSchoolActivity";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f9232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SchoolPageComponent f9233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Subscription f9236a;
    public LinearLayout b;
    public EditText c;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchSchoolActivity.this.f9233a.i();
            SearchSchoolActivity.this.q0(1);
        }
    }

    public static class b implements SchoolPageComponent.OnSchoolListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SearchSchoolActivity> f34115a;

        public b(SearchSchoolActivity searchSchoolActivity) {
            if (searchSchoolActivity != null) {
                this.f34115a = new WeakReference<>(searchSchoolActivity);
            }
        }

        @Override // com.huachenjie.compat.page.login.SchoolPageComponent.OnSchoolListener
        public void a(int i) {
            SearchSchoolActivity searchSchoolActivity;
            WeakReference<SearchSchoolActivity> weakReference = this.f34115a;
            if (weakReference == null || (searchSchoolActivity = weakReference.get()) == null) {
                return;
            }
            searchSchoolActivity.v0(i);
        }

        @Override // com.huachenjie.compat.page.login.SchoolPageComponent.OnSchoolListener
        public void b(SchoolInfo schoolInfo) {
            SearchSchoolActivity searchSchoolActivity;
            WeakReference<SearchSchoolActivity> weakReference = this.f34115a;
            if (weakReference == null || (searchSchoolActivity = weakReference.get()) == null) {
                return;
            }
            searchSchoolActivity.u0(schoolInfo);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SearchSchoolActivity> f34116a;
        public String f;

        public c(SearchSchoolActivity searchSchoolActivity) {
            if (searchSchoolActivity != null) {
                this.f34116a = new WeakReference<>(searchSchoolActivity);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchSchoolActivity searchSchoolActivity;
            WeakReference<SearchSchoolActivity> weakReference = this.f34116a;
            if (weakReference == null || (searchSchoolActivity = weakReference.get()) == null) {
                return;
            }
            searchSchoolActivity.w0(1, this.f);
        }

        public void setKey(String str) {
            this.f = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        setResult(0);
        finish();
    }

    @Override // com.huachenjie.compat.page.login.SearchSchoolContact.SearchSchoolView
    public void c(SchoolListEntity schoolListEntity) {
        this.f9233a.C(0);
        this.f9233a.A(schoolListEntity);
    }

    @Override // com.huachenjie.compat.page.login.SearchSchoolContact.SearchSchoolView
    public void d(SchoolListEntity schoolListEntity) {
        this.f9233a.C(0);
        this.f9233a.B(schoolListEntity);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.activity_search_school;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void getServerData() {
        w0(1, "");
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e.p3(this).G2(R.color.color_main_v2).T2(false).u1(com.huachenjie.common.R.color.transparent).G1(false).T(true).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f9232a = new Handler(getMainLooper());
        this.f9234a = new b(this);
        this.f9235a = new c(this);
        SchoolPageComponent schoolPageComponent = new SchoolPageComponent(this);
        this.f9233a = schoolPageComponent;
        schoolPageComponent.setOnSchoolListener(this.f9234a);
        getLifecycle().addObserver(this.f9233a);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        this.c = (EditText) findViewById(R.id.edit_search);
        this.b = (LinearLayout) findViewById(R.id.ll_no_nearby_school);
        r0();
        s0();
        findViewById(R.id.iv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ly7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43184a.t0(view);
            }
        });
    }

    @Override // com.huachenjie.compat.page.login.SearchSchoolContact.SearchSchoolView
    public void o(String str) {
        this.f9233a.C(0);
        this.f9233a.s(str);
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f9232a.removeCallbacksAndMessages(null);
        this.f9234a = null;
        this.f9235a = null;
        Subscription subscription = this.f9236a;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void q0(int i) {
        c cVar = this.f9235a;
        if (cVar != null) {
            this.f9232a.removeCallbacks(cVar);
        }
        String strTrim = this.c.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            this.f9233a.C(8);
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
            this.f9235a.setKey(strTrim);
            this.f9232a.postDelayed(this.f9235a, 500L);
        }
    }

    public final void r0() {
    }

    public final void s0() {
        this.c.addTextChangedListener(new a());
    }

    public final void u0(SchoolInfo schoolInfo) {
        if (schoolInfo == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("selectedSchool", schoolInfo);
        setResult(-1, intent);
        finish();
    }

    public final void v0(int i) {
        c cVar = this.f9235a;
        if (cVar != null) {
            this.f9232a.removeCallbacks(cVar);
        }
        w0(i, this.c.getText().toString().trim());
    }

    public final void w0(int i, String str) {
        this.f9233a.v();
        Subscription subscription = this.f9236a;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f9236a = ((com.huachenjie.compat.page.login.a) ((BaseActivity) this).f8487a).f(str, i);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public com.huachenjie.compat.page.login.a initPresenter() {
        return new com.huachenjie.compat.page.login.a();
    }
}
