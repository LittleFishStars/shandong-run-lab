package com.huachenjie.works.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.progress.GradientRoundProgress;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.bean.BuddyUserBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemBuddyCardBindingImpl extends WorksItemBuddyCardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14501a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f14503a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37010a = sparseIntArray;
        sparseIntArray.put(R.id.hsv_buddy_tags, 13);
        sparseIntArray.put(R.id.ll_buddy_image_container, 14);
        sparseIntArray.put(R.id.iv_buddy_image_1, 15);
        sparseIntArray.put(R.id.iv_buddy_image_2, 16);
        sparseIntArray.put(R.id.iv_buddy_image_3, 17);
        sparseIntArray.put(R.id.iv_buddy_image_4, 18);
        sparseIntArray.put(R.id.ll_member_info, 19);
        sparseIntArray.put(R.id.ll_member_avatar_preview, 20);
    }

    public WorksItemBuddyCardBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 21, f14501a, f37010a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018f  */
    /* JADX WARN: Code duplicated, block: B:101:0x0192  */
    /* JADX WARN: Code duplicated, block: B:103:0x0199  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0178 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x017a  */
    /* JADX WARN: Code duplicated, block: B:91:0x017d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0181  */
    /* JADX WARN: Code duplicated, block: B:95:0x0185 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0187  */
    /* JADX WARN: Code duplicated, block: B:97:0x018a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        BuddyTypeScopeTypeBean buddyTypeInfo;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String buddyTypeName;
        boolean zIsEmpty;
        long j2;
        String str10;
        int i7;
        boolean z3;
        int i8;
        long j3;
        String str11;
        String str12;
        String str13;
        String str14;
        BuddyUserBean creatorInfo;
        String location;
        String str15;
        int i9;
        boolean zIsJoinButtonEnabled;
        boolean zIsJoinButtonVisible;
        long j4;
        long j5;
        long j6;
        long j7;
        synchronized (this) {
            j = this.f14502a;
            this.f14502a = 0L;
        }
        BuddyCardBean buddyCardBean = ((WorksItemBuddyCardBinding) this).f14491a;
        long j8 = j & 3;
        if (j8 != 0) {
            if (buddyCardBean != null) {
                str3 = buddyCardBean.formatterPublishTime();
                int maxMemberCount = buddyCardBean.getMaxMemberCount();
                buddyTypeInfo = buddyCardBean.getBuddyTypeInfo();
                str11 = buddyCardBean.formatterJoinButtonText();
                str12 = buddyCardBean.formatterDescription();
                str13 = buddyCardBean.formatterMemberCount();
                zIsJoinButtonEnabled = buddyCardBean.isJoinButtonEnabled();
                str14 = buddyCardBean.formatterTitle();
                creatorInfo = buddyCardBean.getCreatorInfo();
                zIsJoinButtonVisible = buddyCardBean.isJoinButtonVisible();
                location = buddyCardBean.getLocation();
                str15 = buddyCardBean.formatterActivityTime();
                str = buddyCardBean.formatterJoinedMemberCount();
                i9 = maxMemberCount;
            } else {
                str = null;
                str3 = null;
                buddyTypeInfo = null;
                str11 = null;
                str12 = null;
                str13 = null;
                str14 = null;
                creatorInfo = null;
                location = null;
                str15 = null;
                i9 = 0;
                zIsJoinButtonEnabled = false;
                zIsJoinButtonVisible = false;
            }
            if (j8 != 0) {
                j |= zIsJoinButtonVisible ? 131072L : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            boolean z4 = i9 == -1;
            z = buddyTypeInfo == null;
            boolean zIsEmpty2 = TextUtils.isEmpty(str12);
            int i10 = zIsJoinButtonVisible ? 0 : 8;
            boolean zIsEmpty3 = TextUtils.isEmpty(location);
            boolean zIsEmpty4 = TextUtils.isEmpty(str15);
            if ((j & 3) != 0) {
                if (z4) {
                    j6 = j | 2048;
                    j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    j6 = j | 1024;
                    j7 = PlaybackStateCompat.ACTION_PREPARE;
                }
                j = j6 | j7;
            }
            if ((j & 3) != 0) {
                if (z) {
                    j4 = j | 8;
                    j5 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                } else {
                    j4 = j | 4;
                    j5 = 262144;
                }
                j = j4 | j5;
            }
            if ((j & 3) != 0) {
                j |= zIsEmpty2 ? 8192L : 4096L;
            }
            if ((j & 3) != 0) {
                j |= zIsEmpty3 ? 128L : 64L;
            }
            if ((j & 3) != 0) {
                j |= zIsEmpty4 ? 512L : 256L;
            }
            String avatar = creatorInfo != null ? creatorInfo.getAvatar() : null;
            int i11 = z4 ? 8 : 0;
            i = z4 ? 0 : 8;
            str2 = str11;
            str4 = str12;
            str5 = str13;
            z2 = zIsJoinButtonEnabled;
            str6 = str14;
            str7 = avatar;
            i2 = i10;
            str8 = location;
            str9 = str15;
            i3 = zIsEmpty2 ? 8 : 0;
            i4 = zIsEmpty3 ? 8 : 0;
            i5 = zIsEmpty4 ? 8 : 0;
            i6 = i11;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            buddyTypeInfo = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            i = 0;
            z = false;
            z2 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if ((j & 262148) != 0) {
            buddyTypeName = buddyTypeInfo != null ? buddyTypeInfo.getBuddyTypeName() : null;
            if ((4 & j) != 0) {
                zIsEmpty = TextUtils.isEmpty(buddyTypeName);
            }
            j2 = j & 3;
            if (j2 != 0) {
                if (z) {
                    z3 = true;
                } else {
                    z3 = zIsEmpty;
                }
                if (z) {
                    buddyTypeName = "";
                }
                if (j2 != 0) {
                    if (z3) {
                        j3 = 32;
                    } else {
                        j3 = 16;
                    }
                    j |= j3;
                }
                if (z3) {
                    i8 = 8;
                } else {
                    i8 = 0;
                }
                str10 = buddyTypeName;
                i7 = i8;
            } else {
                str10 = null;
                i7 = 0;
            }
            if ((j & 3) != 0) {
                aw9.d(((WorksItemBuddyCardBinding) this).f14489a, str7, false, null);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14488a, str4);
                ((WorksItemBuddyCardBinding) this).f14488a.setVisibility(i3);
                CommonBindingAdapter.e0(((WorksItemBuddyCardBinding) this).f14492a, z2);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14492a, str2);
                ((WorksItemBuddyCardBinding) this).f14492a.setVisibility(i2);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14494b, str);
                ((WorksItemBuddyCardBinding) this).f14494b.setVisibility(i);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14495b, str8);
                ((WorksItemBuddyCardBinding) this).f14495b.setVisibility(i4);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14497c, str5);
                int i12 = i6;
                ((WorksItemBuddyCardBinding) this).f14497c.setVisibility(i12);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14498c, str9);
                ((WorksItemBuddyCardBinding) this).f14498c.setVisibility(i5);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14499d, str6);
                TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14500d, str10);
                ((WorksItemBuddyCardBinding) this).f14500d.setVisibility(i7);
                TextViewBindingAdapter.setText(this.e, str3);
                ((WorksItemBuddyCardBinding) this).f37009a.setVisibility(i12);
                ((WorksItemBuddyCardBinding) this).f14490a.setVisibility(i12);
            }
        }
        buddyTypeName = null;
        zIsEmpty = false;
        j2 = j & 3;
        if (j2 != 0) {
            if (z) {
                z3 = true;
            } else {
                z3 = zIsEmpty;
            }
            if (z) {
                buddyTypeName = "";
            }
            if (j2 != 0) {
                if (z3) {
                    j3 = 32;
                } else {
                    j3 = 16;
                }
                j |= j3;
            }
            if (z3) {
                i8 = 8;
            } else {
                i8 = 0;
            }
            str10 = buddyTypeName;
            i7 = i8;
        } else {
            str10 = null;
            i7 = 0;
        }
        if ((j & 3) != 0) {
            aw9.d(((WorksItemBuddyCardBinding) this).f14489a, str7, false, null);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14488a, str4);
            ((WorksItemBuddyCardBinding) this).f14488a.setVisibility(i3);
            CommonBindingAdapter.e0(((WorksItemBuddyCardBinding) this).f14492a, z2);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14492a, str2);
            ((WorksItemBuddyCardBinding) this).f14492a.setVisibility(i2);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14494b, str);
            ((WorksItemBuddyCardBinding) this).f14494b.setVisibility(i);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14495b, str8);
            ((WorksItemBuddyCardBinding) this).f14495b.setVisibility(i4);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14497c, str5);
            int i13 = i6;
            ((WorksItemBuddyCardBinding) this).f14497c.setVisibility(i13);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14498c, str9);
            ((WorksItemBuddyCardBinding) this).f14498c.setVisibility(i5);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14499d, str6);
            TextViewBindingAdapter.setText(((WorksItemBuddyCardBinding) this).f14500d, str10);
            ((WorksItemBuddyCardBinding) this).f14500d.setVisibility(i7);
            TextViewBindingAdapter.setText(this.e, str3);
            ((WorksItemBuddyCardBinding) this).f37009a.setVisibility(i13);
            ((WorksItemBuddyCardBinding) this).f14490a.setVisibility(i13);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14502a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14502a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemBuddyCardBinding
    public void k(@Nullable BuddyCardBean Bean) {
        ((WorksItemBuddyCardBinding) this).f14491a = Bean;
        synchronized (this) {
            this.f14502a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((BuddyCardBean) variable);
        return true;
    }

    public WorksItemBuddyCardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (HorizontalScrollView) bindings[13], (ImageView) bindings[15], (ImageView) bindings[16], (ImageView) bindings[17], (ImageView) bindings[18], (AvatarView) bindings[1], (LinearLayout) bindings[14], (LinearLayout) bindings[20], (LinearLayout) bindings[19], (TextView) bindings[7], (BLTextView) bindings[6], (TextView) bindings[12], (BLTextView) bindings[5], (TextView) bindings[11], (BLTextView) bindings[4], (TextView) bindings[2], (BLTextView) bindings[3], (TextView) bindings[8], (View) bindings[9], (GradientRoundProgress) bindings[10]);
        this.f14502a = -1L;
        ((WorksItemBuddyCardBinding) this).f14489a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f14503a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14488a.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14492a.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14494b.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14495b.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14497c.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14498c.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14499d.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14500d.setTag(null);
        this.e.setTag(null);
        ((WorksItemBuddyCardBinding) this).f37009a.setTag(null);
        ((WorksItemBuddyCardBinding) this).f14490a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
