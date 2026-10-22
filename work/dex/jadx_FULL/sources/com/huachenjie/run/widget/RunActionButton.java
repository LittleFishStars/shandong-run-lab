package com.huachenjie.run.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.RunActionButton;
import com.igexin.push.config.c;
import com.igexin.push.g.o;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 °\u00012\u00020\u0001:\u0006°\u0001±\u0001²\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010q\u001a\u0002032\u0006\u0010r\u001a\u00020\u001a2\u0006\u0010s\u001a\u00020tJH\u0010u\u001a\u0002032\u0006\u0010v\u001a\u00020c2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020\u000b2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bH\u0002J\b\u0010~\u001a\u000203H\u0002J/\u0010\u007f\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u001a2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u000bH\u0002J.\u0010\u0085\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u000bH\u0002J\u0013\u0010\u0088\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J5\u0010\u0089\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u00072\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020302H\u0082\bJ%\u0010\u008c\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u008e\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010\u008f\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u001c\u0010\u0090\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0091\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010\u0092\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u0012\u0010\u0093\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u001fJ\u0013\u0010\u0095\u0001\u001a\u00020\u001a2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020\u001a2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\u001b\u0010\u0099\u0001\u001a\u00020\u001a2\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u009c\u0001\u001a\u000203H\u0014J\t\u0010\u009d\u0001\u001a\u000203H\u0014J\u0013\u0010\u009e\u0001\u001a\u0002032\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0014J\u001b\u0010\u009f\u0001\u001a\u0002032\u0007\u0010 \u0001\u001a\u00020\u00072\u0007\u0010¡\u0001\u001a\u00020\u0007H\u0014J-\u0010¢\u0001\u001a\u0002032\u0007\u0010£\u0001\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u00020\u00072\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010§\u0001\u001a\u00020\u001a2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010¨\u0001\u001a\u0002032\u0007\u0010©\u0001\u001a\u00020\u001aH\u0016J\t\u0010ª\u0001\u001a\u000203H\u0002J\u0007\u0010«\u0001\u001a\u000203J\u0007\u0010¬\u0001\u001a\u000203J\t\u0010\u00ad\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010®\u0001\u001a\u00020\u00072\u0007\u0010¯\u0001\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0014\u0010!\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u000e\u0010;\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u001cR\u000e\u0010G\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010J\u001a\u00020I2\u0006\u0010\u0011\u001a\u00020I@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001c\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0016R\u000e\u0010]\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010e\u001a\u00020d2\u0006\u0010\u0011\u001a\u00020d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010k\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u001c\"\u0004\bm\u0010YR\u001d\u0010n\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010'\u001a\u0004\bo\u0010%¨\u0006³\u0001"}, d2 = {"Lcom/huachenjie/run/widget/RunActionButton;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionSize", "circleCx", "", "circleCy", "circleRadius", "density", "fillPaint", "Landroid/graphics/Paint;", "value", "frameColor", "getFrameColor", "()I", "setFrameColor", "(I)V", "framePaint", "frameWidth", "hasCustomFrame", "", "getHasCustomFrame", "()Z", "iconPaint", "iconRect", "Landroid/graphics/RectF;", "isLongPressStyle", "isPressing", "lockDrawable", "Landroid/graphics/drawable/Drawable;", "getLockDrawable", "()Landroid/graphics/drawable/Drawable;", "lockDrawable$delegate", "Lkotlin/Lazy;", "lockIconH", "lockIconW", "longPressAnimator", "Landroid/animation/ValueAnimator;", "longPressCanceled", "longPressDuration", "", "longPressProgress", "longPressing", "onActionClick", "Lkotlin/Function0;", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function0;", "setOnActionClick", "(Lkotlin/jvm/functions/Function0;)V", "onActionLongPress", "getOnActionLongPress", "setOnActionLongPress", "pauseBarGap", "pauseBarH", "pauseBarRadius", "pauseBarW", "playIconRadius", "playIconSize", "pressingFrameWidth", "progressOval", "progressPaint", "progressWidth", "showTip", "getShowTip", "stopIconRadius", "stopIconSize", "Lcom/huachenjie/run/widget/RunActionButton$Style;", "style", "getStyle", "()Lcom/huachenjie/run/widget/RunActionButton$Style;", "setStyle", "(Lcom/huachenjie/run/widget/RunActionButton$Style;)V", "tipAnimOffset", "tipAnimRange", "tipAnimator", "tipArrowH", "tipArrowOverlap", "tipArrowRadius", "tipArrowW", "tipAutoAnim", "getTipAutoAnim", "setTipAutoAnim", "(Z)V", "tipBgColor", "getTipBgColor", "setTipBgColor", "tipBubbleHeight", "tipCorner", "tipGap", "tipHPadding", "tipPaint", "tipPath", "Landroid/graphics/Path;", "", "tipText", "getTipText", "()Ljava/lang/CharSequence;", "setTipText", "(Ljava/lang/CharSequence;)V", "tipTextPaint", "tipVisible", "getTipVisible", "setTipVisible", "unlockDrawable", "getUnlockDrawable", "unlockDrawable$delegate", "applyRunMode", "hasPauseTime", "tipStyle", "Lcom/huachenjie/run/widget/RunActionButton$TipStyle;", "buildRoundedTriangle", "path", "x0", "y0", "x1", "y1", "x2", "y2", "radius", "cancelLongPressProgress", "drawCircleBody", b.f25229a, "Landroid/graphics/Canvas;", "fillColor", "pressing", "ringWidth", "drawFramedCircle", "ringColor", "width", "drawLock", "drawLongPressBody", "progressColor", "drawIcon", "drawLongPressProgress", "color", "drawPause", "drawPlay", "drawSolidCircle", "drawStop", "drawTip", "getActionCircleBounds", "out", "handleClickTouch", "event", "Landroid/view/MotionEvent;", "handleLongPressTouch", "isInCircle", "x", "y", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", y6b.g, "oldw", "oldh", "onTouchEvent", "setEnabled", "enabled", "startLongPress", "startTipAnim", "stopTipAnim", "tipReservedHeight", "tipTextColorFor", "bg", "Companion", "Style", "TipStyle", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunActionButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunActionButton.kt\ncom/huachenjie/run/widget/RunActionButton\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,590:1\n394#1,5:592\n394#1,5:597\n1#2:591\n*S KotlinDebug\n*F\n+ 1 RunActionButton.kt\ncom/huachenjie/run/widget/RunActionButton\n*L\n369#1:592,5\n377#1:597,5\n*E\n"})
public final class RunActionButton extends View {
    private static final int COLOR_CYAN = -16002049;
    private static final int COLOR_FRAME_PRESSING = -7197;
    private static final int COLOR_GREEN = -12858007;
    private static final int COLOR_ORANGE = -28392;
    private static final int COLOR_RED = -833718;
    private static final int COLOR_TIP_DARK = -15130848;
    private static final int COLOR_WHITE = -1;
    private final int actionSize;
    private float circleCx;
    private float circleCy;
    private float circleRadius;
    private final float density;

    @NotNull
    private final Paint fillPaint;
    private int frameColor;

    @NotNull
    private final Paint framePaint;
    private final float frameWidth;

    @NotNull
    private final Paint iconPaint;

    @NotNull
    private final RectF iconRect;

    /* JADX INFO: renamed from: lockDrawable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lockDrawable;
    private final float lockIconH;
    private final float lockIconW;

    @Nullable
    private ValueAnimator longPressAnimator;
    private boolean longPressCanceled;
    private final long longPressDuration;
    private float longPressProgress;
    private boolean longPressing;

    @Nullable
    private Function0<Unit> onActionClick;

    @Nullable
    private Function0<Unit> onActionLongPress;
    private final float pauseBarGap;
    private final float pauseBarH;
    private final float pauseBarRadius;
    private final float pauseBarW;
    private final float playIconRadius;
    private final float playIconSize;
    private final float pressingFrameWidth;

    @NotNull
    private final RectF progressOval;

    @NotNull
    private final Paint progressPaint;
    private final float progressWidth;
    private final float stopIconRadius;
    private final float stopIconSize;

    @NotNull
    private Style style;
    private float tipAnimOffset;
    private final float tipAnimRange;

    @Nullable
    private ValueAnimator tipAnimator;
    private final float tipArrowH;
    private final float tipArrowOverlap;
    private final float tipArrowRadius;
    private final float tipArrowW;
    private boolean tipAutoAnim;
    private int tipBgColor;
    private final float tipBubbleHeight;
    private final float tipCorner;
    private final float tipGap;
    private final float tipHPadding;

    @NotNull
    private final Paint tipPaint;

    @NotNull
    private final Path tipPath;

    @NotNull
    private CharSequence tipText;

    @NotNull
    private final Paint tipTextPaint;
    private boolean tipVisible;

    /* JADX INFO: renamed from: unlockDrawable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy unlockDrawable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/run/widget/RunActionButton$Style;", "", "(Ljava/lang/String;I)V", "STOP", "PAUSE", "PLAY", "LOCK", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Style {
        STOP,
        PAUSE,
        PLAY,
        LOCK
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/run/widget/RunActionButton$TipStyle;", "", "(Ljava/lang/String;I)V", HlsPlaylistParser.O, "SHEET", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TipStyle {
        MAP,
        SHEET
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Style.values().length];
            try {
                iArr[Style.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Style.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Style.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Style.LOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunActionButton(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RunActionButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x008a  */
    private final void buildRoundedTriangle(Path path, float x0, float y0, float x1, float y1, float x2, float y2, float radius) {
        float[] fArr = {x0, x1, x2};
        float[] fArr2 = {y0, y1, y2};
        path.reset();
        int i = 0;
        while (i < 3) {
            int i2 = (i + 2) % 3;
            int i3 = i + 1;
            int i4 = i3 % 3;
            float f = fArr[i] - fArr[i2];
            float f2 = fArr2[i] - fArr2[i2];
            float fHypot = (float) Math.hypot(f, f2);
            float f3 = fArr[i4] - fArr[i];
            float f4 = fArr2[i4] - fArr2[i];
            float fHypot2 = (float) Math.hypot(f3, f4);
            if (!(fHypot == 0.0f)) {
                if (!(fHypot2 == 0.0f)) {
                    float fMin = Math.min(radius, Math.min(fHypot, fHypot2) / 2.0f);
                    float f5 = fArr[i];
                    float f6 = f5 - ((f / fHypot) * fMin);
                    float f7 = fArr2[i];
                    float f8 = f7 - ((f2 / fHypot) * fMin);
                    float f9 = f5 + ((f3 / fHypot2) * fMin);
                    float f10 = f7 + ((f4 / fHypot2) * fMin);
                    if (i == 0) {
                        path.moveTo(f6, f8);
                    } else {
                        path.lineTo(f6, f8);
                    }
                    path.quadTo(fArr[i], fArr2[i], f9, f10);
                }
            }
            i = i3;
        }
        path.close();
    }

    private final void cancelLongPressProgress() {
        this.longPressCanceled = true;
        ValueAnimator valueAnimator = this.longPressAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.longPressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.longPressAnimator = null;
        this.longPressProgress = 0.0f;
        this.longPressing = false;
        invalidate();
    }

    private final void drawCircleBody(Canvas canvas, int fillColor, boolean pressing, float ringWidth) {
        if (getHasCustomFrame() || isLongPressStyle()) {
            drawFramedCircle(canvas, fillColor, ringColor(pressing), ringWidth);
        } else {
            drawSolidCircle(canvas, fillColor);
        }
    }

    public static /* synthetic */ void drawCircleBody$default(RunActionButton runActionButton, Canvas canvas, int i, boolean z, float f, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f = runActionButton.ringWidth(z);
        }
        runActionButton.drawCircleBody(canvas, i, z, f);
    }

    private final void drawFramedCircle(Canvas canvas, int fillColor, int ringColor, float width) {
        float f = this.circleRadius - width;
        this.framePaint.setColor(ringColor);
        this.fillPaint.setColor(fillColor);
        canvas.drawCircle(this.circleCx, this.circleCy, this.circleRadius, this.framePaint);
        canvas.drawCircle(this.circleCx, this.circleCy, f, this.fillPaint);
    }

    private final void drawLock(Canvas canvas) {
        float fRingWidth = ringWidth(isPressing());
        drawCircleBody(canvas, COLOR_CYAN, isPressing(), fRingWidth);
        drawLongPressProgress(canvas, fRingWidth, COLOR_GREEN);
        Drawable unlockDrawable = this.longPressing ? getUnlockDrawable() : getLockDrawable();
        if (unlockDrawable != null) {
            float f = this.circleCx;
            float f2 = this.lockIconW;
            int i = (int) (f - (f2 / 2.0f));
            float f3 = this.circleCy;
            float f4 = this.lockIconH;
            int i2 = (int) (f3 - (f4 / 2.0f));
            unlockDrawable.setBounds(i, i2, ((int) f2) + i, ((int) f4) + i2);
            unlockDrawable.draw(canvas);
        }
    }

    private final void drawLongPressBody(Canvas canvas, int fillColor, int progressColor, Function0<Unit> drawIcon) {
        float fRingWidth = ringWidth(isPressing());
        drawCircleBody(canvas, fillColor, isPressing(), fRingWidth);
        drawLongPressProgress(canvas, fRingWidth, progressColor);
        drawIcon.invoke();
    }

    private final void drawLongPressProgress(Canvas canvas, float ringWidth, int color) {
        if (this.longPressProgress <= 0.0f) {
            return;
        }
        this.progressPaint.setColor(color);
        float f = this.circleRadius - (ringWidth / 2.0f);
        RectF rectF = this.progressOval;
        float f2 = this.circleCx;
        float f3 = this.circleCy;
        rectF.set(f2 - f, f3 - f, f2 + f, f3 + f);
        canvas.drawArc(this.progressOval, -90.0f, this.longPressProgress * 360.0f, false, this.progressPaint);
    }

    private final void drawPause(Canvas canvas) {
        drawCircleBody$default(this, canvas, -28392, false, 0.0f, 8, null);
        float f = this.circleCy;
        float f2 = this.pauseBarH;
        float f3 = f - (f2 / 2.0f);
        float f4 = f + (f2 / 2.0f);
        RectF rectF = this.iconRect;
        float f5 = this.circleCx;
        float f6 = this.pauseBarGap;
        rectF.set((f5 - (f6 / 2.0f)) - this.pauseBarW, f3, f5 - (f6 / 2.0f), f4);
        RectF rectF2 = this.iconRect;
        float f7 = this.pauseBarRadius;
        canvas.drawRoundRect(rectF2, f7, f7, this.iconPaint);
        RectF rectF3 = this.iconRect;
        float f8 = this.circleCx;
        float f9 = this.pauseBarGap;
        rectF3.set((f9 / 2.0f) + f8, f3, f8 + (f9 / 2.0f) + this.pauseBarW, f4);
        RectF rectF4 = this.iconRect;
        float f10 = this.pauseBarRadius;
        canvas.drawRoundRect(rectF4, f10, f10, this.iconPaint);
    }

    private final void drawPlay(Canvas canvas) {
        drawSolidCircle(canvas, COLOR_GREEN);
        float f = this.playIconSize;
        float f2 = f / 2.0f;
        float f3 = (this.circleCx - (0.32f * f)) + (this.density * 2.0f);
        float f4 = this.circleCy;
        Path path = this.tipPath;
        buildRoundedTriangle(path, f3, f4 - f2, f3 + (f * 0.78f), f4, f3, f4 + f2, this.playIconRadius);
        canvas.drawPath(this.tipPath, this.iconPaint);
    }

    private final void drawSolidCircle(Canvas canvas, int color) {
        this.fillPaint.setColor(color);
        canvas.drawCircle(this.circleCx, this.circleCy, this.circleRadius, this.fillPaint);
    }

    private final void drawStop(Canvas canvas) {
        float fRingWidth = ringWidth(isPressing());
        drawCircleBody(canvas, -833718, isPressing(), fRingWidth);
        drawLongPressProgress(canvas, fRingWidth, -28392);
        float f = this.stopIconSize / 2.0f;
        RectF rectF = this.iconRect;
        float f2 = this.circleCx;
        float f3 = this.circleCy;
        rectF.set(f2 - f, f3 - f, f2 + f, f3 + f);
        RectF rectF2 = this.iconRect;
        float f4 = this.stopIconRadius;
        canvas.drawRoundRect(rectF2, f4, f4, this.iconPaint);
    }

    private final void drawTip(Canvas canvas) {
        String string = this.tipText.toString();
        float fMeasureText = this.tipTextPaint.measureText(string) + (this.tipHPadding * 2);
        float paddingLeft = getPaddingLeft();
        float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float f = ((width - fMeasureText) / 2.0f) + paddingLeft;
        float paddingTop = getPaddingTop() + this.tipAnimRange + this.tipAnimOffset;
        float f2 = this.tipBubbleHeight;
        float f3 = paddingTop + f2;
        float f4 = paddingLeft + (width / 2.0f);
        float fMin = Math.min(this.tipCorner, f2 / 2.0f);
        this.iconRect.set(f, paddingTop, fMeasureText + f, f3);
        canvas.drawRoundRect(this.iconRect, fMin, fMin, this.tipPaint);
        Path path = this.tipPath;
        float f5 = this.tipArrowW;
        float f6 = this.tipArrowOverlap;
        buildRoundedTriangle(path, f4 - (f5 / 2.0f), f3 - f6, f4 + (f5 / 2.0f), f3 - f6, f4, f3 + this.tipArrowH, this.tipArrowRadius);
        canvas.drawPath(this.tipPath, this.tipPaint);
        Paint.FontMetrics fontMetrics = this.tipTextPaint.getFontMetrics();
        canvas.drawText(string, f4, (paddingTop + (this.tipBubbleHeight / 2.0f)) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.tipTextPaint);
    }

    public static /* synthetic */ RectF getActionCircleBounds$default(RunActionButton runActionButton, RectF rectF, int i, Object obj) {
        if ((i & 1) != 0) {
            rectF = new RectF();
        }
        return runActionButton.getActionCircleBounds(rectF);
    }

    private final boolean getHasCustomFrame() {
        return this.frameColor != 0;
    }

    private final Drawable getLockDrawable() {
        return (Drawable) this.lockDrawable.getValue();
    }

    private final boolean getShowTip() {
        if (this.tipVisible) {
            return this.tipText.length() > 0;
        }
        return false;
    }

    private final Drawable getUnlockDrawable() {
        return (Drawable) this.unlockDrawable.getValue();
    }

    private final boolean handleClickTouch(MotionEvent event) {
        Function0<Unit> function0;
        ViewParent parent;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            return true;
        }
        ViewParent parent3 = getParent();
        if (parent3 != null) {
            parent3.requestDisallowInterceptTouchEvent(false);
        }
        if (isInCircle(event.getX(), event.getY()) && (function0 = this.onActionClick) != null) {
            function0.invoke();
        }
        return true;
    }

    private final boolean handleLongPressTouch(MotionEvent event) {
        ValueAnimator valueAnimator;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.longPressing = true;
            ValueAnimator valueAnimator2 = this.tipAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.pause();
            }
            startLongPress();
            invalidate();
            return true;
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        ViewParent parent2 = getParent();
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(false);
        }
        this.longPressing = false;
        cancelLongPressProgress();
        if (getShowTip() && (valueAnimator = this.tipAnimator) != null) {
            valueAnimator.resume();
        }
        invalidate();
        return true;
    }

    private final boolean isInCircle(float x, float y) {
        float f = x - this.circleCx;
        float f2 = y - this.circleCy;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.circleRadius;
        return f3 <= f4 * f4;
    }

    private final boolean isLongPressStyle() {
        Style style = this.style;
        return style == Style.STOP || style == Style.LOCK;
    }

    private final boolean isPressing() {
        return this.longPressing || this.longPressProgress > 0.0f;
    }

    private final int ringColor(boolean pressing) {
        if (getHasCustomFrame()) {
            return this.frameColor;
        }
        if (pressing) {
            return COLOR_FRAME_PRESSING;
        }
        return -833718;
    }

    private final float ringWidth(boolean pressing) {
        return pressing ? this.pressingFrameWidth : this.frameWidth;
    }

    private final void startLongPress() {
        ValueAnimator valueAnimator = this.longPressAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.longPressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.longPressCanceled = false;
        this.longPressProgress = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.longPressDuration);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.il7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                RunActionButton.startLongPress$lambda$13$lambda$12(this.f42388a, valueAnimator3);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.run.widget.RunActionButton$startLongPress$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Function0<Unit> onActionLongPress;
                Intrinsics.checkNotNullParameter(animation, com.ipd.dsp.internal.l.a.l);
                if (this.this$0.longPressCanceled || this.this$0.longPressProgress < 1.0f || (onActionLongPress = this.this$0.getOnActionLongPress()) == null) {
                    return;
                }
                onActionLongPress.invoke();
            }
        });
        valueAnimatorOfFloat.start();
        this.longPressAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLongPress$lambda$13$lambda$12(RunActionButton runActionButton, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(runActionButton, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        runActionButton.longPressProgress = ((Float) animatedValue).floatValue();
        runActionButton.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTipAnim$lambda$8$lambda$7(RunActionButton runActionButton, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(runActionButton, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        runActionButton.tipAnimOffset = ((Float) animatedValue).floatValue();
        runActionButton.invalidate();
    }

    private final float tipReservedHeight() {
        if (getShowTip()) {
            return this.tipAnimRange + this.tipBubbleHeight + this.tipArrowH + this.tipGap;
        }
        return 0.0f;
    }

    private final int tipTextColorFor(int bg) {
        return ((((bg >> 16) & 255) * 299) + (((bg >> 8) & 255) * 587)) + ((bg & 255) * 114) > 186000 ? -15130848 : -1;
    }

    public final void applyRunMode(boolean hasPauseTime, @NotNull TipStyle tipStyle) {
        String str;
        Intrinsics.checkNotNullParameter(tipStyle, "tipStyle");
        setStyle(hasPauseTime ? Style.PAUSE : Style.STOP);
        if (hasPauseTime) {
            str = tipStyle == TipStyle.SHEET ? "跑步进行中，点击暂停" : "";
        } else {
            str = "长按结束跑步";
        }
        setTipText(str);
        if (tipStyle != TipStyle.MAP) {
            this.tipAutoAnim = true;
            return;
        }
        this.tipAutoAnim = this.tipVisible && !hasPauseTime;
        if (hasPauseTime) {
            setTipVisible(false);
        }
    }

    @NotNull
    public final RectF getActionCircleBounds(@NotNull RectF out) {
        Intrinsics.checkNotNullParameter(out, "out");
        float f = this.circleCx;
        float f2 = this.circleRadius;
        float f3 = this.circleCy;
        out.set(f - f2, f3 - f2, f + f2, f3 + f2);
        return out;
    }

    public final int getFrameColor() {
        return this.frameColor;
    }

    @Nullable
    public final Function0<Unit> getOnActionClick() {
        return this.onActionClick;
    }

    @Nullable
    public final Function0<Unit> getOnActionLongPress() {
        return this.onActionLongPress;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    public final boolean getTipAutoAnim() {
        return this.tipAutoAnim;
    }

    public final int getTipBgColor() {
        return this.tipBgColor;
    }

    @NotNull
    public final CharSequence getTipText() {
        return this.tipText;
    }

    public final boolean getTipVisible() {
        return this.tipVisible;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.tipAutoAnim && getShowTip()) {
            startTipAnim();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        stopTipAnim();
        cancelLongPressProgress();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        if (getShowTip() && !this.longPressing) {
            drawTip(canvas);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.style.ordinal()];
        if (i == 1) {
            drawPause(canvas);
            return;
        }
        if (i == 2) {
            drawPlay(canvas);
        } else if (i == 3) {
            drawStop(canvas);
        } else {
            if (i != 4) {
                return;
            }
            drawLock(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize(Math.max((int) (getShowTip() ? this.tipTextPaint.measureText(this.tipText.toString()) + (this.tipHPadding * 2) : 0.0f), this.actionSize) + getPaddingLeft() + getPaddingRight(), widthMeasureSpec), View.resolveSize(((int) (tipReservedHeight() + this.actionSize)) + getPaddingTop() + getPaddingBottom(), heightMeasureSpec));
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingLeft2 = (w - getPaddingLeft()) - getPaddingRight();
        this.circleRadius = this.actionSize / 2.0f;
        this.circleCx = paddingLeft + (paddingLeft2 / 2.0f);
        this.circleCy = paddingTop + tipReservedHeight() + this.circleRadius;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        if (event.getActionMasked() != 0 || isInCircle(event.getX(), event.getY())) {
            return isLongPressStyle() ? handleLongPressTouch(event) : handleClickTouch(event);
        }
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.5f);
        if (enabled) {
            return;
        }
        cancelLongPressProgress();
    }

    public final void setFrameColor(int i) {
        if (this.frameColor == i) {
            return;
        }
        this.frameColor = i;
        invalidate();
    }

    public final void setOnActionClick(@Nullable Function0<Unit> function0) {
        this.onActionClick = function0;
    }

    public final void setOnActionLongPress(@Nullable Function0<Unit> function0) {
        this.onActionLongPress = function0;
    }

    public final void setStyle(@NotNull Style style) {
        Intrinsics.checkNotNullParameter(style, "value");
        if (this.style == style) {
            return;
        }
        this.style = style;
        cancelLongPressProgress();
        invalidate();
    }

    public final void setTipAutoAnim(boolean z) {
        this.tipAutoAnim = z;
    }

    public final void setTipBgColor(int i) {
        if (this.tipBgColor == i) {
            return;
        }
        this.tipBgColor = i;
        this.tipPaint.setColor(i);
        this.tipTextPaint.setColor(tipTextColorFor(i));
        invalidate();
    }

    public final void setTipText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        if (Intrinsics.areEqual(this.tipText, charSequence)) {
            return;
        }
        this.tipText = charSequence;
        requestLayout();
        invalidate();
    }

    public final void setTipVisible(boolean z) {
        if (this.tipVisible == z) {
            return;
        }
        this.tipVisible = z;
        if (z && this.tipAutoAnim) {
            startTipAnim();
        } else {
            stopTipAnim();
        }
        requestLayout();
        invalidate();
    }

    public final void startTipAnim() {
        if (getShowTip()) {
            ValueAnimator valueAnimator = this.tipAnimator;
            if (valueAnimator != null) {
                if (valueAnimator.isPaused()) {
                    valueAnimator.resume();
                    return;
                } else if (valueAnimator.isRunning()) {
                    return;
                }
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -this.tipAnimRange);
            valueAnimatorOfFloat.setDuration(500L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setRepeatMode(2);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.hl7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RunActionButton.startTipAnim$lambda$8$lambda$7(this.f42154a, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.start();
            this.tipAnimator = valueAnimatorOfFloat;
        }
    }

    public final void stopTipAnim() {
        ValueAnimator valueAnimator = this.tipAnimator;
        if (valueAnimator == null) {
            if (this.tipAnimOffset == 0.0f) {
                return;
            }
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.tipAnimator = null;
        this.tipAnimOffset = 0.0f;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:8:0x0193 A[PHI: r12
      0x0193: PHI (r12v5 com.huachenjie.run.widget.RunActionButton$Style) = 
      (r12v2 com.huachenjie.run.widget.RunActionButton$Style)
      (r12v3 com.huachenjie.run.widget.RunActionButton$Style)
      (r12v4 com.huachenjie.run.widget.RunActionButton$Style)
     binds: [B:7:0x0191, B:10:0x019b, B:13:0x01a4] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmOverloads
    public RunActionButton(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Style style = Style.STOP;
        this.style = style;
        this.tipText = "";
        this.tipVisible = true;
        this.tipBgColor = -833718;
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.tipBubbleHeight = f * 32.0f;
        this.tipHPadding = f * 16.0f;
        this.tipCorner = f * 16.0f;
        this.tipArrowW = 11.0f * f;
        this.tipArrowH = f * 7.0f;
        this.tipArrowRadius = 2.5f * f;
        this.tipGap = f * 4.0f;
        this.tipAnimRange = f * 8.0f;
        float f2 = f * 4.0f;
        this.progressWidth = f2;
        this.stopIconSize = 24.0f * f;
        this.stopIconRadius = 5.0f * f;
        this.pauseBarW = f * 8.0f;
        this.pauseBarH = f * 32.0f;
        this.pauseBarRadius = 4.0f * f;
        this.pauseBarGap = 12.0f * f;
        this.playIconSize = f * 32.0f;
        this.playIconRadius = 7.0f * f;
        this.lockIconW = 29.0f * f;
        this.lockIconH = 32.0f * f;
        this.longPressDuration = c.j;
        this.tipArrowOverlap = 1.0f * f;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-833718);
        this.tipPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setTypeface(Typeface.DEFAULT_BOLD);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(getResources().getDisplayMetrics().scaledDensity * 16.0f);
        this.tipTextPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        this.fillPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL);
        this.framePaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        paint5.setStrokeWidth(f2);
        paint5.setColor(-28392);
        this.progressPaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setColor(-1);
        this.iconPaint = paint6;
        this.tipPath = new Path();
        this.progressOval = new RectF();
        this.iconRect = new RectF();
        this.lockDrawable = LazyKt.lazy(new Function0<Drawable>() { // from class: com.huachenjie.run.widget.RunActionButton$lockDrawable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Drawable m735invoke() {
                return ContextCompat.getDrawable(context, R.mipmap.run_ic_screen_lock);
            }
        });
        this.unlockDrawable = LazyKt.lazy(new Function0<Drawable>() { // from class: com.huachenjie.run.widget.RunActionButton$unlockDrawable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Drawable m736invoke() {
                return ContextCompat.getDrawable(context, R.mipmap.run_ic_screen_unlock);
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.run_RunActionButton);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.run_RunActionButton)");
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.run_RunActionButton_run_runActionStyle, style.ordinal());
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.run_RunActionButton_run_runActionTipText);
        setTipText(string != null ? string : "");
        setTipVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.run_RunActionButton_run_runActionTipVisible, true));
        this.tipAutoAnim = typedArrayObtainStyledAttributes.getBoolean(R.styleable.run_RunActionButton_run_runActionTipAutoAnim, false);
        setTipBgColor(typedArrayObtainStyledAttributes.getColor(R.styleable.run_RunActionButton_run_runActionTipBgColor, -833718));
        setFrameColor(typedArrayObtainStyledAttributes.getColor(R.styleable.run_RunActionButton_run_runActionFrameColor, 0));
        this.frameWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.run_RunActionButton_run_runActionFrameWidth, f * 8.0f);
        this.pressingFrameWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.run_RunActionButton_run_runActionPressingFrameWidth, 8.0f * f);
        this.actionSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.run_RunActionButton_run_runActionSize, (int) (f * 80.0f));
        typedArrayObtainStyledAttributes.recycle();
        Style style2 = Style.PAUSE;
        if (i2 != style2.ordinal()) {
            style2 = Style.PLAY;
            if (i2 != style2.ordinal()) {
                style2 = Style.LOCK;
                style = i2 == style2.ordinal() ? style2 : style;
            }
        }
        setStyle(style);
    }
}
