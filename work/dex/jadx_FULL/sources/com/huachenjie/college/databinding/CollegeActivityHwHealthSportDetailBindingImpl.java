package com.huachenjie.college.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.amap.api.maps.MapView;
import com.huachenjie.college.bean.HWHealthSportDetailBean;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityHwHealthSportDetailBindingImpl extends CollegeActivityHwHealthSportDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f8364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8365a;

    @NonNull
    public final BLConstraintLayout b;

    @NonNull
    public final LinearLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HWHealthSportDetailActivity.a f33558a;

        public a a(HWHealthSportDetailActivity.a aVar) {
            this.f33558a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33558a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(28);
        f8360a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{17}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33557a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.college.R.id.card_duration, 11);
        sparseIntArray.put(com.huachenjie.college.R.id.card_calories, 12);
        sparseIntArray.put(com.huachenjie.college.R.id.card_row2_left, 13);
        sparseIntArray.put(com.huachenjie.college.R.id.card_row2_right, 14);
        sparseIntArray.put(com.huachenjie.college.R.id.card_row3_left, 15);
        sparseIntArray.put(com.huachenjie.college.R.id.card_row3_right, 16);
        sparseIntArray.put(com.huachenjie.college.R.id.fl_bottom_btn, 18);
        sparseIntArray.put(com.huachenjie.college.R.id.cl_distance_card, 19);
        sparseIntArray.put(com.huachenjie.college.R.id.iv_distance_bg, 20);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_sport_label, 21);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_main_value, 22);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_main_unit, 23);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_start_time, 24);
        sparseIntArray.put(com.huachenjie.college.R.id.iv_heart, 25);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_heart_label, 26);
        sparseIntArray.put(com.huachenjie.college.R.id.tv_heart_value, 27);
    }

    public CollegeActivityHwHealthSportDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, f8360a, f33557a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0191  */
    /* JADX WARN: Code duplicated, block: B:105:0x019c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x019e  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:113:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:152:0x0223 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0226  */
    /* JADX WARN: Code duplicated, block: B:156:0x0229 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x022b  */
    /* JADX WARN: Code duplicated, block: B:158:0x022f  */
    /* JADX WARN: Code duplicated, block: B:161:0x0236  */
    /* JADX WARN: Code duplicated, block: B:162:0x0239  */
    /* JADX WARN: Code duplicated, block: B:163:0x023c  */
    /* JADX WARN: Code duplicated, block: B:166:0x0247 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:168:0x024a  */
    /* JADX WARN: Code duplicated, block: B:170:0x024d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x024f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0252  */
    /* JADX WARN: Code duplicated, block: B:173:0x0257  */
    /* JADX WARN: Code duplicated, block: B:176:0x0260 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x0262  */
    /* JADX WARN: Code duplicated, block: B:178:0x0270  */
    /* JADX WARN: Code duplicated, block: B:181:0x027b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0282  */
    /* JADX WARN: Code duplicated, block: B:184:0x028a  */
    /* JADX WARN: Code duplicated, block: B:189:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:192:0x02a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:194:0x02af  */
    /* JADX WARN: Code duplicated, block: B:197:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:199:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:200:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:202:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:207:0x02da  */
    /* JADX WARN: Code duplicated, block: B:210:0x02e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:212:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:213:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:217:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:220:0x02f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:222:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:224:0x02ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:225:0x0301  */
    /* JADX WARN: Code duplicated, block: B:226:0x0305  */
    /* JADX WARN: Code duplicated, block: B:229:0x030b  */
    /* JADX WARN: Code duplicated, block: B:231:0x0310  */
    /* JADX WARN: Code duplicated, block: B:234:0x0319  */
    /* JADX WARN: Code duplicated, block: B:237:0x0324  */
    /* JADX WARN: Code duplicated, block: B:240:0x0359  */
    /* JADX WARN: Code duplicated, block: B:243:0x0365  */
    /* JADX WARN: Code duplicated, block: B:246:0x037f  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x0103  */
    /* JADX WARN: Code duplicated, block: B:96:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x017b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        MutableLiveData<HWHealthSportDetailBean> mutableLiveDataO;
        String str;
        BindingTitleBean value;
        String sportType;
        boolean zEquals;
        boolean z;
        int i;
        MutableLiveData<BindingTitleBean> mutableLiveDataI;
        HWHealthSportDetailBean value2;
        a aVarA;
        boolean zEquals2;
        boolean z2;
        boolean deducted;
        boolean z3;
        int i2;
        int i3;
        long j2;
        String str2;
        long j3;
        boolean z4;
        boolean zEquals3;
        BindingTitleBean bindingTitleBean;
        int i4;
        long j4;
        int i5;
        long j5;
        MutableLiveData<BindingTitleBean> mutableLiveDataI2;
        int statusBarHeight;
        MutableLiveData<Boolean> mutableLiveDataL;
        int i6;
        Boolean value3;
        long j6;
        long j7;
        boolean z5;
        boolean zEquals4;
        int i7;
        long j8;
        long j9;
        synchronized (this) {
            j = this.f8361a;
            this.f8361a = 0L;
        }
        HWHealthSportDetailVM hWHealthSportDetailVM = ((CollegeActivityHwHealthSportDetailBinding) this).f8348a;
        HWHealthSportDetailActivity.a aVar = ((CollegeActivityHwHealthSportDetailBinding) this).f8347a;
        boolean z6 = true;
        if ((93 & j) != 0) {
            mutableLiveDataO = hWHealthSportDetailVM != null ? hWHealthSportDetailVM.o() : null;
            updateLiveDataRegistration(2, mutableLiveDataO);
            value2 = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
            long j10 = j & 84;
            if (j10 != 0) {
                str = "*数据来源：" + (value2 != null ? value2.getDataSource() : null);
            } else {
                str = null;
            }
            if ((j & 85) != 0) {
                z = value2 != null;
                if (j10 != 0) {
                    if (z) {
                        j8 = j | 4096 | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j9 = 16777216;
                    } else {
                        j8 = j | 2048 | 8192 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        j9 = 8388608;
                    }
                    j = j8 | j9;
                }
                if ((j & 85) != 0) {
                    j = z ? j | 4294967296L : j | 2147483648L;
                }
                if ((j & 84) != 0 && !z) {
                    i = 8;
                }
                if ((j & 92) != 0) {
                    if (value2 != null) {
                        sportType = value2.getSportType();
                    } else {
                        sportType = null;
                    }
                    if (sportType != null) {
                        zEquals = sportType.equals("JUMP_ROPE");
                    } else {
                        zEquals = false;
                    }
                    if ((j & 16476) != 0) {
                        if (zEquals) {
                            j |= 1048576;
                        } else {
                            j |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        }
                    }
                } else {
                    sportType = null;
                    zEquals = false;
                }
                if ((j & 88) != 0) {
                    if (hWHealthSportDetailVM != null) {
                        mutableLiveDataI = hWHealthSportDetailVM.i();
                        i7 = 3;
                    } else {
                        i7 = 3;
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(i7, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value = mutableLiveDataI.getValue();
                    } else {
                        value = null;
                    }
                } else {
                    value = null;
                    mutableLiveDataI = null;
                }
            } else {
                z = false;
            }
            i = 0;
            if ((j & 92) != 0) {
                if (value2 != null) {
                    sportType = value2.getSportType();
                } else {
                    sportType = null;
                }
                if (sportType != null) {
                    zEquals = sportType.equals("JUMP_ROPE");
                } else {
                    zEquals = false;
                }
                if ((j & 16476) != 0) {
                    if (zEquals) {
                        j |= 1048576;
                    } else {
                        j |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                }
            } else {
                sportType = null;
                zEquals = false;
            }
            if ((j & 88) != 0) {
                if (hWHealthSportDetailVM != null) {
                    mutableLiveDataI = hWHealthSportDetailVM.i();
                    i7 = 3;
                } else {
                    i7 = 3;
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(i7, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            } else {
                value = null;
                mutableLiveDataI = null;
            }
        } else {
            mutableLiveDataO = null;
            str = null;
            value = null;
            sportType = null;
            zEquals = false;
            z = false;
            i = 0;
            mutableLiveDataI = null;
            value2 = null;
        }
        if ((j & 96) == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8365a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8365a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 4312334336L) != 0) {
            if (hWHealthSportDetailVM != null) {
                mutableLiveDataO = hWHealthSportDetailVM.o();
            }
            updateLiveDataRegistration(2, mutableLiveDataO);
            if (mutableLiveDataO != null) {
                value2 = mutableLiveDataO.getValue();
            }
            if ((j & 4311744512L) != 0) {
                deducted = value2 != null ? value2.getDeducted() : false;
                z3 = (j & 4294967296L) != 0 ? !deducted : false;
                if ((j & 589824) != 0) {
                    if (value2 != null) {
                        sportType = value2.getSportType();
                    }
                    if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0 || sportType == null) {
                        zEquals2 = false;
                    } else {
                        zEquals2 = sportType.equals("SWIMMING");
                    }
                    j7 = j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    z5 = zEquals2;
                    if (j7 != 0) {
                        if (sportType != null) {
                            zEquals4 = sportType.equals("RUNNING");
                        } else {
                            zEquals4 = false;
                        }
                        if (j7 != 0) {
                            if (zEquals4) {
                                j |= 262144;
                            } else {
                                j |= 131072;
                            }
                        }
                        z2 = zEquals4;
                        zEquals2 = z5;
                    }
                } else {
                    zEquals2 = false;
                }
                z2 = false;
            } else {
                deducted = false;
            }
            if ((j & 589824) != 0) {
                if (value2 != null) {
                    sportType = value2.getSportType();
                }
                if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                    zEquals2 = false;
                } else {
                    zEquals2 = false;
                }
                j7 = j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                z5 = zEquals2;
                if (j7 != 0) {
                    if (sportType != null) {
                        zEquals4 = sportType.equals("RUNNING");
                    } else {
                        zEquals4 = false;
                    }
                    if (j7 != 0) {
                        if (zEquals4) {
                            j |= 262144;
                        } else {
                            j |= 131072;
                        }
                    }
                    z2 = zEquals4;
                    zEquals2 = z5;
                }
            } else {
                zEquals2 = false;
            }
            z2 = false;
        } else {
            zEquals2 = false;
            z2 = false;
            deducted = false;
            z3 = false;
        }
        if ((j & 16476) != 0) {
            if (zEquals) {
                zEquals2 = true;
            }
            if ((j & 84) != 0) {
                j |= zEquals2 ? 1024L : 512L;
            }
            if ((j & 92) != 0) {
                j = zEquals2 ? j | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED : j | 2097152;
            }
            long j11 = j & 84;
            if (j11 != 0) {
                int i8 = zEquals2 ? -96 : -40;
                boolean z7 = z ? zEquals2 : false;
                if (j11 != 0) {
                    j |= z7 ? 67108864L : 33554432L;
                }
                i2 = z7 ? 0 : 8;
                i3 = i8;
            }
            j2 = j & 84;
            if (j2 != 0) {
                if (!z) {
                    deducted = false;
                }
                if (j2 != 0) {
                    if (deducted) {
                        j6 = 268435456;
                    } else {
                        j6 = 134217728;
                    }
                    j |= j6;
                }
                if (deducted) {
                    str2 = "已抵扣";
                } else {
                    str2 = "阳光跑抵扣";
                }
            } else {
                str2 = null;
            }
            j3 = j & 85;
            if (j3 != 0) {
                if (!z) {
                    z3 = false;
                }
                if (j3 != 0) {
                    if (z3) {
                        j |= 256;
                    } else {
                        j |= 128;
                    }
                }
            } else {
                z3 = false;
            }
            if ((j & 256) != 0) {
                if (hWHealthSportDetailVM != null) {
                    i6 = 0;
                    mutableLiveDataL = hWHealthSportDetailVM.l();
                } else {
                    mutableLiveDataL = null;
                    i6 = 0;
                }
                updateLiveDataRegistration(i6, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value3 = mutableLiveDataL.getValue();
                } else {
                    value3 = null;
                }
                z4 = !ViewDataBinding.safeUnbox(value3);
            } else {
                value = value;
                mutableLiveDataI = mutableLiveDataI;
                z4 = false;
            }
            if ((j & 131072) != 0 || sportType == null) {
                zEquals3 = false;
            } else {
                zEquals3 = sportType.equals("CYCLING");
            }
            if ((j & 2097152) != 0) {
                if (hWHealthSportDetailVM != null) {
                    mutableLiveDataI2 = hWHealthSportDetailVM.i();
                } else {
                    mutableLiveDataI2 = mutableLiveDataI;
                }
                updateLiveDataRegistration(3, mutableLiveDataI2);
                if (mutableLiveDataI2 != null) {
                    value = mutableLiveDataI2.getValue();
                }
                if (value != null) {
                    statusBarHeight = value.getStatusBarHeight();
                } else {
                    statusBarHeight = 0;
                }
                i4 = statusBarHeight + 44;
                bindingTitleBean = value;
            } else {
                bindingTitleBean = value;
                i4 = 0;
            }
            if ((j & 85) != 0 || !z3) {
                z4 = false;
            }
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                z6 = false;
            } else if (!z2) {
                z6 = zEquals3;
            }
            if ((j & 92) != 0 || zEquals2) {
                i4 = 0;
            }
            j4 = j & 84;
            if (j4 != 0) {
                if (!z) {
                    z6 = false;
                }
                if (j4 != 0) {
                    if (z6) {
                        j5 = FileUtils.ONE_GB;
                    } else {
                        j5 = 536870912;
                    }
                    j |= j5;
                }
                i5 = z6 ? 0 : 8;
            } else {
                i5 = 0;
            }
            if ((j & 85) != 0) {
                CommonBindingAdapter.e0(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, z4);
            }
            if ((j & 84) != 0) {
                TextViewBindingAdapter.setText(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, str2);
                ((CollegeActivityHwHealthSportDetailBinding) this).f8345a.setVisibility(i5);
                CommonBindingAdapter.I(this.f8363a, 16, i3, 16, 0, null);
                this.b.setVisibility(i);
                this.c.setVisibility(i);
                TextViewBindingAdapter.setText(((CollegeActivityHwHealthSportDetailBinding) this).f8344a, str);
                ((CollegeActivityHwHealthSportDetailBinding) this).f8352a.setVisibility(i2);
            }
            if ((j & 96) != 0) {
                CommonBindingAdapter.q(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, aVarA, null);
            }
            if ((j & 92) != 0) {
                CommonBindingAdapter.I(this.f8364a, 0, i4, 0, 0, null);
            }
            if ((j & 88) != 0) {
                ((CollegeActivityHwHealthSportDetailBinding) this).f8349a.k(bindingTitleBean);
            }
            ViewDataBinding.executeBindingsOn(((CollegeActivityHwHealthSportDetailBinding) this).f8349a);
        }
        zEquals2 = false;
        i2 = 0;
        i3 = 0;
        j2 = j & 84;
        if (j2 != 0) {
            if (!z) {
                deducted = false;
            }
            if (j2 != 0) {
                if (deducted) {
                    j6 = 268435456;
                } else {
                    j6 = 134217728;
                }
                j |= j6;
            }
            if (deducted) {
                str2 = "已抵扣";
            } else {
                str2 = "阳光跑抵扣";
            }
        } else {
            str2 = null;
        }
        j3 = j & 85;
        if (j3 != 0) {
            if (!z) {
                z3 = false;
            }
            if (j3 != 0) {
                if (z3) {
                    j |= 256;
                } else {
                    j |= 128;
                }
            }
        } else {
            z3 = false;
        }
        if ((j & 256) != 0) {
            if (hWHealthSportDetailVM != null) {
                i6 = 0;
                mutableLiveDataL = hWHealthSportDetailVM.l();
            } else {
                mutableLiveDataL = null;
                i6 = 0;
            }
            updateLiveDataRegistration(i6, mutableLiveDataL);
            if (mutableLiveDataL != null) {
                value3 = mutableLiveDataL.getValue();
            } else {
                value3 = null;
            }
            z4 = !ViewDataBinding.safeUnbox(value3);
        } else {
            value = value;
            mutableLiveDataI = mutableLiveDataI;
            z4 = false;
        }
        if ((j & 131072) != 0) {
            zEquals3 = false;
        } else {
            zEquals3 = false;
        }
        if ((j & 2097152) != 0) {
            if (hWHealthSportDetailVM != null) {
                mutableLiveDataI2 = hWHealthSportDetailVM.i();
            } else {
                mutableLiveDataI2 = mutableLiveDataI;
            }
            updateLiveDataRegistration(3, mutableLiveDataI2);
            if (mutableLiveDataI2 != null) {
                value = mutableLiveDataI2.getValue();
            }
            if (value != null) {
                statusBarHeight = value.getStatusBarHeight();
            } else {
                statusBarHeight = 0;
            }
            i4 = statusBarHeight + 44;
            bindingTitleBean = value;
        } else {
            bindingTitleBean = value;
            i4 = 0;
        }
        if ((j & 85) != 0) {
            z4 = false;
        } else {
            z4 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            z6 = false;
        } else if (!z2) {
            z6 = zEquals3;
        }
        if ((j & 92) != 0) {
            i4 = 0;
        } else {
            i4 = 0;
        }
        j4 = j & 84;
        if (j4 != 0) {
            if (!z) {
                z6 = false;
            }
            if (j4 != 0) {
                if (z6) {
                    j5 = FileUtils.ONE_GB;
                } else {
                    j5 = 536870912;
                }
                j |= j5;
            }
            i5 = z6 ? 0 : 8;
        } else {
            i5 = 0;
        }
        if ((j & 85) != 0) {
            CommonBindingAdapter.e0(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, z4);
        }
        if ((j & 84) != 0) {
            TextViewBindingAdapter.setText(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, str2);
            ((CollegeActivityHwHealthSportDetailBinding) this).f8345a.setVisibility(i5);
            CommonBindingAdapter.I(this.f8363a, 16, i3, 16, 0, null);
            this.b.setVisibility(i);
            this.c.setVisibility(i);
            TextViewBindingAdapter.setText(((CollegeActivityHwHealthSportDetailBinding) this).f8344a, str);
            ((CollegeActivityHwHealthSportDetailBinding) this).f8352a.setVisibility(i2);
        }
        if ((j & 96) != 0) {
            CommonBindingAdapter.q(((CollegeActivityHwHealthSportDetailBinding) this).f8351a, aVarA, null);
        }
        if ((j & 92) != 0) {
            CommonBindingAdapter.I(this.f8364a, 0, i4, 0, 0, null);
        }
        if ((j & 88) != 0) {
            ((CollegeActivityHwHealthSportDetailBinding) this).f8349a.k(bindingTitleBean);
        }
        ViewDataBinding.executeBindingsOn(((CollegeActivityHwHealthSportDetailBinding) this).f8349a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8361a != 0) {
                return true;
            }
            return ((CollegeActivityHwHealthSportDetailBinding) this).f8349a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8361a = 64L;
        }
        ((CollegeActivityHwHealthSportDetailBinding) this).f8349a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHwHealthSportDetailBinding
    public void l(@Nullable HWHealthSportDetailActivity.a aVar) {
        ((CollegeActivityHwHealthSportDetailBinding) this).f8347a = aVar;
        synchronized (this) {
            this.f8361a |= 32;
        }
        notifyPropertyChanged(uk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHwHealthSportDetailBinding
    public void m(@Nullable HWHealthSportDetailVM hWHealthSportDetailVM) {
        ((CollegeActivityHwHealthSportDetailBinding) this).f8348a = hWHealthSportDetailVM;
        synchronized (this) {
            this.f8361a |= 16;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8361a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8361a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<HWHealthSportDetailBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8361a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8361a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8349a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 == i) {
            m((HWHealthSportDetailVM) obj);
        } else {
            if (uk0.k != i) {
                return false;
            }
            l((HWHealthSportDetailActivity.a) obj);
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollegeActivityHwHealthSportDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        BLTextView bLTextView = (BLTextView) objArr[1];
        Object obj = objArr[12];
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBindingA = obj != null ? CollegeItemSportDetailCardBinding.a((View) obj) : null;
        Object obj2 = objArr[11];
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBindingA2 = obj2 != null ? CollegeItemSportDetailCardBinding.a((View) obj2) : null;
        Object obj3 = objArr[13];
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBindingA3 = obj3 != null ? CollegeItemSportDetailCardBinding.a((View) obj3) : null;
        Object obj4 = objArr[14];
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBindingA4 = obj4 != null ? CollegeItemSportDetailCardBinding.a((View) obj4) : null;
        Object obj5 = objArr[15];
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBindingA5 = obj5 != null ? CollegeItemSportDetailCardBinding.a((View) obj5) : null;
        Object obj6 = objArr[16];
        super(dataBindingComponent, view, 4, bLTextView, collegeItemSportDetailCardBindingA, collegeItemSportDetailCardBindingA2, collegeItemSportDetailCardBindingA3, collegeItemSportDetailCardBindingA4, collegeItemSportDetailCardBindingA5, obj6 != null ? CollegeItemSportDetailCardBinding.a((View) obj6) : null, (BLConstraintLayout) objArr[19], (FrameLayout) objArr[18], (ImageView) objArr[20], (ImageView) objArr[25], (LinearLayout) objArr[9], (LinearLayout) objArr[10], (MapView) objArr[3], (LayoutToolbarBindingBinding) objArr[17], (TextView) objArr[6], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[23], (TextView) objArr[22], (TextView) objArr[21], (TextView) objArr[24], (BLView) objArr[4]);
        this.f8361a = -1L;
        ((CollegeActivityHwHealthSportDetailBinding) this).f8351a.setTag(null);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8343a.setTag(null);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8353b.setTag(null);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8345a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8362a = relativeLayout;
        relativeLayout.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[2];
        this.f8364a = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[5];
        this.f8363a = constraintLayout;
        constraintLayout.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[7];
        this.b = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.c = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((CollegeActivityHwHealthSportDetailBinding) this).f8349a);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8344a.setTag(null);
        ((CollegeActivityHwHealthSportDetailBinding) this).f8352a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
