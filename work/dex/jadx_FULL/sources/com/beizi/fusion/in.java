package com.beizi.fusion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollArcView;
import com.beizi.fusion.widget.ScrollClickView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27414a;
    private FrameLayout b;
    private ScrollArcView c;
    private TextView d;
    private TextView e;
    private AnimatorSet f;
    private AnimatorSet g;
    private AnimatorSet h;
    private AnimatorSet i;
    private AnimatorSet j;
    private d k;
    private AdSpacesBean.BuyerBean.ScrollClickBean l;
    private int m;
    private String n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private View s;
    private View t;
    private boolean u;
    private boolean v;
    private int w;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            in inVar = in.this;
            if (inVar.u) {
                return;
            }
            double d = inVar.q;
            int[] iArr = {((int) (0.1d * d)) / 2, (int) (((double) inVar.r) * 0.8d)};
            int[] iArrB = ol.b(((int) (d * 0.9d)) / 2, so.a(inVar.f27414a, 65.0f) / 2);
            in.this.a(String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]));
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
                    AnimatorSet animatorSet = in.this.i;
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
                in.this.f();
                in.this.e();
                in.this.g();
                in.this.i = new AnimatorSet();
                if ("all".equals(in.this.n)) {
                    in inVar = in.this;
                    inVar.i.playTogether(inVar.f, inVar.h);
                } else {
                    in inVar2 = in.this;
                    inVar2.i.playTogether(inVar2.g, inVar2.f, inVar2.h);
                }
                in.this.i.addListener(new a());
                in.this.i.start();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27418a;
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
            in inVar;
            float fAbs2;
            in inVar2;
            float fAbs3;
            in inVar3;
            float fAbs4;
            in inVar4;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27418a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
            } else if (action == 1) {
                in inVar5 = in.this;
                if (inVar5.w != 1) {
                    f = this.d - this.b;
                    if (f > 0.0f) {
                        fAbs4 = Math.abs(f);
                        inVar4 = in.this;
                        if (fAbs4 > inVar4.m) {
                            f2 = this.d - this.b;
                            if (f2 < 0.0f) {
                                fAbs3 = Math.abs(f2);
                                inVar3 = in.this;
                                if (fAbs3 > inVar3.m) {
                                    f3 = this.c - this.f27418a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        inVar2 = in.this;
                                        if (fAbs2 > inVar2.m) {
                                            f4 = this.c - this.f27418a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                inVar = in.this;
                                                if (fAbs > inVar.m && ("right".equalsIgnoreCase(inVar.n) || in.this.o)) {
                                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(inVar2.n) || in.this.o) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(inVar3.n) || in.this.o) {
                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27418a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    inVar2 = in.this;
                                    if (fAbs2 > inVar2.m) {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27418a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        inVar = in.this;
                                        if (fAbs > inVar.m) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                }
                            }
                        } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(inVar4.n) || in.this.o) {
                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        f2 = this.d - this.b;
                        if (f2 < 0.0f) {
                            fAbs3 = Math.abs(f2);
                            inVar3 = in.this;
                            if (fAbs3 > inVar3.m) {
                                f3 = this.c - this.f27418a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    inVar2 = in.this;
                                    if (fAbs2 > inVar2.m) {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27418a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        inVar = in.this;
                                        if (fAbs > inVar.m) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                }
                            } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(inVar3.n)) {
                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            } else {
                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f3 = this.c - this.f27418a;
                            if (f3 < 0.0f) {
                                fAbs2 = Math.abs(f3);
                                inVar2 = in.this;
                                if (fAbs2 > inVar2.m) {
                                    f4 = this.c - this.f27418a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        inVar = in.this;
                                        if (fAbs > inVar.m) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    }
                                } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f4 = this.c - this.f27418a;
                                if (f4 > 0.0f) {
                                    fAbs = Math.abs(f4);
                                    inVar = in.this;
                                    if (fAbs > inVar.m) {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                }
                            }
                        }
                    }
                } else if (inVar5.a(this.e, this.f)) {
                    in inVar6 = in.this;
                    if (inVar6.v) {
                        inVar6.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    } else {
                        f = this.d - this.b;
                        if (f > 0.0f) {
                            fAbs4 = Math.abs(f);
                            inVar4 = in.this;
                            if (fAbs4 > inVar4.m) {
                                f2 = this.d - this.b;
                                if (f2 < 0.0f) {
                                    fAbs3 = Math.abs(f2);
                                    inVar3 = in.this;
                                    if (fAbs3 > inVar3.m) {
                                        f3 = this.c - this.f27418a;
                                        if (f3 < 0.0f) {
                                            fAbs2 = Math.abs(f3);
                                            inVar2 = in.this;
                                            if (fAbs2 > inVar2.m) {
                                                f4 = this.c - this.f27418a;
                                                if (f4 > 0.0f) {
                                                    fAbs = Math.abs(f4);
                                                    inVar = in.this;
                                                    if (fAbs > inVar.m) {
                                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                    }
                                                }
                                            } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            } else {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        } else {
                                            f4 = this.c - this.f27418a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                inVar = in.this;
                                                if (fAbs > inVar.m) {
                                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        }
                                    } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(inVar3.n)) {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f3 = this.c - this.f27418a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        inVar2 = in.this;
                                        if (fAbs2 > inVar2.m) {
                                            f4 = this.c - this.f27418a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                inVar = in.this;
                                                if (fAbs > inVar.m) {
                                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                }
                            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(inVar4.n)) {
                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            } else {
                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            f2 = this.d - this.b;
                            if (f2 < 0.0f) {
                                fAbs3 = Math.abs(f2);
                                inVar3 = in.this;
                                if (fAbs3 > inVar3.m) {
                                    f3 = this.c - this.f27418a;
                                    if (f3 < 0.0f) {
                                        fAbs2 = Math.abs(f3);
                                        inVar2 = in.this;
                                        if (fAbs2 > inVar2.m) {
                                            f4 = this.c - this.f27418a;
                                            if (f4 > 0.0f) {
                                                fAbs = Math.abs(f4);
                                                inVar = in.this;
                                                if (fAbs > inVar.m) {
                                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                                }
                                            }
                                        } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        } else {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                        }
                                    } else {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    }
                                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(inVar3.n)) {
                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                } else {
                                    in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else {
                                f3 = this.c - this.f27418a;
                                if (f3 < 0.0f) {
                                    fAbs2 = Math.abs(f3);
                                    inVar2 = in.this;
                                    if (fAbs2 > inVar2.m) {
                                        f4 = this.c - this.f27418a;
                                        if (f4 > 0.0f) {
                                            fAbs = Math.abs(f4);
                                            inVar = in.this;
                                            if (fAbs > inVar.m) {
                                                in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                            }
                                        }
                                    } else if ("left".equalsIgnoreCase(inVar2.n)) {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    } else {
                                        in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                    }
                                } else {
                                    f4 = this.c - this.f27418a;
                                    if (f4 > 0.0f) {
                                        fAbs = Math.abs(f4);
                                        inVar = in.this;
                                        if (fAbs > inVar.m) {
                                            in.this.a(this.f27418a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
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

    public interface d {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public in(Context context) {
        this.f27414a = context;
    }

    private void b() {
        AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f = null;
        AnimatorSet animatorSet2 = this.h;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.h = null;
        AnimatorSet animatorSet3 = this.g;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.g = null;
        AnimatorSet animatorSet4 = this.i;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        AnimatorSet animatorSet5 = this.j;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
        }
        this.j = null;
        this.i = null;
    }

    private void d() {
        String downloadDetails;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.l;
            if (scrollClickBean != null) {
                String title = scrollClickBean.getTitle();
                if (this.d != null) {
                    if (!TextUtils.isEmpty(title)) {
                        if ("left".equals(this.n) || "right".equals(this.n)) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                            for (int i = 0; i < title.length(); i++) {
                                if (i > 0) {
                                    spannableStringBuilder.append((CharSequence) "\n");
                                }
                                spannableStringBuilder.append(title.charAt(i));
                            }
                            this.d.setText(spannableStringBuilder);
                            this.d.setSingleLine(false);
                            this.d.setMaxLines(title.length());
                        } else {
                            this.d.setText(title);
                        }
                    }
                    int titleFont = this.l.getTitleFont();
                    if (titleFont > 0) {
                        this.d.setTextSize(2, titleFont);
                    }
                }
                if (this.p) {
                    downloadDetails = this.l.getDownloadDetails();
                    if (TextUtils.isEmpty(downloadDetails)) {
                        downloadDetails = "下载应用";
                    }
                } else {
                    downloadDetails = this.l.getDetails();
                }
                int detailsFont = this.l.getDetailsFont();
                if (this.e != null) {
                    if (!TextUtils.isEmpty(downloadDetails)) {
                        if ("left".equals(this.n) || "right".equals(this.n)) {
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                            for (int i2 = 0; i2 < downloadDetails.length(); i2++) {
                                if (i2 > 0) {
                                    spannableStringBuilder2.append((CharSequence) "\n");
                                }
                                spannableStringBuilder2.append(downloadDetails.charAt(i2));
                            }
                            this.e.setText(spannableStringBuilder2);
                            this.e.setSingleLine(false);
                            this.e.setMaxLines(downloadDetails.length());
                        } else {
                            this.e.setText(downloadDetails);
                        }
                    }
                    if (detailsFont > 0) {
                        this.e.setTextSize(2, detailsFont);
                    }
                }
            }
            AdSpacesBean.BuyerBean.ScrollClickPositionBean position = this.l.getPosition();
            String width = position.getWidth();
            String str = "180";
            if (TextUtils.isEmpty(width) || "0".equals(width)) {
                width = "180";
            }
            int i3 = width.endsWith("%") ? (this.q * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100 : so.a(this.f27414a, Integer.parseInt(width));
            String height = position.getHeight();
            if (!TextUtils.isEmpty(width) && !"0".equals(width)) {
                str = height;
            }
            int i4 = str.endsWith("%") ? (this.r * Integer.parseInt(str.substring(0, str.indexOf("%")))) / 100 : so.a(this.f27414a, Integer.parseInt(str));
            String top = position.getTop();
            String centerX = position.getCenterX();
            if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                centerX = "50%";
            }
            if (TextUtils.isEmpty(top) || "0".equals(top)) {
                top = "50%";
            }
            int i5 = centerX.endsWith("%") ? (this.q * Integer.parseInt(centerX.substring(0, centerX.indexOf("%")))) / 100 : so.a(this.f27414a, Integer.parseInt(centerX));
            int i6 = top.endsWith("%") ? (this.r * Integer.parseInt(top.substring(0, top.indexOf("%")))) / 100 : so.a(this.f27414a, Integer.parseInt(top));
            if (ScrollClickView.DIR_DOWN.equals(this.n)) {
                if (this.c != null) {
                    this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, i4 + 100));
                    this.c.setArcDirection(3);
                }
                if (this.b != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i4 + 100);
                    layoutParams.topMargin = 50;
                    this.b.setLayoutParams(layoutParams);
                }
                if (this.t != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = -100;
                    layoutParams2.height = i4 + 300;
                    layoutParams2.width = -1;
                    this.t.setLayoutParams(layoutParams2);
                }
            } else if ("left".equals(this.n)) {
                int i7 = i3 * 2;
                if (this.c != null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i7 + 10, -1);
                    layoutParams3.leftMargin = 150;
                    this.c.setLayoutParams(layoutParams3);
                    this.c.setArcHeight(i7);
                    this.c.setArcDirection(2);
                }
                if (this.b != null) {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((i7 + 10) / 2, -1);
                    layoutParams4.leftMargin = 150;
                    this.b.setLayoutParams(layoutParams4);
                }
                if (this.t != null) {
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams5.leftMargin = (this.q - ((i7 + 10) / 2)) - 150;
                    layoutParams5.height = -1;
                    layoutParams5.width = i7 + 150;
                    this.t.setLayoutParams(layoutParams5);
                }
            } else if ("right".equals(this.n)) {
                int i8 = i3 * 2;
                if (this.c != null) {
                    this.c.setLayoutParams(new FrameLayout.LayoutParams(i8 + 10, -1));
                    this.c.setArcHeight(i8);
                    this.c.setArcDirection(1);
                }
                if (this.b != null) {
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i8, -1);
                    layoutParams6.leftMargin = i8 / 4;
                    this.b.setLayoutParams(layoutParams6);
                }
                if (this.t != null) {
                    FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams7.leftMargin = (-(i8 + 10)) / 2;
                    layoutParams7.height = -1;
                    layoutParams7.width = i8 + 150;
                    this.t.setLayoutParams(layoutParams7);
                }
            } else if ("all".equals(this.n)) {
                if (this.c != null) {
                    FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(i3, i4);
                    layoutParams8.gravity = 17;
                    this.c.setLayoutParams(layoutParams8);
                    this.c.setArcDirection(4);
                }
                if (this.t != null) {
                    FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams9.height = i4 + 200;
                    int i9 = i3 + 200;
                    layoutParams9.width = i9;
                    layoutParams9.leftMargin = i5 - (i9 / 2);
                    layoutParams9.topMargin = i6 - 100;
                    this.t.setLayoutParams(layoutParams9);
                }
            }
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ScrollArcView scrollArcView = this.c;
            if (scrollArcView == null) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(scrollArcView, "alpha", 0.3f, 0.45f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", 0.45f, 0.3f);
            objectAnimatorOfFloat.setDuration(700L);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat2.setDuration(300L);
            objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.h = animatorSet;
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        try {
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.1f, 1.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.1f, 1.0f);
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.n) || "left".equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.1f, 1.0f, 1.1f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.1f, 1.0f, 1.1f);
            } else if ("right".equalsIgnoreCase(this.n) || "all".equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.1f, 1.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.1f, 1.0f);
            } else {
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
            this.f = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.f.setDuration(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        try {
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, 80.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", 80.0f, 0.0f);
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", 80.0f, 0.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, 80.0f);
            } else if ("left".equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationX", -80.0f, 0.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationX", 0.0f, -80.0f);
            } else if ("right".equalsIgnoreCase(this.n)) {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationX", 0.0f, 80.0f);
                objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "translationX", 80.0f, 0.0f);
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
            this.g = animatorSet;
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        } catch (Exception unused) {
        }
    }

    private void h() {
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.l;
            if (scrollClickBean == null) {
                return;
            }
            int randomClickNum = scrollClickBean.getRandomClickNum();
            int randomClickTime = this.l.getRandomClickTime();
            Pair pairA = a(randomClickNum);
            if (((Boolean) pairA.second).booleanValue()) {
                b9.a(new a(), randomClickTime + (((Integer) pairA.first).intValue() * 10));
            }
        } catch (Exception unused) {
        }
    }

    public View a(View view) {
        try {
            this.s = view;
            if (ScrollClickView.DIR_DOWN.equals(this.n)) {
                this.t = LayoutInflater.from(this.f27414a).inflate(R.layout.beizi_scroll_slide_view_down, (ViewGroup) null);
            } else if ("left".equals(this.n)) {
                this.t = LayoutInflater.from(this.f27414a).inflate(R.layout.beizi_scroll_slide_view_left, (ViewGroup) null);
            } else if ("right".equals(this.n)) {
                this.t = LayoutInflater.from(this.f27414a).inflate(R.layout.beizi_scroll_slide_view_right, (ViewGroup) null);
            } else if ("all".equals(this.n)) {
                this.t = LayoutInflater.from(this.f27414a).inflate(R.layout.beizi_scroll_slide_view_all, (ViewGroup) null);
            }
            this.c = (ScrollArcView) this.t.findViewById(R.id.slide_arc);
            this.b = (FrameLayout) this.t.findViewById(R.id.slide_text_container);
            this.d = (TextView) this.t.findViewById(R.id.slide_title);
            this.e = (TextView) this.t.findViewById(R.id.slide_detail);
            d();
            return this.t;
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        try {
            b();
            this.f27414a = null;
            this.t = null;
        } catch (Exception unused) {
        }
    }

    public void i() {
        try {
            this.c.post(new b());
        } catch (Exception unused) {
        }
    }

    public void a(d dVar) {
        this.k = dVar;
    }

    public void a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, boolean z, boolean z2, int i, int i2) {
        this.l = scrollClickBean;
        this.o = z;
        this.p = z2;
        this.q = i;
        this.r = i2;
        if (i <= 0) {
            this.q = so.j(this.f27414a);
        }
        if (this.r <= 0) {
            this.r = so.g(this.f27414a);
        }
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.l;
        if (scrollClickBean2 != null) {
            this.m = so.a(this.f27414a, scrollClickBean2.getScrollDistance());
            this.n = this.l.getScrollDirection();
            this.v = this.l.getSupportClick() == 1;
            this.w = this.l.getRegionalSlide();
        }
        if ("all".equals(this.n)) {
            this.o = true;
        }
        h();
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
            View view = this.s;
            if (view == null) {
                return;
            }
            view.setOnTouchListener(new c());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2) {
        try {
            if (this.c == null) {
                return false;
            }
            Rect rect = new Rect();
            this.c.getGlobalVisibleRect(rect);
            return rect.contains((int) f, (int) f2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            d dVar = this.k;
            if (dVar == null) {
                return;
            }
            this.u = true;
            dVar.a(str, str2, str3, str4, str5, str6, str7, str8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
