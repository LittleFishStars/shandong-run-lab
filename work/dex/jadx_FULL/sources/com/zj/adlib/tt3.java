package com.zj.adlib;

import androidx.camera.video.AudioStats;
import com.google.zxing.client.result.ResultParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class tt3 extends ResultParser {
    public static final Pattern d = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public st3 e(ug7 ug7Var) {
        Matcher matcher = d.matcher(ResultParser.getMassagedText(ug7Var));
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        try {
            double d2 = Double.parseDouble(matcher.group(1));
            if (d2 <= 90.0d && d2 >= -90.0d) {
                double d3 = Double.parseDouble(matcher.group(2));
                if (d3 <= 180.0d && d3 >= -180.0d) {
                    String strGroup2 = matcher.group(3);
                    double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
                    if (strGroup2 != null) {
                        double d5 = Double.parseDouble(matcher.group(3));
                        if (d5 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                            return null;
                        }
                        d4 = d5;
                    }
                    return new st3(d2, d3, d4, strGroup);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
