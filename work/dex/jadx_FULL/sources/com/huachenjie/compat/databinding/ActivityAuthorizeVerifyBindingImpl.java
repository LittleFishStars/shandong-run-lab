package com.huachenjie.compat.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ClearFocusConstraintLayout;
import com.huachenjie.compat.bean.StudentInfo;
import com.huachenjie.compat.page.login.AuthorizeVerifyActivity;
import com.huachenjie.compat.page.login.vm.AuthorizeVerifyVM;
import com.zj.adlib.ju3;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityAuthorizeVerifyBindingImpl extends ActivityAuthorizeVerifyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f9029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f9030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ClearFocusConstraintLayout f9035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f9040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f9041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f9042a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f9043b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9044b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ImageView f9045c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9046c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9047c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9048d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f9049d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f9050e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f9051f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityAuthorizeVerifyBindingImpl.this.f9030a);
            AuthorizeVerifyVM authorizeVerifyVM = ((ActivityAuthorizeVerifyBinding) ActivityAuthorizeVerifyBindingImpl.this).f9025a;
            if (authorizeVerifyVM != null) {
                MutableLiveData<StudentInfo> mutableLiveData = authorizeVerifyVM.j;
                if (mutableLiveData != null) {
                    StudentInfo value = mutableLiveData.getValue();
                    if (value != null) {
                        value.setUserName(textString);
                    }
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34003a;

        public b a(AuthorizeVerifyActivity.c cVar) {
            this.f34003a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34003a.d(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34004a;

        public c a(AuthorizeVerifyActivity.c cVar) {
            this.f34004a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34004a.f(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34005a;

        public d a(AuthorizeVerifyActivity.c cVar) {
            this.f34005a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34005a.g(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34006a;

        public e a(AuthorizeVerifyActivity.c cVar) {
            this.f34006a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34006a.c(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34007a;

        public f a(AuthorizeVerifyActivity.c cVar) {
            this.f34007a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34007a.b(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34008a;

        public g a(AuthorizeVerifyActivity.c cVar) {
            this.f34008a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34008a.e(view);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeVerifyActivity.c f34009a;

        public h a(AuthorizeVerifyActivity.c cVar) {
            this.f34009a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34009a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(29);
        f9027a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{25}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34001a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_tip, 26);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_tip, 27);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_credentials, 28);
    }

    public ActivityAuthorizeVerifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 29, f9027a, f34001a));
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00e2  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        boolean z;
        boolean z2;
        String str;
        String str2;
        boolean z3;
        boolean z4;
        String value2;
        String className;
        boolean z5;
        BindingTitleBean bindingTitleBean;
        String str3;
        String str4;
        boolean z6;
        g gVarA;
        e eVar;
        c cVar;
        h hVar;
        d dVar;
        f fVar;
        b bVar;
        boolean z7;
        long j2;
        boolean z8;
        String str5;
        Long l;
        boolean z9;
        RequestOptions requestOptions;
        String str6;
        String userName;
        String subSchoolName;
        String departmentName;
        boolean z10;
        boolean z11;
        BindingTitleBean value3;
        int i;
        synchronized (this) {
            j = this.f9028a;
            this.f9028a = 0L;
        }
        AuthorizeVerifyVM authorizeVerifyVM = ((ActivityAuthorizeVerifyBinding) this).f9025a;
        AuthorizeVerifyActivity.c cVar2 = ((ActivityAuthorizeVerifyBinding) this).f9024a;
        RequestOptions requestOptions2 = (j & 88) != 0 ? ju3.i : null;
        int i2 = 0;
        if ((95 & j) != 0) {
            if ((j & 81) != 0) {
                MutableLiveData<StudentInfo> mutableLiveData = authorizeVerifyVM != null ? authorizeVerifyVM.j : null;
                updateLiveDataRegistration(0, mutableLiveData);
                StudentInfo value4 = mutableLiveData != null ? mutableLiveData.getValue() : null;
                if (value4 != null) {
                    int sex = value4.getSex();
                    className = value4.getClassName();
                    subSchoolName = value4.getSubSchoolName();
                    int studentStatus = value4.getStudentStatus();
                    String gradeName = value4.getGradeName();
                    departmentName = value4.getDepartmentName();
                    userName = value4.getUserName();
                    i2 = sex;
                    i = studentStatus;
                    str6 = gradeName;
                } else {
                    i = 0;
                    str6 = null;
                    userName = null;
                    className = null;
                    subSchoolName = null;
                    departmentName = null;
                }
                z10 = i2 == 2;
                z4 = i2 == 1;
                z11 = i == 1;
                z = i == 2;
            } else {
                z = false;
                str6 = null;
                userName = null;
                z4 = false;
                className = null;
                subSchoolName = null;
                departmentName = null;
                z10 = false;
                z11 = false;
            }
            long j3 = j & 82;
            if (j3 != 0) {
                MutableLiveData<String> mutableLiveData2 = authorizeVerifyVM != null ? authorizeVerifyVM.n : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                value2 = mutableLiveData2 != null ? mutableLiveData2.getValue() : null;
                z6 = value2 == null;
                if (j3 != 0) {
                    j = z6 ? j | 1024 : j | 512;
                }
            } else {
                value2 = null;
                z6 = false;
            }
            if ((j & 84) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData3 = authorizeVerifyVM != null ? authorizeVerifyVM.i : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    value3 = mutableLiveData3.getValue();
                } else {
                    value3 = null;
                }
            }
            long j4 = j & 88;
            if (j4 != 0) {
                MutableLiveData<String> mutableLiveData4 = authorizeVerifyVM != null ? authorizeVerifyVM.m : null;
                updateLiveDataRegistration(3, mutableLiveData4);
                value = mutableLiveData4 != null ? mutableLiveData4.getValue() : null;
                z5 = value == null;
                if (j4 != 0) {
                    j = z5 ? j | 4096 : j | 2048;
                }
            } else {
                value = null;
                z5 = false;
            }
            str = subSchoolName;
            bindingTitleBean = value3;
            str2 = departmentName;
            str3 = str6;
            z2 = z10;
            str4 = userName;
            z3 = z11;
        } else {
            value = null;
            z = false;
            z2 = false;
            str = null;
            str2 = null;
            z3 = false;
            z4 = false;
            value2 = null;
            className = null;
            z5 = false;
            bindingTitleBean = null;
            str3 = null;
            str4 = null;
            z6 = false;
        }
        long j5 = j & 82;
        RequestOptions requestOptions3 = j5 != 0 ? ju3.j : null;
        if ((j & 96) == 0 || cVar2 == null) {
            gVarA = null;
            eVar = null;
            cVar = null;
            hVar = null;
            dVar = null;
            fVar = null;
            bVar = null;
        } else {
            h hVar2 = this.f9042a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f9042a = hVar2;
            }
            h hVarA = hVar2.a(cVar2);
            b bVar2 = this.f9036a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9036a = bVar2;
            }
            b bVarA = bVar2.a(cVar2);
            c cVar3 = this.f9037a;
            if (cVar3 == null) {
                cVar3 = new c();
                this.f9037a = cVar3;
            }
            c cVarA = cVar3.a(cVar2);
            d dVar2 = this.f9038a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f9038a = dVar2;
            }
            d dVarA = dVar2.a(cVar2);
            e eVar2 = this.f9039a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f9039a = eVar2;
            }
            e eVarA = eVar2.a(cVar2);
            f fVar2 = this.f9040a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f9040a = fVar2;
            }
            f fVarA = fVar2.a(cVar2);
            g gVar = this.f9041a;
            if (gVar == null) {
                gVar = new g();
                this.f9041a = gVar;
            }
            gVarA = gVar.a(cVar2);
            bVar = bVarA;
            hVar = hVarA;
            cVar = cVarA;
            dVar = dVarA;
            eVar = eVarA;
            fVar = fVarA;
        }
        boolean zIsEmpty = (j & 512) != 0 ? TextUtils.isEmpty(value2) : false;
        boolean zIsEmpty2 = (j & 2048) != 0 ? TextUtils.isEmpty(value) : false;
        if (j5 != 0) {
            if (z6) {
                zIsEmpty = true;
            }
            if (j5 != 0) {
                j |= zIsEmpty ? 256L : 128L;
            }
            j2 = 88;
            z7 = !zIsEmpty;
        } else {
            z7 = false;
            zIsEmpty = false;
            j2 = 88;
        }
        long j6 = j & j2;
        if (j6 != 0) {
            if (z5) {
                zIsEmpty2 = true;
            }
            if (j6 != 0) {
                j |= zIsEmpty2 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            z8 = !zIsEmpty2;
        } else {
            z8 = false;
            zIsEmpty2 = false;
        }
        long j7 = j & 82;
        if (j7 == 0) {
            value2 = null;
        } else if (zIsEmpty) {
            value2 = "";
        }
        long j8 = j & 88;
        if (j8 != 0) {
            str5 = zIsEmpty2 ? "" : value;
        } else {
            str5 = null;
        }
        if ((j & 81) != 0) {
            CommonBindingAdapter.e0(((ActivityAuthorizeVerifyBinding) this).f9022a, z);
            CompoundButtonBindingAdapter.setChecked(((ActivityAuthorizeVerifyBinding) this).f9021a, z2);
            CommonBindingAdapter.e0(((ActivityAuthorizeVerifyBinding) this).f9021a, z);
            CompoundButtonBindingAdapter.setChecked(((ActivityAuthorizeVerifyBinding) this).b, z4);
            CommonBindingAdapter.e0(((ActivityAuthorizeVerifyBinding) this).b, z);
            CommonBindingAdapter.l0(this.f9031a, z3);
            TextViewBindingAdapter.setText(this.f9047c, str);
            CommonBindingAdapter.l0(this.f9029a, z3);
            CommonBindingAdapter.l0(this.f9044b, z3);
            TextViewBindingAdapter.setText(this.f9049d, str2);
            TextViewBindingAdapter.setText(this.f9050e, className);
            CommonBindingAdapter.l0(this.b, z3);
            CommonBindingAdapter.l0(this.f9046c, z);
            CommonBindingAdapter.l0(this.f9051f, z3);
            String str7 = str4;
            TextViewBindingAdapter.setText(this.f9051f, str7);
            CommonBindingAdapter.l0(this.c, z);
            CommonBindingAdapter.l0(this.g, z3);
            CommonBindingAdapter.l0(this.h, z);
            CommonBindingAdapter.l0(this.f9030a, z);
            TextViewBindingAdapter.setText(this.f9030a, str7);
            TextViewBindingAdapter.setText(this.i, str3);
            CommonBindingAdapter.l0(this.f, z);
        }
        if ((84 & j) != 0) {
            this.f9034a.k(bindingTitleBean);
        }
        if ((64 & j) != 0) {
            ClearFocusConstraintLayout clearFocusConstraintLayout = this.f9035a;
            DrawablesBindingAdapter.h(clearFocusConstraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(clearFocusConstraintLayout, com.huachenjie.compat.R.color.white)), 0, 0.0f, 0.0f, 0.0f, 26.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            l = null;
            TextViewBindingAdapter.setTextWatcher(this.f9030a, null, null, null, this.f9033a);
        } else {
            l = null;
        }
        if ((j & 96) != 0) {
            CommonBindingAdapter.q(this.f9031a, gVarA, l);
            CommonBindingAdapter.q(this.f9044b, eVar, l);
            CommonBindingAdapter.q(this.f9043b, cVar, l);
            CommonBindingAdapter.q(this.f9045c, hVar, l);
            CommonBindingAdapter.q(this.d, dVar, l);
            CommonBindingAdapter.q(this.e, fVar, l);
            CommonBindingAdapter.q(this.f9048d, bVar, l);
        }
        if (j8 != 0) {
            z9 = false;
            CommonBindingAdapter.b0(this.f9043b, str5, requestOptions, false);
            CommonBindingAdapter.l0(this.f9045c, z8);
        } else {
            z9 = false;
        }
        if (j7 != 0) {
            requestOptions = requestOptions2;
            CommonBindingAdapter.b0(this.d, value2, requestOptions3, z9);
            CommonBindingAdapter.l0(this.e, z7);
        }
        requestOptions = requestOptions2;
        ViewDataBinding.executeBindingsOn(this.f9034a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9028a != 0) {
                return true;
            }
            return this.f9034a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9028a = 64L;
        }
        this.f9034a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAuthorizeVerifyBinding
    public void l(@Nullable AuthorizeVerifyActivity.c cVar) {
        ((ActivityAuthorizeVerifyBinding) this).f9024a = cVar;
        synchronized (this) {
            this.f9028a |= 32;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAuthorizeVerifyBinding
    public void m(@Nullable AuthorizeVerifyVM authorizeVerifyVM) {
        ((ActivityAuthorizeVerifyBinding) this).f9025a = authorizeVerifyVM;
        synchronized (this) {
            this.f9028a |= 16;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9028a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return r((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9028a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<StudentInfo> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9028a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9028a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9034a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((AuthorizeVerifyVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((AuthorizeVerifyActivity.c) obj);
        }
        return true;
    }

    public ActivityAuthorizeVerifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RadioGroup) objArr[4], (RadioButton) objArr[5], (RadioButton) objArr[6], (ImageView) objArr[26], (TextView) objArr[28], (TextView) objArr[27]);
        this.f9033a = new a();
        this.f9028a = -1L;
        ((ActivityAuthorizeVerifyBinding) this).f9022a.setTag(null);
        ((ActivityAuthorizeVerifyBinding) this).f9021a.setTag(null);
        ((ActivityAuthorizeVerifyBinding) this).b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[25];
        this.f9034a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9032a = constraintLayout;
        constraintLayout.setTag(null);
        ClearFocusConstraintLayout clearFocusConstraintLayout = (ClearFocusConstraintLayout) objArr[1];
        this.f9035a = clearFocusConstraintLayout;
        clearFocusConstraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.f9031a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.f9047c = textView;
        textView.setTag(null);
        View view2 = (View) objArr[12];
        this.f9029a = view2;
        view2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[13];
        this.f9044b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.f9049d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.f9050e = textView3;
        textView3.setTag(null);
        View view3 = (View) objArr[16];
        this.b = view3;
        view3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[17];
        this.f9046c = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView = (ImageView) objArr[18];
        this.f9043b = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[19];
        this.f9045c = imageView2;
        imageView2.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.f9051f = textView4;
        textView4.setTag(null);
        ImageView imageView3 = (ImageView) objArr[20];
        this.d = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[21];
        this.e = imageView4;
        imageView4.setTag(null);
        View view4 = (View) objArr[22];
        this.c = view4;
        view4.setTag(null);
        TextView textView5 = (TextView) objArr[23];
        this.g = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[24];
        this.h = textView6;
        textView6.setTag(null);
        EditText editText = (EditText) objArr[3];
        this.f9030a = editText;
        editText.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[7];
        this.f9048d = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView7 = (TextView) objArr[8];
        this.i = textView7;
        textView7.setTag(null);
        ImageView imageView5 = (ImageView) objArr[9];
        this.f = imageView5;
        imageView5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
