package com.beizi.fusion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollArcView;
import com.beizi.fusion.widget.ScrollClickView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class jn {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27446a;
    private FrameLayout b;
    private ImageView c;
    private FrameLayout d;
    private ScrollArcView e;
    private TextView f;
    private TextView g;
    private AnimatorSet h;
    private AnimatorSet i;
    private AnimatorSet j;
    private AnimatorSet k;
    private AnimatorSet l;
    private AnimatorSet m;
    private f n;
    private AdSpacesBean.BuyerBean.ScrollClickBean o;
    private int p;
    private String q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private View v;
    private View w;
    private boolean x;
    private boolean y;
    private int z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jn jnVar = jn.this;
            if (jnVar.x) {
                return;
            }
            double d = jnVar.t;
            int[] iArr = {((int) (0.1d * d)) / 2, (int) (((double) jnVar.u) * 0.8d)};
            int[] iArrB = ol.b(((int) (d * 0.9d)) / 2, so.a(jnVar.f27446a, 65.0f) / 2);
            jn.this.a(String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]));
        }
    }

    public class b implements Runnable {

        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    AnimatorSet animatorSet = jn.this.l;
                    if (animatorSet != null) {
                        animatorSet.start();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("all".equalsIgnoreCase(jn.this.q)) {
                    jn.this.g();
                    return;
                }
                jn.this.h();
                jn.this.f();
                jn.this.e();
                jn.this.i();
                jn.this.l = new AnimatorSet();
                if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(jn.this.q) || ScrollClickView.DIR_UP.equalsIgnoreCase(jn.this.q)) {
                    jn jnVar = jn.this;
                    jnVar.l.playTogether(jnVar.h, jnVar.j, jnVar.i, jnVar.k);
                } else {
                    jn jnVar2 = jn.this;
                    jnVar2.l.playTogether(jnVar2.h, jnVar2.k);
                }
                jn.this.l.addListener(new a());
                jn.this.l.start();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27450a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:17:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:19:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:21:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:25:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:26:0x0193  */
        /* JADX WARN: Code duplicated, block: B:28:0x019c  */
        /* JADX WARN: Code duplicated, block: B:30:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:32:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:34:0x01bf  */
        /* JADX WARN: Code duplicated, block: B:35:0x0256  */
        /* JADX WARN: Code duplicated, block: B:37:0x025f  */
        /* JADX WARN: Code duplicated, block: B:39:0x026e  */
        /* JADX WARN: Code duplicated, block: B:41:0x027a  */
        /* JADX WARN: Code duplicated, block: B:43:0x0282  */
        /* JADX WARN: Code duplicated, block: B:44:0x0319  */
        /* JADX WARN: Code duplicated, block: B:46:0x0322  */
        /* JADX WARN: Code duplicated, block: B:48:0x0331  */
        /* JADX WARN: Instruction removed from duplicated block: B:25:0x00fc, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:34:0x01bf, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:43:0x0282, please report this as an issue */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float f;
            float f2;
            float f3;
            float f4;
            float fAbs;
            jn jnVar;
            float fAbs2;
            jn jnVar2;
            float fAbs3;
            jn jnVar3;
            float fAbs4;
            jn jnVar4;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27450a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
            } else if (action == 1) {
                jn jnVar5 = jn.this;
                if (jnVar5.z != 1) {
                    f = this.d - this.b;
                    if (f > 0.0f) {
                        fAbs4 = Math.abs(f);
                        jnVar4 = jn.this;
                        if (fAbs4 > jnVar4.p) {
                            f2 = this.d - this.b;
                            if (f2 < 0.0f) {
                                fAbs3 = Math.abs(f2);
                                jnVar3 = jn.this;
                                if (fAbs3 > jnVar3.p) {
                                    f3 = this.c - this.f27450a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        jnVar2 = jn.this;
                                        if (fAbs2 > jnVar2.p) {
                                            f4 = this.c - this.f27450a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                jnVar = jn.this;
                                                if (fAbs > jnVar.p && ("right".equalsIgnoreCase(jnVar.q) || jn.this.r)) {
                                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(jnVar2.q) || jn.this.r) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(jnVar3.q) || jn.this.r) {
                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27450a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    jnVar2 = jn.this;
                                    if (fAbs2 > jnVar2.p) {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27450a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        jnVar = jn.this;
                                        if (fAbs > jnVar.p) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                }
                            }
                        } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(jnVar4.q) || jn.this.r) {
                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        f2 = this.d - this.b;
                        if (f2 < 0.0f) {
                            fAbs3 = Math.abs(f2);
                            jnVar3 = jn.this;
                            if (fAbs3 > jnVar3.p) {
                                f3 = this.c - this.f27450a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    jnVar2 = jn.this;
                                    if (fAbs2 > jnVar2.p) {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27450a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        jnVar = jn.this;
                                        if (fAbs > jnVar.p) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                }
                            } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(jnVar3.q)) {
                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            } else {
                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f3 = this.c - this.f27450a;
                            if (f3 < 0.0f) {
                                fAbs2 = Math.abs(f3);
                                jnVar2 = jn.this;
                                if (fAbs2 > jnVar2.p) {
                                    f4 = this.c - this.f27450a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        jnVar = jn.this;
                                        if (fAbs > jnVar.p) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f4 = this.c - this.f27450a;
                                if (f4 > 0.0f) {
                                    fAbs = Math.abs(f4);
                                    jnVar = jn.this;
                                    if (fAbs > jnVar.p) {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                }
                            }
                        }
                    }
                } else if (jnVar5.a(this.e, this.f)) {
                    jn jnVar6 = jn.this;
                    if (jnVar6.y) {
                        jnVar6.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    } else {
                        f = this.d - this.b;
                        if (f > 0.0f) {
                            fAbs4 = Math.abs(f);
                            jnVar4 = jn.this;
                            if (fAbs4 > jnVar4.p) {
                                f2 = this.d - this.b;
                                if (f2 < 0.0f) {
                                    fAbs3 = Math.abs(f2);
                                    jnVar3 = jn.this;
                                    if (fAbs3 > jnVar3.p) {
                                        f3 = this.c - this.f27450a;
                                        if (f3 < 0.0f) {
                                            fAbs2 = Math.abs(f3);
                                            jnVar2 = jn.this;
                                            if (fAbs2 > jnVar2.p) {
                                                f4 = this.c - this.f27450a;
                                                if (f4 > 0.0f) {
                                                    fAbs = Math.abs(f4);
                                                    jnVar = jn.this;
                                                    if (fAbs > jnVar.p) {
                                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                    }
                                                }
                                            } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            } else {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        } else {
                                            f4 = this.c - this.f27450a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                jnVar = jn.this;
                                                if (fAbs > jnVar.p) {
                                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        }
                                    } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(jnVar3.q)) {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f3 = this.c - this.f27450a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        jnVar2 = jn.this;
                                        if (fAbs2 > jnVar2.p) {
                                            f4 = this.c - this.f27450a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                jnVar = jn.this;
                                                if (fAbs > jnVar.p) {
                                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                }
                            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(jnVar4.q)) {
                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            } else {
                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f2 = this.d - this.b;
                            if (f2 < 0.0f) {
                                fAbs3 = Math.abs(f2);
                                jnVar3 = jn.this;
                                if (fAbs3 > jnVar3.p) {
                                    f3 = this.c - this.f27450a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        jnVar2 = jn.this;
                                        if (fAbs2 > jnVar2.p) {
                                            f4 = this.c - this.f27450a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                jnVar = jn.this;
                                                if (fAbs > jnVar.p) {
                                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(jnVar3.q)) {
                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27450a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    jnVar2 = jn.this;
                                    if (fAbs2 > jnVar2.p) {
                                        f4 = this.c - this.f27450a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            jnVar = jn.this;
                                            if (fAbs > jnVar.p) {
                                                jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(jnVar2.q)) {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27450a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        jnVar = jn.this;
                                        if (fAbs > jnVar.p) {
                                            jn.this.a(this.f27450a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                }
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

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f27451a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        public d(float f, float f2, float f3, float f4) {
            this.f27451a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f = this.f27451a;
                float f2 = f + ((this.b - f) * animatedFraction);
                float f3 = this.c;
                float f4 = f3 + ((this.d - f3) * animatedFraction);
                jn jnVar = jn.this;
                float fMax = Math.max(jnVar.G, Math.min(f2, jnVar.H));
                jn jnVar2 = jn.this;
                float fMax2 = Math.max(jnVar2.I, Math.min(f4, jnVar2.J));
                jn jnVar3 = jn.this;
                ImageView imageView = jnVar3.c;
                if (imageView != null) {
                    imageView.setX(fMax - jnVar3.E);
                    jn jnVar4 = jn.this;
                    jnVar4.c.setY(fMax2 - jnVar4.F);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements Runnable {

        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    AnimatorSet animatorSet = jn.this.m;
                    if (animatorSet != null) {
                        animatorSet.start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                jn jnVar = jn.this;
                FrameLayout frameLayout = jnVar.b;
                if (frameLayout != null && jnVar.c != null) {
                    jnVar.A = frameLayout.getWidth();
                    jn jnVar2 = jn.this;
                    jnVar2.B = jnVar2.b.getHeight();
                    jn jnVar3 = jn.this;
                    jnVar3.C = jnVar3.c.getWidth();
                    jn jnVar4 = jn.this;
                    jnVar4.D = jnVar4.c.getHeight();
                    jn jnVar5 = jn.this;
                    int i = jnVar5.C / 2;
                    jnVar5.E = i;
                    int i2 = jnVar5.D / 2;
                    jnVar5.F = i2;
                    jnVar5.G = i;
                    jnVar5.H = jnVar5.A - i;
                    jnVar5.I = i2;
                    jnVar5.J = jnVar5.B - i2;
                    jnVar5.m = new AnimatorSet();
                    jn jnVar6 = jn.this;
                    AnimatorSet animatorSet = jnVar6.m;
                    int i3 = jnVar6.G;
                    int i4 = jnVar6.H - i3;
                    jn jnVar7 = jn.this;
                    float f = jnVar7.G;
                    int i5 = jnVar7.I;
                    int i6 = jnVar7.J - i5;
                    jn jnVar8 = jn.this;
                    jn jnVar9 = jn.this;
                    animatorSet.playSequentially(jnVar6.a((i4 / 2) + i3, jnVar6.I, i3 + (i4 / 2), jnVar6.J), jnVar7.a(f, (i6 / 2) + i5, jnVar7.H, i5 + (i6 / 2)), jnVar8.a(jnVar8.G, jnVar8.I, jnVar8.H, jnVar8.J), jnVar9.a(jnVar9.H, jnVar9.I, jnVar9.G, jnVar9.J));
                    jn.this.m.setDuration(1000L);
                    jn.this.m.setInterpolator(new AccelerateDecelerateInterpolator());
                    jn.this.m.addListener(new a());
                    jn.this.m.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface f {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public jn(Context context) {
        this.f27446a = context;
    }

    private void b() {
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.i = null;
        AnimatorSet animatorSet2 = this.k;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.k = null;
        AnimatorSet animatorSet3 = this.j;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.j = null;
        AnimatorSet animatorSet4 = this.h;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        this.h = null;
        AnimatorSet animatorSet5 = this.l;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
        }
        AnimatorSet animatorSet6 = this.m;
        if (animatorSet6 != null) {
            animatorSet6.cancel();
        }
        this.m = null;
        this.l = null;
    }

    private void d() {
        String downloadDetails;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.o;
            if (scrollClickBean != null) {
                String title = scrollClickBean.getTitle();
                if (this.f != null) {
                    if (!TextUtils.isEmpty(title)) {
                        this.f.setText(title);
                    }
                    int titleFont = this.o.getTitleFont();
                    if (titleFont > 0) {
                        this.f.setTextSize(2, titleFont);
                    }
                }
                if (this.s) {
                    downloadDetails = this.o.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "下载应用";
                    }
                } else {
                    downloadDetails = this.o.getDetails();
                }
                int detailsFont = this.o.getDetailsFont();
                if (this.g != null) {
                    if (!TextUtils.isEmpty(downloadDetails)) {
                        this.g.setText(downloadDetails);
                    }
                    if (detailsFont > 0) {
                        this.g.setTextSize(2, detailsFont);
                    }
                }
            }
            String height = this.o.getPosition().getHeight();
            if (TextUtils.isEmpty(height) || "0".equals(height)) {
                height = "180";
            }
            int i = height.endsWith("%") ? (this.u * Integer.parseInt(height.substring(0, height.indexOf("%")))) / 100 : so.a(this.f27446a, Integer.parseInt(height));
            int iA = so.a(this.f27446a, 110.0f);
            if (this.e != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i + 100);
                layoutParams.topMargin = iA;
                this.e.setLayoutParams(layoutParams);
            }
            int iA2 = so.a(this.f27446a, 200.0f);
            if (this.b != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA2, iA2);
                layoutParams2.topMargin = iA - (iA2 / 2);
                layoutParams2.gravity = 1;
                this.b.setLayoutParams(layoutParams2);
            }
            if (this.c != null) {
                int iA3 = so.a(this.f27446a, 45.0f);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA3, iA3);
                if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.q)) {
                    layoutParams3.gravity = 17;
                } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.q)) {
                    layoutParams3.gravity = 49;
                } else if ("left".equalsIgnoreCase(this.q) || "right".equalsIgnoreCase(this.q) || "all".equalsIgnoreCase(this.q)) {
                    layoutParams3.gravity = 17;
                }
                this.c.setLayoutParams(layoutParams3);
            }
            if (this.d != null) {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, i + 100);
                layoutParams4.topMargin = iA - 50;
                this.d.setLayoutParams(layoutParams4);
            }
            if (this.w != null) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = (this.u - i) - iA;
                this.w.setLayoutParams(layoutParams5);
            }
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ScrollArcView scrollArcView = this.e;
            if (scrollArcView == null) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(scrollArcView, "alpha", 0.3f, 0.45f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "alpha", 0.45f, 0.3f);
            objectAnimatorOfFloat.setDuration(700L);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat2.setDuration(300L);
            objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.k = animatorSet;
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        try {
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.q)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.1f, 1.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.1f, 1.0f);
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.q)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.1f, 1.0f, 1.1f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.1f, 1.0f, 1.1f);
            } else {
                if (!"left".equalsIgnoreCase(this.q)) {
                    "right".equalsIgnoreCase(this.q);
                }
                objectAnimatorOfFloat = null;
                objectAnimatorOfFloat2 = null;
            }
            if (objectAnimatorOfFloat != null) {
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat2 != null) {
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat == null || objectAnimatorOfFloat2 == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.i = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.i.setDuration(1000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            this.b.post(new e());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        try {
            int iA = so.a(this.f27446a, 80.0f);
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.q)) {
                float f2 = -iA;
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, f2);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", f2, 0.0f);
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.q)) {
                float f3 = iA;
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, f3);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", f3, 0.0f);
            } else if ("left".equalsIgnoreCase(this.q)) {
                int i = -iA;
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationX", iA / 2, i / 2);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationX", i / 2, iA / 2);
            } else if ("right".equalsIgnoreCase(this.q)) {
                int i2 = -iA;
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationX", i2 / 2, iA / 2);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationX", iA / 2, i2 / 2);
            } else {
                objectAnimatorOfFloat = null;
                objectAnimatorOfFloat2 = null;
            }
            if (objectAnimatorOfFloat != null) {
                objectAnimatorOfFloat.setDuration(700L);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat2 != null) {
                objectAnimatorOfFloat2.setDuration(300L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat == null || objectAnimatorOfFloat2 == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.h = animatorSet;
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        try {
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.q)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, -80.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "translationY", -80.0f, 0.0f);
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.q)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", -80.0f, 0.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, -80.0f);
            } else {
                if (!"left".equalsIgnoreCase(this.q)) {
                    "right".equalsIgnoreCase(this.q);
                }
                objectAnimatorOfFloat = null;
                objectAnimatorOfFloat2 = null;
            }
            if (objectAnimatorOfFloat != null) {
                objectAnimatorOfFloat.setDuration(700L);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat2 != null) {
                objectAnimatorOfFloat2.setDuration(300L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            }
            if (objectAnimatorOfFloat == null || objectAnimatorOfFloat2 == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.j = animatorSet;
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } catch (Exception unused) {
        }
    }

    private void j() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.o;
            if (scrollClickBean == null) {
                return;
            }
            int randomClickNum = scrollClickBean.getRandomClickNum();
            int randomClickTime = this.o.getRandomClickTime();
            Pair pairA = a(randomClickNum);
            if (((Boolean) pairA.second).booleanValue()) {
                b9.a(new a(), randomClickTime + (((Integer) pairA.first).intValue() * 10));
            }
        } catch (Exception unused) {
        }
    }

    public View a(View view) {
        try {
            this.v = view;
            View viewInflate = LayoutInflater.from(this.f27446a).inflate(R.layout.beizi_scroll_slide_view, (ViewGroup) null);
            this.w = viewInflate;
            this.b = (FrameLayout) viewInflate.findViewById(R.id.slide_hand_container);
            this.c = (ImageView) this.w.findViewById(R.id.slide_hand);
            this.e = (ScrollArcView) this.w.findViewById(R.id.slide_arc);
            this.d = (FrameLayout) this.w.findViewById(R.id.slide_text_container);
            this.f = (TextView) this.w.findViewById(R.id.slide_title);
            this.g = (TextView) this.w.findViewById(R.id.slide_detail);
            d();
            return this.w;
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        try {
            b();
            this.f27446a = null;
            this.w = null;
        } catch (Exception unused) {
        }
    }

    public void k() {
        try {
            this.e.post(new b());
        } catch (Exception unused) {
        }
    }

    public void a(f fVar) {
        this.n = fVar;
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, boolean z, boolean z2, int i, int i2) {
        this.o = scrollClickBean;
        this.r = z;
        this.s = z2;
        this.t = i;
        this.u = i2;
        if (i <= 0) {
            this.t = so.j(this.f27446a);
        }
        if (this.u <= 0) {
            this.u = so.g(this.f27446a);
        }
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.o;
        if (scrollClickBean2 != null) {
            this.p = so.a(this.f27446a, scrollClickBean2.getScrollDistance());
            this.q = this.o.getScrollDirection();
            this.y = this.o.getSupportClick() == 1;
            this.z = this.o.getRegionalSlide();
        }
        if (this.o.getAnimation() == 0 && this.r) {
            this.q = "all";
        }
        j();
    }

    public static Pair a(int i) {
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        if (iRandom <= i) {
            return new Pair(Integer.valueOf(iRandom), Boolean.TRUE);
        }
        return new Pair(Integer.valueOf(iRandom), Boolean.FALSE);
    }

    private void a() {
        try {
            View view = this.v;
            if (view == null) {
                return;
            }
            view.setOnTouchListener(new c());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f2, float f3) {
        try {
            if (this.e == null) {
                return false;
            }
            Rect rect = new Rect();
            this.e.getGlobalVisibleRect(rect);
            return rect.contains((int) f2, (int) f3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator a(float f2, float f3, float f4, float f5) {
        try {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new d(f2, f4, f3, f5));
            return valueAnimatorOfFloat;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            f fVar = this.n;
            if (fVar == null) {
                return;
            }
            this.x = true;
            fVar.a(str, str2, str3, str4, str5, str6, str7, str8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
