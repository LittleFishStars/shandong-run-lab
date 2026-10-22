package com.ltmb.ltadsdk.adx.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.heytap.mcssdk.constant.b;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.core.download.SYDownloadListenerInner;
import com.ltmb.ltadsdk.core.download.SYDownloadTask;
import com.ltmb.ltadsdk.pkg.a5;
import com.ltmb.ltadsdk.pkg.b5;
import com.ltmb.ltadsdk.pkg.d;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.n0;
import com.ltmb.ltadsdk.pkg.o;
import com.ltmb.ltadsdk.pkg.o0;
import com.ltmb.ltadsdk.pkg.s;
import com.ltmb.ltadsdk.pkg.s6;
import com.ltmb.ltadsdk.pkg.w5;
import com.ltmb.ltadsdk.pkg.z4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"B\u001d\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B%\b\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b!\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R.\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/view/AdxClickButton;", "Landroid/widget/Button;", "", "", "status", "", "setDownloadText", "Lcom/ltmb/ltadsdk/core/download/SYDownloadListenerInner;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setDownloadListener", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "getOnClickCallback", "()Lkotlin/jvm/functions/Function0;", "setOnClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "onClickCallback", "Lcom/ltmb/ltadsdk/pkg/s;", "b", "getOnGetAdClickInfo", "setOnGetAdClickInfo", "onGetAdClickInfo", "Lcom/ltmb/ltadsdk/pkg/e;", "value", "adsBean", "Lcom/ltmb/ltadsdk/pkg/e;", "getAdsBean", "()Lcom/ltmb/ltadsdk/pkg/e;", "setAdsBean", "(Lcom/ltmb/ltadsdk/pkg/e;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxClickButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Function0<Unit> onClickCallback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Function0<s> onGetAdClickInfo;

    @Nullable
    public e c;
    public SYDownloadListenerInner d;
    public o e;

    public static final class a implements SYDownloadListenerInner {
        public a() {
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadCompleted(@NotNull SYDownloadTask sYDownloadTask) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            AdxClickButton.this.setDownloadText(sYDownloadTask.getStatus());
            String requestId = sYDownloadTask.getRequestId();
            e c = AdxClickButton.this.getC();
            if (Intrinsics.areEqual(requestId, c != null ? ((d) c).p : null)) {
                w5.a.a(AdxClickButton.this.getC());
                SYDownloadListenerInner sYDownloadListenerInner = AdxClickButton.this.d;
                if (sYDownloadListenerInner != null) {
                    sYDownloadListenerInner.onDownloadCompleted(sYDownloadTask);
                }
            }
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadFailed(@NotNull SYDownloadTask sYDownloadTask, int i, @Nullable String str) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            AdxClickButton.this.setDownloadText(sYDownloadTask.getStatus());
            String requestId = sYDownloadTask.getRequestId();
            e c = AdxClickButton.this.getC();
            if (Intrinsics.areEqual(requestId, c != null ? ((d) c).p : null)) {
                e c2 = AdxClickButton.this.getC();
                if (c2 != null) {
                    try {
                        n0 n0VarI = c2.I();
                        n0VarI.g = i;
                        n0VarI.l = str;
                        Intrinsics.checkNotNullExpressionValue(n0VarI, "params");
                        Intrinsics.checkNotNullParameter(n0VarI, "params");
                        Intrinsics.checkNotNullParameter("sdk_ad_dld_fail", b.k);
                        Intrinsics.checkNotNullParameter(n0VarI, "params");
                        o0.t.a().a("sdk_ad_dld_fail", n0VarI);
                    } catch (Throwable th) {
                        d9.d.a(th);
                    }
                }
                SYDownloadListenerInner sYDownloadListenerInner = AdxClickButton.this.d;
                if (sYDownloadListenerInner != null) {
                    sYDownloadListenerInner.onDownloadFailed(sYDownloadTask, i, str);
                }
            }
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadPaused(@NotNull SYDownloadTask sYDownloadTask) {
            SYDownloadListenerInner sYDownloadListenerInner;
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            AdxClickButton.this.setDownloadText(sYDownloadTask.getStatus());
            String requestId = sYDownloadTask.getRequestId();
            e c = AdxClickButton.this.getC();
            if (!Intrinsics.areEqual(requestId, c != null ? ((d) c).p : null) || (sYDownloadListenerInner = AdxClickButton.this.d) == null) {
                return;
            }
            sYDownloadListenerInner.onDownloadPaused(sYDownloadTask);
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadStart(@NotNull SYDownloadTask sYDownloadTask) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            AdxClickButton.this.setDownloadText(sYDownloadTask.getStatus());
            String requestId = sYDownloadTask.getRequestId();
            e c = AdxClickButton.this.getC();
            if (Intrinsics.areEqual(requestId, c != null ? ((d) c).p : null)) {
                SYDownloadListenerInner sYDownloadListenerInner = AdxClickButton.this.d;
                if (sYDownloadListenerInner != null) {
                    sYDownloadListenerInner.onDownloadStart(sYDownloadTask);
                }
                w5.a.b(AdxClickButton.this.getC());
            }
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onDownloadUpdate(@NotNull SYDownloadTask sYDownloadTask, long j, long j2) {
            SYDownloadListenerInner sYDownloadListenerInner;
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            String requestId = sYDownloadTask.getRequestId();
            e c = AdxClickButton.this.getC();
            if (!Intrinsics.areEqual(requestId, c != null ? ((d) c).p : null) || (sYDownloadListenerInner = AdxClickButton.this.d) == null) {
                return;
            }
            sYDownloadListenerInner.onDownloadUpdate(sYDownloadTask, j, j2);
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onInstallStart(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
            e c = AdxClickButton.this.getC();
            if (Intrinsics.areEqual(str, c != null ? ((d) c).p : null)) {
                w5.a.d(AdxClickButton.this.getC());
                SYDownloadListenerInner sYDownloadListenerInner = AdxClickButton.this.d;
                if (sYDownloadListenerInner != null) {
                    sYDownloadListenerInner.onInstallStart(str);
                }
            }
        }

        @Override // com.ltmb.ltadsdk.core.download.SYDownloadListenerInner
        public void onInstalled(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
            AdxClickButton.this.setDownloadText(7);
            e c = AdxClickButton.this.getC();
            if (Intrinsics.areEqual(str, c != null ? ((d) c).p : null)) {
                w5.a.c(AdxClickButton.this.getC());
                SYDownloadListenerInner sYDownloadListenerInner = AdxClickButton.this.d;
                if (sYDownloadListenerInner != null) {
                    sYDownloadListenerInner.onInstalled(str);
                }
            }
        }
    }

    public AdxClickButton(@Nullable Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDownloadText(int status) {
        String string;
        d9.d.a("setDownloadText status=" + status);
        if (status == 2) {
            string = getResources().getString(R.string.ltad_downloading);
        } else if (status == 3) {
            string = getResources().getString(R.string.ltad_download_pause);
        } else if (status == 4) {
            string = getResources().getString(R.string.ltad_click_install);
        } else if (status != 5) {
            string = status != 7 ? getResources().getString(R.string.ltad_download_now) : getResources().getString(R.string.ltad_open);
        } else {
            string = getResources().getString(R.string.ltad_download_fail);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (status) {\n        …d_download_now)\n        }");
        setText(string);
    }

    @Nullable
    /* JADX INFO: renamed from: getAdsBean, reason: from getter */
    public final e getC() {
        return this.c;
    }

    @Nullable
    public final Function0<Unit> getOnClickCallback() {
        return this.onClickCallback;
    }

    @Nullable
    public final Function0<s> getOnGetAdClickInfo() {
        return this.onGetAdClickInfo;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o oVar = this.e;
        if (oVar != null) {
            oVar.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    public final void setAdsBean(@Nullable e eVar) {
        boolean z;
        o oVar;
        this.c = eVar;
        if (eVar != null && (oVar = this.e) != null) {
            oVar.a(eVar, new z4(eVar, this));
        }
        e eVar2 = this.c;
        if (eVar2 != null) {
            z = eVar2.c();
        }
        a5 a5Var = new a5(this);
        Intrinsics.checkNotNullParameter(this, "view");
        s6 s6Var = new s6();
        s6Var.c = a5Var;
        s6Var.d = z;
        setOnTouchListener(s6Var);
    }

    public final void setDownloadListener(@NotNull SYDownloadListenerInner listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.d = listener;
    }

    public final void setOnClickCallback(@Nullable Function0<Unit> function0) {
        this.onClickCallback = function0;
    }

    public final void setOnGetAdClickInfo(@Nullable Function0<s> function0) {
        this.onGetAdClickInfo = function0;
    }

    public AdxClickButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final s a(View view) {
        if (view instanceof b5) {
            return ((b5) view).getClickInfo();
        }
        if (!(view.getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        s sVarA = a((ViewGroup) parent);
        if (sVarA != null) {
            return sVarA;
        }
        return null;
    }

    public AdxClickButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        o oVar = new o();
        oVar.a(new a());
        Unit unit = Unit.INSTANCE;
        this.e = oVar;
    }
}
