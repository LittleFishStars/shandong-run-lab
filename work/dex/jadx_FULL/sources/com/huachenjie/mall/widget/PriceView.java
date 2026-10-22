package com.huachenjie.mall.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.mall.R;
import com.zj.adlib.fe9;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010+\u001a\u00020\r¢\u0006\u0004\b,\u0010-J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0010R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0010R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0018¨\u0006."}, d2 = {"Lcom/huachenjie/mall/widget/PriceView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "Landroid/widget/TextView$BufferType;", "type", "", "setText", "Landroid/util/AttributeSet;", "attrs", "b", "", "dpValue", "", "dp2px", "K", "I", "moneySize", "L", "intSize", "M", "decimalSize", "", "a", "Z", "strikethrough", "", "f", "Ljava/lang/String;", RequestParameters.PREFIX, "N", "prefixSize", y6b.f, "suffix", "O", "suffixSize", "keepZero", "P", "addSize", "c", "isInit", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PriceView extends AppCompatTextView {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int moneySize;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int intSize;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public int decimalSize;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public int prefixSize;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public int suffixSize;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    public int addSize;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean strikethrough;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean keepZero;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean isInit;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String prefix;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String suffix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PriceView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PriceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PriceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void b(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MallPriceView);
        this.moneySize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_money_size, (int) getTextSize());
        this.intSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_int_size, (int) getTextSize());
        this.decimalSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_decimal_size, (int) getTextSize());
        this.strikethrough = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MallPriceView_mall_strikethrough, false);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.MallPriceView_mall_prefix);
        String str = "";
        if (string == null) {
            string = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.styleable.Ma…ceView_mall_prefix) ?: \"\"");
        }
        this.prefix = string;
        this.prefixSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_prefix_size, (int) getTextSize());
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.MallPriceView_mall_suffix);
        if (string2 != null) {
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.styleable.Ma…ceView_mall_suffix) ?: \"\"");
            str = string2;
        }
        this.suffix = str;
        this.suffixSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_suffix_size, (int) getTextSize());
        this.keepZero = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MallPriceView_mall_keep_zero, false);
        this.addSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MallPriceView_mall_add_size, (int) getTextSize());
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int dp2px(float dpValue) {
        return (int) ((dpValue * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        boolean z;
        String str;
        String str2;
        String str3;
        boolean z2;
        String strReplace;
        if ((text == null || text.length() == 0) || !this.isInit) {
            super.setText(text, type);
            return;
        }
        String string = text.toString();
        if (StringsKt.contains$default(string, "+", false, 2, (Object) null)) {
            List listSplit$default = StringsKt.split$default(string, new String[]{"+"}, false, 0, 6, (Object) null);
            string = (String) listSplit$default.get(0);
            str = (String) listSplit$default.get(1);
            z = true;
        } else if (StringsKt.contains$default(string, fe9.b.FLASH_COINS, false, 2, (Object) null)) {
            z = false;
            str = null;
        } else {
            z = false;
            str = string;
            string = null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.prefix.length() > 0) {
            spannableStringBuilder.append((CharSequence) (this.prefix + ' '));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.prefixSize, false), 0, spannableStringBuilder.length(), 33);
        }
        if (TextUtils.isEmpty(string)) {
            str2 = "this as java.lang.String…ing(startIndex, endIndex)";
        } else {
            int length = spannableStringBuilder.length();
            Intrinsics.checkNotNull(string);
            str2 = "this as java.lang.String…ing(startIndex, endIndex)";
            String strSubstring = string.substring(0, StringsKt.lastIndexOf$default(string, fe9.b.FLASH_COINS, 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(strSubstring, str2);
            spannableStringBuilder.append((CharSequence) strSubstring);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.intSize, false), length, length2, 33);
            spannableStringBuilder.append((CharSequence) " 闪金币");
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.suffixSize, false), length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " + ");
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.addSize, false), length3, spannableStringBuilder.length(), 33);
            }
            Intrinsics.checkNotNull(str);
            Character chLastOrNull = StringsKt.lastOrNull(str);
            if (chLastOrNull != null && chLastOrNull.charValue() == 36215) {
                String strSubstring2 = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, str2);
                str3 = strSubstring2;
                z2 = true;
            } else {
                str3 = str;
                z2 = false;
            }
            List listSplit$default2 = StringsKt.split$default(str3, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
            String strSubstring3 = (String) listSplit$default2.get(0);
            if ((strSubstring3.length() > 0) && strSubstring3.charAt(0) == 165) {
                strSubstring3 = strSubstring3.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
            }
            if (listSplit$default2.size() > 1) {
                strReplace = '.' + ((String) listSplit$default2.get(1));
            } else {
                strReplace = "";
            }
            if (!this.keepZero) {
                strReplace = new Regex("[.]$").replace(new Regex("0+?$").replace(strReplace, ""), "");
            }
            int length4 = spannableStringBuilder.length();
            int length5 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "¥");
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.moneySize, false), length4, spannableStringBuilder.length(), 33);
            if (strSubstring3.length() > 0) {
                int length6 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) strSubstring3);
                int length7 = spannableStringBuilder.length();
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.intSize, false), length6, length7, 33);
                length5 = length7;
            }
            if (strReplace.length() > 0) {
                int length8 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) strReplace);
                length5 = spannableStringBuilder.length();
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.decimalSize, false), length8, length5, 33);
            }
            if (this.strikethrough) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), length4, length5, 33);
            }
            if (z2) {
                int length9 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) " 起");
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.suffixSize, false), length9, spannableStringBuilder.length(), 33);
            }
        } else if (!TextUtils.isEmpty(string)) {
            if (string != null && StringsKt.contains$default(string, "起", false, 2, (Object) null)) {
                int length10 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "起");
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.suffixSize, false), length10, spannableStringBuilder.length(), 33);
            }
        }
        if (this.suffix.length() > 0) {
            int length11 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (' ' + this.suffix));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.suffixSize, false), length11, spannableStringBuilder.length(), 33);
        }
        super.setText(spannableStringBuilder, type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PriceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.moneySize = dp2px(12.0f);
        this.intSize = dp2px(12.0f);
        this.decimalSize = dp2px(12.0f);
        this.prefix = "";
        this.prefixSize = dp2px(12.0f);
        this.suffix = "";
        this.suffixSize = dp2px(12.0f);
        this.addSize = dp2px(12.0f);
        b(attributeSet);
        this.isInit = true;
    }
}
