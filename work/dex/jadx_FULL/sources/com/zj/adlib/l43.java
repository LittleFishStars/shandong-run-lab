package com.zj.adlib;

import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huachenjie.common.R;
import com.huachenjie.common.constants.Environment;
import com.imuxuan.floatingview.FloatingMagnetView;
import com.imuxuan.floatingview.a;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class l43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f42992a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f17872a = "baff872373d605e61dab331a5cdddd08";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<Integer, String> f17873a = k43.a(new Map.Entry[]{new AbstractMap.SimpleEntry(1, "Dev"), new AbstractMap.SimpleEntry(4, "Test"), new AbstractMap.SimpleEntry(7, "Pre"), new AbstractMap.SimpleEntry(9, "Pro"), new AbstractMap.SimpleEntry(10, TypedValues.Custom.NAME), new AbstractMap.SimpleEntry(11, "Sd")});
    public static final String b = "3ab365742e1512d75b2313294a162f0f";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int env) {
        String strA;
        String str;
        String str2 = "https://dev-afs-xs.huachenjie.com";
        String str3 = "wss://ws.huachenjie.cn/websocket";
        String str4 = "ws://120.55.182.189:9155/websocket";
        String str5 = "https://dev.huachenjie.com/shandong-game-web/3.0";
        String str6 = "https://dev.huachenjie.com/run-mobile-web";
        String str7 = f17872a;
        if (env == 1) {
            strA = "https://dev.huachenjie.com/";
            str = "https://dev.huachenjie.com";
        } else if (env == 4) {
            strA = "https://test.huachenjie.com/";
            str = "https://test.huachenjie.com";
            str6 = "https://test.huachenjie.com/run-mobile-web";
            str5 = "https://test.huachenjie.com/shandong-game-web/3.0";
            str4 = "ws://121.196.201.96:9155/websocket";
            str3 = "wss://test.huachenjie.com/websocket";
            str2 = "https://test-afs-xs.huachenjie.com";
        } else if (env != 7) {
            strA = "https://api.huachenjie.com/";
            str = "https://mh5.huachenjie.com";
            switch (env) {
                case 9:
                default:
                    str2 = "https://afs-xs.huachenjie.com";
                    str3 = "wss://game.huachenjie.com/websocket";
                    str4 = "wss://socket-connect.huachenjie.com/websocket";
                    str5 = "https://mh5.huachenjie.com/shandong-game-web/3.0";
                    str6 = "https://mh5.huachenjie.com/run-mobile-web";
                    break;
                case 10:
                    strA = fz5.a();
                    break;
                case 11:
                    strA = "https://sd-api.huachenjie.com/";
                    str2 = "https://afs-xs.huachenjie.com";
                    str3 = "wss://game.huachenjie.com/websocket";
                    str4 = "wss://socket-connect.huachenjie.com/websocket";
                    str5 = "https://mh5.huachenjie.com/shandong-game-web/3.0";
                    str6 = "https://mh5.huachenjie.com/run-mobile-web";
                    break;
            }
            str7 = b;
        } else {
            strA = "https://pre-api.huachenjie.com/";
            str = "https://pre-mh5.huachenjie.com";
            str6 = "https://pre-api.huachenjie.com/run-mobile-web";
            str5 = "https://pre-api.huachenjie.com/shandong-game-web/3.0";
            str4 = "ws://101.37.246.165:9155/websocket";
            str3 = "wss://pre-api.huachenjie.com/websocket";
            str2 = "https://pre-afs-xs.huachenjie.com";
        }
        Environment.c(strA);
        Environment.e(str);
        Environment.g(str6);
        Environment.b(str5);
        Environment.h("");
        Environment.f(str4);
        Environment.j(str7);
        Environment.i(str3);
        Environment.d(str2);
        f42992a = env;
    }

    public static int b() {
        return f42992a;
    }

    public static void c() {
        TextView textView;
        FloatingMagnetView floatingMagnetViewG = a.r().g();
        if (floatingMagnetViewG == null || (textView = (TextView) floatingMagnetViewG.findViewById(R.id.text)) == null) {
            return;
        }
        textView.setText(f17873a.get(Integer.valueOf(f42992a)));
    }
}
