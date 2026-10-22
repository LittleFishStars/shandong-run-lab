package com.aliyun.subtitle;

import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LocationStyle {
    public static final int Location_Bottom = 8;
    public static final int Location_Center = 64;
    public static final int Location_CenterH = 16;
    public static final int Location_CenterV = 32;
    public static final int Location_Left = 1;
    public static final int Location_Right = 4;
    public static final int Location_Top = 2;

    public static void setLocation(RelativeLayout.LayoutParams layoutParams, Map<String, Object> map, int i) {
        if (map != null && map.containsKey(SubtitleView.EXTRA_LOCATION__INT)) {
            i = ((Integer) map.get(SubtitleView.EXTRA_LOCATION__INT)).intValue();
        }
        if ((i & 8) == 8) {
            layoutParams.addRule(12);
        }
        if ((i & 1) == 1) {
            layoutParams.addRule(9);
        }
        if ((i & 2) == 2) {
            layoutParams.addRule(10);
        }
        if ((i & 4) == 4) {
            layoutParams.addRule(11);
        }
        if ((i & 16) == 16) {
            layoutParams.addRule(14);
        }
        if ((i & 32) == 32) {
            layoutParams.addRule(15);
        }
        if ((i & 64) == 64) {
            layoutParams.addRule(13);
        }
    }
}
