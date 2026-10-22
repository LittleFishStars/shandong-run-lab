package android.taobao.windvane.base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface ILogService {

    public enum LogLevelEnum {
        VERBOSE(0, "V"),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, "W"),
        ERROR(4, "E");

        private int LogLevel;
        private String LogLevelName;

        LogLevelEnum(int i, String str) {
            this.LogLevelName = str;
            this.LogLevel = i;
        }

        public int getLogLevel() {
            return this.LogLevel;
        }

        public String getLogLevelName() {
            return this.LogLevelName;
        }
    }

    void a(String str, String str2);

    void a(String str, String str2, Throwable th);

    boolean a(int i);

    void b(String str, String str2);

    void b(String str, String str2, Throwable th);

    void c(String str, String str2);

    void c(String str, String str2, Throwable th);

    void d(String str, String str2);

    void d(String str, String str2, Throwable th);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);
}
