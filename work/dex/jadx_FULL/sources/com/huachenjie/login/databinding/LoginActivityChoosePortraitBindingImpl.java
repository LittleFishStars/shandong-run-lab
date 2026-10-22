package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.page.info.portrait.ChoosePortraitActivity;
import com.huachenjie.login.page.info.portrait.ChoosePortraitAdapter;
import com.huachenjie.login.page.info.portrait.ChoosePortraitVM;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityChoosePortraitBindingImpl extends LoginActivityChoosePortraitBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34623a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9939a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9949a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChoosePortraitActivity.ClickProxy f34624a;

        public a a(ChoosePortraitActivity.ClickProxy clickProxy) {
            this.f34624a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34624a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChoosePortraitActivity.ClickProxy f34625a;

        public b a(ChoosePortraitActivity.ClickProxy clickProxy) {
            this.f34625a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34625a.e(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChoosePortraitActivity.ClickProxy f34626a;

        public c a(ChoosePortraitActivity.ClickProxy clickProxy) {
            this.f34626a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34626a.c(view);
        }
    }

    public LoginActivityChoosePortraitBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9939a, f34623a));
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00b1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String str;
        boolean z;
        boolean z2;
        ChoosePortraitAdapter value2;
        RequestOptions avatarOptions;
        boolean z3;
        int i;
        int i2;
        c cVarA;
        a aVarA;
        b bVarA;
        boolean z4;
        int iSafeUnbox;
        int iSafeUnbox2;
        MutableLiveData<String> mutableLiveDataL;
        synchronized (this) {
            j = this.f9940a;
            this.f9940a = 0L;
        }
        ChoosePortraitVM choosePortraitVM = ((LoginActivityChoosePortraitBinding) this).f9938a;
        ChoosePortraitActivity.ClickProxy clickProxy = ((LoginActivityChoosePortraitBinding) this).f34622a;
        if ((95 & j) != 0) {
            long j2 = j & 81;
            if (j2 != 0) {
                MutableLiveData<Integer> mutableLiveDataN = choosePortraitVM != null ? choosePortraitVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                z4 = iSafeUnbox3 >= -1;
                z = iSafeUnbox3 == -1;
                if (j2 != 0) {
                    j |= z4 ? 256L : 128L;
                }
                str = z4 ? "#0BD3FF" : "#FFFFFF";
            } else {
                str = null;
                z = false;
                z4 = false;
            }
            if ((j & 84) != 0) {
                BaseViewModel.b bVarE = choosePortraitVM != null ? choosePortraitVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox + 16));
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            if ((j & 82) == 0) {
                value2 = null;
            } else {
                MutableLiveData<ChoosePortraitAdapter> mutableLiveDataM = choosePortraitVM != null ? choosePortraitVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value2 = mutableLiveDataM.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 88) != 0) {
                if (choosePortraitVM != null) {
                    avatarOptions = choosePortraitVM.getAvatarOptions();
                    mutableLiveDataL = choosePortraitVM.l();
                } else {
                    mutableLiveDataL = null;
                    avatarOptions = null;
                }
                updateLiveDataRegistration(3, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                z3 = value == null;
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
                z2 = z4;
            } else {
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
                z2 = z4;
                value = null;
                avatarOptions = null;
                z3 = false;
            }
        } else {
            value = null;
            str = null;
            z = false;
            z2 = false;
            value2 = null;
            avatarOptions = null;
            z3 = false;
            i = 0;
            i2 = 0;
        }
        long j3 = j & 96;
        if (j3 == 0 || clickProxy == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f9948a;
            if (cVar == null) {
                cVar = new c();
                this.f9948a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            a aVar = this.f9946a;
            if (aVar == null) {
                aVar = new a();
                this.f9946a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f9947a;
            if (bVar == null) {
                bVar = new b();
                this.f9947a = bVar;
            }
            bVarA = bVar.a(clickProxy);
        }
        if ((84 & j) != 0) {
            CommonBindingAdapter.I(this.f9943a, 0, i2, 0, 0, null);
            CommonBindingAdapter.I(this.d, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f9949a, aVarA, null);
            CommonBindingAdapter.q(this.f9944a, bVarA, null);
            CommonBindingAdapter.q(this.d, cVarA, null);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.l0(this.f9942a, z3);
            CommonBindingAdapter.b0(this.b, value, avatarOptions, false);
        }
        if ((81 & j) != 0) {
            CommonBindingAdapter.l0(this.c, z);
            CommonBindingAdapter.e0(this.f9944a, z2);
            CommonBindingAdapter.W(this.f9944a, str);
        }
        if ((j & 82) != 0) {
            CommonBindingAdapter.g(this.f9945a, value2, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9940a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9940a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChoosePortraitBinding
    public void l(@Nullable ChoosePortraitActivity.ClickProxy clickProxy) {
        ((LoginActivityChoosePortraitBinding) this).f34622a = clickProxy;
        synchronized (this) {
            this.f9940a |= 32;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChoosePortraitBinding
    public void m(@Nullable ChoosePortraitVM choosePortraitVM) {
        ((LoginActivityChoosePortraitBinding) this).f9938a = choosePortraitVM;
        synchronized (this) {
            this.f9940a |= 16;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9940a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ChoosePortraitAdapter> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9940a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9940a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9940a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((ChoosePortraitVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((ChoosePortraitActivity.ClickProxy) obj);
        }
        return true;
    }

    public LoginActivityChoosePortraitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4);
        this.f9940a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9941a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f9943a = linearLayout;
        linearLayout.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[2];
        this.f9949a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f9942a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.b = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[5];
        this.c = imageView3;
        imageView3.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[6];
        this.f9945a = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.f9944a = textView;
        textView.setTag(null);
        ImageView imageView4 = (ImageView) objArr[8];
        this.d = imageView4;
        imageView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
