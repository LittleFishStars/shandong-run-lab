package com.ltmb.ltadsdk.adx.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.pkg.d;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.n3;
import com.ltmb.ltadsdk.pkg.x0;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0016\u0010\u001aB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001dB-\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/view/AdFeedbackEntryView;", "Landroid/widget/TextView;", "", "Landroid/content/Context;", "context", "", "setRealContext", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "getRealContextWeak", "()Ljava/lang/ref/WeakReference;", "setRealContextWeak", "(Ljava/lang/ref/WeakReference;)V", "realContextWeak", "Lcom/ltmb/ltadsdk/pkg/e;", "adsBean", "Lcom/ltmb/ltadsdk/pkg/e;", "getAdsBean", "()Lcom/ltmb/ltadsdk/pkg/e;", "setAdsBean", "(Lcom/ltmb/ltadsdk/pkg/e;)V", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdFeedbackEntryView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public e f40306a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public WeakReference<Context> realContextWeak;
    public x0 c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.ltmb.ltadsdk.adx.ui.view.AdFeedbackEntryView$a$a, reason: collision with other inner class name */
        public static final class C1320a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f40308a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1320a(e eVar) {
                super(0);
                this.f40308a = eVar;
            }

            public Object invoke() {
                ((d) this.f40308a).R = true;
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:41:0x007b  */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context;
            boolean z;
            try {
                e f40306a = AdFeedbackEntryView.this.getF40306a();
                if (f40306a != null) {
                    if (AdFeedbackEntryView.this.getRealContextWeak() != null) {
                        WeakReference<Context> realContextWeak = AdFeedbackEntryView.this.getRealContextWeak();
                        context = realContextWeak != null ? realContextWeak.get() : null;
                    } else {
                        context = AdFeedbackEntryView.this.getContext();
                    }
                    if (!((d) f40306a).R) {
                        x0 x0Var = AdFeedbackEntryView.this.c;
                        if ((x0Var == null || !x0Var.isShowing()) && context != null) {
                            AdFeedbackEntryView adFeedbackEntryView = AdFeedbackEntryView.this;
                            x0 x0Var2 = new x0(context);
                            x0Var2.a(((d) f40306a).p, f40306a.v(), ((d) f40306a).k, (Map) null);
                            x0Var2.g = new C1320a(f40306a);
                            Unit unit = Unit.INSTANCE;
                            adFeedbackEntryView.c = x0Var2;
                            x0 x0Var3 = AdFeedbackEntryView.this.c;
                            if (x0Var3 != null) {
                                x0Var3.a();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (context instanceof Activity) {
                        if (context == null) {
                            z = true;
                        } else {
                            try {
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    if (activity.isFinishing() || activity.isDestroyed()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    if (context instanceof ContextWrapper) {
                                        Context baseContext = ((ContextWrapper) context).getBaseContext();
                                        while (true) {
                                            if (baseContext instanceof ContextWrapper) {
                                                if (!(baseContext instanceof Activity)) {
                                                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                                                } else if (((Activity) baseContext).isFinishing() || ((Activity) baseContext).isDestroyed()) {
                                                }
                                            }
                                            z = false;
                                        }
                                    }
                                    z = true;
                                }
                            } catch (Throwable th) {
                                d9.d.a(th);
                            }
                        }
                        if (z) {
                            return;
                        }
                        n3.e.a(context, "您已成功提交反馈，请勿重复提交哦！");
                    }
                }
            } catch (Throwable th2) {
                d9.d.a(th2);
            }
        }
    }

    public AdFeedbackEntryView(@Nullable Context context) {
        this(context, null);
    }

    public final void a() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setText(context.getResources().getString(R.string.ltad_ad_feedback));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        setTextColor(context2.getResources().getColor(R.color.ltad_color_white));
        setTextSize(14.0f);
        setGravity(17);
        setBackgroundResource(R.drawable.ltad_bg_ad_feedback);
        setOnClickListener(new a());
    }

    @Nullable
    /* JADX INFO: renamed from: getAdsBean, reason: from getter */
    public final e getF40306a() {
        return this.f40306a;
    }

    @Nullable
    public final WeakReference<Context> getRealContextWeak() {
        return this.realContextWeak;
    }

    public final void setAdsBean(@Nullable e eVar) {
        this.f40306a = eVar;
    }

    public final void setRealContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.realContextWeak = new WeakReference<>(context);
    }

    public final void setRealContextWeak(@Nullable WeakReference<Context> weakReference) {
        this.realContextWeak = weakReference;
    }

    public AdFeedbackEntryView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedbackEntryView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public AdFeedbackEntryView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }
}
