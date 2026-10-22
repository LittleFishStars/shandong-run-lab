package com.byazt.rr;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.byazt.omf.gt;
import com.byazt.sq.uj;
import com.byazt.ue.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1287, 20})
public class c implements uj.c {
    public Context c;

    private static String a() {
        return n.tt + "/t_frequent/";
    }

    public static boolean c(String str) {
        return c(str, "checkFrequency");
    }

    private Context getContext() {
        Context context = this.c;
        return context == null ? gt.getContext() : context;
    }

    private static ContentResolver n() {
        try {
            if (gt.getContext() != null) {
                return gt.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean tt(String str) {
        return c(str, "checkAggFrequency");
    }

    public static String uj() {
        return uj("maxAggRit");
    }

    public static boolean ve(String str) {
        if (gt.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                return "true".equals(contentResolverN.getType(Uri.parse(a() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.byazt.sq.uj.c
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.sq.uj.c
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.byazt.sq.uj.c
    public String getType(Uri uri) {
        String str = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)[2];
        if ("checkFrequency".equals(str)) {
            return com.byazt.dl.n.c().c(uri.getQueryParameter("rit")) ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        if ("isSilent".equals(str)) {
            return com.byazt.dl.n.c().uj() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        if ("maxRit".equals(str)) {
            return com.byazt.dl.n.c().n();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.byazt.dl.c.c().c(uri.getQueryParameter("rit")) ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        if ("isAggSilent".equals(str)) {
            return com.byazt.dl.c.c().uj() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        if ("maxAggRit".equals(str)) {
            return com.byazt.dl.c.c().n();
        }
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public void init() {
    }

    @Override // com.byazt.sq.uj.c
    public void injectContext(Context context) {
        this.c = context;
    }

    @Override // com.byazt.sq.uj.c
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.byazt.sq.uj.c
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static boolean c(String str, String str2) {
        if (gt.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                return "true".equals(contentResolverN.getType(Uri.parse(a() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean tt() {
        return ve("isAggSilent");
    }

    public static String uj(String str) {
        if (gt.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverN = n();
            if (contentResolverN != null) {
                return contentResolverN.getType(Uri.parse(a() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String ve() {
        return uj("maxRit");
    }

    public static boolean c() {
        return ve("isSilent");
    }
}
