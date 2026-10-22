package com.ltmb.ltadsdk.adx.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.aliyun.credentials.utils.AuthConstant;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.i1;
import com.ltmb.ltadsdk.pkg.l0;
import com.ltmb.ltadsdk.pkg.l1;
import com.ltmb.ltadsdk.pkg.l3;
import com.ltmb.ltadsdk.pkg.n0;
import com.ltmb.ltadsdk.pkg.o0;
import com.ltmb.ltadsdk.pkg.q1;
import com.ltmb.ltadsdk.pkg.s3;
import com.ltmb.ltadsdk.pkg.s7;
import com.ltmb.ltadsdk.pkg.u3;
import com.ltmb.ltadsdk.pkg.v1;
import com.ltmb.ltadsdk.pkg.x3;
import com.ltmb.ltadsdk.pkg.y9;
import com.ltmb.ltadsdk.pkg.z5;
import com.ltmb.ltadsdk.pkg.z9;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001c\u0010#J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/view/AdxVideoView;", "Landroid/widget/FrameLayout;", "", "Lcom/ltmb/ltadsdk/pkg/y9;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "setVideoListener", "", com.alibaba.ariver.jsapi.multimedia.video.a.f, "setVideoMute", "Lcom/ltmb/ltadsdk/pkg/e;", "ad", "setDataSource", AuthConstant.INI_ENABLE, "setEnablePause", "Lcom/ltmb/ltadsdk/pkg/l3$a;", "align", "setTextureViewAlign", "Lkotlin/Function0;", "m", "Lkotlin/jvm/functions/Function0;", "getOnVideoClickCallback", "()Lkotlin/jvm/functions/Function0;", "setOnVideoClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "onVideoClickCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxVideoView extends FrameLayout {
    public static final /* synthetic */ int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f40315a;
    public l1 b;
    public ImageView c;
    public FrameLayout d;
    public v1 e;
    public y9 f;
    public y9 g;
    public boolean h;
    public ViewTreeObserver.OnWindowFocusChangeListener i;
    public l3.a j;
    public e k;
    public z9 l;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onVideoClickCallback;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdxVideoView adxVideoView = AdxVideoView.this;
            if (!adxVideoView.h) {
                Function0<Unit> onVideoClickCallback = adxVideoView.getOnVideoClickCallback();
                if (onVideoClickCallback != null) {
                    return;
                }
                return;
            }
            v1 v1Var = adxVideoView.e;
            if (v1Var != null) {
                if (Intrinsics.areEqual(v1Var.b, z9.e.a)) {
                    v1Var.c();
                } else if (Intrinsics.areEqual(v1Var.b, z9.d.a)) {
                    v1Var.e();
                }
            }
        }
    }

    public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            try {
                d9.d.a("OnWindowFocusChangeListener it=" + z + ", mVideoPlayer=" + AdxVideoView.this.e + ", mStatusOfAfterStop=" + AdxVideoView.this.l);
                if (z) {
                    AdxVideoView adxVideoView = AdxVideoView.this;
                    v1 v1Var = adxVideoView.e;
                    if (v1Var != null && Intrinsics.areEqual(adxVideoView.l, z9.e.a)) {
                        v1Var.e();
                    }
                } else {
                    AdxVideoView adxVideoView2 = AdxVideoView.this;
                    v1 v1Var2 = adxVideoView2.e;
                    if (v1Var2 != null) {
                        adxVideoView2.l = v1Var2.b;
                        v1Var2.c();
                    }
                }
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ boolean b;

        public d(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdxVideoView adxVideoView = AdxVideoView.this;
            boolean z = this.b;
            int i = AdxVideoView.n;
            adxVideoView.a(z);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdxVideoView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(boolean z) {
        try {
            if (this.k == null) {
                d9.d.b("播放失败，请先设置播放数据");
                return;
            }
            d9 d9Var = d9.d;
            StringBuilder sb = new StringBuilder();
            sb.append("state=");
            v1 v1Var = this.e;
            String str = null;
            sb.append(v1Var != null ? v1Var.b : null);
            sb.append(", hashcode=");
            sb.append(hashCode());
            d9Var.a(sb.toString());
            v1 v1Var2 = this.e;
            if (v1Var2 == null) {
                x3.b bVar = x3.c;
                x3 x3Var = (x3) x3.b.getValue();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                x3Var.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                if (x3Var.a == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    x3Var.a = new u3(applicationContext);
                }
                v1 v1Var3 = x3Var.a;
                Intrinsics.checkNotNull(v1Var3);
                this.e = v1Var3;
            } else {
                Intrinsics.checkNotNull(v1Var2);
                if (v1Var2.a()) {
                    return;
                }
            }
            v1 v1Var4 = this.e;
            if (v1Var4 != null) {
                v1Var4.a(this.d, this.j);
                v1Var4.a(z);
                if (this.g == null) {
                    this.g = new c(z);
                }
                y9 y9Var = this.g;
                if (y9Var != null) {
                    Intrinsics.checkNotNullParameter(y9Var, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
                    v1Var4.a = y9Var;
                }
                e eVar = this.k;
                Intrinsics.checkNotNull(eVar);
                eVar.getClass();
                try {
                    com.ltmb.ltadsdk.pkg.b.a.b bVarX = eVar.x();
                    if (bVarX != null) {
                        str = bVarX.a;
                    }
                } catch (Exception e) {
                    d9.d.a(e);
                }
                Intrinsics.checkNotNullExpressionValue(str, "mAdsBean!!.videoUrl");
                v1Var4.a(str, true);
                v1Var4.d();
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final void b(boolean z) {
        try {
            if (this.k != null) {
                a(z);
            } else {
                post(new d(z));
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    @Nullable
    public final Function0<Unit> getOnVideoClickCallback() {
        return this.onVideoClickCallback;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            d9.d.a("AdVideoView onAttachedToWindow, hashcode=" + hashCode());
            if (this.k == null || this.f40315a.getVisibility() != 8) {
                return;
            }
            v1 v1Var = this.e;
            if (!Intrinsics.areEqual(v1Var != null ? v1Var.b : null, z9.a.a)) {
                v1 v1Var2 = this.e;
                if (!Intrinsics.areEqual(v1Var2 != null ? v1Var2.b : null, z9.i.a)) {
                    return;
                }
            }
            this.f40315a.setVisibility(0);
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = this.i;
            if (onWindowFocusChangeListener != null) {
                getViewTreeObserver().removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
                this.i = null;
            }
            v1 v1Var = this.e;
            if (v1Var != null) {
                y9 y9Var = this.g;
                synchronized (v1Var) {
                    try {
                        y9 y9Var2 = v1Var.a;
                        if (y9Var2 != null && Intrinsics.areEqual(y9Var2, y9Var)) {
                            v1Var.a = null;
                            v1Var.b();
                        }
                    } catch (Throwable th) {
                        d9.d.a(th);
                    }
                }
            }
            this.e = null;
            d9.d.a("AdVideoView onDetachedFromWindow, hashcode=" + hashCode());
        } catch (Throwable th2) {
            d9.d.a(th2);
        }
    }

    public final void setDataSource(@NotNull e ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.k = ad;
        i1.a(this.f40315a, ad.m(), (i1.b) null);
    }

    public final void setEnablePause(boolean enable) {
        this.h = enable;
    }

    public final void setOnVideoClickCallback(@Nullable Function0<Unit> function0) {
        this.onVideoClickCallback = function0;
    }

    public final void setTextureViewAlign(@NotNull l3.a align) {
        Intrinsics.checkNotNullParameter(align, "align");
        this.j = align;
    }

    public final void setVideoListener(@NotNull y9 listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.f = listener;
    }

    public final void setVideoMute(boolean mute) {
        v1 v1Var = this.e;
        if (v1Var != null) {
            v1Var.a(mute);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdxVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.l = z9.c.a;
        setBackgroundColor(getResources().getColor(R.color.ltad_color_black));
        FrameLayout frameLayout = new FrameLayout(context);
        this.d = frameLayout;
        frameLayout.setOnClickListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.d, layoutParams);
        l1 l1Var = new l1(context);
        this.b = l1Var;
        l1Var.setVisibility(0);
        s7 s7Var = s7.a;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(s7Var.a(40), s7Var.a(40));
        layoutParams2.gravity = 17;
        addView(this.b, layoutParams2);
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setImageResource(R.drawable.ltad_icon_video_pause);
        this.c.setVisibility(8);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(s7Var.a(45), s7Var.a(45));
        layoutParams3.gravity = 17;
        addView(this.c, layoutParams3);
        ImageView imageView2 = new ImageView(context);
        this.f40315a = imageView2;
        imageView2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams4.gravity = 17;
        addView(this.f40315a, layoutParams4);
        this.i = new b();
        getViewTreeObserver().addOnWindowFocusChangeListener(this.i);
    }

    public static final class c implements y9 {
        public c(boolean z) {
        }

        public void a(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str, "message");
            e eVar = AdxVideoView.this.k;
            Intrinsics.checkNotNullParameter(str, "message");
            if (eVar == null) {
                return;
            }
            try {
                n0 n0VarI = eVar.I();
                n0VarI.g = i;
                n0VarI.l = str;
                Intrinsics.checkNotNullExpressionValue(n0VarI, "params");
                Intrinsics.checkNotNullParameter(n0VarI, "params");
                Intrinsics.checkNotNullParameter("sdk_ad_play_fail", com.heytap.mcssdk.constant.b.k);
                Intrinsics.checkNotNullParameter(n0VarI, "params");
                o0.t.a().a("sdk_ad_play_fail", n0VarI);
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }

        public void b() {
            AdxVideoView.this.b.setVisibility(0);
        }

        public void a(@NotNull z9 z9Var) {
            Intrinsics.checkNotNullParameter(z9Var, "state");
            try {
                if (Intrinsics.areEqual(z9Var, z9.e.a)) {
                    AdxVideoView.this.b.setVisibility(8);
                    AdxVideoView.this.f40315a.setVisibility(8);
                    AdxVideoView.this.c.setVisibility(8);
                    e eVar = AdxVideoView.this.k;
                    if (eVar != null) {
                        try {
                            if (!((com.ltmb.ltadsdk.pkg.d) eVar).A) {
                                n0 n0VarI = eVar.I();
                                Intrinsics.checkNotNullExpressionValue(n0VarI, "params");
                                Intrinsics.checkNotNullParameter(n0VarI, "params");
                                Intrinsics.checkNotNullParameter("sdk_ad_play_start", com.heytap.mcssdk.constant.b.k);
                                Intrinsics.checkNotNullParameter(n0VarI, "params");
                                o0.t.a().a("sdk_ad_play_start", n0VarI);
                                ((com.ltmb.ltadsdk.pkg.d) eVar).A = true;
                            }
                        } catch (Throwable th) {
                            d9.d.a(th);
                        }
                    }
                } else if (!Intrinsics.areEqual(z9Var, z9.i.a) && !Intrinsics.areEqual(z9Var, z9.b.a)) {
                    if (Intrinsics.areEqual(z9Var, z9.d.a)) {
                        AdxVideoView.this.c.setVisibility(0);
                    } else if (Intrinsics.areEqual(z9Var, z9.a.a)) {
                        e eVar2 = AdxVideoView.this.k;
                        if (eVar2 != null) {
                            try {
                                if (!((com.ltmb.ltadsdk.pkg.d) eVar2).B) {
                                    n0 n0VarI2 = eVar2.I();
                                    Intrinsics.checkNotNullExpressionValue(n0VarI2, "params");
                                    Intrinsics.checkNotNullParameter(n0VarI2, "params");
                                    Intrinsics.checkNotNullParameter("sdk_ad_play_finish", com.heytap.mcssdk.constant.b.k);
                                    Intrinsics.checkNotNullParameter(n0VarI2, "params");
                                    o0.t.a().a("sdk_ad_play_finish", n0VarI2);
                                    ((com.ltmb.ltadsdk.pkg.d) eVar2).B = true;
                                }
                            } catch (Throwable th2) {
                                d9.d.a(th2);
                            }
                        }
                    } else if (Intrinsics.areEqual(z9Var, z9.g.a)) {
                        AdxVideoView.this.b.setVisibility(0);
                        AdxVideoView.this.f40315a.setVisibility(8);
                    }
                } else {
                    AdxVideoView.this.f40315a.setVisibility(0);
                }
                y9 y9Var = AdxVideoView.this.f;
                if (y9Var != null) {
                    y9Var.a(z9Var);
                }
            } catch (Throwable th3) {
                d9.d.a(th3);
            }
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00dd  */
        public void a(long j, long j2) {
            List<l0.a> list;
            String strReplace$default;
            List list2;
            y9 y9Var = AdxVideoView.this.f;
            if (y9Var != null) {
                y9Var.a(j, j2);
            }
            e eVar = AdxVideoView.this.k;
            if (eVar == null) {
                return;
            }
            try {
                if (((com.ltmb.ltadsdk.pkg.d) eVar).I) {
                    return;
                }
                l0 l0Var = ((com.ltmb.ltadsdk.pkg.d) eVar).d;
                int i = 0;
                int size = (l0Var == null || (list2 = l0Var.k) == null) ? 0 : list2.size();
                q1.a aVar = new q1.a((String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, 262143);
                aVar.c(String.valueOf(System.currentTimeMillis()));
                l0 l0Var2 = ((com.ltmb.ltadsdk.pkg.d) eVar).d;
                if (l0Var2 != null && (list = l0Var2.k) != null) {
                    int i2 = 0;
                    for (l0.a aVar2 : list) {
                        if (aVar2.c) {
                            i2++;
                        } else {
                            if (j2 >= aVar2.b * 1000) {
                                String str = aVar2.a;
                                Intrinsics.checkNotNullParameter(aVar, "macro");
                                try {
                                    List<Pair> listListOf = CollectionsKt.listOf(TuplesKt.to("__AEVENTTIME__", aVar.r));
                                    if (str == null) {
                                        strReplace$default = "";
                                    } else {
                                        String str2 = str.length() > 0 ? str : null;
                                        if (str2 != null) {
                                            strReplace$default = str2;
                                            for (Pair pair : listListOf) {
                                                strReplace$default = StringsKt.replace$default(strReplace$default, (String) pair.component1(), (String) pair.component2(), false, 4, (Object) null);
                                            }
                                            if (strReplace$default == null) {
                                                strReplace$default = "";
                                            }
                                        } else {
                                            strReplace$default = "";
                                        }
                                    }
                                } catch (Throwable unused) {
                                    if (str == null) {
                                        str = "";
                                    }
                                    strReplace$default = str;
                                }
                                s3 s3Var = new s3(strReplace$default);
                                String strV = eVar.v();
                                Intrinsics.checkNotNullExpressionValue(strV, "ads.slotId");
                                s3Var.d(strV);
                                String strD = eVar.d();
                                Intrinsics.checkNotNullExpressionValue(strD, "ads.adCodeId");
                                s3Var.a(strD);
                                String str3 = ((com.ltmb.ltadsdk.pkg.d) eVar).k;
                                Intrinsics.checkNotNullExpressionValue(str3, "ads.adId");
                                s3Var.b(str3);
                                String str4 = ((com.ltmb.ltadsdk.pkg.d) eVar).p;
                                Intrinsics.checkNotNullExpressionValue(str4, "ads.requestId");
                                s3Var.c(str4);
                                Map mapO = eVar.o();
                                if (mapO != null) {
                                    s3Var.a(mapO);
                                }
                                s3Var.a(z5.a);
                            }
                            aVar2.c = true;
                        }
                    }
                    i = i2;
                }
                if (i == size) {
                    ((com.ltmb.ltadsdk.pkg.d) eVar).I = true;
                }
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }

        public void a() {
            AdxVideoView.this.b.setVisibility(8);
        }
    }
}
