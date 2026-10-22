package cn.hzjizhun.admin.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ShellUtils {
    public static final String COMMAND_EXIT = "exit\n";
    public static final String COMMAND_LINE_END = "\n";
    public static final String COMMAND_SH = "sh";
    public static final String COMMAND_SU = "su";
    private static final long DEFAULT_TIMEOUT_MS = 10000;

    private ShellUtils() {
    }

    public static boolean checkRootPermission() {
        return execCommand("echo root", true, false).result == 0;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static CommandResult execCommand(String str, boolean z) {
        return execCommand(new String[]{str}, z, true);
    }

    private static String readStream(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        closeQuietly(bufferedReader);
                        return string;
                    }
                    sb.append(line);
                }
            } catch (IOException e) {
                e = e;
                try {
                    ALog.e("", "readStream error: " + e.getMessage());
                    closeQuietly(bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    bufferedReader = bufferedReader2;
                    closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(bufferedReader);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    private static int waitForWithTimeout(Process process, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return process.exitValue();
        } catch (IllegalThreadStateException unused) {
            do {
                try {
                    Thread.sleep(50L);
                    try {
                        return process.exitValue();
                    } catch (IllegalThreadStateException unused2) {
                    }
                } catch (InterruptedException unused3) {
                    Thread.currentThread().interrupt();
                    process.destroy();
                    return -1;
                }
            } while (System.currentTimeMillis() - jCurrentTimeMillis < j);
            process.destroy();
            return -2;
        }
    }

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i) {
            this.result = i;
        }

        public CommandResult(int i, String str, String str2) {
            this.result = i;
            this.successMsg = str;
            this.errorMsg = str2;
        }
    }

    public static CommandResult execCommand(List<String> list, boolean z) {
        return execCommand(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCommand(String[] strArr, boolean z) {
        return execCommand(strArr, z, true);
    }

    public static CommandResult execCommand(String str, boolean z, boolean z2) {
        return execCommand(new String[]{str}, z, z2);
    }

    public static CommandResult execCommand(List<String> list, boolean z, boolean z2) {
        return execCommand(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    public static CommandResult execCommand(String[] strArr, boolean z, boolean z2) {
        return execCommand(strArr, z, z2, 10000L);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[DONT_GENERATE] */
    public static CommandResult execCommand(String[] strArr, boolean z, boolean z2, long j) {
        Process processExec;
        DataOutputStream dataOutputStream;
        String stream;
        String stream2;
        if (strArr != null && strArr.length != 0) {
            try {
                processExec = Runtime.getRuntime().exec(z ? "su" : COMMAND_SH);
                try {
                    dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                    try {
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                dataOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                                dataOutputStream.writeBytes("\n");
                                dataOutputStream.flush();
                            }
                        }
                        dataOutputStream.writeBytes(COMMAND_EXIT);
                        dataOutputStream.flush();
                        int iWaitForWithTimeout = waitForWithTimeout(processExec, j);
                        if (z2) {
                            stream = readStream(processExec.getInputStream());
                            stream2 = readStream(processExec.getErrorStream());
                        } else {
                            stream = null;
                            stream2 = null;
                        }
                        CommandResult commandResult = new CommandResult(iWaitForWithTimeout, stream, stream2);
                        closeQuietly(dataOutputStream);
                        closeQuietly(null);
                        closeQuietly(null);
                        processExec.destroy();
                        return commandResult;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            ALog.innerE("", "execCommand IOException: " + th.getMessage());
                            return new CommandResult(-1, null, th.getMessage());
                        } finally {
                            closeQuietly(dataOutputStream);
                            closeQuietly(null);
                            closeQuietly(null);
                            if (processExec != null) {
                                processExec.destroy();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = null;
                    ALog.innerE("", "execCommand IOException: " + th.getMessage());
                    return new CommandResult(-1, null, th.getMessage());
                }
            } catch (Throwable th3) {
                th = th3;
                processExec = null;
            }
        } else {
            return new CommandResult(-1, null, null);
        }
    }
}
