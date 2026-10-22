package cj.mobile.wm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v1 {
    public static String dexa = "BPw0c0/dQqRqorasJ2DgnA==";
    public static String dexb = "gwjiX1iwmbTQkJnofPJSJA==";
    public static String dexc = "Hx9uy4g61ym7GU2I2bsvHQ==";
    public static String dexd = "T+pAySlR+rcMppEFMmbs7w==";
    public static String dexe = "lY1Up+eS0uoI9SfS6gMhig==";
    public static String dexf = "y5Ox+AvDQb8Q4fOpXEAWWg==";

    public static String dexa(Intent intent) {
        Uri data;
        return (intent == null || (data = intent.getData()) == null) ? "" : data.getScheme();
    }

    public static String dexa(String str) {
        return ae.dexa(str, com.wangmai.insightvision.openadsdk.common.f.a);
    }

    public static boolean dexa() {
        return dexb(dexa) || dexb(dexb);
    }

    public static boolean dexa(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                String action = intent.getAction();
                Set<String> categories = intent.getCategories();
                if (categories != null && categories.contains(dexa("MSA09I5DeEtnllrocX7zLAFcqljTSaIQq3PeCF1Z1to=")) && dexa("7JAhJYwGosH59j6fgpcgt1nu0cdSAxSF4xm/FnrQ3OE=").equals(action)) {
                    return false;
                }
                String strDexa = dexa(intent);
                if (dexa("VDTjLmWL956fXNAPK6HFfQ==").equals(strDexa) || dexa("5CX4+0f1CjjJg9pxjN3ICQ==").equals(strDexa) || context.getPackageManager().resolveActivity(intent, 131072) == null) {
                    return false;
                }
                if (dexa() || dexb() || dexc() || !dexd()) {
                    Intent intent2 = (Intent) Intent.class.getMethod(dexa("iOpilNWnTB1vZc2tYEBPSw=="), Intent.class, CharSequence.class).invoke(null, intent, dexa("/9MbCLGuVyHxQXYz9FaRCA=="));
                    Intent.class.getMethod(dexa("puZOSludg1SwwgSLfq/B+Q=="), Integer.TYPE).invoke(intent2, 268468224);
                    Context.class.getMethod(dexa("Xrb4kX/12+p2Ie8ZRVdkWQ=="), Intent.class).invoke(context, intent2);
                    return true;
                }
                try {
                    Intent.class.getMethod(dexa("puZOSludg1SwwgSLfq/B+Q=="), Integer.TYPE).invoke(intent, 268468224);
                    Array.set(Array.newInstance((Class<?>) Intent.class, 1), 0, intent);
                    Context.class.getMethod(dexa("CkAqPd50oBYUBEFXX8GA6Q=="), Intent[].class).invoke(context, new Intent[]{intent});
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public static boolean dexb() {
        return dexb(dexc);
    }

    public static boolean dexb(String str) {
        try {
            String str2 = (String) Class.forName(dexa("IUXAp8/lvvT5kXrhBEifQFEJo/n5XOBQN0JwjdSpjs0=")).getField(dexa("VqYu7eM1KzbWalCBsFPcGg==")).get(null);
            return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(dexa(str));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dexc() {
        return dexb(dexd);
    }

    public static boolean dexd() {
        return dexb(dexe) || dexb(dexf);
    }
}
