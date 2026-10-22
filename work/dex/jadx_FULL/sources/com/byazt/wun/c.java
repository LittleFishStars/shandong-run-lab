package com.byazt.wun;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.permission.b;
import com.byazt.aas.nb;
import com.byazt.hv.TTDownloadField;
import com.byazt.hy.n;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.byazt.va.ve;
import com.byazt.vif.uj;
import com.byazt.whk.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.huachenjie.shandong_school.splash.SplashActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, 20})
public class c implements tt {
    public static volatile c c;
    public static final FileFilter tt = new FileFilter() { // from class: com.byazt.wun.c.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    private void a(String str) {
        try {
            ve veVarVe = n.c().tt().ve();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "android");
            jSONObject.put("device_model", Build.MODEL);
            veVarVe.c(Uri.parse(nb.sl("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter("extra", com.byazt.nr.c.tt(jSONObject.toString())).toString());
            com.byazt.hm.tt ttVarC = veVarVe.c();
            if (ttVarC == null || !ttVarC.i()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(ttVarC.n());
            if (jSONObject2.optInt("code") != 200) {
                c("bytebench_value", "-1.0", str);
                return;
            }
            double dOptDouble = jSONObject2.optDouble("score");
            if (dOptDouble <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                c("bytebench_value", "-1.0", str);
                return;
            }
            c("bytebench_update_time", String.valueOf(System.currentTimeMillis()), str);
            c("bytebench_value", String.valueOf(dOptDouble), str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("score", dOptDouble);
            yp.c().sp(jSONObject3);
        } catch (Exception e) {
            m.c(e);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                yp.c().sp(jSONObject4);
            } catch (JSONException e2) {
                m.c(e2);
            }
        }
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private static int n(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    private int sp(String str) {
        int iTt = tt(gt.getContext());
        int iN = n();
        int i = 2;
        if (iTt != 0 && iTt != 1 && iN != 0) {
            if (iTt == 2 && iN > 0) {
                i = 1;
            } else if (iTt <= 2) {
                i = -1000;
            } else if (iN > 1) {
                i = 0;
            } else {
                i = 1;
            }
        }
        c("ram_level", String.valueOf(iTt), str);
        c("cpu_level", String.valueOf(iN), str);
        c("update_time", String.valueOf(System.currentTimeMillis()), str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", iTt);
            jSONObject.put("cpu", iN);
            jSONObject.put(b.b, i);
        } catch (JSONException e) {
            m.c(e);
        }
        yp.c().a(jSONObject);
        c(i, str);
        return i;
    }

    public static int uj() {
        try {
            int iUj = uj("/sys/devices/system/cpu/possible");
            if (iUj == -1) {
                iUj = uj("/sys/devices/system/cpu/present");
            }
            return iUj == -1 ? new File("/sys/devices/system/cpu/").listFiles(tt).length : iUj;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int ve() {
        int iIntValue = -1;
        for (int i = 0; i < uj(); i++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i2 = 0;
                        while (Character.isDigit(bArr[i2]) && i2 < 128) {
                            i2++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iC = c("cpu MHz", fileInputStream2) * 1000;
                if (iC > iIntValue) {
                    iIntValue = iC;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return iIntValue;
    }

    @Override // com.byazt.whk.tt
    public String tt() {
        return "DeviceRate";
    }

    public boolean tt(String str) {
        String strC = c("update_time", str);
        return strC.isEmpty() || System.currentTimeMillis() - Long.parseLong(strC) >= 2592000000L;
    }

    private static int n() {
        int iVe = ve() / 1000;
        if (iVe <= 1600) {
            return 0;
        }
        if (iVe <= 2000) {
            return 1;
        }
        return iVe <= 2500 ? 2 : 3;
    }

    private static int tt(Context context) {
        long jC = c(context) / 1048576;
        if (jC <= 2000) {
            return 0;
        }
        if (jC <= 3000) {
            return 1;
        }
        if (jC <= ExoPlayerImplInternal.f) {
            return 2;
        }
        return jC <= SplashActivity.f36053a ? 3 : 4;
    }

    private static int uj(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iN = n(line);
                fileInputStream.close();
                return iN;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    @TargetApi(16)
    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static int c(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                byte b = bArr[i2];
                if (b == 10 || i2 == 0) {
                    if (b == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < i; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            break;
                        }
                        if (i4 == str.length() - 1) {
                            return c(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException | NumberFormatException e) {
            m.c(e);
            return -1;
        }
    }

    private static int c(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public boolean ve(String str) {
        String strC = c("bytebench_update_time", str);
        return strC.isEmpty() || System.currentTimeMillis() - Long.parseLong(strC) >= 2592000000L;
    }

    public void c(String str) {
        if (gt.tt().ka() && tt(str)) {
            sp(str);
        }
        try {
            if (Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", str)) <= AudioStats.AUDIO_AMPLITUDE_NONE || (gt.tt().mc() && ve(str))) {
                a(str);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.whk.tt
    public String c(String str, String str2) {
        return uj.c(null, tt()).get(str, "");
    }

    @Override // com.byazt.whk.tt
    public void c(String str, String str2, String str3) {
        uj.c(null, tt()).put(str, str2);
    }

    private void c(int i, String str) {
        c("device_level", String.valueOf(i), str);
        com.byazt.by.uj.c().x(i);
    }
}
