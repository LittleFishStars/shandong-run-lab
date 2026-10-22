package com.kc.bw.adIdUtils.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class OAIDRom {
    public static int alreadyQueried;
    public static boolean isCoolpad;

    public static boolean is360OS() {
        return !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/cvjme/vjwfstjpo"), ""));
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("BTVT")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("BTVT"));
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("CMBDLTIBSL")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("CMBDLTIBSL"));
    }

    public static boolean isCoolpad(Context context) {
        int i = alreadyQueried;
        if (i > 0) {
            Log.d(dexg.dexa("je"), dexg.dexa("br"));
            return isCoolpad;
        }
        try {
            alreadyQueried = i + 1;
            context.getPackageManager().getPackageInfo(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu"), 0);
            isCoolpad = true;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isCoosea() {
        return sysProperty(dexg.dexa("sp/pen/nbovgbduvsfs"), "").equalsIgnoreCase(dexg.dexa("QSJ[F"));
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/cvjme/wfstjpo/fnvj"), ""));
    }

    public static boolean isFreeme() {
        return !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/cvjme/gsffnf/mbcfm"), ""));
    }

    public static boolean isHonor() {
        return Build.BRAND.equalsIgnoreCase(dexg.dexa("IPOPS"));
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("IVBXFJ"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexg.dexa("IVBXFJ")) && !str.equalsIgnoreCase(dexg.dexa("IPOPS"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLenovo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("MFOPWP"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexg.dexa("MFOPWP")) && !str.equalsIgnoreCase(dexg.dexa("[VL"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("NFJ[V")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("NFJ[V")) || Build.DISPLAY.toUpperCase().contains(dexg.dexa("GMZNF"));
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/njvj/vj/wfstjpo/obnf"), ""));
    }

    public static boolean isMotolora() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("NPUPMPSB")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("NPUPMPSB"));
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("OVCJB")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("OVCJB"));
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("POFQMVT")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("POFQMVT"));
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("PQQP"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexg.dexa("PQQP")) && !str.equalsIgnoreCase(dexg.dexa("SFBMNF")) && TextUtils.isEmpty(sysProperty(dexg.dexa("sp/cvjme/wfstjpo/pqqpspn"), ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSSUI() {
        return !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/ttvj/qspevdu"), ""));
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("TBNTVOH")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("TBNTVOH"));
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("WJWP")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("WJWP")) || !TextUtils.isEmpty(sysProperty(dexg.dexa("sp/wjwp/pt/wfstjpo"), ""));
    }

    public static boolean isXiaomi() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("YJBPNJ"))) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(dexg.dexa("YJBPNJ")) && !str.equalsIgnoreCase(dexg.dexa("SFENJ"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase(dexg.dexa("[UF")) || Build.BRAND.equalsIgnoreCase(dexg.dexa("[UF"));
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(dexg.dexa("boespje/pt/TztufnQspqfsujft"));
            str3 = (String) cls.getMethod(dexg.dexa("hfu"), String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("Tztufn!qspqfsuz!jowplf!fssps;!") + th);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
