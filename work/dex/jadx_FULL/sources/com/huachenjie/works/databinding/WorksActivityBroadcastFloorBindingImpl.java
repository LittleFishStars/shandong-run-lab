package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorBean;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityBroadcastFloorBindingImpl extends WorksActivityBroadcastFloorBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13832a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13838a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13839b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f13840b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastFloorActivity.ClickProxy f36771a;

        public a a(BroadcastFloorActivity.ClickProxy value) {
            this.f36771a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36771a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastFloorActivity.ClickProxy f36772a;

        public b a(BroadcastFloorActivity.ClickProxy value) {
            this.f36772a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36772a.b(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastFloorActivity.ClickProxy f36773a;

        public c a(BroadcastFloorActivity.ClickProxy value) {
            this.f36773a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36773a.d(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastFloorActivity.ClickProxy f36774a;

        public d a(BroadcastFloorActivity.ClickProxy value) {
            this.f36774a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36774a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36770a = sparseIntArray;
        sparseIntArray.put(R.id.bg_container, 14);
        sparseIntArray.put(R.id.preImage, 15);
        sparseIntArray.put(R.id.curImage, 16);
        sparseIntArray.put(R.id.app_bar, 17);
        sparseIntArray.put(R.id.cl_header_container, 18);
        sparseIntArray.put(R.id.vp_broadcast_floor_banner, 19);
        sparseIntArray.put(R.id.iv_broadcast_floor_icon, 20);
        sparseIntArray.put(R.id.tool_bar, 21);
        sparseIntArray.put(R.id.tv_title, 22);
        sparseIntArray.put(R.id.bl_LinearLayout, 23);
        sparseIntArray.put(R.id.tabLayout, 24);
        sparseIntArray.put(R.id.viewPager, 25);
    }

    public WorksActivityBroadcastFloorBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 26, f13832a, f36770a));
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0152  */
    /* JADX WARN: Code duplicated, block: B:83:0x015c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0174  */
    /* JADX WARN: Code duplicated, block: B:86:0x0178  */
    /* JADX WARN: Code duplicated, block: B:89:0x019b  */
    /* JADX WARN: Code duplicated, block: B:92:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ce  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        boolean zSafeUnbox;
        int iA;
        int i;
        String surveyCoverImage;
        String str;
        String description;
        String str2;
        String str3;
        long j2;
        d dVar;
        b bVar;
        c cVarA;
        a aVar;
        boolean z;
        int i2;
        synchronized (this) {
            j = this.f13833a;
            this.f13833a = 0L;
        }
        BroadcastFloorVM broadcastFloorVM = ((WorksActivityBroadcastFloorBinding) this).f13826a;
        BroadcastFloorActivity.ClickProxy clickProxy = ((WorksActivityBroadcastFloorBinding) this).f13825a;
        long j3 = 88 & j;
        RequestOptions requestOptions = j3 != 0 ? ju3.m : null;
        if ((95 & j) != 0) {
            if ((j & 85) != 0) {
                BaseViewModel.b bVarE = broadcastFloorVM != null ? broadcastFloorVM.e() : null;
                if ((j & 81) != 0) {
                    MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                    updateLiveDataRegistration(0, mutableLiveDataA);
                    int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                    i2 = iSafeUnbox2 + 12;
                    iA = jj8.a(iSafeUnbox2 + 68);
                } else {
                    iA = 0;
                    i2 = 0;
                }
                if ((j & 84) != 0) {
                    MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                    updateLiveDataRegistration(2, mutableLiveDataC);
                    iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
                } else {
                    iSafeUnbox = 0;
                }
            } else {
                iSafeUnbox = 0;
                iA = 0;
                i2 = 0;
            }
            if ((j & 82) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = broadcastFloorVM != null ? broadcastFloorVM.p() : null;
                updateLiveDataRegistration(1, mutableLiveDataP);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if (j3 != 0) {
                MutableLiveData<BroadcastFloorBean> mutableLiveDataL = broadcastFloorVM != null ? broadcastFloorVM.l() : null;
                updateLiveDataRegistration(3, mutableLiveDataL);
                BroadcastFloorBean value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value != null) {
                    description = value.getDescription();
                    String name = value.getName();
                    String topic = value.getTopic();
                    String surveyName = value.getSurveyName();
                    surveyCoverImage = value.getSurveyCoverImage();
                    i = i2;
                    str2 = name;
                    str3 = topic;
                    str = surveyName;
                }
                j2 = j & 96;
                if (j2 != 0 || clickProxy == null) {
                    dVar = null;
                    bVar = null;
                    cVarA = null;
                    aVar = null;
                } else {
                    d dVar2 = this.f13837a;
                    if (dVar2 == null) {
                        dVar2 = new d();
                        this.f13837a = dVar2;
                    }
                    d dVarA = dVar2.a(clickProxy);
                    a aVar2 = this.f13834a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f13834a = aVar2;
                    }
                    a aVarA = aVar2.a(clickProxy);
                    b bVar2 = this.f13835a;
                    if (bVar2 == null) {
                        bVar2 = new b();
                        this.f13835a = bVar2;
                    }
                    b bVarA = bVar2.a(clickProxy);
                    c cVar = this.f13836a;
                    if (cVar == null) {
                        cVar = new c();
                        this.f13836a = cVar;
                    }
                    cVarA = cVar.a(clickProxy);
                    dVar = dVarA;
                    aVar = aVarA;
                    bVar = bVarA;
                }
                z = zSafeUnbox;
                if (j2 != 0) {
                    CommonBindingAdapter.q(((WorksActivityBroadcastFloorBinding) this).b, dVar, null);
                    CommonBindingAdapter.q(this.f13838a, aVar, null);
                    CommonBindingAdapter.q(this.f13840b, bVar, null);
                    CommonBindingAdapter.q(((WorksActivityBroadcastFloorBinding) this).f13829b, cVarA, null);
                }
                if (j3 != 0) {
                    TextViewBindingAdapter.setText(this.f, str);
                    CommonBindingAdapter.b0(this.e, surveyCoverImage, requestOptions, false);
                    TextViewBindingAdapter.setText(((WorksActivityBroadcastFloorBinding) this).f13819a, description);
                    TextViewBindingAdapter.setText(((WorksActivityBroadcastFloorBinding) this).f13830c, str2);
                    TextViewBindingAdapter.setText(super.e, str3);
                }
                if ((81 & j) != 0) {
                    CommonBindingAdapter.G(this.b, iA);
                    CommonBindingAdapter.I(this.f13840b, 16, 12, 16, i, null);
                }
                if ((82 & j) != 0) {
                    CommonBindingAdapter.l0(this.g, z);
                    CommonBindingAdapter.l0(this.c, z);
                }
                if ((j & 84) != 0) {
                    CommonBindingAdapter.G(((WorksActivityBroadcastFloorBinding) this).f36769a, iSafeUnbox);
                }
            }
            i = i2;
        } else {
            iSafeUnbox = 0;
            zSafeUnbox = false;
            iA = 0;
            i = 0;
        }
        surveyCoverImage = null;
        str = null;
        description = null;
        str2 = null;
        str3 = null;
        j2 = j & 96;
        if (j2 != 0) {
            dVar = null;
            bVar = null;
            cVarA = null;
            aVar = null;
        } else {
            dVar = null;
            bVar = null;
            cVarA = null;
            aVar = null;
        }
        z = zSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.q(((WorksActivityBroadcastFloorBinding) this).b, dVar, null);
            CommonBindingAdapter.q(this.f13838a, aVar, null);
            CommonBindingAdapter.q(this.f13840b, bVar, null);
            CommonBindingAdapter.q(((WorksActivityBroadcastFloorBinding) this).f13829b, cVarA, null);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f, str);
            CommonBindingAdapter.b0(this.e, surveyCoverImage, requestOptions, false);
            TextViewBindingAdapter.setText(((WorksActivityBroadcastFloorBinding) this).f13819a, description);
            TextViewBindingAdapter.setText(((WorksActivityBroadcastFloorBinding) this).f13830c, str2);
            TextViewBindingAdapter.setText(super.e, str3);
        }
        if ((81 & j) != 0) {
            CommonBindingAdapter.G(this.b, iA);
            CommonBindingAdapter.I(this.f13840b, 16, 12, 16, i, null);
        }
        if ((82 & j) != 0) {
            CommonBindingAdapter.l0(this.g, z);
            CommonBindingAdapter.l0(this.c, z);
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.G(((WorksActivityBroadcastFloorBinding) this).f36769a, iSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13833a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13833a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityBroadcastFloorBinding
    public void l(@Nullable BroadcastFloorActivity.ClickProxy Click) {
        ((WorksActivityBroadcastFloorBinding) this).f13825a = Click;
        synchronized (this) {
            this.f13833a |= 32;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityBroadcastFloorBinding
    public void m(@Nullable BroadcastFloorVM Vm) {
        ((WorksActivityBroadcastFloorBinding) this).f13826a = Vm;
        synchronized (this) {
            this.f13833a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BroadcastFloorBean> VmBroadcastFloorBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13833a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmShowSurvey, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13833a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13833a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13833a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((BroadcastFloorVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((BroadcastFloorActivity.ClickProxy) variable);
        }
        return true;
    }

    public WorksActivityBroadcastFloorBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (AppBarLayout) bindings[17], (FrameLayout) bindings[14], (BLLinearLayout) bindings[23], (ConstraintLayout) bindings[18], (ImageView) bindings[16], (ImageView) bindings[5], (ImageView) bindings[20], (ImageView) bindings[15], (SlidingTabLayout) bindings[24], (Toolbar) bindings[21], (TextView) bindings[4], (TextView) bindings[6], (TextView) bindings[3], (TextView) bindings[22], (TextView) bindings[2], (View) bindings[1], (ViewPager) bindings[25], (Banner) bindings[19]);
        this.f13833a = -1L;
        ((WorksActivityBroadcastFloorBinding) this).b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f13839b = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.f = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[11];
        this.f13838a = bLTextView;
        bLTextView.setTag(null);
        View view = (View) bindings[12];
        this.b = view;
        view.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[13];
        this.f13840b = bLTextView2;
        bLTextView2.setTag(null);
        TextView textView2 = (TextView) bindings[7];
        this.g = textView2;
        textView2.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) bindings[8];
        this.c = frameLayout2;
        frameLayout2.setTag(null);
        ImageView imageView = (ImageView) bindings[9];
        this.e = imageView;
        imageView.setTag(null);
        ((WorksActivityBroadcastFloorBinding) this).f13819a.setTag(null);
        ((WorksActivityBroadcastFloorBinding) this).f13829b.setTag(null);
        ((WorksActivityBroadcastFloorBinding) this).f13830c.setTag(null);
        super.e.setTag(null);
        ((WorksActivityBroadcastFloorBinding) this).f36769a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
