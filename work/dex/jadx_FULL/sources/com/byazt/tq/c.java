package com.byazt.tq;

import android.text.TextUtils;
import com.byazt.fk.u;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1134, 20})
public class c implements com.byazt.fk.c {
    public String c = "video_reward_full";
    public String tt = "video_brand";
    public String ve = "video_splash";
    public String uj = "video_default";
    public String n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29069a = null;
    public String sp = null;
    public String x = null;
    public String i = null;

    private static void c(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.byazt.tq.c.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    private Set<String> tt() {
        HashSet hashSet = new HashSet();
        for (com.byazt.gn.c cVar : com.byazt.gn.c.c.values()) {
            if (cVar != null && cVar.c() != null) {
                a aVarC = cVar.c();
                hashSet.add(com.byazt.vv.ve.tt(aVarC.getCacheParentDir(), aVarC.getFileNameKey()).getAbsolutePath());
                hashSet.add(com.byazt.vv.ve.ve(aVarC.getCacheParentDir(), aVarC.getFileNameKey()).getAbsolutePath());
            }
        }
        for (com.byazt.yqr.tt ttVar : com.byazt.yqr.ve.c.values()) {
            if (ttVar != null && ttVar.c() != null) {
                u uVarC = ttVar.c();
                hashSet.add(com.byazt.vv.ve.tt(uVarC.getCacheParentDir(), uVarC.getFileNameKey()).getAbsolutePath());
                hashSet.add(com.byazt.vv.ve.ve(uVarC.getCacheParentDir(), uVarC.getFileNameKey()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    @Override // com.byazt.fk.c
    public synchronized void clearCache() {
        com.byazt.lt.tt.c("Exec clear video cache ");
        com.byazt.lt.tt.c(this.n);
        Set<String> setTt = null;
        for (com.byazt.vg.c cVar : c()) {
            File[] fileArrC = cVar.c();
            if (fileArrC != null && fileArrC.length >= cVar.tt()) {
                if (setTt == null) {
                    setTt = tt();
                }
                int iTt = cVar.tt() - 2;
                if (iTt < 0) {
                    iTt = 0;
                }
                c(cVar.c(), iTt, setTt);
            }
        }
    }

    @Override // com.byazt.fk.c
    public String getBrandCacheDir() {
        if (this.sp == null) {
            this.sp = this.n + File.separator + this.tt;
            File file = new File(this.sp);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.sp;
    }

    @Override // com.byazt.fk.c
    public long getCachedSize(u uVar) {
        if (TextUtils.isEmpty(uVar.getCacheParentDir()) || TextUtils.isEmpty(uVar.getFileNameKey())) {
            return 0L;
        }
        return com.byazt.vv.ve.c(uVar.getCacheParentDir(), uVar.getFileNameKey());
    }

    @Override // com.byazt.fk.c
    public String getOtherCacheDir() {
        if (this.i == null) {
            this.i = this.n + File.separator + this.uj;
            File file = new File(this.i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.i;
    }

    @Override // com.byazt.fk.c
    public String getRewardFullCacheDir() {
        if (this.f29069a == null) {
            this.f29069a = this.n + File.separator + this.c;
            File file = new File(this.f29069a);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f29069a;
    }

    @Override // com.byazt.fk.c
    public String getSplashCacheDir() {
        if (this.x == null) {
            this.x = this.n + File.separator + this.ve;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.byazt.fk.c
    public boolean isVideoCached(u uVar) {
        if (TextUtils.isEmpty(uVar.getCacheParentDir()) || TextUtils.isEmpty(uVar.getFileNameKey())) {
            return false;
        }
        return new File(uVar.getCacheParentDir(), uVar.getFileNameKey()).exists();
    }

    @Override // com.byazt.fk.c
    public void setRootDir(String str) {
        this.n = str;
    }

    private List<com.byazt.vg.c> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.vg.c(new File(getRewardFullCacheDir()).listFiles(), com.byazt.ri.c.ve()));
        arrayList.add(new com.byazt.vg.c(new File(getSplashCacheDir()).listFiles(), com.byazt.ri.c.tt()));
        arrayList.add(new com.byazt.vg.c(new File(getBrandCacheDir()).listFiles(), com.byazt.ri.c.uj()));
        arrayList.add(new com.byazt.vg.c(new File(getOtherCacheDir()).listFiles(), com.byazt.ri.c.n()));
        return arrayList;
    }
}
