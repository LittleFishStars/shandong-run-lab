package com.kwad.components.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k.a.d;
import com.kwad.sdk.k.a.e;
import com.kwad.sdk.k.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.cf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements com.kwad.sdk.core.b {
    private String Ns;
    private int Sb;
    private String ajS;
    private int ajT;
    private String ajU;
    private Long ajV;
    private Long ajW;
    private Long ajX;
    private Long ajY;
    private String ajZ;
    private String aka;
    private long akc;
    private String akd;
    private long ake;
    private String akg;
    private String akh;
    private boolean aki;
    private List<a> akj;
    private f akk;
    private d akl;
    private com.kwad.sdk.k.a.b akm;
    private List<e> akn;
    private List<cf.a> akb = new CopyOnWriteArrayList();
    private int akf = -1;
    private float screenBrightness = -1.0f;
    private int Se = -1;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int ako = -1;
        public int akp = -1;
        public int akq = -1;
        public int streamType;

        private a(int i) {
            this.streamType = i;
        }

        public static List<a> aN(Context context) {
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.e.ao(256L)) {
                return arrayList;
            }
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    return arrayList;
                }
                for (int i = 0; i <= 5; i++) {
                    a aVar = new a(i);
                    int iBT = bT(i);
                    aVar.akq = audioManager.getStreamVolume(iBT);
                    aVar.ako = audioManager.getStreamMaxVolume(iBT);
                    if (Build.VERSION.SDK_INT >= 28) {
                        aVar.akp = audioManager.getStreamMinVolume(iBT);
                    }
                    arrayList.add(aVar);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        private static int bT(int i) {
            if (i == 0) {
                return 0;
            }
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        i2 = 4;
                        if (i != 4) {
                            i2 = 5;
                            if (i != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return i2;
        }
    }

    private void aM(@NonNull Context context) {
        if (com.kwad.sdk.core.config.e.ao(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                this.aki = intExtra == 2 || intExtra == 5;
                int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
                if (intExtra2 == 2) {
                    this.Se = 1;
                    return;
                }
                if (intExtra2 == 1) {
                    this.Se = 2;
                } else if (intExtra2 == 4) {
                    this.Se = 3;
                } else if (intExtra2 == 0) {
                    this.Se = 0;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static Context getContext() {
        return ServiceProvider.Ud();
    }

    @WorkerThread
    public static b we() {
        b bVar = new b();
        bVar.ajT = bt.WJ();
        bVar.ajU = AbiUtil.cK(getContext());
        bVar.Sb = bt.es(getContext());
        bVar.ajV = Long.valueOf(bt.et(getContext()));
        bVar.ajW = Long.valueOf(bt.ep(getContext()));
        bVar.ajX = Long.valueOf(bt.WG());
        bVar.ajY = Long.valueOf(bt.WH());
        bVar.ajZ = bf.dT(getContext());
        bVar.aka = bf.dU(getContext());
        bVar.akb.addAll(bf.o(getContext(), 15));
        bVar.akc = bt.WO();
        bVar.ake = bt.WP();
        bVar.akh = bt.WQ();
        bVar.akg = bt.WR();
        bVar.Ns = bt.WS();
        bVar.akd = bt.WT();
        Context context = getContext();
        if (context != null) {
            bVar.akf = bt.eA(context);
            bVar.akj = new CopyOnWriteArrayList(a.aN(context));
            bVar.aM(context);
        }
        bVar.akl = com.kwad.sdk.utils.c.d.eJ(context);
        bVar.akm = bf.TB();
        bVar.akn = bl.Wp().Wq();
        bVar.akk = bf.TC();
        try {
            bVar.ajS = Build.HARDWARE;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "cpuCount", this.ajT);
        ac.putValue(jSONObject, "cpuAbi", this.ajU);
        ac.putValue(jSONObject, "batteryPercent", this.Sb);
        ac.putValue(jSONObject, "totalMemorySize", this.ajV.longValue());
        ac.putValue(jSONObject, "availableMemorySize", this.ajW.longValue());
        ac.putValue(jSONObject, "totalDiskSize", this.ajX.longValue());
        ac.putValue(jSONObject, "availableDiskSize", this.ajY.longValue());
        ac.putValue(jSONObject, "imsi", this.ajZ);
        ac.putValue(jSONObject, "iccid", this.aka);
        ac.putValue(jSONObject, "wifiList", this.akb);
        ac.putValue(jSONObject, "bootTime", this.akc);
        ac.putValue(jSONObject, "romName", this.Ns);
        ac.putValue(jSONObject, "romVersion", this.akd);
        ac.putValue(jSONObject, "romBuildTimestamp", this.ake);
        ac.putValue(jSONObject, "ringerMode", this.akf);
        ac.putValue(jSONObject, "audioStreamInfo", this.akj);
        ac.putValue(jSONObject, "baseBandVersion", this.akg);
        ac.putValue(jSONObject, "fingerPrint", this.akh);
        ac.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        ac.putValue(jSONObject, "isCharging", this.aki);
        ac.putValue(jSONObject, "chargeType", this.Se);
        f fVar = this.akk;
        if (fVar != null) {
            ac.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.akl;
        if (dVar != null) {
            ac.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.k.a.b bVar = this.akm;
        if (bVar != null) {
            ac.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.akn;
        if (list != null) {
            ac.putValue(jSONObject, "sensorEventInfoList", list);
        }
        ac.putValue(jSONObject, "machineName", this.ajS);
        return jSONObject;
    }
}
