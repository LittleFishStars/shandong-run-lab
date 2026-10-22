package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements Comparable<b> {
    public String aEU;
    public boolean aEV;
    public ClassLoader aFA;
    public String aFr;
    public String aFs;
    public long aFt;
    public String aFu;
    public boolean aFv = false;
    public boolean aFw = true;
    public HashMap<String, String> aFx = new HashMap<>(10);
    public List<String> aFy;
    public List<String> aFz;
    public boolean enable;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.aFr + "', version='" + this.version + "', downloadUrl='" + this.aFs + "', fileSize=" + this.aFt + ", enable=" + this.enable + ", md5sum='" + this.aFu + "', onlyWifiDownload=" + this.aFv + ", onlyWifiRetryDownload=" + this.aFw + ", soMd5s=" + this.aFx + ", hostPackages=" + this.aFy + ", hostInterfaces=" + this.aFz + '}';
    }
}
