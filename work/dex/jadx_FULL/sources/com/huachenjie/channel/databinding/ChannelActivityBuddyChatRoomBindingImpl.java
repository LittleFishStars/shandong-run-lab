package com.huachenjie.channel.databinding;

import android.text.TextUtils;
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
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.BuddyDetailBean;
import com.huachenjie.channel.bean.notify.BuddyDetailTypeBean;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityBuddyChatRoomBindingImpl extends ChannelActivityBuddyChatRoomBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7423a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7430a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f7431b;

    @NonNull
    public final BLTextView c;

    @NonNull
    public final BLTextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuddyChatRoomActivity.a f33040a;

        public a a(BuddyChatRoomActivity.a aVar) {
            this.f33040a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33040a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuddyChatRoomActivity.a f33041a;

        public b a(BuddyChatRoomActivity.a aVar) {
            this.f33041a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33041a.back(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33039a = sparseIntArray;
        sparseIntArray.put(R.id.fl_chat_content, 8);
    }

    public ChannelActivityBuddyChatRoomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7423a, f33039a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String value;
        String location;
        String buddyTypeName;
        String str;
        String str2;
        boolean z2;
        int iSafeUnbox;
        boolean z3;
        a aVarA;
        long j2;
        b bVarA;
        boolean z4;
        long j3;
        boolean z5;
        String str3;
        String str4;
        boolean z6;
        BuddyDetailTypeBean buddyTypeInfo;
        synchronized (this) {
            j = this.f7424a;
            this.f7424a = 0L;
        }
        BuddyChatRoomVM buddyChatRoomVM = ((ChannelActivityBuddyChatRoomBinding) this).f7422a;
        BuddyChatRoomActivity.a aVar = ((ChannelActivityBuddyChatRoomBinding) this).f7421a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = buddyChatRoomVM != null ? buddyChatRoomVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            long j4 = j & 42;
            if (j4 != 0) {
                MutableLiveData<BuddyDetailBean> mutableLiveDataI = buddyChatRoomVM != null ? buddyChatRoomVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                BuddyDetailBean value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value2 != null) {
                    buddyTypeInfo = value2.getBuddyTypeInfo();
                    str3 = value2.formatterActivityTime();
                    str4 = value2.formatterMemberCount();
                    location = value2.getLocation();
                } else {
                    location = null;
                    buddyTypeInfo = null;
                    str3 = null;
                    str4 = null;
                }
                z2 = buddyTypeInfo != null;
                boolean zIsEmpty = TextUtils.isEmpty(str3);
                boolean zIsEmpty2 = TextUtils.isEmpty(location);
                if (j4 != 0) {
                    j = z2 ? j | 128 : j | 64;
                }
                buddyTypeName = buddyTypeInfo != null ? buddyTypeInfo.getBuddyTypeName() : null;
                z5 = !zIsEmpty;
                z6 = !zIsEmpty2;
                j3 = 44;
            } else {
                location = null;
                buddyTypeName = null;
                j3 = 44;
                z5 = false;
                str3 = null;
                str4 = null;
                z2 = false;
                z6 = false;
            }
            if ((j & j3) != 0) {
                BaseViewModel.b bVarE = buddyChatRoomVM != null ? buddyChatRoomVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                z = z5;
                str = str3;
                str2 = str4;
                z3 = z6;
            } else {
                z = z5;
                str = str3;
                str2 = str4;
                z3 = z6;
                iSafeUnbox = 0;
            }
        } else {
            z = false;
            value = null;
            location = null;
            buddyTypeName = null;
            str = null;
            str2 = null;
            z2 = false;
            iSafeUnbox = 0;
            z3 = false;
        }
        long j5 = j & 48;
        if (j5 == 0 || aVar == null) {
            aVarA = null;
            j2 = 128;
            bVarA = null;
        } else {
            b bVar = this.f7429a;
            if (bVar == null) {
                bVar = new b();
                this.f7429a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7428a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7428a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            j2 = 128;
        }
        boolean zIsEmpty3 = (j2 & j) != 0 ? true ^ TextUtils.isEmpty(buddyTypeName) : false;
        long j6 = 42 & j;
        if (j6 != 0) {
            z4 = z2 ? zIsEmpty3 : false;
        } else {
            z4 = false;
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.I(this.b, 0, iSafeUnbox, 0, 0, null);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(this.f7425a, bVarA, null);
            CommonBindingAdapter.q(this.f7430a, aVarA, null);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.f7430a, str2);
            TextViewBindingAdapter.setText(this.f7431b, buddyTypeName);
            CommonBindingAdapter.l0(this.f7431b, z4);
            TextViewBindingAdapter.setText(this.c, str);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.d, location);
            CommonBindingAdapter.l0(this.d, z3);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.f7427a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7424a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7424a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityBuddyChatRoomBinding
    public void l(@Nullable BuddyChatRoomActivity.a aVar) {
        ((ChannelActivityBuddyChatRoomBinding) this).f7421a = aVar;
        synchronized (this) {
            this.f7424a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityBuddyChatRoomBinding
    public void m(@Nullable BuddyChatRoomVM buddyChatRoomVM) {
        ((ChannelActivityBuddyChatRoomBinding) this).f7422a = buddyChatRoomVM;
        synchronized (this) {
            this.f7424a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BuddyDetailBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7424a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7424a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7424a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((BuddyChatRoomVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((BuddyChatRoomActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityBuddyChatRoomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FrameLayout) objArr[8]);
        this.f7424a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7426a = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.b = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f7425a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f7430a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f7427a = textView;
        textView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[5];
        this.f7431b = bLTextView2;
        bLTextView2.setTag(null);
        BLTextView bLTextView3 = (BLTextView) objArr[6];
        this.c = bLTextView3;
        bLTextView3.setTag(null);
        BLTextView bLTextView4 = (BLTextView) objArr[7];
        this.d = bLTextView4;
        bLTextView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
