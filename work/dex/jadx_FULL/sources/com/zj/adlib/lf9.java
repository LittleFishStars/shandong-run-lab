package com.zj.adlib;

import com.google.zxing.client.result.ResultParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class lf9 extends ResultParser {
    public static final Pattern d = Pattern.compile("[-._~:/?#\\[\\]@!$&'()*+,;=%A-Za-z0-9]+");
    public static final Pattern e = Pattern.compile(":/*([^/@]+)@[^/]+");
    public static final Pattern f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    public static final Pattern g = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean i(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    public static boolean j(String str) {
        return !d.matcher(str).matches() || e.matcher(str).find();
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public kf9 e(ug7 ug7Var) {
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new kf9(massagedText.substring(4).trim(), null);
        }
        String strTrim = massagedText.trim();
        if (!i(strTrim) || j(strTrim)) {
            return null;
        }
        return new kf9(strTrim, null);
    }
}
