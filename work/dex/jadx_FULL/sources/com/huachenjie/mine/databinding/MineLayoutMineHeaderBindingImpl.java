package com.huachenjie.mine.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.mine.R;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.page.home.MineFragment;
import com.huachenjie.mine.page.home.MineVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineLayoutMineHeaderBindingImpl extends MineLayoutMineHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11349a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f11352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f11356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f11357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f11358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f11359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f11360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f11361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f11362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f11363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11364a;

    @NonNull
    public final DrawableCenterButton b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11365c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f11366c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView g;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35351a;

        public a a(MineFragment.a aVar) {
            this.f35351a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35351a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35352a;

        public b a(MineFragment.a aVar) {
            this.f35352a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35352a.l(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35353a;

        public c a(MineFragment.a aVar) {
            this.f35353a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35353a.f(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35354a;

        public d a(MineFragment.a aVar) {
            this.f35354a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35354a.j(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35355a;

        public e a(MineFragment.a aVar) {
            this.f35355a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35355a.k(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35356a;

        public f a(MineFragment.a aVar) {
            this.f35356a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35356a.d(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35357a;

        public g a(MineFragment.a aVar) {
            this.f35357a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35357a.s(view);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35358a;

        public h a(MineFragment.a aVar) {
            this.f35358a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35358a.h(view);
        }
    }

    public static class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35359a;

        public i a(MineFragment.a aVar) {
            this.f35359a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35359a.i(view);
        }
    }

    public static class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35360a;

        public j a(MineFragment.a aVar) {
            this.f35360a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35360a.g(view);
        }
    }

    public static class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35361a;

        public k a(MineFragment.a aVar) {
            this.f35361a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35361a.r(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35350a = sparseIntArray;
        sparseIntArray.put(R.id.vBottomSpace, 20);
        sparseIntArray.put(R.id.ll_tags_wrap, 21);
        sparseIntArray.put(R.id.iv_mine_qr_code, 22);
        sparseIntArray.put(R.id.iv_passport, 23);
        sparseIntArray.put(R.id.tv_passport_title, 24);
    }

    public MineLayoutMineHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 25, f11349a, f35350a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:111:0x020e  */
    /* JADX WARN: Code duplicated, block: B:113:0x023b  */
    /* JADX WARN: Code duplicated, block: B:221:0x047f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:222:0x0481  */
    /* JADX WARN: Code duplicated, block: B:223:0x0483  */
    /* JADX WARN: Code duplicated, block: B:226:0x048a  */
    /* JADX WARN: Code duplicated, block: B:227:0x04be  */
    /* JADX WARN: Code duplicated, block: B:230:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:231:0x051c  */
    /* JADX WARN: Code duplicated, block: B:234:0x0525  */
    /* JADX WARN: Code duplicated, block: B:237:0x055b  */
    /* JADX WARN: Code duplicated, block: B:240:0x0568  */
    /* JADX WARN: Code duplicated, block: B:242:0x0571  */
    /* JADX WARN: Code duplicated, block: B:244:0x057a  */
    /* JADX WARN: Code duplicated, block: B:247:0x0589  */
    /* JADX WARN: Code duplicated, block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x0105  */
    /* JADX WARN: Code duplicated, block: B:60:0x010b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0112  */
    /* JADX WARN: Code duplicated, block: B:64:0x011a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x011c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0129  */
    /* JADX WARN: Code duplicated, block: B:68:0x0140  */
    /* JADX WARN: Code duplicated, block: B:70:0x0147  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:73:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0151  */
    /* JADX WARN: Code duplicated, block: B:75:0x015a  */
    /* JADX WARN: Code duplicated, block: B:78:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x016a  */
    /* JADX WARN: Code duplicated, block: B:80:0x016f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0177  */
    /* JADX WARN: Code duplicated, block: B:85:0x017b  */
    /* JADX WARN: Code duplicated, block: B:86:0x017e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0186  */
    /* JADX WARN: Code duplicated, block: B:90:0x0195  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:96:0x01c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        String str;
        Drawable drawable;
        CharSequence charSequence;
        String str2;
        String str3;
        boolean z;
        CharSequence charSequence2;
        String str4;
        boolean z2;
        String str5;
        CharSequence charSequence3;
        Boolean bool;
        MutableLiveData<MineData> mutableLiveData;
        MineData value;
        MutableLiveData<MineMateData> mutableLiveData2;
        boolean z3;
        MutableLiveData<Boolean> mutableLiveData3;
        boolean bisVip;
        MineMateData value2;
        int i2;
        RequestOptions requestOptions;
        String str6;
        int i3;
        boolean zSafeUnbox;
        String themeImg;
        f fVar;
        d dVar;
        i iVar;
        k kVar;
        b bVar;
        c cVar;
        e eVarA;
        g gVar;
        h hVar;
        j jVar;
        a aVarA;
        long j4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        long j5;
        RequestOptions requestOptions2;
        long j6;
        long j7;
        MutableLiveData<Boolean> mutableLiveDataO;
        int i4;
        int iSafeUnbox;
        boolean z8;
        MutableLiveData<MineData> mutableLiveDataM;
        MineData value3;
        String avatar;
        String nickName;
        CharSequence charSequence4;
        String slogan;
        CharSequence charSequence5;
        CharSequence charSequence6;
        int colorFromResource;
        boolean z9;
        MutableLiveData<MineMateData> mutableLiveDataN;
        String avatarFrameImgUrl;
        long j8;
        MutableLiveData<Boolean> mutableLiveDataO2;
        int i5;
        Boolean value4;
        boolean z10;
        long j9;
        boolean bisVip2;
        int i6;
        Drawable drawable2;
        int vipPerksNum;
        String alumniId;
        synchronized (this) {
            j2 = this.f11350a;
            this.f11350a = 0L;
        }
        MineVM mineVM = ((MineLayoutMineHeaderBinding) this).f11344a;
        MineFragment.a aVar = ((MineLayoutMineHeaderBinding) this).f11343a;
        if ((95 & j2) != 0) {
            RequestOptions bgOptions = ((j2 & 84) == 0 || mineVM == null) ? null : mineVM.getBgOptions();
            if ((j2 & 81) != 0) {
                BaseViewModel.b bVarE = mineVM != null ? mineVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j10 = j2 & 90;
            if (j10 != 0) {
                mutableLiveDataM = mineVM != null ? mineVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                value3 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                nickName = value3 != null ? value3.getNickName() : null;
                z8 = !TextUtils.isEmpty(nickName);
                if (j10 != 0) {
                    j2 = z8 ? j2 | PlaybackStateCompat.ACTION_PREPARE : j2 | 8192;
                }
                if ((j2 & 82) != 0) {
                    if (value3 != null) {
                        avatar = value3.getAvatar();
                        charSequence4 = value3.formatterFollowedCount();
                        slogan = value3.getSlogan();
                        alumniId = value3.getAlumniId();
                        charSequence5 = value3.formatterLikeCount();
                        charSequence6 = value3.formatterFollowCount();
                    } else {
                        avatar = null;
                        charSequence4 = null;
                        slogan = null;
                        alumniId = null;
                        charSequence5 = null;
                        charSequence6 = null;
                    }
                    boolean zIsEmpty = TextUtils.isEmpty(slogan);
                    str4 = String.format("ID：%s", alumniId);
                    z2 = !zIsEmpty;
                } else {
                    z2 = false;
                    str4 = null;
                    avatar = null;
                }
                if ((j2 & 86) != 0) {
                    if (mineVM != null) {
                        mutableLiveDataN = mineVM.n();
                    } else {
                        mutableLiveDataN = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataN);
                    if (mutableLiveDataN != null) {
                        value2 = mutableLiveDataN.getValue();
                    } else {
                        value2 = null;
                    }
                    j9 = j2 & 84;
                    if (j9 != 0) {
                        if (value2 != null) {
                            avatarFrameImgUrl = value2.getAvatarFrameImgUrl();
                            themeImg = value2.getThemeImg();
                            vipPerksNum = value2.getVipPerksNum();
                        } else {
                            avatarFrameImgUrl = null;
                            themeImg = null;
                            vipPerksNum = 0;
                        }
                        str6 = String.format("办理黑金护照解锁%d大权益", Integer.valueOf(vipPerksNum));
                    } else {
                        str6 = null;
                        avatarFrameImgUrl = null;
                        themeImg = null;
                    }
                    if (value2 != null) {
                        bisVip2 = value2.getBisVip();
                    } else {
                        bisVip2 = false;
                    }
                    if (j9 != 0) {
                        if (bisVip2) {
                            j2 = j2 | 256 | 1024;
                        } else {
                            j2 = j2 | 128 | 512;
                        }
                    }
                    if ((j2 & 86) != 0) {
                        if (bisVip2) {
                            j2 |= 4096;
                        } else {
                            j2 |= 2048;
                        }
                    }
                    if ((j2 & 84) != 0) {
                        TextView textView = super.e;
                        if (bisVip2) {
                            i6 = R.color.hcj_vip_txt_color;
                        } else {
                            i6 = R.color.color_191F20;
                        }
                        colorFromResource = ViewDataBinding.getColorFromResource(textView, i6);
                        if (bisVip2) {
                            drawable2 = AppCompatResources.getDrawable(((MineLayoutMineHeaderBinding) this).f11340a.getContext(), R.drawable.mine_bg_qr_code_vip);
                        } else {
                            drawable2 = AppCompatResources.getDrawable(((MineLayoutMineHeaderBinding) this).f11340a.getContext(), R.drawable.mine_bg_qr_code);
                        }
                        z9 = bisVip2;
                        drawable = drawable2;
                        j2 = j2;
                    } else {
                        z9 = bisVip2;
                        drawable = null;
                        colorFromResource = 0;
                    }
                } else {
                    str6 = null;
                    drawable = null;
                    colorFromResource = 0;
                    z9 = false;
                    mutableLiveDataN = null;
                    value2 = null;
                    avatarFrameImgUrl = null;
                    themeImg = null;
                }
                j8 = j2 & 92;
                if (j8 != 0) {
                    if (mineVM != null) {
                        i5 = 3;
                        mutableLiveDataO2 = mineVM.o();
                    } else {
                        mutableLiveDataO2 = null;
                        i5 = 3;
                    }
                    updateLiveDataRegistration(i5, mutableLiveDataO2);
                    if (mutableLiveDataO2 != null) {
                        value4 = mutableLiveDataO2.getValue();
                    } else {
                        value4 = null;
                    }
                    z10 = !ViewDataBinding.safeUnbox(value4);
                    if (j8 != 0) {
                        if (z10) {
                            j2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        } else {
                            j2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                    }
                    j3 = 0;
                    if ((j2 & 88) != 0) {
                        zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z10));
                    } else {
                        zSafeUnbox = false;
                    }
                    requestOptions = bgOptions;
                    charSequence = charSequence6;
                    bisVip = z9;
                    str3 = nickName;
                    mutableLiveData = mutableLiveDataM;
                    z = z8;
                    value = value3;
                    charSequence2 = charSequence4;
                    mutableLiveData2 = mutableLiveDataN;
                    str5 = slogan;
                    z3 = z10;
                    i3 = iSafeUnbox;
                    charSequence3 = charSequence5;
                    mutableLiveData3 = mutableLiveDataO2;
                    str = avatarFrameImgUrl;
                    i2 = colorFromResource;
                    str2 = avatar;
                    bool = value4;
                    drawable = drawable;
                } else {
                    String str7 = str6;
                    j3 = 0;
                    i3 = iSafeUnbox;
                    charSequence3 = charSequence5;
                    str = avatarFrameImgUrl;
                    themeImg = themeImg;
                    str6 = str7;
                    mutableLiveData3 = null;
                    zSafeUnbox = false;
                    requestOptions = bgOptions;
                    i2 = colorFromResource;
                    str2 = avatar;
                    charSequence = charSequence6;
                    bool = null;
                    bisVip = z9;
                    str3 = nickName;
                    mutableLiveData = mutableLiveDataM;
                    z = z8;
                    value = value3;
                    charSequence2 = charSequence4;
                    mutableLiveData2 = mutableLiveDataN;
                    str5 = slogan;
                    z3 = false;
                }
            } else {
                z2 = false;
                z8 = false;
                mutableLiveDataM = null;
                value3 = null;
                str4 = null;
                avatar = null;
                nickName = null;
            }
            charSequence4 = null;
            slogan = null;
            charSequence5 = null;
            charSequence6 = null;
            if ((j2 & 86) != 0) {
                if (mineVM != null) {
                    mutableLiveDataN = mineVM.n();
                } else {
                    mutableLiveDataN = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value2 = mutableLiveDataN.getValue();
                } else {
                    value2 = null;
                }
                j9 = j2 & 84;
                if (j9 != 0) {
                    if (value2 != null) {
                        avatarFrameImgUrl = value2.getAvatarFrameImgUrl();
                        themeImg = value2.getThemeImg();
                        vipPerksNum = value2.getVipPerksNum();
                    } else {
                        avatarFrameImgUrl = null;
                        themeImg = null;
                        vipPerksNum = 0;
                    }
                    str6 = String.format("办理黑金护照解锁%d大权益", Integer.valueOf(vipPerksNum));
                } else {
                    str6 = null;
                    avatarFrameImgUrl = null;
                    themeImg = null;
                }
                if (value2 != null) {
                    bisVip2 = value2.getBisVip();
                } else {
                    bisVip2 = false;
                }
                if (j9 != 0) {
                    if (bisVip2) {
                        j2 = j2 | 256 | 1024;
                    } else {
                        j2 = j2 | 128 | 512;
                    }
                }
                if ((j2 & 86) != 0) {
                    if (bisVip2) {
                        j2 |= 4096;
                    } else {
                        j2 |= 2048;
                    }
                }
                if ((j2 & 84) != 0) {
                    TextView textView2 = super.e;
                    if (bisVip2) {
                        i6 = R.color.hcj_vip_txt_color;
                    } else {
                        i6 = R.color.color_191F20;
                    }
                    colorFromResource = ViewDataBinding.getColorFromResource(textView2, i6);
                    if (bisVip2) {
                        drawable2 = AppCompatResources.getDrawable(((MineLayoutMineHeaderBinding) this).f11340a.getContext(), R.drawable.mine_bg_qr_code_vip);
                    } else {
                        drawable2 = AppCompatResources.getDrawable(((MineLayoutMineHeaderBinding) this).f11340a.getContext(), R.drawable.mine_bg_qr_code);
                    }
                    z9 = bisVip2;
                    drawable = drawable2;
                    j2 = j2;
                } else {
                    z9 = bisVip2;
                    drawable = null;
                    colorFromResource = 0;
                }
            } else {
                str6 = null;
                drawable = null;
                colorFromResource = 0;
                z9 = false;
                mutableLiveDataN = null;
                value2 = null;
                avatarFrameImgUrl = null;
                themeImg = null;
            }
            j8 = j2 & 92;
            if (j8 != 0) {
                if (mineVM != null) {
                    i5 = 3;
                    mutableLiveDataO2 = mineVM.o();
                } else {
                    mutableLiveDataO2 = null;
                    i5 = 3;
                }
                updateLiveDataRegistration(i5, mutableLiveDataO2);
                if (mutableLiveDataO2 != null) {
                    value4 = mutableLiveDataO2.getValue();
                } else {
                    value4 = null;
                }
                z10 = !ViewDataBinding.safeUnbox(value4);
                if (j8 != 0) {
                    if (z10) {
                        j2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j2 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                }
                j3 = 0;
                if ((j2 & 88) != 0) {
                    zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z10));
                } else {
                    zSafeUnbox = false;
                }
                requestOptions = bgOptions;
                charSequence = charSequence6;
                bisVip = z9;
                str3 = nickName;
                mutableLiveData = mutableLiveDataM;
                z = z8;
                value = value3;
                charSequence2 = charSequence4;
                mutableLiveData2 = mutableLiveDataN;
                str5 = slogan;
                z3 = z10;
                i3 = iSafeUnbox;
                charSequence3 = charSequence5;
                mutableLiveData3 = mutableLiveDataO2;
                str = avatarFrameImgUrl;
                i2 = colorFromResource;
                str2 = avatar;
                bool = value4;
                drawable = drawable;
            } else {
                String str8 = str6;
                j3 = 0;
                i3 = iSafeUnbox;
                charSequence3 = charSequence5;
                str = avatarFrameImgUrl;
                themeImg = themeImg;
                str6 = str8;
                mutableLiveData3 = null;
                zSafeUnbox = false;
                requestOptions = bgOptions;
                i2 = colorFromResource;
                str2 = avatar;
                charSequence = charSequence6;
                bool = null;
                bisVip = z9;
                str3 = nickName;
                mutableLiveData = mutableLiveDataM;
                z = z8;
                value = value3;
                charSequence2 = charSequence4;
                mutableLiveData2 = mutableLiveDataN;
                str5 = slogan;
                z3 = false;
            }
        } else {
            j3 = 0;
            str = null;
            drawable = null;
            charSequence = null;
            str2 = null;
            str3 = null;
            z = false;
            charSequence2 = null;
            str4 = null;
            z2 = false;
            str5 = null;
            charSequence3 = null;
            bool = null;
            mutableLiveData = null;
            value = null;
            mutableLiveData2 = null;
            z3 = false;
            mutableLiveData3 = null;
            bisVip = false;
            value2 = null;
            i2 = 0;
            requestOptions = null;
            str6 = null;
            i3 = 0;
            zSafeUnbox = false;
            themeImg = null;
        }
        if ((j2 & 96) == j3 || aVar == null) {
            fVar = null;
            dVar = null;
            iVar = null;
            kVar = null;
            bVar = null;
            cVar = null;
            eVarA = null;
            gVar = null;
            hVar = null;
            jVar = null;
            aVarA = null;
        } else {
            k kVar2 = this.f11363a;
            if (kVar2 == null) {
                kVar2 = new k();
                this.f11363a = kVar2;
            }
            k kVarA = kVar2.a(aVar);
            b bVar2 = this.f11354a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f11354a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            c cVar2 = this.f11355a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f11355a = cVar2;
            }
            c cVarA = cVar2.a(aVar);
            d dVar2 = this.f11356a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f11356a = dVar2;
            }
            d dVarA = dVar2.a(aVar);
            e eVar = this.f11357a;
            if (eVar == null) {
                eVar = new e();
                this.f11357a = eVar;
            }
            eVarA = eVar.a(aVar);
            f fVar2 = this.f11358a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f11358a = fVar2;
            }
            f fVarA = fVar2.a(aVar);
            g gVar2 = this.f11359a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f11359a = gVar2;
            }
            g gVarA = gVar2.a(aVar);
            h hVar2 = this.f11360a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f11360a = hVar2;
            }
            h hVarA = hVar2.a(aVar);
            i iVar2 = this.f11361a;
            if (iVar2 == null) {
                iVar2 = new i();
                this.f11361a = iVar2;
            }
            i iVarA = iVar2.a(aVar);
            j jVar2 = this.f11362a;
            if (jVar2 == null) {
                jVar2 = new j();
                this.f11362a = jVar2;
            }
            j jVarA = jVar2.a(aVar);
            a aVar2 = this.f11353a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11353a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            dVar = dVarA;
            gVar = gVarA;
            hVar = hVarA;
            iVar = iVarA;
            jVar = jVarA;
            cVar = cVarA;
            bVar = bVarA;
            kVar = kVarA;
            fVar = fVarA;
        }
        if ((j2 & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            if (mineVM != null) {
                i4 = 3;
                mutableLiveDataO = mineVM.o();
            } else {
                mutableLiveDataO = mutableLiveData3;
                i4 = 3;
            }
            updateLiveDataRegistration(i4, mutableLiveDataO);
            z3 = !ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : bool);
            j4 = 0;
            if ((j2 & 92) != 0) {
                j2 = z3 ? j2 | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j2 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
        } else {
            dVar = dVar;
            iVar = iVar;
            j4 = 0;
        }
        boolean z11 = ((j2 & 90) == j4 || !z) ? false : z3;
        if ((j2 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != j4) {
            MutableLiveData<MineMateData> mutableLiveDataN2 = mineVM != null ? mineVM.n() : mutableLiveData2;
            updateLiveDataRegistration(2, mutableLiveDataN2);
            if (mutableLiveDataN2 != null) {
                value2 = mutableLiveDataN2.getValue();
            }
            if (value2 != null) {
                bisVip = value2.getBisVip();
            }
            if ((j2 & 84) != 0) {
                if (bisVip) {
                    j6 = j2 | 256;
                    j7 = 1024;
                } else {
                    j6 = j2 | 128;
                    j7 = 512;
                }
                j2 = j6 | j7;
            }
            if ((j2 & 86) != 0) {
                j2 = bisVip ? j2 | 4096 : j2 | 2048;
            }
            z5 = !bisVip;
            z4 = bisVip;
        } else {
            z11 = z11;
            z4 = bisVip;
            z5 = false;
        }
        long j11 = j2 & 92;
        if (j11 == 0 || !z3) {
            z5 = false;
        }
        if ((j2 & 2048) != 0) {
            MutableLiveData<MineData> mutableLiveDataM2 = mineVM != null ? mineVM.m() : mutableLiveData;
            z6 = true;
            updateLiveDataRegistration(1, mutableLiveDataM2);
            if (mutableLiveDataM2 != null) {
                value = mutableLiveDataM2.getValue();
            }
            List<String> tagList = value != null ? value.getTagList() : null;
            z7 = (tagList != null ? tagList.size() : 0) > 0;
            j5 = j2 & 86;
            if (j5 != 0) {
                z7 = false;
            } else if (z4) {
                z7 = z6;
            }
            if ((j2 & 82) != 0) {
                aw9.d(((MineLayoutMineHeaderBinding) this).f11342a, str2, false, null);
                TextViewBindingAdapter.setText(this.f11364a, str4);
                TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).f11341a, charSequence);
                CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11348b, z2);
                TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).f11348b, str5);
                TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).c, charSequence2);
                TextViewBindingAdapter.setText(super.d, charSequence3);
                CommonBindingAdapter.l0(super.e, z);
                TextViewBindingAdapter.setText(super.e, str3);
            }
            if ((j2 & 96) != 0) {
                requestOptions2 = null;
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11342a, fVar, null);
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11340a, dVar, null);
                CommonBindingAdapter.q(this.f11352a, iVar, null);
                CommonBindingAdapter.q(this.b, eVarA, null);
                CommonBindingAdapter.q(this.f11366c, cVar, null);
                b bVar3 = bVar;
                CommonBindingAdapter.q(this.d, bVar3, null);
                CommonBindingAdapter.q(this.e, kVar, null);
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11345a, gVar, null);
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11341a, aVarA, null);
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11348b, hVar, null);
                CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).c, jVar, null);
                CommonBindingAdapter.q(super.e, bVar3, null);
            } else {
                requestOptions2 = null;
            }
            if ((j2 & 84) != 0) {
                aw9.c(((MineLayoutMineHeaderBinding) this).f11342a, str, requestOptions2);
                ViewBindingAdapter.setBackground(((MineLayoutMineHeaderBinding) this).f11340a, drawable);
                TextViewBindingAdapter.setText(this.g, str6);
                CommonBindingAdapter.b0(this.c, themeImg, requestOptions, false);
                CommonBindingAdapter.l0(this.e, z4);
                super.e.setTextColor(i2);
            }
            if ((88 & j2) != 0) {
                CommonBindingAdapter.l0(this.f11365c, zSafeUnbox);
            }
            if ((j2 & 90) != 0) {
                CommonBindingAdapter.l0(this.d, z11);
            }
            if (j11 != 0) {
                CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11345a, z5);
            }
            if (j5 != 0) {
                CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11338a, z7);
            }
            if ((j2 & 81) != 0) {
                CommonBindingAdapter.I(((MineLayoutMineHeaderBinding) this).f35349a, 0, i3, 0, 0, null);
            }
        }
        z5 = z5;
        z6 = true;
        j5 = j2 & 86;
        if (j5 != 0) {
            z7 = false;
        } else if (z4) {
            z7 = z6;
        }
        if ((j2 & 82) != 0) {
            aw9.d(((MineLayoutMineHeaderBinding) this).f11342a, str2, false, null);
            TextViewBindingAdapter.setText(this.f11364a, str4);
            TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).f11341a, charSequence);
            CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11348b, z2);
            TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).f11348b, str5);
            TextViewBindingAdapter.setText(((MineLayoutMineHeaderBinding) this).c, charSequence2);
            TextViewBindingAdapter.setText(super.d, charSequence3);
            CommonBindingAdapter.l0(super.e, z);
            TextViewBindingAdapter.setText(super.e, str3);
        }
        if ((j2 & 96) != 0) {
            requestOptions2 = null;
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11342a, fVar, null);
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11340a, dVar, null);
            CommonBindingAdapter.q(this.f11352a, iVar, null);
            CommonBindingAdapter.q(this.b, eVarA, null);
            CommonBindingAdapter.q(this.f11366c, cVar, null);
            b bVar4 = bVar;
            CommonBindingAdapter.q(this.d, bVar4, null);
            CommonBindingAdapter.q(this.e, kVar, null);
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11345a, gVar, null);
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11341a, aVarA, null);
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).f11348b, hVar, null);
            CommonBindingAdapter.q(((MineLayoutMineHeaderBinding) this).c, jVar, null);
            CommonBindingAdapter.q(super.e, bVar4, null);
        } else {
            requestOptions2 = null;
        }
        if ((j2 & 84) != 0) {
            aw9.c(((MineLayoutMineHeaderBinding) this).f11342a, str, requestOptions2);
            ViewBindingAdapter.setBackground(((MineLayoutMineHeaderBinding) this).f11340a, drawable);
            TextViewBindingAdapter.setText(this.g, str6);
            CommonBindingAdapter.b0(this.c, themeImg, requestOptions, false);
            CommonBindingAdapter.l0(this.e, z4);
            super.e.setTextColor(i2);
        }
        if ((88 & j2) != 0) {
            CommonBindingAdapter.l0(this.f11365c, zSafeUnbox);
        }
        if ((j2 & 90) != 0) {
            CommonBindingAdapter.l0(this.d, z11);
        }
        if (j11 != 0) {
            CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11345a, z5);
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(((MineLayoutMineHeaderBinding) this).f11338a, z7);
        }
        if ((j2 & 81) != 0) {
            CommonBindingAdapter.I(((MineLayoutMineHeaderBinding) this).f35349a, 0, i3, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11350a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11350a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineLayoutMineHeaderBinding
    public void l(@Nullable MineFragment.a aVar) {
        ((MineLayoutMineHeaderBinding) this).f11343a = aVar;
        synchronized (this) {
            this.f11350a |= 32;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineLayoutMineHeaderBinding
    public void m(@Nullable MineVM mineVM) {
        ((MineLayoutMineHeaderBinding) this).f11344a = mineVM;
        synchronized (this) {
            this.f11350a |= 16;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<MineData> mutableLiveData, int i2) {
        if (i2 != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11350a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<MineMateData> mutableLiveData, int i2) {
        if (i2 != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11350a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return q((MutableLiveData) obj, i3);
        }
        if (i2 == 1) {
            return n((MutableLiveData) obj, i3);
        }
        if (i2 == 2) {
            return o((MutableLiveData) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return p((MutableLiveData) obj, i3);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i2) {
        if (i2 != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11350a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i2) {
        if (i2 != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11350a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (ik0.p0 == i2) {
            m((MineVM) obj);
        } else {
            if (ik0.k != i2) {
                return false;
            }
            l((MineFragment.a) obj);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public MineLayoutMineHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (AvatarView) objArr[3], (ImageView) objArr[22], (ImageView) objArr[23], (LinearLayout) objArr[8], (LinearLayout) objArr[21], (BLRelativeLayout) objArr[14], (HorizontalScrollView) objArr[6], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[12], (TextView) objArr[11], (TextView) objArr[4], (TextView) objArr[24], (BLView) objArr[20], (View) objArr[1]);
        this.f11350a = -1L;
        ((MineLayoutMineHeaderBinding) this).f11342a.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f11340a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11351a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.g = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[16];
        this.f11365c = linearLayout;
        linearLayout.setTag(null);
        ?? r0 = (DrawableCenterButton) objArr[17];
        this.f11352a = r0;
        r0.setTag(null);
        ?? r1 = (DrawableCenterButton) objArr[18];
        this.b = r1;
        r1.setTag(null);
        ?? r2 = (DrawableCenterButton) objArr[19];
        this.f11366c = r2;
        r2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.c = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.d = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[7];
        this.e = imageView3;
        imageView3.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[9];
        this.f11364a = bLTextView;
        bLTextView.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f11345a.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f11338a.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f11341a.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f11348b.setTag(null);
        ((MineLayoutMineHeaderBinding) this).c.setTag(null);
        super.d.setTag(null);
        super.e.setTag(null);
        ((MineLayoutMineHeaderBinding) this).f35349a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
