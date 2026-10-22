package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, d2 = {"htmlEncode", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
