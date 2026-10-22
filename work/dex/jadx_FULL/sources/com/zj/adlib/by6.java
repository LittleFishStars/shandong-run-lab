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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/by6;", "", "", "price", "", "minSize", "maxSize", "Landroid/text/SpannableStringBuilder;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class by6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final by6 f40862a = new by6();

    @JvmStatic
    @NotNull
    public static final SpannableStringBuilder a(@NotNull String price, float minSize, float maxSize) {
        Intrinsics.checkNotNullParameter(price, "price");
        try {
            c49 c49VarF = c49.f();
            c49VarF.g(new b49().o("¥").q(qv1.W(minSize)).r(1).p(Color.parseColor("#FF2C3E50")));
            if (StringsKt.contains$default(price, Consts.DOT, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default(price, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                if (listSplit$default.size() > 1) {
                    c49VarF.g(new b49().o((String) listSplit$default.get(0)).q(qv1.W(maxSize)).p(Color.parseColor("#FF2C3E50")).r(1)).g(new b49().o('.' + ((String) listSplit$default.get(1))).q(qv1.W(minSize)).p(Color.parseColor("#FF2C3E50")).r(1));
                } else {
                    c49VarF.g(new b49().o(price).q(qv1.W(maxSize)).r(1).p(Color.parseColor("#FF2C3E50")));
                }
            } else {
                c49VarF.g(new b49().o(price).q(qv1.W(maxSize)).r(1).p(Color.parseColor("#FF2C3E50")));
            }
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            SpannableStringBuilder spannableStringBuilderE2 = c49.f().g(new b49().o(price).q(qv1.W(maxSize)).r(1).p(Color.parseColor("#FF2C3E50"))).e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE2, "create().setSpan(\n      …\"))\n            ).build()");
            return spannableStringBuilderE2;
        }
    }
}
