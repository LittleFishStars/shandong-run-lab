package com.zj.adlib;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import com.alibaba.android.arouter.utils.Consts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J8\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J8\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002H\u0007J8\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002H\u0007¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/cy6;", "", "", "multipleSku", "", "minSkuPrice", "maxSkuPrice", y6b.f, "", "goodsType", "minPointsInMinPriceSku", "maxPointsInMinPriceSku", "e", "salePrice", "pointsPrice", y6b.g, "f", "", "price", "intTextSize", "floatTextSize", "textColor", "showMulti", "", "a", "b", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class cy6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cy6 f41067a = new cy6();

    @JvmStatic
    @NotNull
    public static final CharSequence a(float price, float intTextSize, float floatTextSize, @NotNull String textColor, boolean showMulti) {
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        String strValueOf = String.valueOf(price);
        Intrinsics.checkNotNullExpressionValue(strValueOf, "valueOf(price)");
        return b(strValueOf, intTextSize, floatTextSize, textColor, showMulti);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    @JvmStatic
    @NotNull
    public static final CharSequence b(@NotNull String price, float intTextSize, float floatTextSize, @NotNull String textColor, boolean showMulti) {
        String strSubstring;
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        int iIndexOf$default = StringsKt.indexOf$default(price, Consts.DOT, 0, false, 6, (Object) null);
        if (iIndexOf$default > -1) {
            int i = iIndexOf$default + 1;
            if (price.length() - i > 2) {
                strSubstring = price.substring(0, i + 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = price;
            }
        } else {
            strSubstring = price;
        }
        try {
            c49 c49VarF = c49.f();
            c49VarF.g(new b49().o("¥").q(qv1.W(floatTextSize)).r(1).p(Color.parseColor(textColor)));
            if (StringsKt.contains$default(strSubstring, Consts.DOT, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default(strSubstring, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                if (listSplit$default.size() > 1) {
                    c49VarF.g(new b49().o((String) listSplit$default.get(0)).q(qv1.W(intTextSize)).p(Color.parseColor(textColor)).r(1)).g(new b49().o('.' + ((String) listSplit$default.get(1))).q(qv1.W(floatTextSize)).p(Color.parseColor(textColor)).r(1));
                } else {
                    c49VarF.g(new b49().o(strSubstring).q(qv1.W(intTextSize)).r(1).p(Color.parseColor(textColor)));
                }
            } else {
                c49VarF.g(new b49().o(strSubstring).q(qv1.W(intTextSize)).r(1).p(Color.parseColor(textColor)));
            }
            if (showMulti) {
                c49VarF.g(new b49().o("起").q(qv1.W(floatTextSize)).p(Color.parseColor(textColor)).r(1));
            }
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            if (!showMulti) {
                return strSubstring;
            }
            return strSubstring + (char) 36215;
        }
    }

    public static /* synthetic */ CharSequence c(float f, float f2, float f3, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 16.0f;
        }
        if ((i & 4) != 0) {
            f3 = 12.0f;
        }
        if ((i & 8) != 0) {
            str = "#FFFFFF";
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return a(f, f2, f3, str, z);
    }

    public static /* synthetic */ CharSequence d(String str, float f, float f2, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 16.0f;
        }
        if ((i & 4) != 0) {
            f2 = 12.0f;
        }
        if ((i & 8) != 0) {
            str2 = "#FFFFFF";
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return b(str, f, f2, str2, z);
    }

    @JvmStatic
    @NotNull
    public static final String e(int goodsType, boolean multipleSku, @NotNull String minSkuPrice, @NotNull String maxSkuPrice, int minPointsInMinPriceSku, int maxPointsInMinPriceSku) {
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        Intrinsics.checkNotNullParameter(maxSkuPrice, "maxSkuPrice");
        if (goodsType != 3) {
            return g(multipleSku, minSkuPrice, maxSkuPrice);
        }
        if (Intrinsics.areEqual(minSkuPrice, "0")) {
            if (minPointsInMinPriceSku == maxPointsInMinPriceSku) {
                return minPointsInMinPriceSku + fe9.b.FLASH_COINS;
            }
            return minPointsInMinPriceSku + "闪金币起";
        }
        if ((!multipleSku || Intrinsics.areEqual(minSkuPrice, maxSkuPrice)) && minPointsInMinPriceSku == maxPointsInMinPriceSku) {
            return minPointsInMinPriceSku + "闪金币+¥" + minSkuPrice;
        }
        return minPointsInMinPriceSku + "闪金币+¥" + minSkuPrice + (char) 36215;
    }

    @JvmStatic
    @NotNull
    public static final String f(@NotNull String salePrice, int pointsPrice) {
        Intrinsics.checkNotNullParameter(salePrice, "salePrice");
        if (pointsPrice == 0) {
            return (char) 165 + salePrice;
        }
        if (Intrinsics.areEqual(salePrice, "0") || Intrinsics.areEqual(salePrice, "0.00")) {
            return pointsPrice + fe9.b.FLASH_COINS;
        }
        return pointsPrice + "闪金币+¥" + salePrice;
    }

    @JvmStatic
    @NotNull
    public static final String g(boolean multipleSku, @NotNull String minSkuPrice, @NotNull String maxSkuPrice) {
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        Intrinsics.checkNotNullParameter(maxSkuPrice, "maxSkuPrice");
        if (!multipleSku || Intrinsics.areEqual(minSkuPrice, maxSkuPrice)) {
            return (char) 165 + minSkuPrice;
        }
        return (char) 165 + minSkuPrice + (char) 36215;
    }

    @JvmStatic
    @NotNull
    public static final String h(int goodsType, @NotNull String salePrice, int pointsPrice) {
        Intrinsics.checkNotNullParameter(salePrice, "salePrice");
        if (goodsType == 3) {
            return f(salePrice, pointsPrice);
        }
        return (char) 165 + salePrice;
    }
}
