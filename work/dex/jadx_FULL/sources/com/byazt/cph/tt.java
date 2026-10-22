package com.byazt.cph;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.iy.n;
import com.byazt.nr.a;
import com.byazt.nr.x;
import com.byazt.va.ve;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.byazt.yj.qy;
import com.byazt.yy.uj;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1059, 13})
public class tt {
    public static final String c;
    public static final String tt;
    public static volatile tt uj;
    public final n ve = new uj.c().c("lottie_tpl_info").c(com.byazt.mf.c.c().ve().getContext()).c(1).c(com.byazt.mf.c.c().ve().t()).c();

    public interface c<T> {
        void c(int i, String str);

        void c(T t);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        sb.append(str);
        sb.append("lottie");
        sb.append(str);
        sb.append("audio");
        c = sb.toString();
        tt = "tt_derive" + str + "lottie" + str + "anim_img";
    }

    private tt() {
    }

    public void tt(String str, final c<Bitmap> cVar) {
        qy qyVarN = com.byazt.mf.c.c().n();
        if (qyVarN != null) {
            qyVarN.from(str).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.cph.tt.3
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str2, Throwable th) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    c cVar2;
                    try {
                        Bitmap result = mVar.getResult();
                        if (result == null || (cVar2 = cVar) == null) {
                            return;
                        }
                        cVar2.c(result);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                }
            }, 4);
        } else if (cVar != null) {
            cVar.c(-1, "imageCenter is null");
        }
    }

    public static tt c() {
        if (uj == null) {
            synchronized (tt.class) {
                if (uj == null) {
                    uj = new tt();
                }
            }
        }
        return uj;
    }

    public void c(Context context, com.byazt.cph.c cVar) {
        if (cVar != null) {
            String strVe = cVar.ve();
            if (!TextUtils.isEmpty(strVe)) {
                tt(strVe, null);
            }
            String strC = cVar.c();
            if (TextUtils.isEmpty(strC) || !TextUtils.isEmpty(c(strC))) {
                return;
            }
            c(strC, (c<String>) null);
        }
    }

    public void c(final String str, final c<String> cVar) {
        ve veVarN = com.byazt.mf.c.c().ve().n();
        if (veVarN == null) {
            return;
        }
        veVarN.c(str);
        veVarN.c(new com.byazt.mh.c() { // from class: com.byazt.cph.tt.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                String strN;
                boolean z = false;
                if (ttVar != null) {
                    try {
                        if (ttVar.i() && (strN = ttVar.n()) != null) {
                            try {
                                com.byazt.nr.m.c("TTDeriveTplManager", "lottie content is ok, version: " + new JSONObject(strN).optString("v"));
                                tt.this.c(str, strN);
                                c cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.c(strN);
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                com.byazt.nr.m.c(e);
                                if (cVar != null) {
                                    String message = e.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    cVar.c(10006, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                        c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.c(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                c cVar4 = cVar;
                if (cVar4 != null) {
                    StringBuilder sb = new StringBuilder("lottieJsonUrl加载失败1, response is not null:");
                    sb.append(ttVar != null);
                    sb.append(", isSuccess:");
                    if (ttVar != null && ttVar.i()) {
                        z = true;
                    }
                    sb.append(z);
                    cVar4.c(10001, sb.toString());
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void c(Context context, String str, final c<Bitmap> cVar) {
        qy qyVarN = com.byazt.mf.c.c().n();
        if (qyVarN != null) {
            qyVarN.from(str).cacheDir(c(context)).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.cph.tt.2
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str2, Throwable th) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    c cVar2;
                    try {
                        Bitmap result = mVar.getResult();
                        if (result == null || (cVar2 = cVar) == null) {
                            return;
                        }
                        cVar2.c(result);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                }
            }, 4);
        } else if (cVar != null) {
            cVar.c(-1, "imageCenter is null");
        }
    }

    public String c(String str) {
        String strTt = a.tt(str);
        if (TextUtils.isEmpty(strTt)) {
            return null;
        }
        return this.ve.get(strTt, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        String strTt = a.tt(str);
        if (TextUtils.isEmpty(strTt)) {
            return;
        }
        this.ve.put(strTt, str2);
    }

    public String c(Context context) {
        return x.c(context, com.byazt.mf.c.c().ve().t(), tt).getAbsolutePath();
    }
}
