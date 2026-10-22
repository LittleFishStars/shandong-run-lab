package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.page.post.PublishPostVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemFooterPublishPostBindingImpl extends WorksItemFooterPublishPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37032a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14574a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f14577a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((WorksItemFooterPublishPostBinding) WorksItemFooterPublishPostBindingImpl.this).f37031a);
            PublishPostVM publishPostVM = ((WorksItemFooterPublishPostBinding) WorksItemFooterPublishPostBindingImpl.this).f14573a;
            if (publishPostVM != null) {
                MutableLiveData<String> mutableLiveDataR = publishPostVM.r();
                if (mutableLiveDataR != null) {
                    mutableLiveDataR.setValue(textString);
                }
            }
        }
    }

    public WorksItemFooterPublishPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14574a, f37032a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        synchronized (this) {
            j = this.f14575a;
            this.f14575a = 0L;
        }
        PublishPostVM publishPostVM = ((WorksItemFooterPublishPostBinding) this).f14573a;
        long j2 = 7 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<String> mutableLiveDataR = publishPostVM != null ? publishPostVM.r() : null;
            updateLiveDataRegistration(0, mutableLiveDataR);
            if (mutableLiveDataR != null) {
                value = mutableLiveDataR.getValue();
            } else {
                value = null;
            }
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((WorksItemFooterPublishPostBinding) this).f37031a, value);
        }
        if ((j & 4) != 0) {
            TextViewBindingAdapter.setTextWatcher(((WorksItemFooterPublishPostBinding) this).f37031a, null, null, null, this.f14577a);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14575a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14575a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemFooterPublishPostBinding
    public void k(@Nullable PublishPostVM Vm) {
        ((WorksItemFooterPublishPostBinding) this).f14573a = Vm;
        synchronized (this) {
            this.f14575a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> VmRedPackNum, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14575a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((PublishPostVM) variable);
        return true;
    }

    public WorksItemFooterPublishPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (EditText) bindings[1]);
        this.f14577a = new a();
        this.f14575a = -1L;
        ((WorksItemFooterPublishPostBinding) this).f37031a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14576a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
