package com.byazt.zz;

import android.app.Notification;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadListener;
import com.byazt.c.eo;
import com.byazt.c.nb;
import com.byazt.c.yv;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface u {
    int a(int i);

    void a();

    int c(String str, String str2);

    List<DownloadInfo> c(String str);

    void c();

    void c(int i);

    void c(int i, int i2);

    void c(int i, int i2, int i3, int i4);

    void c(int i, int i2, int i3, long j);

    void c(int i, int i2, long j);

    void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z);

    void c(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z, boolean z2);

    void c(int i, long j);

    void c(int i, Notification notification);

    void c(int i, yv yvVar);

    void c(int i, List<com.byazt.t.tt> list);

    void c(int i, boolean z);

    void c(nb nbVar);

    void c(DownloadTask downloadTask);

    void c(com.byazt.t.tt ttVar);

    void c(List<String> list);

    void c(boolean z, boolean z2);

    boolean c(DownloadInfo downloadInfo);

    void da(int i);

    List<com.byazt.t.tt> i(int i);

    boolean m(int i);

    IDownloadFileUriProvider my(int i);

    long n(int i);

    List<DownloadInfo> n(String str);

    boolean n();

    yv nu(int i);

    eo rh(int i);

    void sl(int i);

    boolean sp();

    boolean sp(int i);

    void startService();

    boolean t(int i);

    DownloadInfo tt(String str, String str2);

    List<DownloadInfo> tt(String str);

    void tt(int i, int i2, IDownloadListener iDownloadListener, com.byazt.ev.a aVar, boolean z);

    void tt(int i, List<com.byazt.t.tt> list);

    void tt(int i, boolean z);

    void tt(DownloadInfo downloadInfo);

    void tt(DownloadTask downloadTask);

    void tt(List<String> list);

    boolean tt();

    boolean tt(int i);

    int u(int i);

    List<DownloadInfo> uj();

    List<DownloadInfo> uj(String str);

    void uj(int i);

    List<DownloadInfo> ve(String str);

    void ve(int i);

    void ve(int i, boolean z);

    boolean ve();

    boolean ve(DownloadInfo downloadInfo);

    DownloadInfo x(int i);

    boolean yp(int i);

    void z(int i);
}
