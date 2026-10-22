package com.byazt.xm;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.ml.ve;
import com.byazt.vb.i;
import com.byazt.vb.n;
import com.byazt.vb.sp;
import com.byazt.ym.uj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1600, 20})
public class c {
    public static String c = "layerType";
    public i n;
    public String tt;
    public n uj;
    public Context ve;

    public c(String str) {
        this.tt = str;
        sp spVarTt = com.byazt.epi.c.tt(str);
        this.uj = spVarTt.tt();
        this.n = spVarTt.ve();
    }

    private static ContentResolver c(n nVar) {
        try {
            if (nVar.getContext() != null) {
                return nVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private n tt() {
        if (this.uj == null) {
            this.uj = com.byazt.epi.c.tt(this.tt).tt();
        }
        return this.uj;
    }

    private i ve() {
        if (this.n == null) {
            this.n = com.byazt.epi.c.tt(this.tt).ve();
        }
        return this.n;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getType(Uri uri) {
        JSONObject jSONObject;
        tt();
        i iVarVe = ve();
        if (iVarVe == null) {
            ve.uj("getType center is null", tt());
            return null;
        }
        byte b = 2;
        String str = uri.getPath().split(WVNativeCallbackUtil.SEPERATER)[2];
        str.hashCode();
        switch (str.hashCode()) {
            case -482705237:
                b = str.equals("trackAdFailed") ? (byte) 0 : (byte) -1;
                break;
            case -171493183:
                b = str.equals("adLogStart") ? (byte) 1 : (byte) -1;
                break;
            case 964299715:
                if (!str.equals("adLogStop")) {
                    b = -1;
                }
                break;
            case 1025736635:
                b = str.equals("adLogDispatch") ? (byte) 3 : (byte) -1;
                break;
            case 1131732929:
                b = str.equals("trackAdUrl") ? (byte) 4 : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                com.byazt.pvs.c.c(tt()).c(uri.getQueryParameter("did"));
                return null;
            case 1:
                tt();
                iVarVe.c(TextUtils.equals(uri.getQueryParameter("is_flush"), "true"));
                return null;
            case 2:
                tt();
                return null;
            case 3:
                tt();
                com.byazt.vb.tt ttVarUj = com.byazt.fo.c.uj(com.byazt.ym.ve.tt(uri.getQueryParameter("event")));
                if (ttVarUj != null) {
                    iVarVe.c(ttVarUj);
                }
                return null;
            case 4:
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter2 = uri.getQueryParameter("track");
                    try {
                        jSONObject = new JSONObject(com.byazt.ym.ve.tt(uri.getQueryParameter("extraMate")));
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    String[] strArrSplit = com.byazt.ym.ve.tt(queryParameter2).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strTt = com.byazt.ym.ve.tt(str2);
                            if (!TextUtils.isEmpty(strTt)) {
                                arrayList.add(strTt);
                            }
                        }
                        com.byazt.pvs.c.c(tt()).c(queryParameter, arrayList, zBooleanValue, null, jSONObject);
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return null;
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static void c(n nVar, boolean z) {
        if (nVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverC = c(nVar);
            if (contentResolverC != null) {
                contentResolverC.getType(c(Uri.parse(tt(nVar) + "adLogStart?is_flush=" + z), nVar));
            }
        } catch (Throwable unused) {
        }
    }

    private static String tt(n nVar) {
        String strC = uj.c(nVar);
        StringBuilder sb = new StringBuilder();
        sb.append(strC);
        sb.append(WVNativeCallbackUtil.SEPERATER);
        sb.append("csj_mediation".equals(nVar.n()) ? "gromore_ad_log_event" : "ad_log_event");
        sb.append(WVNativeCallbackUtil.SEPERATER);
        return sb.toString();
    }

    public static void c(com.byazt.vb.tt ttVar, n nVar) {
        if (ttVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverC = c(nVar);
            if (contentResolverC != null) {
                contentResolverC.getType(c(Uri.parse(tt(nVar) + "adLogDispatch?event=" + com.byazt.ym.ve.c(ttVar.a())), nVar));
            }
        } catch (Throwable th) {
            ve.ve("dispatch event Throwable:" + th.toString(), nVar);
        }
    }

    public static void c(String str, List<String> list, boolean z, n nVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.byazt.ym.ve.c(it.next()));
                sb.append(",");
            }
            String strC = com.byazt.ym.ve.c(sb.toString());
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(strC) + "&replace=" + String.valueOf(z) + "&extraMate=" + com.byazt.ym.ve.c(jSONObject.toString());
            ContentResolver contentResolverC = c(nVar);
            if (contentResolverC != null) {
                contentResolverC.getType(c(Uri.parse(tt(nVar) + "trackAdUrl" + str2), nVar));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverC = c(nVar);
            if (contentResolverC != null) {
                contentResolverC.getType(c(Uri.parse(tt(nVar) + "trackAdFailed?did=" + String.valueOf(str)), nVar));
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context) {
        this.ve = context;
    }

    public String c() {
        return "csj_mediation".equals(this.tt) ? "gromore_ad_log_event" : "ad_log_event";
    }

    private static Uri c(Uri uri, n nVar) {
        if (uri == null || nVar == null) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.appendQueryParameter(c, String.valueOf(nVar.u()));
            return builderBuildUpon.build();
        } catch (Throwable unused) {
            return uri;
        }
    }
}
