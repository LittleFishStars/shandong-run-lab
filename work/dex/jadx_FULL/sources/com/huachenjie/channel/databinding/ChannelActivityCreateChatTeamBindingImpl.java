package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity;
import com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityCreateChatTeamBindingImpl extends ChannelActivityCreateChatTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f7489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7496a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateChatTeamActivity.ClickProxy f33059a;

        public a a(CreateChatTeamActivity.ClickProxy clickProxy) {
            this.f33059a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33059a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateChatTeamActivity.ClickProxy f33060a;

        public b a(CreateChatTeamActivity.ClickProxy clickProxy) {
            this.f33060a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33060a.c(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateChatTeamActivity.ClickProxy f33061a;

        public c a(CreateChatTeamActivity.ClickProxy clickProxy) {
            this.f33061a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33061a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f7485a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{9}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33058a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.v_line, 10);
    }

    public ChannelActivityCreateChatTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f7485a, f33058a));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String logoUrl;
        boolean z;
        String teamTitle;
        boolean z2;
        BindingTitleBean value;
        int i;
        int i2;
        b bVarA;
        c cVar;
        a aVar;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean z3;
        int i3;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f7486a;
            this.f7486a = 0L;
        }
        CreateChatTeamVM createChatTeamVM = ((ChannelActivityCreateChatTeamBinding) this).f7481a;
        String str = this.f;
        CreateChatTeamActivity.ClickProxy clickProxy = ((ChannelActivityCreateChatTeamBinding) this).f7480a;
        Boolean bool = ((ChannelActivityCreateChatTeamBinding) this).f7484a;
        if ((285 & j) != 0) {
            long j2 = j & 273;
            if (j2 != 0) {
                BaseViewModel.b bVarE = createChatTeamVM != null ? createChatTeamVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                boolean z4 = iSafeUnbox > 0;
                if (j2 != 0) {
                    j |= z4 ? 1024L : 512L;
                }
                i3 = z4 ? 12 : 30;
            } else {
                i3 = 0;
                iSafeUnbox = 0;
            }
            if ((j & 276) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataP = createChatTeamVM != null ? createChatTeamVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                } else {
                    value = null;
                }
            }
            long j3 = j & 280;
            if (j3 != 0) {
                MutableLiveData<MyChannelChatTeam> mutableLiveDataM = createChatTeamVM != null ? createChatTeamVM.m() : null;
                updateLiveDataRegistration(3, mutableLiveDataM);
                MyChannelChatTeam value2 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                if (value2 != null) {
                    teamTitle = value2.getTeamTitle();
                    logoUrl = value2.getLogoUrl();
                } else {
                    logoUrl = null;
                    teamTitle = null;
                }
                boolean zIsEmpty = TextUtils.isEmpty(logoUrl);
                boolean z5 = !zIsEmpty;
                if (j3 != 0) {
                    j = z5 ? j | 4096 : j | 2048;
                }
                i = i3;
                i2 = iSafeUnbox;
                z = zIsEmpty;
                z2 = z5;
            } else {
                i = i3;
                i2 = iSafeUnbox;
                logoUrl = null;
                z = false;
                teamTitle = null;
                z2 = false;
            }
        } else {
            logoUrl = null;
            z = false;
            teamTitle = null;
            z2 = false;
            value = null;
            i = 0;
            i2 = 0;
        }
        long j4 = j & 288;
        long j5 = 280 & j;
        RequestOptions requestOptions = j5 != 0 ? ju3.d : null;
        long j6 = j & 320;
        if (j6 == 0 || clickProxy == null) {
            bVarA = null;
            cVar = null;
            aVar = null;
        } else {
            c cVar2 = this.f7493a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f7493a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            a aVar2 = this.f7491a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7491a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar = this.f7492a;
            if (bVar == null) {
                bVar = new b();
                this.f7492a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            aVar = aVarA;
            cVar = cVarA;
        }
        long j7 = j & 384;
        if (j7 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
        }
        boolean z6 = (j & 4096) != 0 ? !TextUtils.isEmpty(teamTitle) : false;
        if (j5 != 0) {
            if (!z2) {
                z6 = false;
            }
            z3 = z6;
        } else {
            z3 = false;
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityCreateChatTeamBinding) this).f7479a, teamTitle);
            CommonBindingAdapter.l0(this.f7487a, z2);
            CommonBindingAdapter.b0(this.f7488a, logoUrl, requestOptions, false);
            CommonBindingAdapter.l0(this.f7495a, z);
            CommonBindingAdapter.e0(this.f7494a, z3);
        }
        if (j7 != 0) {
            CommonBindingAdapter.l0(this.f7490a, zSafeUnbox);
            CommonBindingAdapter.l0(this.f7496a, zSafeUnbox2);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(this.f7490a, aVar, null);
            CommonBindingAdapter.q(this.f7487a, bVarA, null);
            CommonBindingAdapter.q(this.f7495a, bVarA, null);
            CommonBindingAdapter.q(this.f7494a, cVar, null);
        }
        if (j4 != 0) {
            TextViewBindingAdapter.setText(this.f7496a, str);
        }
        if ((j & 273) != 0) {
            CommonBindingAdapter.I(this.f7494a, 0, 20, 0, i, null);
            CommonBindingAdapter.O(((ChannelActivityCreateChatTeamBinding) this).f7483a, 0, 0, 0, i2, null);
        }
        if ((j & 276) != 0) {
            ((ChannelActivityCreateChatTeamBinding) this).f7482a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityCreateChatTeamBinding) this).f7482a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7486a != 0) {
                return true;
            }
            return ((ChannelActivityCreateChatTeamBinding) this).f7482a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7486a = 256L;
        }
        ((ChannelActivityCreateChatTeamBinding) this).f7482a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBinding
    public void o(@Nullable CreateChatTeamActivity.ClickProxy clickProxy) {
        ((ChannelActivityCreateChatTeamBinding) this).f7480a = clickProxy;
        synchronized (this) {
            this.f7486a |= 64;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return v((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return s((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return u((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return t((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBinding
    public void p(@Nullable Boolean bool) {
        ((ChannelActivityCreateChatTeamBinding) this).f7484a = bool;
        synchronized (this) {
            this.f7486a |= 128;
        }
        notifyPropertyChanged(tk0.z);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBinding
    public void q(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f7486a |= 32;
        }
        notifyPropertyChanged(tk0.k0);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityCreateChatTeamBinding
    public void r(@Nullable CreateChatTeamVM createChatTeamVM) {
        ((ChannelActivityCreateChatTeamBinding) this).f7481a = createChatTeamVM;
        synchronized (this) {
            this.f7486a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean s(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7486a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityCreateChatTeamBinding) this).f7482a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            r((CreateChatTeamVM) obj);
        } else if (tk0.k0 == i) {
            q((String) obj);
        } else if (tk0.k == i) {
            o((CreateChatTeamActivity.ClickProxy) obj);
        } else {
            if (tk0.z != i) {
                return false;
            }
            p((Boolean) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<MyChannelChatTeam> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7486a |= 8;
        }
        return true;
    }

    public final boolean u(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7486a |= 4;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7486a |= 1;
        }
        return true;
    }

    public ChannelActivityCreateChatTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (EditText) objArr[6], (ShadowConstraintLayout) objArr[7], (LayoutToolbarBindingBinding) objArr[9], (View) objArr[10]);
        this.f7486a = -1L;
        ((ChannelActivityCreateChatTeamBinding) this).f7479a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f7489a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f7490a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f7496a = bLTextView;
        bLTextView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[3];
        this.f7487a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.f7488a = imageView;
        imageView.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[5];
        this.f7495a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLButton bLButton = (BLButton) objArr[8];
        this.f7494a = bLButton;
        bLButton.setTag(null);
        ((ChannelActivityCreateChatTeamBinding) this).f7483a.setTag(null);
        setContainedBinding(((ChannelActivityCreateChatTeamBinding) this).f7482a);
        setRootTag(view);
        invalidateAll();
    }
}
