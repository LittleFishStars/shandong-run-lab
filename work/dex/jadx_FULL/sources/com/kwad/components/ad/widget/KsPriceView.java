package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class KsPriceView extends TextView implements d {
    private static String Ol = "¥%s 到手约 ¥%s";
    private static String Om = "¥%s  ¥%s";
    private static String On = "¥%s";
    private a Ok;
    private String Oo;
    private String Op;
    private boolean Oq;

    public static class a {
        private int Or;
        private int Os;
        private int Ot;
        private int Ou;
        private int Ov;
        private int Ow;

        public final a aE(int i) {
            this.Os = i;
            return this;
        }

        public final a aF(int i) {
            this.Ov = i;
            return this;
        }

        public final a aG(int i) {
            this.Ow = i;
            return this;
        }

        public final int oA() {
            return this.Or;
        }

        public final int oB() {
            return this.Os;
        }

        public final int ow() {
            return this.Ot;
        }

        public final int ox() {
            return this.Ov;
        }

        public final int oy() {
            return this.Ou;
        }

        public final int oz() {
            return this.Ow;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Ok = new a();
        A(context);
    }

    private void A(Context context) {
        setMaxLines(1);
        a aVar = this.Ok;
        Resources resources = context.getResources();
        int i = R.color.ksad_reward_main_color;
        aVar.Ot = resources.getColor(i);
        a aVar2 = this.Ok;
        Resources resources2 = context.getResources();
        int i2 = R.dimen.ksad_reward_order_price_size;
        aVar2.Ou = resources2.getDimensionPixelSize(i2);
        this.Ok.Ov = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Ok.Ow = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Ok.Or = context.getResources().getColor(i);
        this.Ok.Os = context.getResources().getDimensionPixelSize(i2);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        String str3;
        if (str2 == null) {
            str3 = String.format(On, str);
        } else {
            str3 = String.format(z ? Om : Ol, str, str2);
        }
        SpannableString spannableString = new SpannableString(str3);
        if (str3.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.oA()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.oB()), 0, 1, 17);
        }
        int iIndexOf = str3.indexOf(str);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length() + iIndexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.ow()), iIndexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.oy()), iIndexOf, length, 18);
        if (str2 != null) {
            int iLastIndexOf = str3.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + iLastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.ox()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.oz()), iLastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), iLastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Oo = str;
        this.Op = str2;
        this.Oq = z;
        SpannableString spannableStringA = null;
        if (TextUtils.isEmpty(str2)) {
            this.Op = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Ok.ow());
        try {
            spannableStringA = a(str, this.Op, z, this.Ok);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableStringA != null) {
            setText(spannableStringA);
        }
    }

    @NonNull
    public a getConfig() {
        return this.Ok;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ok = new a();
        A(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ok = new a();
        A(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Ok = new a();
        A(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Ok.Ot = eVar.zX();
        d(this.Oo, this.Op, this.Oq);
    }
}
