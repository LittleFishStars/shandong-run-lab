package com.aliyun.tea.logging;

import com.aliyun.tea.utils.StringUtils;
import com.zj.adlib.c25;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class DefaultLogger extends MarkerIgnoringBase {
    private static final String CLOSE_BRACKET = "]";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(c25.o);
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    private static final String HYPHEN = " - ";
    public static final String INFO = "INFO";
    private static final String OPEN_BRACKET = " [";
    public static final String SDK_LOG_LEVEL = "ALIBABA_CLOUD_SDK_LOG_LEVEL";
    public static final String TRACE = "TRACE";
    public static final String WARN = "WARN";
    private static final String WHITESPACE = " ";
    private final String classPath;
    private final boolean isDebugEnabled;
    private final boolean isErrorEnabled;
    private final boolean isInfoEnabled;
    private final boolean isTraceEnabled;
    private final boolean isWarnEnabled;

    public DefaultLogger(Class<?> cls) {
        this(cls.getName());
    }

    private String getFormattedDate() {
        return DATE_FORMAT.format(new Date());
    }

    private String loadFromEnvironment(String str) {
        return !StringUtils.isEmpty((CharSequence) System.getenv(str)) ? System.getenv(str) : System.getProperty(str);
    }

    private void log(String str, String str2, Throwable th) {
        String formattedDate = getFormattedDate();
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(formattedDate);
        sb.append(OPEN_BRACKET);
        sb.append(name);
        sb.append(CLOSE_BRACKET);
        sb.append(OPEN_BRACKET);
        sb.append(str);
        sb.append(CLOSE_BRACKET);
        sb.append(" ");
        sb.append(this.classPath);
        sb.append(HYPHEN);
        sb.append(str2);
        sb.append(System.lineSeparator());
        writeWithThrowable(sb, th);
    }

    private void logMessageWithFormat(String str, String str2, Object... objArr) {
        FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str2, objArr);
        log(str, formattingTupleArrayFormat.getMessage(), formattingTupleArrayFormat.getThrowable());
    }

    public void debug(String str) {
        logMessageWithFormat(DEBUG, str, new Object[0]);
    }

    public void error(String str, Object obj) {
        logMessageWithFormat(ERROR, str, obj);
    }

    public String getName() {
        return this.classPath;
    }

    public void info(String str) {
        logMessageWithFormat("INFO", str, new Object[0]);
    }

    public boolean isDebugEnabled() {
        return this.isDebugEnabled;
    }

    public boolean isErrorEnabled() {
        return this.isErrorEnabled;
    }

    public boolean isInfoEnabled() {
        return this.isInfoEnabled;
    }

    public boolean isTraceEnabled() {
        return this.isTraceEnabled;
    }

    public boolean isWarnEnabled() {
        return this.isWarnEnabled;
    }

    public void trace(String str) {
        if (isTraceEnabled()) {
            logMessageWithFormat(TRACE, str, new Object[0]);
        }
    }

    public void warn(String str) {
        logMessageWithFormat(WARN, str, new Object[0]);
    }

    public void writeWithThrowable(StringBuilder sb, Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                sb.append(stringWriter.toString());
                printWriter.close();
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        printWriter.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        }
        System.out.print(sb.toString());
    }

    public DefaultLogger(String str) {
        try {
            str = Class.forName(str).getCanonicalName();
        } catch (ClassNotFoundException unused) {
        }
        this.classPath = str;
        int logLevel = LogLevel.fromString(!StringUtils.isEmpty((CharSequence) loadFromEnvironment(SDK_LOG_LEVEL)) ? loadFromEnvironment(SDK_LOG_LEVEL) : WARN).getLogLevel();
        LogLevel logLevel2 = LogLevel.VERBOSE;
        this.isTraceEnabled = logLevel2.getLogLevel() > logLevel;
        this.isDebugEnabled = logLevel2.getLogLevel() >= logLevel;
        this.isInfoEnabled = LogLevel.INFORMATIONAL.getLogLevel() >= logLevel;
        this.isWarnEnabled = LogLevel.WARNING.getLogLevel() >= logLevel;
        this.isErrorEnabled = LogLevel.ERROR.getLogLevel() >= logLevel;
    }

    public void debug(String str, Object obj) {
        logMessageWithFormat(DEBUG, str, obj);
    }

    public void error(String str) {
        logMessageWithFormat(ERROR, str, new Object[0]);
    }

    public void info(String str, Object obj) {
        logMessageWithFormat("INFO", str, obj);
    }

    public void warn(String str, Object obj) {
        logMessageWithFormat(WARN, str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        logMessageWithFormat(DEBUG, str, obj, obj2);
    }

    public void error(String str, Object obj, Object obj2) {
        logMessageWithFormat(ERROR, str, obj, obj2);
    }

    public void info(String str, Object obj, Object obj2) {
        logMessageWithFormat("INFO", str, obj, obj2);
    }

    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            logMessageWithFormat(TRACE, str, obj);
        }
    }

    public void warn(String str, Object obj, Object obj2) {
        logMessageWithFormat(WARN, str, obj, obj2);
    }

    public void debug(String str, Object... objArr) {
        logMessageWithFormat(DEBUG, str, objArr);
    }

    public void error(String str, Object... objArr) {
        logMessageWithFormat(ERROR, str, objArr);
    }

    public void info(String str, Object... objArr) {
        logMessageWithFormat("INFO", str, objArr);
    }

    public void warn(String str, Object... objArr) {
        logMessageWithFormat(WARN, str, objArr);
    }

    public void debug(String str, Throwable th) {
        log(DEBUG, str, th);
    }

    public void error(String str, Throwable th) {
        log(ERROR, str, th);
    }

    public void info(String str, Throwable th) {
        log("INFO", str, th);
    }

    public void trace(String str, Object obj, Object obj2) {
        logMessageWithFormat(TRACE, str, obj, obj2);
    }

    public void warn(String str, Throwable th) {
        log(WARN, str, th);
    }

    public void trace(String str, Object... objArr) {
        logMessageWithFormat(TRACE, str, objArr);
    }

    public void trace(String str, Throwable th) {
        log(TRACE, str, th);
    }
}
