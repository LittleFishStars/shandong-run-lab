package com.huachenjie.works.external.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.works.R;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.h46;
import com.zj.adlib.n0a;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Q2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bL\u0010MB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bL\u0010NB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010O\u001a\u00020\u000f¢\u0006\u0004\bL\u0010PJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J.\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000fRT\u0010\"\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\u0016\u0010&R\"\u0010-\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010.R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010.R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010.R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010.\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00109\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010.\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010(\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010#R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010K\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010D\u001a\u0004\bI\u0010J¨\u0006R"}, d2 = {"Lcom/huachenjie/works/external/widget/BLOperateAnimView;", "Lcom/noober/background/view/BLLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "f", y6b.f, "", "d", "i", "needRecount", "k", "j", "", "animType", "quantity", "isChecked", "", yj7.g.WORKS_NO, "commentNo", "setCheckedState", "count", "setCheckedStateAtOnce", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "a", "Lkotlin/jvm/functions/Function2;", "getOnQuantityChangeCallback", "()Lkotlin/jvm/functions/Function2;", "setOnQuantityChangeCallback", "(Lkotlin/jvm/functions/Function2;)V", "onQuantityChangeCallback", "Z", "isCheckedState", "()Z", "(Z)V", "K", "I", "getAQuantity", "()I", "setAQuantity", "(I)V", "aQuantity", "Ljava/lang/String;", "quantityZeroName", "L", y6b.g, "getWorksAuthorNo", "()Ljava/lang/String;", "setWorksAuthorNo", "(Ljava/lang/String;)V", "worksAuthorNo", "getCommentUserNo", "setCommentUserNo", "commentUserNo", "M", "getSource", "setSource", "source", "b", "canClick", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnim", "Landroid/animation/AnimatorSet;", "Lkotlin/Lazy;", "getIconUnselectAnim", "()Landroid/animation/AnimatorSet;", "iconUnselectAnim", "Landroid/widget/TextView;", "getTvQuantity", "()Landroid/widget/TextView;", "tvQuantity", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BLOperateAnimView extends BLLinearLayout {
    public static final int ANIM_TYPE_ALUMNI_SAY = 4;
    public static final int ANIM_TYPE_ALUMNI_SAY_COMMENT = 5;
    public static final int ANIM_TYPE_COLLECT = 1;
    public static final int ANIM_TYPE_COMMENT = 3;
    public static final int ANIM_TYPE_LIKE = 2;
    public static final int ANIM_TYPE_POST_COMMENT = 8;
    public static final int ANIM_TYPE_POST_LIKE = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f37136a = 200;
    public static final long b = 600;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int aQuantity;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int animType;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public int source;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public LottieAnimationView lottieAnim;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy iconUnselectAnim;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function2<? super Boolean, ? super Integer, Unit> onQuantityChangeCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isCheckedState;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy tvQuantity;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean canClick;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String quantityZeroName;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String worksNo;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public String commentNo;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public String worksAuthorNo;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public String commentUserNo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BLOperateAnimView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void e(BLOperateAnimView bLOperateAnimView) {
        Intrinsics.checkNotNullParameter(bLOperateAnimView, "this$0");
        bLOperateAnimView.canClick = true;
    }

    private final AnimatorSet getIconUnselectAnim() {
        return (AnimatorSet) this.iconUnselectAnim.getValue();
    }

    private final TextView getTvQuantity() {
        return (TextView) this.tvQuantity.getValue();
    }

    public static final void h(BLOperateAnimView bLOperateAnimView, View view) {
        Intrinsics.checkNotNullParameter(bLOperateAnimView, "this$0");
        if (bLOperateAnimView.d()) {
            bLOperateAnimView.isCheckedState = !bLOperateAnimView.isCheckedState;
            LottieAnimationView lottieAnimationView = bLOperateAnimView.lottieAnim;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                lottieAnimationView = null;
            }
            lottieAnimationView.cancelAnimation();
            LottieAnimationView lottieAnimationView2 = bLOperateAnimView.lottieAnim;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setProgress(0.0f);
            if (bLOperateAnimView.isCheckedState) {
                LottieAnimationView lottieAnimationView3 = bLOperateAnimView.lottieAnim;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                    lottieAnimationView3 = null;
                }
                lottieAnimationView3.playAnimation();
            } else {
                bLOperateAnimView.getIconUnselectAnim().start();
            }
            bLOperateAnimView.i();
            updateQuantity$default(bLOperateAnimView, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCheckedState$lambda$4(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public static /* synthetic */ void updateQuantity$default(BLOperateAnimView bLOperateAnimView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        bLOperateAnimView.k(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        if (!this.canClick) {
            return false;
        }
        this.canClick = false;
        postDelayed(new Runnable() { // from class: com.zj.adlib.dk0
            @Override // java.lang.Runnable
            public final void run() {
                BLOperateAnimView.e(this.f41215a);
            }
        }, 600L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.OperateAnimView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.OperateAnimView)");
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OperateAnimView_works_anim_size, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OperateAnimView_works_anim_name);
        if (string == null) {
            string = "";
        }
        this.quantityZeroName = typedArrayObtainStyledAttributes.getString(R.styleable.OperateAnimView_works_quantity_zero_name);
        typedArrayObtainStyledAttributes.recycle();
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        lottieAnimationView.setAnimation(string);
        this.lottieAnim = lottieAnimationView;
        setGravity(17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        LottieAnimationView lottieAnimationView = this.lottieAnim;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
            lottieAnimationView = null;
        }
        addView(lottieAnimationView);
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.fk0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BLOperateAnimView.h(this.f41694a, view);
            }
        });
    }

    public final int getAQuantity() {
        return this.aQuantity;
    }

    @NotNull
    public final String getCommentUserNo() {
        return this.commentUserNo;
    }

    @Nullable
    public final Function2<Boolean, Integer, Unit> getOnQuantityChangeCallback() {
        return this.onQuantityChangeCallback;
    }

    public final int getSource() {
        return this.source;
    }

    @NotNull
    public final String getWorksAuthorNo() {
        return this.worksAuthorNo;
    }

    public final void i() {
        switch (this.animType) {
            case 1:
                if (!this.isCheckedState) {
                    n0a.f43422a.y(this.worksNo, this.worksAuthorNo, this.source);
                } else {
                    n0a.f43422a.a(this.worksNo, this.worksAuthorNo, this.source);
                }
                break;
            case 2:
                if (!this.isCheckedState) {
                    n0a.f43422a.E(this.worksNo, this.worksAuthorNo, this.source);
                } else {
                    n0a.f43422a.x(this.worksNo, this.worksAuthorNo, this.source);
                }
                break;
            case 3:
                if (!this.isCheckedState) {
                    n0a.f43422a.B(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                } else {
                    n0a.f43422a.u(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                }
                break;
            case 4:
                if (!this.isCheckedState) {
                    n0a.f43422a.z(this.worksNo, this.worksAuthorNo, this.source);
                } else {
                    n0a.f43422a.s(this.worksNo, this.worksAuthorNo, this.source);
                }
                break;
            case 5:
                if (!this.isCheckedState) {
                    n0a.f43422a.A(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                } else {
                    n0a.f43422a.t(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                }
                break;
            case 6:
                if (!this.isCheckedState) {
                    n0a.f43422a.C(this.worksNo, this.worksAuthorNo, this.source);
                } else {
                    n0a.f43422a.v(this.worksNo, this.worksAuthorNo, this.source);
                }
                break;
            case 8:
                if (!this.isCheckedState) {
                    n0a.f43422a.D(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                } else {
                    n0a.f43422a.w(this.worksNo, this.worksAuthorNo, this.commentNo, this.commentUserNo, this.source);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: isCheckedState, reason: from getter */
    public final boolean getIsCheckedState() {
        return this.isCheckedState;
    }

    public final void j() {
        String strValueOf;
        TextView tvQuantity = getTvQuantity();
        Intrinsics.checkNotNull(tvQuantity);
        int i = this.aQuantity;
        if (i <= 0) {
            this.aQuantity = 0;
            strValueOf = this.quantityZeroName;
        } else if (i < 1000) {
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = h46.f42049a.j(Float.valueOf(this.aQuantity / 10000.0f), 1) + 'W';
        }
        tvQuantity.setText(strValueOf);
    }

    public final void k(boolean needRecount) {
        if (getTvQuantity() == null) {
            Function2<? super Boolean, ? super Integer, Unit> function2 = this.onQuantityChangeCallback;
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(this.isCheckedState), 0);
                return;
            }
            return;
        }
        if (!needRecount) {
            TextView tvQuantity = getTvQuantity();
            Intrinsics.checkNotNull(tvQuantity);
            int i = this.aQuantity;
            tvQuantity.setText(i <= 0 ? this.quantityZeroName : String.valueOf(i));
            return;
        }
        if (this.isCheckedState) {
            this.aQuantity++;
        } else {
            this.aQuantity--;
        }
        j();
        Function2<? super Boolean, ? super Integer, Unit> function3 = this.onQuantityChangeCallback;
        if (function3 != null) {
            function3.invoke(Boolean.valueOf(this.isCheckedState), Integer.valueOf(this.aQuantity));
        }
    }

    public final void setAQuantity(int i) {
        this.aQuantity = i;
    }

    public final void setCheckedState(boolean z) {
        this.isCheckedState = z;
    }

    public final void setCheckedStateAtOnce(boolean isChecked, int count) {
        this.isCheckedState = isChecked;
        this.aQuantity = count;
        LottieAnimationView lottieAnimationView = this.lottieAnim;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
            lottieAnimationView = null;
        }
        lottieAnimationView.setProgress(this.isCheckedState ? 1.0f : 0.0f);
        j();
    }

    public final void setCommentUserNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentUserNo = str;
    }

    public final void setOnQuantityChangeCallback(@Nullable Function2<? super Boolean, ? super Integer, Unit> function2) {
        this.onQuantityChangeCallback = function2;
    }

    public final void setSource(int i) {
        this.source = i;
    }

    public final void setWorksAuthorNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.worksAuthorNo = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BLOperateAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCheckedState(final int animType, int quantity, final boolean isChecked, @NotNull final String worksNo, @NotNull final String commentNo) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        this.animType = animType;
        this.isCheckedState = isChecked;
        this.aQuantity = quantity;
        this.worksNo = worksNo;
        this.commentNo = commentNo;
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.works.external.widget.BLOperateAnimView$setCheckedState$runner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m818invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m818invoke() {
                switch (animType) {
                    case 1:
                        this.setCheckedState(n0a.f43422a.k(worksNo, isChecked));
                        break;
                    case 2:
                        this.setCheckedState(n0a.f43422a.r(worksNo, isChecked));
                        break;
                    case 3:
                        this.setCheckedState(n0a.f43422a.o(worksNo, commentNo, isChecked));
                        break;
                    case 4:
                        this.setCheckedState(n0a.f43422a.n(worksNo, isChecked));
                        break;
                    case 5:
                        this.setCheckedState(n0a.f43422a.m(worksNo, commentNo, isChecked));
                        break;
                    case 6:
                        this.setCheckedState(n0a.f43422a.q(worksNo, isChecked));
                        break;
                    case 8:
                        this.setCheckedState(n0a.f43422a.p(worksNo, commentNo, isChecked));
                        break;
                }
                BLOperateAnimView bLOperateAnimView = this;
                bLOperateAnimView.k(bLOperateAnimView.getIsCheckedState() != isChecked);
                LottieAnimationView lottieAnimationView = this.lottieAnim;
                LottieAnimationView lottieAnimationView2 = null;
                if (lottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                    lottieAnimationView = null;
                }
                lottieAnimationView.cancelAnimation();
                LottieAnimationView lottieAnimationView3 = this.lottieAnim;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                } else {
                    lottieAnimationView2 = lottieAnimationView3;
                }
                lottieAnimationView2.setProgress(this.getIsCheckedState() ? 1.0f : 0.0f);
            }
        };
        if (this.lottieAnim != null) {
            function0.invoke();
        } else {
            post(new Runnable() { // from class: com.zj.adlib.ek0
                @Override // java.lang.Runnable
                public final void run() {
                    BLOperateAnimView.setCheckedState$lambda$4(function0);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLOperateAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.worksNo = "";
        this.commentNo = "";
        this.worksAuthorNo = "";
        this.commentUserNo = "";
        this.canClick = true;
        this.iconUnselectAnim = LazyKt.lazy(new Function0<AnimatorSet>() { // from class: com.huachenjie.works.external.widget.BLOperateAnimView$iconUnselectAnim$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnimatorSet m817invoke() {
                AnimatorSet animatorSet = new AnimatorSet();
                BLOperateAnimView bLOperateAnimView = this.this$0;
                LottieAnimationView lottieAnimationView = bLOperateAnimView.lottieAnim;
                LottieAnimationView lottieAnimationView2 = null;
                if (lottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                    lottieAnimationView = null;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(lottieAnimationView, "scaleX", 0.5f);
                LottieAnimationView lottieAnimationView3 = bLOperateAnimView.lottieAnim;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                    lottieAnimationView3 = null;
                }
                animatorSet.playTogether(objectAnimatorOfFloat, ObjectAnimator.ofFloat(lottieAnimationView3, "scaleY", 0.5f));
                animatorSet.setDuration(200L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                BLOperateAnimView bLOperateAnimView2 = this.this$0;
                LottieAnimationView lottieAnimationView4 = bLOperateAnimView2.lottieAnim;
                if (lottieAnimationView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                    lottieAnimationView4 = null;
                }
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(lottieAnimationView4, "scaleX", 1.0f);
                LottieAnimationView lottieAnimationView5 = bLOperateAnimView2.lottieAnim;
                if (lottieAnimationView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnim");
                } else {
                    lottieAnimationView2 = lottieAnimationView5;
                }
                animatorSet2.playTogether(objectAnimatorOfFloat2, ObjectAnimator.ofFloat(lottieAnimationView2, "scaleY", 1.0f));
                animatorSet2.setDuration(200L);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playSequentially(animatorSet, animatorSet2);
                return animatorSet3;
            }
        });
        this.tvQuantity = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.external.widget.BLOperateAnimView$tvQuantity$2
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m819invoke() {
                if (this.this$0.quantityZeroName == null || this.this$0.getChildCount() <= 1) {
                    return null;
                }
                View view = (View) SequencesKt.last(ViewGroupKt.getChildren(this.this$0));
                if (view instanceof TextView) {
                    return (TextView) view;
                }
                return null;
            }
        });
        if (attributeSet != null) {
            f(context, attributeSet);
        }
        g();
    }
}
