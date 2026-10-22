package com.beizi.fusion;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f27305a;
    private String b;
    private String c;
    private boolean d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final fp f27306a = new fp();
    }

    public static fp a() {
        return a.f27306a;
    }

    private boolean d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return !Pattern.compile("^[A-Fa-f0-9]{2}$").matcher(str).matches();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean b() {
        return this.f27305a == i.UI_MODEL_DARK;
    }

    public boolean c(String str) {
        try {
            return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$").matcher(str).matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private int b(String str) {
        return Integer.parseInt(str, 16);
    }

    public void a(Context context, i iVar, String str, String str2) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f27305a = iVar;
        this.b = str;
        this.c = str2;
        if (TextUtils.isEmpty(str)) {
            this.b = "#FFFFFF";
        }
        if (TextUtils.isEmpty(str2)) {
            this.c = "#000000";
        }
        boolean zA = a(context);
        if (iVar == i.UI_MODEL_AUTO && zA) {
            this.f27305a = i.UI_MODEL_DARK;
        }
    }

    private boolean a(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            return configuration != null && (configuration.uiMode & 48) == 32;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public String a(String str) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        String strReplace;
        try {
            if (this.f27305a == i.UI_MODEL_LIGHT) {
                return c(str) ? str : this.b;
            }
            String strReplace2 = str.replace("#", "");
            int length = strReplace2.length();
            String str2 = "FF";
            if (length == 6) {
                strSubstring = strReplace2.substring(0, 2);
                strSubstring2 = strReplace2.substring(2, 4);
                strSubstring3 = strReplace2.substring(4, 6);
            } else if (length != 8) {
                strSubstring3 = this.f27305a == i.UI_MODEL_DARK ? "00" : "FF";
                strSubstring = strSubstring3;
                strSubstring2 = strSubstring;
            } else {
                String strSubstring4 = strReplace2.substring(0, 2);
                if (!d(strSubstring4)) {
                    str2 = strSubstring4;
                }
                strSubstring = strReplace2.substring(2, 4);
                strSubstring2 = strReplace2.substring(4, 6);
                strSubstring3 = strReplace2.substring(6, 8);
            }
            if (!d(strSubstring) && !d(strSubstring2) && !d(strSubstring3)) {
                int iB = b(strSubstring);
                int iB2 = b(strSubstring2);
                int iB3 = b(strSubstring3);
                if (iB != iB2 || iB2 != iB3 || this.f27305a != i.UI_MODEL_DARK) {
                    return str;
                }
                String upperCase = a(255 - iB).toUpperCase();
                return "#" + str2 + "" + upperCase + "" + upperCase + "" + upperCase;
            }
            if (this.f27305a == i.UI_MODEL_DARK) {
                strReplace = this.c.replace("#", "");
            } else {
                strReplace = this.b.replace("#", "");
            }
            return "#" + str2 + "" + strReplace.toUpperCase();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private String a(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() != 1) {
            return hexString;
        }
        return "0" + hexString;
    }
}
