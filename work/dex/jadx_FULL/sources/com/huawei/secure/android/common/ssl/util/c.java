package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37747a = "c";
    private static final long b = 432000000;
    private static final String c = "lastCheckTime";
    private static volatile boolean d = false;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(f37747a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(f37747a, "checkUpgradeBks, context is null");
            return false;
        }
        d = true;
        long jA = g.a(c, 0L, contextUtil);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > b) {
            g.b(c, jCurrentTimeMillis, contextUtil);
            return true;
        }
        e.c(f37747a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        e.a(f37747a, "onPreExecute");
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            e.b(f37747a, "doInBackground: exception : " + e.getMessage());
            bksFromTss = null;
        }
        e.a(f37747a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (bksFromTss != null) {
            d.a(bksFromTss);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(f37747a, "onPostExecute: upate done");
        } else {
            e.b(f37747a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(f37747a, "onProgressUpdate");
    }
}
