package com.aliyun.tea.logging;

import com.aliyun.tea.utils.StringUtils;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClientLogger {
    private static final Pattern CRLF_PATTERN = Pattern.compile("[\r\n]");
    private final Logger logger;

    /* JADX INFO: renamed from: com.aliyun.tea.logging.ClientLogger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$tea$logging$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$aliyun$tea$logging$LogLevel = iArr;
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$tea$logging$LogLevel[LogLevel.INFORMATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$tea$logging$LogLevel[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$tea$logging$LogLevel[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ClientLogger(Class<?> cls) {
        this(cls.getName());
    }

    private boolean doesArgsHaveThrowable(Object... objArr) {
        if (objArr.length == 0) {
            return false;
        }
        return objArr[objArr.length - 1] instanceof Throwable;
    }

    private void performLogging(LogLevel logLevel, boolean z, String str, Object... objArr) {
        String message = "";
        if (doesArgsHaveThrowable(objArr)) {
            if (!z) {
                Object obj = objArr[objArr.length - 1];
                if (obj instanceof Throwable) {
                    message = ((Throwable) obj).getMessage();
                }
            }
            if (!this.logger.isDebugEnabled()) {
                objArr = removeThrowable(objArr);
            }
        }
        sanitizeLogMessageInput(str);
        int i = AnonymousClass1.$SwitchMap$com$aliyun$tea$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            this.logger.debug(str, objArr);
            return;
        }
        if (i == 2) {
            this.logger.info(str, objArr);
            return;
        }
        if (i == 3) {
            if (!StringUtils.isEmpty((CharSequence) message)) {
                str = str + System.lineSeparator() + message;
            }
            this.logger.warn(str, objArr);
            return;
        }
        if (i != 4) {
            return;
        }
        if (!StringUtils.isEmpty((CharSequence) message)) {
            str = str + System.lineSeparator() + message;
        }
        this.logger.error(str, objArr);
    }

    private Object[] removeThrowable(Object... objArr) {
        return Arrays.copyOf(objArr, objArr.length - 1);
    }

    private static String sanitizeLogMessageInput(String str) {
        return StringUtils.isEmpty((CharSequence) str) ? str : CRLF_PATTERN.matcher(str).replaceAll("");
    }

    public boolean canLogAtLevel(LogLevel logLevel) {
        if (logLevel == null) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$aliyun$tea$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            return this.logger.isDebugEnabled();
        }
        if (i == 2) {
            return this.logger.isInfoEnabled();
        }
        if (i == 3) {
            return this.logger.isWarnEnabled();
        }
        if (i != 4) {
            return false;
        }
        return this.logger.isErrorEnabled();
    }

    public void error(String str) {
        if (this.logger.isErrorEnabled()) {
            this.logger.error(sanitizeLogMessageInput(str));
        }
    }

    public void info(String str) {
        if (this.logger.isInfoEnabled()) {
            this.logger.info(sanitizeLogMessageInput(str));
        }
    }

    public RuntimeException logExceptionAsError(RuntimeException runtimeException) {
        Objects.requireNonNull(runtimeException, "'runtimeException' cannot be null.");
        return (RuntimeException) logThrowableAsError(runtimeException);
    }

    public RuntimeException logExceptionAsWarning(RuntimeException runtimeException) {
        Objects.requireNonNull(runtimeException, "'runtimeException' cannot be null.");
        return (RuntimeException) logThrowableAsWarning(runtimeException);
    }

    public <T extends Throwable> T logThrowableAsError(T t) {
        Objects.requireNonNull(t, "'throwable' cannot be null.");
        if (!this.logger.isErrorEnabled()) {
            return t;
        }
        performLogging(LogLevel.ERROR, true, t.getMessage(), t);
        return t;
    }

    public <T extends Throwable> T logThrowableAsWarning(T t) {
        Objects.requireNonNull(t, "'throwable' cannot be null.");
        if (!this.logger.isWarnEnabled()) {
            return t;
        }
        performLogging(LogLevel.WARNING, true, t.getMessage(), t);
        return t;
    }

    public void verbose(String str) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug(sanitizeLogMessageInput(str));
        }
    }

    public void warning(String str) {
        if (this.logger.isWarnEnabled()) {
            this.logger.warn(sanitizeLogMessageInput(str));
        }
    }

    public ClientLogger(String str) {
        DefaultLogger logger = LoggerFactory.getLogger(str);
        this.logger = logger instanceof NOPLogger ? new DefaultLogger(str) : logger;
    }

    public void error(String str, Object... objArr) {
        if (this.logger.isErrorEnabled()) {
            performLogging(LogLevel.ERROR, false, str, objArr);
        }
    }

    public void info(String str, Object... objArr) {
        if (this.logger.isInfoEnabled()) {
            performLogging(LogLevel.INFORMATIONAL, false, str, objArr);
        }
    }

    public void verbose(String str, Object... objArr) {
        if (this.logger.isDebugEnabled()) {
            performLogging(LogLevel.VERBOSE, false, str, objArr);
        }
    }

    public void warning(String str, Object... objArr) {
        if (this.logger.isWarnEnabled()) {
            performLogging(LogLevel.WARNING, false, str, objArr);
        }
    }
}
