package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.AlignmentSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.huachenjie.base.view.ExpandableTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J^\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0007J0\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\rH\u0002J$\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019¨\u0006!"}, d2 = {"Lcom/zj/adlib/v39;", "", "", "source", "Landroid/text/TextPaint;", "textPaint", "", "contentWidth", "Landroid/text/Layout;", "f", "textMinLine", "textMaxLine", "buttonTextColor", "", "closeInNewLine", "Landroid/graphics/drawable/Drawable;", "drawableIcon", "showExpandText", "Lcom/zj/adlib/gb3;", "d", "showText", "Landroid/text/SpannableString;", "a", "c", "", "Ljava/lang/String;", "CHARACTER_ELLIPSIZE", "b", "CHARACTER_CLOSE", "CHARACTER_EXPAND", "CHARACTER_UNIT", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class v39 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v39 f45284a = new v39();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String CHARACTER_ELLIPSIZE = "...";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String CHARACTER_CLOSE = " 收起";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String CHARACTER_EXPAND = " 展开";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String CHARACTER_UNIT = "我";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/zj/adlib/v39$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "", "onClick", "Landroid/text/TextPaint;", "ds", "updateDrawState", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends ClickableSpan {
        public final /* synthetic */ int K;

        public a(int i) {
            this.K = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (widget instanceof ExpandableTextView) {
                ((ExpandableTextView) widget).close();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.K);
            ds.setUnderlineText(false);
            ds.clearShadowLayer();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/zj/adlib/v39$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "", "onClick", "Landroid/text/TextPaint;", "ds", "updateDrawState", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends ClickableSpan {
        public final /* synthetic */ int K;

        public b(int i) {
            this.K = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (widget instanceof ExpandableTextView) {
                ((ExpandableTextView) widget).expand();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.K);
            ds.setUnderlineText(false);
            ds.clearShadowLayer();
        }
    }

    public static /* synthetic */ SpannableString b(v39 v39Var, boolean z, int i, Drawable drawable, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            drawable = null;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return v39Var.a(z, i, drawable, z2);
    }

    @JvmStatic
    @NotNull
    public static final ExpandableText d(@NotNull CharSequence source, @NotNull TextPaint textPaint, int contentWidth, int textMinLine, int textMaxLine, int buttonTextColor, boolean closeInNewLine, @Nullable Drawable drawableIcon, boolean showExpandText) {
        float fMeasureText;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        if (drawableIcon != null) {
            int iRoundToInt = MathKt.roundToInt(textPaint.measureText(CHARACTER_UNIT));
            drawableIcon.setBounds(0, 0, iRoundToInt, iRoundToInt);
        }
        Layout layoutF = f(source, textPaint, contentWidth);
        int lineCount = layoutF.getLineCount();
        if (lineCount <= textMinLine) {
            return new ExpandableText(source, source);
        }
        int i = textMinLine - 1;
        if (drawableIcon == null) {
            fMeasureText = textPaint.measureText(" ... 展开");
        } else {
            fMeasureText = showExpandText ? textPaint.measureText(" ... 展开我") : textPaint.measureText(" ...我");
        }
        CharSequence charSequenceSubSequence = source.subSequence(0, layoutF.getLineStart(i) + textPaint.breakText(source, layoutF.getLineStart(i), layoutF.getLineEnd(i), true, contentWidth - fMeasureText, null));
        if (charSequenceSubSequence.charAt(charSequenceSubSequence.length() - 1) == '\n') {
            charSequenceSubSequence = charSequenceSubSequence.subSequence(0, charSequenceSubSequence.length() - 1);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(charSequenceSubSequence).append((CharSequence) CHARACTER_ELLIPSIZE);
        v39 v39Var = f45284a;
        SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) v39Var.c(buttonTextColor, drawableIcon, showExpandText));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(source.subSequence(0, layoutF.getLineEnd(Math.max(0, Math.min(lineCount, textMaxLine) - 1))));
        if (closeInNewLine) {
            spannableStringBuilder.append((CharSequence) "\n");
        }
        spannableStringBuilder.append((CharSequence) v39Var.a(closeInNewLine, buttonTextColor, drawableIcon, true));
        i4a.c("closeText:" + ((Object) spannableStringBuilderAppend2));
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilderAppend2, "closeText");
        return new ExpandableText(spannableStringBuilderAppend2, spannableStringBuilder);
    }

    @JvmStatic
    @NotNull
    public static final Layout f(@NotNull CharSequence source, @NotNull TextPaint textPaint, int contentWidth) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(source, 0, source.length(), textPaint, contentWidth);
        Intrinsics.checkNotNullExpressionValue(builderObtain, "obtain(\n                …ontentWidth\n            )");
        builderObtain.setAlignment(Layout.Alignment.ALIGN_NORMAL);
        builderObtain.setIncludePad(true);
        builderObtain.setLineSpacing(0.0f, 1.0f);
        StaticLayout staticLayoutBuild = builderObtain.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "{\n            val builde…builder.build()\n        }");
        return staticLayoutBuild;
    }

    public final SpannableString a(boolean closeInNewLine, int buttonTextColor, Drawable drawableIcon, boolean showText) {
        SpannableString spannableString;
        if (drawableIcon == null) {
            spannableString = new SpannableString(CHARACTER_CLOSE);
        } else {
            spannableString = showText ? new SpannableString(" 收起我") : new SpannableString(CHARACTER_UNIT);
        }
        spannableString.setSpan(new ForegroundColorSpan(buttonTextColor), 0, 3, 33);
        if (drawableIcon != null) {
            ef1 ef1Var = new ef1(drawableIcon);
            ef1Var.a(180.0f);
            spannableString.setSpan(ef1Var, spannableString.length() - 1, spannableString.length(), 33);
        }
        if (closeInNewLine) {
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, 1, 33);
        }
        spannableString.setSpan(new a(buttonTextColor), 0, spannableString.length(), 33);
        return spannableString;
    }

    public final SpannableString c(int buttonTextColor, Drawable drawableIcon, boolean showExpandText) {
        SpannableString spannableString;
        if (drawableIcon == null) {
            spannableString = new SpannableString(CHARACTER_EXPAND);
        } else {
            spannableString = showExpandText ? new SpannableString(" 展开我") : new SpannableString(CHARACTER_UNIT);
        }
        if (showExpandText || drawableIcon == null) {
            spannableString.setSpan(new ForegroundColorSpan(buttonTextColor), 0, 3, 33);
        }
        if (drawableIcon != null) {
            spannableString.setSpan(new ef1(drawableIcon), spannableString.length() - 1, spannableString.length(), 33);
        }
        spannableString.setSpan(new b(buttonTextColor), 0, spannableString.length(), 33);
        return spannableString;
    }
}
