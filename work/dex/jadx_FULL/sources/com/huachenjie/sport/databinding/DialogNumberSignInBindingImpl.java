package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.ClearFocusConstraintLayout;
import com.huachenjie.common.widget.PinEntryEditText;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.signin.NumberSignInDialog;
import com.huachenjie.sport.page.mine.signin.NumberSignInVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogNumberSignInBindingImpl extends DialogNumberSignInBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13406a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f13408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ClearFocusConstraintLayout f13409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13410a;

    @NonNull
    public final TextView c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((DialogNumberSignInBinding) DialogNumberSignInBindingImpl.this).f13403a);
            NumberSignInVM numberSignInVM = ((DialogNumberSignInBinding) DialogNumberSignInBindingImpl.this).f13405a;
            if (numberSignInVM != null) {
                MutableLiveData<String> mutableLiveData = numberSignInVM.i;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NumberSignInDialog.c f36453a;

        public b a(NumberSignInDialog.c cVar) {
            this.f36453a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36453a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36451a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.tv_tip, 4);
    }

    public DialogNumberSignInBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13406a, f36451a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String value;
        b bVarA;
        synchronized (this) {
            j = this.f13407a;
            this.f13407a = 0L;
        }
        NumberSignInVM numberSignInVM = ((DialogNumberSignInBinding) this).f13405a;
        NumberSignInDialog.c cVar = ((DialogNumberSignInBinding) this).f13404a;
        long j2 = 11 & j;
        if (j2 != 0) {
            MutableLiveData<String> mutableLiveData = numberSignInVM != null ? numberSignInVM.i : null;
            updateLiveDataRegistration(0, mutableLiveData);
            value = mutableLiveData != null ? mutableLiveData.getValue() : null;
            z = (value != null ? value.length() : 0) >= 4;
        } else {
            z = false;
            value = null;
        }
        long j3 = 12 & j;
        if (j3 == 0 || cVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f13410a;
            if (bVar == null) {
                bVar = new b();
                this.f13410a = bVar;
            }
            bVarA = bVar.a(cVar);
        }
        if ((j & 8) != 0) {
            ClearFocusConstraintLayout clearFocusConstraintLayout = this.f13409a;
            DrawablesBindingAdapter.h(clearFocusConstraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(clearFocusConstraintLayout, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView = this.c;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(this.c, R.color.color_898fa2)), 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.k(((DialogNumberSignInBinding) this).f13403a, false);
            TextViewBindingAdapter.setTextWatcher(((DialogNumberSignInBinding) this).f13403a, null, null, null, this.f13408a);
        }
        if (j2 != 0) {
            CommonBindingAdapter.e0(this.c, z);
            TextViewBindingAdapter.setText(((DialogNumberSignInBinding) this).f13403a, value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.c, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13407a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13407a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogNumberSignInBinding
    public void l(@Nullable NumberSignInDialog.c cVar) {
        ((DialogNumberSignInBinding) this).f13404a = cVar;
        synchronized (this) {
            this.f13407a |= 4;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogNumberSignInBinding
    public void m(@Nullable NumberSignInVM numberSignInVM) {
        ((DialogNumberSignInBinding) this).f13405a = numberSignInVM;
        synchronized (this) {
            this.f13407a |= 2;
        }
        notifyPropertyChanged(ok0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13407a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.L == i) {
            m((NumberSignInVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((NumberSignInDialog.c) obj);
        }
        return true;
    }

    public DialogNumberSignInBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (PinEntryEditText) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.f13408a = new a();
        this.f13407a = -1L;
        ClearFocusConstraintLayout clearFocusConstraintLayout = (ClearFocusConstraintLayout) objArr[0];
        this.f13409a = clearFocusConstraintLayout;
        clearFocusConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.c = textView;
        textView.setTag(null);
        ((DialogNumberSignInBinding) this).f13403a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
