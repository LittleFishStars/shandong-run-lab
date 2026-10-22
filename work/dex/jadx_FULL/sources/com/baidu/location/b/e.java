package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Base64;
import com.baidu.location.BDLocation;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f26347a = null;
    private boolean b = false;
    private Deque<String> c = new LinkedList();
    private Deque<String> d = new LinkedList();
    private Deque<String> e = new LinkedList();
    private int f = 5;
    private int g = 5;
    private int h = 1;
    private int i = 1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f26348a = new e();
    }

    public static e a() {
        return a.f26348a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    private String a(int i, int i2) {
        String str;
        if (i == 1) {
            String strC = c(this.e);
            if ("".equals(strC)) {
                str = "";
            } else {
                str = "&ll_pre=" + strC;
            }
        } else {
            str = "";
        }
        if (i2 != 1) {
            return str;
        }
        String strB = b(this.c);
        if (!"".equals(strB)) {
            str = str + "&cl_pre=" + strB;
        }
        String strB2 = b(this.d);
        if ("".equals(strB2)) {
            return str;
        }
        return str + "&wf_pre=" + strB2;
    }

    private void a(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    private void a(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.g) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor editorEdit = this.f26347a.edit();
            editorEdit.putString("ll_pre", str);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    private void a(Deque<String> deque, String str) {
        if (deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = deque.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor editorEdit = this.f26347a.edit();
            editorEdit.putString(str + "_pre", str2);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }

    private String b(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String strPeekFirst = deque.peekFirst();
        if (strPeekFirst != null) {
            try {
                String[] strArrSplit = strPeekFirst.split(",");
                int i = 0;
                for (String str : deque) {
                    if (strArrSplit.length != 3) {
                        break;
                    }
                    String[] strArrSplit2 = str.split(",");
                    if (i == 0) {
                        sb.append(strPeekFirst);
                    } else {
                        if (strArrSplit2.length == 3) {
                            try {
                                sb.append((int) ((Double.parseDouble(strArrSplit[0]) - Double.parseDouble(strArrSplit2[0])) * Math.pow(10.0d, 6.0d)));
                                sb.append(",");
                                sb.append((int) ((Double.parseDouble(strArrSplit[1]) - Double.parseDouble(strArrSplit2[1])) * Math.pow(10.0d, 6.0d)));
                                sb.append(",");
                                sb.append(Long.parseLong(strArrSplit[2]) - Long.parseLong(strArrSplit2[2]));
                            } catch (Exception unused) {
                            }
                        }
                        i++;
                    }
                    if (i != deque.size() - 1) {
                        sb.append("|");
                    }
                    i++;
                }
            } catch (Exception unused2) {
            }
        }
        return sb.toString();
    }

    private void b(String str, Deque<String> deque) {
        if (str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0105 A[Catch: Exception -> 0x010f, TRY_LEAVE, TryCatch #1 {Exception -> 0x010f, blocks: (B:9:0x0019, B:10:0x0023, B:12:0x0029, B:15:0x0035, B:17:0x003c, B:25:0x00fd, B:27:0x0105, B:19:0x0042), top: B:38:0x0019 }] */
    private String c(Deque<String> deque) {
        int i;
        int i2;
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String strPeekFirst = deque.peekFirst();
        if (strPeekFirst != null) {
            try {
                String[] strArrSplit = strPeekFirst.split(",");
                char c = 0;
                int i3 = 0;
                for (String str : deque) {
                    if (strArrSplit.length != 7) {
                        break;
                    }
                    String[] strArrSplit2 = str.split(",");
                    if (i3 == 0) {
                        sb.append(strPeekFirst);
                    } else if (strArrSplit2.length != 7) {
                        i3++;
                    } else {
                        try {
                            sb.append(Integer.parseInt(strArrSplit[c]) - Integer.parseInt(strArrSplit2[c]));
                            sb.append(",");
                            sb.append(Integer.parseInt(strArrSplit[1]) - Integer.parseInt(strArrSplit2[1]));
                            sb.append(",");
                            sb.append(new BigDecimal(strArrSplit[2]).subtract(new BigDecimal(strArrSplit2[2])));
                            sb.append(",");
                            sb.append(Long.parseLong(strArrSplit[3]) - Long.parseLong(strArrSplit2[3]));
                            sb.append(",");
                            sb.append(new BigDecimal(strArrSplit[4]).subtract(new BigDecimal(strArrSplit2[4])));
                            sb.append(",");
                            double dDoubleValue = new BigDecimal(strArrSplit[5]).subtract(new BigDecimal(strArrSplit2[5])).doubleValue();
                            double dDoubleValue2 = new BigDecimal(strArrSplit[6]).subtract(new BigDecimal(strArrSplit2[6])).doubleValue();
                            i = i3;
                            try {
                                sb.append((int) (dDoubleValue * Math.pow(10.0d, 6.0d)));
                                sb.append(",");
                                sb.append((int) (dDoubleValue2 * Math.pow(10.0d, 6.0d)));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            i = i3;
                        }
                        i2 = i;
                        if (i2 != deque.size() - 1) {
                            sb.append("|");
                        }
                        i3 = i2 + 1;
                        c = 0;
                    }
                    i = i3;
                    i2 = i;
                    if (i2 != deque.size() - 1) {
                        sb.append("|");
                    }
                    i3 = i2 + 1;
                    c = 0;
                }
            } catch (Exception unused3) {
            }
        }
        return sb.toString();
    }

    public void a(Context context) {
        if (this.f26347a == null) {
            this.f26347a = s.a().b(context);
        }
        SharedPreferences sharedPreferences = this.f26347a;
        if (sharedPreferences == null || this.b) {
            return;
        }
        try {
            String string = sharedPreferences.getString("cl_pre", "");
            String string2 = this.f26347a.getString("wf_pre", "");
            String string3 = this.f26347a.getString("ll_pre", "");
            a(string, this.c);
            a(string2, this.d);
            b(string3, this.e);
        } catch (Exception unused) {
        }
        this.b = true;
    }

    public synchronized void a(BDLocation bDLocation, String str, Location location) {
        Deque<String> deque;
        String str2;
        if (bDLocation != null) {
            if ("gcj02".equals(str)) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                int locType = bDLocation.getLocType();
                if (locType == 61 || locType == 161) {
                    if (networkLocationType == null) {
                        networkLocationType = "null";
                    }
                    try {
                        if (!networkLocationType.contains("wf") || this.h != 1) {
                            if (networkLocationType.contains("cl") && this.h == 1) {
                                this.c.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.h.c(bDLocation.getTime()));
                                deque = this.c;
                                str2 = "cl";
                            } else if (locType == 61 && this.i == 1 && location != null) {
                                int radius = (int) bDLocation.getRadius();
                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
                                DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
                                this.e.offerFirst(bDLocation.getSatelliteNumber() + "," + radius + "," + decimalFormat.format(bDLocation.getAltitude()) + "," + com.baidu.location.e.h.c(bDLocation.getTime()) + "," + decimalFormat2.format(bDLocation.getSpeed()) + "," + decimalFormat3.format(location.getLongitude()) + "," + decimalFormat3.format(location.getLatitude()));
                                a(this.e);
                            }
                        }
                        this.d.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.h.c(bDLocation.getTime()));
                        deque = this.d;
                        str2 = "wf";
                        a(deque, str2);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public String b() {
        return a(this.i, this.h);
    }

    public synchronized String c() {
        return a(this.i, this.h);
    }
}
