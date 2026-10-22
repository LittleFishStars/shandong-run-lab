package com.huachenjie.works.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.CommentInputVM;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogCommentInputBindingImpl extends WorksDialogCommentInputBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14058a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f14061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f14064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f14065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f14066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f14067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f14068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f14069a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((WorksDialogCommentInputBinding) WorksDialogCommentInputBindingImpl.this).f14055a);
            CommentInputVM commentInputVM = ((WorksDialogCommentInputBinding) WorksDialogCommentInputBindingImpl.this).f14054a;
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
        public CommentInputDialog.ClickProxy f36852a;

        public b a(CommentInputDialog.ClickProxy value) {
            this.f36852a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36852a.h(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36853a;

        public c a(CommentInputDialog.ClickProxy value) {
            this.f36853a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36853a.d(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36854a;

        public d a(CommentInputDialog.ClickProxy value) {
            this.f36854a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36854a.e(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36855a;

        public e a(CommentInputDialog.ClickProxy value) {
            this.f36855a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36855a.g(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36856a;

        public f a(CommentInputDialog.ClickProxy value) {
            this.f36856a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36856a.a(arg0);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36857a;

        public g a(CommentInputDialog.ClickProxy value) {
            this.f36857a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36857a.b(arg0);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36858a;

        public h a(CommentInputDialog.ClickProxy value) {
            this.f36858a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36858a.f(arg0);
        }
    }

    public static class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CommentInputDialog.ClickProxy f36859a;

        public i a(CommentInputDialog.ClickProxy value) {
            this.f36859a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36859a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36850a = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 12);
        sparseIntArray.put(R.id.rl_comment_input, 13);
    }

    public WorksDialogCommentInputBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, f14058a, f36850a));
    }

    /* JADX WARN: Code duplicated, block: B:162:0x029d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:167:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:169:0x02aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    /* JADX WARN: Code duplicated, block: B:170:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:171:0x02af  */
    /* JADX WARN: Code duplicated, block: B:174:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:175:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:177:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:180:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:183:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:186:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:189:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:192:0x0304  */
    /* JADX WARN: Code duplicated, block: B:195:0x0312  */
    /* JADX WARN: Code duplicated, block: B:198:0x032e  */
    /* JADX WARN: Code duplicated, block: B:201:0x036e  */
    /* JADX WARN: Code duplicated, block: B:204:0x0382  */
    /* JADX WARN: Code duplicated, block: B:211:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String path;
        boolean zIsEmpty;
        CharSequence charSequence;
        Drawable drawable;
        boolean z;
        boolean z2;
        String str;
        MutableLiveData<CommentImageBean> mutableLiveData;
        boolean zSafeUnbox;
        boolean z3;
        int i2;
        CommentImageBean value;
        boolean z4;
        i iVar;
        f fVar;
        h hVar;
        g gVar;
        b bVar;
        c cVar;
        d dVar;
        e eVar;
        long j2;
        boolean z5;
        boolean z6;
        long j3;
        int i3;
        boolean z7;
        boolean z8;
        long j4;
        boolean z9;
        int iSafeUnbox;
        Drawable drawable2;
        long j5;
        String value2;
        int i4;
        MutableLiveData<CommentImageBean> mutableLiveDataL;
        synchronized (this) {
            j = this.f14059a;
            this.f14059a = 0L;
        }
        CommentInputVM commentInputVM = ((WorksDialogCommentInputBinding) this).f14054a;
        CommentInputDialog.ClickProxy clickProxy = ((WorksDialogCommentInputBinding) this).f14053a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                charSequence = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = commentInputVM != null ? commentInputVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    charSequence = (String) mutableLiveDataK.getValue();
                } else {
                    charSequence = null;
                }
            }
            if ((j & 322) != 0) {
                MutableLiveData<Integer> mutableLiveDataJ = commentInputVM != null ? commentInputVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
                z9 = iSafeUnbox2 != 3;
                z2 = iSafeUnbox2 == 1;
            } else {
                z2 = false;
                z9 = false;
            }
            if ((j & 328) != 0) {
                BaseViewModel.b bVarE = commentInputVM != null ? commentInputVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j6 = j & 324;
            if (j6 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = commentInputVM != null ? commentInputVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j6 != 0) {
                    j |= zSafeUnbox ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                drawable2 = AppCompatResources.getDrawable(((WorksDialogCommentInputBinding) this).b.getContext(), zSafeUnbox ? R.drawable.works_ic_comment_keyboard : R.drawable.works_ic_comment_emoji);
            } else {
                drawable2 = null;
                zSafeUnbox = false;
            }
            long j7 = j & 368;
            if (j7 != 0) {
                MutableLiveData<String> mutableLiveDataI = commentInputVM != null ? commentInputVM.i() : null;
                updateLiveDataRegistration(4, mutableLiveDataI);
                value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value2);
                if (j7 != 0) {
                    j = zIsEmpty ? j | 4096 : j | 2048;
                }
                z3 = !zIsEmpty;
                j5 = 0;
                if ((j & 368) != 0) {
                    j |= z3 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
            } else {
                j5 = 0;
                value2 = null;
                zIsEmpty = false;
                z3 = false;
            }
            if ((j & 352) != j5) {
                if (commentInputVM != null) {
                    mutableLiveDataL = commentInputVM.l();
                    i4 = 5;
                } else {
                    i4 = 5;
                    mutableLiveDataL = null;
                }
                updateLiveDataRegistration(i4, mutableLiveDataL);
                CommentImageBean value3 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                boolean z10 = value3 != null;
                if (value3 != null) {
                    int i5 = iSafeUnbox;
                    str = value2;
                    path = value3.getPath();
                    value = value3;
                    drawable = drawable2;
                    mutableLiveData = mutableLiveDataL;
                    i2 = i5;
                    boolean z11 = z9;
                    z4 = z10;
                    z = z11;
                } else {
                    value = value3;
                    drawable = drawable2;
                    mutableLiveData = mutableLiveDataL;
                    i2 = iSafeUnbox;
                    str = value2;
                    path = null;
                    boolean z12 = z9;
                    z4 = z10;
                    z = z12;
                }
            } else {
                i2 = iSafeUnbox;
                drawable = drawable2;
                z = z9;
                mutableLiveData = null;
                value = null;
                z4 = false;
                str = value2;
                path = null;
            }
        } else {
            path = null;
            zIsEmpty = false;
            charSequence = null;
            drawable = null;
            z = false;
            z2 = false;
            str = null;
            mutableLiveData = null;
            zSafeUnbox = false;
            z3 = false;
            i2 = 0;
            value = null;
            z4 = false;
        }
        RequestOptions requestOptions = (j & 352) != 0 ? ju3.h : null;
        if ((j & 384) == 0 || clickProxy == null) {
            iVar = null;
            fVar = null;
            hVar = null;
            gVar = null;
            bVar = null;
            cVar = null;
            dVar = null;
            eVar = null;
        } else {
            i iVar2 = this.f14069a;
            if (iVar2 == null) {
                iVar2 = new i();
                this.f14069a = iVar2;
            }
            i iVarA = iVar2.a(clickProxy);
            b bVar2 = this.f14062a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f14062a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar2 = this.f14063a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f14063a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar2 = this.f14064a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f14064a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            e eVar2 = this.f14065a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f14065a = eVar2;
            }
            e eVarA = eVar2.a(clickProxy);
            f fVar2 = this.f14066a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f14066a = fVar2;
            }
            f fVarA = fVar2.a(clickProxy);
            g gVar2 = this.f14067a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f14067a = gVar2;
            }
            g gVarA = gVar2.a(clickProxy);
            h hVar2 = this.f14068a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f14068a = hVar2;
            }
            h hVarA = hVar2.a(clickProxy);
            bVar = bVarA;
            cVar = cVarA;
            dVar = dVarA;
            eVar = eVarA;
            fVar = fVarA;
            gVar = gVarA;
            hVar = hVarA;
            iVar = iVarA;
        }
        if ((j & 12288) != 0) {
            MutableLiveData<CommentImageBean> mutableLiveDataL2 = commentInputVM != null ? commentInputVM.l() : mutableLiveData;
            updateLiveDataRegistration(5, mutableLiveDataL2);
            if (mutableLiveDataL2 != null) {
                value = mutableLiveDataL2.getValue();
            }
            j2 = 0;
            if ((j & 8192) != 0) {
                z5 = value != null;
            } else {
                z5 = z4;
            }
            if ((j & 4096) != 0 && value == null) {
                z6 = true;
            }
            j3 = j & 368;
            if (j3 != j2) {
                if (!zIsEmpty) {
                    z6 = false;
                }
                if (z3) {
                    z8 = true;
                } else {
                    z8 = z5;
                }
                if (j3 != j2) {
                    if (z6) {
                        j4 = 1024;
                    } else {
                        j4 = 512;
                    }
                    j |= j4;
                }
                if (z6) {
                    i3 = RunIndexRecordAdapter.O;
                } else {
                    i3 = -10155284;
                }
                z7 = z8;
            } else {
                i3 = 0;
                z7 = false;
            }
            if ((j & 352) != 0) {
                CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).f14057b, z5);
                CommonBindingAdapter.b0(this.f, path, requestOptions, false);
            }
            if ((j & 324) != 0) {
                CommonBindingAdapter.i(((WorksDialogCommentInputBinding) this).f36849a, zSafeUnbox);
                ImageViewBindingAdapter.setImageDrawable(((WorksDialogCommentInputBinding) this).b, drawable);
            }
            if ((j & 321) != 0) {
                ((WorksDialogCommentInputBinding) this).f14055a.setHint(charSequence);
            }
            if ((336 & j) != 0) {
                TextViewBindingAdapter.setText(((WorksDialogCommentInputBinding) this).f14055a, str);
            }
            if ((256 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((WorksDialogCommentInputBinding) this).f14055a, null, null, null, this.f14061a);
            }
            if ((j & 322) != 0) {
                CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).f14050a, z);
                CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).b, z);
                CommonBindingAdapter.l0(this.c, z2);
                CommonBindingAdapter.l0(this.d, z);
            }
            if ((j & 384) != 0) {
                CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).f14050a, fVar, null);
                CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).b, iVar, null);
                CommonBindingAdapter.q(this.c, dVar, null);
                CommonBindingAdapter.q(this.d, cVar, null);
                CommonBindingAdapter.q(this.b, gVar, null);
                CommonBindingAdapter.q(this.e, eVar, null);
                CommonBindingAdapter.q(this.f, bVar, null);
                CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).f14051a, hVar, null);
            }
            if ((328 & j) != 0) {
                CommonBindingAdapter.O(this.f14060a, 0, 0, 0, i2, null);
            }
            if ((j & 368) != 0) {
                CommonBindingAdapter.e0(((WorksDialogCommentInputBinding) this).f14051a, z7);
                ((WorksDialogCommentInputBinding) this).f14051a.setTextColor(i3);
            }
        }
        iVar = iVar;
        j2 = 0;
        z5 = z4;
        z6 = false;
        j3 = j & 368;
        if (j3 != j2) {
            if (!zIsEmpty) {
                z6 = false;
            }
            if (z3) {
                z8 = true;
            } else {
                z8 = z5;
            }
            if (j3 != j2) {
                if (z6) {
                    j4 = 1024;
                } else {
                    j4 = 512;
                }
                j |= j4;
            }
            if (z6) {
                i3 = RunIndexRecordAdapter.O;
            } else {
                i3 = -10155284;
            }
            z7 = z8;
        } else {
            i3 = 0;
            z7 = false;
        }
        if ((j & 352) != 0) {
            CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).f14057b, z5);
            CommonBindingAdapter.b0(this.f, path, requestOptions, false);
        }
        if ((j & 324) != 0) {
            CommonBindingAdapter.i(((WorksDialogCommentInputBinding) this).f36849a, zSafeUnbox);
            ImageViewBindingAdapter.setImageDrawable(((WorksDialogCommentInputBinding) this).b, drawable);
        }
        if ((j & 321) != 0) {
            ((WorksDialogCommentInputBinding) this).f14055a.setHint(charSequence);
        }
        if ((336 & j) != 0) {
            TextViewBindingAdapter.setText(((WorksDialogCommentInputBinding) this).f14055a, str);
        }
        if ((256 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((WorksDialogCommentInputBinding) this).f14055a, null, null, null, this.f14061a);
        }
        if ((j & 322) != 0) {
            CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).f14050a, z);
            CommonBindingAdapter.l0(((WorksDialogCommentInputBinding) this).b, z);
            CommonBindingAdapter.l0(this.c, z2);
            CommonBindingAdapter.l0(this.d, z);
        }
        if ((j & 384) != 0) {
            CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).f14050a, fVar, null);
            CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).b, iVar, null);
            CommonBindingAdapter.q(this.c, dVar, null);
            CommonBindingAdapter.q(this.d, cVar, null);
            CommonBindingAdapter.q(this.b, gVar, null);
            CommonBindingAdapter.q(this.e, eVar, null);
            CommonBindingAdapter.q(this.f, bVar, null);
            CommonBindingAdapter.q(((WorksDialogCommentInputBinding) this).f14051a, hVar, null);
        }
        if ((328 & j) != 0) {
            CommonBindingAdapter.O(this.f14060a, 0, 0, 0, i2, null);
        }
        if ((j & 368) != 0) {
            CommonBindingAdapter.e0(((WorksDialogCommentInputBinding) this).f14051a, z7);
            ((WorksDialogCommentInputBinding) this).f14051a.setTextColor(i3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14059a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14059a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogCommentInputBinding
    public void l(@Nullable CommentInputDialog.ClickProxy Click) {
        ((WorksDialogCommentInputBinding) this).f14053a = Click;
        synchronized (this) {
            this.f14059a |= 128;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogCommentInputBinding
    public void m(@Nullable CommentInputVM Vm) {
        ((WorksDialogCommentInputBinding) this).f14054a = Vm;
        synchronized (this) {
            this.f14059a |= 64;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmComment, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmCommentType, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return s((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 4) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 5) {
            return false;
        }
        return q((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmHint, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<CommentImageBean> VmImage, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 32;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmShowEmoji, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 4;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14059a |= 8;
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

    public WorksDialogCommentInputBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (CardView) bindings[12], (CardView) bindings[8], (FrameLayout) bindings[11], (PubWorkContentEditView) bindings[2], (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[3], (ImageView) bindings[4], (BLRelativeLayout) bindings[13], (TextView) bindings[7]);
        this.f14061a = new a();
        this.f14059a = -1L;
        ((WorksDialogCommentInputBinding) this).f14057b.setTag(null);
        ((WorksDialogCommentInputBinding) this).f36849a.setTag(null);
        ((WorksDialogCommentInputBinding) this).f14055a.setTag(null);
        ((WorksDialogCommentInputBinding) this).f14050a.setTag(null);
        ((WorksDialogCommentInputBinding) this).b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.f14060a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[10];
        this.e = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[9];
        this.f = imageView2;
        imageView2.setTag(null);
        ((WorksDialogCommentInputBinding) this).f14051a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
