package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.account.CancelAccountSubmitVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityCancelAccountSubmitBindingImpl extends ActivityCancelAccountSubmitBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f9067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9071a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityCancelAccountSubmitBindingImpl.this.f9067a);
            CancelAccountSubmitVM cancelAccountSubmitVM = ((ActivityCancelAccountSubmitBinding) ActivityCancelAccountSubmitBindingImpl.this).f34016a;
            if (cancelAccountSubmitVM != null) {
                MutableLiveData<String> mutableLiveDataJ = cancelAccountSubmitVM.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f9065a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f34017a = null;
    }

    public ActivityCancelAccountSubmitBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9065a, f34017a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        String str;
        synchronized (this) {
            j = this.f9066a;
            this.f9066a = 0L;
        }
        CancelAccountSubmitVM cancelAccountSubmitVM = ((ActivityCancelAccountSubmitBinding) this).f34016a;
        if ((15 & j) != 0) {
            if ((j & 13) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataK = cancelAccountSubmitVM != null ? cancelAccountSubmitVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 14) != 0) {
                MutableLiveData<String> mutableLiveDataJ = cancelAccountSubmitVM != null ? cancelAccountSubmitVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                str = String.format("%d/300", Integer.valueOf(value != null ? value.length() : 0));
            } else {
                value = null;
                str = null;
            }
        } else {
            value = null;
            value2 = null;
            str = null;
        }
        if ((13 & j) != 0) {
            this.f9071a.k(value2);
        }
        if ((j & 14) != 0) {
            TextViewBindingAdapter.setText(this.f9067a, value);
            TextViewBindingAdapter.setText(this.f9069a, str);
        }
        if ((j & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.f9067a, null, null, null, this.f9070a);
        }
        ViewDataBinding.executeBindingsOn(this.f9071a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9066a != 0) {
                return true;
            }
            return this.f9071a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9066a = 8L;
        }
        this.f9071a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityCancelAccountSubmitBinding
    public void k(@Nullable CancelAccountSubmitVM cancelAccountSubmitVM) {
        ((ActivityCancelAccountSubmitBinding) this).f34016a = cancelAccountSubmitVM;
        synchronized (this) {
            this.f9066a |= 4;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9066a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9066a |= 1;
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
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9071a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 != i) {
            return false;
        }
        k((CancelAccountSubmitVM) obj);
        return true;
    }

    public ActivityCancelAccountSubmitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f9070a = new a();
        this.f9066a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f9071a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9068a = linearLayout;
        linearLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.f9067a = editText;
        editText.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9069a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
