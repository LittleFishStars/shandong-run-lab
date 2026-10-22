package cj.mobile.wm.adIdUtils.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class OAIDRom {
    public static volatile boolean isCoolpad = false;
    public static volatile boolean queryDone = false;

    public static boolean is360OS() {
        return !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/cvjme/vjwfstjpo"), ""));
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("BTVT")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("BTVT"));
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("CMBDLTIBSL")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("CMBDLTIBSL"));
    }

    public static boolean isCoolpad(Context context) {
        if (queryDone) {
            return isCoolpad;
        }
        boolean z = true;
        try {
            queryDone = true;
            if (context.getPackageManager().getPackageInfo(dexc.dexa("dpn/dppmqbe/efwjdfjetvqqpsu"), 0) == null) {
                z = false;
            }
            isCoolpad = z;
        } catch (Throwable unused) {
        }
        return isCoolpad;
    }

    public static boolean isCoosea() {
        return sysProperty(dexc.dexa("sp/pen/nbovgbduvsfs"), "").equalsIgnoreCase(dexc.dexa("QSJ[F"));
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/cvjme/wfstjpo/fnvj"), ""));
    }

    public static boolean isFreeme() {
        return !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/cvjme/gsffnf/mbcfm"), ""));
    }

    public static boolean isHonor() {
        return Build.BRAND.equalsIgnoreCase(dexc.dexa("IPOPS"));
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("IVBXFJ"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexc.dexa("IVBXFJ")) && !str.equalsIgnoreCase(dexc.dexa("IPOPS"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLenovo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("MFOPWP"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexc.dexa("MFOPWP")) && !str.equalsIgnoreCase(dexc.dexa("[VL"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("NFJ[V")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("NFJ[V")) || Build.DISPLAY.toUpperCase().contains(dexc.dexa("GMZNF"));
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/njvj/vj/wfstjpo/obnf"), ""));
    }

    public static boolean isMotolora() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("NPUPMPSB")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("NPUPMPSB"));
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("OVCJB")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("OVCJB"));
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("POFQMVT")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("POFQMVT"));
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("PQQP"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexc.dexa("PQQP")) && !str.equalsIgnoreCase(dexc.dexa("SFBMNF")) && TextUtils.isEmpty(sysProperty(dexc.dexa("sp/cvjme/wfstjpo/pqqpspn"), ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSSUI() {
        return !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/ttvj/qspevdu"), ""));
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("TBNTVOH")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("TBNTVOH"));
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("WJWP")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("WJWP")) || !TextUtils.isEmpty(sysProperty(dexc.dexa("sp/wjwp/pt/wfstjpo"), ""));
    }

    public static boolean isXiaomi() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("YJBPNJ"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexc.dexa("YJBPNJ")) && !str.equalsIgnoreCase(dexc.dexa("SFENJ"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexc.dexa("[UF")) || Build.BRAND.equalsIgnoreCase(dexc.dexa("[UF"));
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(dexc.dexa("boespje/pt/TztufnQspqfsujft"));
            str3 = (String) cls.getMethod(dexc.dexa("hfu"), String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("Tztufn!qspqfsuz!jowplf!fssps;!") + th);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
