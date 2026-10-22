package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.school.JoinChannelTipDialog;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogJoinChannelTipBindingImpl extends WorksDialogJoinChannelTipBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14090a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14095a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JoinChannelTipDialog.a f36870a;

        public a a(JoinChannelTipDialog.a value) {
            this.f36870a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36870a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JoinChannelTipDialog.a f36871a;

        public b a(JoinChannelTipDialog.a value) {
            this.f36871a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36871a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36869a = sparseIntArray;
        sparseIntArray.put(R.id.iv_header, 2);
        sparseIntArray.put(R.id.v_center, 3);
    }

    public WorksDialogJoinChannelTipBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14090a, f36869a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f14091a;
            this.f14091a = 0L;
        }
        JoinChannelTipDialog.a aVar = ((WorksDialogJoinChannelTipBinding) this).f14088a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f14094a;
            if (bVar == null) {
                bVar = new b();
                this.f14094a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f14093a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14093a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14092a, bVarA, null);
            CommonBindingAdapter.q(this.f14095a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14091a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14091a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogJoinChannelTipBinding
    public void k(@Nullable JoinChannelTipDialog.a Click) {
        ((WorksDialogJoinChannelTipBinding) this).f14088a = Click;
        synchronized (this) {
            this.f14091a |= 1;
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
        k((JoinChannelTipDialog.a) variable);
        return true;
    }

    public WorksDialogJoinChannelTipBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[2], (BLView) bindings[3]);
        this.f14091a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14092a = frameLayout;
        frameLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[1];
        this.f14095a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
