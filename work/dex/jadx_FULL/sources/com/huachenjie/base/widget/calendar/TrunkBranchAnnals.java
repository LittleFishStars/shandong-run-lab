package com.huachenjie.base.widget.calendar;

import android.content.Context;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class TrunkBranchAnnals {
    private static String[] BRANCH_STR;
    private static String[] TRUNK_STR;

    public static int getBranchInt(int year) {
        int i = year % 12;
        if (i == 0) {
            return 11;
        }
        return i - 1;
    }

    public static String getBranchString(int year) {
        return BRANCH_STR[getBranchInt(year)];
    }

    public static String getTrunkBranchYear(int year) {
        return String.format("%s%s", getTrunkString(year), getBranchString(year));
    }

    public static int getTrunkInt(int year) {
        int i = year % 10;
        if (i == 0) {
            return 9;
        }
        return i - 1;
    }

    public static String getTrunkString(int year) {
        return TRUNK_STR[getTrunkInt(year)];
    }

    public static void init(Context context) {
        if (TRUNK_STR != null) {
            return;
        }
        TRUNK_STR = context.getResources().getStringArray(R.array.trunk_string_array);
        BRANCH_STR = context.getResources().getStringArray(R.array.branch_string_array);
    }
}
