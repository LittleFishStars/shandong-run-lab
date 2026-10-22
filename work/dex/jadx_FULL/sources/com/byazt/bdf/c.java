package com.byazt.bdf;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.dna.h;
import com.byazt.fk.da;
import com.byazt.fk.i;
import com.byazt.fk.sp;
import com.byazt.fk.t;
import com.byazt.fk.tt;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 2417, 20})
public class c implements h, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                sp spVarCreateTTLiveVideoPlayer = createTTLiveVideoPlayer((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
                return spVarCreateTTLiveVideoPlayer != null ? new i(spVarCreateTTLiveVideoPlayer) : spVarCreateTTLiveVideoPlayer;
            case 2:
                sp spVarCreateTTVideoPlayer = createTTVideoPlayer((Context) sparseArray.get(1), (String) sparseArray.get(2));
                return spVarCreateTTVideoPlayer != null ? new i(spVarCreateTTVideoPlayer) : spVarCreateTTVideoPlayer;
            case 3:
                preloadTTVideo((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Integer) sparseArray.get(3)).intValue(), (String[]) sparseArray.get(4), (long[]) sparseArray.get(5), ((Boolean) sparseArray.get(6)).booleanValue());
                return null;
            case 4:
                return Boolean.valueOf(isTTVideoOk());
            case 5:
                openDebugLog(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 6:
                da daVarCreateVideoPreload = createVideoPreload();
                return daVarCreateVideoPreload != null ? new t(daVarCreateVideoPreload) : daVarCreateVideoPreload;
            case 7:
                com.byazt.fk.c cVarCreateVideoCacheDir = createVideoCacheDir();
                return cVarCreateVideoCacheDir != null ? new tt(cVarCreateVideoCacheDir) : cVarCreateVideoCacheDir;
            case 8:
                return Integer.valueOf(getLiveSupportCode());
            default:
                return null;
        }
    }

    @Override // com.byazt.dna.h
    public sp createTTLiveVideoPlayer(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        return new com.byazt.ir.c(context, z, j, jSONObject, looper);
    }

    @Override // com.byazt.dna.h
    public sp createTTVideoPlayer(Context context, String str) {
        return new com.byazt.jy.tt(context, str);
    }

    @Override // com.byazt.dna.h
    public com.byazt.fk.c createVideoCacheDir() {
        return new com.byazt.fd.c();
    }

    @Override // com.byazt.dna.h
    public da createVideoPreload() {
        return new com.byazt.au.c();
    }

    @Override // com.byazt.dna.h
    public int getLiveSupportCode() {
        return 0;
    }

    @Override // com.byazt.dna.h
    public boolean isTTVideoOk() {
        return com.byazt.jy.tt.c();
    }

    @Override // com.byazt.dna.h
    public void openDebugLog(boolean z) {
        com.byazt.jy.c.c(z);
    }

    @Override // com.byazt.dna.h
    public void preloadTTVideo(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        com.byazt.jy.tt.c(context, str, i, strArr, jArr, z);
    }
}
