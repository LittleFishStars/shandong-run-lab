package com.huachenjie.works.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.util.rich_text.RichEditView;
import com.huachenjie.base.widget.input_panel.audio.AudioPanelView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogBroadcastFloorCommentInputBindingImpl extends WorksDialogBroadcastFloorCommentInputBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13985a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f13989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f13993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f13994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f13995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f13996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f13997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f13998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f13999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f14000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14001a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14002b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14003b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final CardView f14004b;

    @NonNull
    public final FrameLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ImageView f14005c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((WorksDialogBroadcastFloorCommentInputBinding) WorksDialogBroadcastFloorCommentInputBindingImpl.this).f13981a);
            CommentInputVM commentInputVM = ((WorksDialogBroadcastFloorCommentInputBinding) WorksDialogBroadcastFloorCommentInputBindingImpl.this).f13984a;
            if (commentInputVM != null) {
                MutableLiveData<String> mutableLiveDataI = commentInputVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36823a;

        public b a(CommentInputDialog.ClickProxy value) {
            this.f36823a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36823a.g(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36824a;

        public c a(CommentInputDialog.ClickProxy value) {
            this.f36824a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36824a.k(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36825a;

        public d a(CommentInputDialog.ClickProxy value) {
            this.f36825a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36825a.e(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36826a;

        public e a(CommentInputDialog.ClickProxy value) {
            this.f36826a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36826a.f(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36827a;

        public f a(CommentInputDialog.ClickProxy value) {
            this.f36827a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36827a.j(arg0);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36828a;

        public g a(CommentInputDialog.ClickProxy value) {
            this.f36828a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36828a.d(arg0);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36829a;

        public h a(CommentInputDialog.ClickProxy value) {
            this.f36829a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36829a.h(arg0);
        }
    }

    public static class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36830a;

        public i a(CommentInputDialog.ClickProxy value) {
            this.f36830a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36830a.i(arg0);
        }
    }

    public static class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36831a;

        public j a(CommentInputDialog.ClickProxy value) {
            this.f36831a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36831a.a(arg0);
        }
    }

    public static class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36832a;

        public k a(CommentInputDialog.ClickProxy value) {
            this.f36832a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36832a.b(arg0);
        }
    }

    public static class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36833a;

        public l a(CommentInputDialog.ClickProxy value) {
            this.f36833a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36833a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36821a = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 18);
        sparseIntArray.put(R.id.ivIcon, 19);
        sparseIntArray.put(R.id.jsonAudio, 20);
        sparseIntArray.put(R.id.fl_panel, 21);
    }

    public WorksDialogBroadcastFloorCommentInputBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 22, f13985a, f36821a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:208:0x03bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:212:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:213:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:215:0x03cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:216:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:217:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:220:0x03de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:222:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:223:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:226:0x03f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:227:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:228:0x0400  */
    /* JADX WARN: Code duplicated, block: B:231:0x040a  */
    /* JADX WARN: Code duplicated, block: B:232:0x0411  */
    /* JADX WARN: Code duplicated, block: B:235:0x041b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:236:0x041d  */
    /* JADX WARN: Code duplicated, block: B:237:0x041f  */
    /* JADX WARN: Code duplicated, block: B:241:0x0428 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:242:0x042a  */
    /* JADX WARN: Code duplicated, block: B:243:0x042c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0430  */
    /* JADX WARN: Code duplicated, block: B:249:0x043d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:250:0x043f  */
    /* JADX WARN: Code duplicated, block: B:251:0x0442  */
    /* JADX WARN: Code duplicated, block: B:254:0x0447  */
    /* JADX WARN: Code duplicated, block: B:256:0x044a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x044c  */
    /* JADX WARN: Code duplicated, block: B:258:0x0450  */
    /* JADX WARN: Code duplicated, block: B:261:0x0457  */
    /* JADX WARN: Code duplicated, block: B:262:0x045b  */
    /* JADX WARN: Code duplicated, block: B:264:0x0462  */
    /* JADX WARN: Code duplicated, block: B:267:0x046c  */
    /* JADX WARN: Code duplicated, block: B:268:0x047d  */
    /* JADX WARN: Code duplicated, block: B:271:0x0486  */
    /* JADX WARN: Code duplicated, block: B:274:0x049a  */
    /* JADX WARN: Code duplicated, block: B:277:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:280:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:281:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:284:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:287:0x050d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0524  */
    /* JADX WARN: Code duplicated, block: B:293:0x053c  */
    /* JADX WARN: Code duplicated, block: B:296:0x054e  */
    /* JADX WARN: Code duplicated, block: B:299:0x0560  */
    /* JADX WARN: Code duplicated, block: B:306:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j2;
        String path;
        BroadcastFloorMessageImageBean value;
        boolean z;
        String value2;
        String str;
        MutableLiveData<BroadcastFloorMessageVoiceBean> mutableLiveDataO;
        CharSequence charSequence;
        boolean zSafeUnbox;
        int i2;
        byte b2;
        BroadcastFloorMessageVoiceBean value3;
        boolean zIsEmpty;
        int i3;
        boolean z2;
        boolean z3;
        MutableLiveData<BroadcastFloorMessageImageBean> mutableLiveDataK;
        boolean z4;
        int iSafeUnbox;
        i iVar;
        k kVar;
        b bVarA;
        c cVar;
        g gVar;
        e eVar;
        f fVar;
        h hVar;
        d dVar;
        l lVar;
        j jVar;
        b bVar;
        g gVar2;
        long j3;
        boolean z5;
        boolean z6;
        long j4;
        boolean z7;
        long j5;
        boolean z8;
        boolean z9;
        long j6;
        boolean z10;
        int i4;
        Long l2;
        boolean z11;
        int i5;
        long j7;
        MutableLiveData<BroadcastFloorMessageVoiceBean> mutableLiveDataO2;
        BroadcastFloorMessageVoiceBean value4;
        boolean z12;
        CharSequence charSequence2;
        boolean zSafeUnbox2;
        long j8;
        boolean z13;
        long j9;
        synchronized (this) {
            j2 = this.f13986a;
            this.f13986a = 0L;
        }
        CommentInputVM commentInputVM = ((WorksDialogBroadcastFloorCommentInputBinding) this).f13984a;
        CommentInputDialog.ClickProxy clickProxy = ((WorksDialogBroadcastFloorCommentInputBinding) this).f13983a;
        if ((1535 & j2) != 0) {
            if ((j2 & 1281) == 0) {
                charSequence2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = commentInputVM != null ? commentInputVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    charSequence2 = (String) mutableLiveDataJ.getValue();
                } else {
                    charSequence2 = null;
                }
            }
            long j10 = j2 & 1282;
            i3 = -13877680;
            if (j10 != 0) {
                MutableLiveData<Boolean> mutableLiveDataL = commentInputVM != null ? commentInputVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
                if (j10 != 0) {
                    j2 |= zSafeUnbox ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                i2 = zSafeUnbox ? -13877680 : -7563357;
            } else {
                zSafeUnbox = false;
                i2 = 0;
            }
            long j11 = j2 & 1284;
            if (j11 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = commentInputVM != null ? commentInputVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j11 != 0) {
                    j2 |= zSafeUnbox3 ? 4096L : 2048L;
                }
                b2 = zSafeUnbox3 ? (byte) -13877680 : (byte) -7563357;
            } else {
                b2 = 0;
            }
            if ((j2 & 1296) != 0) {
                BaseViewModel.b bVarE = commentInputVM != null ? commentInputVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(4, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j12 = j2 & 1288;
            if (j12 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = commentInputVM != null ? commentInputVM.m() : null;
                updateLiveDataRegistration(3, mutableLiveDataM);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j12 != 0) {
                    j2 |= zSafeUnbox2 ? 1048576L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                if (!zSafeUnbox2) {
                    i3 = -7563357;
                }
            } else {
                zSafeUnbox2 = false;
                i3 = 0;
            }
            if ((j2 & 1312) != 0) {
                mutableLiveDataO = commentInputVM != null ? commentInputVM.o() : null;
                updateLiveDataRegistration(5, mutableLiveDataO);
                value3 = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                z3 = value3 != null;
                str = String.format("%ds", Integer.valueOf(value3 != null ? value3.getVoiceTime() : 0));
            } else {
                str = null;
                mutableLiveDataO = null;
                value3 = null;
                z3 = false;
            }
            long j13 = j2 & 1504;
            if (j13 != 0) {
                MutableLiveData<String> mutableLiveDataI = commentInputVM != null ? commentInputVM.i() : null;
                updateLiveDataRegistration(6, mutableLiveDataI);
                value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value2);
                if (j13 != 0) {
                    j2 = zIsEmpty ? j2 | PlaybackStateCompat.ACTION_PREPARE : j2 | 8192;
                }
                z13 = !zIsEmpty;
                j8 = 0;
                if ((j2 & 1504) != 0) {
                    j2 = z13 ? j2 | 16777216 : j2 | 8388608;
                }
            } else {
                str = str;
                j8 = 0;
                value2 = null;
                z13 = false;
                zIsEmpty = false;
            }
            if ((j2 & 1408) != j8) {
                if (commentInputVM != null) {
                    long j14 = j2;
                    mutableLiveDataK = commentInputVM.k();
                    j9 = j14;
                } else {
                    j9 = j2;
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(7, mutableLiveDataK);
                value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                z4 = value != null;
                if (value != null) {
                    j2 = j9;
                    path = value.getPath();
                } else {
                    j2 = j9;
                    path = null;
                }
                boolean z14 = z13;
                charSequence = charSequence2;
                z = zSafeUnbox2;
                z2 = z14;
            } else {
                iSafeUnbox = iSafeUnbox;
                mutableLiveDataK = null;
                z4 = false;
                mutableLiveDataO = mutableLiveDataO;
                z3 = z3;
                value = null;
                value3 = value3;
                b2 = b2;
                i2 = i2;
                str = str;
                zIsEmpty = zIsEmpty;
                zSafeUnbox = zSafeUnbox;
                value2 = value2;
                path = null;
                boolean z15 = z13;
                charSequence = charSequence2;
                z = zSafeUnbox2;
                z2 = z15;
            }
        } else {
            path = null;
            value = null;
            z = false;
            value2 = null;
            str = null;
            mutableLiveDataO = null;
            charSequence = null;
            zSafeUnbox = false;
            i2 = 0;
            b2 = 0;
            value3 = null;
            zIsEmpty = false;
            i3 = 0;
            z2 = false;
            z3 = false;
            mutableLiveDataK = null;
            z4 = false;
            iSafeUnbox = 0;
        }
        RequestOptions requestOptions = (j2 & 1408) != 0 ? ju3.h : null;
        if ((j2 & 1536) == 0 || clickProxy == null) {
            iVar = null;
            kVar = null;
            bVarA = null;
            cVar = null;
            gVar = null;
            eVar = null;
            fVar = null;
            hVar = null;
            dVar = null;
            lVar = null;
            jVar = null;
        } else {
            l lVar2 = this.f14000a;
            if (lVar2 == null) {
                lVar2 = new l();
                this.f14000a = lVar2;
            }
            l lVarA = lVar2.a(clickProxy);
            c cVar2 = this.f13991a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f13991a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar2 = this.f13992a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f13992a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            e eVar2 = this.f13993a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f13993a = eVar2;
            }
            e eVarA = eVar2.a(clickProxy);
            f fVar2 = this.f13994a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f13994a = fVar2;
            }
            f fVarA = fVar2.a(clickProxy);
            g gVar3 = this.f13995a;
            if (gVar3 == null) {
                gVar3 = new g();
                this.f13995a = gVar3;
            }
            g gVarA = gVar3.a(clickProxy);
            h hVar2 = this.f13996a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f13996a = hVar2;
            }
            h hVarA = hVar2.a(clickProxy);
            i iVar2 = this.f13997a;
            if (iVar2 == null) {
                iVar2 = new i();
                this.f13997a = iVar2;
            }
            i iVarA = iVar2.a(clickProxy);
            j jVar2 = this.f13998a;
            if (jVar2 == null) {
                jVar2 = new j();
                this.f13998a = jVar2;
            }
            j jVarA = jVar2.a(clickProxy);
            k kVar2 = this.f13999a;
            if (kVar2 == null) {
                kVar2 = new k();
                this.f13999a = kVar2;
            }
            k kVarA = kVar2.a(clickProxy);
            b bVar2 = this.f13990a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f13990a = bVar2;
            }
            bVarA = bVar2.a(clickProxy);
            gVar = gVarA;
            hVar = hVarA;
            jVar = jVarA;
            dVar = dVarA;
            cVar = cVarA;
            eVar = eVarA;
            iVar = iVarA;
            lVar = lVarA;
            fVar = fVarA;
            kVar = kVarA;
        }
        if ((j2 & 8404992) != 0) {
            if (commentInputVM != null) {
                mutableLiveDataK = commentInputVM.k();
            }
            bVar = bVarA;
            gVar2 = gVar;
            MutableLiveData<BroadcastFloorMessageImageBean> mutableLiveData = mutableLiveDataK;
            updateLiveDataRegistration(7, mutableLiveData);
            if (mutableLiveData != null) {
                value = mutableLiveData.getValue();
            }
            j3 = 0;
            if ((j2 & 8388608) != 0) {
                z4 = value != null;
            }
            if ((j2 & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                z6 = value == null;
                z5 = z4;
            }
            j4 = j2 & 1504;
            if (j4 != j3) {
                if (!zIsEmpty) {
                    z6 = false;
                }
                if (z2) {
                    z7 = true;
                } else {
                    z7 = z5;
                }
                if (j4 != j3) {
                    if (z6) {
                        j2 |= 67108864;
                    } else {
                        j2 |= 33554432;
                    }
                }
                if ((j2 & 1504) != 0) {
                    if (z7) {
                        j2 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    } else {
                        j2 |= 2097152;
                    }
                }
            } else {
                z6 = false;
                z7 = false;
            }
            if ((j2 & 69206016) != 0) {
                if (commentInputVM != null) {
                    mutableLiveDataO2 = commentInputVM.o();
                } else {
                    mutableLiveDataO2 = mutableLiveDataO;
                }
                updateLiveDataRegistration(5, mutableLiveDataO2);
                if (mutableLiveDataO2 != null) {
                    value4 = mutableLiveDataO2.getValue();
                } else {
                    value4 = value3;
                }
                j5 = 0;
                if ((j2 & 2097152) != 0) {
                    if (value4 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z3 = z12;
                }
                if ((j2 & 67108864) != 0) {
                    if (value4 == null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z8 = z3;
                }
                j6 = j2 & 1504;
                if (j6 != j5) {
                    if (z7) {
                        z11 = true;
                    } else {
                        z11 = z8;
                    }
                    if (!z6) {
                        z9 = false;
                    }
                    if (j6 != j5) {
                        if (z9) {
                            j7 = 262144;
                        } else {
                            j7 = 131072;
                        }
                        j2 |= j7;
                    }
                    if (z9) {
                        i5 = RunIndexRecordAdapter.O;
                    } else {
                        i5 = -10155284;
                    }
                    i4 = i5;
                    z10 = z11;
                } else {
                    z10 = false;
                    i4 = 0;
                }
                if ((j2 & 1282) != 0) {
                    CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f13982a, zSafeUnbox);
                    CommonBindingAdapter.Y(this.h, Integer.valueOf(i2));
                }
                if ((1288 & j2) != 0) {
                    CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f36820a, z);
                    CommonBindingAdapter.Y(this.f, Integer.valueOf(i3));
                }
                if ((j2 & 1281) != 0) {
                    ((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a.setHint(charSequence);
                }
                if ((1344 & j2) != 0) {
                    TextViewBindingAdapter.setText(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, value2);
                }
                if ((1024 & j2) != 0) {
                    l2 = null;
                    TextViewBindingAdapter.setTextWatcher(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, null, null, null, this.f13989a);
                } else {
                    l2 = null;
                }
                if ((j2 & 1536) != 0) {
                    CommonBindingAdapter.q(this.c, kVar, l2);
                    CommonBindingAdapter.q(this.b, cVar, l2);
                    CommonBindingAdapter.q(this.f14005c, iVar, l2);
                    CommonBindingAdapter.q(this.f14001a, eVar, l2);
                    CommonBindingAdapter.q(this.d, fVar, l2);
                    CommonBindingAdapter.q(this.f14003b, bVar, l2);
                    CommonBindingAdapter.q(this.e, gVar2, l2);
                    CommonBindingAdapter.q(this.f, lVar, l2);
                    CommonBindingAdapter.q(this.g, dVar, l2);
                    CommonBindingAdapter.q(this.h, hVar, l2);
                    CommonBindingAdapter.q(this.i, jVar, l2);
                }
                if ((j2 & 1296) != 0) {
                    CommonBindingAdapter.O(this.f13987a, 0, 0, 0, iSafeUnbox, null);
                }
                if ((j2 & 1408) != 0) {
                    CommonBindingAdapter.b0(this.b, path, requestOptions, false);
                    CommonBindingAdapter.l0(this.f14004b, z5);
                }
                if ((1312 & j2) != 0) {
                    CommonBindingAdapter.l0(this.f14002b, z8);
                    TextViewBindingAdapter.setText(this.f13988a, str);
                }
                if ((j2 & 1504) != 0) {
                    CommonBindingAdapter.e0(this.f14003b, z10);
                    this.f14003b.setTextColor(i4);
                }
                if ((j2 & 1284) != 0) {
                    CommonBindingAdapter.Y(this.e, Integer.valueOf(b2));
                }
            }
            z5 = z5;
            j5 = 0;
            z8 = z3;
            z9 = false;
            j6 = j2 & 1504;
            if (j6 != j5) {
                if (z7) {
                    z11 = true;
                } else {
                    z11 = z8;
                }
                if (!z6) {
                    z9 = false;
                }
                if (j6 != j5) {
                    if (z9) {
                        j7 = 262144;
                    } else {
                        j7 = 131072;
                    }
                    j2 |= j7;
                }
                if (z9) {
                    i5 = RunIndexRecordAdapter.O;
                } else {
                    i5 = -10155284;
                }
                i4 = i5;
                z10 = z11;
            } else {
                z10 = false;
                i4 = 0;
            }
            if ((j2 & 1282) != 0) {
                CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f13982a, zSafeUnbox);
                CommonBindingAdapter.Y(this.h, Integer.valueOf(i2));
            }
            if ((1288 & j2) != 0) {
                CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f36820a, z);
                CommonBindingAdapter.Y(this.f, Integer.valueOf(i3));
            }
            if ((j2 & 1281) != 0) {
                ((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a.setHint(charSequence);
            }
            if ((1344 & j2) != 0) {
                TextViewBindingAdapter.setText(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, value2);
            }
            if ((1024 & j2) != 0) {
                l2 = null;
                TextViewBindingAdapter.setTextWatcher(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, null, null, null, this.f13989a);
            } else {
                l2 = null;
            }
            if ((j2 & 1536) != 0) {
                CommonBindingAdapter.q(this.c, kVar, l2);
                CommonBindingAdapter.q(this.b, cVar, l2);
                CommonBindingAdapter.q(this.f14005c, iVar, l2);
                CommonBindingAdapter.q(this.f14001a, eVar, l2);
                CommonBindingAdapter.q(this.d, fVar, l2);
                CommonBindingAdapter.q(this.f14003b, bVar, l2);
                CommonBindingAdapter.q(this.e, gVar2, l2);
                CommonBindingAdapter.q(this.f, lVar, l2);
                CommonBindingAdapter.q(this.g, dVar, l2);
                CommonBindingAdapter.q(this.h, hVar, l2);
                CommonBindingAdapter.q(this.i, jVar, l2);
            }
            if ((j2 & 1296) != 0) {
                CommonBindingAdapter.O(this.f13987a, 0, 0, 0, iSafeUnbox, null);
            }
            if ((j2 & 1408) != 0) {
                CommonBindingAdapter.b0(this.b, path, requestOptions, false);
                CommonBindingAdapter.l0(this.f14004b, z5);
            }
            if ((1312 & j2) != 0) {
                CommonBindingAdapter.l0(this.f14002b, z8);
                TextViewBindingAdapter.setText(this.f13988a, str);
            }
            if ((j2 & 1504) != 0) {
                CommonBindingAdapter.e0(this.f14003b, z10);
                this.f14003b.setTextColor(i4);
            }
            if ((j2 & 1284) != 0) {
                CommonBindingAdapter.Y(this.e, Integer.valueOf(b2));
            }
        }
        bVar = bVarA;
        gVar2 = gVar;
        j3 = 0;
        z5 = z4;
        z6 = false;
        j4 = j2 & 1504;
        if (j4 != j3) {
            if (!zIsEmpty) {
                z6 = false;
            }
            if (z2) {
                z7 = true;
            } else {
                z7 = z5;
            }
            if (j4 != j3) {
                if (z6) {
                    j2 |= 67108864;
                } else {
                    j2 |= 33554432;
                }
            }
            if ((j2 & 1504) != 0) {
                if (z7) {
                    j2 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                } else {
                    j2 |= 2097152;
                }
            }
        } else {
            z6 = false;
            z7 = false;
        }
        if ((j2 & 69206016) != 0) {
            if (commentInputVM != null) {
                mutableLiveDataO2 = commentInputVM.o();
            } else {
                mutableLiveDataO2 = mutableLiveDataO;
            }
            updateLiveDataRegistration(5, mutableLiveDataO2);
            if (mutableLiveDataO2 != null) {
                value4 = mutableLiveDataO2.getValue();
            } else {
                value4 = value3;
            }
            j5 = 0;
            if ((j2 & 2097152) != 0) {
                if (value4 != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z3 = z12;
            }
            if ((j2 & 67108864) != 0) {
                if (value4 == null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z8 = z3;
            }
            j6 = j2 & 1504;
            if (j6 != j5) {
                if (z7) {
                    z11 = true;
                } else {
                    z11 = z8;
                }
                if (!z6) {
                    z9 = false;
                }
                if (j6 != j5) {
                    if (z9) {
                        j7 = 262144;
                    } else {
                        j7 = 131072;
                    }
                    j2 |= j7;
                }
                if (z9) {
                    i5 = RunIndexRecordAdapter.O;
                } else {
                    i5 = -10155284;
                }
                i4 = i5;
                z10 = z11;
            } else {
                z10 = false;
                i4 = 0;
            }
            if ((j2 & 1282) != 0) {
                CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f13982a, zSafeUnbox);
                CommonBindingAdapter.Y(this.h, Integer.valueOf(i2));
            }
            if ((1288 & j2) != 0) {
                CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f36820a, z);
                CommonBindingAdapter.Y(this.f, Integer.valueOf(i3));
            }
            if ((j2 & 1281) != 0) {
                ((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a.setHint(charSequence);
            }
            if ((1344 & j2) != 0) {
                TextViewBindingAdapter.setText(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, value2);
            }
            if ((1024 & j2) != 0) {
                l2 = null;
                TextViewBindingAdapter.setTextWatcher(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, null, null, null, this.f13989a);
            } else {
                l2 = null;
            }
            if ((j2 & 1536) != 0) {
                CommonBindingAdapter.q(this.c, kVar, l2);
                CommonBindingAdapter.q(this.b, cVar, l2);
                CommonBindingAdapter.q(this.f14005c, iVar, l2);
                CommonBindingAdapter.q(this.f14001a, eVar, l2);
                CommonBindingAdapter.q(this.d, fVar, l2);
                CommonBindingAdapter.q(this.f14003b, bVar, l2);
                CommonBindingAdapter.q(this.e, gVar2, l2);
                CommonBindingAdapter.q(this.f, lVar, l2);
                CommonBindingAdapter.q(this.g, dVar, l2);
                CommonBindingAdapter.q(this.h, hVar, l2);
                CommonBindingAdapter.q(this.i, jVar, l2);
            }
            if ((j2 & 1296) != 0) {
                CommonBindingAdapter.O(this.f13987a, 0, 0, 0, iSafeUnbox, null);
            }
            if ((j2 & 1408) != 0) {
                CommonBindingAdapter.b0(this.b, path, requestOptions, false);
                CommonBindingAdapter.l0(this.f14004b, z5);
            }
            if ((1312 & j2) != 0) {
                CommonBindingAdapter.l0(this.f14002b, z8);
                TextViewBindingAdapter.setText(this.f13988a, str);
            }
            if ((j2 & 1504) != 0) {
                CommonBindingAdapter.e0(this.f14003b, z10);
                this.f14003b.setTextColor(i4);
            }
            if ((j2 & 1284) != 0) {
                CommonBindingAdapter.Y(this.e, Integer.valueOf(b2));
            }
        }
        z5 = z5;
        j5 = 0;
        z8 = z3;
        z9 = false;
        j6 = j2 & 1504;
        if (j6 != j5) {
            if (z7) {
                z11 = true;
            } else {
                z11 = z8;
            }
            if (!z6) {
                z9 = false;
            }
            if (j6 != j5) {
                if (z9) {
                    j7 = 262144;
                } else {
                    j7 = 131072;
                }
                j2 |= j7;
            }
            if (z9) {
                i5 = RunIndexRecordAdapter.O;
            } else {
                i5 = -10155284;
            }
            i4 = i5;
            z10 = z11;
        } else {
            z10 = false;
            i4 = 0;
        }
        if ((j2 & 1282) != 0) {
            CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f13982a, zSafeUnbox);
            CommonBindingAdapter.Y(this.h, Integer.valueOf(i2));
        }
        if ((1288 & j2) != 0) {
            CommonBindingAdapter.l0(((WorksDialogBroadcastFloorCommentInputBinding) this).f36820a, z);
            CommonBindingAdapter.Y(this.f, Integer.valueOf(i3));
        }
        if ((j2 & 1281) != 0) {
            ((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a.setHint(charSequence);
        }
        if ((1344 & j2) != 0) {
            TextViewBindingAdapter.setText(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, value2);
        }
        if ((1024 & j2) != 0) {
            l2 = null;
            TextViewBindingAdapter.setTextWatcher(((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a, null, null, null, this.f13989a);
        } else {
            l2 = null;
        }
        if ((j2 & 1536) != 0) {
            CommonBindingAdapter.q(this.c, kVar, l2);
            CommonBindingAdapter.q(this.b, cVar, l2);
            CommonBindingAdapter.q(this.f14005c, iVar, l2);
            CommonBindingAdapter.q(this.f14001a, eVar, l2);
            CommonBindingAdapter.q(this.d, fVar, l2);
            CommonBindingAdapter.q(this.f14003b, bVar, l2);
            CommonBindingAdapter.q(this.e, gVar2, l2);
            CommonBindingAdapter.q(this.f, lVar, l2);
            CommonBindingAdapter.q(this.g, dVar, l2);
            CommonBindingAdapter.q(this.h, hVar, l2);
            CommonBindingAdapter.q(this.i, jVar, l2);
        }
        if ((j2 & 1296) != 0) {
            CommonBindingAdapter.O(this.f13987a, 0, 0, 0, iSafeUnbox, null);
        }
        if ((j2 & 1408) != 0) {
            CommonBindingAdapter.b0(this.b, path, requestOptions, false);
            CommonBindingAdapter.l0(this.f14004b, z5);
        }
        if ((1312 & j2) != 0) {
            CommonBindingAdapter.l0(this.f14002b, z8);
            TextViewBindingAdapter.setText(this.f13988a, str);
        }
        if ((j2 & 1504) != 0) {
            CommonBindingAdapter.e0(this.f14003b, z10);
            this.f14003b.setTextColor(i4);
        }
        if ((j2 & 1284) != 0) {
            CommonBindingAdapter.Y(this.e, Integer.valueOf(b2));
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13986a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13986a = 1024L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBroadcastFloorCommentInputBinding
    public void l(@Nullable CommentInputDialog.ClickProxy Click) {
        ((WorksDialogBroadcastFloorCommentInputBinding) this).f13983a = Click;
        synchronized (this) {
            this.f13986a |= 512;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBroadcastFloorCommentInputBinding
    public void m(@Nullable CommentInputVM Vm) {
        ((WorksDialogBroadcastFloorCommentInputBinding) this).f13984a = Vm;
        synchronized (this) {
            this.f13986a |= 256;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmComment, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 64;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmHint, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return o((MutableLiveData) object, fieldId);
            case 1:
                return q((MutableLiveData) object, fieldId);
            case 2:
                return s((MutableLiveData) object, fieldId);
            case 3:
                return r((MutableLiveData) object, fieldId);
            case 4:
                return t((MutableLiveData) object, fieldId);
            case 5:
                return u((MutableLiveData) object, fieldId);
            case 6:
                return n((MutableLiveData) object, fieldId);
            case 7:
                return p((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<BroadcastFloorMessageImageBean> VmImage, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 128;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmShowAudio, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmShowEmoji, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Boolean> VmShowKeyboard, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((CommentInputVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((CommentInputDialog.ClickProxy) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 16;
        }
        return true;
    }

    public final boolean u(MutableLiveData<BroadcastFloorMessageVoiceBean> VmVoice, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13986a |= 32;
        }
        return true;
    }

    public WorksDialogBroadcastFloorCommentInputBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (AudioPanelView) bindings[17], (CardView) bindings[18], (FrameLayout) bindings[16], (RichEditView) bindings[2], (FrameLayout) bindings[21], (ImageView) bindings[19], (LottieAnimationView) bindings[20]);
        this.f13989a = new a();
        this.f13986a = -1L;
        ((WorksDialogBroadcastFloorCommentInputBinding) this).f13982a.setTag(null);
        ((WorksDialogBroadcastFloorCommentInputBinding) this).f36820a.setTag(null);
        ((WorksDialogBroadcastFloorCommentInputBinding) this).f13981a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.c = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f13987a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[10];
        this.b = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[11];
        this.f14005c = imageView2;
        imageView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[12];
        this.f14002b = linearLayout2;
        linearLayout2.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[13];
        this.f14001a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) bindings[14];
        this.f13988a = textView;
        textView.setTag(null);
        ImageView imageView3 = (ImageView) bindings[15];
        this.d = imageView3;
        imageView3.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.f14003b = textView2;
        textView2.setTag(null);
        ImageView imageView4 = (ImageView) bindings[4];
        this.e = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[5];
        this.f = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) bindings[6];
        this.g = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) bindings[7];
        this.h = imageView7;
        imageView7.setTag(null);
        ImageView imageView8 = (ImageView) bindings[8];
        this.i = imageView8;
        imageView8.setTag(null);
        CardView cardView = (CardView) bindings[9];
        this.f14004b = cardView;
        cardView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
