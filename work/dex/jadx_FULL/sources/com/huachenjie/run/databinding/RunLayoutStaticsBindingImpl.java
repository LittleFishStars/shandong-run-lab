package com.huachenjie.run.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.flexbox.FlexboxLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ai9;
import com.zj.adlib.aw9;
import com.zj.adlib.lk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutStaticsBindingImpl extends RunLayoutStaticsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f12193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12195a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLTextView f12196c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f12197e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f12198f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35709a;

        public a a(RunDetailActivity.a value) {
            this.f35709a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35709a.d(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35710a;

        public b a(RunDetailActivity.a value) {
            this.f35710a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35710a.b(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(26);
        f12190a = includedLayouts;
        includedLayouts.setIncludes(21, new String[]{"run_layout_metrics_content"}, new int[]{23}, new int[]{R.layout.run_layout_metrics_content});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35708a = sparseIntArray;
        sparseIntArray.put(R.id.cl_statics_card, 24);
        sparseIntArray.put(R.id.flex_tags, 25);
    }

    public RunLayoutStaticsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 26, f12190a, f35708a));
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0228 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:112:0x024f  */
    /* JADX WARN: Code duplicated, block: B:115:0x025b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x025d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0260  */
    /* JADX WARN: Code duplicated, block: B:119:0x0264 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0266  */
    /* JADX WARN: Code duplicated, block: B:121:0x026a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0271  */
    /* JADX WARN: Code duplicated, block: B:127:0x027d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x027f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0284  */
    /* JADX WARN: Code duplicated, block: B:131:0x0288  */
    /* JADX WARN: Code duplicated, block: B:132:0x028b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0295 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x0297  */
    /* JADX WARN: Code duplicated, block: B:138:0x029c  */
    /* JADX WARN: Code duplicated, block: B:140:0x029f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:142:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:148:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:151:0x02bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:155:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:157:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:158:0x0345  */
    /* JADX WARN: Code duplicated, block: B:161:0x0350  */
    /* JADX WARN: Code duplicated, block: B:164:0x035e  */
    /* JADX WARN: Code duplicated, block: B:167:0x0379  */
    /* JADX WARN: Code duplicated, block: B:168:0x0389  */
    /* JADX WARN: Code duplicated, block: B:171:0x0391  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0092  */
    /* JADX WARN: Code duplicated, block: B:38:0x0099  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:47:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x010e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0112  */
    /* JADX WARN: Code duplicated, block: B:53:0x011f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0121  */
    /* JADX WARN: Code duplicated, block: B:57:0x0125  */
    /* JADX WARN: Code duplicated, block: B:58:0x0127  */
    /* JADX WARN: Code duplicated, block: B:60:0x012a  */
    /* JADX WARN: Code duplicated, block: B:61:0x012e  */
    /* JADX WARN: Code duplicated, block: B:64:0x013f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0142  */
    /* JADX WARN: Code duplicated, block: B:68:0x0148  */
    /* JADX WARN: Code duplicated, block: B:69:0x014a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0152  */
    /* JADX WARN: Code duplicated, block: B:73:0x0154  */
    /* JADX WARN: Code duplicated, block: B:75:0x0157  */
    /* JADX WARN: Code duplicated, block: B:76:0x0159  */
    /* JADX WARN: Code duplicated, block: B:79:0x0162 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0164  */
    /* JADX WARN: Code duplicated, block: B:81:0x0168  */
    /* JADX WARN: Code duplicated, block: B:85:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0175  */
    /* JADX WARN: Code duplicated, block: B:87:0x0178  */
    /* JADX WARN: Code duplicated, block: B:91:0x0182 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0184  */
    /* JADX WARN: Code duplicated, block: B:93:0x0189  */
    /* JADX WARN: Code duplicated, block: B:96:0x019b  */
    /* JADX WARN: Code duplicated, block: B:97:0x019e  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatarFrameImgUrl;
        String avatar;
        boolean z;
        int i;
        String str;
        boolean z2;
        boolean z3;
        String str2;
        String str3;
        int i2;
        String str4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        List<RunRecordStatusLog> list;
        String str5;
        String str6;
        Drawable drawable;
        String str7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str8;
        a aVarA;
        b bVar;
        long j2;
        long j3;
        boolean z12;
        boolean z13;
        long j4;
        boolean z14;
        boolean z15;
        long j5;
        boolean z16;
        RequestOptions requestOptions;
        long j6;
        int size;
        long j7;
        Drawable drawable2;
        String strJ;
        String strK;
        long j8;
        MutableLiveData<RunDetailEntity> mutableLiveDataL;
        RunDetailEntity value;
        int i3;
        boolean z17;
        List<RunRecordStatusLog> statusLogRecords;
        String recordStatus;
        int sunRunRecordStatus;
        int i4;
        boolean zIsValid;
        String reward;
        String validDistance;
        String activityReward;
        String totalDistanceText;
        boolean zIsMorningFlag;
        String runTimeRange;
        int i5;
        int i6;
        boolean z18;
        int i7;
        int i8;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        int i9;
        long j9;
        long j10;
        long j11;
        synchronized (this) {
            j = this.f12191a;
            this.f12191a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutStaticsBinding) this).f12184a;
        RunDetailActivity.a aVar = ((RunLayoutStaticsBinding) this).f12183a;
        if ((j & 32) != 0) {
            avatarFrameImgUrl = ai9.e().getAvatarFrameImgUrl();
            avatar = ai9.e().getAvatar();
        } else {
            avatarFrameImgUrl = null;
            avatar = null;
        }
        if ((45 & j) != 0) {
            long j12 = j & 41;
            if (j12 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = runDetailVM != null ? runDetailVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j12 != 0) {
                    j |= zSafeUnbox ? 128L : 64L;
                }
                drawable2 = zSafeUnbox ? AppCompatResources.getDrawable(this.b.getContext(), R.drawable.run_run_ic_detail_eye_on) : AppCompatResources.getDrawable(this.b.getContext(), R.drawable.run_run_ic_detail_eye_off);
                if (runDetailVM != null) {
                    strK = runDetailVM.k(zSafeUnbox);
                    strJ = runDetailVM.j(zSafeUnbox);
                }
                j8 = j & 44;
                if (j8 != 0) {
                    if (runDetailVM != null) {
                        mutableLiveDataL = runDetailVM.l();
                    } else {
                        mutableLiveDataL = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataL);
                    if (mutableLiveDataL != null) {
                        value = mutableLiveDataL.getValue();
                    } else {
                        value = null;
                    }
                    if (value != null) {
                        recordStatus = value.formatRecordStatus();
                        sunRunRecordStatus = value.getSunRunRecordStatus();
                        int sportType = value.getSportType();
                        boolean runActivityFlag = value.getRunActivityFlag();
                        int recordStatusBg = value.getRecordStatusBg();
                        zIsValid = value.isValid();
                        reward = value.getReward();
                        validDistance = value.formatValidDistance();
                        int runScene = value.getRunScene();
                        activityReward = value.formatActivityReward();
                        int alignType = value.getAlignType();
                        totalDistanceText = value.formatTotalDistanceText();
                        zIsMorningFlag = value.isMorningFlag();
                        runTimeRange = value.formatRunTimeRange();
                        statusLogRecords = value.getStatusLogRecords();
                        i3 = sportType;
                        z17 = runActivityFlag;
                        i4 = recordStatusBg;
                        i5 = runScene;
                        i6 = alignType;
                    } else {
                        i3 = 0;
                        z17 = false;
                        statusLogRecords = null;
                        recordStatus = null;
                        sunRunRecordStatus = 0;
                        i4 = 0;
                        zIsValid = false;
                        reward = null;
                        validDistance = null;
                        activityReward = null;
                        totalDistanceText = null;
                        zIsMorningFlag = false;
                        runTimeRange = null;
                        i5 = 0;
                        i6 = 0;
                    }
                    if (j8 != 0) {
                        if (zIsValid) {
                            j11 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        } else {
                            j11 = 262144;
                        }
                        j |= j11;
                    }
                    boolean zIsEmpty = TextUtils.isEmpty(recordStatus);
                    if (sunRunRecordStatus == 10) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (i3 == 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (zIsValid) {
                        i7 = RunIndexRecordAdapter.K;
                    } else {
                        i7 = RunIndexRecordAdapter.L;
                    }
                    boolean zIsEmpty2 = TextUtils.isEmpty(reward);
                    int i10 = i7;
                    boolean z23 = z17;
                    i8 = i5;
                    if (i8 == 20) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (i8 == 30) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    boolean z24 = z20;
                    if (i6 == 3) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    if (statusLogRecords == null) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    if ((j & 44) != 0) {
                        if (z7) {
                            j10 = 131072;
                        } else {
                            j10 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        }
                        j |= j10;
                    }
                    if ((j & 44) != 0) {
                        if (z21) {
                            j9 = 8192;
                        } else {
                            j9 = 4096;
                        }
                        j |= j9;
                    }
                    if ((j & 44) != 0) {
                        if (z22) {
                            j |= 512;
                        } else {
                            j |= 256;
                        }
                    }
                    boolean z25 = !zIsEmpty;
                    long j13 = j;
                    Resources resources = super.d.getResources();
                    if (z7) {
                        i9 = R.string.sunshine_run_name;
                    } else {
                        i9 = R.string.free_run_name;
                    }
                    String string = resources.getString(i9);
                    z = true;
                    boolean z26 = !zIsEmpty2;
                    list = statusLogRecords;
                    z11 = z25;
                    str8 = validDistance;
                    z5 = z23;
                    runDetailVM = runDetailVM;
                    str6 = strJ;
                    avatar = avatar;
                    str4 = recordStatus;
                    i = i4;
                    i2 = i10;
                    z6 = zIsMorningFlag;
                    z8 = z19;
                    z10 = z18;
                    avatarFrameImgUrl = avatarFrameImgUrl;
                    str5 = strK;
                    str3 = totalDistanceText;
                    str7 = string;
                    z3 = z21;
                    z4 = z22;
                    str = runTimeRange;
                    z9 = z24;
                    z2 = z26;
                    j = j13;
                    String str9 = activityReward;
                    drawable = drawable2;
                    str2 = str9;
                } else {
                    z = true;
                    drawable = drawable2;
                    str6 = strJ;
                    str5 = strK;
                    i = 0;
                    str = null;
                    z2 = false;
                    z3 = false;
                    str2 = null;
                    str3 = null;
                    i2 = 0;
                    str4 = null;
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    list = null;
                }
                if ((j & 48) != 0 || aVar == null) {
                    aVarA = null;
                    bVar = null;
                } else {
                    b bVar2 = this.f12195a;
                    if (bVar2 == null) {
                        bVar2 = new b();
                        this.f12195a = bVar2;
                    }
                    b bVarA = bVar2.a(aVar);
                    a aVar2 = this.f12194a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f12194a = aVar2;
                    }
                    aVarA = aVar2.a(aVar);
                    bVar = bVarA;
                }
                j2 = j & 44;
                if (j2 != 0) {
                    if (z3) {
                        z12 = z;
                    } else {
                        z12 = z10;
                    }
                    if (j2 != 0) {
                        if (z12) {
                            j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        } else {
                            j7 = PlaybackStateCompat.ACTION_PREPARE;
                        }
                        j |= j7;
                    }
                    j3 = 256;
                } else {
                    j3 = 256;
                    z12 = false;
                }
                if ((j & j3) == 0) {
                    z13 = false;
                } else {
                    if (list != null) {
                        size = list.size();
                    } else {
                        size = 0;
                    }
                    if (size == 0) {
                        z13 = z;
                    } else {
                        z13 = false;
                    }
                }
                j4 = j & 44;
                if (j4 != 0) {
                    if (z4) {
                        z13 = z;
                    }
                    z14 = z13;
                } else {
                    z14 = false;
                }
                if (j4 != 0) {
                    if (z12) {
                        z15 = z;
                    } else {
                        z15 = z9;
                    }
                    if (j4 != 0) {
                        if (z15) {
                            j6 = 2048;
                        } else {
                            j6 = 1024;
                        }
                        j |= j6;
                    }
                } else {
                    z15 = false;
                }
                j5 = j & 44;
                if (j5 != 0) {
                    if (!z15) {
                        z = z8;
                    }
                    z16 = z;
                } else {
                    z16 = false;
                }
                if (j5 != 0) {
                    CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f35707a, z5);
                    CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12179a, z7);
                    CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).b, z14);
                    CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12186a, z16);
                    this.f12197e.setTextColor(i2);
                    TextViewBindingAdapter.setText(this.f12198f, str);
                    TextViewBindingAdapter.setText(this.g, str3);
                    TextViewBindingAdapter.setText(this.h, str2);
                    CommonBindingAdapter.l0(this.h, z2);
                    CommonBindingAdapter.l0(this.f12196c, z6);
                    TextViewBindingAdapter.setText(this.i, str4);
                    CommonBindingAdapter.x(this.i, i);
                    CommonBindingAdapter.l0(this.i, z11);
                    CommonBindingAdapter.l0(this.c, z3);
                    boolean z27 = z10;
                    CommonBindingAdapter.l0(this.d, z27);
                    CommonBindingAdapter.l0(this.e, z9);
                    CommonBindingAdapter.l0(this.f, z8);
                    TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12180a, str8);
                    ((RunLayoutStaticsBinding) this).f12180a.setTextColor(i2);
                    TextViewBindingAdapter.setText(super.d, str7);
                    CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12189b, z27);
                }
                if ((40 & j) != 0) {
                    ((RunLayoutStaticsBinding) this).f12182a.k(runDetailVM);
                }
                if ((41 & j) != 0) {
                    ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
                    TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12188b, str6);
                    TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).c, str5);
                }
                if ((j & 48) != 0) {
                    requestOptions = null;
                    CommonBindingAdapter.q(this.b, aVarA, null);
                    CommonBindingAdapter.q(((RunLayoutStaticsBinding) this).f12187a, bVar, null);
                } else {
                    requestOptions = null;
                }
                if ((j & 32) != 0) {
                    aw9.d(this.f12193a, avatar, false, requestOptions);
                    aw9.c(this.f12193a, avatarFrameImgUrl, requestOptions);
                }
                ViewDataBinding.executeBindingsOn(((RunLayoutStaticsBinding) this).f12182a);
            }
            drawable2 = null;
            strJ = null;
            strK = null;
            j8 = j & 44;
            if (j8 != 0) {
                if (runDetailVM != null) {
                    mutableLiveDataL = runDetailVM.l();
                } else {
                    mutableLiveDataL = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
                if (value != null) {
                    recordStatus = value.formatRecordStatus();
                    sunRunRecordStatus = value.getSunRunRecordStatus();
                    int sportType2 = value.getSportType();
                    boolean runActivityFlag2 = value.getRunActivityFlag();
                    int recordStatusBg2 = value.getRecordStatusBg();
                    zIsValid = value.isValid();
                    reward = value.getReward();
                    validDistance = value.formatValidDistance();
                    int runScene2 = value.getRunScene();
                    activityReward = value.formatActivityReward();
                    int alignType2 = value.getAlignType();
                    totalDistanceText = value.formatTotalDistanceText();
                    zIsMorningFlag = value.isMorningFlag();
                    runTimeRange = value.formatRunTimeRange();
                    statusLogRecords = value.getStatusLogRecords();
                    i3 = sportType2;
                    z17 = runActivityFlag2;
                    i4 = recordStatusBg2;
                    i5 = runScene2;
                    i6 = alignType2;
                } else {
                    i3 = 0;
                    z17 = false;
                    statusLogRecords = null;
                    recordStatus = null;
                    sunRunRecordStatus = 0;
                    i4 = 0;
                    zIsValid = false;
                    reward = null;
                    validDistance = null;
                    activityReward = null;
                    totalDistanceText = null;
                    zIsMorningFlag = false;
                    runTimeRange = null;
                    i5 = 0;
                    i6 = 0;
                }
                if (j8 != 0) {
                    if (zIsValid) {
                        j11 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        j11 = 262144;
                    }
                    j |= j11;
                }
                boolean zIsEmpty3 = TextUtils.isEmpty(recordStatus);
                if (sunRunRecordStatus == 10) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (i3 == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (zIsValid) {
                    i7 = RunIndexRecordAdapter.K;
                } else {
                    i7 = RunIndexRecordAdapter.L;
                }
                boolean zIsEmpty4 = TextUtils.isEmpty(reward);
                int i11 = i7;
                boolean z28 = z17;
                i8 = i5;
                if (i8 == 20) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (i8 == 30) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                boolean z29 = z20;
                if (i6 == 3) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                if (statusLogRecords == null) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                if ((j & 44) != 0) {
                    if (z7) {
                        j10 = 131072;
                    } else {
                        j10 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                    j |= j10;
                }
                if ((j & 44) != 0) {
                    if (z21) {
                        j9 = 8192;
                    } else {
                        j9 = 4096;
                    }
                    j |= j9;
                }
                if ((j & 44) != 0) {
                    if (z22) {
                        j |= 512;
                    } else {
                        j |= 256;
                    }
                }
                boolean z210 = !zIsEmpty3;
                long j14 = j;
                Resources resources2 = super.d.getResources();
                if (z7) {
                    i9 = R.string.sunshine_run_name;
                } else {
                    i9 = R.string.free_run_name;
                }
                String string2 = resources2.getString(i9);
                z = true;
                boolean z211 = !zIsEmpty4;
                list = statusLogRecords;
                z11 = z210;
                str8 = validDistance;
                z5 = z28;
                runDetailVM = runDetailVM;
                str6 = strJ;
                avatar = avatar;
                str4 = recordStatus;
                i = i4;
                i2 = i11;
                z6 = zIsMorningFlag;
                z8 = z19;
                z10 = z18;
                avatarFrameImgUrl = avatarFrameImgUrl;
                str5 = strK;
                str3 = totalDistanceText;
                str7 = string2;
                z3 = z21;
                z4 = z22;
                str = runTimeRange;
                z9 = z29;
                z2 = z211;
                j = j14;
                String str10 = activityReward;
                drawable = drawable2;
                str2 = str10;
            } else {
                z = true;
                drawable = drawable2;
                str6 = strJ;
                str5 = strK;
                i = 0;
                str = null;
                z2 = false;
                z3 = false;
                str2 = null;
                str3 = null;
                i2 = 0;
                str4 = null;
                z4 = false;
                z5 = false;
                z6 = false;
                z7 = false;
                list = null;
            }
            if ((j & 48) != 0) {
                aVarA = null;
                bVar = null;
            } else {
                aVarA = null;
                bVar = null;
            }
            j2 = j & 44;
            if (j2 != 0) {
                if (z3) {
                    z12 = z;
                } else {
                    z12 = z10;
                }
                if (j2 != 0) {
                    if (z12) {
                        j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        j7 = PlaybackStateCompat.ACTION_PREPARE;
                    }
                    j |= j7;
                }
                j3 = 256;
            } else {
                j3 = 256;
                z12 = false;
            }
            if ((j & j3) == 0) {
                z13 = false;
            } else {
                if (list != null) {
                    size = list.size();
                } else {
                    size = 0;
                }
                if (size == 0) {
                    z13 = z;
                } else {
                    z13 = false;
                }
            }
            j4 = j & 44;
            if (j4 != 0) {
                if (z4) {
                    z13 = z;
                }
                z14 = z13;
            } else {
                z14 = false;
            }
            if (j4 != 0) {
                if (z12) {
                    z15 = z;
                } else {
                    z15 = z9;
                }
                if (j4 != 0) {
                    if (z15) {
                        j6 = 2048;
                    } else {
                        j6 = 1024;
                    }
                    j |= j6;
                }
            } else {
                z15 = false;
            }
            j5 = j & 44;
            if (j5 != 0) {
                if (!z15) {
                    z = z8;
                }
                z16 = z;
            } else {
                z16 = false;
            }
            if (j5 != 0) {
                CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f35707a, z5);
                CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12179a, z7);
                CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).b, z14);
                CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12186a, z16);
                this.f12197e.setTextColor(i2);
                TextViewBindingAdapter.setText(this.f12198f, str);
                TextViewBindingAdapter.setText(this.g, str3);
                TextViewBindingAdapter.setText(this.h, str2);
                CommonBindingAdapter.l0(this.h, z2);
                CommonBindingAdapter.l0(this.f12196c, z6);
                TextViewBindingAdapter.setText(this.i, str4);
                CommonBindingAdapter.x(this.i, i);
                CommonBindingAdapter.l0(this.i, z11);
                CommonBindingAdapter.l0(this.c, z3);
                boolean z212 = z10;
                CommonBindingAdapter.l0(this.d, z212);
                CommonBindingAdapter.l0(this.e, z9);
                CommonBindingAdapter.l0(this.f, z8);
                TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12180a, str8);
                ((RunLayoutStaticsBinding) this).f12180a.setTextColor(i2);
                TextViewBindingAdapter.setText(super.d, str7);
                CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12189b, z212);
            }
            if ((40 & j) != 0) {
                ((RunLayoutStaticsBinding) this).f12182a.k(runDetailVM);
            }
            if ((41 & j) != 0) {
                ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
                TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12188b, str6);
                TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).c, str5);
            }
            if ((j & 48) != 0) {
                requestOptions = null;
                CommonBindingAdapter.q(this.b, aVarA, null);
                CommonBindingAdapter.q(((RunLayoutStaticsBinding) this).f12187a, bVar, null);
            } else {
                requestOptions = null;
            }
            if ((j & 32) != 0) {
                aw9.d(this.f12193a, avatar, false, requestOptions);
                aw9.c(this.f12193a, avatarFrameImgUrl, requestOptions);
            }
            ViewDataBinding.executeBindingsOn(((RunLayoutStaticsBinding) this).f12182a);
        }
        z = true;
        i = 0;
        str = null;
        z2 = false;
        z3 = false;
        str2 = null;
        str3 = null;
        i2 = 0;
        str4 = null;
        z4 = false;
        z5 = false;
        z6 = false;
        z7 = false;
        list = null;
        str5 = null;
        str6 = null;
        drawable = null;
        str7 = null;
        z8 = false;
        z9 = false;
        z10 = false;
        z11 = false;
        str8 = null;
        if ((j & 48) != 0) {
            aVarA = null;
            bVar = null;
        } else {
            aVarA = null;
            bVar = null;
        }
        j2 = j & 44;
        if (j2 != 0) {
            if (z3) {
                z12 = z;
            } else {
                z12 = z10;
            }
            if (j2 != 0) {
                if (z12) {
                    j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    j7 = PlaybackStateCompat.ACTION_PREPARE;
                }
                j |= j7;
            }
            j3 = 256;
        } else {
            j3 = 256;
            z12 = false;
        }
        if ((j & j3) == 0) {
            z13 = false;
        } else {
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            if (size == 0) {
                z13 = z;
            } else {
                z13 = false;
            }
        }
        j4 = j & 44;
        if (j4 != 0) {
            if (z4) {
                z13 = z;
            }
            z14 = z13;
        } else {
            z14 = false;
        }
        if (j4 != 0) {
            if (z12) {
                z15 = z;
            } else {
                z15 = z9;
            }
            if (j4 != 0) {
                if (z15) {
                    j6 = 2048;
                } else {
                    j6 = 1024;
                }
                j |= j6;
            }
        } else {
            z15 = false;
        }
        j5 = j & 44;
        if (j5 != 0) {
            if (!z15) {
                z = z8;
            }
            z16 = z;
        } else {
            z16 = false;
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f35707a, z5);
            CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12179a, z7);
            CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).b, z14);
            CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12186a, z16);
            this.f12197e.setTextColor(i2);
            TextViewBindingAdapter.setText(this.f12198f, str);
            TextViewBindingAdapter.setText(this.g, str3);
            TextViewBindingAdapter.setText(this.h, str2);
            CommonBindingAdapter.l0(this.h, z2);
            CommonBindingAdapter.l0(this.f12196c, z6);
            TextViewBindingAdapter.setText(this.i, str4);
            CommonBindingAdapter.x(this.i, i);
            CommonBindingAdapter.l0(this.i, z11);
            CommonBindingAdapter.l0(this.c, z3);
            boolean z213 = z10;
            CommonBindingAdapter.l0(this.d, z213);
            CommonBindingAdapter.l0(this.e, z9);
            CommonBindingAdapter.l0(this.f, z8);
            TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12180a, str8);
            ((RunLayoutStaticsBinding) this).f12180a.setTextColor(i2);
            TextViewBindingAdapter.setText(super.d, str7);
            CommonBindingAdapter.l0(((RunLayoutStaticsBinding) this).f12189b, z213);
        }
        if ((40 & j) != 0) {
            ((RunLayoutStaticsBinding) this).f12182a.k(runDetailVM);
        }
        if ((41 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).f12188b, str6);
            TextViewBindingAdapter.setText(((RunLayoutStaticsBinding) this).c, str5);
        }
        if ((j & 48) != 0) {
            requestOptions = null;
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(((RunLayoutStaticsBinding) this).f12187a, bVar, null);
        } else {
            requestOptions = null;
        }
        if ((j & 32) != 0) {
            aw9.d(this.f12193a, avatar, false, requestOptions);
            aw9.c(this.f12193a, avatarFrameImgUrl, requestOptions);
        }
        ViewDataBinding.executeBindingsOn(((RunLayoutStaticsBinding) this).f12182a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12191a != 0) {
                return true;
            }
            return ((RunLayoutStaticsBinding) this).f12182a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12191a = 32L;
        }
        ((RunLayoutStaticsBinding) this).f12182a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutStaticsBinding
    public void l(@Nullable RunDetailActivity.a Click) {
        ((RunLayoutStaticsBinding) this).f12183a = Click;
        synchronized (this) {
            this.f12191a |= 16;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutStaticsBinding
    public void m(@Nullable RunDetailVM Vm) {
        ((RunLayoutStaticsBinding) this).f12184a = Vm;
        synchronized (this) {
            this.f12191a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(RunLayoutMetricsContentBinding LayoutMetricsInCard, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12191a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12191a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((RunLayoutMetricsContentBinding) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Boolean> VmUserInfoVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12191a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunLayoutStaticsBinding) this).f12182a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RunDetailVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunDetailActivity.a) variable);
        }
        return true;
    }

    public RunLayoutStaticsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BLConstraintLayout) bindings[24], (FlexboxLayout) bindings[25], (ImageView) bindings[7], (RunLayoutMetricsContentBinding) bindings[23], (LinearLayout) bindings[15], (LinearLayout) bindings[21], (BLLinearLayout) bindings[2], (TextView) bindings[9], (BLTextView) bindings[1], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[8], (BLTextView) bindings[20]);
        this.f12191a = -1L;
        ((RunLayoutStaticsBinding) this).f35707a.setTag(null);
        setContainedBinding(((RunLayoutStaticsBinding) this).f12182a);
        ((RunLayoutStaticsBinding) this).f12179a.setTag(null);
        ((RunLayoutStaticsBinding) this).b.setTag(null);
        ((RunLayoutStaticsBinding) this).f12186a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f12192a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.f12197e = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[11];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[14];
        this.f12198f = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[16];
        this.g = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[17];
        this.h = textView4;
        textView4.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[18];
        this.f12196c = bLTextView;
        bLTextView.setTag(null);
        TextView textView5 = (TextView) bindings[19];
        this.i = textView5;
        textView5.setTag(null);
        AvatarView avatarView = (AvatarView) bindings[22];
        this.f12193a = avatarView;
        avatarView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.c = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[4];
        this.d = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[5];
        this.e = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[6];
        this.f = imageView5;
        imageView5.setTag(null);
        ((RunLayoutStaticsBinding) this).f12180a.setTag(null);
        ((RunLayoutStaticsBinding) this).f12187a.setTag(null);
        ((RunLayoutStaticsBinding) this).f12188b.setTag(null);
        ((RunLayoutStaticsBinding) this).c.setTag(null);
        super.d.setTag(null);
        ((RunLayoutStaticsBinding) this).f12189b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
