package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.UserActivityInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel;
import com.zj.adlib.qk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksHeadSearchHotSpotBindingImpl extends WorksHeadSearchHotSpotBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14390a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f14396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f14397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f14398a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14399b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14400c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f14401d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f14402e;

    @NonNull
    public final LinearLayout f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f14403f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36981a;

        public a a(SearchHotSpotFragment.a value) {
            this.f36981a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36981a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36982a;

        public b a(SearchHotSpotFragment.a value) {
            this.f36982a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36982a.e(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36983a;

        public c a(SearchHotSpotFragment.a value) {
            this.f36983a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36983a.f(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36984a;

        public d a(SearchHotSpotFragment.a value) {
            this.f36984a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36984a.c(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36985a;

        public e a(SearchHotSpotFragment.a value) {
            this.f36985a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36985a.a(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchHotSpotFragment.a f36986a;

        public f a(SearchHotSpotFragment.a value) {
            this.f36986a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36986a.d(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36980a = sparseIntArray;
        sparseIntArray.put(R.id.fl_history, 18);
    }

    public WorksHeadSearchHotSpotBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 19, f14390a, f36980a));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        String str3;
        String popularityValue;
        String str4;
        String str5;
        String str6;
        f fVar;
        a aVar;
        e eVarA;
        d dVar;
        b bVar;
        c cVar;
        String popularityValue2;
        String title;
        String popularityValue3;
        String subjectName;
        String subjectName2;
        String subjectName3;
        synchronized (this) {
            j = this.f14391a;
            this.f14391a = 0L;
        }
        SearchHotSpotModel searchHotSpotModel = ((WorksHeadSearchHotSpotBinding) this).f14389a;
        SearchHotSpotFragment.a aVar2 = ((WorksHeadSearchHotSpotBinding) this).f14388a;
        boolean z5 = false;
        if ((191 & j) != 0) {
            if ((j & 161) != 0) {
                MutableLiveData<SearchHotSpotItemBean> mutableLiveDataJ = searchHotSpotModel != null ? searchHotSpotModel.J() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                SearchHotSpotItemBean value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                if (value != null) {
                    popularityValue2 = value.getPopularityValue();
                    subjectName3 = value.getSubjectName();
                } else {
                    popularityValue2 = null;
                    subjectName3 = null;
                }
                z = value != null;
                str4 = String.format("#%s", subjectName3);
            } else {
                z = false;
                str4 = null;
                popularityValue2 = null;
            }
            if ((j & 160) == 0) {
                z2 = false;
            } else {
                List<String> listH = searchHotSpotModel != null ? searchHotSpotModel.H() : null;
                if ((listH != null ? listH.size() : 0) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if ((j & 162) != 0) {
                MutableLiveData<Boolean> mutableLiveDataD = searchHotSpotModel != null ? searchHotSpotModel.D() : null;
                updateLiveDataRegistration(1, mutableLiveDataD);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataD != null ? mutableLiveDataD.getValue() : null);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
            } else {
                zSafeUnbox = false;
                zSafeUnbox2 = false;
            }
            if ((j & 164) != 0) {
                MutableLiveData<SearchHotSpotItemBean> mutableLiveDataE = searchHotSpotModel != null ? searchHotSpotModel.E() : null;
                updateLiveDataRegistration(2, mutableLiveDataE);
                SearchHotSpotItemBean value2 = mutableLiveDataE != null ? mutableLiveDataE.getValue() : null;
                z3 = value2 != null;
                if (value2 != null) {
                    popularityValue = value2.getPopularityValue();
                    subjectName2 = value2.getSubjectName();
                } else {
                    subjectName2 = null;
                    popularityValue = null;
                }
                str2 = String.format("#%s", subjectName2);
            } else {
                z3 = false;
                str2 = null;
                popularityValue = null;
            }
            if ((j & 168) != 0) {
                MutableLiveData<UserActivityInfo> mutableLiveDataB = searchHotSpotModel != null ? searchHotSpotModel.B() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                UserActivityInfo value3 = mutableLiveDataB != null ? mutableLiveDataB.getValue() : null;
                title = value3 != null ? value3.getTitle() : null;
                z4 = value3 != null;
            } else {
                z4 = false;
                title = null;
            }
            if ((j & 176) != 0) {
                MutableLiveData<SearchHotSpotItemBean> mutableLiveDataK = searchHotSpotModel != null ? searchHotSpotModel.K() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                SearchHotSpotItemBean value4 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if (value4 != null) {
                    popularityValue3 = value4.getPopularityValue();
                    subjectName = value4.getSubjectName();
                } else {
                    popularityValue3 = null;
                    subjectName = null;
                }
                boolean z6 = value4 != null;
                str = String.format("#%s", subjectName);
                str3 = popularityValue3;
                z5 = z6;
            } else {
                str = null;
                str3 = null;
            }
            String str7 = popularityValue2;
            str6 = title;
            str5 = str7;
        } else {
            z = false;
            z2 = false;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            z3 = false;
            z4 = false;
            str = null;
            str2 = null;
            str3 = null;
            popularityValue = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || aVar2 == null) {
            fVar = null;
            aVar = null;
            eVarA = null;
            dVar = null;
            bVar = null;
            cVar = null;
        } else {
            f fVar2 = this.f14398a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f14398a = fVar2;
            }
            f fVarA = fVar2.a(aVar2);
            a aVar3 = this.f14393a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f14393a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f14394a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f14394a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f14395a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f14395a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar2 = this.f14396a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f14396a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            e eVar = this.f14397a;
            if (eVar == null) {
                eVar = new e();
                this.f14397a = eVar;
            }
            eVarA = eVar.a(aVar2);
            bVar = bVarA;
            fVar = fVarA;
            cVar = cVarA;
            dVar = dVarA;
            aVar = aVarA;
        }
        if ((j & 160) != 0) {
            CommonBindingAdapter.l0(((WorksHeadSearchHotSpotBinding) this).f14387a, z2);
            CommonBindingAdapter.l0(this.b, z2);
        }
        if ((j & 164) != 0) {
            TextViewBindingAdapter.setText(this.f14399b, str2);
            TextViewBindingAdapter.setText(this.f14400c, popularityValue);
            CommonBindingAdapter.l0(this.f, z3);
        }
        if ((j & 161) != 0) {
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.f14401d, str4);
            TextViewBindingAdapter.setText(this.f14402e, str5);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.c, bVar, null);
            CommonBindingAdapter.q(this.d, cVar, null);
            CommonBindingAdapter.q(this.h, aVar, null);
            CommonBindingAdapter.q(this.i, aVar, null);
            CommonBindingAdapter.q(this.e, fVar, null);
            CommonBindingAdapter.q(this.f, dVar, null);
            CommonBindingAdapter.q(((WorksHeadSearchHotSpotBinding) this).f14385a, eVarA, null);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.l0(this.d, z5);
            TextViewBindingAdapter.setText(this.f14403f, str);
            TextViewBindingAdapter.setText(this.g, str3);
        }
        if ((162 & j) != 0) {
            CommonBindingAdapter.l0(this.h, zSafeUnbox2);
            boolean z7 = zSafeUnbox;
            CommonBindingAdapter.l0(this.i, z7);
            CommonBindingAdapter.l0(((WorksHeadSearchHotSpotBinding) this).f14385a, z7);
            CommonBindingAdapter.l0(((WorksHeadSearchHotSpotBinding) this).f36979a, z7);
        }
        if ((j & 168) != 0) {
            CommonBindingAdapter.l0(this.e, z4);
            TextViewBindingAdapter.setText(this.j, str6);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14391a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14391a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadSearchHotSpotBinding
    public void l(@Nullable SearchHotSpotFragment.a Click) {
        ((WorksHeadSearchHotSpotBinding) this).f14388a = Click;
        synchronized (this) {
            this.f14391a |= 64;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadSearchHotSpotBinding
    public void m(@Nullable SearchHotSpotModel Vm) {
        ((WorksHeadSearchHotSpotBinding) this).f14389a = Vm;
        synchronized (this) {
            this.f14391a |= 32;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<UserActivityInfo> VmActivityInfo, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14391a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmDelHistoryStatus, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14391a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return r((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<SearchHotSpotItemBean> VmFirstHotSpot, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14391a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<SearchHotSpotItemBean> VmSecondHotSpot, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14391a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<SearchHotSpotItemBean> VmThirdHotSpot, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14391a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((SearchHotSpotModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((SearchHotSpotFragment.a) variable);
        }
        return true;
    }

    public WorksHeadSearchHotSpotBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ConstraintLayout) bindings[6], (Flow) bindings[18], (TextView) bindings[3], (View) bindings[4]);
        this.f14391a = -1L;
        ((WorksHeadSearchHotSpotBinding) this).f14387a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14392a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[1];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.f14399b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[11];
        this.f14400c = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[12];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView3 = (TextView) bindings[13];
        this.f14401d = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[14];
        this.f14402e = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[15];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView5 = (TextView) bindings[16];
        this.f14403f = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[17];
        this.g = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) bindings[2];
        this.h = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) bindings[5];
        this.i = textView8;
        textView8.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) bindings[7];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        TextView textView9 = (TextView) bindings[8];
        this.j = textView9;
        textView9.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) bindings[9];
        this.f = linearLayout6;
        linearLayout6.setTag(null);
        ((WorksHeadSearchHotSpotBinding) this).f14385a.setTag(null);
        ((WorksHeadSearchHotSpotBinding) this).f36979a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
