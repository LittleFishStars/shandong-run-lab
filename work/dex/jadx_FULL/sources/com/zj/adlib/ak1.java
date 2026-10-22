package com.zj.adlib;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ak1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long[] f15280a = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f15281a = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
    public static final String[] b = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    public static final String[] c = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    public static final String[] d = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f40543a = new SimpleDateFormat("yyyy年M月d日 EEEEE");

    public static final String a(int i) {
        return d[(i - 4) % 12];
    }

    public static final long[] b(int i, int i2, int i3) {
        char c2;
        long j;
        long[] jArr = new long[7];
        int i4 = 1900;
        long time = (new GregorianCalendar(i, i2 - 1, i3).getTime().getTime() - new GregorianCalendar(1900, 0, 31).getTime().getTime()) / 86400000;
        jArr[5] = 40 + time;
        jArr[4] = 14;
        int iN = 0;
        while (i4 < 2100 && time > 0) {
            iN = k(i4);
            time -= (long) iN;
            jArr[4] = jArr[4] + 12;
            i4++;
        }
        if (time < 0) {
            time += (long) iN;
            i4--;
            jArr[4] = jArr[4] - 12;
        }
        jArr[0] = i4;
        jArr[3] = i4 - 1864;
        int iM = m(i4);
        jArr[6] = 0;
        int i5 = 1;
        while (i5 < 13 && time > 0) {
            if (iM > 0 && i5 == iM + 1 && jArr[6] == 0) {
                jArr[6] = 1;
                iN = l((int) jArr[0]);
                i5--;
            } else {
                iN = n((int) jArr[0], i5);
            }
            if (jArr[6] == 1 && i5 == iM + 1) {
                jArr[6] = 0;
            }
            time -= (long) iN;
            if (jArr[6] == 0) {
                jArr[4] = jArr[4] + 1;
            }
            i5++;
        }
        long j2 = time;
        if (j2 != 0 || iM <= 0 || i5 != iM + 1) {
            c2 = 4;
        } else if (jArr[6] == 1) {
            jArr[6] = 0;
            c2 = 4;
        } else {
            jArr[6] = 1;
            i5--;
            c2 = 4;
            jArr[4] = jArr[4] - 1;
        }
        if (j2 < 0) {
            j = j2 + ((long) iN);
            i5--;
            jArr[c2] = jArr[c2] - 1;
        } else {
            j = j2;
        }
        jArr[1] = i5;
        jArr[2] = j + 1;
        return jArr;
    }

    public static final String c(int i) {
        return d((i - 1900) + 36);
    }

    public static final String d(int i) {
        return b[i % 10] + c[i % 12];
    }

    public static final String e(int i) {
        if (i == 10) {
            return "初十";
        }
        if (i == 20) {
            return "二十";
        }
        if (i == 30) {
            return "三十";
        }
        int i2 = i / 10;
        String str = i2 == 0 ? "初" : "";
        if (i2 == 1) {
            str = "十";
        }
        if (i2 == 2) {
            str = "廿";
        }
        if (i2 == 3) {
            str = "三";
        }
        switch (i % 10) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "六";
            case 7:
                return str + "七";
            case 8:
                return str + "八";
            case 9:
                return str + "九";
            default:
                return str;
        }
    }

    public static String f() {
        Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        int i = calendar.get(1);
        long[] jArrB = b(i, calendar.get(2) + 1, calendar.get(5));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f40543a.format(calendar.getTime()));
        stringBuffer.append(" 农历");
        stringBuffer.append(c(i));
        stringBuffer.append('(');
        stringBuffer.append(a(i));
        stringBuffer.append(")年");
        stringBuffer.append(f15281a[(int) jArrB[1]]);
        stringBuffer.append("月");
        stringBuffer.append(e((int) jArrB[2]));
        return stringBuffer.toString();
    }

    public static ArrayList<String> g(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 <= i; i2++) {
            arrayList.add(e(i2));
        }
        return arrayList;
    }

    public static String h(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i - 4;
        sb.append(b[i2 % 10]);
        sb.append(c[i2 % 12]);
        sb.append("年");
        return sb.toString();
    }

    public static ArrayList<String> i(int i) {
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 1;
        while (true) {
            strArr = f15281a;
            if (i2 >= strArr.length) {
                break;
            }
            arrayList.add(strArr[i2] + "月");
            i2++;
        }
        if (m(i) != 0) {
            arrayList.add(m(i), "闰" + strArr[m(i)] + "月");
        }
        return arrayList;
    }

    public static ArrayList<String> j(int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (i < i2) {
            arrayList.add(String.format("%s(%d)", h(i), Integer.valueOf(i)));
            i++;
        }
        return arrayList;
    }

    public static final int k(int i) {
        int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((f15280a[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + l(i);
    }

    public static final int l(int i) {
        if (m(i) != 0) {
            return (f15280a[i + (-1900)] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0 ? 30 : 29;
        }
        return 0;
    }

    public static final int m(int i) {
        return (int) (f15280a[i - 1900] & 15);
    }

    public static final int n(int i, int i2) {
        return (((long) (65536 >> i2)) & f15280a[i + (-1900)]) == 0 ? 29 : 30;
    }

    public static String o(int i, int i2, int i3) {
        long[] jArrB = b(i, i2, i3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 农历");
        stringBuffer.append(c(i));
        stringBuffer.append('(');
        stringBuffer.append(a(i));
        stringBuffer.append(")年");
        stringBuffer.append(f15281a[(int) jArrB[1]]);
        stringBuffer.append("月");
        stringBuffer.append(e((int) jArrB[2]));
        return stringBuffer.toString();
    }
}
