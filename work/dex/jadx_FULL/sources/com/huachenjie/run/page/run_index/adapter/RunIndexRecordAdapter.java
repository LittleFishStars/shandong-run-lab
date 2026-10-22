package com.huachenjie.run.page.run_index.adapter;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemIndexRecordBinding;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLTextView;
import com.zj.adlib.jj8;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import com.zj.adlib.y6b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0014\u0010\f\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/SportRecord;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemIndexRecordBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "i", y6b.g, y6b.f, "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunIndexRecordAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunIndexRecordAdapter.kt\ncom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,147:1\n262#2,2:148\n262#2,2:150\n262#2,2:152\n262#2,2:154\n262#2,2:156\n*S KotlinDebug\n*F\n+ 1 RunIndexRecordAdapter.kt\ncom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter\n*L\n45#1:148,2\n46#1:150,2\n64#1:152,2\n73#1:154,2\n81#1:156,2\n*E\n"})
public final class RunIndexRecordAdapter extends BaseQuickAdapter<SportRecord, BaseDataBindingHolder<RunItemIndexRecordBinding>> implements LoadMoreModule {
    public static final int K = -15130848;
    public static final int L = -833718;
    public static final int M = -13196801;
    public static final int N = -28392;
    public static final int O = -4079167;
    public static final int P = -16730402;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f12505a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f35930a = jj8.a(10.0f);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Set<Integer> f12506a = SetsKt.setOf(new Integer[]{2, 3, 4, 5});

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter$a;", "", "", "color", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", y6b.f, "status", "Lkotlin/Pair;", "", "e", "scene", "f", "", "meters", "scale", y6b.g, "COLOR_APPEAL", "I", "COLOR_APPEALING", "COLOR_INVALID", "COLOR_TAG_BLUE", "COLOR_TAG_ORANGE", "COLOR_VALID", "", "INVALID_STATUSES", "Ljava/util/Set;", "", "TAG_RADIUS", "F", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<String, String> e(int status) {
            if (status != 2) {
                if (status == 3) {
                    return TuplesKt.to("本次跑步无效，查看原因", "点击申诉");
                }
                if (status == 4) {
                    return TuplesKt.to("本次跑步无效，查看原因", "申诉中");
                }
                if (status != 5) {
                    return TuplesKt.to("", "");
                }
            }
            return TuplesKt.to("本次跑步无效 / 不可申诉", "");
        }

        public final Pair<String, Integer> f(int scene) {
            if (scene == 10) {
                return TuplesKt.to("无感识别", Integer.valueOf(R.drawable.run_run_ic_detail_scene_visioning));
            }
            if (scene == 20) {
                return TuplesKt.to("人脸识别", Integer.valueOf(R.drawable.run_run_ic_detail_scene_face));
            }
            if (scene != 30) {
                return null;
            }
            return TuplesKt.to("打卡机", Integer.valueOf(R.drawable.run_run_ic_detail_scene_machine));
        }

        public final Drawable g(int color) {
            return new DrawableCreator.Builder().setSolidColor(color).setCornersRadius(RunIndexRecordAdapter.f35930a).build();
        }

        public final String h(long meters, int scale) {
            String plainString = BigDecimal.valueOf(meters).divide(BigDecimal.valueOf(1000L), scale, RoundingMode.HALF_UP).toPlainString();
            Intrinsics.checkNotNullExpressionValue(plainString, "valueOf(meters)\n        …         .toPlainString()");
            return plainString;
        }
    }

    public RunIndexRecordAdapter() {
        super(R.layout.run_item_index_record, null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0168  */
    public final void g(RunItemIndexRecordBinding runItemIndexRecordBinding, SportRecord sportRecord) {
        boolean z;
        Pair pair;
        int sunRunRecordStatus = sportRecord.getSunRunRecordStatus();
        boolean zContains = f12506a.contains(Integer.valueOf(sunRunRecordStatus));
        int i = zContains ? -833718 : K;
        TextView textView = runItemIndexRecordBinding.g;
        a aVar = f12505a;
        textView.setText(aVar.h(sportRecord.getValidDistance(), 3));
        runItemIndexRecordBinding.g.setTextColor(i);
        runItemIndexRecordBinding.h.setTextColor(i);
        boolean z2 = sunRunRecordStatus != 10;
        BLTextView bLTextView = runItemIndexRecordBinding.f11945b;
        Intrinsics.checkNotNullExpressionValue(bLTextView, "ivStatus");
        bLTextView.setVisibility(z2 ? 0 : 8);
        BLTextView bLTextView2 = runItemIndexRecordBinding.f11948d;
        Intrinsics.checkNotNullExpressionValue(bLTextView2, "tvVisioning");
        bLTextView2.setVisibility(z2 ^ true ? 0 : 8);
        if (z2) {
            if (sportRecord.getRecheckStatus() == 2) {
                pair = TuplesKt.to("复核中", Integer.valueOf(N));
            } else {
                pair = zContains ? TuplesKt.to("无效", Integer.valueOf(L)) : TuplesKt.to("计入成绩", Integer.valueOf(M));
            }
            String str = (String) pair.component1();
            int iIntValue = ((Number) pair.component2()).intValue();
            runItemIndexRecordBinding.f11945b.setText(str);
            runItemIndexRecordBinding.f11945b.setBackground(aVar.g(iIntValue));
        }
        runItemIndexRecordBinding.j.setText("本次总里程 " + aVar.h(sportRecord.getDistance(), 3) + "km");
        runItemIndexRecordBinding.b.setText(s72.c(sportRecord.getStartTime(), "MM/dd HH:mm"));
        runItemIndexRecordBinding.c.setText(s72.n(sportRecord.getDuration()));
        runItemIndexRecordBinding.f.setText(ll7.f43096a.p((long) sportRecord.getPace(), true));
        runItemIndexRecordBinding.f35620a.setText(aVar.h(sportRecord.getCalorie(), 0));
        Pair pairF = aVar.f(sportRecord.getRunScene());
        Group group = runItemIndexRecordBinding.f11944b;
        Intrinsics.checkNotNullExpressionValue(group, "groupScene");
        group.setVisibility(pairF != null ? 0 : 8);
        if (pairF != null) {
            runItemIndexRecordBinding.i.setText((CharSequence) pairF.getFirst());
            runItemIndexRecordBinding.i.setCompoundDrawablesRelativeWithIntrinsicBounds(((Number) pairF.getSecond()).intValue(), 0, 0, 0);
        }
        Pair pairE = aVar.e(sunRunRecordStatus);
        String str2 = (String) pairE.component1();
        String str3 = (String) pairE.component2();
        boolean z3 = sportRecord.getArchiveState() != 1 && zContains;
        if (z3) {
            z = str3.length() > 0;
        }
        Group group2 = runItemIndexRecordBinding.f11940a;
        Intrinsics.checkNotNullExpressionValue(group2, "groupAppeal");
        group2.setVisibility(z3 ? 0 : 8);
        runItemIndexRecordBinding.e.setText(str2);
        runItemIndexRecordBinding.e.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, z ? R.drawable.run_run_ic_record_reason_arrow : 0, 0);
        TextView textView2 = runItemIndexRecordBinding.d;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvErrorBtn");
        textView2.setVisibility(z ? 0 : 8);
        runItemIndexRecordBinding.d.setText(str3);
        runItemIndexRecordBinding.d.setTextColor(sunRunRecordStatus == 4 ? O : P);
    }

    public final void h() {
        removeEmptyView();
    }

    public final void i() {
        if (hasEmptyView()) {
            return;
        }
        setEmptyView(R.layout.layout_empty_work);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemIndexRecordBinding> holder, @NotNull SportRecord item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemIndexRecordBinding runItemIndexRecordBinding = (RunItemIndexRecordBinding) holder.getDataBinding();
        if (runItemIndexRecordBinding != null) {
            runItemIndexRecordBinding.k(item);
            g(runItemIndexRecordBinding, item);
            runItemIndexRecordBinding.executePendingBindings();
        }
    }
}
