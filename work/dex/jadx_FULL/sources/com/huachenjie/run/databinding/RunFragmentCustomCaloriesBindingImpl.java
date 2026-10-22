package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.page.free.CustomCaloriesFragment;
import com.huachenjie.run.page.free.CustomCaloriesVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFragmentCustomCaloriesBindingImpl extends RunFragmentCustomCaloriesBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11809a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f11812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11814a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((RunFragmentCustomCaloriesBinding) RunFragmentCustomCaloriesBindingImpl.this).f11805a);
            CustomCaloriesVM customCaloriesVM = ((RunFragmentCustomCaloriesBinding) RunFragmentCustomCaloriesBindingImpl.this).f11808a;
            if (customCaloriesVM != null) {
                MutableLiveData<String> mutableLiveData = customCaloriesVM.i;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CustomCaloriesFragment.a f35572a;

        public b a(CustomCaloriesFragment.a value) {
            this.f35572a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35572a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CustomCaloriesFragment.a f35573a;

        public c a(CustomCaloriesFragment.a value) {
            this.f35573a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35573a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35570a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.tv_input_unit, 5);
        sparseIntArray.put(R.id.v_divider, 6);
    }

    public RunFragmentCustomCaloriesBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f11809a, f35570a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f11810a;
            this.f11810a = 0L;
        }
        CustomCaloriesVM customCaloriesVM = ((RunFragmentCustomCaloriesBinding) this).f11808a;
        CustomCaloriesFragment.a aVar = ((RunFragmentCustomCaloriesBinding) this).f11807a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<String> mutableLiveData = customCaloriesVM != null ? customCaloriesVM.i : null;
            updateLiveDataRegistration(0, mutableLiveData);
            if (mutableLiveData != null) {
                value = mutableLiveData.getValue();
            } else {
                value = null;
            }
        }
        long j3 = 12 & j;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f11814a;
            if (cVar == null) {
                cVar = new c();
                this.f11814a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f11813a;
            if (bVar == null) {
                bVar = new b();
                this.f11813a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 8) != 0) {
            CommonBindingAdapter.J(((RunFragmentCustomCaloriesBinding) this).f11805a, 2);
            EditText editText = ((RunFragmentCustomCaloriesBinding) this).f11805a;
            DrawablesBindingAdapter.h(editText, 0, null, ViewDataBinding.getColorFromResource(editText, R.color.color_E8E8E8), 1.0f, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setTextWatcher(((RunFragmentCustomCaloriesBinding) this).f11805a, null, null, null, this.f11812a);
            ConstraintLayout constraintLayout = this.f11811a;
            DrawablesBindingAdapter.h(constraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(constraintLayout, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 14.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((RunFragmentCustomCaloriesBinding) this).f11805a, value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(this.c, cVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11810a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11810a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentCustomCaloriesBinding
    public void l(@Nullable CustomCaloriesFragment.a Click) {
        ((RunFragmentCustomCaloriesBinding) this).f11807a = Click;
        synchronized (this) {
            this.f11810a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentCustomCaloriesBinding
    public void m(@Nullable CustomCaloriesVM MState) {
        ((RunFragmentCustomCaloriesBinding) this).f11808a = MState;
        synchronized (this) {
            this.f11810a |= 2;
        }
        notifyPropertyChanged(lk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> MStateCalories, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11810a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L == variableId) {
            m((CustomCaloriesVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((CustomCaloriesFragment.a) variable);
        }
        return true;
    }

    public RunFragmentCustomCaloriesBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (EditText) bindings[1], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[4], (View) bindings[6]);
        this.f11812a = new a();
        this.f11810a = -1L;
        ((RunFragmentCustomCaloriesBinding) this).f11805a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11811a = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
