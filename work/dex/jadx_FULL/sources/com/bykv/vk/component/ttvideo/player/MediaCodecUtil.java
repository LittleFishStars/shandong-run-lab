package com.bykv.vk.component.ttvideo.player;

import android.util.Pair;
import com.byazt.nr.m;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    static {
        HashMap map = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = map;
        map.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1);
        map.put("02", 2);
        map.put("03", 4);
        map.put("04", 8);
        map.put("05", 16);
        map.put("06", 32);
        map.put("07", 64);
        map.put("08", 128);
        map.put("09", 256);
        HashMap map2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = map2;
        map2.put("00", 1);
        map2.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 2);
        map2.put("02", 4);
        map2.put("03", 8);
        map2.put("04", 16);
        map2.put("05", 32);
        map2.put("06", 64);
        map2.put("07", 128);
        map2.put("08", 256);
        map2.put("09", 512);
    }

    public static String getDolbyCodecs(int i, int i2) {
        String str;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = VisualSampleEntry.TYPE4;
        }
        return str + ".0" + i + ".0" + i2;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            m.tt("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            m.tt("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String strGroup = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(strGroup);
        if (num == null) {
            m.tt("MediaCodecUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(strGroup)));
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        m.tt("MediaCodecUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str2)));
        return null;
    }
}
