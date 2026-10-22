package com.getui.gtc.base.log;

import android.content.Context;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.a.a;
import com.getui.gtc.base.log.a.b;
import com.getui.gtc.base.util.CommonUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Logger {
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;
    private a fileLogController;
    private com.getui.gtc.base.log.b.a fileLogDestination;
    private com.getui.gtc.base.log.c.a fileLogFormatter;
    private final com.getui.gtc.base.log.d.a logPrinter;
    private final b logcatLogController;
    private final com.getui.gtc.base.log.c.b logcatLogFormatter;

    public Logger() {
        this(null);
    }

    public Logger(Context context) {
        com.getui.gtc.base.log.d.b bVar = new com.getui.gtc.base.log.d.b();
        this.logPrinter = bVar;
        if (context != null) {
            GtcProvider.setContext(context);
        }
        Context context2 = GtcProvider.context();
        context2 = context2 == null ? CommonUtil.findAppContext() : context2;
        if (context2 != null) {
            com.getui.gtc.base.log.b.a aVar = new com.getui.gtc.base.log.b.a(context2);
            this.fileLogDestination = aVar;
            com.getui.gtc.base.log.c.a aVar2 = new com.getui.gtc.base.log.c.a(aVar);
            this.fileLogFormatter = aVar2;
            a aVar3 = new a(context2, aVar2);
            this.fileLogController = aVar3;
            bVar.a(aVar3);
        }
        com.getui.gtc.base.log.c.b bVar2 = new com.getui.gtc.base.log.c.b(new com.getui.gtc.base.log.b.b());
        this.logcatLogFormatter = bVar2;
        b bVar3 = new b(bVar2);
        this.logcatLogController = bVar3;
        bVar.a(bVar3);
    }

    public void addController(ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.logPrinter.a(iLogController);
    }

    public void d(String str) {
        this.logPrinter.a(2, null, str, null);
    }

    public void d(String str, String str2) {
        this.logPrinter.a(2, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        this.logPrinter.a(2, str, str2, th);
    }

    public void d(String str, Throwable th) {
        this.logPrinter.a(2, str, null, th);
    }

    public void d(Throwable th) {
        this.logPrinter.a(2, null, null, th);
    }

    public void e(String str) {
        this.logPrinter.a(5, null, str, null);
    }

    public void e(String str, String str2) {
        this.logPrinter.a(5, str, str2, null);
    }

    public void e(String str, String str2, Throwable th) {
        this.logPrinter.a(5, str, str2, th);
    }

    public void e(String str, Throwable th) {
        this.logPrinter.a(5, null, str, th);
    }

    public void e(Throwable th) {
        this.logPrinter.a(5, null, null, th);
    }

    public void filelog(int i, String str, String str2, Throwable th) {
        this.logPrinter.a(i | 32, str, str2, th);
    }

    public void i(String str) {
        this.logPrinter.a(3, null, str, null);
    }

    public void i(String str, String str2) {
        this.logPrinter.a(3, str, str2, null);
    }

    public void i(String str, String str2, Throwable th) {
        this.logPrinter.a(3, str, str2, th);
    }

    public void i(String str, Throwable th) {
        this.logPrinter.a(3, str, null, th);
    }

    public void i(Throwable th) {
        this.logPrinter.a(3, null, null, th);
    }

    public void logcat(int i, String str, String str2, Throwable th) {
        this.logPrinter.a(i | 16, str, str2, th);
    }

    public void removeController(ILogController iLogController) {
        this.logPrinter.b(iLogController);
    }

    public void setFileEnableProperty(String str) {
        a aVar = this.fileLogController;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setGlobalTag(String str) {
        this.logcatLogFormatter.f30286a = str;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.f30285a = str;
        }
    }

    public void setLogFileNameSuffix(String str) {
        com.getui.gtc.base.log.b.a aVar = this.fileLogDestination;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setLogcatEnable(boolean z) {
        this.logcatLogController.f30282a = z;
    }

    public void setStackOffset(int i) {
        int i2 = i + 8;
        this.logcatLogFormatter.b = i2;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.b = i2;
        }
    }

    public void v(String str) {
        this.logPrinter.a(1, null, str, null);
    }

    public void v(String str, String str2) {
        this.logPrinter.a(1, str, str2, null);
    }

    public void v(String str, String str2, Throwable th) {
        this.logPrinter.a(1, str, str2, th);
    }

    public void v(String str, Throwable th) {
        this.logPrinter.a(1, str, null, th);
    }

    public void v(Throwable th) {
        this.logPrinter.a(1, null, null, th);
    }

    public void w(String str) {
        this.logPrinter.a(4, null, str, null);
    }

    public void w(String str, String str2) {
        this.logPrinter.a(4, str, str2, null);
    }

    public void w(String str, String str2, Throwable th) {
        this.logPrinter.a(4, str, str2, th);
    }

    public void w(String str, Throwable th) {
        this.logPrinter.a(4, null, str, th);
    }

    public void w(Throwable th) {
        this.logPrinter.a(4, null, null, th);
    }
}
