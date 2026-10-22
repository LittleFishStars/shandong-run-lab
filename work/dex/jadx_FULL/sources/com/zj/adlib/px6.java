package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.blankj.utilcode.util.LogUtils;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class px6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f44079a = 9484;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f18951a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f18952a = "────────────────────────────────────────────────────────";
    public static final char b = 9492;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f18953b = 4000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f18954b = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final char c = 9500;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static int f18955c = 4;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f18956c = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final char d = 9474;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f18957d = 0;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f18958d = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final int e = 5;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f18959e = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f18961a = true;
        public boolean b = true;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<String> f18960a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public StackTraceElement[] f18962a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String[] f18963a = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f44080a = null;

        public a a(String str) {
            if (str == null) {
                return this;
            }
            this.f18960a.add(px6.d(str));
            return this;
        }

        public a b(String str) {
            this.f18960a.add(str);
            return this;
        }

        public a c(Object obj) {
            b(obj == null ? "null" : obj.toString());
            return this;
        }

        public a d(String str) {
            if (str == null) {
                return this;
            }
            this.f18960a.add(px6.e(str));
            return this;
        }

        public List<String> e() {
            ArrayList arrayList = new ArrayList();
            String[] strArrF = this.f18963a;
            if (strArrF == null) {
                StackTraceElement[] stackTraceElementArr = this.f18962a;
                strArrF = stackTraceElementArr != null ? px6.f(stackTraceElementArr) : px6.f(Thread.currentThread().getStackTrace());
            }
            arrayList.add("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            if (this.f18961a) {
                StringBuilder sb = new StringBuilder();
                sb.append("│ Thread: ");
                sb.append(TextUtils.isEmpty(this.f44080a) ? Thread.currentThread().getName() : this.f44080a);
                arrayList.add(sb.toString());
                arrayList.add("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
            if (this.b) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : strArrF) {
                    sb2.append("   ");
                    arrayList.add(String.valueOf(px6.d) + ' ' + sb2.toString() + str);
                }
                arrayList.add("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
            Iterator<String> it = this.f18960a.iterator();
            while (it.hasNext()) {
                for (String str2 : it.next().split("\n")) {
                    if (!TextUtils.isEmpty(str2)) {
                        byte[] bytes = str2.getBytes();
                        int length = bytes.length;
                        if (length <= 4000) {
                            arrayList.add(LogUtils.f1286e + str2);
                        } else {
                            for (int i = 0; i < length; i += 4000) {
                                arrayList.add(LogUtils.f1286e + new String(bytes, i, Math.min(length - i, 4000)));
                            }
                        }
                    }
                }
                arrayList.add("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
            arrayList.set(arrayList.size() - 1, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            return arrayList;
        }

        public String f() {
            List<String> listE = e();
            StringBuilder sb = new StringBuilder(":\n");
            for (String str : listE) {
                sb.append("\t");
                sb.append(str);
                sb.append("\n");
            }
            return sb.toString();
        }

        public a g(boolean z) {
            this.b = z;
            return this;
        }

        public a h(boolean z) {
            this.f18961a = z;
            return this;
        }

        public a i(StackTraceElement[] stackTraceElementArr) {
            this.f18962a = stackTraceElementArr;
            return this;
        }

        public a j(String[] strArr) {
            this.f18963a = strArr;
            return this;
        }

        public a k(String str) {
            this.f44080a = str;
            return this;
        }
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static String b(@NonNull String str) {
        a(str);
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    public static int c(@NonNull StackTraceElement[] stackTraceElementArr) {
        a(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(c25.class.getName()) && !className.equals(c25.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "Empty/Null json content";
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith(bv9.b)) {
                return new JSONObject(strTrim).toString(2);
            }
            if (strTrim.startsWith("[")) {
                return new JSONArray(strTrim).toString(2);
            }
            return "Invalid Json";
        } catch (JSONException unused) {
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "Empty/Null xml content";
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">\n");
        } catch (TransformerException unused) {
            return "Invalid xml";
        }
    }

    public static String[] f(StackTraceElement[] stackTraceElementArr) {
        int iC = c(stackTraceElementArr) + 0;
        if (f18955c + iC > stackTraceElementArr.length) {
            f18955c = (stackTraceElementArr.length - iC) - 1;
        }
        int i = f18955c;
        String[] strArr = new String[i];
        while (i > 0) {
            int i2 = i + iC;
            if (i2 < stackTraceElementArr.length) {
                strArr[f18955c - i] = b(stackTraceElementArr[i2].getClassName()) + Consts.DOT + stackTraceElementArr[i2].getMethodName() + "  (" + stackTraceElementArr[i2].getFileName() + u15.f19942b + stackTraceElementArr[i2].getLineNumber() + ")";
            }
            i--;
        }
        return strArr;
    }
}
