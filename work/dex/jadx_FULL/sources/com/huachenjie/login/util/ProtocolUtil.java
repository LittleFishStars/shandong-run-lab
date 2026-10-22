package com.huachenjie.login.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.base.util.spannable.span.CustomClickableSpan;
import com.huachenjie.login.R;
import com.huachenjie.login.util.ProtocolUtil;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.uy6;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004J,\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010 ¨\u0006$"}, d2 = {"Lcom/huachenjie/login/util/ProtocolUtil;", "", "Landroid/widget/TextView;", "textView", "", "privacyName", "privacyUrl", "", y6b.g, "protocolStr", "f", "Landroid/content/Context;", "context", "", "text", "Landroid/text/SpannableString;", "d", RVParams.SHOW_TOOLBAR, "protocol", "Lkotlin/Function1;", "Landroid/view/View;", "onClick", "c", "view", "url", "j", "i", "Ljava/util/concurrent/atomic/AtomicLong;", "a", "Ljava/util/concurrent/atomic/AtomicLong;", "lastClickTime", "", "I", "clickInterval", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ProtocolUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int clickInterval = 500;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final ProtocolUtil f10119a = new ProtocolUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final AtomicLong lastClickTime = new AtomicLong(0);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/login/util/ProtocolUtil$a", "Lcom/huachenjie/base/util/spannable/span/CustomClickableSpan;", "Landroid/view/View;", "widget", "", "a", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends CustomClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<View, Unit> f34756a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super View, Unit> function1) {
            this.f34756a = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huachenjie.base.util.spannable.span.CustomClickableSpan
        public void a(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (widget instanceof Checkable) {
                ((Checkable) widget).toggle();
            }
            this.f34756a.invoke(widget);
        }
    }

    public static /* synthetic */ SpannableString e(ProtocolUtil protocolUtil, Context context, CharSequence charSequence, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return protocolUtil.d(context, charSequence, str, str2);
    }

    public static /* synthetic */ void g(ProtocolUtil protocolUtil, TextView textView, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        protocolUtil.f(textView, str);
    }

    public static final void k(View view, String str) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(str, "$url");
        ProtocolUtil protocolUtil = f10119a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        protocolUtil.i(context, str);
    }

    public final void c(SpannableString sb, String protocol, Function1<? super View, Unit> onClick) {
        int iIndexOf$default = StringsKt.indexOf$default(sb, protocol, 0, false, 6, (Object) null);
        if (iIndexOf$default > -1) {
            sb.setSpan(new ForegroundColorSpan(Color.parseColor("#00B6DE")), iIndexOf$default, protocol.length() + iIndexOf$default, 34);
            sb.setSpan(new StyleSpan(1), iIndexOf$default, protocol.length() + iIndexOf$default, 34);
            sb.setSpan(new a(onClick), iIndexOf$default, protocol.length() + iIndexOf$default, 34);
        }
    }

    @NotNull
    public final SpannableString d(@NotNull Context context, @NotNull CharSequence text, @Nullable String protocolStr, @Nullable final String privacyUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        if (TextUtils.isEmpty(text)) {
            return new SpannableString(text);
        }
        SpannableString spannableString = new SpannableString(text);
        String string = context.getResources().getString(R.string.login_user_protocol);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.login_user_protocol)");
        c(spannableString, string, new Function1<View, Unit>() { // from class: com.huachenjie.login.util.ProtocolUtil$createProtocolClickable$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, o.f);
                ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
                String str = uy6.f45250a;
                Intrinsics.checkNotNullExpressionValue(str, "AGREEMENT_URL");
                protocolUtil.j(view, str);
            }
        });
        String string2 = context.getResources().getString(R.string.login_privacy_protocol);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…g.login_privacy_protocol)");
        c(spannableString, string2, new Function1<View, Unit>() { // from class: com.huachenjie.login.util.ProtocolUtil$createProtocolClickable$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, o.f);
                ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
                String str = uy6.b;
                Intrinsics.checkNotNullExpressionValue(str, "PRIVACY_URL");
                protocolUtil.j(view, str);
            }
        });
        String string3 = context.getResources().getString(R.string.login_third_sdk_protocol);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr…login_third_sdk_protocol)");
        c(spannableString, string3, new Function1<View, Unit>() { // from class: com.huachenjie.login.util.ProtocolUtil$createProtocolClickable$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, o.f);
                ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
                String str = uy6.c;
                Intrinsics.checkNotNullExpressionValue(str, "SDK_PRIVACY_URL");
                protocolUtil.j(view, str);
            }
        });
        if (!TextUtils.isEmpty(protocolStr)) {
            if (protocolStr == null) {
                protocolStr = "";
            }
            c(spannableString, protocolStr, new Function1<View, Unit>() { // from class: com.huachenjie.login.util.ProtocolUtil$createProtocolClickable$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((View) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, o.f);
                    if (TextUtils.isEmpty(privacyUrl)) {
                        return;
                    }
                    ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
                    String str = privacyUrl;
                    if (str == null) {
                        str = "";
                    }
                    protocolUtil.j(view, str);
                }
            });
        }
        return spannableString;
    }

    public final void f(@NotNull TextView textView, @Nullable String protocolStr) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        CharSequence text = protocolStr;
        if (protocolStr == null) {
            text = textView.getText();
        }
        CharSequence charSequence = text;
        Intrinsics.checkNotNullExpressionValue(charSequence, "protocolStr ?: textView.text");
        textView.setText(e(this, context, charSequence, null, null, 12, null));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public final void h(@NotNull TextView textView, @Nullable String privacyName, @Nullable String privacyUrl) {
        SpannableString spannableStringD;
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (TextUtils.isEmpty(privacyName)) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            String strE = ys8.e(R.string.login_protocol);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.login_protocol)");
            spannableStringD = e(this, context, strE, null, null, 12, null);
        } else {
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "textView.context");
            String string = textView.getContext().getString(R.string.login_protocol_with_phone_operator, privacyName);
            Intrinsics.checkNotNullExpressionValue(string, "textView.context.getStri…one_operator,privacyName)");
            spannableStringD = d(context2, string, privacyName, privacyUrl);
        }
        textView.setText(spannableStringD);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public final void i(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        context.startActivity(intent);
    }

    public final void j(final View view, final String url) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong = lastClickTime;
        if (jCurrentTimeMillis - atomicLong.get() < 500) {
            fv5.b("您的手速太快了");
            return;
        }
        atomicLong.set(jCurrentTimeMillis);
        if (view instanceof Checkable) {
            view.postDelayed(new Runnable() { // from class: com.zj.adlib.a27
                @Override // java.lang.Runnable
                public final void run() {
                    ProtocolUtil.k(view, url);
                }
            }, 32L);
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        i(context, url);
    }
}
