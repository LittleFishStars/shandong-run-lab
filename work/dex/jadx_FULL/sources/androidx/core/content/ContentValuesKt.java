package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object objComponent2 = pair.component2();
            if (objComponent2 == null) {
                contentValues.putNull(str);
            } else if (objComponent2 instanceof String) {
                contentValues.put(str, (String) objComponent2);
            } else if (objComponent2 instanceof Integer) {
                contentValues.put(str, (Integer) objComponent2);
            } else if (objComponent2 instanceof Long) {
                contentValues.put(str, (Long) objComponent2);
            } else if (objComponent2 instanceof Boolean) {
                contentValues.put(str, (Boolean) objComponent2);
            } else if (objComponent2 instanceof Float) {
                contentValues.put(str, (Float) objComponent2);
            } else if (objComponent2 instanceof Double) {
                contentValues.put(str, (Double) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                contentValues.put(str, (byte[]) objComponent2);
            } else if (objComponent2 instanceof Byte) {
                contentValues.put(str, (Byte) objComponent2);
            } else {
                if (!(objComponent2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                contentValues.put(str, (Short) objComponent2);
            }
        }
        return contentValues;
    }
}
