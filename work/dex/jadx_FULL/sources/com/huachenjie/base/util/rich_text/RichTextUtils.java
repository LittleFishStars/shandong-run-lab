package com.huachenjie.base.util.rich_text;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import androidx.annotation.ColorInt;
import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.base.R;
import com.huachenjie.run.map.RouteOverlay;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.om9;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000f\u001a\u00020\u000eJ0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u000eJ(\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001e¨\u0006'"}, d2 = {"Lcom/huachenjie/base/util/rich_text/RichTextUtils;", "", "", "topicId", "k", "userId", t.d, "goodsId", "f", "url", "", y6b.f, "e", "content", "", "color", "", "i", "Landroid/text/SpannableStringBuilder;", ALPUserTrackConstant.METHOD_BUILD, "spanStart", "spanEnd", "", "a", "Landroid/text/Spannable;", "span", "", "scale", "c", y6b.g, "Ljava/lang/String;", "TOPIC_SCHEME", "b", "USER_SCHEME", "GOODS_SCHEME", "d", "ID_KEY", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class RichTextUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RichTextUtils f32968a = new RichTextUtils();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TOPIC_SCHEME = "topic";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String USER_SCHEME = "user";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String GOODS_SCHEME = "goods";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String ID_KEY = "id";

    public static /* synthetic */ void b(RichTextUtils richTextUtils, SpannableStringBuilder spannableStringBuilder, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            i3 = Color.parseColor(RouteOverlay.f12338c);
        }
        richTextUtils.a(spannableStringBuilder, str, i, i2, i3);
    }

    public static /* synthetic */ void d(RichTextUtils richTextUtils, Spannable spannable, int i, int i2, float f, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f = 1.0f;
        }
        richTextUtils.c(spannable, i, i2, f);
    }

    public static /* synthetic */ CharSequence j(RichTextUtils richTextUtils, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Color.parseColor(RouteOverlay.f12338c);
        }
        return richTextUtils.i(str, i);
    }

    public final void a(@NotNull SpannableStringBuilder build, @NotNull String url, int spanStart, int spanEnd, @ColorInt int color) {
        Intrinsics.checkNotNullParameter(build, ALPUserTrackConstant.METHOD_BUILD);
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, GOODS_SCHEME, false, 2, (Object) null)) {
            d(this, build, spanStart, spanEnd, 0.0f, 8, null);
        }
        build.setSpan(new RichColorUrlSpan(url, color), spanStart, spanEnd, 33);
    }

    public final void c(@NotNull Spannable span, int spanStart, int spanEnd, float scale) {
        Intrinsics.checkNotNullParameter(span, "span");
        Drawable drawable = Utils.a().getDrawable(R.drawable.base_ic_url_goods_logo);
        Intrinsics.checkNotNull(drawable);
        drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * scale), (int) (drawable.getIntrinsicHeight() * scale));
        om9 om9Var = new om9(drawable);
        int i = spanStart + 1;
        span.setSpan(om9Var, spanStart, i, 33);
        span.setSpan(new StyleSpan(1), i, spanEnd, 33);
    }

    @NotNull
    public final String e(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String queryParameter = Uri.parse(url).getQueryParameter("id");
        return queryParameter == null ? "" : queryParameter;
    }

    @NotNull
    public final String f(@NotNull String goodsId) {
        Intrinsics.checkNotNullParameter(goodsId, "goodsId");
        return "goods://?id=" + goodsId;
    }

    public final boolean g(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.startsWith$default(url, GOODS_SCHEME, false, 2, (Object) null);
    }

    public final void h(@NotNull String url) {
        String scheme;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = Uri.parse(url);
        String strE = e(url);
        if (TextUtils.isEmpty(strE) || (scheme = uri.getScheme()) == null) {
            return;
        }
        int iHashCode = scheme.hashCode();
        if (iHashCode == 3599307) {
            if (scheme.equals(USER_SCHEME)) {
                ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", strE).navigation();
            }
        } else if (iHashCode == 98539350) {
            if (scheme.equals(GOODS_SCHEME)) {
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", strE).navigation();
            }
        } else if (iHashCode == 110546223 && scheme.equals("topic")) {
            ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, strE).navigation();
        }
    }

    @NotNull
    public final CharSequence i(@NotNull String content, @ColorInt int color) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!StringsKt.contains$default(content, "<a", false, 2, (Object) null)) {
            return new SpannableString(content);
        }
        Spanned spannedFromHtml = Html.fromHtml(new Regex("\\s{2,}").replace(StringsKt.replace$default(content, "\n", "<br>", false, 4, (Object) null), new Function1<MatchResult, CharSequence>() { // from class: com.huachenjie.base.util.rich_text.RichTextUtils$stringToHtmlSpan$1
            @NotNull
            public final CharSequence invoke(@NotNull MatchResult matchResult) {
                Intrinsics.checkNotNullParameter(matchResult, o.f);
                return StringsKt.repeat("&nbsp;", matchResult.getValue().length());
            }
        }));
        Object[] spans = spannedFromHtml.getSpans(0, spannedFromHtml.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(\n              …:class.java\n            )");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        spannableStringBuilder.clearSpans();
        for (URLSpan uRLSpan : (URLSpan[]) spans) {
            RichTextUtils richTextUtils = f32968a;
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "url.url");
            richTextUtils.a(spannableStringBuilder, url, spannedFromHtml.getSpanStart(uRLSpan), spannedFromHtml.getSpanEnd(uRLSpan), color);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final String k(@NotNull String topicId) {
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        return "topic://?id=" + topicId;
    }

    @NotNull
    public final String l(@NotNull String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return "user://?id=" + userId;
    }
}
