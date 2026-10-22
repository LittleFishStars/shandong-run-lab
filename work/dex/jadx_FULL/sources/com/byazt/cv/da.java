package com.byazt.cv;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 72})
public class da extends com.byazt.sbm.n {
    public yp c;

    public da(yp ypVar) {
        this.c = ypVar;
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.tt> getAdLoadInfo() {
        if (this.c == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.c.tt().size(); i++) {
            linkedList.add(new x(this.c.tt().get(i)));
        }
        return linkedList;
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getBestEcpm() {
        yp ypVar = this.c;
        return ypVar != null ? new sp(ypVar.uj()) : new sp(null);
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getCacheList() {
        if (this.c == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.c.n().size(); i++) {
            linkedList.add(new sp(this.c.n().get(i)));
        }
        return linkedList;
    }

    @Override // com.byazt.sbm.ve
    public List<com.byazt.sbm.c> getMultiBiddingEcpm() {
        if (this.c == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.c.ve().size(); i++) {
            linkedList.add(new sp(this.c.ve().get(i)));
        }
        return linkedList;
    }

    @Override // com.byazt.sbm.ve
    public com.byazt.sbm.c getShowEcpm() {
        yp ypVar = this.c;
        return ypVar != null ? new sp(ypVar.a()) : new sp(null);
    }

    @Override // com.byazt.sbm.n
    public boolean hasDislike() {
        yp ypVar = this.c;
        if (ypVar != null) {
            return ypVar.sp();
        }
        return false;
    }

    @Override // com.byazt.sbm.n
    public boolean isExpress() {
        yp ypVar = this.c;
        if (ypVar != null) {
            return ypVar.x();
        }
        return false;
    }

    @Override // com.byazt.sbm.ve
    public boolean isReady() {
        yp ypVar = this.c;
        if (ypVar != null) {
            return ypVar.c();
        }
        return true;
    }

    @Override // com.byazt.sbm.n
    public void onPause() {
        yp ypVar = this.c;
        if (ypVar != null) {
            ypVar.da();
        }
    }

    @Override // com.byazt.sbm.n
    public void onResume() {
        yp ypVar = this.c;
        if (ypVar != null) {
            ypVar.i();
        }
    }

    @Override // com.byazt.sbm.n
    public void setShakeViewListener(final com.byazt.am.a aVar) {
        yp ypVar = this.c;
        if (ypVar != null) {
            ypVar.c(new z() { // from class: com.byazt.cv.da.1
                @Override // com.byazt.cv.z
                public void c() {
                    com.byazt.am.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
            });
        }
    }

    @Override // com.byazt.sbm.n
    public void setUseCustomVideo(boolean z) {
        yp ypVar = this.c;
        if (ypVar != null) {
            ypVar.c(z);
        }
    }
}
