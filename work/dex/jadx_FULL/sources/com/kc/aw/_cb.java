package com.kc.aw;

import android.content.Context;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.common.base.a;
import com.google.common.net.c;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.PtgCustomController;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cb {
    public static long _a;
    public static ArrayList _b = new ArrayList();

    public static String _a() {
        String[] strArrSplit;
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig()._m;
        if (ptgCustomController != null && !ptgCustomController.isAllowSDKObtainPhoneInfo()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        if (PtgAdSdk.getContext() != null) {
            try {
                if (com.kc.aw.lib.utils._a._a(_a)) {
                    _b.clear();
                    String string = Settings.Secure.getString(PtgAdSdk.getContext().getContentResolver(), "enabled_accessibility_services");
                    if (!TextUtils.isEmpty(string)) {
                        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(c.b);
                        simpleStringSplitter.setString(string);
                        int i = 0;
                        while (simpleStringSplitter.hasNext() && i < 8) {
                            String next = simpleStringSplitter.next();
                            if (!TextUtils.isEmpty(next) && next.contains(WVNativeCallbackUtil.SEPERATER) && (strArrSplit = next.split(WVNativeCallbackUtil.SEPERATER)) != null && strArrSplit.length > 0) {
                                _b.add(strArrSplit[0]);
                                i++;
                            }
                        }
                    }
                    _a = System.currentTimeMillis();
                }
            } catch (Exception unused) {
            }
        }
        ArrayList arrayList = _b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
        }
        return jSONArray.toString();
    }

    public static String _a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String _a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            stringBuffer.append(cArr[(b & 240) >> 4]);
            stringBuffer.append(cArr[b & a.q]);
            if (i < length - 1) {
                stringBuffer.append(u15.f19942b);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean _a(Context context, String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            return new File("storage/emulated/0/Android/data/" + str).exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean _b(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimState();
            return (simState == 0 || simState == 1) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }
}
