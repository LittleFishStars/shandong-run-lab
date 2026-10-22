package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.bean.ClassificationBean;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLButton;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityEditChannelInfoBindingImpl extends ChannelActivityEditChannelInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f7536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f7541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f7542a;

    @NonNull
    public final ImageView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelActivityEditChannelInfoBinding) ChannelActivityEditChannelInfoBindingImpl.this).f33073a);
            EditChannelInfoVM editChannelInfoVM = ((ChannelActivityEditChannelInfoBinding) ChannelActivityEditChannelInfoBindingImpl.this).f7530a;
            if (editChannelInfoVM != null) {
                MutableLiveData<String> mutableLiveDataL = editChannelInfoVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EditChannelInfoActivity.a f33076a;

        public b a(EditChannelInfoActivity.a aVar) {
            this.f33076a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33076a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EditChannelInfoActivity.a f33077a;

        public c a(EditChannelInfoActivity.a aVar) {
            this.f33077a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33077a.b(view);
        }
    }

    public static class d implements UploadPictureButton.OnUrlChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EditChannelInfoActivity.a f33078a;

        @Override // com.huachenjie.channel.widget.UploadPictureButton.OnUrlChangedListener
        public void a(String str) {
            this.f33078a.c(str);
        }

        public d b(EditChannelInfoActivity.a aVar) {
            this.f33078a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f7534a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{9}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33074a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_title, 10);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_avatar_hint, 11);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_name, 12);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_bg, 13);
    }

    public ChannelActivityEditChannelInfoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f7534a, f33074a));
    }

    /* JADX WARN: Code duplicated, block: B:91:0x0139  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        MutableLiveData<String> mutableLiveDataJ;
        boolean z;
        MutableLiveData<String> mutableLiveData;
        String str2;
        String str3;
        int i;
        boolean zIsEmpty;
        BindingTitleBean bindingTitleBean;
        boolean z2;
        String value;
        int i2;
        d dVarB;
        b bVarA;
        c cVar;
        boolean z3;
        String str4;
        String str5;
        boolean z4;
        Object drawable2;
        boolean z5;
        long j2;
        long j3;
        c cVarA;
        boolean z6;
        int iSafeUnbox;
        int i3;
        String str6;
        String value2;
        BindingTitleBean value3;
        int i4;
        MutableLiveData<String> mutableLiveDataK;
        MutableLiveData<ClassificationBean> mutableLiveDataP;
        MutableLiveData<ClassificationBean> mutableLiveDataN;
        synchronized (this) {
            j = this.f7535a;
            this.f7535a = 0L;
        }
        EditChannelInfoVM editChannelInfoVM = ((ChannelActivityEditChannelInfoBinding) this).f7530a;
        EditChannelInfoActivity.a aVar = ((ChannelActivityEditChannelInfoBinding) this).f7529a;
        if ((2031 & j) != 0) {
            if ((j & 1793) != 0) {
                mutableLiveDataJ = editChannelInfoVM != null ? editChannelInfoVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                z6 = ((j & 1281) == 0 || value == null) ? false : true;
            } else {
                z6 = false;
                mutableLiveDataJ = null;
                value = null;
            }
            long j4 = j & 1284;
            if (j4 != 0) {
                BaseViewModel.b bVarE = editChannelInfoVM != null ? editChannelInfoVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(2, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                boolean z7 = iSafeUnbox > 0;
                if (j4 != 0) {
                    j |= z7 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                i3 = z7 ? 12 : 30;
            } else {
                iSafeUnbox = 0;
                i3 = 0;
            }
            if ((j & 1346) != 0) {
                if (editChannelInfoVM != null) {
                    mutableLiveDataP = editChannelInfoVM.p();
                    mutableLiveDataN = editChannelInfoVM.n();
                } else {
                    mutableLiveDataP = null;
                    mutableLiveDataN = null;
                }
                updateLiveDataRegistration(1, mutableLiveDataP);
                updateLiveDataRegistration(6, mutableLiveDataN);
                ClassificationBean value4 = mutableLiveDataP != null ? mutableLiveDataP.getValue() : null;
                ClassificationBean value5 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                str6 = String.format("%s - %s", value4 != null ? value4.getClassificationName() : null, value5 != null ? value5.getClassificationName() : null);
            } else {
                str6 = null;
            }
            long j5 = j & 1417;
            if (j5 != 0) {
                MutableLiveData<String> mutableLiveDataL = editChannelInfoVM != null ? editChannelInfoVM.l() : null;
                updateLiveDataRegistration(3, mutableLiveDataL);
                value2 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                z2 = !TextUtils.isEmpty(value2);
                if (j5 != 0) {
                    j = z2 ? j | 1048576 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
            } else {
                z2 = false;
                value2 = null;
            }
            if ((j & 1312) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataO = editChannelInfoVM != null ? editChannelInfoVM.o() : null;
                updateLiveDataRegistration(5, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value3 = mutableLiveDataO.getValue();
                } else {
                    value3 = null;
                }
            }
            long j6 = j & 1408;
            if (j6 != 0) {
                if (editChannelInfoVM != null) {
                    mutableLiveDataK = editChannelInfoVM.k();
                    i4 = 7;
                } else {
                    i4 = 7;
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(i4, mutableLiveDataK);
                String value6 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                boolean zIsEmpty2 = TextUtils.isEmpty(value6);
                if (j6 != 0) {
                    j = zIsEmpty2 ? j | 4096 | 262144 : j | 2048 | 131072;
                }
                Drawable drawable3 = zIsEmpty2 ? AppCompatResources.getDrawable(this.b.getContext(), com.huachenjie.channel.R.drawable.channel_ic_info_avatar_take) : AppCompatResources.getDrawable(this.b.getContext(), com.huachenjie.channel.R.drawable.channel_ic_info_avatar_take_sel);
                zIsEmpty = zIsEmpty2;
                i2 = i3;
                str = str6;
                mutableLiveData = mutableLiveDataK;
                str2 = value6;
                bindingTitleBean = value3;
                str3 = value2;
                drawable = drawable3;
                i = iSafeUnbox;
                z = z6;
                j = j;
            } else {
                i2 = i3;
                str = str6;
                bindingTitleBean = value3;
                str3 = value2;
                drawable = null;
                mutableLiveData = null;
                str2 = null;
                zIsEmpty = false;
                i = iSafeUnbox;
                z = z6;
            }
        } else {
            drawable = null;
            str = null;
            mutableLiveDataJ = null;
            z = false;
            mutableLiveData = null;
            str2 = null;
            str3 = null;
            i = 0;
            zIsEmpty = false;
            bindingTitleBean = null;
            z2 = false;
            value = null;
            i2 = 0;
        }
        long j7 = j & 1408;
        RequestOptions requestOptions = j7 != 0 ? ju3.d : null;
        if ((j & 1793) != 0) {
            if ((j & 1536) == 0 || aVar == null) {
                bVarA = null;
                cVarA = null;
            } else {
                c cVar2 = this.f7539a;
                if (cVar2 == null) {
                    cVar2 = new c();
                    this.f7539a = cVar2;
                }
                cVarA = cVar2.a(aVar);
                b bVar = this.f7538a;
                if (bVar == null) {
                    bVar = new b();
                    this.f7538a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            b bVar2 = bVarA;
            if (aVar != null) {
                d dVar = this.f7540a;
                if (dVar == null) {
                    dVar = new d();
                    this.f7540a = dVar;
                }
                dVarB = dVar.b(aVar);
                bVarA = bVar2;
            } else {
                dVarB = null;
            }
            cVar = cVarA;
        } else {
            mutableLiveData = mutableLiveData;
            dVarB = null;
            bVarA = null;
            cVar = null;
        }
        if ((j & 1048576) != 0) {
            MutableLiveData<String> mutableLiveDataK2 = editChannelInfoVM != null ? editChannelInfoVM.k() : mutableLiveData;
            updateLiveDataRegistration(7, mutableLiveDataK2);
            String value7 = str2;
            if (mutableLiveDataK2 != null) {
                value7 = mutableLiveDataK2.getValue();
            }
            zIsEmpty = TextUtils.isEmpty(value7);
            if (j7 != 0) {
                if (zIsEmpty) {
                    j2 = j | 4096;
                    j3 = 262144;
                } else {
                    j2 = j | 2048;
                    j3 = 131072;
                }
                j = j2 | j3;
            }
            z3 = !zIsEmpty;
            str4 = value7;
        } else {
            dVarB = dVarB;
            z3 = false;
            str4 = str2;
        }
        long j8 = j & 1417;
        if (j8 != 0) {
            if (!z2) {
                z3 = false;
            }
            if (j8 != 0) {
                j = z3 ? j | PlaybackStateCompat.ACTION_PREPARE : j | 8192;
            }
        } else {
            z3 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            MutableLiveData<String> mutableLiveDataJ2 = editChannelInfoVM != null ? editChannelInfoVM.j() : mutableLiveDataJ;
            updateLiveDataRegistration(0, mutableLiveDataJ2);
            if (mutableLiveDataJ2 != null) {
                value = mutableLiveDataJ2.getValue();
            }
            z4 = !TextUtils.isEmpty(value);
            str5 = value;
        } else {
            str5 = value;
            z4 = false;
        }
        long j9 = j & 1408;
        if (j9 != 0) {
            drawable2 = zIsEmpty ? AppCompatResources.getDrawable(((ChannelActivityEditChannelInfoBinding) this).f7527a.getContext(), com.huachenjie.channel.R.drawable.channel_ic_info_avatar_default) : str4;
        } else {
            z4 = z4;
            drawable2 = null;
        }
        long j10 = j & 1417;
        if (j10 != 0) {
            if (!z3) {
                z4 = false;
            }
            z5 = z4;
        } else {
            z5 = false;
        }
        if ((j & 1288) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityEditChannelInfoBinding) this).f33073a, str3);
        }
        if ((j & 1024) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ChannelActivityEditChannelInfoBinding) this).f33073a, null, null, null, this.f7537a);
        }
        if (j9 != 0) {
            CommonBindingAdapter.b0(((ChannelActivityEditChannelInfoBinding) this).f7527a, drawable2, requestOptions, false);
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
        }
        if ((j & 1536) != 0) {
            CommonBindingAdapter.q(((ChannelActivityEditChannelInfoBinding) this).f7527a, bVarA, null);
            CommonBindingAdapter.q(this.f7542a, cVar, null);
        }
        if ((j & 1281) != 0) {
            CommonBindingAdapter.l0(this.f7541a, z);
        }
        if (j10 != 0) {
            CommonBindingAdapter.e0(this.f7542a, z5);
        }
        if ((j & 1284) != 0) {
            CommonBindingAdapter.I(this.f7542a, 0, 20, 0, i2, null);
            CommonBindingAdapter.O(((ChannelActivityEditChannelInfoBinding) this).f7533a, 0, 0, 0, i, null);
        }
        if ((j & 1312) != 0) {
            ((ChannelActivityEditChannelInfoBinding) this).f7532a.k(bindingTitleBean);
        }
        if ((j & 1346) != 0) {
            TextViewBindingAdapter.setText(this.d, str);
        }
        if ((j & 1793) != 0) {
            UploadPictureButton.createBindingAdapter(((ChannelActivityEditChannelInfoBinding) this).f7531a, str5, 20, dVarB, true);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityEditChannelInfoBinding) this).f7532a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7535a != 0) {
                return true;
            }
            return ((ChannelActivityEditChannelInfoBinding) this).f7532a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7535a = 1024L;
        }
        ((ChannelActivityEditChannelInfoBinding) this).f7532a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityEditChannelInfoBinding
    public void l(@Nullable EditChannelInfoActivity.a aVar) {
        ((ChannelActivityEditChannelInfoBinding) this).f7529a = aVar;
        synchronized (this) {
            this.f7535a |= 512;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityEditChannelInfoBinding
    public void m(@Nullable EditChannelInfoVM editChannelInfoVM) {
        ((ChannelActivityEditChannelInfoBinding) this).f7530a = editChannelInfoVM;
        synchronized (this) {
            this.f7535a |= 256;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return o((MutableLiveData) obj, i2);
            case 1:
                return t((MutableLiveData) obj, i2);
            case 2:
                return u((MutableLiveData) obj, i2);
            case 3:
                return q((MutableLiveData) obj, i2);
            case 4:
                return n((LayoutToolbarBindingBinding) obj, i2);
            case 5:
                return s((MutableLiveData) obj, i2);
            case 6:
                return r((MutableLiveData) obj, i2);
            case 7:
                return p((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 128;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<ClassificationBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 64;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityEditChannelInfoBinding) this).f7532a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((EditChannelInfoVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((EditChannelInfoActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<ClassificationBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 2;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7535a |= 4;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public ChannelActivityEditChannelInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (EditText) objArr[4], (ImageView) objArr[2], (ShadowConstraintLayout) objArr[7], (LayoutToolbarBindingBinding) objArr[9], (TextView) objArr[11], (TextView) objArr[13], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[10], (UploadPictureButton) objArr[5]);
        this.f7537a = new a();
        this.f7535a = -1L;
        ((ChannelActivityEditChannelInfoBinding) this).f33073a.setTag(null);
        ((ChannelActivityEditChannelInfoBinding) this).f7527a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f7536a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.b = imageView;
        imageView.setTag(null);
        ?? r0 = (DrawableCenterButton) objArr[6];
        this.f7541a = r0;
        r0.setTag(null);
        BLButton bLButton = (BLButton) objArr[8];
        this.f7542a = bLButton;
        bLButton.setTag(null);
        ((ChannelActivityEditChannelInfoBinding) this).f7533a.setTag(null);
        setContainedBinding(((ChannelActivityEditChannelInfoBinding) this).f7532a);
        this.d.setTag(null);
        ((ChannelActivityEditChannelInfoBinding) this).f7531a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
