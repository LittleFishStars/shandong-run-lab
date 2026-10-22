package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.dialog.PublishEntryDialog;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.e0a;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogPublishEntryBindingImpl extends WorksDialogPublishEntryBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14100a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14105a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishEntryDialog.ClickProxy f36874a;

        public a a(PublishEntryDialog.ClickProxy value) {
            this.f36874a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36874a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishEntryDialog.ClickProxy f36875a;

        public b a(PublishEntryDialog.ClickProxy value) {
            this.f36875a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36875a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishEntryDialog.ClickProxy f36876a;

        public c a(PublishEntryDialog.ClickProxy value) {
            this.f36876a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36876a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36873a = sparseIntArray;
        sparseIntArray.put(R.id.iv_close, 5);
        sparseIntArray.put(R.id.iv_video, 6);
    }

    public WorksDialogPublishEntryBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14100a, f36873a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean vipOpenFlag;
        boolean z;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f14101a;
            this.f14101a = 0L;
        }
        PublishEntryDialog.ClickProxy clickProxy = ((WorksDialogPublishEntryBinding) this).f14097a;
        long j2 = 2 & j;
        if (j2 != 0) {
            vipOpenFlag = e0a.d().getVipOpenFlag();
            z = !vipOpenFlag;
        } else {
            vipOpenFlag = false;
            z = false;
        }
        long j3 = j & 3;
        if (j3 == 0 || clickProxy == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f14105a;
            if (cVar == null) {
                cVar = new c();
                this.f14105a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            a aVar = this.f14103a;
            if (aVar == null) {
                aVar = new a();
                this.f14103a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f14104a;
            if (bVar == null) {
                bVar = new b();
                this.f14104a = bVar;
            }
            bVarA = bVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((WorksDialogPublishEntryBinding) this).f14098a, aVarA, null);
            CommonBindingAdapter.q(this.f14102a, bVarA, null);
            CommonBindingAdapter.q(((WorksDialogPublishEntryBinding) this).f14096a, cVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.b, z);
            CommonBindingAdapter.l0(((WorksDialogPublishEntryBinding) this).f14099a, vipOpenFlag);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14101a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14101a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogPublishEntryBinding
    public void k(@Nullable PublishEntryDialog.ClickProxy Click) {
        ((WorksDialogPublishEntryBinding) this).f14097a = Click;
        synchronized (this) {
            this.f14101a |= 1;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.k != variableId) {
            return false;
        }
        k((PublishEntryDialog.ClickProxy) variable);
        return true;
    }

    public WorksDialogPublishEntryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (ImageView) bindings[6], (BLLinearLayout) bindings[4], (RelativeLayout) bindings[1], (BLTextView) bindings[3]);
        this.f14101a = -1L;
        ((WorksDialogPublishEntryBinding) this).f14098a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14102a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.b = bLTextView;
        bLTextView.setTag(null);
        ((WorksDialogPublishEntryBinding) this).f14096a.setTag(null);
        ((WorksDialogPublishEntryBinding) this).f14099a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
