package cj.mobile.wm.permission;

import android.text.TextUtils;
import com.acse.ottn.p3;
import com.blankj.utilcode.util.e;
import com.igexin.assist.control.xiaomi.XmSystemUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RomHelper {
    public static final String MANUFACTURER_HONOR = "HONOR";
    public static final String MANUFACTURER_HUAWEI = "HUAWEI";
    public static final String MANUFACTURER_KNOWN = "KNOWN";
    public static final String MANUFACTURER_OPPO = "OPPO";
    public static final String MANUFACTURER_VIVO = "VIVO";
    public static final String MANUFACTURER_XIAOMI = "XIAOMI";

    public static String getManufacturer() {
        if (isMiui()) {
            return "XIAOMI";
        }
        if (isColorOs()) {
            return "OPPO";
        }
        if (isOriginOs()) {
            return "VIVO";
        }
        if (isEmui()) {
            return "HUAWEI";
        }
        return isMagicOs() ? "HONOR" : "KNOWN";
    }

    public static String getSystemProperty(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(p3.f, String.class).invoke(null, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isColorOs() {
        return (TextUtils.isEmpty(getSystemProperty("ro.build.version.oplusrom")) && TextUtils.isEmpty(getSystemProperty(e.d)) && !getSystemProperty("ro.build.product").toLowerCase().contains("coloros")) ? false : true;
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.hw_emui_api_level"));
    }

    public static boolean isMagicOs() {
        return (TextUtils.isEmpty(getSystemProperty("ro.build.version.magic")) && TextUtils.isEmpty(getSystemProperty("ro.magik.version")) && TextUtils.isEmpty(getSystemProperty("ro.honor.magic.version")) && !getSystemProperty("ro.build.version.emui").toLowerCase().contains("magic") && !getSystemProperty("ro.build.display.id").toLowerCase().contains("magic")) ? false : true;
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(getSystemProperty(XmSystemUtils.KEY_VERSION_MIUI));
    }

    public static boolean isOriginOs() {
        return !TextUtils.isEmpty(getSystemProperty(e.b));
    }
}
