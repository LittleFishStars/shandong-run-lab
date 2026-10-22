package com.huachenjie.social_contact.databinding;

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
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendAdapter;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogShareEmojiFriendBindingImpl extends DialogShareEmojiFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12915a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12921a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareEmojiFriendDialog.a f36159a;

        public a a(ShareEmojiFriendDialog.a aVar) {
            this.f36159a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36159a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareEmojiFriendDialog.a f36160a;

        public b a(ShareEmojiFriendDialog.a aVar) {
            this.f36160a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36160a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36158a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
    }

    public DialogShareEmojiFriendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12915a, f36158a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ShareEmojiFriendAdapter value;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f12916a;
            this.f12916a = 0L;
        }
        ShareEmojiFriendVM shareEmojiFriendVM = ((DialogShareEmojiFriendBinding) this).f12914a;
        ShareEmojiFriendDialog.a aVar = ((DialogShareEmojiFriendBinding) this).f12913a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<ShareEmojiFriendAdapter> mutableLiveDataI = shareEmojiFriendVM != null ? shareEmojiFriendVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f12920a;
            if (bVar == null) {
                bVar = new b();
                this.f12920a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12919a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12919a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f12917a, bVarA, null);
            CommonBindingAdapter.q(this.f12921a, aVarA, null);
            CommonBindingAdapter.q(this.f12918a, bVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((DialogShareEmojiFriendBinding) this).f12912a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12916a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12916a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogShareEmojiFriendBinding
    public void l(@Nullable ShareEmojiFriendDialog.a aVar) {
        ((DialogShareEmojiFriendBinding) this).f12913a = aVar;
        synchronized (this) {
            this.f12916a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogShareEmojiFriendBinding
    public void m(@Nullable ShareEmojiFriendVM shareEmojiFriendVM) {
        ((DialogShareEmojiFriendBinding) this).f12914a = shareEmojiFriendVM;
        synchronized (this) {
            this.f12916a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ShareEmojiFriendAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12916a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((ShareEmojiFriendVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((ShareEmojiFriendDialog.a) obj);
        }
        return true;
    }

    public DialogShareEmojiFriendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[3], (TextView) objArr[4]);
        this.f12916a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12917a = frameLayout;
        frameLayout.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[1];
        this.f12921a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f12918a = imageView;
        imageView.setTag(null);
        ((DialogShareEmojiFriendBinding) this).f12912a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
