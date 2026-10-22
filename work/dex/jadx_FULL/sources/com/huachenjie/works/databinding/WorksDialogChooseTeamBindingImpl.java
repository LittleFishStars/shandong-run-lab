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
import com.huachenjie.works.page.share.choose_team.ChooseTeamAdapter;
import com.huachenjie.works.page.share.choose_team.ChooseTeamDialog;
import com.huachenjie.works.page.share.choose_team.ChooseTeamVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogChooseTeamBindingImpl extends WorksDialogChooseTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14038a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14042a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseTeamDialog.a f36846a;

        public a a(ChooseTeamDialog.a value) {
            this.f36846a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36846a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36845a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public WorksDialogChooseTeamBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14038a, f36845a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ChooseTeamAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f14039a;
            this.f14039a = 0L;
        }
        ChooseTeamVM chooseTeamVM = ((WorksDialogChooseTeamBinding) this).f14037a;
        ChooseTeamDialog.a aVar = ((WorksDialogChooseTeamBinding) this).f14036a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<ChooseTeamAdapter> mutableLiveDataJ = chooseTeamVM != null ? chooseTeamVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14042a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14042a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14041a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((WorksDialogChooseTeamBinding) this).f14035a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14039a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14039a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogChooseTeamBinding
    public void l(@Nullable ChooseTeamDialog.a Click) {
        ((WorksDialogChooseTeamBinding) this).f14036a = Click;
        synchronized (this) {
            this.f14039a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogChooseTeamBinding
    public void m(@Nullable ChooseTeamVM Vm) {
        ((WorksDialogChooseTeamBinding) this).f14037a = Vm;
        synchronized (this) {
            this.f14039a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ChooseTeamAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14039a |= 1;
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
            m((ChooseTeamVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((ChooseTeamDialog.a) variable);
        }
        return true;
    }

    public WorksDialogChooseTeamBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[2], (TextView) bindings[3]);
        this.f14039a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14040a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14041a = imageView;
        imageView.setTag(null);
        ((WorksDialogChooseTeamBinding) this).f14035a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
