package com.command.core.logwriter;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.NonNull;
import com.command.core.logwriter.LogWriter;
import com.google.common.net.b;
import com.zj.adlib.c25;
import com.zj.adlib.u15;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class LogWriter {
    private static final int BUFFER_SIZE = 32768;
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH";
    private static final String DAY_PATTERN = "yyyy-MM-dd";
    private static final Object INSTANCE_LOCK = new Object();
    private static final String LOG_SUBDIR = "LogWriter";
    private static final String ZIP_SUBDIR = "log_zip";
    private static volatile LogWriter sInstance;
    private final SimpleDateFormat bucketFormat;
    private String currentBucket;
    private BufferedOutputStream currentOut;
    private final SimpleDateFormat dayFormat;
    private volatile EncryptCallback encryptCallback;
    private boolean isPrintLogcat;
    private final SimpleDateFormat lineTimeFormat;
    private volatile File rootDir;
    private final ExecutorService writer = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.zj.adlib.w15
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return LogWriter.lambda$new$0(runnable);
        }
    });
    private final ExecutorService exporter = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.zj.adlib.x15
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return LogWriter.lambda$new$1(runnable);
        }
    });

    public interface EncryptCallback {
        String onEncrypt(String str, String str2);
    }

    public interface ExportCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    public static final class LogRecord {
        private final long eventTimeMillis;
        private final String message;
        private final String mode;

        @NonNull
        public String toString() {
            return "LogRecord{eventTimeMillis=" + this.eventTimeMillis + ", mode='" + this.mode + "', message='" + this.message + "'}";
        }

        private LogRecord(long j, String str, String str2) {
            this.eventTimeMillis = j;
            this.mode = str;
            this.message = str2;
        }
    }

    private LogWriter() {
        Locale locale = Locale.US;
        this.dayFormat = new SimpleDateFormat(DAY_PATTERN, locale);
        this.bucketFormat = new SimpleDateFormat(DATE_PATTERN, locale);
        this.lineTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS", locale);
    }

    private String applyEncryptCallback(String str, String str2) {
        EncryptCallback encryptCallback = this.encryptCallback;
        if (encryptCallback == null) {
            return str2;
        }
        try {
            String strOnEncrypt = encryptCallback.onEncrypt(str, str2);
            return strOnEncrypt == null ? str2 : strOnEncrypt;
        } catch (Throwable unused) {
            return str2;
        }
    }

    private String buildZipName(List<String> list) {
        if (list.size() == 1) {
            return list.get(0) + ".zip";
        }
        return list.get(0) + "_to_" + list.get(list.size() - 1) + ".zip";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeStreamQuietly() {
        BufferedOutputStream bufferedOutputStream = this.currentOut;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.flush();
                this.currentOut.close();
            } catch (IOException unused) {
            } finally {
                this.currentOut = null;
            }
        }
    }

    private List<File> collectLogFiles(File file, List<String> list) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, it.next());
            if (file2.exists() && file2.isDirectory() && (fileArrListFiles = file2.listFiles(new FilenameFilter() { // from class: com.zj.adlib.y15
                @Override // java.io.FilenameFilter
                public final boolean accept(File file3, String str) {
                    return LogWriter.lambda$collectLogFiles$5(file3, str);
                }
            })) != null) {
                for (File file3 : fileArrListFiles) {
                    if (file3 != null && file3.isFile()) {
                        arrayList.add(file3);
                    }
                }
            }
        }
        return arrayList;
    }

    private String encodeExceptionInfo(Throwable th) {
        if (th == null) {
            return "null";
        }
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb = new StringBuilder();
            String localizedMessage = th.getLocalizedMessage();
            sb.append(th.getClass().getName());
            sb.append(": ");
            sb.append(localizedMessage);
            sb.append('\n');
            for (StackTraceElement stackTraceElement : stackTrace) {
                String str = stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + u15.f19942b + stackTraceElement.getLineNumber() + ")";
                sb.append('\t');
                sb.append(str);
                sb.append('\n');
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "exception read error";
        }
    }

    private void ensureOutputStream() throws IOException {
        File file = this.rootDir;
        if (file == null) {
            return;
        }
        Date date = new Date();
        String day = formatDay(date);
        String bucket = formatBucket(date);
        if (this.currentOut == null || !bucket.equals(this.currentBucket)) {
            closeStreamQuietly();
            this.currentBucket = bucket;
            File file2 = new File(file, LOG_SUBDIR);
            if (!file2.exists() && !file2.mkdirs()) {
                this.currentOut = null;
                return;
            }
            File file3 = new File(file2, day);
            if (!file3.exists() && !file3.mkdirs()) {
                this.currentOut = null;
                return;
            }
            this.currentOut = new BufferedOutputStream(new FileOutputStream(new File(file3, bucket + c25.n), true), 32768);
        }
    }

    private String formatBucket(Date date) {
        String str;
        synchronized (this.bucketFormat) {
            str = this.bucketFormat.format(date);
        }
        return str;
    }

    private String formatDay(Date date) {
        String str;
        synchronized (this.dayFormat) {
            str = this.dayFormat.format(date);
        }
        return str;
    }

    private String formatLineTime(long j) {
        String str;
        synchronized (this.lineTimeFormat) {
            str = this.lineTimeFormat.format(new Date(j));
        }
        return str;
    }

    public static LogWriter getInstance() {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new LogWriter();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$collectLogFiles$5(File file, String str) {
        return str.endsWith(c25.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$exportLogsAsync$4(ExportCallback exportCallback, LogExportTimeRange logExportTimeRange) {
        File file = this.rootDir;
        if (file == null) {
            notifyExportError(exportCallback, "Log root directory is null");
            return;
        }
        File file2 = new File(file, LOG_SUBDIR);
        List<String> listResolveExportDays = resolveExportDays(logExportTimeRange);
        if (listResolveExportDays.isEmpty()) {
            notifyExportError(exportCallback, "No valid date found to export");
            return;
        }
        List<File> listCollectLogFiles = collectLogFiles(file2, listResolveExportDays);
        if (listCollectLogFiles.isEmpty()) {
            notifyExportError(exportCallback, "No log files found in selected date range");
            return;
        }
        File file3 = new File(file2, ZIP_SUBDIR);
        if (!file3.exists() && !file3.mkdirs()) {
            notifyExportError(exportCallback, "Failed to create zip directory: " + file3.getAbsolutePath());
            return;
        }
        File file4 = new File(file3, buildZipName(listResolveExportDays));
        if (file4.exists() && file4.isFile() && !file4.delete()) {
            notifyExportError(exportCallback, "Failed to delete old zip: " + file4.getAbsolutePath());
            return;
        }
        try {
            zipFilesWithDayFolder(listCollectLogFiles, file4);
            notifyExportSuccess(exportCallback, file4.getAbsolutePath());
        } catch (IOException e) {
            notifyExportError(exportCallback, "Export logs failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$3() {
        BufferedOutputStream bufferedOutputStream = this.currentOut;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.flush();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "command-core-log-writer");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "command-core-log-exporter");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$output$2(LogRecord logRecord) {
        try {
            if (this.isPrintLogcat) {
                LogUtils.d("LogWriter --> ", logRecord.toString());
            }
            writeLine(logRecord);
        } catch (IOException unused) {
            closeStreamQuietly();
        }
    }

    private static String normalizeOneLine(String str) {
        return str == null ? "" : str.replace('\r', ' ').replace('\n', ' ');
    }

    private void notifyExportError(ExportCallback exportCallback, String str) {
        if (exportCallback != null) {
            exportCallback.onError(str);
        }
    }

    private void notifyExportSuccess(ExportCallback exportCallback, String str) {
        if (exportCallback != null) {
            exportCallback.onSuccess(str);
        }
    }

    private Date parseDay(String str) {
        if (str != null && !str.trim().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAY_PATTERN, Locale.US);
            simpleDateFormat.setLenient(false);
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    private List<String> resolveExportDays(LogExportTimeRange logExportTimeRange) {
        if (logExportTimeRange == null) {
            logExportTimeRange = LogExportTimeRange.builder().build();
        }
        Date day = parseDay(logExportTimeRange.getStartDate());
        Date day2 = parseDay(logExportTimeRange.getEndDate());
        if (day == null && day2 == null) {
            return Collections.singletonList(formatDay(new Date()));
        }
        if (day == null) {
            day = day2;
        }
        if (day2 == null) {
            day2 = day;
        }
        if (day == null || day2 == null) {
            return Collections.emptyList();
        }
        if (day.after(day2)) {
            Date date = day;
            day = day2;
            day2 = date;
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        while (!calendar.getTime().after(day2)) {
            arrayList.add(formatDay(calendar.getTime()));
            calendar.add(5, 1);
        }
        return arrayList;
    }

    private void submitExportTask(Runnable runnable) {
        try {
            this.exporter.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    private void submitTask(Runnable runnable) {
        try {
            this.writer.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    private void writeLine(LogRecord logRecord) throws IOException {
        if (logRecord == null || logRecord.message == null || logRecord.message.isEmpty()) {
            return;
        }
        ensureOutputStream();
        if (this.currentOut == null) {
            return;
        }
        String strNormalizeOneLine = normalizeOneLine(applyEncryptCallback(logRecord.mode, logRecord.message));
        this.currentOut.write(String.format(Locale.US, "[%s]:[%s]: %s", formatLineTime(logRecord.eventTimeMillis), logRecord.mode, strNormalizeOneLine).getBytes(StandardCharsets.UTF_8));
        this.currentOut.write(10);
        this.currentOut.flush();
    }

    private void zipFilesWithDayFolder(List<File> list, File file) throws IOException {
        byte[] bArr = new byte[32768];
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try {
            for (File file2 : list) {
                if (file2 != null && file2.isFile()) {
                    File parentFile = file2.getParentFile();
                    zipOutputStream.putNextEntry(new ZipEntry((parentFile == null ? "unknown_day" : parentFile.getName()) + WVNativeCallbackUtil.SEPERATER + file2.getName()));
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        while (true) {
                            try {
                                int i = fileInputStream2.read(bArr);
                                if (i != -1) {
                                    zipOutputStream.write(bArr, 0, i);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException unused) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                zipOutputStream.closeEntry();
                                throw th;
                            }
                        }
                        fileInputStream2.close();
                        zipOutputStream.closeEntry();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            zipOutputStream.flush();
            zipOutputStream.close();
        } catch (Throwable th3) {
            try {
                zipOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public void exportLogsAsync(final LogExportTimeRange logExportTimeRange, final ExportCallback exportCallback) {
        submitExportTask(new Runnable() { // from class: com.zj.adlib.a25
            @Override // java.lang.Runnable
            public final void run() {
                this.f15144a.lambda$exportLogsAsync$4(exportCallback, logExportTimeRange);
            }
        });
    }

    public void exportTodayLogsAsync(ExportCallback exportCallback) {
        exportLogsAsync(LogExportTimeRange.builder().build(), exportCallback);
    }

    public void flush() {
        submitTask(new Runnable() { // from class: com.zj.adlib.z15
            @Override // java.lang.Runnable
            public final void run() {
                this.f46160a.lambda$flush$3();
            }
        });
    }

    public void init(File file, boolean z) {
        this.rootDir = file;
        this.isPrintLogcat = z;
    }

    public void output(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (str == null) {
            str = "Print";
        }
        final LogRecord logRecord = new LogRecord(jCurrentTimeMillis, str, str3);
        submitTask(new Runnable() { // from class: com.command.core.logwriter.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1486a.lambda$output$2(logRecord);
            }
        });
    }

    public void outputWarning(String str) {
        output(b.g, str);
    }

    public void setEncryptCallback(EncryptCallback encryptCallback) {
        this.encryptCallback = encryptCallback;
    }

    public void shutdown() {
        submitTask(new Runnable() { // from class: com.zj.adlib.v15
            @Override // java.lang.Runnable
            public final void run() {
                this.f45270a.closeStreamQuietly();
            }
        });
        this.writer.shutdown();
        this.exporter.shutdown();
        try {
            ExecutorService executorService = this.writer;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit)) {
                this.writer.shutdownNow();
            }
            if (this.exporter.awaitTermination(5L, timeUnit)) {
                return;
            }
            this.exporter.shutdownNow();
        } catch (InterruptedException unused) {
            this.writer.shutdownNow();
            this.exporter.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void output(String str) {
        output("Print", str);
    }

    public void output(Throwable th) {
        output("Exception", encodeExceptionInfo(th));
    }
}
