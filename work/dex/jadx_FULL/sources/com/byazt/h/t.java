package com.byazt.h;

import androidx.annotation.NonNull;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 66})
public class t implements n {
    public final i c;
    public final com.byazt.t.n tt;
    public final n ve;

    public t(DownloadInfo downloadInfo, tt ttVar, i iVar) throws BaseException {
        this.c = iVar;
        this.tt = c(downloadInfo, iVar);
        this.ve = new x(ttVar, this);
    }

    public n c() {
        return this.ve;
    }

    public i n() {
        return this.c;
    }

    @Override // com.byazt.h.n
    public void tt(@NonNull c cVar) throws IOException {
        this.tt.c(cVar.c, 0, cVar.ve);
        this.c.tt(cVar.ve);
    }

    public void uj() {
        com.byazt.w.a.c(this.tt);
    }

    public void ve() throws IOException {
        this.tt.ve();
    }

    private com.byazt.t.n c(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.byazt.t.n nVarC = com.byazt.w.a.c(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.byazt.k.c.c(downloadInfo.getId()).c("flush_buffer_size_byte", -1));
        try {
            nVarC.c(iVar.n());
            return nVarC;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }

    public void tt() throws IOException {
        this.tt.tt();
    }
}
