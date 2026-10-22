package com.kc.aw.lib.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.kc.aw._jf;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.b85;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TextUtil {
    private static final String CHINESE_PATTERN = "[^\\u4e00-\\u9fa5]";
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static String appendStrings(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString().trim();
    }

    public static String base64Encode(String str) {
        return isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 8);
    }

    public static String formatNumber(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            long j = Long.parseLong(str);
            if (j < 10000) {
                return str;
            }
            return j == 10000 ? "1万" : String.format("%s万", Float.valueOf(Math.round((j / 10000.0f) * 10.0f) / 10.0f));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public static Spanned fromHtml(String str) {
        try {
            return Html.fromHtml(str);
        } catch (Throwable unused) {
            return new SpannableString("");
        }
    }

    public static boolean generateJudgment(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    private static String getHexString(String str) {
        String str2 = "";
        for (int length = str.length(); length < 4; length++) {
            str2 = length == str.length() ? "0" : str2 + "0";
        }
        return str2 + str;
    }

    public static String getString(String str, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            str = str.replace("#p" + i + "#", String.valueOf(objArr[i]));
        }
        return str;
    }

    public static String hexToUnicode(String str) {
        String string = null;
        String string2 = null;
        for (int i = 0; i < str.length(); i++) {
            if (string2 == null) {
                string2 = String.valueOf(str.charAt(i));
            } else {
                StringBuilder sb_a = _jf._a(string2);
                sb_a.append(str.charAt(i));
                string2 = sb_a.toString();
            }
            if (i % 4 == 3) {
                if (string2 != null) {
                    if (string == null) {
                        string = String.valueOf((char) Integer.valueOf(string2, 16).intValue());
                    } else {
                        StringBuilder sb_a2 = _jf._a(string);
                        sb_a2.append(String.valueOf((char) Integer.valueOf(string2, 16).intValue()));
                        string = sb_a2.toString();
                    }
                }
                string2 = null;
            }
        }
        return string;
    }

    public static boolean isBigThanZero(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            return Double.valueOf(str).doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isChinese(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.compile(CHINESE_PATTERN).matcher(str).matches();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() <= 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    public static boolean isEmpty(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMobile(String str) {
        return !isEmpty(str) && str.trim().startsWith("1") && str.trim().length() == 11;
    }

    public static boolean isNickNameSpecialChar(String str) {
        return Pattern.compile("[;/?:@&=+$,]").matcher(str).find();
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && collection.size() > 0;
    }

    public static boolean isNotEmpty(Map map) {
        return map != null && map.size() > 0;
    }

    public static boolean isNotEmpty(Object[] objArr) {
        return objArr != null && objArr.length > 0;
    }

    public static boolean isNumer(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.compile(NUMBER_PATTERN).matcher(str).matches();
    }

    public static boolean isSpecialChar(String str) {
        return Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t").matcher(str).find();
    }

    public static SpannableString lightText(String str, String str2, int i) {
        SpannableString spannableString = new SpannableString(str);
        if (isEmpty(str2)) {
            return spannableString;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < str2.length(); i2++) {
            arrayList.add(Character.valueOf(str2.charAt(i2)));
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (arrayList.contains(Character.valueOf(str.charAt(i3)))) {
                spannableString.setSpan(new ForegroundColorSpan(i), i3, i3 + 1, 17);
            }
        }
        return spannableString;
    }

    public static Spanned lightText(String str, String str2, String str3) {
        String string;
        if (!isEmpty(str)) {
            if (!isEmpty(str2) && str.contains(str2)) {
                int iIndexOf = str.indexOf(str2);
                int length = str2.length();
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, iIndexOf));
                sb.append("<font color=");
                sb.append(str3);
                sb.append(">");
                int i = length + iIndexOf;
                sb.append(str.substring(iIndexOf, i));
                sb.append("</font>");
                sb.append(str.substring(i));
                string = sb.toString();
            }
            return Html.fromHtml(str);
        }
        string = "";
        return Html.fromHtml(string);
    }

    public static <T> T replaceNullObject(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static String replaceNullString(String str) {
        return replaceNullString(str, "");
    }

    public static String replaceNullString(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static void setTextBold(TextView textView, boolean z) {
        if (z) {
            setTextStyleBold(textView);
        } else {
            setTextStyleNormal(textView);
        }
    }

    public static void setTextLine(TextView textView) {
        if (textView == null || textView.getPaint() == null) {
            return;
        }
        textView.getPaint().setFlags(17);
    }

    public static void setTextStyleBold(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public static void setTextStyleNormal(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public static void setTextToClipboard(Context context, CharSequence charSequence) {
        if (context == null || isEmpty(charSequence)) {
            return;
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", charSequence));
    }

    public static String trimString(String str) {
        if (isEmpty(str)) {
            return "";
        }
        boolean zIsChinese = isChinese(str);
        String strReplace = str.trim().replace("\n", "");
        return zIsChinese ? strReplace.replace("\u3000", "").replace(" ", "").replaceAll("\\<.*?>", "") : strReplace.replaceAll("\\<.*?>", "");
    }

    public static String trimStringTwo(String str) {
        return isEmpty(str) ? "" : str.trim().replace("\r\n", "").replace("\n", "").replace(b85.b, "").replace("\t", "").replace("\u3000", "").replaceAll("\\<.*?>", "");
    }

    public static String unicodeToHe(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String string = null;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                string = getHexString(Integer.toHexString(str.charAt(i)).toUpperCase());
            } else {
                StringBuilder sb_a = _jf._a(string);
                sb_a.append(getHexString(Integer.toHexString(str.charAt(i)).toUpperCase()));
                string = sb_a.toString();
            }
        }
        return string;
    }

    public String format(String str) {
        int iLastIndexOf;
        String string = Html.fromHtml(str).toString();
        if (string == null || (iLastIndexOf = string.lastIndexOf("\n\n")) == -1) {
            return string;
        }
        return string.substring(0, iLastIndexOf) + string.substring(iLastIndexOf + 1);
    }
}
