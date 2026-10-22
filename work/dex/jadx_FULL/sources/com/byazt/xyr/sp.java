package com.byazt.xyr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.ogz.t;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.RollRecoveryEntry;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 91})
public class sp {
    public volatile boolean c;
    public final t da;
    public final String gt;
    public int m;
    public volatile SensorEventListener my;
    public boolean n;
    public int nu;
    public float[] qy;
    public int rh;
    public float[] rl;
    public int sl;
    public int t;
    public volatile boolean tt;
    public volatile JSONArray u;
    public View uj;
    public volatile boolean ve;
    public volatile JSONObject x;
    public volatile JSONArray yp;
    public volatile JSONArray z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29196a = -1;
    public long sp = -1;
    public final List<JSONObject> i = new ArrayList();

    public sp(ic icVar) {
        this.gt = icVar.zm();
        t tVarHl = gt.tt().hl();
        this.da = tVarHl;
        com.byazt.dj.tt ttVarIj = icVar.ij();
        if (tVarHl == null || ttVarIj == null) {
            return;
        }
        int iGt = ttVarIj.gt();
        this.c = tVarHl.c(iGt);
        this.tt = tVarHl.tt(iGt);
        this.ve = tVarHl.ve(iGt) && tt();
    }

    private boolean tt() {
        com.byazt.nr.n nVarC = com.byazt.nr.n.c(gt.getContext());
        return (nVarC.c(10) == null || nVarC.c(4) == null || nVarC.c(15) == null) ? false : true;
    }

    private void uj() {
        if (this.ve && this.my == null) {
            this.u = new JSONArray();
            this.yp = new JSONArray();
            this.z = new JSONArray();
            this.rl = new float[9];
            this.qy = new float[3];
            this.sl = this.da.tt();
            this.t = this.da.ve();
            this.my = new SensorEventListener() { // from class: com.byazt.xyr.sp.1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    sp.this.c(sensorEvent);
                }
            };
            com.byazt.nr.n nVarC = com.byazt.nr.n.c(gt.getContext());
            nVarC.c(this.my, nVarC.c(10), this.t);
            nVarC.c(this.my, nVarC.c(4), this.t);
            nVarC.c(this.my, nVarC.c(15), this.t);
        }
    }

    private void ve() {
        Object objUj = com.byazt.rgb.tt.uj(this.gt, 1);
        if (objUj instanceof JSONArray) {
            ((JSONArray) objUj).put(this.x);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.x);
            com.byazt.rgb.tt.c(this.gt, 1, jSONArray);
        }
        this.x = null;
    }

    public void c(ViewGroup viewGroup, MotionEvent motionEvent, boolean z) {
        if (this.c) {
            try {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.i.add(c(motionEvent));
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    View view = this.uj;
                    if (view != null && view.equals(c(viewGroup, motionEvent.getX(), motionEvent.getY())) && this.n && z) {
                        return;
                    }
                    if (this.x != null) {
                        this.x.putOpt("ended", c(motionEvent));
                        this.x.putOpt("moves", c(this.i, this.da.c()));
                    }
                    ve();
                    return;
                }
                this.uj = c(viewGroup, motionEvent.getX(), motionEvent.getY());
                this.n = z;
                this.f29196a = motionEvent.getEventTime();
                this.x = new JSONObject();
                this.x.putOpt("began", c(motionEvent));
                this.i.clear();
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.xj.ve veVar) {
        try {
            com.byazt.rgb.tt.c(this.gt, 0, new c(veVar).c());
        } catch (Exception e) {
            m.c(e);
        }
    }

    private void tt(JSONArray jSONArray, SensorEvent sensorEvent) {
        if (jSONArray == null || sensorEvent == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", Math.round(((double) sensorEvent.values[0]) * 100.0d) / 100.0d);
            jSONObject.put("y", Math.round(((double) sensorEvent.values[1]) * 100.0d) / 100.0d);
            jSONObject.put(j.o, Math.round(((double) sensorEvent.values[2]) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.sp) / 1000000);
        } catch (Exception e) {
            m.c(e);
        }
        jSONArray.put(jSONObject);
    }

    private JSONArray c(List<JSONObject> list, int i) {
        if (list.isEmpty()) {
            return null;
        }
        int size = list.size();
        int i2 = 0;
        int i3 = size > i ? (size / i) - 1 : 0;
        JSONArray jSONArray = new JSONArray();
        if (i3 > 0) {
            while (i2 < i) {
                i2++;
                int i4 = (i2 * i3) - 1;
                if (i4 < size) {
                    jSONArray.put(list.get(i4));
                }
            }
        } else {
            int iMin = Math.min(size, i);
            while (i2 < iMin) {
                jSONArray.put(list.get(i2));
                i2++;
            }
        }
        return jSONArray;
    }

    private View c(ViewGroup viewGroup, float f, float f2) {
        View view = null;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && c(f, f2, childAt)) {
                if (childAt instanceof ViewGroup) {
                    View viewC = c((ViewGroup) childAt, f, f2);
                    if (viewC != null) {
                        childAt = viewC;
                    }
                    if (childAt.isClickable()) {
                        return childAt;
                    }
                    view = childAt;
                } else if (childAt.isClickable()) {
                    return childAt;
                }
            }
        }
        return view;
    }

    private boolean c(float f, float f2, View view) {
        return f >= ((float) view.getLeft()) && f <= ((float) view.getRight()) && f2 >= ((float) view.getTop()) && f2 <= ((float) view.getBottom());
    }

    private JSONObject c(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nums", motionEvent.getPointerCount());
            jSONObject.put("x", String.format("%.2f", Float.valueOf(motionEvent.getX())));
            jSONObject.put("y", String.format("%.2f", Float.valueOf(motionEvent.getY())));
            jSONObject.put("ts", motionEvent.getEventTime() - this.f29196a);
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    public void c() {
        if (this.my != null) {
            this.my = null;
            com.byazt.nr.n.c(gt.getContext()).c(this.my);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("accelerometer", this.u);
                jSONObject.putOpt("gyro", this.yp);
                jSONObject.putOpt("device", this.z);
                com.byazt.rgb.tt.c(this.gt, 2, jSONObject);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SensorEvent sensorEvent) {
        int i;
        int type = sensorEvent.sensor.getType();
        if (this.sp < 0) {
            this.sp = sensorEvent.timestamp;
        }
        if (type == 4) {
            int i2 = this.nu;
            if (i2 < this.sl) {
                this.nu = i2 + 1;
                tt(this.yp, sensorEvent);
            }
        } else if (type == 10) {
            int i3 = this.m;
            if (i3 < this.sl) {
                this.m = i3 + 1;
                tt(this.u, sensorEvent);
            }
        } else if (type == 15 && (i = this.rh) < this.sl) {
            this.rh = i + 1;
            c(this.z, sensorEvent);
        }
        int i4 = this.m;
        int i5 = this.sl;
        if (i4 < i5 || this.nu < i5 || this.rh < i5) {
            return;
        }
        c();
    }

    private void c(JSONArray jSONArray, SensorEvent sensorEvent) {
        float[] fArr;
        float[] fArr2;
        if (jSONArray == null || sensorEvent == null || (fArr = this.rl) == null || this.qy == null || (fArr2 = sensorEvent.values) == null || fArr2.length < 4) {
            return;
        }
        SensorManager.getRotationMatrixFromVector(fArr, fArr2);
        SensorManager.getOrientation(this.rl, this.qy);
        float degrees = (float) Math.toDegrees(this.qy[0]);
        float degrees2 = (float) Math.toDegrees(this.qy[1]);
        float degrees3 = (float) Math.toDegrees(this.qy[2]);
        float f = (degrees + 360.0f) % 360.0f;
        float fMax = Math.max(-90.0f, Math.min(90.0f, degrees2));
        float f2 = (degrees3 + 360.0f) % 360.0f;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pitch", Math.round(((double) fMax) * 100.0d) / 100.0d);
            jSONObject.put(RollRecoveryEntry.TYPE, Math.round(((double) f2) * 100.0d) / 100.0d);
            jSONObject.put("yaw", Math.round(((double) f) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.sp) / 1000000);
        } catch (Exception e) {
            m.c(e);
        }
        jSONArray.put(jSONObject);
    }

    public void c(final com.byazt.xj.ve veVar) {
        uj();
        if (this.tt) {
            this.tt = false;
            final View viewI = veVar.i();
            if (viewI != null) {
                viewI.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.xyr.sp.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        viewI.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        sp.this.tt(veVar);
                    }
                });
            }
        }
    }
}
