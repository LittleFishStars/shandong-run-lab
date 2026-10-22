package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends d {
    private String B(File file) {
        File file2 = new File(file, "anr_reason");
        String strY = "";
        if (file2.exists()) {
            try {
                strY = y.Y(file2);
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
            y.W(file2);
        }
        return strY;
    }

    private AnrExceptionMessage C(File file) {
        String strY;
        try {
            strY = y.Y(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            strY = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (strY != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(strY));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        y.W(file);
        return anrExceptionMessage;
    }

    private static boolean gC(@NonNull String str) {
        for (String str2 : com.kwad.sdk.crash.e.Qd().Qe()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.d.c.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) throws Throwable {
        com.kwad.sdk.core.d.c.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + file5.getPath());
        AnrExceptionMessage anrExceptionMessageC = C(file2);
        try {
            anrExceptionMessageC.mReason = B(file5);
            a(anrExceptionMessageC, file);
            a(file4, anrExceptionMessageC);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) anrExceptionMessageC.toString(), true);
            com.kwad.sdk.crash.utils.g.d(file3, file);
            file.renameTo(file3);
            anrExceptionMessageC.toString();
            File file6 = new File(file5, "meminfo");
            if (file6.exists()) {
                anrExceptionMessageC.mDumpsys = y.Y(file6);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("AnrReporter", Log.getStackTraceString(e));
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            anrExceptionMessageC.mErrorMessage += this.mErrorMessage;
        }
        return anrExceptionMessageC;
    }

    private void a(AnrExceptionMessage anrExceptionMessage, File file) throws Throwable {
        String strGI = com.kwad.sdk.crash.utils.g.gI(file.getName());
        anrExceptionMessage.mLogUUID = strGI;
        anrExceptionMessage.mIndex = com.kwad.sdk.crash.utils.g.getIndex(strGI);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!z && line.startsWith("\"main\" prio")) {
                            sb2.append(line);
                            sb2.append('\n');
                            String[] strArrSplit = line.split("\\s+");
                            anrExceptionMessage.mThreadStatus = strArrSplit[strArrSplit.length - 1];
                            z = true;
                        } else if (!z) {
                            continue;
                        } else {
                            if (line.length() == 0) {
                                break;
                            }
                            if (line.startsWith("  |")) {
                                sb2.append(line);
                                sb2.append('\n');
                            } else {
                                sb.append(line);
                                sb.append('\n');
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
        if (sb.length() > 1) {
            anrExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (TextUtils.isEmpty(anrExceptionMessage.mCrashDetail)) {
            anrExceptionMessage.mCrashSource = 0;
        } else if (gC(anrExceptionMessage.mCrashDetail)) {
            anrExceptionMessage.mCrashSource = 1;
        } else {
            anrExceptionMessage.mCrashSource = 2;
        }
        com.kwad.sdk.core.d.c.d("AnrReporter", " message.mCrashSource=" + anrExceptionMessage.mCrashSource + "message.mCrashDetail = " + anrExceptionMessage.mCrashDetail);
        if (sb2.length() > 1) {
            anrExceptionMessage.mThreadDetail = sb2.substring(0, sb2.length() - 1);
        }
    }
}
