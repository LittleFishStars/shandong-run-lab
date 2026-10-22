package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f26333a = new Object();
    private static aa b;
    private HandlerThread c;
    private Handler d;
    private boolean e = false;

    public static aa a() {
        aa aaVar;
        synchronized (f26333a) {
            if (b == null) {
                b = new aa();
            }
            aaVar = b;
        }
        return aaVar;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        if (!this.e || gnssNavigationMessage == null) {
            return;
        }
        try {
            Handler handler = this.d;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(11);
                Bundle bundle = new Bundle();
                bundle.putParcelable("gnss_navigation_message", gnssNavigationMessage);
                bundle.putLong("gps_time", j);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Location location, int i) {
        if (!this.e || location == null) {
            return;
        }
        try {
            Handler handler = this.d;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        if (this.e) {
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void e() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.c == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.c = handlerThread;
            handlerThread.start();
            if (this.c != null) {
                this.d = new Handler(this.c.getLooper()) { // from class: com.baidu.location.b.aa.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 1) {
                            Bundle data = message.getData();
                            try {
                                Location location = (Location) data.getParcelable("loc");
                                data.getInt("satnum");
                                if (location != null) {
                                    i.a().a(location);
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        if (i == 2) {
                            z.a(v.c(), com.baidu.location.c.f.a().r(), v.d(), v.a(), v.e());
                            return;
                        }
                        if (i == 3) {
                            z.a(v.c(), (com.baidu.location.c.k) null, v.d(), b.a().c(), v.e());
                            return;
                        }
                        if (i == 4) {
                            boolean zL = com.baidu.location.c.f.a().l();
                            if (com.baidu.location.e.h.b()) {
                                zL = false;
                            }
                            if (zL) {
                                k.a().d();
                            }
                            try {
                                if (aa.this.d != null) {
                                    aa.this.d.sendEmptyMessageDelayed(4, com.baidu.location.e.h.Q);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            y.a().b();
                            return;
                        }
                        if (i == 7) {
                            z.a().c();
                            return;
                        }
                        if (i == 8 || i == 9) {
                            message.getData();
                            return;
                        }
                        if (i != 11) {
                            return;
                        }
                        Bundle data2 = message.getData();
                        try {
                            y.a().a((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
                        } catch (Exception unused) {
                        }
                    }
                };
            }
        }
        try {
            Handler handler = this.d;
            if (handler != null) {
                handler.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Handler handler2 = this.d;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(4, com.baidu.location.e.h.Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        if (this.e) {
            i.a().b();
            try {
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d = null;
            try {
                HandlerThread handlerThread = this.c;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.c.interrupt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c = null;
            this.e = false;
        }
    }
}
