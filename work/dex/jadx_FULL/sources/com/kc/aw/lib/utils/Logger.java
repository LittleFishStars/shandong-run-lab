package com.kc.aw.lib.utils;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Logger {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final LogDispatcher dispatcher;
    private static boolean isDebug;

    @Keep
    public interface DispatchCallback {
        void onDispatch();
    }

    @Keep
    public interface ILogger {
        public static final String TAG = "PTG_AD_LOG";

        void d(LogMessage logMessage);

        void e(LogMessage logMessage);

        boolean enable();

        void i(LogMessage logMessage);

        void setLoggerOutput(Class cls);

        void w(LogMessage logMessage);
    }

    @Keep
    public static class LogDispatcher {
        private static DispatchCallback dispatchCallback;
        private static final Set<ILogger> allReceivers = new HashSet();
        private static final Executor dispatcher = Executors.newSingleThreadExecutor();

        public static void addLogReceiver(ILogger iLogger) {
            if (iLogger != null) {
                Set<ILogger> set = allReceivers;
                synchronized (set) {
                    set.add(iLogger);
                }
            }
        }

        public static void setDispatchCallback(DispatchCallback dispatchCallback2) {
            dispatchCallback = dispatchCallback2;
        }

        public void dispatch(LoggerExecutor loggerExecutor) {
            dispatcher.execute(new Runnable(this, loggerExecutor) { // from class: com.kc.aw.lib.utils.Logger.LogDispatcher.1
                public final LogDispatcher this$0;
                public final LoggerExecutor val$execute;

                {
                    this.this$0 = this;
                    this.val$execute = loggerExecutor;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (LogDispatcher.dispatchCallback != null) {
                        LogDispatcher.dispatchCallback.onDispatch();
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (LogDispatcher.allReceivers) {
                        arrayList.addAll(LogDispatcher.allReceivers);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            this.val$execute.onExecute((ILogger) it.next());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Keep
    public static class LogMessage {
        public Object context;
        public Object[] ext;
        public String message;
        public String tag;
        public Throwable throwable;

        public LogMessage setExt(Object... objArr) {
            this.ext = objArr;
            return this;
        }

        public LogMessage setMessage(String str) {
            this.message = str;
            return this;
        }

        public LogMessage setTag(String str) {
            this.tag = str;
            return this;
        }

        public LogMessage setThrowable(Throwable th) {
            this.throwable = th;
            return this;
        }

        public LogMessage with(Object obj) {
            this.context = obj;
            return this;
        }
    }

    @Keep
    public interface LoggerExecutor {
        void onExecute(ILogger iLogger);
    }

    @Keep
    public static class PlainLogger implements ILogger {
        private String defaultTag;

        public PlainLogger(String str) {
            this.defaultTag = str;
        }

        private String buildExt(Object... objArr) {
            String str;
            StringBuilder sb = new StringBuilder();
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (sb.length() == 0) {
                        sb.append("\n");
                        str = "EXT = [ ";
                    } else {
                        str = " , ";
                    }
                    sb.append(str);
                    sb.append(obj);
                }
                if (sb.length() > 0) {
                    sb.append(" ]\n");
                }
            }
            return sb.toString();
        }

        private String buildThrowable(Throwable th) {
            StringBuilder sb = new StringBuilder();
            if (th != null) {
                sb.append("\n");
                sb.append(th.getMessage());
                sb.append("\n");
            }
            return sb.toString();
        }

        private String getTag(String str) {
            return TextUtils.isEmpty(str) ? this.defaultTag : str;
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public void d(LogMessage logMessage) {
            try {
                Log.d(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public void e(LogMessage logMessage) {
            try {
                Log.e(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public boolean enable() {
            return true;
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public void i(LogMessage logMessage) {
            try {
                Log.i(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public void setLoggerOutput(Class cls) {
        }

        @Override // com.kc.aw.lib.utils.Logger.ILogger
        public void w(LogMessage logMessage) {
            try {
                Log.w(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }
    }

    static {
        LogDispatcher logDispatcher = new LogDispatcher();
        dispatcher = logDispatcher;
        logDispatcher.dispatch(new LoggerExecutor() { // from class: com.kc.aw.lib.utils.Logger.1
            @Override // com.kc.aw.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.setLoggerOutput(Logger.class);
            }
        });
    }

    private static LogMessage createDefault() {
        return new LogMessage();
    }

    public static LogMessage d(String str) {
        return d(null, str);
    }

    public static LogMessage d(String str, String str2) {
        return d(str, str2, new Object[0]);
    }

    public static LogMessage d(String str, String str2, Object... objArr) {
        if (!isDebug) {
            return createDefault();
        }
        LogMessage ext = new LogMessage().setTag(getTag(str)).setMessage(str2).setExt(objArr);
        dispatcher.dispatch(new LoggerExecutor(ext) { // from class: com.kc.aw.lib.utils.Logger.3
            public final LogMessage val$logMessage;

            {
                this.val$logMessage = ext;
            }

            @Override // com.kc.aw.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.d(this.val$logMessage);
            }
        });
        return ext;
    }

    public static LogMessage e(String str) {
        return e((String) null, str);
    }

    public static LogMessage e(String str, String str2) {
        return e(str, str2, null);
    }

    public static LogMessage e(String str, String str2, Throwable th) {
        if (!isDebug) {
            return createDefault();
        }
        LogMessage throwable = new LogMessage().setTag(getTag(str)).setMessage(str2).setThrowable(th);
        dispatcher.dispatch(new LoggerExecutor(throwable) { // from class: com.kc.aw.lib.utils.Logger.4
            public final LogMessage val$logMessage;

            {
                this.val$logMessage = throwable;
            }

            @Override // com.kc.aw.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.e(this.val$logMessage);
            }
        });
        return throwable;
    }

    public static LogMessage e(String str, Throwable th) {
        return e(null, str, th);
    }

    private static String getTag() {
        return getTag(null);
    }

    private static String getTag(String str) {
        return TextUtils.isEmpty(str) ? ILogger.TAG : str;
    }

    public static LogMessage i(String str) {
        return i(null, str);
    }

    public static LogMessage i(String str, String str2) {
        if (!isDebug) {
            return createDefault();
        }
        LogMessage message = new LogMessage().setTag(getTag(str)).setMessage(str2);
        dispatcher.dispatch(new LoggerExecutor(message) { // from class: com.kc.aw.lib.utils.Logger.2
            public final LogMessage val$logMessage;

            {
                this.val$logMessage = message;
            }

            @Override // com.kc.aw.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.i(this.val$logMessage);
            }
        });
        return message;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void logLongMessage(String str, String str2) {
        if (str2.length() <= 4000) {
            Log.d(str, str2);
            return;
        }
        int length = str2.length() / 4000;
        int i = 0;
        while (i <= length) {
            int i2 = i * 4000;
            i++;
            int iMin = Math.min(i * 4000, str2.length());
            if (i2 < iMin) {
                Log.d(str, "[" + i + WVNativeCallbackUtil.SEPERATER + (length + 1) + "] " + str2.substring(i2, iMin));
            }
        }
    }

    public static void openDebug() {
        isDebug = true;
    }
}
