package com.getui.gtc.base.log.c;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.getui.gtc.base.log.ILogDestination;
import com.getui.gtc.base.log.ILogFormatter;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements ILogFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30286a;
    public int b;
    private ILogDestination c;

    public b() {
        this(new com.getui.gtc.base.log.b.b());
    }

    public b(ILogDestination iLogDestination) {
        this.f30286a = "";
        this.b = 8;
        this.c = (ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
    }

    private String a() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            return String.format("%s.%s", className.substring(className.lastIndexOf(Consts.DOT) + 1), stackTraceElement.getMethodName());
        } catch (Throwable unused) {
            return "";
        }
    }

    private String a(String str, Throwable th) {
        if (th != null && str != null) {
            str = str + " : " + a(th);
        }
        if (th != null && str == null) {
            str = a(th);
        }
        if (TextUtils.isEmpty(str)) {
            str = "Empty/NULL log message";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith(bv9.b) && strTrim.endsWith("}")) {
            try {
                strTrim = new JSONObject(strTrim).toString(2);
            } catch (Throwable unused) {
            }
        }
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            try {
                strTrim = new JSONArray(strTrim).toString(2);
            } catch (Throwable unused2) {
            }
        }
        String strB = b();
        if (th != null) {
            return strTrim;
        }
        return strTrim + " " + strB;
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter((OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }

    private String b() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            return String.format("(%s:%d)", className.substring(className.lastIndexOf(Consts.DOT) + 1) + ".java", Integer.valueOf(stackTraceElement.getLineNumber()));
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.getui.gtc.base.log.ILogFormatter
    public final void log(int i, String str, String str2, Throwable th) {
        String strA = a();
        if (TextUtils.isEmpty(str)) {
            str = this.f30286a;
        }
        if (!TextUtils.isEmpty(str)) {
            strA = str + c49.f40900a + strA;
        }
        this.c.log(i, strA, a(str2, th));
    }
}
