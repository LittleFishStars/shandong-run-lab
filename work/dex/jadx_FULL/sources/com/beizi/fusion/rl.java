package com.beizi.fusion;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class rl {
    public static String a(String str, Map map) {
        if (map != null && !map.isEmpty()) {
            Pattern patternCompile = Pattern.compile("__[A-Z_^\\d]+__");
            Matcher matcher = patternCompile.matcher(str);
            while (matcher.find()) {
                String strGroup = matcher.group();
                if (!map.containsKey(strGroup) || TextUtils.isEmpty((CharSequence) map.get(strGroup))) {
                    str = matcher.replaceFirst(strGroup.replace(LoginConstants.UNDER_LINE, "~"));
                } else {
                    String strReplaceAll = (String) map.get(strGroup);
                    if (strReplaceAll != null && strReplaceAll.contains("\"")) {
                        strReplaceAll = strReplaceAll.replaceAll("\"", "\\\\\"");
                    }
                    String strQuoteReplacement = Matcher.quoteReplacement(strReplaceAll);
                    if (strQuoteReplacement.contains("\\\"")) {
                        strQuoteReplacement = strQuoteReplacement.replaceAll("\\\"", "\\\\\"");
                    }
                    str = matcher.replaceFirst(strQuoteReplacement);
                }
                matcher = patternCompile.matcher(str);
            }
        }
        return str.replace("~", LoginConstants.UNDER_LINE);
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }
}
