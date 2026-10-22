package com.kwad.sdk.a.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class b {
    private static volatile b aGX;
    private Stack<AdTemplate> aGV = new Stack<>();
    private File aGW;
    private boolean mHasInit;

    public interface a {
        void Hk();

        void hK();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File Hg() {
        File file = this.aGW;
        if (file != null) {
            return file;
        }
        String strEi = bg.ei(ServiceProvider.getContext());
        File file2 = new File(strEi);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(strEi + File.separator + "uninstall_ad");
        this.aGW = file3;
        if (!file3.exists()) {
            try {
                this.aGW.createNewFile();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
            }
        }
        return this.aGW;
    }

    private static boolean Hh() {
        return com.kwad.sdk.core.config.e.JG() == 0;
    }

    public static b Hi() {
        if (aGX == null) {
            synchronized (b.class) {
                if (aGX == null) {
                    aGX = new b();
                }
            }
        }
        return aGX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bo(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        Iterator<AdTemplate> it = this.aGV.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.helper.e.eY(it.next()) == com.kwad.sdk.core.response.helper.e.eY(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (!z) {
            return;
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aGW));
            try {
                try {
                    objectOutputStream.writeObject(this.aGV);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bp(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.aGV.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(Hg()));
            try {
                try {
                    objectOutputStream.writeObject(this.aGV);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            objectOutputStream = null;
            e = e3;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File bs(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.J(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        if (y.Q(file)) {
            return file;
        }
        return null;
    }

    public final synchronized AdTemplate Hj() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.aGV.clone();
        while (!stack.isEmpty()) {
            adTemplate = (AdTemplate) stack.pop();
            if (adTemplate != null) {
                String str = com.kwad.sdk.core.response.helper.e.eO(adTemplate).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File fileBs = bs(adTemplate);
                if (fileBs == null || !fileBs.exists() || fileBs.lastModified() + 604800000 <= System.currentTimeMillis() || au.aw(context, str)) {
                }
            }
        }
        adTemplate = null;
        return adTemplate;
    }

    public final void bq(final AdTemplate adTemplate) {
        if (Hh() || adTemplate == null) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.this.bp(adTemplate);
            }
        });
    }

    public final void br(final AdTemplate adTemplate) {
        if (Hh() || adTemplate == null) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.this.bo(adTemplate);
            }
        });
    }

    public static /* synthetic */ boolean a(b bVar) {
        return Hh();
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        i.execute(new bi() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x0123: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:71:0x0123 */
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ObjectInputStream objectInputStream;
                ObjectOutputStream objectOutputStream;
                try {
                    if (b.a(b.this) || com.kwad.sdk.a.a.a.b.dV() > 0) {
                        return;
                    }
                    HashMap map = new HashMap();
                    File fileHg = b.this.Hg();
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        try {
                            if (!fileHg.exists()) {
                                com.kwad.sdk.core.d.c.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                            }
                            b.this.aGV.clear();
                            objectInputStream = new ObjectInputStream(new FileInputStream(fileHg));
                            try {
                                b.this.aGV = (Stack) objectInputStream.readObject();
                                if (!b.this.aGV.isEmpty()) {
                                    Stack stack = new Stack();
                                    while (!b.this.aGV.isEmpty()) {
                                        AdTemplate adTemplate = (AdTemplate) b.this.aGV.pop();
                                        if (adTemplate != null) {
                                            String strValueOf = String.valueOf(com.kwad.sdk.core.response.helper.e.eY(adTemplate));
                                            File fileBs = b.bs(adTemplate);
                                            if (fileBs == null || !fileBs.exists() || fileBs.lastModified() + 604800000 <= System.currentTimeMillis()) {
                                                map.put(strValueOf, Boolean.TRUE);
                                            } else {
                                                stack.push(adTemplate);
                                            }
                                        }
                                    }
                                    while (!stack.isEmpty()) {
                                        b.this.aGV.push((AdTemplate) stack.pop());
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.Hk();
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream2 = objectOutputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        objectInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                    try {
                        try {
                            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream(fileHg));
                            try {
                                objectOutputStream3.writeObject(b.this.aGV);
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream3);
                            } catch (Exception e3) {
                                e = e3;
                                objectOutputStream2 = objectOutputStream3;
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                                com.kwad.components.core.d.a.reportSdkCaughtException(e);
                                a aVar3 = aVar;
                                if (aVar3 != null) {
                                    aVar3.Hk();
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                    return;
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                objectOutputStream2 = objectOutputStream3;
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.hK();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th5);
                }
            }
        });
    }
}
