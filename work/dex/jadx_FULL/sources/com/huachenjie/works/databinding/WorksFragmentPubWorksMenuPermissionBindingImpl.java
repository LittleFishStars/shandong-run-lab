package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment;
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionModel;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.e0a;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentPubWorksMenuPermissionBindingImpl extends WorksFragmentPubWorksMenuPermissionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36940a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14287a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f14294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14295a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14296b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14297c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PubWorkMenuPermissionFragment.a f36941a;

        public a a(PubWorkMenuPermissionFragment.a value) {
            this.f36941a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36941a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PubWorkMenuPermissionFragment.a f36942a;

        public b a(PubWorkMenuPermissionFragment.a value) {
            this.f36942a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36942a.b(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PubWorkMenuPermissionFragment.a f36943a;

        public c a(PubWorkMenuPermissionFragment.a value) {
            this.f36943a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36943a.c(arg0);
        }
    }

    public WorksFragmentPubWorksMenuPermissionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, f14287a, f36940a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f14288a;
            this.f14288a = 0L;
        }
        PubWorkMenuPermissionModel pubWorkMenuPermissionModel = ((WorksFragmentPubWorksMenuPermissionBinding) this).f14286a;
        PubWorkMenuPermissionFragment.a aVar = ((WorksFragmentPubWorksMenuPermissionBinding) this).f36939a;
        long j2 = 8 & j;
        boolean z3 = false;
        boolean friendVisitLevel = j2 != 0 ? e0a.d().getFriendVisitLevel() : false;
        long j3 = 11 & j;
        if (j3 != 0) {
            MutableLiveData<Integer> mutableLiveDataJ = pubWorkMenuPermissionModel != null ? pubWorkMenuPermissionModel.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
            boolean z4 = iSafeUnbox == PubWorkMenuPermissionFragment.VISIBLE_TYPE_MINE;
            z2 = iSafeUnbox == PubWorkMenuPermissionFragment.VISIBLE_TYPE_FRIEND;
            z = iSafeUnbox == PubWorkMenuPermissionFragment.VISIBLE_TYPE_PUBLIC;
            z3 = z4;
        } else {
            z = false;
            z2 = false;
        }
        long j4 = j & 12;
        if (j4 == 0 || aVar == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f14293a;
            if (cVar == null) {
                cVar = new c();
                this.f14293a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f14291a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14291a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f14292a;
            if (bVar == null) {
                bVar = new b();
                this.f14292a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.f14290a, cVarA, null);
            CommonBindingAdapter.q(this.f14296b, bVarA, null);
            CommonBindingAdapter.q(this.f14297c, aVarA, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f14289a, z);
            CommonBindingAdapter.l0(this.b, z3);
            CommonBindingAdapter.l0(this.c, z2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f14294a, friendVisitLevel);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14288a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14288a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPubWorksMenuPermissionBinding
    public void l(@Nullable PubWorkMenuPermissionFragment.a Click) {
        ((WorksFragmentPubWorksMenuPermissionBinding) this).f36939a = Click;
        synchronized (this) {
            this.f14288a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPubWorksMenuPermissionBinding
    public void m(@Nullable PubWorkMenuPermissionModel Vm) {
        ((WorksFragmentPubWorksMenuPermissionBinding) this).f14286a = Vm;
        synchronized (this) {
            this.f14288a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmVisibleType, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14288a |= 1;
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
            m((PubWorkMenuPermissionModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PubWorkMenuPermissionFragment.a) variable);
        }
        return true;
    }

    public WorksFragmentPubWorksMenuPermissionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f14288a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14295a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f14290a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.f14289a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.f14296b = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.b = imageView2;
        imageView2.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) bindings[5];
        this.f14294a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView3 = (TextView) bindings[6];
        this.f14297c = textView3;
        textView3.setTag(null);
        ImageView imageView3 = (ImageView) bindings[7];
        this.c = imageView3;
        imageView3.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
