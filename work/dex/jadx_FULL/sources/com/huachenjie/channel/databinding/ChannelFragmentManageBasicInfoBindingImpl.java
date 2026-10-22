package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment;
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLEditText;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageBasicInfoBindingImpl extends ChannelFragmentManageBasicInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7806a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f7813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7815a;

    @NonNull
    public final TextView e;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelFragmentManageBasicInfoBinding) ChannelFragmentManageBasicInfoBindingImpl.this).f7805b);
            ManageBasicInfoVM manageBasicInfoVM = ((ChannelFragmentManageBasicInfoBinding) ChannelFragmentManageBasicInfoBindingImpl.this).f7801a;
            if (manageBasicInfoVM != null) {
                MutableLiveData<String> mutableLiveDataJ = manageBasicInfoVM.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ManageBasicInfoFragment.a f33178a;

        public b a(ManageBasicInfoFragment.a aVar) {
            this.f33178a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33178a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ManageBasicInfoFragment.a f33179a;

        public c a(ManageBasicInfoFragment.a aVar) {
            this.f33179a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33179a.a(view);
        }
    }

    public static class d implements UploadPictureButton.OnUrlChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ManageBasicInfoFragment.a f33180a;

        @Override // com.huachenjie.channel.widget.UploadPictureButton.OnUrlChangedListener
        public void a(String str) {
            this.f33180a.c(str);
        }

        public d b(ManageBasicInfoFragment.a aVar) {
            this.f33180a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }
    }

    public static class e implements UploadPictureButton.OnUrlChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ManageBasicInfoFragment.a f33181a;

        @Override // com.huachenjie.channel.widget.UploadPictureButton.OnUrlChangedListener
        public void a(String str) {
            this.f33181a.d(str);
        }

        public e b(ManageBasicInfoFragment.a aVar) {
            this.f33181a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33176a = sparseIntArray;
        sparseIntArray.put(R.id.tv_channel_name_title, 9);
        sparseIntArray.put(R.id.tv_channel_desc_title, 10);
        sparseIntArray.put(R.id.tv_channel_logo_title, 11);
        sparseIntArray.put(R.id.tv_channel_bg_title, 12);
    }

    public ChannelFragmentManageBasicInfoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f7806a, f33176a));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:77:0x0104  */
    /* JADX WARN: Code duplicated, block: B:78:0x010b  */
    /* JADX WARN: Code duplicated, block: B:80:0x011b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        MutableLiveData<String> mutableLiveDataJ;
        String value;
        ChannelBasicInfo value2;
        String str3;
        String coverUrl;
        boolean z;
        boolean z2;
        int i;
        int i2;
        b bVarA;
        e eVarB;
        d dVarB;
        c cVarA;
        boolean z3;
        String str4;
        boolean z4;
        Long l;
        int i3;
        int iSafeUnbox;
        long j2;
        String logo;
        String channelDescription;
        synchronized (this) {
            j = this.f7807a;
            this.f7807a = 0L;
        }
        ManageBasicInfoVM manageBasicInfoVM = ((ChannelFragmentManageBasicInfoBinding) this).f7801a;
        ManageBasicInfoFragment.a aVar = ((ChannelFragmentManageBasicInfoBinding) this).f7800a;
        long j3 = 512;
        if ((63 & j) != 0) {
            long j4 = j & 41;
            if (j4 != 0) {
                BaseViewModel.b bVarE = manageBasicInfoVM != null ? manageBasicInfoVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                boolean z5 = iSafeUnbox > 0;
                if (j4 != 0) {
                    j |= z5 ? 2048L : 1024L;
                }
                i3 = z5 ? 12 : 30;
            } else {
                i3 = 0;
                iSafeUnbox = 0;
            }
            if ((j & 62) != 0) {
                MutableLiveData<ChannelBasicInfo> mutableLiveDataI = manageBasicInfoVM != null ? manageBasicInfoVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                coverUrl = ((j & 58) == 0 || value2 == null) ? null : value2.getCoverUrl();
                logo = value2 != null ? value2.getLogo() : null;
                long j5 = j & 46;
                if (j5 != 0) {
                    z = !TextUtils.isEmpty(logo);
                    if (j5 != 0) {
                        j = z ? j | 512 : j | 256;
                    }
                } else {
                    z = false;
                }
                if ((j & 42) != 0) {
                    channelDescription = value2 != null ? value2.getChannelDescription() : null;
                    str2 = String.format("%s/100", Integer.valueOf(channelDescription != null ? channelDescription.length() : 0));
                    j2 = 44;
                } else {
                    str2 = null;
                    j2 = 44;
                }
                if ((j & j2) != 0) {
                    if (manageBasicInfoVM != null) {
                        mutableLiveDataJ = manageBasicInfoVM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                        value = mutableLiveDataJ.getValue();
                    } else {
                        value = null;
                    }
                    z2 = !TextUtils.isEmpty(value);
                    i = i3;
                    i2 = iSafeUnbox;
                    str3 = logo;
                    str = channelDescription;
                } else {
                    i = i3;
                    i2 = iSafeUnbox;
                    str3 = logo;
                    str = channelDescription;
                    mutableLiveDataJ = null;
                    value = null;
                    z2 = false;
                }
            } else {
                z = false;
                str2 = null;
                value2 = null;
                j2 = 44;
                coverUrl = null;
                logo = null;
            }
            channelDescription = null;
            if ((j & j2) != 0) {
                if (manageBasicInfoVM != null) {
                    mutableLiveDataJ = manageBasicInfoVM.j();
                } else {
                    mutableLiveDataJ = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
                z2 = !TextUtils.isEmpty(value);
                i = i3;
                i2 = iSafeUnbox;
                str3 = logo;
                str = channelDescription;
            } else {
                i = i3;
                i2 = iSafeUnbox;
                str3 = logo;
                str = channelDescription;
                mutableLiveDataJ = null;
                value = null;
                z2 = false;
            }
        } else {
            str = null;
            str2 = null;
            mutableLiveDataJ = null;
            value = null;
            value2 = null;
            str3 = null;
            coverUrl = null;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
        }
        if ((j & 58) != 0) {
            if ((j & 48) == 0 || aVar == null) {
                bVarA = null;
                cVarA = null;
            } else {
                c cVar = this.f7811a;
                if (cVar == null) {
                    cVar = new c();
                    this.f7811a = cVar;
                }
                cVarA = cVar.a(aVar);
                b bVar = this.f7810a;
                if (bVar == null) {
                    bVar = new b();
                    this.f7810a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            if (aVar != null) {
                e eVar = this.f7813a;
                if (eVar == null) {
                    eVar = new e();
                    this.f7813a = eVar;
                }
                eVarB = eVar.b(aVar);
                d dVar = this.f7812a;
                if (dVar == null) {
                    dVar = new d();
                    this.f7812a = dVar;
                }
                dVarB = dVar.b(aVar);
                j3 = 512;
            } else {
                eVarB = null;
                dVarB = null;
            }
        } else {
            bVarA = null;
            eVarB = null;
            dVarB = null;
            cVarA = null;
        }
        if ((j3 & j) != 0) {
            if (manageBasicInfoVM != null) {
                mutableLiveDataJ = manageBasicInfoVM.j();
            }
            updateLiveDataRegistration(2, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            }
            z2 = !TextUtils.isEmpty(value);
        }
        boolean z6 = z2;
        long j6 = j & 46;
        if (j6 != 0) {
            z3 = z ? z6 : false;
            if (j6 != 0) {
                j = z3 ? j | 128 : j | 64;
            }
        } else {
            z3 = false;
        }
        if ((128 & j) != 0) {
            if (value2 != null) {
                coverUrl = value2.getCoverUrl();
            }
            z4 = !TextUtils.isEmpty(coverUrl);
            str4 = coverUrl;
        } else {
            str4 = coverUrl;
            z4 = false;
        }
        long j7 = j & 46;
        if (j7 == 0 || !z3) {
            z4 = false;
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((ChannelFragmentManageBasicInfoBinding) this).f7803a, str);
            TextViewBindingAdapter.setText(this.e, str2);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(((ChannelFragmentManageBasicInfoBinding) this).f7805b, value);
            CommonBindingAdapter.l0(((ChannelFragmentManageBasicInfoBinding) this).f33175a, z6);
        }
        if ((32 & j) != 0) {
            l = null;
            TextViewBindingAdapter.setTextWatcher(((ChannelFragmentManageBasicInfoBinding) this).f7805b, null, null, null, this.f7809a);
        } else {
            l = null;
        }
        if ((j & 48) != 0) {
            CommonBindingAdapter.q(((ChannelFragmentManageBasicInfoBinding) this).f33175a, bVarA, l);
            CommonBindingAdapter.q(this.f7815a, cVarA, l);
        }
        if ((41 & j) != 0) {
            CommonBindingAdapter.O(this.f7814a, 0, 0, 0, i2, null);
            CommonBindingAdapter.I(this.f7815a, 0, 20, 0, i, null);
        }
        if (j7 != 0) {
            CommonBindingAdapter.e0(this.f7815a, z4);
        }
        if ((j & 58) != 0) {
            UploadPictureButton.createBindingAdapter(((ChannelFragmentManageBasicInfoBinding) this).f7802a, str4, null, dVarB, false);
            UploadPictureButton.createBindingAdapter(((ChannelFragmentManageBasicInfoBinding) this).f7804b, str3, null, eVarB, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7807a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7807a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageBasicInfoBinding
    public void l(@Nullable ManageBasicInfoFragment.a aVar) {
        ((ChannelFragmentManageBasicInfoBinding) this).f7800a = aVar;
        synchronized (this) {
            this.f7807a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageBasicInfoBinding
    public void m(@Nullable ManageBasicInfoVM manageBasicInfoVM) {
        ((ChannelFragmentManageBasicInfoBinding) this).f7801a = manageBasicInfoVM;
        synchronized (this) {
            this.f7807a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ChannelBasicInfo> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7807a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7807a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7807a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((ManageBasicInfoVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((ManageBasicInfoFragment.a) obj);
        }
        return true;
    }

    public ChannelFragmentManageBasicInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLEditText) objArr[3], (BLEditText) objArr[1], (ImageView) objArr[2], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[9], (UploadPictureButton) objArr[6], (UploadPictureButton) objArr[5]);
        this.f7809a = new a();
        this.f7807a = -1L;
        ((ChannelFragmentManageBasicInfoBinding) this).f7803a.setTag(null);
        ((ChannelFragmentManageBasicInfoBinding) this).f7805b.setTag(null);
        ((ChannelFragmentManageBasicInfoBinding) this).f33175a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7808a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.e = textView;
        textView.setTag(null);
        ShadowConstraintLayout shadowConstraintLayout = (ShadowConstraintLayout) objArr[7];
        this.f7814a = shadowConstraintLayout;
        shadowConstraintLayout.setTag(null);
        BLButton bLButton = (BLButton) objArr[8];
        this.f7815a = bLButton;
        bLButton.setTag(null);
        ((ChannelFragmentManageBasicInfoBinding) this).f7802a.setTag(null);
        ((ChannelFragmentManageBasicInfoBinding) this).f7804b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
