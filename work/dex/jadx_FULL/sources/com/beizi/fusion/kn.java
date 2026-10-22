package com.beizi.fusion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class kn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27479a;
    private AdSpacesBean.BuyerBean.ScrollClickBean b;
    private AdSpacesBean.BuyerBean.ScrollClickBean c;
    private AdSpacesBean.BuyerBean.ScrollClickPositionBean d;
    private View f;
    private String g;
    private int l;
    private ValueAnimator m;
    private int n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private LinearLayout u;
    private boolean v;
    private d e = null;
    private String h = ScrollClickView.DIR_UP;
    private String i = ScrollClickView.DIR_DOWN;
    private String j = "left";
    private String k = "right";
    private String r = "#9CBBFF";
    private String s = "#C1D4FF";
    private String t = "#FFFFFF";

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27480a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0120  */
        /* JADX WARN: Code duplicated, block: B:22:0x0129  */
        /* JADX WARN: Code duplicated, block: B:24:0x0138  */
        /* JADX WARN: Code duplicated, block: B:31:0x01eb  */
        /* JADX WARN: Code duplicated, block: B:33:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:35:0x0203  */
        /* JADX WARN: Code duplicated, block: B:37:0x0211  */
        /* JADX WARN: Code duplicated, block: B:39:0x0219  */
        /* JADX WARN: Code duplicated, block: B:42:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:44:0x02bf  */
        /* JADX WARN: Code duplicated, block: B:46:0x02ce  */
        /* JADX WARN: Code duplicated, block: B:48:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:50:0x02e4  */
        /* JADX WARN: Code duplicated, block: B:53:0x0381  */
        /* JADX WARN: Code duplicated, block: B:55:0x0390  */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float f;
            float f2;
            float f3;
            d dVar;
            float fAbs;
            kn knVar;
            d dVar2;
            float fAbs2;
            kn knVar2;
            d dVar3;
            float fAbs3;
            kn knVar3;
            d dVar4;
            d dVar5;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27480a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
            } else if (action == 1) {
                kh.d("BeiZisAd", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f27480a + ",mPosY = " + this.b);
                float f4 = this.d - this.b;
                if (f4 > 0.0f) {
                    float fAbs4 = Math.abs(f4);
                    kn knVar4 = kn.this;
                    if (fAbs4 <= knVar4.l) {
                        f = this.d - this.b;
                        if (f < 0.0f) {
                            fAbs3 = Math.abs(f);
                            knVar3 = kn.this;
                            if (fAbs3 > knVar3.l) {
                                f2 = this.c - this.f27480a;
                                if (f2 < 0.0f) {
                                    fAbs2 = Math.abs(f2);
                                    knVar2 = kn.this;
                                    if (fAbs2 > knVar2.l) {
                                        f3 = this.c - this.f27480a;
                                        if (f3 > 0.0f) {
                                            fAbs = Math.abs(f3);
                                            knVar = kn.this;
                                            if (fAbs > knVar.l) {
                                                if ((knVar.k.equalsIgnoreCase(knVar.g) || kn.this.v) && (dVar2 = kn.this.e) != null) {
                                                    dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            } else if (Math.abs(this.c - this.f27480a) <= 15.0f && Math.abs(this.d - this.b) <= 15.0f && (dVar = kn.this.e) != null) {
                                                dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                            }
                                        } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                            dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                        }
                                    } else if ((knVar2.j.equalsIgnoreCase(knVar2.g) || kn.this.v) && (dVar3 = kn.this.e) != null) {
                                        dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f3 = this.c - this.f27480a;
                                    if (f3 > 0.0f) {
                                        fAbs = Math.abs(f3);
                                        knVar = kn.this;
                                        if (fAbs > knVar.l) {
                                            if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            } else {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                            dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                }
                            } else if ((knVar3.h.equalsIgnoreCase(knVar3.g) || kn.this.v) && (dVar4 = kn.this.e) != null) {
                                dVar4.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f2 = this.c - this.f27480a;
                            if (f2 < 0.0f) {
                                fAbs2 = Math.abs(f2);
                                knVar2 = kn.this;
                                if (fAbs2 > knVar2.l) {
                                    f3 = this.c - this.f27480a;
                                    if (f3 > 0.0f) {
                                        fAbs = Math.abs(f3);
                                        knVar = kn.this;
                                        if (fAbs > knVar.l) {
                                            if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            } else {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                            dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (knVar2.j.equalsIgnoreCase(knVar2.g)) {
                                    dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27480a;
                                if (f3 > 0.0f) {
                                    fAbs = Math.abs(f3);
                                    knVar = kn.this;
                                    if (fAbs > knVar.l) {
                                        if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                    dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                }
                            }
                        }
                    } else if ((knVar4.i.equalsIgnoreCase(knVar4.g) || kn.this.v) && (dVar5 = kn.this.e) != null) {
                        dVar5.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else {
                    f = this.d - this.b;
                    if (f < 0.0f) {
                        fAbs3 = Math.abs(f);
                        knVar3 = kn.this;
                        if (fAbs3 > knVar3.l) {
                            f2 = this.c - this.f27480a;
                            if (f2 < 0.0f) {
                                fAbs2 = Math.abs(f2);
                                knVar2 = kn.this;
                                if (fAbs2 > knVar2.l) {
                                    f3 = this.c - this.f27480a;
                                    if (f3 > 0.0f) {
                                        fAbs = Math.abs(f3);
                                        knVar = kn.this;
                                        if (fAbs > knVar.l) {
                                            if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            } else {
                                                dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                            dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (knVar2.j.equalsIgnoreCase(knVar2.g)) {
                                    dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27480a;
                                if (f3 > 0.0f) {
                                    fAbs = Math.abs(f3);
                                    knVar = kn.this;
                                    if (fAbs > knVar.l) {
                                        if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                    dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                }
                            }
                        } else if (knVar3.h.equalsIgnoreCase(knVar3.g)) {
                            dVar4.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        } else {
                            dVar4.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        f2 = this.c - this.f27480a;
                        if (f2 < 0.0f) {
                            fAbs2 = Math.abs(f2);
                            knVar2 = kn.this;
                            if (fAbs2 > knVar2.l) {
                                f3 = this.c - this.f27480a;
                                if (f3 > 0.0f) {
                                    fAbs = Math.abs(f3);
                                    knVar = kn.this;
                                    if (fAbs > knVar.l) {
                                        if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                        dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                    }
                                } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                    dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                }
                            } else if (knVar2.j.equalsIgnoreCase(knVar2.g)) {
                                dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            } else {
                                dVar3.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f3 = this.c - this.f27480a;
                            if (f3 > 0.0f) {
                                fAbs = Math.abs(f3);
                                knVar = kn.this;
                                if (fAbs > knVar.l) {
                                    if (knVar.k.equalsIgnoreCase(knVar.g)) {
                                        dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        dVar2.b(this.f27480a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                    dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                                }
                            } else if (Math.abs(this.c - this.f27480a) <= 15.0f) {
                                dVar.a(this.f27480a + "", this.b + "", this.e + "", this.f + "", this.f27480a + "", this.b + "", this.e + "", this.f + "");
                            }
                        }
                    }
                }
            } else if (action == 2) {
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
            }
            return true;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0054 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x005c A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:15:0x008f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x0091 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:17:0x00c4 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:18:0x00c6 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0101 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0133 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:23:0x0135 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0167 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:25:0x0169 A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:3:0x0007, B:5:0x0022, B:8:0x0034, B:10:0x0044, B:26:0x019a, B:28:0x01a2, B:29:0x01a6, B:31:0x01ac, B:12:0x0054, B:14:0x005c, B:16:0x0091, B:18:0x00c6, B:19:0x00f9, B:21:0x0101, B:23:0x0135, B:25:0x0169), top: B:36:0x0007 }] */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kn knVar;
            int i;
            kn knVar2;
            int i2;
            kh.c("ScrollUtil", "addScrollViewViewAnimation onAnimationEnd");
            try {
                kn knVar3 = kn.this;
                knVar3.n++;
                if (knVar3.h.equals(knVar3.g)) {
                    knVar = kn.this;
                    i = knVar.n;
                    if (i == 1) {
                        knVar.o.setColorFilter(Color.parseColor(knVar.s));
                        kn knVar4 = kn.this;
                        knVar4.p.setColorFilter(Color.parseColor(knVar4.t));
                        kn knVar5 = kn.this;
                        knVar5.q.setColorFilter(Color.parseColor(knVar5.r));
                    } else if (i == 2) {
                        knVar.o.setColorFilter(Color.parseColor(knVar.t));
                        kn knVar6 = kn.this;
                        knVar6.p.setColorFilter(Color.parseColor(knVar6.r));
                        kn knVar7 = kn.this;
                        knVar7.q.setColorFilter(Color.parseColor(knVar7.s));
                    } else if (i == 3) {
                        knVar.o.setColorFilter(Color.parseColor(knVar.r));
                        kn knVar8 = kn.this;
                        knVar8.p.setColorFilter(Color.parseColor(knVar8.s));
                        kn knVar9 = kn.this;
                        knVar9.q.setColorFilter(Color.parseColor(knVar9.t));
                    }
                } else {
                    kn knVar10 = kn.this;
                    if (knVar10.j.equals(knVar10.g)) {
                        knVar = kn.this;
                        i = knVar.n;
                        if (i == 1) {
                            knVar.o.setColorFilter(Color.parseColor(knVar.s));
                            kn knVar11 = kn.this;
                            knVar11.p.setColorFilter(Color.parseColor(knVar11.t));
                            kn knVar12 = kn.this;
                            knVar12.q.setColorFilter(Color.parseColor(knVar12.r));
                        } else if (i == 2) {
                            knVar.o.setColorFilter(Color.parseColor(knVar.t));
                            kn knVar13 = kn.this;
                            knVar13.p.setColorFilter(Color.parseColor(knVar13.r));
                            kn knVar14 = kn.this;
                            knVar14.q.setColorFilter(Color.parseColor(knVar14.s));
                        } else if (i == 3) {
                            knVar.o.setColorFilter(Color.parseColor(knVar.r));
                            kn knVar15 = kn.this;
                            knVar15.p.setColorFilter(Color.parseColor(knVar15.s));
                            kn knVar16 = kn.this;
                            knVar16.q.setColorFilter(Color.parseColor(knVar16.t));
                        }
                    } else {
                        kn knVar17 = kn.this;
                        if (knVar17.i.equals(knVar17.g)) {
                            knVar2 = kn.this;
                            i2 = knVar2.n;
                            if (i2 == 1) {
                                knVar2.o.setColorFilter(Color.parseColor(knVar2.r));
                                kn knVar18 = kn.this;
                                knVar18.p.setColorFilter(Color.parseColor(knVar18.t));
                                kn knVar19 = kn.this;
                                knVar19.q.setColorFilter(Color.parseColor(knVar19.s));
                            } else if (i2 == 2) {
                                knVar2.o.setColorFilter(Color.parseColor(knVar2.s));
                                kn knVar20 = kn.this;
                                knVar20.p.setColorFilter(Color.parseColor(knVar20.r));
                                kn knVar21 = kn.this;
                                knVar21.q.setColorFilter(Color.parseColor(knVar21.t));
                            } else if (i2 == 3) {
                                knVar2.o.setColorFilter(Color.parseColor(knVar2.t));
                                kn knVar22 = kn.this;
                                knVar22.p.setColorFilter(Color.parseColor(knVar22.s));
                                kn knVar23 = kn.this;
                                knVar23.q.setColorFilter(Color.parseColor(knVar23.r));
                            }
                        } else {
                            kn knVar24 = kn.this;
                            if (knVar24.k.equals(knVar24.g)) {
                                knVar2 = kn.this;
                                i2 = knVar2.n;
                                if (i2 == 1) {
                                    knVar2.o.setColorFilter(Color.parseColor(knVar2.r));
                                    kn knVar110 = kn.this;
                                    knVar110.p.setColorFilter(Color.parseColor(knVar110.t));
                                    kn knVar111 = kn.this;
                                    knVar111.q.setColorFilter(Color.parseColor(knVar111.s));
                                } else if (i2 == 2) {
                                    knVar2.o.setColorFilter(Color.parseColor(knVar2.s));
                                    kn knVar25 = kn.this;
                                    knVar25.p.setColorFilter(Color.parseColor(knVar25.r));
                                    kn knVar26 = kn.this;
                                    knVar26.q.setColorFilter(Color.parseColor(knVar26.t));
                                } else if (i2 == 3) {
                                    knVar2.o.setColorFilter(Color.parseColor(knVar2.t));
                                    kn knVar27 = kn.this;
                                    knVar27.p.setColorFilter(Color.parseColor(knVar27.s));
                                    kn knVar28 = kn.this;
                                    knVar28.q.setColorFilter(Color.parseColor(knVar28.r));
                                }
                            }
                        }
                    }
                }
                kn knVar29 = kn.this;
                if (knVar29.n >= 3) {
                    knVar29.n = 0;
                }
                ValueAnimator valueAnimator = knVar29.m;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface d {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public kn(Context context, AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, String str, String str2) {
        try {
            this.f27479a = context;
            this.b = scrollClickBean;
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanA = a(scrollClickBean.getOrderData(), str2);
            if (orderDataScrollViewOrderBeanA != null && orderDataScrollViewOrderBeanA.getScrollClick() != null) {
                this.c = orderDataScrollViewOrderBeanA.getScrollClick();
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.c;
            if (scrollClickBean2 != null) {
                this.g = scrollClickBean2.getScrollDirection();
                this.l = this.c.getScrollDistance();
                this.d = this.c.getPosition();
            } else {
                AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.b;
                if (scrollClickBean3 != null) {
                    this.g = scrollClickBean3.getScrollDirection();
                    this.l = this.b.getScrollDistance();
                    this.d = this.b.getPosition();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new a());
    }

    private void d() {
        this.u.setGravity(17);
        int i = this.u.getLayoutParams().width;
        int i2 = this.u.getLayoutParams().height;
        this.o = new ImageView(this.f27479a);
        this.p = new ImageView(this.f27479a);
        this.q = new ImageView(this.f27479a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.h.equals(this.g)) {
            this.u.setOrientation(1);
            ImageView imageView = this.o;
            int i3 = R.mipmap.beizi_interaction_icon_arrow_up;
            imageView.setImageResource(i3);
            this.p.setImageResource(i3);
            this.q.setImageResource(i3);
            this.o.setColorFilter(Color.parseColor(this.r));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.t));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.i.equals(this.g)) {
            this.u.setOrientation(1);
            ImageView imageView2 = this.o;
            int i4 = R.mipmap.beizi_interaction_icon_arrow_down;
            imageView2.setImageResource(i4);
            this.p.setImageResource(i4);
            this.q.setImageResource(i4);
            this.o.setColorFilter(Color.parseColor(this.t));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.r));
            layoutParams.width = i;
            layoutParams.height = i2 / 3;
        } else if (this.j.equals(this.g)) {
            this.u.setOrientation(0);
            ImageView imageView3 = this.o;
            int i5 = R.mipmap.beizi_interaction_icon_arrow_left;
            imageView3.setImageResource(i5);
            this.p.setImageResource(i5);
            this.q.setImageResource(i5);
            this.o.setColorFilter(Color.parseColor(this.r));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.t));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        } else if (this.k.equals(this.g)) {
            this.u.setOrientation(0);
            ImageView imageView4 = this.o;
            int i6 = R.mipmap.beizi_interaction_icon_arrow_right;
            imageView4.setImageResource(i6);
            this.p.setImageResource(i6);
            this.q.setImageResource(i6);
            this.o.setColorFilter(Color.parseColor(this.t));
            this.p.setColorFilter(Color.parseColor(this.s));
            this.q.setColorFilter(Color.parseColor(this.r));
            layoutParams.width = i / 3;
            layoutParams.height = i2;
        }
        this.u.addView(this.o, layoutParams);
        this.u.addView(this.p, layoutParams);
        this.u.addView(this.q, layoutParams);
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void b(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f27479a == null) {
                    return;
                }
                this.u = new LinearLayout(this.f27479a);
                int[] iArrA = a(viewGroup);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    int i = iArrA[0];
                    if (i > 0) {
                        layoutParams.width = i;
                    }
                    int i2 = iArrA[1];
                    if (i2 > 0) {
                        layoutParams.height = i2;
                    }
                    layoutParams.leftMargin = iArrA[2];
                    layoutParams.topMargin = iArrA[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(this.u, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    int i3 = iArrA[0];
                    if (i3 > 0) {
                        layoutParams2.width = i3;
                    }
                    int i4 = iArrA[1];
                    if (i4 > 0) {
                        layoutParams2.height = i4;
                    }
                    layoutParams2.leftMargin = iArrA[2];
                    layoutParams2.topMargin = iArrA[3];
                    viewGroup.addView(this.u, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int i5 = iArrA[0];
                    if (i5 > 0) {
                        layoutParams3.width = i5;
                    }
                    int i6 = iArrA[1];
                    if (i6 > 0) {
                        layoutParams3.height = i6;
                    }
                    layoutParams3.leftMargin = iArrA[2];
                    layoutParams3.topMargin = iArrA[3];
                    viewGroup.addView(this.u, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    int i7 = iArrA[0];
                    if (i7 > 0) {
                        layoutParams4.width = i7;
                    }
                    int i8 = iArrA[1];
                    if (i8 > 0) {
                        layoutParams4.height = i8;
                    }
                    viewGroup.addView(this.u, layoutParams4);
                }
                d();
                a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0167 A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0036, B:13:0x003d, B:15:0x0043, B:18:0x004a, B:20:0x0065, B:21:0x006b, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x016c A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0036, B:13:0x003d, B:15:0x0043, B:18:0x004a, B:20:0x0065, B:21:0x006b, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x0010 }] */
    private int[] a(ViewGroup viewGroup) {
        int i;
        int i2;
        int i3;
        int i4;
        int iA;
        int iA2;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean = this.d;
                if (scrollClickPositionBean != null) {
                    String centerX = scrollClickPositionBean.getCenterX();
                    String top = this.d.getTop();
                    String width = this.d.getWidth();
                    String height = this.d.getHeight();
                    if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                        centerX = "10";
                    }
                    if (TextUtils.isEmpty(top) || "0".equals(top)) {
                        top = "10";
                    }
                    viewGroup.measure(0, 0);
                    int iB = bq.b(this.f27479a, viewGroup.getMeasuredWidth());
                    int iB2 = bq.b(this.f27479a, viewGroup.getMeasuredHeight());
                    if (iB <= 0) {
                        iB = to.j(this.f27479a);
                    }
                    kh.a("ScrollUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().width + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().height);
                    if (TextUtils.isEmpty(width) || "0".equals(width)) {
                        width = "20";
                    }
                    if (TextUtils.isEmpty(height) || "0".equals(height)) {
                        height = "20";
                    }
                    if (centerX.endsWith("%")) {
                        i = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * iB) / 100;
                    } else {
                        i = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                    }
                    if (top.endsWith("%")) {
                        i2 = (iB2 * Integer.parseInt(top.substring(0, top.indexOf("%")))) / 100;
                    } else {
                        i2 = !TextUtils.isEmpty(top) ? Integer.parseInt(top) : 0;
                    }
                    int i5 = 20;
                    if (width.endsWith("%")) {
                        i3 = (iB * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                    } else {
                        i3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                    }
                    if (!height.endsWith("%")) {
                        if (!TextUtils.isEmpty(width)) {
                            i4 = Integer.parseInt(height);
                        }
                        int iA3 = bq.a(this.f27479a, i3);
                        int iA4 = bq.a(this.f27479a, i5);
                        iA = bq.a(this.f27479a, i);
                        iA2 = bq.a(this.f27479a, i2);
                        iArr[0] = iA3;
                        iArr[1] = iA4;
                        if (iA > 0) {
                            iArr[2] = iA;
                        }
                        if (iA2 > 0) {
                            iArr[3] = iA2;
                        }
                        kh.a("ScrollUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + top);
                        return iArr;
                    }
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                    i5 = i4;
                    int iA5 = bq.a(this.f27479a, i3);
                    int iA6 = bq.a(this.f27479a, i5);
                    iA = bq.a(this.f27479a, i);
                    iA2 = bq.a(this.f27479a, i2);
                    iArr[0] = iA5;
                    iArr[1] = iA6;
                    if (iA > 0) {
                        iArr[2] = iA;
                    }
                    if (iA2 > 0) {
                        iArr[3] = iA2;
                    }
                    kh.a("ScrollUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + top);
                    return iArr;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return iArr;
            }
        }
        int iA7 = bq.a(this.f27479a, 20.0f);
        int iA8 = bq.a(this.f27479a, 10.0f);
        iArr[0] = iA7;
        iArr[1] = iA7;
        iArr[2] = iA8;
        iArr[3] = iA8;
        return iArr;
    }

    public void b() {
        try {
            this.f = null;
            this.e = null;
            this.c = null;
            this.b = null;
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.m.removeAllListeners();
            }
            this.m = null;
            this.o = null;
            this.p = null;
            this.q = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(View view, d dVar) {
        this.f = view;
        this.e = dVar;
        c();
    }

    private void a() {
        try {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, 0);
            this.m = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(500L);
            this.m.addUpdateListener(new b());
            this.m.addListener(new c());
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean = (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean) it.next();
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }
}
