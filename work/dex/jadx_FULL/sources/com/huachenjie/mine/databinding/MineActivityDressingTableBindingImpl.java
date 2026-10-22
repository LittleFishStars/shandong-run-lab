package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.page.dressing_table.DressingTableVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineActivityDressingTableBindingImpl extends MineActivityDressingTableBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11182a;

    @NonNull
    public final TextView b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        f11178a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35289a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mine.R.id.rlName, 8);
        sparseIntArray.put(com.huachenjie.mine.R.id.iv_id, 9);
        sparseIntArray.put(com.huachenjie.mine.R.id.ll_tags, 10);
        sparseIntArray.put(com.huachenjie.mine.R.id.tabLayout, 11);
        sparseIntArray.put(com.huachenjie.mine.R.id.viewPager, 12);
    }

    public MineActivityDressingTableBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f11178a, f35289a));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        BindingTitleBean value;
        String str;
        String str2;
        String str3;
        String slogan;
        String nickName;
        String avatar;
        String alumniId;
        String avatarFrameImgUrl;
        List<String> tagList;
        synchronized (this) {
            j = this.f11179a;
            this.f11179a = 0L;
        }
        DressingTableVM dressingTableVM = ((MineActivityDressingTableBinding) this).f11177a;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                MutableLiveData<MineData> mutableLiveDataI = dressingTableVM != null ? dressingTableVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                MineData value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value2 != null) {
                    slogan = value2.getSlogan();
                    nickName = value2.getNickName();
                    avatar = value2.getAvatar();
                    alumniId = value2.getAlumniId();
                    avatarFrameImgUrl = value2.getAvatarFrameImgUrl();
                    tagList = value2.getTagList();
                } else {
                    tagList = null;
                    slogan = null;
                    nickName = null;
                    avatar = null;
                    alumniId = null;
                    avatarFrameImgUrl = null;
                }
                z = (tagList != null ? tagList.size() : 0) > 0;
            } else {
                z = false;
                slogan = null;
                nickName = null;
                avatar = null;
                alumniId = null;
                avatarFrameImgUrl = null;
            }
            if ((j & 14) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = dressingTableVM != null ? dressingTableVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            str3 = avatar;
            str = alumniId;
            str2 = avatarFrameImgUrl;
        } else {
            z = false;
            value = null;
            str = null;
            str2 = null;
            str3 = null;
            slogan = null;
            nickName = null;
        }
        if ((13 & j) != 0) {
            aw9.d(((MineActivityDressingTableBinding) this).f11176a, str3, false, null);
            aw9.c(((MineActivityDressingTableBinding) this).f11176a, str2, null);
            TextViewBindingAdapter.setText(this.f11182a, str);
            TextViewBindingAdapter.setText(this.b, slogan);
            CommonBindingAdapter.l0(((MineActivityDressingTableBinding) this).f35288a, z);
            TextViewBindingAdapter.setText(((MineActivityDressingTableBinding) this).f11172a, nickName);
        }
        if ((j & 14) != 0) {
            this.f11181a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f11181a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11179a != 0) {
                return true;
            }
            return this.f11181a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11179a = 8L;
        }
        this.f11181a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityDressingTableBinding
    public void k(@Nullable DressingTableVM dressingTableVM) {
        ((MineActivityDressingTableBinding) this).f11177a = dressingTableVM;
        synchronized (this) {
            this.f11179a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<MineData> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11179a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11179a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11181a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 != i) {
            return false;
        }
        k((DressingTableVM) obj);
        return true;
    }

    public MineActivityDressingTableBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[1], (AvatarView) objArr[2], (ImageView) objArr[9], (LinearLayout) objArr[10], (RelativeLayout) objArr[8], (HorizontalScrollView) objArr[5], (SlidingTabLayout) objArr[11], (TextView) objArr[3], (ViewPager) objArr[12]);
        this.f11179a = -1L;
        ((MineActivityDressingTableBinding) this).f11173a.setTag(null);
        ((MineActivityDressingTableBinding) this).f11176a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f11180a = frameLayout;
        frameLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f11181a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f11182a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.b = textView;
        textView.setTag(null);
        ((MineActivityDressingTableBinding) this).f35288a.setTag(null);
        ((MineActivityDressingTableBinding) this).f11172a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
