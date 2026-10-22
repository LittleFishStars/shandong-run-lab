package cj.mobile.wm;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class eb {
    public static va dexa() {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ob.dexa()) {
            return new fb();
        }
        if (ob.dexb()) {
            return new gb();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new nb();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new mb();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new kb();
        }
        if (dexb() || str.equalsIgnoreCase("zuk")) {
            return new hb();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new jb();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new lb();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu") || ob.dexc()) {
            return new ib();
        }
        return null;
    }

    public static boolean dexb() {
        String str = Build.MANUFACTURER;
        String str2 = Build.BRAND;
        return (str != null && (str.equalsIgnoreCase("LENOVO") || str.equalsIgnoreCase("MOTOROLA"))) || (str2 != null && (str2.equalsIgnoreCase("LENOVO") || str2.equalsIgnoreCase("MOTOROLA")));
    }
}
