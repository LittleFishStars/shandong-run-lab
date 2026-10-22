package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double[] f26392a = {1999.0d, 8.0d, 22.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
    private HashMap<String, c> b = new HashMap<>();
    private HashMap<String, String> c = new HashMap<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static t f26393a = new t();
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26394a = 0;
        double b = AudioStats.AUDIO_AMPLITUDE_NONE;

        public b() {
        }
    }

    public class c {
        private boolean b;
        private boolean c;
        private long d;
        private int e;
        private int f;
        private ArrayList<String> g;
        private ArrayList<Integer> h;
        private int i;
        private double j;
        private double k;
        private double l;
        private int m;
        private int n;
        private b o;

        public c(int i, int i2) {
            a(i, i2);
            this.i = 0;
            this.j = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.k = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.l = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.m = 0;
            this.n = 0;
            this.o = t.this.new b();
        }

        private b a(int i, double d) {
            b bVarA = a(t.f26392a);
            if (d < -1.0E9d || 1.0E9d < d) {
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            int i2 = (int) d;
            bVarA.f26394a += (i * 604800) + i2;
            bVarA.b = d - ((double) i2);
            return bVarA;
        }

        private b a(double[] dArr) {
            int[] iArr = {1, 32, 60, 91, 121, 152, 182, 213, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 274, 305, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS};
            b bVar = t.this.new b();
            int i = 0;
            int i2 = (int) dArr[0];
            int i3 = (int) dArr[1];
            int i4 = (int) dArr[2];
            if (i2 >= 1970 && 2099 >= i2 && i3 >= 1 && 12 >= i3) {
                int i5 = (((((i2 - 1970) * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME) + ((i2 - 1969) / 4)) + iArr[i3 - 1]) + i4) - 2;
                if (i2 % 4 == 0 && i3 >= 3) {
                    i = 1;
                }
                int iFloor = (int) Math.floor(dArr[5]);
                bVar.f26394a = ((i5 + i) * 86400) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + iFloor;
                bVar.b = dArr[5] - ((double) iFloor);
            }
            return bVar;
        }

        @TargetApi(24)
        private String a(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            for (byte b : gnssNavigationMessage.getData()) {
                sb.append(String.format("%8s", Integer.toBinaryString(b & 255)).replace(' ', '0'));
            }
            return sb.toString();
        }

        private void a() {
            boolean z;
            if (this.g.size() == 0) {
                z = false;
                break;
            }
            int i = 0;
            while (true) {
                if (i >= this.g.size()) {
                    z = true;
                    break;
                } else {
                    if (this.g.get(i).contains("None")) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                this.c = true;
            } else {
                this.c = false;
            }
        }

        private void a(int i, int i2) {
            int i3 = this.f;
            int i4 = 5;
            if (i3 != 257 && i3 != 769) {
                if (i3 == 1537) {
                    i4 = 6;
                } else if (i3 != 1281) {
                    i4 = i3 != 1282 ? 0 : 10;
                } else {
                    i4 = 3;
                }
            }
            ArrayList<String> arrayList = this.g;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.g = new ArrayList<>();
            }
            ArrayList<Integer> arrayList2 = this.h;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.h = new ArrayList<>();
            }
            for (int i5 = 0; i5 < i4; i5++) {
                this.g.add("None");
            }
            this.e = i;
            this.f = i2;
            this.b = false;
            this.c = false;
            this.d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(24)
        public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
            int type = gnssNavigationMessage.getType();
            int svid = gnssNavigationMessage.getSvid();
            int submessageId = gnssNavigationMessage.getSubmessageId();
            byte[] data = gnssNavigationMessage.getData();
            if (j - this.d > 1200 || this.b || this.g.size() == 0 || type != this.f || svid != this.e) {
                a(svid, type);
            }
            if ((type == 1282 || type == 1281) && !b()) {
                a(svid, type);
            }
            if (this.g.size() == 0) {
                return;
            }
            int i = this.f;
            boolean z = true;
            int i2 = i == 1537 ? 0 : 1;
            if (i == 1282) {
                if (submessageId != 1) {
                    return;
                }
                e(b(gnssNavigationMessage));
                submessageId = this.m;
            }
            int i3 = submessageId - i2;
            if (i3 >= this.g.size()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append((int) b);
            }
            this.g.set(i3, sb.toString());
            if (type == 1281 || type == 1282) {
                this.h.add(Integer.valueOf(i3));
            }
            if (this.f == 1537) {
                a(a(gnssNavigationMessage));
            }
            a();
            this.d = j;
        }

        private void a(String str) {
            StringBuilder sb;
            int i;
            char cCharAt = str.charAt(0);
            char cCharAt2 = str.charAt(120);
            if (cCharAt == '1' && cCharAt2 == '0') {
                sb = new StringBuilder();
                sb.append(str.substring(2, 18));
                i = 234;
            } else {
                if (cCharAt != '0' || cCharAt2 != '1') {
                    return;
                }
                sb = new StringBuilder();
                sb.append(str.substring(2, 114));
                i = 138;
            }
            sb.append(str.substring(122, i));
            String string = sb.toString();
            int i2 = Integer.parseInt(string.substring(0, 6), 2);
            if (i2 == 0) {
                b(string);
            } else if (i2 == 1) {
                c(string);
            } else if (i2 == 4) {
                d(string);
            }
        }

        @TargetApi(24)
        private String b(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            byte[] data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i = 0; i < length; i++) {
                String strReplace = String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(' ', '0');
                if (i % 4 == 0) {
                    strReplace = strReplace.substring(2, 8);
                }
                sb.append(strReplace);
            }
            return sb.toString();
        }

        private void b(String str) {
            this.i = Integer.parseInt(str.substring(96, 108), 2);
            this.j = Long.parseLong(str.substring(108, 128), 2);
        }

        private boolean b() {
            if (this.h == null) {
                return false;
            }
            for (int i = 0; i < this.h.size(); i++) {
                if (this.h.get(i).intValue() != i) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            StringBuilder sb = new StringBuilder();
            if (!this.c) {
                return sb.toString();
            }
            if (this.f == 1537) {
                d();
            }
            sb.append(this.o.f26394a);
            sb.append('|');
            boolean z = true;
            for (int i = 0; i < this.g.size(); i++) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(this.g.get(i));
            }
            this.b = true;
            return sb.toString();
        }

        private void c(String str) {
            this.k = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        private void d() {
            int i;
            b bVarA = a(this.i, this.j);
            b bVarA2 = a(this.i, this.k);
            double d = (((double) (bVarA2.f26394a - bVarA.f26394a)) + bVarA2.b) - bVarA.b;
            if (d <= 302400.0d) {
                if (d < -302400.0d) {
                    i = this.i + 1;
                }
                this.o = a(this.i, this.l);
                this.n = this.i + 1024;
            }
            i = this.i - 1;
            this.i = i;
            this.o = a(this.i, this.l);
            this.n = this.i + 1024;
        }

        private void d(String str) {
            this.l = Long.parseLong(str.substring(54, 68), 2) * 60;
        }

        private void e(String str) {
            this.m = Integer.parseInt(str.substring(42, 46), 2);
        }
    }

    public static t a() {
        return a.f26393a;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        String str;
        HashMap<String, c> map;
        int svid = gnssNavigationMessage.getSvid();
        int type = gnssNavigationMessage.getType();
        if (type == 257) {
            str = "G";
        } else if (type == 769) {
            str = "R";
        } else if (type == 1537) {
            str = "E";
        } else if (type != 1281) {
            str = type != 1282 ? "none" : AssistPushConsts.MSG_KEY_CONTENT;
        } else {
            str = "CO";
        }
        String str2 = str + svid;
        if (str2.contains("none") || (map = this.b) == null) {
            return;
        }
        if (!map.containsKey(str2)) {
            this.b.put(str2, new c(svid, type));
        }
        this.b.get(str2).a(gnssNavigationMessage, j);
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, c> entry : this.b.entrySet()) {
            String key = entry.getKey();
            String strC = entry.getValue().c();
            if (strC != null && strC.length() != 0) {
                if (this.c.containsKey(key)) {
                    if (strC.substring(0, 100).equals(this.c.get(key).substring(0, 100))) {
                    }
                } else {
                    this.c.put(key, strC);
                }
                arrayList.add(key + '|' + strC);
            }
        }
        return arrayList;
    }
}
