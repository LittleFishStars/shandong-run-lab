package com.igexin.push.f;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.hv.TTDownloadField;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.b.u;
import com.igexin.push.core.d.d.AnonymousClass3;
import com.igexin.push.core.d.d.AnonymousClass4;
import com.igexin.push.g.n;
import com.igexin.push.g.o;
import com.igexin.push.g.q;
import com.igexin.sdk.router.TransferGtcProcess;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38133a = "com.sdk.plus.EnhActivity";
    public static final int b = 1;
    public static final int c = 0;
    static final AtomicReference<ScheduledFuture<?>> d = new AtomicReference<>();
    private static final String e = "Type145Task";

    /* JADX INFO: renamed from: com.igexin.push.f.h$2, reason: invalid class name */
    public static class AnonymousClass2 implements Call.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f38135a;
        final /* synthetic */ String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        public AnonymousClass2(AtomicInteger atomicInteger, String str, byte[] bArr, int i) {
            this.f38135a = atomicInteger;
            this.b = str;
            this.c = bArr;
            this.d = i;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(Call call, Exception exc) {
            com.igexin.c.a.c.a.a(exc);
            if (!"network is not available".equals(exc.getMessage()) && this.f38135a.incrementAndGet() < 3) {
                com.igexin.push.f.a.c.a(this.b, this.c, this);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(Call call, Response response) {
            try {
                int iCode = response.code();
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("result")) {
                    String string = jSONObject.getString("result");
                    com.igexin.c.a.c.a.b(h.e, "upload 145 code = " + iCode + " result = " + string);
                    if ("ok".equals(string)) {
                        h.a(this.d);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f38137a = new h();

        private a() {
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length / 1024;
        if (length <= 200) {
            return bitmap;
        }
        double d2 = length / 200;
        Double dValueOf = Double.valueOf(((double) bitmap.getWidth()) / Math.sqrt(d2));
        Double dValueOf2 = Double.valueOf(((double) bitmap.getHeight()) / Math.sqrt(d2));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) (dValueOf.doubleValue() / ((double) width)), (float) (dValueOf2.doubleValue() / ((double) height)));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static Bitmap a(Bitmap bitmap, Double d2, Double d3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) (d2.doubleValue() / ((double) width)), (float) (d3.doubleValue() / ((double) height)));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static h a() {
        return a.f38137a;
    }

    private static String a(Context context) {
        return (String) o.b(context, "ua", "");
    }

    public static /* synthetic */ String a(Context context, Intent intent, u uVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuffer.append("|");
        stringBuffer.append(uVar.f37973a);
        stringBuffer.append("|");
        stringBuffer.append(uVar.b);
        stringBuffer.append("|");
        stringBuffer.append(uVar.c);
        stringBuffer.append("|");
        stringBuffer.append(2);
        stringBuffer.append("|");
        stringBuffer.append(uVar.g);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(uVar.d);
        stringBuffer.append("|");
        stringBuffer.append(uVar.l);
        stringBuffer.append("|");
        stringBuffer.append(1 ^ (uVar.f ? 1 : 0));
        stringBuffer.append("|");
        stringBuffer.append(uVar.e ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(uVar.h ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(uVar.i);
        stringBuffer.append("|");
        String str = "";
        stringBuffer.append(intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab) ? uVar.k : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(uVar.j);
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145IpEnable", com.igexin.push.config.d.ac) ? q.a(context) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad) ? a(n.r()) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145NetLocEnable", com.igexin.push.config.d.ae) ? a(n.s()) : "");
        stringBuffer.append("|");
        if (intent.getBooleanExtra("type145CellInfoEnable", com.igexin.push.config.d.af)) {
            com.igexin.push.core.b.d dVarB = q.b(context);
            str = dVarB.f37954a + "," + dVarB.b + "," + dVarB.c + "," + dVarB.d;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static String a(Location location) {
        StringBuilder sb = new StringBuilder();
        if (location == null) {
            sb.append("none");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append(",");
            sb.append(location.getLongitude());
            sb.append(",");
            sb.append(location.getLatitude());
            sb.append(",");
            sb.append(location.getAltitude());
        }
        return sb.toString();
    }

    private static String a(com.igexin.push.core.b.d dVar) {
        return dVar.f37954a + "," + dVar.b + "," + dVar.c + "," + dVar.d;
    }

    public static /* synthetic */ void a(int i) throws Throwable {
        String str = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        com.igexin.push.core.d.d dVarA = com.igexin.push.core.d.d.a();
        dVarA.a(dVarA.new AnonymousClass4(str).a((com.igexin.push.core.g.a) dVarA.new AnonymousClass3()));
    }

    private static void a(final int i, final String str, final String str2) {
        com.igexin.b.a.a().b().schedule(new Runnable() { // from class: com.igexin.push.f.h.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList<String> arrayListA = com.igexin.push.core.d.d.a().a(i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i, new ArrayList<>());
                    if (arrayListA.isEmpty()) {
                        arrayListA.size();
                        return;
                    }
                    for (int i2 = 0; i2 < arrayListA.size(); i2++) {
                        String str3 = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(arrayListA.get(i2).getBytes(), 2)));
                        if (i2 < arrayListA.size() - 1) {
                            sb.append(str3);
                            sb.append("\n");
                        } else {
                            sb.append(str3);
                        }
                    }
                    String string = sb.toString();
                    com.igexin.c.a.c.a.b(h.e, " start145Data  content  = ".concat(String.valueOf(string)));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", 145);
                    jSONObject.put("cid", str2);
                    jSONObject.put("BIData", new String(IOUtils.encode(string.getBytes(), 0)));
                    byte[] bytes = jSONObject.toString().getBytes();
                    if (bytes == null || bytes.length <= 0) {
                        return;
                    }
                    h.a(str, bytes, i);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }, 10000L, TimeUnit.MILLISECONDS);
    }

    private static void a(final Context context, final int i, final Intent intent) {
        ServiceManager.b = context;
        final String stringExtra = intent.getStringExtra("biUploadUrl");
        final String stringExtra2 = intent.getStringExtra("cid");
        a(i, stringExtra, stringExtra2);
        if (Build.VERSION.SDK_INT >= 28) {
            com.igexin.c.a.c.a.b(e, "processName  = ".concat(String.valueOf(Application.getProcessName())));
        }
        final String stringExtra3 = intent.getStringExtra("appid");
        final String stringExtra4 = intent.getStringExtra("gtcid");
        long longExtra = intent.getLongExtra("type145IntervalMs", com.igexin.push.config.d.Z);
        final int intExtra = intent.getIntExtra("type145times", com.igexin.push.config.d.aa);
        boolean booleanExtra = intent.getBooleanExtra("type145Enable", com.igexin.push.config.d.Y);
        final boolean booleanExtra2 = intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab);
        int intExtra2 = intent.getIntExtra("gtsdkGuardStart", 0);
        com.igexin.c.a.c.a.b(e, "type145IntervalMs  = " + longExtra + " , type145times  = " + intExtra);
        if (intExtra2 != 1) {
            com.igexin.c.a.c.a.b(e, "gtsdkGuardStart  = false");
            return;
        }
        if (!booleanExtra) {
            com.igexin.c.a.c.a.b(e, "type145Enable  = false");
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        d.set(com.igexin.b.a.a().b().scheduleAtFixedRate(new Runnable() { // from class: com.igexin.push.f.h.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (atomicInteger.incrementAndGet() > intExtra) {
                        h.d();
                        return;
                    }
                    Pair<Activity, String> pairC = h.c();
                    Activity activity = (Activity) pairC.first;
                    if (activity == null) {
                        com.igexin.c.a.c.a.b(h.e, " start145Data return topActivity = null");
                        return;
                    }
                    String className = activity.getComponentName().getClassName();
                    if (h.f38133a.equals(className)) {
                        com.igexin.c.a.c.a.b(h.e, " start145Data return topActivity = ".concat(String.valueOf(className)));
                        return;
                    }
                    String strC = booleanExtra2 ? h.c(activity) : "";
                    boolean z = ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0) != null;
                    boolean zA = h.a(activity);
                    boolean z2 = context.getPackageManager().getActivityInfo(activity.getComponentName(), 0).theme == 16973840;
                    com.igexin.c.a.c.a.b(h.e, " packageData ");
                    if (zA || !z2 || z) {
                        h.d();
                        u uVar = new u(stringExtra2, stringExtra3, stringExtra4, className, zA, z2, z, jElapsedRealtime, (String) pairC.second, strC, i);
                        h.a(stringExtra, h.b((List<String>) h.b(h.a(context, intent, uVar), i), uVar), i);
                    }
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }, 0L, longExtra, TimeUnit.MILLISECONDS));
    }

    public static void a(Context context, Intent intent) {
        try {
            if (CommonUtil.isMainProcess()) {
                a(context, 0, intent);
            } else {
                TransferGtcProcess.getInstance().transferGtcProcess(context, intent, TransferGtcProcess.TYPE145TASK_METHODNAME);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static /* synthetic */ void a(String str, byte[] bArr, int i) {
        com.igexin.push.f.a.c.a(str, bArr, new AnonymousClass2(new AtomicInteger(0), str, bArr, i));
    }

    public static boolean a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        IBinder windowToken = decorView.getWindowToken();
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            int iIndexOf = ((ArrayList) declaredField.get(objInvoke)).indexOf(decorView);
            if (iIndexOf < 0) {
                return false;
            }
            Field declaredField2 = cls.getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(objInvoke);
            IBinder iBinder = ((WindowManager.LayoutParams) arrayList.get(iIndexOf)).token;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IBinder iBinder2 = ((WindowManager.LayoutParams) it.next()).token;
                if (iBinder2 == windowToken || iBinder2 == null || iBinder2 == iBinder) {
                    arrayList2.add(iBinder2);
                }
            }
            return arrayList2.size() > 1;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static String b(Context context, Intent intent, u uVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuffer.append("|");
        stringBuffer.append(uVar.f37973a);
        stringBuffer.append("|");
        stringBuffer.append(uVar.b);
        stringBuffer.append("|");
        stringBuffer.append(uVar.c);
        stringBuffer.append("|");
        stringBuffer.append(2);
        stringBuffer.append("|");
        stringBuffer.append(uVar.g);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(uVar.d);
        stringBuffer.append("|");
        stringBuffer.append(uVar.l);
        stringBuffer.append("|");
        stringBuffer.append(1 ^ (uVar.f ? 1 : 0));
        stringBuffer.append("|");
        stringBuffer.append(uVar.e ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(uVar.h ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(uVar.i);
        stringBuffer.append("|");
        String str = "";
        stringBuffer.append(intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab) ? uVar.k : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(uVar.j);
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145IpEnable", com.igexin.push.config.d.ac) ? q.a(context) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad) ? a(n.r()) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145NetLocEnable", com.igexin.push.config.d.ae) ? a(n.s()) : "");
        stringBuffer.append("|");
        if (intent.getBooleanExtra("type145CellInfoEnable", com.igexin.push.config.d.af)) {
            com.igexin.push.core.b.d dVarB = q.b(context);
            str = dVarB.f37954a + "," + dVarB.b + "," + dVarB.c + "," + dVarB.d;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> b(String str, int i) throws Throwable {
        String strEncodeToString = Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 2);
        String str2 = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        ArrayList<String> arrayListA = com.igexin.push.core.d.d.a().a(str2, new ArrayList<>());
        arrayListA.add(strEncodeToString);
        com.igexin.push.core.d.d.a().a(str2, (Object) arrayListA);
        return arrayListA;
    }

    public static void b() {
        com.igexin.c.a.c.a.b(e, "doAction ---");
        Intent intent = new Intent(com.igexin.push.core.e.g + ".doaction");
        intent.putExtra("cid", com.igexin.push.core.e.A);
        intent.putExtra("appid", com.igexin.push.core.e.f38001a);
        intent.putExtra("gtcid", com.igexin.push.core.e.C);
        intent.putExtra("type145IntervalMs", com.igexin.push.config.d.Z);
        intent.putExtra("type145times", com.igexin.push.config.d.aa);
        intent.putExtra("type145Enable", com.igexin.push.config.d.Y);
        intent.putExtra("biUploadUrl", SDKUrlConfig.getBiUploadServiceUrl());
        intent.putExtra("gtsdkGuardStart", (Serializable) ServiceManager.getInstance().initType.first);
        intent.putExtra("type145PicEnable", com.igexin.push.config.d.ab);
        intent.putExtra("type145IpEnable", com.igexin.push.config.d.ac);
        intent.putExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad);
        intent.putExtra("type145NetLocEnable", com.igexin.push.config.d.ae);
        intent.putExtra("type145CellInfoEnable", com.igexin.push.config.d.af);
        a(com.igexin.push.core.e.l, 1, intent);
        if (CommonUtil.isMainProcess()) {
            return;
        }
        h unused = a.f38137a;
        a(com.igexin.push.core.e.l, intent);
    }

    private static void b(int i) throws Throwable {
        String str = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        com.igexin.push.core.d.d dVarA = com.igexin.push.core.d.d.a();
        dVarA.a(dVarA.new AnonymousClass4(str).a((com.igexin.push.core.g.a) dVarA.new AnonymousClass3()));
    }

    private static void b(String str, byte[] bArr, int i) {
        com.igexin.push.f.a.c.a(str, bArr, new AnonymousClass2(new AtomicInteger(0), str, bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(List<String> list, u uVar) throws Throwable {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(list.get(i).getBytes(), 2)));
            int size = list.size() - 1;
            sb.append(str);
            if (i < size) {
                sb.append("\n");
            }
        }
        String string = sb.toString();
        com.igexin.c.a.c.a.b(e, " start145Data  content  = ".concat(String.valueOf(string)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", "upload_BI");
        jSONObject.put("BIType", 145);
        jSONObject.put("cid", uVar.f37973a);
        jSONObject.put("BIData", new String(IOUtils.encode(string.getBytes(), 0)));
        return jSONObject.toString().getBytes();
    }

    public static Pair<Activity, String> c() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return new Pair<>(null, "");
            }
            StringBuffer stringBuffer = new StringBuffer();
            Activity activity = null;
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj);
                Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (!declaredField3.getBoolean(obj)) {
                    activity = activity2;
                }
                if (activity2 != null) {
                    stringBuffer.append(activity2.getComponentName().getClassName());
                    stringBuffer.append(",");
                }
            }
            return new Pair<>(activity, stringBuffer.toString());
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new Pair<>(null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Activity activity) {
        try {
            View rootView = activity.getWindow().getDecorView().getRootView();
            Method declaredMethod = View.class.getDeclaredMethod(new String(Base64.decode("c2V0RHJhd2luZ0NhY2hlRW5hYmxlZA==", 0)), Boolean.TYPE);
            declaredMethod.invoke(rootView, Boolean.TRUE);
            String str = new String(Base64.decode("Y3JlYXRlQml0bWFw", 0));
            Class cls = Integer.TYPE;
            Bitmap bitmapCreateBitmap = (Bitmap) Bitmap.class.getDeclaredMethod(str, cls, cls, Bitmap.Config.class).invoke(null, Integer.valueOf(rootView.getWidth()), Integer.valueOf(rootView.getHeight()), Bitmap.Config.RGB_565);
            rootView.draw(new Canvas(bitmapCreateBitmap));
            declaredMethod.invoke(rootView, Boolean.FALSE);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length / 1024;
            if (length > 200) {
                double d2 = length / 200;
                Double dValueOf = Double.valueOf(((double) bitmapCreateBitmap.getWidth()) / Math.sqrt(d2));
                Double dValueOf2 = Double.valueOf(((double) bitmapCreateBitmap.getHeight()) / Math.sqrt(d2));
                int width = bitmapCreateBitmap.getWidth();
                int height = bitmapCreateBitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale((float) (dValueOf.doubleValue() / ((double) width)), (float) (dValueOf2.doubleValue() / ((double) height)));
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height, matrix, true);
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (IOException unused) {
            }
            return Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static /* synthetic */ void d() {
        AtomicReference<ScheduledFuture<?>> atomicReference = d;
        if (atomicReference.get() != null) {
            com.igexin.c.a.c.a.b(e, "type145 task close");
            atomicReference.get().cancel(false);
        }
    }

    private static void e() {
        AtomicReference<ScheduledFuture<?>> atomicReference = d;
        if (atomicReference.get() != null) {
            com.igexin.c.a.c.a.b(e, "type145 task close");
            atomicReference.get().cancel(false);
        }
    }

    private static Bitmap f() {
        return null;
    }
}
