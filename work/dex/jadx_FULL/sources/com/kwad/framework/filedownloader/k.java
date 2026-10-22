package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class k implements t {
    private a.InterfaceC1252a azT;
    private a.c azU;
    private Queue<MessageSnapshot> azV;
    private boolean azW = false;

    public k(a.InterfaceC1252a interfaceC1252a, a.c cVar) {
        a(interfaceC1252a, cVar);
    }

    private void a(a.InterfaceC1252a interfaceC1252a, a.c cVar) {
        this.azT = interfaceC1252a;
        this.azU = cVar;
        this.azV = new LinkedBlockingQueue();
    }

    private void cu(int i) {
        if (com.kwad.framework.filedownloader.d.d.cX(i)) {
            if (!this.azV.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.azV.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.getId()), Integer.valueOf(this.azV.size()), Byte.valueOf(messageSnapshotPeek.AH()));
            }
            this.azT = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.azT);
        }
        this.azU.AY();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC1252a interfaceC1252a = this.azT;
        if (interfaceC1252a == null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH()));
            }
        } else {
            if (!this.azW && interfaceC1252a.AP().AC() != null) {
                this.azV.offer(messageSnapshot);
                j.Bp().a(this);
                return;
            }
            if ((l.isValid() || this.azT.AW()) && messageSnapshot.AH() == 4) {
                this.azU.AY();
            }
            cu(messageSnapshot.AH());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean Bs() {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.azT);
        }
        if (this.azT == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.azV.size()));
            return false;
        }
        this.azU.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void Bt() {
        if (this.azW) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.azV.poll();
        byte bAH = messageSnapshotPoll.AH();
        a.InterfaceC1252a interfaceC1252a = this.azT;
        if (interfaceC1252a == null) {
            return;
        }
        a aVarAP = interfaceC1252a.AP();
        i iVarAC = aVarAP.AC();
        x.a aVarAQ = interfaceC1252a.AQ();
        cu(bAH);
        if (iVarAC == null) {
            return;
        }
        if (bAH == 4) {
            try {
                iVarAC.d(aVarAP);
                o(((com.kwad.framework.filedownloader.message.a) messageSnapshotPoll).CJ());
                return;
            } catch (Throwable th) {
                m(aVarAQ.n(th));
                return;
            }
        }
        g gVar = iVarAC instanceof g ? (g) iVarAC : null;
        if (bAH == -4) {
            iVarAC.c(aVarAP);
            return;
        }
        if (bAH == -3) {
            iVarAC.b(aVarAP);
            return;
        }
        if (bAH == -2) {
            if (gVar == null) {
                iVarAC.c(aVarAP, messageSnapshotPoll.CK(), messageSnapshotPoll.CL());
                return;
            } else {
                messageSnapshotPoll.CO();
                messageSnapshotPoll.CM();
                return;
            }
        }
        if (bAH == -1) {
            iVarAC.a(aVarAP, messageSnapshotPoll.CP());
            return;
        }
        if (bAH == 1) {
            if (gVar == null) {
                iVarAC.a(aVarAP, messageSnapshotPoll.CK(), messageSnapshotPoll.CL());
                return;
            } else {
                messageSnapshotPoll.CO();
                messageSnapshotPoll.CM();
                return;
            }
        }
        if (bAH == 2) {
            if (gVar == null) {
                iVarAC.a(aVarAP, messageSnapshotPoll.getEtag(), messageSnapshotPoll.CC(), aVarAP.getSmallFileSoFarBytes(), messageSnapshotPoll.CL());
                return;
            }
            messageSnapshotPoll.getEtag();
            messageSnapshotPoll.CC();
            messageSnapshotPoll.CM();
            return;
        }
        if (bAH == 3) {
            if (gVar != null) {
                messageSnapshotPoll.CO();
                return;
            } else {
                iVarAC.b(aVarAP, messageSnapshotPoll.CK(), aVarAP.getSmallFileTotalBytes());
                return;
            }
        }
        if (bAH != 5) {
            if (bAH != 6) {
                return;
            }
            iVarAC.a(aVarAP);
        } else if (gVar != null) {
            messageSnapshotPoll.CP();
            messageSnapshotPoll.AL();
            messageSnapshotPoll.CO();
        } else {
            messageSnapshotPoll.CP();
            messageSnapshotPoll.AL();
            messageSnapshotPoll.CK();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean Bu() {
        return this.azT.AP().AM();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean Bv() {
        return this.azV.peek().AH() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void Bw() {
        this.azW = true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC1252a interfaceC1252a, a.c cVar) {
        if (this.azT != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("the messenger is working, can't re-appointment for %s", interfaceC1252a));
        }
        a(interfaceC1252a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.azT);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.azT);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.azT);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a aVarAP = this.azT.AP();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", aVarAP, Long.valueOf(aVarAP.AE()), Long.valueOf(aVarAP.AG()));
        }
        if (aVarAP.Az() > 0) {
            p(messageSnapshot);
        } else if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.azT);
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.azT, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            a aVarAP = this.azT.AP();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.azT, Integer.valueOf(aVarAP.AK()), Integer.valueOf(aVarAP.AL()), aVarAP.AJ());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.azT);
        }
        this.azU.AY();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            a.InterfaceC1252a interfaceC1252a = this.azT;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC1252a, interfaceC1252a.AP().AJ());
        }
        this.azU.AY();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.azT);
        }
        this.azU.AY();
        p(messageSnapshot);
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC1252a interfaceC1252a = this.azT;
        objArr[0] = Integer.valueOf(interfaceC1252a == null ? -1 : interfaceC1252a.AP().getId());
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.c("%d:%s", objArr);
    }
}
