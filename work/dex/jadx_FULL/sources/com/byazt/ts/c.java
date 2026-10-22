package com.byazt.ts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 357, 20})
public abstract class c implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve.sp f29071a;
    public boolean c = false;
    public ve.a n;
    public ve.InterfaceC0537ve sp;
    public ve.n tt;
    public ve.c uj;
    public ve.tt ve;
    public ve.uj x;

    @Override // com.byazt.ts.ve
    public final void c(ve.n nVar) {
        this.tt = nVar;
    }

    public final void tt() {
        try {
            ve.n nVar = this.tt;
            if (nVar != null) {
                nVar.tt(this);
            }
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void uj() {
        try {
            ve.a aVar = this.n;
            if (aVar != null) {
                aVar.ve(this);
            }
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public final void ve() {
        try {
            ve.tt ttVar = this.ve;
            if (ttVar != null) {
                ttVar.c(this);
            }
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.tt ttVar) {
        this.ve = ttVar;
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.c cVar) {
        this.uj = cVar;
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.a aVar) {
        this.n = aVar;
    }

    public final boolean tt(int i, int i2) {
        try {
            ve.uj ujVar = this.x;
            return ujVar != null && ujVar.tt(this, i, i2);
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.InterfaceC0537ve interfaceC0537ve) {
        this.sp = interfaceC0537ve;
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.uj ujVar) {
        this.x = ujVar;
    }

    @Override // com.byazt.ts.ve
    public final void c(ve.sp spVar) {
        this.f29071a = spVar;
    }

    public void c() {
        this.tt = null;
        this.uj = null;
        this.ve = null;
        this.n = null;
        this.f29071a = null;
        this.sp = null;
        this.x = null;
    }

    public final void c(int i) {
        try {
            ve.c cVar = this.uj;
            if (cVar != null) {
                cVar.c(this, i);
            }
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        try {
            ve.sp spVar = this.f29071a;
            if (spVar != null) {
                spVar.c(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean c(int i, int i2) {
        try {
            ve.InterfaceC0537ve interfaceC0537ve = this.sp;
            return interfaceC0537ve != null && interfaceC0537ve.c(this, i, i2);
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.byazt.ts.ve
    public void c(boolean z) {
        this.c = z;
    }
}
