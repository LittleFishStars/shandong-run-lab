package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.page.comment.report.CommentOptDialog;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogCommentOptBindingImpl extends WorksDialogCommentOptBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36861a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14071a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14076a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentOptDialog.a f36862a;

        public a a(CommentOptDialog.a value) {
            this.f36862a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36862a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentOptDialog.a f36863a;

        public b a(CommentOptDialog.a value) {
            this.f36863a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36863a.d(arg0);
        }
    }

    public WorksDialogCommentOptBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14071a, f36861a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f14072a;
            this.f14072a = 0L;
        }
        Boolean bool = ((WorksDialogCommentOptBinding) this).f14070a;
        CommentOptDialog.a aVar = ((WorksDialogCommentOptBinding) this).f36860a;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = j & 6;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f14074a;
            if (bVar == null) {
                bVar = new b();
                this.f14074a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f14073a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14073a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f14076a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14076a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14072a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14072a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogCommentOptBinding
    public void l(@Nullable CommentOptDialog.a Click) {
        ((WorksDialogCommentOptBinding) this).f36860a = Click;
        synchronized (this) {
            this.f14072a |= 2;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogCommentOptBinding
    public void m(@Nullable Boolean IsSelf) {
        ((WorksDialogCommentOptBinding) this).f14070a = IsSelf;
        synchronized (this) {
            this.f14072a |= 1;
        }
        notifyPropertyChanged(qk0.G);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.G == variableId) {
            m((Boolean) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((CommentOptDialog.a) variable);
        }
        return true;
    }

    public WorksDialogCommentOptBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14072a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14075a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[1];
        this.f14076a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[2];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
