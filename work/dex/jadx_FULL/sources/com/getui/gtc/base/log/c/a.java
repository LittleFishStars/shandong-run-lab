package com.getui.gtc.base.log.c;

import android.os.Process;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.getui.gtc.base.log.ILogDestination;
import com.getui.gtc.base.log.ILogFormatter;
import com.getui.gtc.base.util.CommonUtil;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements ILogFormatter {
    private final ILogDestination c;
    private String e;
    private final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30285a = "";
    public int b = 8;

    public a(ILogDestination iLogDestination) {
        this.e = "";
        this.c = (ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
        this.e = CommonUtil.getProcessName();
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
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.format(new Date()));
        sb.append(" ");
        sb.append(Process.myPid());
        sb.append(WVNativeCallbackUtil.SEPERATER);
        sb.append(this.e);
        sb.append(" ");
        if (i == 1) {
            str3 = "V";
        } else if (i == 2) {
            str3 = "D";
        } else if (i == 3) {
            str3 = "I";
        } else if (i != 4) {
            str3 = i != 5 ? "?" : "E";
        } else {
            str3 = "W";
        }
        sb.append(str3);
        sb.append(WVNativeCallbackUtil.SEPERATER);
        String strA = a();
        String str4 = TextUtils.isEmpty(str) ? this.f30285a : str;
        if (!TextUtils.isEmpty(str4)) {
            strA = str4 + c49.f40900a + strA;
        }
        sb.append(strA);
        sb.append(": ");
        sb.append(a(str2, th));
        String string = sb.toString();
        if (!string.endsWith("\n")) {
            string = string + "\n";
        }
        this.c.log(i, str, string);
    }
}
