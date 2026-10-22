package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.acse.ottn.R;
import com.acse.ottn.h2;
import com.acse.ottn.i3;
import com.acse.ottn.n1;
import com.acse.ottn.n3;
import com.acse.ottn.o1;
import com.google.common.base.a;
import com.tencent.mmkv.MMKV;
import java.io.ObjectStreamException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HelpShopAppUtil {
    private static char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static HelpShopAppUtil instance;
    private static Context mContext;

    private HelpShopAppUtil() {
    }

    private static String getAppIdFromMainfest(String str) {
        Bundle bundle;
        try {
            Context context = mContext;
            if (context == null) {
                return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getHmKey() {
        try {
            if (n3.a() == null) {
                return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
            }
            String strE = n3.a().e("APP_KEY");
            if (TextUtils.isEmpty(strE) || strE == null) {
                strE = getAppIdFromMainfest("APP_KEY");
                n3.a().b("APP_KEY", strE);
            }
            h2.a("HelpShopAppUtil", "APP_KEY =" + strE);
            return strE;
        } catch (Exception e) {
            h2.a("TAG", e.getMessage());
            return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
        }
    }

    public static HelpShopAppUtil getInstance() {
        if (instance == null) {
            synchronized (HelpShopAppUtil.class) {
                if (instance == null) {
                    instance = new HelpShopAppUtil();
                }
            }
        }
        return instance;
    }

    private static String getSessionId(String str) {
        byte[] bArrDigest = new byte[0];
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return printHexBinary(bArrDigest);
    }

    private static void getWindowInfo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (n3.a() != null) {
            n3.a().a("screenWidth", i);
            n3.a().a("screenHight", i2);
        }
    }

    public static void init(Context context) {
        mContext = context;
        MMKV.initialize(context);
        getWindowInfo();
        getHmKey();
    }

    public static void playVideo(Context context) {
        MediaPlayer mediaPlayerCreate = MediaPlayer.create(context, R.raw.lucky_money);
        mediaPlayerCreate.setVolume(0.3f, 0.3f);
        mediaPlayerCreate.start();
    }

    private static String printHexBinary(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(hexCode[(b >> 4) & 15]);
            sb.append(hexCode[b & a.q]);
        }
        return sb.toString();
    }

    public static String randomSessionExID() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("sessionID");
        if (strE != null && !"".equals(strE)) {
            return strE;
        }
        String strSubstring = i3.c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
        String strReplace = String.format("%32s", "0" + Long.toHexString(new Long(System.currentTimeMillis()).longValue()) + strSubstring).replace(' ', 'f');
        n3.a().b("sessionID", strReplace);
        return strReplace;
    }

    public static String randomSessionNewID() {
        if (n3.a() == null) {
            return "";
        }
        String strD = n1.a().d("sessionID");
        if (strD != null && !"".equals(strD)) {
            return strD;
        }
        String strSubstring = i3.c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
        String strReplace = String.format("%32s", "0" + Long.toHexString(new Long(System.currentTimeMillis()).longValue()) + strSubstring).replace(' ', 'f');
        n1.a().b("sessionID", strReplace);
        return strReplace;
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public static String sessionExID() {
        if (n3.a() == null || n1.a() == null) {
            return "";
        }
        String strD = n1.a().d("sessionID");
        if (TextUtils.isEmpty(strD)) {
            String strE = n3.a().e("sessionID");
            return TextUtils.isEmpty(strE) ? randomSessionExID() : strE;
        }
        n3.a().b("sessionID", strD);
        n1.a().b("sessionID", "");
        return strD;
    }

    public static String sessionID() {
        String strD = n1.a().d("sessionID");
        return TextUtils.isEmpty(strD) ? randomSessionNewID() : strD;
    }

    public Long createRandomNumber() {
        if (n3.a() == null) {
            return 14400L;
        }
        if (n3.a().d("random_num") == 0) {
            n3.a().a("random_num", new Random().nextInt(7200) + 10800);
        }
        return Long.valueOf(n3.a().d("random_num"));
    }

    public String getAppName() {
        return o1.c().b();
    }
}
