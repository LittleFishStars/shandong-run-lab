package com.czhj.devicehelper.honor.identifier;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.openset.constant.DeviceIdType;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: com.czhj.devicehelper.honor.identifier.a$a, reason: collision with other inner class name */
    public static final class C0612a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29368a;
        public boolean b;
    }

    private a() {
    }

    public static C0612a a(Context context) {
        b bVar = new b();
        bVar.b = context;
        if (!bVar.a(context)) {
            return null;
        }
        C0612a c0612a = bVar.f29369a;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID);
            if (!TextUtils.isEmpty(string)) {
                c0612a.b = false;
                c0612a.f29368a = string;
                Log.i("AdvertisingIdPlatform", "use global oaid");
                return c0612a;
            }
        } catch (Exception unused) {
        }
        try {
            Log.i("AdvertisingIdPlatform", "bindService start");
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            context.bindService(intent, bVar, 1);
            bVar.e.await(2000L, TimeUnit.MILLISECONDS);
            bVar.a();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
            bVar.a();
        }
        return c0612a;
    }

    public static boolean b(Context context) {
        return new b().a(context);
    }
}
