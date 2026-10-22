package com.byazt.b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ev.DownloadStatus;
import com.byazt.t.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 158})
public class sl implements com.byazt.zz.da {
    public final SparseArray<DownloadInfo> c = new SparseArray<>();
    public final SparseArray<List<com.byazt.t.tt>> tt = new SparseArray<>();
    public final SparseArray<Map<Long, com.byazt.h.i>> ve = new SparseArray<>();

    public SparseArray<List<com.byazt.t.tt>> a() {
        return this.tt;
    }

    public SparseArray<DownloadInfo> c() {
        return this.c;
    }

    @Override // com.byazt.zz.da
    public void c(int i, int i2, int i3, int i4) {
    }

    @Override // com.byazt.zz.da
    public DownloadInfo da(int i) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setStatus(-7);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo i(int i) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setStatus(1);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public boolean n() {
        return false;
    }

    @Override // com.byazt.zz.da
    public synchronized boolean n(int i) {
        this.c.remove(i);
        return true;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo sp(int i) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setStatus(2);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized Map<Long, com.byazt.h.i> t(int i) {
        return this.ve.get(i);
    }

    @Override // com.byazt.zz.da
    public synchronized DownloadInfo tt(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.c.get(i);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.byazt.zz.da
    public void tt(int i, List<com.byazt.t.tt> list) {
    }

    @Override // com.byazt.zz.da
    public void tt(com.byazt.t.tt ttVar) {
    }

    @Override // com.byazt.zz.da
    public synchronized void u(int i) {
        this.ve.remove(i);
    }

    @Override // com.byazt.zz.da
    public synchronized List<DownloadInfo> uj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.c.size(); i++) {
            DownloadInfo downloadInfo = this.c.get(this.c.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.zz.da
    public boolean uj() {
        return false;
    }

    @Override // com.byazt.zz.da
    public synchronized List<DownloadInfo> ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.c.size(); i++) {
            DownloadInfo downloadInfo = this.c.get(this.c.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo x(int i) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setStatus(5);
            downloadInfoTt.setFirstDownload(false);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized List<com.byazt.h.i> yp(int i) {
        Map<Long, com.byazt.h.i> map = this.ve.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.byazt.zz.da
    public boolean a(int i) {
        n(i);
        uj(i);
        u(i);
        return true;
    }

    @Override // com.byazt.zz.da
    public synchronized List<DownloadInfo> c(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo downloadInfoValueAt = this.c.valueAt(i);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        return arrayList;
    }

    @Override // com.byazt.zz.da
    public synchronized List<DownloadInfo> tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.c.size(); i++) {
            DownloadInfo downloadInfo = this.c.get(this.c.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.zz.da
    public void c(com.byazt.t.tt ttVar) {
        int iSl = ttVar.sl();
        List<com.byazt.t.tt> arrayList = this.tt.get(iSl);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.tt.put(iSl, arrayList);
        }
        arrayList.add(ttVar);
    }

    @Override // com.byazt.zz.da
    public synchronized void c(int i, int i2, long j) {
        List<com.byazt.t.tt> listVe = ve(i);
        if (listVe == null) {
            return;
        }
        for (com.byazt.t.tt ttVar : listVe) {
            if (ttVar != null && ttVar.my() == i2) {
                ttVar.tt(j);
                return;
            }
        }
    }

    @Override // com.byazt.zz.da
    public synchronized void uj(int i) {
        this.tt.remove(i);
    }

    @Override // com.byazt.zz.da
    public synchronized List<com.byazt.t.tt> ve(int i) {
        return this.tt.get(i);
    }

    @Override // com.byazt.zz.da
    public synchronized void ve() {
        this.c.clear();
        this.tt.clear();
    }

    @Override // com.byazt.zz.da
    public DownloadInfo uj(int i, long j) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setCurBytes(j, false);
            downloadInfoTt.setStatus(-2);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized List<DownloadInfo> tt() {
        if (this.c.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        for (int i = 0; i < this.c.size(); i++) {
            DownloadInfo downloadInfoValueAt = this.c.valueAt(i);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo ve(int i, long j) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setCurBytes(j, false);
            downloadInfoTt.setStatus(-3);
            downloadInfoTt.setFirstDownload(false);
            downloadInfoTt.setFirstSuccess(false);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized void c(int i, int i2, int i3, long j) {
        List<com.byazt.t.tt> listVe = ve(i);
        if (listVe == null) {
            return;
        }
        for (com.byazt.t.tt ttVar : listVe) {
            if (ttVar != null && ttVar.my() == i3 && !ttVar.a()) {
                if (ttVar.sp() == null) {
                    break;
                }
                for (com.byazt.t.tt ttVar2 : ttVar.sp()) {
                    if (ttVar2 != null && ttVar2.my() == i2) {
                        ttVar2.tt(j);
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // com.byazt.zz.da
    public DownloadInfo tt(int i, long j) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setCurBytes(j, false);
            downloadInfoTt.setStatus(-1);
            downloadInfoTt.setFirstDownload(false);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public void tt(DownloadInfo downloadInfo) {
        c(downloadInfo);
    }

    @Override // com.byazt.zz.da
    public synchronized DownloadInfo c(int i, int i2) {
        DownloadInfo downloadInfoTt;
        downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setChunkCount(i2);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized boolean c(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.c.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.c.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j, String str, String str2) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setTotalBytes(j);
            downloadInfoTt.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoTt.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoTt.setName(str2);
            }
            downloadInfoTt.setStatus(3);
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public DownloadInfo c(int i, long j) {
        DownloadInfo downloadInfoTt = tt(i);
        if (downloadInfoTt != null) {
            downloadInfoTt.setCurBytes(j, false);
            if (downloadInfoTt.getStatus() != -3 && downloadInfoTt.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoTt.getStatus()) && downloadInfoTt.getStatus() != -4) {
                downloadInfoTt.setStatus(4);
            }
        }
        return downloadInfoTt;
    }

    @Override // com.byazt.zz.da
    public synchronized void c(int i, List<com.byazt.t.tt> list) {
        if (list == null) {
            return;
        }
        uj(i);
        for (com.byazt.t.tt ttVar : list) {
            if (ttVar != null) {
                c(ttVar);
                if (ttVar.a()) {
                    Iterator<com.byazt.t.tt> it = ttVar.sp().iterator();
                    while (it.hasNext()) {
                        c(it.next());
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.byazt.zz.da
    public synchronized boolean c(int i, Map<Long, com.byazt.h.i> map) {
        this.ve.put(i, map);
        return false;
    }
}
