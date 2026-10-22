package com.byazt.aas;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY})
public class qp {
    public static String c;

    /* JADX WARN: Code duplicated, block: B:45:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String c(String str) {
        BufferedReader bufferedReader;
        Exception e;
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            File file = new File("data/data/com.union_test.toutiao" + WVNativeCallbackUtil.SEPERATER + str);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (Exception e2) {
                            e = e2;
                            com.byazt.nr.m.c(e);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable unused4) {
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused5) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
                return string;
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        com.byazt.nr.m.c(e);
        if (fileReader != null) {
            fileReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }

    public static String tt(String str) {
        try {
            if (!c()) {
                return str;
            }
            String strL = com.byazt.omf.x.m().l();
            return TextUtils.isEmpty(strL) ? str : Uri.parse(str).buildUpon().appendQueryParameter(tt(), strL).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strVe = com.byazt.fh.c.ve();
            if (!TextUtils.isEmpty(strVe)) {
                strVe = strVe.replaceAll("\\.", "");
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("sdkVersion", strVe).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String tt() {
        if (TextUtils.isEmpty(c)) {
            c = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return c;
    }

    public static boolean c() {
        if (com.byazt.nr.m.ve()) {
            return com.byazt.omf.x.m().hd();
        }
        return false;
    }

    public static String c(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static void c(Map<String, String> map) {
        if (c()) {
            map.put("x-app-id", "5001121");
            String strL = com.byazt.omf.x.m().l();
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            map.put("x-device-id", strL);
        }
    }
}
