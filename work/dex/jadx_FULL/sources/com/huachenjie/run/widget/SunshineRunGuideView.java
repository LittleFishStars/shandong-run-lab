package com.huachenjie.run.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.SunshineRunGuideView;
import com.zj.adlib.jj8;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020!H\u0002J\u0006\u00104\u001a\u00020!J\b\u00105\u001a\u00020!H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0014J\b\u00109\u001a\u00020!H\u0002J \u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0007H\u0002J*\u0010>\u001a\u00020!2\u0014\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*0 0)2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*0 0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/huachenjie/run/widget/SunshineRunGuideView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnNext", "Landroid/widget/TextView;", "cardGroup", "dimPaint", "Landroid/graphics/Paint;", "dp16", "dp20", "dp44", "dp64", "dp8", "dp85", "holeCircle", "", "holePath", "Landroid/graphics/Path;", "holeRadius", "", "holeRect", "Landroid/graphics/RectF;", "ivMascot", "Landroid/widget/ImageView;", "ivPointer", "onComplete", "Lkotlin/Function0;", "", "panelBelow", "panelEnd", "panelStart", "panelView", "Landroid/widget/LinearLayout;", "step", "targets", "", "Landroid/view/View;", "tmpBounds", "tmpLoc", "", "tmpRoot", "tvContent", "tvStepIndex", "applyPointer", "below", "bind", "dismiss", "next", "onDraw", b.f25229a, "Landroid/graphics/Canvas;", "placePanel", "resolveHole", "target", "fit", "expand", "show", "targetProviders", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSunshineRunGuideView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunGuideView.kt\ncom/huachenjie/run/widget/SunshineRunGuideView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 Canvas.kt\nandroidx/core/graphics/CanvasKt\n*L\n1#1,252:1\n1#2:253\n262#3,2:254\n262#3,2:256\n262#3,2:258\n162#3,8:260\n329#3,4:268\n329#3,4:272\n260#3:283\n30#4,7:276\n*S KotlinDebug\n*F\n+ 1 SunshineRunGuideView.kt\ncom/huachenjie/run/widget/SunshineRunGuideView\n*L\n80#1:254,2\n92#1:256,2\n103#1:258,2\n179#1:260,8\n224#1:268,4\n233#1:272,4\n158#1:283\n241#1:276,7\n*E\n"})
public final class SunshineRunGuideView extends FrameLayout {

    @NotNull
    private final TextView btnNext;

    @NotNull
    private final FrameLayout cardGroup;

    @NotNull
    private final Paint dimPaint;
    private final int dp16;
    private final int dp20;
    private final int dp44;
    private final int dp64;
    private final int dp8;
    private final int dp85;
    private boolean holeCircle;

    @NotNull
    private final Path holePath;
    private float holeRadius;

    @NotNull
    private final RectF holeRect;

    @NotNull
    private final ImageView ivMascot;

    @NotNull
    private final ImageView ivPointer;

    @Nullable
    private Function0<Unit> onComplete;
    private boolean panelBelow;
    private int panelEnd;
    private int panelStart;

    @NotNull
    private final LinearLayout panelView;
    private int step;

    @NotNull
    private List<? extends Function0<? extends View>> targets;

    @NotNull
    private final RectF tmpBounds;

    @NotNull
    private final int[] tmpLoc;

    @NotNull
    private final int[] tmpRoot;

    @NotNull
    private final TextView tvContent;

    @NotNull
    private final TextView tvStepIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunshineRunGuideView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunshineRunGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SunshineRunGuideView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(SunshineRunGuideView sunshineRunGuideView, View view) {
        Intrinsics.checkNotNullParameter(sunshineRunGuideView, "this$0");
        sunshineRunGuideView.next();
    }

    private final void applyPointer(boolean below) {
        this.panelView.removeView(this.ivPointer);
        this.ivPointer.setImageResource(below ? R.drawable.run_ic_sun_run_guide_pointer_up : R.drawable.run_ic_sun_run_guide_pointer_down);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dp16, below ? this.dp44 : this.dp64);
        int i = this.dp8;
        if (below) {
            layoutParams.bottomMargin = i;
        } else {
            layoutParams.topMargin = i;
        }
        LinearLayout linearLayout = this.panelView;
        ImageView imageView = this.ivPointer;
        if (below) {
            linearLayout.addView(imageView, 0);
        } else {
            linearLayout.addView(imageView);
        }
        this.ivPointer.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.cardGroup;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), below ? 0 : this.dp85, frameLayout.getPaddingRight(), frameLayout.getPaddingBottom());
    }

    private final void bind() {
        final View view;
        Function0 function0 = (Function0) CollectionsKt.getOrNull(this.targets, this.step);
        if (function0 == null || (view = (View) function0.invoke()) == null) {
            next();
            return;
        }
        int size = this.targets.size();
        boolean z = this.step >= size + (-1);
        TextView textView = this.tvStepIndex;
        StringBuilder sb = new StringBuilder();
        sb.append(this.step + 1);
        sb.append('/');
        sb.append(size);
        textView.setText(sb.toString());
        this.btnNext.setText(z ? "我知道了" : "下一步");
        int i = this.step;
        if (i == 0) {
            this.tvContent.setText("本次跑步要跑完的最低公里数，当前运动距离和跑步总时长，更多数据可上滑查看。");
            this.ivMascot.setImageResource(R.drawable.run_ic_sun_run_guide_mascot_1);
            this.panelBelow = false;
            int iA = jj8.a(38.0f);
            this.panelStart = iA;
            this.panelEnd = iA;
            this.holeCircle = false;
            this.holeRadius = this.dp16;
        } else if (i != 1) {
            this.tvContent.setText((view instanceof RunActionButton) && ((RunActionButton) view).getStyle() == RunActionButton.Style.PAUSE ? "点击可暂停休息，也可退出跑步" : "本校跑步无法暂停，长按可结束跑步");
            this.ivMascot.setImageResource(R.drawable.run_ic_sun_run_guide_mascot_3);
            this.panelBelow = false;
            int iA2 = jj8.a(38.0f);
            this.panelStart = iA2;
            this.panelEnd = iA2;
            this.holeCircle = true;
            this.holeRadius = 0.0f;
        } else {
            this.tvContent.setText("这里是跑步成绩合格的条件，条件都完成时，即代表本次跑步已达标!");
            this.ivMascot.setImageResource(R.drawable.run_ic_sun_run_guide_mascot_2);
            this.panelBelow = true;
            this.panelStart = this.dp16;
            this.panelEnd = jj8.a(59.0f);
            this.holeCircle = false;
            this.holeRadius = this.dp8;
        }
        applyPointer(this.panelBelow);
        view.post(new Runnable() { // from class: com.zj.adlib.zv8
            @Override // java.lang.Runnable
            public final void run() {
                SunshineRunGuideView.bind$lambda$5(this.f21119a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$5(SunshineRunGuideView sunshineRunGuideView, View view) {
        Intrinsics.checkNotNullParameter(sunshineRunGuideView, "this$0");
        Intrinsics.checkNotNullParameter(view, "$target");
        if (sunshineRunGuideView.getVisibility() == 0) {
            int i = sunshineRunGuideView.step;
            if (!sunshineRunGuideView.resolveHole(view, i > 0, i > 0 ? sunshineRunGuideView.dp8 : 0)) {
                sunshineRunGuideView.next();
            } else {
                sunshineRunGuideView.invalidate();
                sunshineRunGuideView.placePanel();
            }
        }
    }

    private final void next() {
        if (this.step < CollectionsKt.getLastIndex(this.targets)) {
            this.step++;
            bind();
            return;
        }
        Function0<Unit> function0 = this.onComplete;
        dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void placePanel() {
        int iCoerceAtLeast = RangesKt.coerceAtLeast((getWidth() - this.panelStart) - this.panelEnd, 0);
        this.panelView.measure(View.MeasureSpec.makeMeasureSpec(iCoerceAtLeast, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int iCoerceAtLeast2 = this.panelBelow ? (int) (this.holeRect.bottom + this.dp8) : RangesKt.coerceAtLeast((int) (this.holeRect.top - this.panelView.getMeasuredHeight()), this.dp16);
        LinearLayout linearLayout = this.panelView;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = iCoerceAtLeast;
        layoutParams2.height = -2;
        layoutParams2.gravity = 8388659;
        layoutParams2.leftMargin = this.panelStart;
        layoutParams2.rightMargin = this.panelEnd;
        layoutParams2.topMargin = iCoerceAtLeast2;
        linearLayout.setLayoutParams(layoutParams2);
        if (this.ivPointer.getParent() != null) {
            ImageView imageView = this.ivPointer;
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.setMarginStart(RangesKt.coerceAtLeast((int) ((this.holeRect.centerX() - this.panelStart) - (this.dp16 / 2.0f)), 0));
            imageView.setLayoutParams(layoutParams4);
        }
    }

    private final boolean resolveHole(View target, boolean fit, int expand) {
        if (target.getWidth() <= 0 || target.getHeight() <= 0 || getWidth() <= 0 || getHeight() <= 0) {
            return false;
        }
        target.getLocationOnScreen(this.tmpLoc);
        getLocationOnScreen(this.tmpRoot);
        int[] iArr = this.tmpLoc;
        int i = iArr[0];
        int[] iArr2 = this.tmpRoot;
        float f = i - iArr2[0];
        float f2 = iArr[1] - iArr2[1];
        if (fit) {
            if (target instanceof RunActionButton) {
                ((RunActionButton) target).getActionCircleBounds(this.tmpBounds);
            } else if (target instanceof ShadowFrameLayout) {
                ((ShadowFrameLayout) target).getCardBounds(this.tmpBounds);
            } else {
                this.tmpBounds.set(0.0f, 0.0f, target.getWidth(), target.getHeight());
            }
            float f3 = expand;
            RectF rectF = this.holeRect;
            RectF rectF2 = this.tmpBounds;
            rectF.set((rectF2.left + f) - f3, (rectF2.top + f2) - f3, f + rectF2.right + f3, f2 + rectF2.bottom + f3);
        } else {
            this.holeRect.set(this.dp16, f2, getWidth() - this.dp16, getHeight() - this.dp20);
        }
        this.holePath.reset();
        if (this.holeCircle) {
            this.holePath.addOval(this.holeRect, Path.Direction.CW);
        } else {
            Path path = this.holePath;
            RectF rectF3 = this.holeRect;
            float f4 = this.holeRadius;
            path.addRoundRect(rectF3, f4, f4, Path.Direction.CW);
        }
        return true;
    }

    public final void dismiss() {
        this.targets = CollectionsKt.emptyList();
        this.onComplete = null;
        this.holeRect.setEmpty();
        this.holePath.reset();
        setClickable(false);
        setVisibility(8);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        if (this.holeRect.isEmpty()) {
            return;
        }
        int iSave = canvas.save();
        try {
            canvas.clipOutPath(this.holePath);
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.dimPaint);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public final void show(@NotNull List<? extends Function0<? extends View>> targetProviders, @NotNull Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(targetProviders, "targetProviders");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (targetProviders.isEmpty()) {
            onComplete.invoke();
            return;
        }
        this.targets = targetProviders;
        this.onComplete = onComplete;
        this.step = 0;
        setClickable(true);
        setVisibility(0);
        bringToFront();
        bind();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SunshineRunGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setClipChildren(false);
        this.panelView = linearLayout;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.ivPointer = imageView;
        Paint paint = new Paint(1);
        paint.setColor(Integer.MIN_VALUE);
        this.dimPaint = paint;
        this.holePath = new Path();
        this.holeRect = new RectF();
        this.tmpBounds = new RectF();
        this.tmpLoc = new int[2];
        this.tmpRoot = new int[2];
        this.dp8 = jj8.a(8.0f);
        this.dp16 = jj8.a(16.0f);
        this.dp20 = jj8.a(20.0f);
        this.dp44 = jj8.a(44.0f);
        this.dp64 = jj8.a(64.0f);
        this.dp85 = jj8.a(85.0f);
        this.targets = CollectionsKt.emptyList();
        setClickable(true);
        setClipChildren(false);
        setWillNotDraw(false);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.run_layout_sunshine_run_guide, (ViewGroup) linearLayout, true);
        View viewFindViewById = findViewById(R.id.cardGroup);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.cardGroup)");
        this.cardGroup = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tvStepIndex);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.tvStepIndex)");
        this.tvStepIndex = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tvContent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.tvContent)");
        this.tvContent = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.btnNext);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.btnNext)");
        TextView textView = (TextView) viewFindViewById4;
        this.btnNext = textView;
        View viewFindViewById5 = findViewById(R.id.ivMascot);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.ivMascot)");
        this.ivMascot = (ImageView) viewFindViewById5;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yv8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SunshineRunGuideView._init_$lambda$3(this.f46126a, view);
            }
        });
        setVisibility(8);
    }
}
