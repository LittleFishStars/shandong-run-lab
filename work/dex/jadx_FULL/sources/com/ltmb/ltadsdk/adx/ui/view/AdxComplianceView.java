package com.ltmb.ltadsdk.adx.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.ltmb.ltadsdk.adx.dialog.AdDownloadDetailDialog;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.e5;
import com.ltmb.ltadsdk.pkg.p3;
import com.ltmb.ltadsdk.pkg.s;
import com.ltmb.ltadsdk.pkg.w;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001a\u0010!R,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/view/AdxComplianceView;", "Lcom/ltmb/ltadsdk/pkg/w;", "", "Lkotlin/Function0;", "Lcom/ltmb/ltadsdk/pkg/s;", y6b.f, "Lkotlin/jvm/functions/Function0;", "getOnGetClickInfo", "()Lkotlin/jvm/functions/Function0;", "setOnGetClickInfo", "(Lkotlin/jvm/functions/Function0;)V", "onGetClickInfo", "", y6b.g, "getOnClickCallback", "setOnClickCallback", "onClickCallback", "Lcom/ltmb/ltadsdk/pkg/e;", "adsBean", "Lcom/ltmb/ltadsdk/pkg/e;", "getAdsBean", "()Lcom/ltmb/ltadsdk/pkg/e;", "setAdsBean", "(Lcom/ltmb/ltadsdk/pkg/e;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxComplianceView extends w {

    @Nullable
    public e f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public Function0<s> onGetClickInfo;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onClickCallback;
    public int i;

    public static final class a implements p3 {
        public a() {
        }

        public void a(@Nullable Boolean bool, int i) {
            Function0<Unit> onClickCallback = AdxComplianceView.this.getOnClickCallback();
            if (onClickCallback != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxComplianceView(@NotNull Context context) {
        super(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        int iDecrementAndGet;
        e eVar = this.f;
        if (eVar != null) {
            try {
                Intent intent = new Intent(getContext(), (Class<?>) AdDownloadDetailDialog.class);
                synchronized (e5.f) {
                    Intrinsics.checkNotNullParameter(eVar, "ad");
                    try {
                        iDecrementAndGet = e5.c.decrementAndGet();
                        e5.b.put(iDecrementAndGet, eVar);
                    } catch (Throwable th) {
                        d9.d.a(th);
                        iDecrementAndGet = 0;
                    }
                }
                this.i = iDecrementAndGet;
                intent.putExtra("get_info_key", iDecrementAndGet);
                intent.addFlags(268435456);
                Function0<s> function0 = this.onGetClickInfo;
                intent.putExtra("click_info", (Parcelable) (function0 != null ? (s) function0.invoke() : null));
                e5 e5Var = e5.f;
                int i = this.i;
                a aVar = new a();
                synchronized (e5Var) {
                    Intrinsics.checkNotNullParameter(aVar, RenderCallContext.TYPE_CALLBACK);
                    try {
                        e5.d.put(i, aVar);
                    } catch (Throwable th2) {
                        d9.d.a(th2);
                    }
                }
                getContext().startActivity(intent);
            } catch (Throwable th3) {
                d9.d.a(th3);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getAdsBean, reason: from getter */
    public final e getF() {
        return this.f;
    }

    @Nullable
    public final Function0<Unit> getOnClickCallback() {
        return this.onClickCallback;
    }

    @Nullable
    public final Function0<s> getOnGetClickInfo() {
        return this.onGetClickInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        e5 e5Var = e5.f;
        try {
            e5.d.remove(this.i);
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final void setAdsBean(@Nullable e eVar) {
        this.f = eVar;
    }

    public final void setOnClickCallback(@Nullable Function0<Unit> function0) {
        this.onClickCallback = function0;
    }

    public final void setOnGetClickInfo(@Nullable Function0<s> function0) {
        this.onGetClickInfo = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxComplianceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxComplianceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
