package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSearchActivity;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSearchVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityPeClassesSearchBindingImpl extends ActivityPeClassesSearchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36421a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13320a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f13325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13327a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityPeClassesSearchBinding) ActivityPeClassesSearchBindingImpl.this).f13316a);
            PEClassesSearchVM pEClassesSearchVM = ((ActivityPeClassesSearchBinding) ActivityPeClassesSearchBindingImpl.this).f13319a;
            if (pEClassesSearchVM != null) {
                MutableLiveData<String> mutableLiveDataH = pEClassesSearchVM.h();
                if (mutableLiveDataH != null) {
                    mutableLiveDataH.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PEClassesSearchActivity.a f36423a;

        public b a(PEClassesSearchActivity.a aVar) {
            this.f36423a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36423a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PEClassesSearchActivity.a f36424a;

        public c a(PEClassesSearchActivity.a aVar) {
            this.f36424a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36424a.b(view);
        }
    }

    public ActivityPeClassesSearchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13320a, f36421a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f13321a;
            this.f13321a = 0L;
        }
        PEClassesSearchVM pEClassesSearchVM = ((ActivityPeClassesSearchBinding) this).f13319a;
        PEClassesSearchActivity.a aVar = ((ActivityPeClassesSearchBinding) this).f13318a;
        int iSafeUnbox = 0;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataH = pEClassesSearchVM != null ? pEClassesSearchVM.h() : null;
                updateLiveDataRegistration(0, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value = mutableLiveDataH.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<Integer> mutableLiveData = pEClassesSearchVM != null ? pEClassesSearchVM.b : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            }
        } else {
            value = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f13327a;
            if (cVar == null) {
                cVar = new c();
                this.f13327a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f13326a;
            if (bVar == null) {
                bVar = new b();
                this.f13326a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((16 & j) != 0) {
            CommonBindingAdapter.k(((ActivityPeClassesSearchBinding) this).f13316a, true);
            TextViewBindingAdapter.setTextWatcher(((ActivityPeClassesSearchBinding) this).f13316a, null, null, null, this.f13325a);
            LinearLayoutCompat linearLayoutCompat = this.f13323a;
            DrawablesBindingAdapter.h(linearLayoutCompat, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 14.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView = this.f13322a;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(((ActivityPeClassesSearchBinding) this).f13316a, value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityPeClassesSearchBinding) this).f13317a, bVarA, null);
            CommonBindingAdapter.q(this.f13322a, cVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.G(((ActivityPeClassesSearchBinding) this).f36420a, iSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13321a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13321a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityPeClassesSearchBinding
    public void l(@Nullable PEClassesSearchActivity.a aVar) {
        ((ActivityPeClassesSearchBinding) this).f13318a = aVar;
        synchronized (this) {
            this.f13321a |= 8;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityPeClassesSearchBinding
    public void m(@Nullable PEClassesSearchVM pEClassesSearchVM) {
        ((ActivityPeClassesSearchBinding) this).f13319a = pEClassesSearchVM;
        synchronized (this) {
            this.f13321a |= 4;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13321a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13321a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((PEClassesSearchVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((PEClassesSearchActivity.a) obj);
        }
        return true;
    }

    public ActivityPeClassesSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (EditText) objArr[4], (ImageView) objArr[2], (View) objArr[1]);
        this.f13325a = new a();
        this.f13321a = -1L;
        ((ActivityPeClassesSearchBinding) this).f13316a.setTag(null);
        ((ActivityPeClassesSearchBinding) this).f13317a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13324a = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[3];
        this.f13323a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f13322a = textView;
        textView.setTag(null);
        ((ActivityPeClassesSearchBinding) this).f36420a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
