package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OfficialChannelBean;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.bean.PostCategoryDataBean;
import com.huachenjie.works.bean.ThisSchoolBean;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolVM;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksHeadThisSchoolBindingImpl extends WorksHeadThisSchoolBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14415a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f14422a;

    @NonNull
    public final View b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView j;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolFragment.ClickProxy f36989a;

        public a a(ThisSchoolFragment.ClickProxy value) {
            this.f36989a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36989a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolFragment.ClickProxy f36990a;

        public b a(ThisSchoolFragment.ClickProxy value) {
            this.f36990a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36990a.b(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolFragment.ClickProxy f36991a;

        public c a(ThisSchoolFragment.ClickProxy value) {
            this.f36991a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36991a.e(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolFragment.ClickProxy f36992a;

        public d a(ThisSchoolFragment.ClickProxy value) {
            this.f36992a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36992a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36988a = sparseIntArray;
        sparseIntArray.put(R.id.tv_new, 22);
    }

    public WorksHeadThisSchoolBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 23, f14415a, f36988a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:101:0x01de  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:106:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:113:0x0234  */
    /* JADX WARN: Code duplicated, block: B:114:0x0268  */
    /* JADX WARN: Code duplicated, block: B:75:0x0167 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0169  */
    /* JADX WARN: Code duplicated, block: B:77:0x016e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0174  */
    /* JADX WARN: Code duplicated, block: B:81:0x017b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0181  */
    /* JADX WARN: Code duplicated, block: B:86:0x018a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x018c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0191  */
    /* JADX WARN: Code duplicated, block: B:91:0x0198  */
    /* JADX WARN: Code duplicated, block: B:92:0x019f  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d6  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str7;
        boolean z7;
        int i;
        String str8;
        String name;
        String str9;
        boolean z8;
        String str10;
        String str11;
        String str12;
        int i2;
        boolean z9;
        int i3;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        a aVar;
        b bVar;
        c cVarA;
        d dVar;
        Object drawable;
        int iSafeUnbox;
        boolean zShowBanner;
        boolean zShowOfficialChannel;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean zIsEmpty;
        String str13;
        String str14;
        String str15;
        String strFindUserAvatar;
        String strFindUserAvatar2;
        String strFindUserAvatar3;
        String logo;
        int iSafeUnbox2;
        int iSafeUnbox3;
        boolean zSafeUnbox;
        MutableLiveData<PostCategoryDataBean> mutableLiveDataO;
        PostCategoryDataBean value;
        boolean zShowTag;
        PostCategoryBean postCategoryBeanFindCategory;
        PostCategoryBean postCategoryBeanFindCategory2;
        PostCategoryBean postCategoryBeanFindCategory3;
        PostCategoryBean postCategoryBeanFindCategory4;
        PostCategoryBean postCategoryBeanFindCategory5;
        PostCategoryBean postCategoryBeanFindCategory6;
        String name2;
        String name3;
        String name4;
        String name5;
        String name6;
        MutableLiveData<Boolean> mutableLiveDataT;
        Boolean value2;
        OfficialChannelBean officialChannel;
        OfficialChannelBean officialChannelBeanFindOfficialChannel;
        String channelUserValue;
        String channelName;
        synchronized (this) {
            j = this.f14416a;
            this.f14416a = 0L;
        }
        ThisSchoolVM thisSchoolVM = ((WorksHeadThisSchoolBinding) this).f14407a;
        ThisSchoolFragment.ClickProxy clickProxy = ((WorksHeadThisSchoolBinding) this).f14406a;
        if ((383 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<Integer> mutableLiveDataU = thisSchoolVM != null ? thisSchoolVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataU != null ? mutableLiveDataU.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j2 = j & 322;
            if (j2 != 0) {
                MutableLiveData<ThisSchoolBean> mutableLiveDataR = thisSchoolVM != null ? thisSchoolVM.r() : null;
                updateLiveDataRegistration(1, mutableLiveDataR);
                ThisSchoolBean value3 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                if (value3 != null) {
                    officialChannel = value3.getOfficialChannel();
                    zShowOfficialChannel = value3.showOfficialChannel();
                    strFindUserAvatar = value3.findUserAvatar(0);
                    strFindUserAvatar2 = value3.findUserAvatar(2);
                    strFindUserAvatar3 = value3.findUserAvatar(1);
                    officialChannelBeanFindOfficialChannel = value3.findOfficialChannel();
                    zShowBanner = value3.showBanner();
                } else {
                    zShowBanner = false;
                    zShowOfficialChannel = false;
                    officialChannel = null;
                    strFindUserAvatar = null;
                    strFindUserAvatar2 = null;
                    strFindUserAvatar3 = null;
                    officialChannelBeanFindOfficialChannel = null;
                }
                String coverUrl = officialChannel != null ? officialChannel.getCoverUrl() : null;
                z10 = !zShowOfficialChannel;
                boolean zIsEmpty2 = TextUtils.isEmpty(strFindUserAvatar);
                boolean zIsEmpty3 = TextUtils.isEmpty(strFindUserAvatar2);
                boolean zIsEmpty4 = TextUtils.isEmpty(strFindUserAvatar3);
                if (officialChannelBeanFindOfficialChannel != null) {
                    channelName = officialChannelBeanFindOfficialChannel.getChannelName();
                    logo = officialChannelBeanFindOfficialChannel.getLogo();
                    channelUserValue = officialChannelBeanFindOfficialChannel.getChannelUserValue();
                } else {
                    channelUserValue = null;
                    channelName = null;
                    logo = null;
                }
                zIsEmpty = TextUtils.isEmpty(coverUrl);
                z11 = !zIsEmpty2;
                z12 = !zIsEmpty3;
                z13 = !zIsEmpty4;
                str13 = String.format("@%s", channelName);
                str14 = String.format("已加入%s校友", channelUserValue);
                str15 = coverUrl;
                if (j2 != 0) {
                    j |= zIsEmpty ? 1024L : 512L;
                    str15 = coverUrl;
                }
            } else {
                zShowBanner = false;
                zShowOfficialChannel = false;
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
                zIsEmpty = false;
                str13 = null;
                str14 = null;
                str15 = null;
                strFindUserAvatar = null;
                strFindUserAvatar2 = null;
                strFindUserAvatar3 = null;
                logo = null;
            }
            if ((j & 356) != 0) {
                BaseViewModel.b bVarE = thisSchoolVM != null ? thisSchoolVM.e() : null;
                if ((j & 324) != 0) {
                    MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                    updateLiveDataRegistration(2, mutableLiveDataB);
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                } else {
                    iSafeUnbox2 = 0;
                }
                if ((j & 352) != 0) {
                    MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                    updateLiveDataRegistration(5, mutableLiveDataC);
                    iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
                }
                if ((j & 328) != 0) {
                    if (thisSchoolVM != null) {
                        mutableLiveDataT = thisSchoolVM.t();
                    } else {
                        mutableLiveDataT = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveDataT);
                    if (mutableLiveDataT != null) {
                        value2 = mutableLiveDataT.getValue();
                    } else {
                        value2 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value2);
                } else {
                    zSafeUnbox = false;
                }
                if ((j & 336) != 0) {
                    if (thisSchoolVM != null) {
                        mutableLiveDataO = thisSchoolVM.o();
                    } else {
                        mutableLiveDataO = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataO);
                    if (mutableLiveDataO != null) {
                        value = mutableLiveDataO.getValue();
                    } else {
                        value = null;
                    }
                    if (value != null) {
                        postCategoryBeanFindCategory3 = value.findCategory(1);
                        postCategoryBeanFindCategory4 = value.findCategory(3);
                        postCategoryBeanFindCategory5 = value.findCategory(5);
                        postCategoryBeanFindCategory6 = value.findCategory(0);
                        postCategoryBeanFindCategory2 = value.findCategory(2);
                        postCategoryBeanFindCategory = value.findCategory(4);
                        zShowTag = value.showTag();
                    } else {
                        zShowTag = false;
                        postCategoryBeanFindCategory = null;
                        postCategoryBeanFindCategory2 = null;
                        postCategoryBeanFindCategory3 = null;
                        postCategoryBeanFindCategory4 = null;
                        postCategoryBeanFindCategory5 = null;
                        postCategoryBeanFindCategory6 = null;
                    }
                    if (postCategoryBeanFindCategory3 != null) {
                        name2 = postCategoryBeanFindCategory3.getName();
                    } else {
                        name2 = null;
                    }
                    if (postCategoryBeanFindCategory4 != null) {
                        name3 = postCategoryBeanFindCategory4.getName();
                    } else {
                        name3 = null;
                    }
                    if (postCategoryBeanFindCategory5 != null) {
                        name4 = postCategoryBeanFindCategory5.getName();
                    } else {
                        name4 = null;
                    }
                    if (postCategoryBeanFindCategory6 != null) {
                        name5 = postCategoryBeanFindCategory6.getName();
                    } else {
                        name5 = null;
                    }
                    if (postCategoryBeanFindCategory2 != null) {
                        name6 = postCategoryBeanFindCategory2.getName();
                    } else {
                        name6 = null;
                    }
                    if (postCategoryBeanFindCategory != null) {
                        str10 = name6;
                        i2 = iSafeUnbox3;
                        z2 = z10;
                        str6 = str14;
                        str8 = name4;
                        z3 = z12;
                        str4 = logo;
                        str11 = name2;
                        str9 = name3;
                        str = strFindUserAvatar3;
                        boolean z14 = z13;
                        z8 = zShowTag;
                        z = zShowOfficialChannel;
                        z7 = zIsEmpty;
                        str12 = name5;
                        z5 = z14;
                        boolean z15 = z11;
                        name = postCategoryBeanFindCategory.getName();
                        j = j;
                        i3 = iSafeUnbox;
                        z9 = zSafeUnbox;
                        z4 = zShowBanner;
                        str2 = strFindUserAvatar2;
                        z6 = z15;
                        int i4 = iSafeUnbox2;
                        str5 = str13;
                        str3 = strFindUserAvatar;
                        i = i4;
                        str7 = str15;
                    } else {
                        str10 = name6;
                        i2 = iSafeUnbox3;
                        z2 = z10;
                        str6 = str14;
                        str8 = name4;
                        z3 = z12;
                        str4 = logo;
                        str11 = name2;
                        str9 = name3;
                        str = strFindUserAvatar3;
                        j = j;
                        i3 = iSafeUnbox;
                        z9 = zSafeUnbox;
                        z4 = zShowBanner;
                        str2 = strFindUserAvatar2;
                        z6 = z11;
                        name = null;
                        boolean z16 = z13;
                        z8 = zShowTag;
                        z = zShowOfficialChannel;
                        z7 = zIsEmpty;
                        str12 = name5;
                        z5 = z16;
                        int i5 = iSafeUnbox2;
                        str5 = str13;
                        str3 = strFindUserAvatar;
                        i = i5;
                        str7 = str15;
                    }
                } else {
                    i2 = iSafeUnbox3;
                    z = zShowOfficialChannel;
                    str = strFindUserAvatar3;
                    z2 = z10;
                    z3 = z12;
                    z5 = z13;
                    z7 = zIsEmpty;
                    str8 = null;
                    str9 = null;
                    z8 = false;
                    str10 = null;
                    str12 = null;
                    i3 = iSafeUnbox;
                    str6 = str14;
                    z9 = zSafeUnbox;
                    z4 = zShowBanner;
                    str2 = strFindUserAvatar2;
                    z6 = z11;
                    str4 = logo;
                    name = null;
                    str11 = null;
                    int i6 = iSafeUnbox2;
                    str5 = str13;
                    str3 = strFindUserAvatar;
                    i = i6;
                    str7 = str15;
                }
            } else {
                iSafeUnbox2 = 0;
            }
            iSafeUnbox3 = 0;
            if ((j & 328) != 0) {
                if (thisSchoolVM != null) {
                    mutableLiveDataT = thisSchoolVM.t();
                } else {
                    mutableLiveDataT = null;
                }
                updateLiveDataRegistration(3, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value2 = mutableLiveDataT.getValue();
                } else {
                    value2 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value2);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 336) != 0) {
                if (thisSchoolVM != null) {
                    mutableLiveDataO = thisSchoolVM.o();
                } else {
                    mutableLiveDataO = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value = mutableLiveDataO.getValue();
                } else {
                    value = null;
                }
                if (value != null) {
                    postCategoryBeanFindCategory3 = value.findCategory(1);
                    postCategoryBeanFindCategory4 = value.findCategory(3);
                    postCategoryBeanFindCategory5 = value.findCategory(5);
                    postCategoryBeanFindCategory6 = value.findCategory(0);
                    postCategoryBeanFindCategory2 = value.findCategory(2);
                    postCategoryBeanFindCategory = value.findCategory(4);
                    zShowTag = value.showTag();
                } else {
                    zShowTag = false;
                    postCategoryBeanFindCategory = null;
                    postCategoryBeanFindCategory2 = null;
                    postCategoryBeanFindCategory3 = null;
                    postCategoryBeanFindCategory4 = null;
                    postCategoryBeanFindCategory5 = null;
                    postCategoryBeanFindCategory6 = null;
                }
                if (postCategoryBeanFindCategory3 != null) {
                    name2 = postCategoryBeanFindCategory3.getName();
                } else {
                    name2 = null;
                }
                if (postCategoryBeanFindCategory4 != null) {
                    name3 = postCategoryBeanFindCategory4.getName();
                } else {
                    name3 = null;
                }
                if (postCategoryBeanFindCategory5 != null) {
                    name4 = postCategoryBeanFindCategory5.getName();
                } else {
                    name4 = null;
                }
                if (postCategoryBeanFindCategory6 != null) {
                    name5 = postCategoryBeanFindCategory6.getName();
                } else {
                    name5 = null;
                }
                if (postCategoryBeanFindCategory2 != null) {
                    name6 = postCategoryBeanFindCategory2.getName();
                } else {
                    name6 = null;
                }
                if (postCategoryBeanFindCategory != null) {
                    str10 = name6;
                    i2 = iSafeUnbox3;
                    z2 = z10;
                    str6 = str14;
                    str8 = name4;
                    z3 = z12;
                    str4 = logo;
                    str11 = name2;
                    str9 = name3;
                    str = strFindUserAvatar3;
                    boolean z17 = z13;
                    z8 = zShowTag;
                    z = zShowOfficialChannel;
                    z7 = zIsEmpty;
                    str12 = name5;
                    z5 = z17;
                    boolean z18 = z11;
                    name = postCategoryBeanFindCategory.getName();
                    j = j;
                    i3 = iSafeUnbox;
                    z9 = zSafeUnbox;
                    z4 = zShowBanner;
                    str2 = strFindUserAvatar2;
                    z6 = z18;
                    int i7 = iSafeUnbox2;
                    str5 = str13;
                    str3 = strFindUserAvatar;
                    i = i7;
                    str7 = str15;
                } else {
                    str10 = name6;
                    i2 = iSafeUnbox3;
                    z2 = z10;
                    str6 = str14;
                    str8 = name4;
                    z3 = z12;
                    str4 = logo;
                    str11 = name2;
                    str9 = name3;
                    str = strFindUserAvatar3;
                    j = j;
                    i3 = iSafeUnbox;
                    z9 = zSafeUnbox;
                    z4 = zShowBanner;
                    str2 = strFindUserAvatar2;
                    z6 = z11;
                    name = null;
                    boolean z19 = z13;
                    z8 = zShowTag;
                    z = zShowOfficialChannel;
                    z7 = zIsEmpty;
                    str12 = name5;
                    z5 = z19;
                    int i8 = iSafeUnbox2;
                    str5 = str13;
                    str3 = strFindUserAvatar;
                    i = i8;
                    str7 = str15;
                }
            } else {
                i2 = iSafeUnbox3;
                z = zShowOfficialChannel;
                str = strFindUserAvatar3;
                z2 = z10;
                z3 = z12;
                z5 = z13;
                z7 = zIsEmpty;
                str8 = null;
                str9 = null;
                z8 = false;
                str10 = null;
                str12 = null;
                i3 = iSafeUnbox;
                str6 = str14;
                z9 = zSafeUnbox;
                z4 = zShowBanner;
                str2 = strFindUserAvatar2;
                z6 = z11;
                str4 = logo;
                name = null;
                str11 = null;
                int i9 = iSafeUnbox2;
                str5 = str13;
                str3 = strFindUserAvatar;
                i = i9;
                str7 = str15;
            }
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            str7 = null;
            z7 = false;
            i = 0;
            str8 = null;
            name = null;
            str9 = null;
            z8 = false;
            str10 = null;
            str11 = null;
            str12 = null;
            i2 = 0;
            z9 = false;
            i3 = 0;
        }
        long j3 = j & 322;
        if (j3 != 0) {
            RequestOptions requestOptions3 = ju3.h;
            requestOptions = ju3.b;
            requestOptions2 = requestOptions3;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        long j4 = j & 384;
        if (j4 == 0 || clickProxy == null) {
            aVar = null;
            bVar = null;
            cVarA = null;
            dVar = null;
        } else {
            d dVar2 = this.f14422a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f14422a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            a aVar2 = this.f14419a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14419a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            dVar = dVarA;
            b bVar2 = this.f14420a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f14420a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar = this.f14421a;
            if (cVar == null) {
                cVar = new c();
                this.f14421a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            aVar = aVarA;
            bVar = bVarA;
        }
        if (j3 != 0) {
            drawable = z7 ? AppCompatResources.getDrawable(((WorksHeadThisSchoolBinding) this).f14404a.getContext(), R.drawable.base_bg_channel_main_head) : str7;
        } else {
            bVar = bVar;
            cVarA = cVarA;
            drawable = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(((WorksHeadThisSchoolBinding) this).f14410a, z4);
            CommonBindingAdapter.b0(((WorksHeadThisSchoolBinding) this).f14408a, str4, requestOptions, false);
            CommonBindingAdapter.b0(((WorksHeadThisSchoolBinding) this).f14404a, drawable, requestOptions2, false);
            CommonBindingAdapter.l0(((WorksHeadThisSchoolBinding) this).f14412b, z6);
            CommonBindingAdapter.b0(((WorksHeadThisSchoolBinding) this).f14412b, str3, requestOptions, false);
            CommonBindingAdapter.l0(((WorksHeadThisSchoolBinding) this).f14413c, z5);
            CommonBindingAdapter.b0(((WorksHeadThisSchoolBinding) this).f14413c, str, requestOptions, false);
            CommonBindingAdapter.l0(((WorksHeadThisSchoolBinding) this).f14414d, z3);
            CommonBindingAdapter.b0(((WorksHeadThisSchoolBinding) this).f14414d, str2, requestOptions, false);
            CommonBindingAdapter.l0(this.b, z2);
            TextViewBindingAdapter.setText(this.j, str6);
            CommonBindingAdapter.l0(this.f14418a, z);
            TextViewBindingAdapter.setText(((WorksHeadThisSchoolBinding) this).f14411b, str5);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((WorksHeadThisSchoolBinding) this).f14409a, aVar, null);
            CommonBindingAdapter.q(((WorksHeadThisSchoolBinding) this).b, cVarA, null);
            CommonBindingAdapter.q(((WorksHeadThisSchoolBinding) this).f14405a, bVar, null);
            d dVar3 = dVar;
            CommonBindingAdapter.q(((WorksHeadThisSchoolBinding) this).d, dVar3, null);
            CommonBindingAdapter.q(this.e, dVar3, null);
            CommonBindingAdapter.q(this.f, dVar3, null);
            CommonBindingAdapter.q(this.g, dVar3, null);
            CommonBindingAdapter.q(this.h, dVar3, null);
            CommonBindingAdapter.q(this.i, dVar3, null);
        }
        if ((j & 324) != 0) {
            CommonBindingAdapter.I(((WorksHeadThisSchoolBinding) this).f36987a, 0, i, 0, 0, null);
        }
        if ((j & 321) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            float f = i3;
            ((WorksHeadThisSchoolBinding) this).f14404a.setTranslationY(f);
            this.c.setTranslationY(f);
        }
        if ((j & 328) != 0) {
            CommonBindingAdapter.l0(((WorksHeadThisSchoolBinding) this).b, z9);
        }
        if ((j & 352) != 0) {
            CommonBindingAdapter.G(this.b, i2);
        }
        if ((j & 336) != 0) {
            TextViewBindingAdapter.setText(((WorksHeadThisSchoolBinding) this).d, str12);
            TextViewBindingAdapter.setText(this.e, str11);
            TextViewBindingAdapter.setText(this.f, str10);
            boolean z20 = z8;
            CommonBindingAdapter.l0(this.g, z20);
            TextViewBindingAdapter.setText(this.g, str9);
            CommonBindingAdapter.l0(this.h, z20);
            TextViewBindingAdapter.setText(this.h, name);
            CommonBindingAdapter.l0(this.i, z20);
            TextViewBindingAdapter.setText(this.i, str8);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14416a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14416a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadThisSchoolBinding
    public void l(@Nullable ThisSchoolFragment.ClickProxy Click) {
        ((WorksHeadThisSchoolBinding) this).f14406a = Click;
        synchronized (this) {
            this.f14416a |= 128;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadThisSchoolBinding
    public void m(@Nullable ThisSchoolVM Vm) {
        ((WorksHeadThisSchoolBinding) this).f14407a = Vm;
        synchronized (this) {
            this.f14416a |= 64;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<PostCategoryDataBean> VmPostCategoryData, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ThisSchoolBean> VmSchoolBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return s((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 4) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 5) {
            return false;
        }
        return r((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Boolean> VmShowSwitchSchool, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 32;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> VmVerticalOffset, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14416a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((ThisSchoolVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((ThisSchoolFragment.ClickProxy) variable);
        }
        return true;
    }

    public WorksHeadThisSchoolBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (Banner) bindings[14], (BLTextView) bindings[7], (View) bindings[5], (BLImageView) bindings[6], (ImageView) bindings[3], (ImageView) bindings[9], (BLImageView) bindings[10], (BLImageView) bindings[11], (BLImageView) bindings[12], (TextView) bindings[15], (TextView) bindings[8], (TextView) bindings[22], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[19], (TextView) bindings[20], (TextView) bindings[21]);
        this.f14416a = -1L;
        ((WorksHeadThisSchoolBinding) this).f14410a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14409a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f36987a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14408a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14404a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).b.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14412b.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14413c.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14414d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14417a = linearLayout;
        linearLayout.setTag(null);
        View view = (View) bindings[1];
        this.b = view;
        view.setTag(null);
        TextView textView = (TextView) bindings[13];
        this.j = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[2];
        this.f14418a = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) bindings[4];
        this.c = view2;
        view2.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14405a.setTag(null);
        ((WorksHeadThisSchoolBinding) this).f14411b.setTag(null);
        ((WorksHeadThisSchoolBinding) this).d.setTag("0");
        this.e.setTag("1");
        this.f.setTag("2");
        this.g.setTag("3");
        this.h.setTag("4");
        this.i.setTag("5");
        setRootTag(root);
        invalidateAll();
    }
}
