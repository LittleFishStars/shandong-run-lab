package com.aliyun.vod.common.logger;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LoggerPrinter implements Printer {
    private static final int ASSERT = 7;
    private static final String BOTTOM_BORDER = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final char BOTTOM_LEFT_CORNER = 9562;
    private static final int CHUNK_SIZE = 4000;
    private static final int DEBUG = 3;
    private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════";
    private static final int ERROR = 6;
    private static final char HORIZONTAL_DOUBLE_LINE = 9553;
    private static final int INFO = 4;
    private static final int JSON_INDENT = 4;
    private static final String MIDDLE_BORDER = "╟────────────────────────────────────────────────────────────────────────────────────────";
    private static final char MIDDLE_CORNER = 9567;
    private static final int MIN_STACK_OFFSET = 3;
    private static final String SINGLE_DIVIDER = "────────────────────────────────────────────";
    private static final String TOP_BORDER = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final char TOP_LEFT_CORNER = 9556;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    private Settings settings;
    private String tag;
    private final ThreadLocal<String> localTag = new ThreadLocal<>();
    private final ThreadLocal<Integer> localMethodCount = new ThreadLocal<>();

    private String createMessage(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private String formatTag(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(this.tag, str)) {
            return this.tag;
        }
        return this.tag + c49.f40900a + str;
    }

    private int getMethodCount() {
        Integer num = this.localMethodCount.get();
        int methodCount = this.settings.getMethodCount();
        if (num != null) {
            this.localMethodCount.remove();
            methodCount = num.intValue();
        }
        if (methodCount >= 0) {
            return methodCount;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    private String getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    private int getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(LoggerPrinter.class.getName()) && !className.equals(Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    private String getTag() {
        String str = this.localTag.get();
        if (str == null) {
            return this.tag;
        }
        this.localTag.remove();
        return str;
    }

    private synchronized void log(int i, String str, Object... objArr) {
        if (this.settings.getLogLevel() == LogLevel.NONE) {
            return;
        }
        String tag = getTag();
        String strCreateMessage = createMessage(str, objArr);
        int methodCount = getMethodCount();
        logTopBorder(i, tag);
        logHeaderContent(i, tag, methodCount);
        byte[] bytes = strCreateMessage.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (methodCount > 0) {
                logDivider(i, tag);
            }
            logContent(i, tag, strCreateMessage);
            logBottomBorder(i, tag);
            return;
        }
        if (methodCount > 0) {
            logDivider(i, tag);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            logContent(i, tag, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        logBottomBorder(i, tag);
    }

    private void logBottomBorder(int i, String str) {
        logChunk(i, str, BOTTOM_BORDER);
    }

    private void logChunk(int i, String str, String str2) {
        String tag = formatTag(str);
        if (i == 2) {
            this.settings.getLogTool().v(tag, str2);
            return;
        }
        if (i == 4) {
            this.settings.getLogTool().i(tag, str2);
            return;
        }
        if (i == 5) {
            this.settings.getLogTool().w(tag, str2);
            return;
        }
        if (i == 6) {
            this.settings.getLogTool().e(tag, str2);
        } else if (i != 7) {
            this.settings.getLogTool().d(tag, str2);
        } else {
            this.settings.getLogTool().wtf(tag, str2);
        }
    }

    private void logContent(int i, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            logChunk(i, str, "║ " + str3);
        }
    }

    private void logDivider(int i, String str) {
        logChunk(i, str, MIDDLE_BORDER);
    }

    private void logHeaderContent(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.settings.isShowThreadInfo()) {
            logChunk(i, str, "║ Thread: " + Thread.currentThread().getName());
            logDivider(i, str);
        }
        int stackOffset = getStackOffset(stackTrace) + this.settings.getMethodOffset();
        if (i2 + stackOffset > stackTrace.length) {
            i2 = (stackTrace.length - stackOffset) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + stackOffset;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                logChunk(i, str, "║ " + str2 + getSimpleClassName(stackTrace[i3].getClassName()) + Consts.DOT + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + u15.f19942b + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    private void logTopBorder(int i, String str) {
        logChunk(i, str, TOP_BORDER);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void clear() {
        this.settings = null;
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void d(String str, Object... objArr) {
        log(3, str, objArr);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void e(Throwable th) {
        e(th, null, new Object[0]);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public Settings getSettings() {
        return this.settings;
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public Settings init(String str) {
        if (str == null) {
            throw new NullPointerException("tag may not be null");
        }
        if (str.trim().length() == 0) {
            throw new IllegalStateException("tag may not be empty");
        }
        this.tag = str;
        Settings settings = new Settings();
        this.settings = settings;
        return settings;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    @Override // com.aliyun.vod.common.logger.Printer
    public void json(String str) {
        if (TextUtils.isEmpty(str)) {
            d("Empty/Null json content", new Object[0]);
            return;
        }
        try {
            if (str.startsWith(bv9.b)) {
                d(new JSONObject(str).toString(4), new Object[0]);
            } else if (str.startsWith("[")) {
                d(new JSONArray(str).toString(4), new Object[0]);
            }
        } catch (JSONException e) {
            e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public Printer t(String str, int i) {
        if (str != null) {
            this.localTag.set(str);
        }
        this.localMethodCount.set(Integer.valueOf(i));
        return this;
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void v(String str, Object... objArr) {
        log(2, str, objArr);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void w(String str, Object... objArr) {
        log(5, str, objArr);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void wtf(String str, Object... objArr) {
        log(7, str, objArr);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void xml(String str) {
        if (TextUtils.isEmpty(str)) {
            d("Empty/Null xml content", new Object[0]);
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"), new Object[0]);
        } catch (TransformerException e) {
            e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void e(String str, Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.aliyun.vod.common.logger.Printer
    public void e(Throwable th, String str, Object... objArr) {
        if (th != null && str != null) {
            str = str + " : " + th.toString();
        }
        if (th != null && str == null) {
            str = th.toString();
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        log(6, str, objArr);
    }
}
