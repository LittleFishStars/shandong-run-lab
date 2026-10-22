package com.kwad.framework.filedownloader.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a {
    private static void b(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean cv(int i) {
        b("request pause the task[%d] in the download service", Integer.valueOf(i));
        return false;
    }

    public static byte cw(int i) {
        b("request get the status for the task[%d] in the download service", Integer.valueOf(i));
        return (byte) 0;
    }

    public static boolean cx(int i) {
        b("request clear the task[%d] data in the database", Integer.valueOf(i));
        return false;
    }

    public static boolean h(String str, String str2, boolean z) {
        b("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }
}
