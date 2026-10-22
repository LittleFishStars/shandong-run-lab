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
import com.huachenjie.works.R;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.huachenjie.works.page.post.PublishPostVM;
import com.huachenjie.works.widget.select_media.SelectGridMediaView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemHeaderPublishPostBindingImpl extends WorksItemHeaderPublishPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14588a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f14591a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((WorksItemHeaderPublishPostBinding) WorksItemHeaderPublishPostBindingImpl.this).f37036a);
            PublishPostVM publishPostVM = ((WorksItemHeaderPublishPostBinding) WorksItemHeaderPublishPostBindingImpl.this).f14586a;
            if (publishPostVM != null) {
                MutableLiveData<String> mutableLiveDataO = publishPostVM.o();
                if (mutableLiveDataO != null) {
                    mutableLiveDataO.setValue(textString);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37037a = sparseIntArray;
        sparseIntArray.put(R.id.view_select_media, 2);
    }

    public WorksItemHeaderPublishPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14588a, f37037a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        synchronized (this) {
            j = this.f14589a;
            this.f14589a = 0L;
        }
        PublishPostVM publishPostVM = ((WorksItemHeaderPublishPostBinding) this).f14586a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<String> mutableLiveDataO = publishPostVM != null ? publishPostVM.o() : null;
            updateLiveDataRegistration(0, mutableLiveDataO);
            if (mutableLiveDataO != null) {
                value = mutableLiveDataO.getValue();
            } else {
                value = null;
            }
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((WorksItemHeaderPublishPostBinding) this).f37036a, value);
        }
        if ((j & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(((WorksItemHeaderPublishPostBinding) this).f37036a, null, null, null, this.f14591a);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14589a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14589a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemHeaderPublishPostBinding
    public void l(@Nullable PublishPostActivity.a Click) {
        ((WorksItemHeaderPublishPostBinding) this).f14585a = Click;
    }

    @Override // com.huachenjie.works.databinding.WorksItemHeaderPublishPostBinding
    public void m(@Nullable PublishPostVM Vm) {
        ((WorksItemHeaderPublishPostBinding) this).f14586a = Vm;
        synchronized (this) {
            this.f14589a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmContent, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14589a |= 1;
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
        if (qk0.p0 == variableId) {
            m((PublishPostVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PublishPostActivity.a) variable);
        }
        return true;
    }

    public WorksItemHeaderPublishPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (EditText) bindings[1], (SelectGridMediaView) bindings[2]);
        this.f14591a = new a();
        this.f14589a = -1L;
        ((WorksItemHeaderPublishPostBinding) this).f37036a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14590a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
