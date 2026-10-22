package androidx.coroutines.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.coroutines.BindingConversion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class Converters {
    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int i) {
        return ColorStateList.valueOf(i);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int i) {
        return new ColorDrawable(i);
    }
}
