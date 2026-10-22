package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendAdapter;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogChooseFriendBindingImpl extends WorksDialogChooseFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14030a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14034a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseFriendDialog.a f36843a;

        public a a(ChooseFriendDialog.a value) {
            this.f36843a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36843a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36842a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public WorksDialogChooseFriendBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14030a, f36842a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ChooseFriendAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f14031a;
            this.f14031a = 0L;
        }
        ChooseFriendVM chooseFriendVM = ((WorksDialogChooseFriendBinding) this).f14029a;
        ChooseFriendDialog.a aVar = ((WorksDialogChooseFriendBinding) this).f14028a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<ChooseFriendAdapter> mutableLiveDataL = chooseFriendVM != null ? chooseFriendVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            if (mutableLiveDataL != null) {
                value = mutableLiveDataL.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14034a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14034a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14033a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((WorksDialogChooseFriendBinding) this).f14027a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14031a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14031a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogChooseFriendBinding
    public void l(@Nullable ChooseFriendDialog.a Click) {
        ((WorksDialogChooseFriendBinding) this).f14028a = Click;
        synchronized (this) {
            this.f14031a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogChooseFriendBinding
    public void m(@Nullable ChooseFriendVM Vm) {
        ((WorksDialogChooseFriendBinding) this).f14029a = Vm;
        synchronized (this) {
            this.f14031a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ChooseFriendAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14031a |= 1;
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
            m((ChooseFriendVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((ChooseFriendDialog.a) variable);
        }
        return true;
    }

    public WorksDialogChooseFriendBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[2], (TextView) bindings[3]);
        this.f14031a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14032a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14033a = imageView;
        imageView.setTag(null);
        ((WorksDialogChooseFriendBinding) this).f14027a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
