package com.netease.nis.wrapper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class NEDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[][] f1a = {new String[]{a.auu.a.c("psrDgOj+gPDlkcv5lfP3g8zFiPL2qt3/jdzOg+PGk+zpMjUe"), a.auu.a.c("HgkRBBIWRSoKAwsNHAQqRQANBFMKKAMdBggSCW4EBBVBFRchCFQRCRZFIQMSDAIaBCJFFw0AHQsrCVo=")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnMrElt/aguDNhMTXpsffgs7Sg9rc"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVIgwXBBUaCiBFHAQSUwcrABpFFRIIPgAGAAVd")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnNXim8rbgO3N"), a.auu.a.c("CgAAAAIHACpFAA0EUxU8AAcADxAAbgoSRQBTASsHAQIGFhdg")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkfnJlc3vg//6hOrNqt3Zjd7jje/p"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBHAtuBBpFBB4QIgQAChNd")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnMrElt/aguDNhO/NJgobDob9yqvH94HZ3o3x9ZzE7Q=="), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBFQNDhwOJwsTRQQdEycXGwsMFgs6Sw==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnMrElt/aguDNhO/NPAobEYb9yqvH94HZ3o3x9ZzE7Q=="), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBFQXDhwRKwFUAA8FDDwKGggEHRFg")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnMrElt/aguDNidHOqNbcgOTWFiE="), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbg0VFkERACsLVAwPGQAtEREBTw==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkN7ClPXIgvrKhNHm"), a.auu.a.c("CgAAAAIHACpFAA0AB0UvRQQXDgscbgwHRQMWDCACVBASFgFg")}, new String[]{a.auu.a.c("qMb0g9T4gMbVLBUOAAAqgvrKhNHm"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFOQMKPQAQRQQdEycXGwsMFgs6Sw==")}, new String[]{a.auu.a.c("q9jngOj+gsftkvnNl930gP7FhOjfpsrhgvXbgsftm9ntm8r5gP/ahujRqOvRgO7igPbmkN3rlN/x"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRQBTETwMFQlBBQA8Fh0KD19FPgkRBBIWRSoKVAsOB0U8ABgAAAAAbgwARQUaFysGAAkYXQ==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVIjUvltnOgOTK"), a.auu.a.c("CgAAAAIHACpFAA0AB0UvRSI1L1MMPUUWAAgdAm4QBwAFXQ==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkfnJlurCgMjlAAMVqt3Zjd7jje/p"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBFQBFBIJbgQEFUEWCzgMBgoPHgAgEVo=")}, new String[]{a.auu.a.c("qMb0g9T4gMbVITYjm9XNjdvwhM/lq+DHg+jggPLl"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFNCAnbgERBxQUAicLE0UMHAErRR0WQRYLLwcYAAVd")}, new String[]{a.auu.a.c("qMb0g9T4gMbVJgoMltnMgMzd"), a.auu.a.c("CgAAAAIHACpFFQtBEgcgCgYIAB9FHCo5Sw==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVks3Ale7RgvbchPTeqevbgMPw"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0U9DBkQDRIRKwFUBg0aBiUWWg==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkN/wlezFg+jfhv3Kq8f3"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0UtCRsQBVMVJgoaAE8=")}, new String[]{a.auu.a.c("qMb0g9T4gMbVnPz7le7Rg+jfhv3Kq8f3"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0U4DAYRFBIJbggVBgkaCytL")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkdTultzbgPHUhcnO"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0U9BgYABB1FPQ0VFwRd")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkdnjlt32gvrKhNHm"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFABELIRcZBA1TACATHRcOHQgrCwBL")}, new String[]{a.auu.a.c("qMb0g9T4gMbVkNjslNjggcjPiPPF"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0UoBB8AQR8KLQQADA4dSw==")}, new String[]{a.auu.a.c("qMb0g9T4gMbVku/ylunLgvrKhNHm"), a.auu.a.c("CgAAAAIHACpFAA0AB0U6DRFFAAMVbgwHRRMGCyAMGgJBGgtuBBpFBB0TJxcbCwwWCzpFAwwVG0UgAAASDgEObhYaDAcVDCACWg==")}};

    public static void showDialog(Context context, String str) {
        Thread thread = new Thread(new c(context, str));
        synchronized (thread) {
            try {
                thread.start();
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void showProbation(String str) {
        if (str.length() == 0) {
            showRiskMessage(9, "");
        }
    }

    public static void showRiskMessage(int i, String str) {
        String str2;
        String str3 = MyApplication.TAG;
        Context appCtx = MyApplication.getAppCtx();
        if (appCtx != null) {
            String strA = h.a();
            if (!TextUtils.isEmpty(strA) && strA.equals(appCtx.getPackageName())) {
                String language = Locale.getDefault().getLanguage();
                String str4 = null;
                if (i < f1a.length && i >= 0) {
                    str4 = language.equalsIgnoreCase(a.auu.a.c("NA0=")) ? f1a[i][0] : f1a[i][1];
                }
                if (str.length() != 0) {
                    String str5 = MyApplication.TAG;
                    str2 = (str4 + a.auu.a.c("RA==")) + str;
                } else {
                    str2 = str4;
                }
                try {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        String str6 = MyApplication.TAG;
                        Toast.makeText(appCtx, str2, 0).show();
                    } else {
                        String str7 = MyApplication.TAG;
                        Handler handler = MyApplication.getHandler();
                        if (handler != null) {
                            handler.postAtFrontOfQueue(new e(str2));
                        }
                    }
                } catch (Exception e) {
                    String str8 = MyApplication.TAG;
                    new StringBuilder(a.auu.a.c("Kx0XABEHDCELTg==")).append(e.getMessage());
                }
            }
        }
    }

    public static void showToast(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 1);
        toastMakeText.setGravity(16, 0, 0);
        toastMakeText.setDuration(1);
        toastMakeText.show();
    }
}
