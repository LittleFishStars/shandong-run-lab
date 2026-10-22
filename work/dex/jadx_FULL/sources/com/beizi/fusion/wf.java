package com.beizi.fusion;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.download.service.DownloadService;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPAdActivity;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPDownloadPromptActivity;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPLandingPageActivity;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPRewardVideoActivity;
import com.zj.adlib.u15;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class wf {

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public static boolean a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) ASNPDownloadPromptActivity.class);
        intent.putExtra("download_info_key", str2);
        return b(context, intent);
    }

    private static boolean b(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static boolean c(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static void d(Context context, Intent intent) {
        context.startService(intent);
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwpps://landingpage");
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        List<String> pathSegments = uri.getPathSegments();
        return (TextUtils.isEmpty(scheme) || !"bzopen".equals(scheme) || TextUtils.isEmpty(host) || pathSegments == null || pathSegments.isEmpty()) ? false : true;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("intent://");
    }

    public static boolean a(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) ASNPLandingPageActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(LoginConstants.EXT, bundle);
        return c(context, intent);
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        d(context, intent);
        a(context, intent, serviceConnection);
    }

    public static void a(Context context, Intent intent, ServiceConnection serviceConnection) {
        context.bindService(intent, serviceConnection, 1);
    }

    public static boolean a(Context context, String str, d dVar, String str2) {
        Class<ASNPAdActivity> cls = dVar == d.INTERSTITIAL ? ASNPAdActivity.class : null;
        if (dVar == d.VIDEO) {
            cls = ASNPRewardVideoActivity.class;
        }
        if (cls == null) {
            return false;
        }
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        bundle.putString("SpaceId", str);
        bundle.putString("AdType", dVar.c());
        bundle.putString("consumeId", str2);
        intent.putExtra("AdBundle", bundle);
        return c(context, intent);
    }

    public static boolean a(Context context, String str) {
        return a(context, str, (a) null);
    }

    public static boolean a(Context context, String str, a aVar) {
        return a(context, str, (String) null, aVar);
    }

    public static boolean a(Context context, String str, String str2, a aVar) {
        if (aVar != null) {
            aVar.b();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intentA = a(str, str2);
        if (a(context, intentA)) {
            if (aVar != null) {
                aVar.d();
            }
        } else if (aVar != null) {
            aVar.a();
        }
        if (d(str)) {
            intentA = a(str);
        }
        boolean zB = b(context, intentA);
        if (zB) {
            if (aVar != null) {
                aVar.c();
                return zB;
            }
        } else if (aVar != null) {
            aVar.e();
        }
        return zB;
    }

    private static Intent a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        String queryParameter = uri.getQueryParameter("flags");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                    intent.setFlags(Integer.parseInt(queryParameter));
                } else {
                    intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                }
            } catch (NumberFormatException unused) {
            }
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        intent.setComponent(new ComponentName(host, uri.getPathSegments().get(0)));
        String queryParameter2 = uri.getQueryParameter("rect");
        if (!TextUtils.isEmpty(queryParameter2)) {
            try {
                String[] strArrSplit = queryParameter2.split(u15.f19942b);
                if (strArrSplit.length == 4) {
                    Rect rect = new Rect();
                    rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                    intent.setSourceBounds(rect);
                }
            } catch (NumberFormatException unused2) {
            }
        }
        return intent;
    }

    private static Intent a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b(str)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            return intent;
        }
        if (c(str)) {
            try {
                Intent uri = Intent.parseUri(str, 1);
                uri.setFlags(268435456);
                return uri;
            } catch (URISyntaxException unused) {
                return null;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent2.setFlags(268435456);
        if (!TextUtils.isEmpty(str2)) {
            intent2.setPackage(str2);
        }
        return intent2;
    }

    private static boolean a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }
}
