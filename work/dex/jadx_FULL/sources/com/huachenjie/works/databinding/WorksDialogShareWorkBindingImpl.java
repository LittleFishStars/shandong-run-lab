package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.page.share.ShareWorksDialog;
import com.huachenjie.works.page.share.ShareWorksVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogShareWorkBindingImpl extends WorksDialogShareWorkBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14124a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f14129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f14130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f14131a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareWorksDialog.a f36882a;

        public a a(ShareWorksDialog.a value) {
            this.f36882a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36882a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareWorksDialog.a f36883a;

        public b a(ShareWorksDialog.a value) {
            this.f36883a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36883a.b(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareWorksDialog.a f36884a;

        public c a(ShareWorksDialog.a value) {
            this.f36884a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36884a.d(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareWorksDialog.a f36885a;

        public d a(ShareWorksDialog.a value) {
            this.f36885a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36885a.a(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareWorksDialog.a f36886a;

        public e a(ShareWorksDialog.a value) {
            this.f36886a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36886a.e(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36881a = sparseIntArray;
        sparseIntArray.put(R.id.iv_share_to_wechat, 10);
        sparseIntArray.put(R.id.tv_share_to_wechat, 11);
        sparseIntArray.put(R.id.iv_share_to_moments, 12);
        sparseIntArray.put(R.id.tv_share_to_moments, 13);
        sparseIntArray.put(R.id.iv_share_to_qq, 14);
        sparseIntArray.put(R.id.tv_share_to_qq, 15);
        sparseIntArray.put(R.id.iv_share_to_sina, 16);
        sparseIntArray.put(R.id.tv_share_to_sina, 17);
    }

    public WorksDialogShareWorkBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 18, f14124a, f36881a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        e eVarA;
        a aVarA;
        d dVarA;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f14125a;
            this.f14125a = 0L;
        }
        ShareWorksDialog.a aVar = ((WorksDialogShareWorkBinding) this).f14114a;
        long j2 = j & 6;
        if (j2 == 0 || aVar == null) {
            eVarA = null;
            aVarA = null;
            dVarA = null;
            bVarA = null;
            cVarA = null;
        } else {
            e eVar = this.f14130a;
            if (eVar == null) {
                eVar = new e();
                this.f14130a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f14126a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14126a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f14127a;
            if (bVar == null) {
                bVar = new b();
                this.f14127a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f14128a;
            if (cVar == null) {
                cVar = new c();
                this.f14128a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f14129a;
            if (dVar == null) {
                dVar = new d();
                this.f14129a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f36880a, cVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).b, bVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).c, aVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).g, eVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f14116a, dVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f14113a, cVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f14117b, bVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f14118c, aVarA, null);
            CommonBindingAdapter.q(((WorksDialogShareWorkBinding) this).f14122g, eVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14125a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14125a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogShareWorkBinding
    public void l(@Nullable ShareWorksDialog.a Click) {
        ((WorksDialogShareWorkBinding) this).f14114a = Click;
        synchronized (this) {
            this.f14125a |= 2;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogShareWorkBinding
    public void m(@Nullable ShareWorksVM Vm) {
        ((WorksDialogShareWorkBinding) this).f14115a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((ShareWorksVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((ShareWorksDialog.a) variable);
        }
        return true;
    }

    public WorksDialogShareWorkBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (ImageView) bindings[1], (ImageView) bindings[7], (ImageView) bindings[12], (ImageView) bindings[14], (ImageView) bindings[16], (ImageView) bindings[3], (ImageView) bindings[10], (BLTextView) bindings[9], (TextView) bindings[6], (TextView) bindings[2], (TextView) bindings[8], (TextView) bindings[13], (TextView) bindings[15], (TextView) bindings[17], (TextView) bindings[4], (TextView) bindings[11]);
        this.f14125a = -1L;
        ((WorksDialogShareWorkBinding) this).f36880a.setTag(null);
        ((WorksDialogShareWorkBinding) this).b.setTag("saveToFriend");
        ((WorksDialogShareWorkBinding) this).c.setTag(null);
        ((WorksDialogShareWorkBinding) this).g.setTag("saveToFriend");
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f14131a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((WorksDialogShareWorkBinding) this).f14116a.setTag(null);
        ((WorksDialogShareWorkBinding) this).f14113a.setTag(null);
        ((WorksDialogShareWorkBinding) this).f14117b.setTag("saveToFriend");
        ((WorksDialogShareWorkBinding) this).f14118c.setTag(null);
        ((WorksDialogShareWorkBinding) this).f14122g.setTag("saveToFriend");
        setRootTag(root);
        invalidateAll();
    }
}
