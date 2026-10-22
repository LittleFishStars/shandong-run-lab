package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.common.crash.CrashHandler;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28143a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SimpleDateFormat f1280a = null;
    public static final int b = 3;
    public static final int c = 4;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f1284c = "┌";
    public static final int d = 5;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f1285d = "├";
    public static final int e = 6;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f1286e = "│ ";
    public static final int f = 7;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f1287f = "└";
    public static final int g = 16;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f1288g = "────────────────────────────────────────────────────────";
    public static final int h = 32;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String f1289h = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final int i = 48;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String f1290i = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final int j = 1100;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f1291j = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final String k = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final String l = "log nothing";
    public static final String m = "null";
    public static final String n = "args";
    public static final String o = " ";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f1282a = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1279a = System.getProperty("file.separator");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f1283b = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final e f1278a = new e();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExecutorService f1281a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SimpleArrayMap<Class, IFormatter> f1277a = new SimpleArrayMap<>();

    public interface IFileWriter {
        void a(String str, String str2);
    }

    public static abstract class IFormatter<T> {
        public abstract String a(T t);
    }

    public interface OnConsoleOutputListener {
        void a(int i, String str, String str2);
    }

    public interface OnFileOutputListener {
        void a(String str, String str2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public class a implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f28144a;
        public final /* synthetic */ String f;

        public a(int i, g gVar, String str) {
            this.K = i;
            this.f28144a = gVar;
            this.f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.Q(this.K, this.f28144a.f28147a, this.f28144a.b + this.f);
        }
    }

    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return LogUtils.I(str);
        }
    }

    public class c implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return LogUtils.I(str);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f28145a;

        public d(File file) {
            this.f28145a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f28145a.delete()) {
                return;
            }
            Log.e("LogUtils", "delete " + this.f28145a + " failed!");
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28146a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public IFileWriter f1292a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public OnConsoleOutputListener f1293a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public OnFileOutputListener f1294a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i.a f1295a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1296a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1297a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f1298b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f1299b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public String f1300c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f1301c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public String f1302d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f1303d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public String f1304e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f1305e;
        public String f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public boolean f1306f;
        public boolean g;

        public e() {
            this.f1300c = "util";
            this.f1302d = CrashHandler.FILE_NAME_SUFFIX;
            this.f1297a = true;
            this.f1299b = true;
            this.f1304e = "";
            this.f1301c = true;
            this.f1303d = true;
            this.f1305e = false;
            this.f1306f = true;
            this.g = true;
            this.f28146a = 2;
            this.b = 2;
            this.c = 1;
            this.d = 0;
            this.e = -1;
            this.f = i.M();
            this.f1295a = new i.a(com.ipd.dsp.internal.h1.a.f38319a);
            if (!i.z0() || Utils.a().getExternalFilesDir(null) == null) {
                this.f1296a = Utils.a().getFilesDir() + LogUtils.f1279a + "log" + LogUtils.f1279a;
                return;
            }
            this.f1296a = Utils.a().getExternalFilesDir(null) + LogUtils.f1279a + "log" + LogUtils.f1279a;
        }

        public final boolean A() {
            return this.f1303d;
        }

        public final boolean B() {
            return this.f1297a;
        }

        public final boolean C() {
            return this.g;
        }

        public final e D(boolean z) {
            this.f1306f = z;
            return this;
        }

        public final e E(int i) {
            this.f28146a = i;
            return this;
        }

        public final e F(boolean z) {
            this.f1299b = z;
            return this;
        }

        public final e G(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + LogUtils.f1279a;
            }
            this.f1298b = str;
            return this;
        }

        public final e H(String str) {
            if (i.C0(str)) {
                this.f1298b = null;
            } else {
                if (!str.endsWith(LogUtils.f1279a)) {
                    str = str + LogUtils.f1279a;
                }
                this.f1298b = str;
            }
            return this;
        }

        public final e I(String str) {
            if (i.C0(str)) {
                this.f1302d = CrashHandler.FILE_NAME_SUFFIX;
            } else if (str.startsWith(Consts.DOT)) {
                this.f1302d = str;
            } else {
                this.f1302d = Consts.DOT + str;
            }
            return this;
        }

        public final e J(int i) {
            this.b = i;
            return this;
        }

        public final e K(String str) {
            if (i.C0(str)) {
                this.f1300c = "util";
            } else {
                this.f1300c = str;
            }
            return this;
        }

        public final e L(IFileWriter iFileWriter) {
            this.f1292a = iFileWriter;
            return this;
        }

        public final e M(String str) {
            if (i.C0(str)) {
                this.f1304e = "";
                this.f1301c = true;
            } else {
                this.f1304e = str;
                this.f1301c = false;
            }
            return this;
        }

        public final e N(boolean z) {
            this.f1305e = z;
            return this;
        }

        public final e O(boolean z) {
            this.f1303d = z;
            return this;
        }

        public final e P(boolean z) {
            this.f1297a = z;
            return this;
        }

        public final e Q(OnConsoleOutputListener onConsoleOutputListener) {
            this.f1293a = onConsoleOutputListener;
            return this;
        }

        public final e R(OnFileOutputListener onFileOutputListener) {
            this.f1294a = onFileOutputListener;
            return this;
        }

        public final e S(@IntRange(from = 1) int i) {
            this.e = i;
            return this;
        }

        public final e T(boolean z) {
            this.g = z;
            return this;
        }

        public final e U(@IntRange(from = 1) int i) {
            this.c = i;
            return this;
        }

        public final e V(@IntRange(from = 0) int i) {
            this.d = i;
            return this;
        }

        public final e h(String str, String str2) {
            this.f1295a.b(str, str2);
            return this;
        }

        public final e i(Map<String, String> map) {
            this.f1295a.c(map);
            return this;
        }

        public final <T> e j(IFormatter<T> iFormatter) {
            if (iFormatter != null) {
                LogUtils.f1277a.put(LogUtils.E(iFormatter), iFormatter);
            }
            return this;
        }

        public final char k() {
            return LogUtils.f1282a[this.f28146a - 2];
        }

        public final String l() {
            return this.f1296a;
        }

        public final String m() {
            String str = this.f1298b;
            return str == null ? this.f1296a : str;
        }

        public final String n() {
            return this.f1302d;
        }

        public final char o() {
            return LogUtils.f1282a[this.b - 2];
        }

        public final String p() {
            return this.f1300c;
        }

        public final String q() {
            return i.C0(this.f1304e) ? "" : this.f1304e;
        }

        public final String r() {
            String str = this.f;
            return str == null ? "" : str.replace(u15.f19942b, LoginConstants.UNDER_LINE);
        }

        public final int s() {
            return this.e;
        }

        public final int t() {
            return this.c;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("process: ");
            sb.append(r());
            sb.append(LogUtils.f1283b);
            sb.append("logSwitch: ");
            sb.append(B());
            sb.append(LogUtils.f1283b);
            sb.append("consoleSwitch: ");
            sb.append(x());
            sb.append(LogUtils.f1283b);
            sb.append("tag: ");
            sb.append(q().equals("") ? "null" : q());
            sb.append(LogUtils.f1283b);
            sb.append("headSwitch: ");
            sb.append(A());
            sb.append(LogUtils.f1283b);
            sb.append("fileSwitch: ");
            sb.append(y());
            sb.append(LogUtils.f1283b);
            sb.append("dir: ");
            sb.append(m());
            sb.append(LogUtils.f1283b);
            sb.append("filePrefix: ");
            sb.append(p());
            sb.append(LogUtils.f1283b);
            sb.append("borderSwitch: ");
            sb.append(z());
            sb.append(LogUtils.f1283b);
            sb.append("singleTagSwitch: ");
            sb.append(C());
            sb.append(LogUtils.f1283b);
            sb.append("consoleFilter: ");
            sb.append(k());
            sb.append(LogUtils.f1283b);
            sb.append("fileFilter: ");
            sb.append(o());
            sb.append(LogUtils.f1283b);
            sb.append("stackDeep: ");
            sb.append(t());
            sb.append(LogUtils.f1283b);
            sb.append("stackOffset: ");
            sb.append(u());
            sb.append(LogUtils.f1283b);
            sb.append("saveDays: ");
            sb.append(s());
            sb.append(LogUtils.f1283b);
            sb.append("formatter: ");
            sb.append(LogUtils.f1277a);
            sb.append(LogUtils.f1283b);
            sb.append("fileWriter: ");
            sb.append(this.f1292a);
            sb.append(LogUtils.f1283b);
            sb.append("onConsoleOutputListener: ");
            sb.append(this.f1293a);
            sb.append(LogUtils.f1283b);
            sb.append("onFileOutputListener: ");
            sb.append(this.f1294a);
            sb.append(LogUtils.f1283b);
            sb.append("fileExtraHeader: ");
            sb.append(this.f1295a.f());
            return sb.toString();
        }

        public final int u() {
            return this.d;
        }

        public final boolean v() {
            return this.f1293a != null;
        }

        public final boolean w() {
            return this.f1294a != null;
        }

        public final boolean x() {
            return this.f1299b;
        }

        public final boolean y() {
            return this.f1305e;
        }

        public final boolean z() {
            return this.f1306f;
        }
    }

    public static final class f {
        public static String a(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }

        public static String b(Bundle bundle) {
            Iterator<String> it = bundle.keySet().iterator();
            if (!it.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append("Bundle { ");
            while (true) {
                String next = it.next();
                Object obj = bundle.get(next);
                sb.append(next);
                sb.append(com.alipay.sdk.m.p.a.h);
                if (obj instanceof Bundle) {
                    sb.append(obj == bundle ? "(this Bundle)" : b((Bundle) obj));
                } else {
                    sb.append(LogUtils.w(obj));
                }
                if (!it.hasNext()) {
                    sb.append(" }");
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        }

        @RequiresApi(api = 16)
        public static void c(ClipData clipData, StringBuilder sb) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb.append("ClipData.Item {}");
                return;
            }
            sb.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb.append("H:");
                sb.append(htmlText);
                sb.append("}");
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb.append("T:");
                sb.append(text);
                sb.append("}");
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb.append("U:");
                sb.append(uri);
                sb.append("}");
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent == null) {
                sb.append("NULL");
                sb.append("}");
            } else {
                sb.append("I:");
                sb.append(f(intent));
                sb.append("}");
            }
        }

        public static String d(String str) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '{') {
                        return new JSONObject(str).toString(2);
                    }
                    if (cCharAt == '[') {
                        return new JSONArray(str).toString(2);
                    }
                    if (!Character.isWhitespace(cCharAt)) {
                        return str;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return str;
        }

        public static String e(String str) {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformerNewTransformer.transform(streamSource, streamResult);
                return streamResult.getWriter().toString().replaceFirst(">", ">" + LogUtils.f1283b);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        public static String f(Intent intent) {
            boolean z;
            StringBuilder sb = new StringBuilder(128);
            sb.append("Intent { ");
            String action = intent.getAction();
            boolean z2 = false;
            boolean z3 = true;
            if (action != null) {
                sb.append("act=");
                sb.append(action);
                z = false;
            } else {
                z = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cat=[");
                for (String str : categories) {
                    if (!z3) {
                        sb.append(',');
                    }
                    sb.append(str);
                    z3 = false;
                }
                sb.append("]");
                z = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("dat=");
                sb.append(data);
                z = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("typ=");
                sb.append(type);
                z = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("flg=0x");
                sb.append(Integer.toHexString(flags));
                z = false;
            }
            String str2 = intent.getPackage();
            if (str2 != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("pkg=");
                sb.append(str2);
                z = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cmp=");
                sb.append(component.flattenToShortString());
                z = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("bnds=");
                sb.append(sourceBounds.toShortString());
                z = false;
            }
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                if (!z) {
                    sb.append(' ');
                }
                c(clipData, sb);
                z = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("extras={");
                sb.append(b(extras));
                sb.append('}');
            } else {
                z2 = z;
            }
            Intent selector = intent.getSelector();
            if (selector != null) {
                if (!z2) {
                    sb.append(' ');
                }
                sb.append("sel={");
                sb.append(selector == intent ? "(this Intent)" : f(selector));
                sb.append("}");
            }
            sb.append(" }");
            return sb.toString();
        }

        public static String g(Object obj) {
            if (obj instanceof CharSequence) {
                return i.F(obj.toString());
            }
            try {
                return i.T().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        public static String h(Object obj) {
            return i(obj, -1);
        }

        public static String i(Object obj, int i) {
            if (obj.getClass().isArray()) {
                return a(obj);
            }
            if (obj instanceof Throwable) {
                return i.S((Throwable) obj);
            }
            if (obj instanceof Bundle) {
                return b((Bundle) obj);
            }
            if (obj instanceof Intent) {
                return f((Intent) obj);
            }
            if (i == 32) {
                return g(obj);
            }
            return i == 48 ? e(obj.toString()) : obj.toString();
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28147a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String[] f1307a;
        public String b;

        public g(String str, String[] strArr, String str2) {
            this.f28147a = str;
            this.f1307a = strArr;
            this.b = str2;
        }
    }

    public LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(Date date) {
        String strSubstring = D().format(date).substring(0, 10);
        StringBuilder sb = new StringBuilder();
        e eVar = f1278a;
        sb.append(eVar.m());
        sb.append(eVar.p());
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(strSubstring);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(eVar.r());
        sb.append(eVar.n());
        return sb.toString();
    }

    public static String B(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] strArrSplit = className.split("\\.");
        if (strArrSplit.length > 0) {
            className = strArrSplit[strArrSplit.length - 1];
        }
        int iIndexOf = className.indexOf(36);
        if (iIndexOf != -1) {
            className = className.substring(0, iIndexOf);
        }
        return className + ".java";
    }

    public static List<File> C() {
        File file = new File(f1278a.m());
        if (!file.exists()) {
            return new ArrayList();
        }
        File[] fileArrListFiles = file.listFiles(new b());
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fileArrListFiles);
        return arrayList;
    }

    public static SimpleDateFormat D() {
        if (f1280a == null) {
            f1280a = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return f1280a;
    }

    public static <T> Class E(IFormatter<T> iFormatter) {
        Type[] genericInterfaces = iFormatter.getClass().getGenericInterfaces();
        Type rawType = ((ParameterizedType) (genericInterfaces.length == 1 ? genericInterfaces[0] : iFormatter.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        while (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        String string = rawType.toString();
        if (string.startsWith("class ")) {
            string = string.substring(6);
        } else if (string.startsWith("interface ")) {
            string = string.substring(10);
        }
        try {
            return Class.forName(string);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void F(Object... objArr) {
        N(4, f1278a.q(), objArr);
    }

    public static void G(String str, Object... objArr) {
        N(4, str, objArr);
    }

    public static void H(String str, String str2) {
        e eVar = f1278a;
        if (eVar.f1292a == null) {
            i.h1(str, str2, true);
        } else {
            eVar.f1292a.a(str, str2);
        }
        if (eVar.f1294a != null) {
            eVar.f1294a.a(str, str2);
        }
    }

    public static boolean I(String str) {
        return str.matches("^" + f1278a.p() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static void J(int i2, Object obj) {
        N(i2 | 32, f1278a.q(), obj);
    }

    public static void K(int i2, String str, Object obj) {
        N(i2 | 32, str, obj);
    }

    public static void L(Object obj) {
        N(35, f1278a.q(), obj);
    }

    public static void M(String str, Object obj) {
        N(35, str, obj);
    }

    public static void N(int i2, String str, Object... objArr) {
        e eVar = f1278a;
        if (eVar.B()) {
            int i3 = i2 & 15;
            int i4 = i2 & 240;
            if (eVar.x() || eVar.y() || i4 == 16) {
                if (i3 >= eVar.f28146a || i3 >= eVar.b) {
                    g gVarZ = Z(str);
                    String strX = X(i4, objArr);
                    if (eVar.x() && i4 != 16 && i3 >= eVar.f28146a) {
                        P(i3, gVarZ.f28147a, gVarZ.f1307a, strX);
                    }
                    if ((eVar.y() || i4 == 16) && i3 >= eVar.b) {
                        f1281a.execute(new a(i3, gVarZ, strX));
                    }
                }
            }
        }
    }

    public static void O(int i2, String str, String str2) {
        Log.println(i2, str, str2);
        e eVar = f1278a;
        if (eVar.f1293a != null) {
            eVar.f1293a.a(i2, str, str2);
        }
    }

    public static void P(int i2, String str, String[] strArr, String str2) {
        if (f1278a.C()) {
            V(i2, str, Y(i2, str, strArr, str2));
            return;
        }
        R(i2, str, true);
        T(i2, str, strArr);
        U(i2, str, str2);
        R(i2, str, false);
    }

    public static void Q(int i2, String str, String str2) {
        Date date = new Date();
        String str3 = D().format(date);
        String strSubstring = str3.substring(0, 10);
        String strA = A(date);
        if (!k(strA, strSubstring)) {
            Log.e("LogUtils", "create " + strA + " failed!");
            return;
        }
        H(strA, str3.substring(11) + f1282a[i2 - 2] + WVNativeCallbackUtil.SEPERATER + str + str2 + f1283b);
    }

    public static void R(int i2, String str, boolean z) {
        if (f1278a.z()) {
            O(i2, str, z ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    public static void S(String str, String str2) {
        e eVar = f1278a;
        eVar.f1295a.a("Date of Log", str2);
        H(str, eVar.f1295a.toString());
    }

    public static void T(int i2, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (f1278a.z()) {
                    str2 = f1286e + str2;
                }
                O(i2, str, str2);
            }
            if (f1278a.z()) {
                O(i2, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }

    public static void U(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / 1100;
        if (i3 <= 0) {
            W(i2, str, str2);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1100;
            W(i2, str, str2.substring(i5, i6));
            i4++;
            i5 = i6;
        }
        if (i5 != length) {
            W(i2, str, str2.substring(i5, length));
        }
    }

    public static void V(int i2, String str, String str2) {
        int length = str2.length();
        e eVar = f1278a;
        int i3 = 1100;
        int i4 = eVar.z() ? (length - 113) / 1100 : length / 1100;
        if (i4 <= 0) {
            O(i2, str, str2);
            return;
        }
        int i5 = 1;
        if (!eVar.z()) {
            O(i2, str, str2.substring(0, 1100));
            while (i5 < i4) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(f1283b);
                int i6 = i3 + 1100;
                sb.append(str2.substring(i3, i6));
                O(i2, str, sb.toString());
                i5++;
                i3 = i6;
            }
            if (i3 != length) {
                O(i2, str, " " + f1283b + str2.substring(i3, length));
                return;
            }
            return;
        }
        O(i2, str, str2.substring(0, 1100) + f1283b + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        while (i5 < i4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            String str3 = f1283b;
            sb2.append(str3);
            sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb2.append(str3);
            sb2.append(f1286e);
            int i7 = i3 + 1100;
            sb2.append(str2.substring(i3, i7));
            sb2.append(str3);
            sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            O(i2, str, sb2.toString());
            i5++;
            i3 = i7;
        }
        if (i3 != length - 113) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" ");
            String str4 = f1283b;
            sb3.append(str4);
            sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb3.append(str4);
            sb3.append(f1286e);
            sb3.append(str2.substring(i3, length));
            O(i2, str, sb3.toString());
        }
    }

    public static void W(int i2, String str, String str2) {
        if (!f1278a.z()) {
            O(i2, str, str2);
            return;
        }
        for (String str3 : str2.split(f1283b)) {
            O(i2, str, f1286e + str3);
        }
    }

    public static String X(int i2, Object... objArr) {
        String string;
        if (objArr != null) {
            if (objArr.length == 1) {
                string = v(i2, objArr[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = objArr[i3];
                    sb.append("args");
                    sb.append("[");
                    sb.append(i3);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(w(obj));
                    sb.append(f1283b);
                }
                string = sb.toString();
            }
        } else {
            string = "null";
        }
        return string.length() == 0 ? l : string;
    }

    public static String Y(int i2, String str, String[] strArr, String str2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        if (f1278a.z()) {
            sb.append(" ");
            String str3 = f1283b;
            sb.append(str3);
            sb.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb.append(str3);
            if (strArr != null) {
                for (String str4 : strArr) {
                    sb.append(f1286e);
                    sb.append(str4);
                    sb.append(f1283b);
                }
                sb.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb.append(f1283b);
            }
            String[] strArrSplit = str2.split(f1283b);
            int length = strArrSplit.length;
            while (i3 < length) {
                String str5 = strArrSplit[i3];
                sb.append(f1286e);
                sb.append(str5);
                sb.append(f1283b);
                i3++;
            }
            sb.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb.append(" ");
                sb.append(f1283b);
                int length2 = strArr.length;
                while (i3 < length2) {
                    sb.append(strArr[i3]);
                    sb.append(f1283b);
                    i3++;
                }
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static g Z(String str) {
        String strSubstring;
        String strQ;
        String strSubstring2;
        e eVar = f1278a;
        if (eVar.f1301c || eVar.A()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int iU = eVar.u() + 3;
            if (iU >= stackTrace.length) {
                String strB = B(stackTrace[3]);
                if (eVar.f1301c && i.C0(str)) {
                    int iIndexOf = strB.indexOf(46);
                    strSubstring2 = iIndexOf == -1 ? strB : strB.substring(0, iIndexOf);
                } else {
                    strSubstring2 = str;
                }
                return new g(strSubstring2, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[iU];
            String strB2 = B(stackTraceElement);
            if (eVar.f1301c && i.C0(str)) {
                int iIndexOf2 = strB2.indexOf(46);
                strSubstring = iIndexOf2 == -1 ? strB2 : strB2.substring(0, iIndexOf2);
            } else {
                strSubstring = str;
            }
            if (eVar.A()) {
                String name = Thread.currentThread().getName();
                String string = new Formatter().format("%s, %s.%s(%s:%d)", name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), strB2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str2 = " [" + string + "]: ";
                if (eVar.t() <= 1) {
                    return new g(strSubstring, new String[]{string}, str2);
                }
                int iMin = Math.min(eVar.t(), stackTrace.length - iU);
                String[] strArr = new String[iMin];
                strArr[0] = string;
                int length = name.length() + 2;
                String string2 = new Formatter().format("%" + length + "s", "").toString();
                for (int i2 = 1; i2 < iMin; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2 + iU];
                    strArr[i2] = new Formatter().format("%s%s.%s(%s:%d)", string2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), B(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new g(strSubstring, strArr, str2);
            }
            strQ = strSubstring;
        } else {
            strQ = eVar.q();
        }
        return new g(strQ, null, ": ");
    }

    public static void a0(Object... objArr) {
        N(2, f1278a.q(), objArr);
    }

    public static void b0(String str, Object... objArr) {
        N(2, str, objArr);
    }

    public static void c0(Object... objArr) {
        N(5, f1278a.q(), objArr);
    }

    public static void d0(String str, Object... objArr) {
        N(5, str, objArr);
    }

    public static void e0(int i2, String str) {
        N(i2 | 48, f1278a.q(), str);
    }

    public static void f0(int i2, String str, String str2) {
        N(i2 | 48, str, str2);
    }

    public static void g0(String str) {
        N(51, f1278a.q(), str);
    }

    public static void h0(String str, String str2) {
        N(51, str, str2);
    }

    public static void i(Object... objArr) {
        N(7, f1278a.q(), objArr);
    }

    public static void j(String str, Object... objArr) {
        N(7, str, objArr);
    }

    public static boolean k(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!i.r(file.getParentFile())) {
            return false;
        }
        try {
            n(str, str2);
            boolean zCreateNewFile = file.createNewFile();
            if (zCreateNewFile) {
                S(str, str2);
            }
            return zCreateNewFile;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void l(Object... objArr) {
        N(3, f1278a.q(), objArr);
    }

    public static void m(String str, Object... objArr) {
        N(3, str, objArr);
    }

    public static void n(String str, String str2) {
        File[] fileArrListFiles;
        e eVar = f1278a;
        if (eVar.s() > 0 && (fileArrListFiles = new File(str).getParentFile().listFiles(new c())) != null && fileArrListFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (((long) eVar.s()) * 86400000);
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat.parse(u(name)).getTime() <= time) {
                        f1281a.execute(new d(file));
                    }
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void o(Object... objArr) {
        N(6, f1278a.q(), objArr);
    }

    public static void p(String str, Object... objArr) {
        N(6, str, objArr);
    }

    public static void q(int i2, Object obj) {
        N(i2 | 16, f1278a.q(), obj);
    }

    public static void r(int i2, String str, Object obj) {
        N(i2 | 16, str, obj);
    }

    public static void s(Object obj) {
        N(19, f1278a.q(), obj);
    }

    public static void t(String str, Object obj) {
        N(19, str, obj);
    }

    public static String u(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public static String v(int i2, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (i2 == 32) {
            return f.i(obj, 32);
        }
        return i2 == 48 ? f.i(obj, 48) : w(obj);
    }

    public static String w(Object obj) {
        IFormatter iFormatter;
        if (obj == null) {
            return "null";
        }
        SimpleArrayMap<Class, IFormatter> simpleArrayMap = f1277a;
        return (simpleArrayMap.isEmpty() || (iFormatter = simpleArrayMap.get(x(obj))) == null) ? f.h(obj) : iFormatter.a(obj);
    }

    public static Class x(Object obj) {
        String string;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type rawType = genericInterfaces[0];
                while (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                string = rawType.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                string = genericSuperclass.toString();
            }
            if (string.startsWith("class ")) {
                string = string.substring(6);
            } else if (string.startsWith("interface ")) {
                string = string.substring(10);
            }
            try {
                return Class.forName(string);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return cls;
    }

    public static e y() {
        return f1278a;
    }

    public static String z() {
        return A(new Date());
    }
}
