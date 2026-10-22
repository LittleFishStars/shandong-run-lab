package com.huachenjie.run.page.run_detail.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemRunRecordStatusBinding;
import com.igexin.push.g.o;
import com.zj.adlib.RunRecordFaceThumb;
import com.zj.adlib.s72;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/run/page/run_detail/adapter/RunRecordStatusAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/RunRecordStatusLog;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemRunRecordStatusBinding;", "holder", "item", "", "convert", "binding", "e", "", y6b.f, y6b.g, "", "i", "f", "K", "I", "appealStatus", "L", "faceCheck", "", "Lcom/zj/adlib/lm7;", "Ljava/util/List;", "faceThumbs", "<init>", "(IILjava/util/List;)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunRecordStatusAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunRecordStatusAdapter.kt\ncom/huachenjie/run/page/run_detail/adapter/RunRecordStatusAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n766#2:122\n857#2,2:123\n*S KotlinDebug\n*F\n+ 1 RunRecordStatusAdapter.kt\ncom/huachenjie/run/page/run_detail/adapter/RunRecordStatusAdapter\n*L\n37#1:122\n37#1:123,2\n*E\n"})
public final class RunRecordStatusAdapter extends BaseQuickAdapter<RunRecordStatusLog, BaseDataBindingHolder<RunItemRunRecordStatusBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int appealStatus;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int faceCheck;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final List<RunRecordFaceThumb> faceThumbs;

    public /* synthetic */ RunRecordStatusAdapter(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final void e(RunItemRunRecordStatusBinding binding) {
        RecyclerView recyclerView = binding.f35631a;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvFace");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RunRecordFaceThumbAdapter runRecordFaceThumbAdapter = adapter instanceof RunRecordFaceThumbAdapter ? (RunRecordFaceThumbAdapter) adapter : null;
        if (runRecordFaceThumbAdapter == null) {
            runRecordFaceThumbAdapter = new RunRecordFaceThumbAdapter();
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
            recyclerView.setAdapter(runRecordFaceThumbAdapter);
            recyclerView.setItemAnimator(null);
        }
        runRecordFaceThumbAdapter.setList(this.faceThumbs);
    }

    public final int f(RunRecordStatusLog item) {
        if (item.getSourceType() == 2 && this.appealStatus == 1) {
            return R.drawable.run_run_shape_detail_record_status_appealing;
        }
        return item.getStatus() == 1 ? R.drawable.run_run_shape_detail_record_status_valid : R.drawable.run_run_shape_detail_record_status_invalid;
    }

    public final String g(RunRecordStatusLog item) {
        int sourceType = item.getSourceType();
        if (sourceType != 1) {
            if (sourceType != 2) {
                return (sourceType == 3 || sourceType == 4) ? "经学校核实：" : "";
            }
            return "";
        }
        if (item.getStatus() == 0) {
            return item.isAppealFlag() ? "未达到学校要求：" : "未达到学校要求,不可申诉：";
        }
        return "";
    }

    public final String h(RunRecordStatusLog item) {
        int sourceType = item.getSourceType();
        if (sourceType == 1) {
            if (item.getStatus() != 0 || item.isAppealFlag()) {
                return null;
            }
            return "不可申诉";
        }
        if (sourceType != 2) {
            if (sourceType != 5) {
                return null;
            }
            return item.getStatus() == 1 ? "人脸复核通过" : "人脸复核不通过";
        }
        if (this.appealStatus == 1) {
            return "申诉中";
        }
        return item.getStatus() == 1 ? "申诉通过" : "申诉不通过";
    }

    public final int i(RunRecordStatusLog item) {
        if (item.getSourceType() == 2 && this.appealStatus == 1) {
            return R.drawable.run_run_shape_detail_record_tag_appealing;
        }
        return item.getStatus() == 1 ? R.drawable.run_run_shape_detail_record_tag_valid : R.drawable.run_run_shape_detail_record_tag_invalid;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemRunRecordStatusBinding> holder, @NotNull RunRecordStatusLog item) {
        List listEmptyList;
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemRunRecordStatusBinding runItemRunRecordStatusBinding = (RunItemRunRecordStatusBinding) holder.getDataBinding();
        if (runItemRunRecordStatusBinding != null) {
            runItemRunRecordStatusBinding.y(item);
            runItemRunRecordStatusBinding.I(item.getStatus() == 1 ? "成绩有效" : "成绩无效");
            String strC = s72.c(item.getUpdateTime(), "yyyy/MM/dd HH:mm");
            runItemRunRecordStatusBinding.H(strC);
            boolean z = item.getSourceType() == 2 && this.appealStatus == 1;
            runItemRunRecordStatusBinding.A(z);
            runItemRunRecordStatusBinding.x(z ? "申诉时间：" + strC : "");
            String strG = g(item);
            List<String> remark = item.getRemark();
            if (remark != null) {
                Intrinsics.checkNotNullExpressionValue(remark, "remark");
                listEmptyList = new ArrayList();
                for (Object obj : remark) {
                    String str = (String) obj;
                    Intrinsics.checkNotNullExpressionValue(str, o.f);
                    if (str.length() > 0) {
                        listEmptyList.add(obj);
                    }
                }
            } else {
                listEmptyList = null;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.isEmpty()) {
                strJoinToString$default = "";
            } else {
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                if (strG.length() > 0) {
                    listCreateListBuilder.add(strG);
                }
                listCreateListBuilder.addAll(listEmptyList);
                strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
            runItemRunRecordStatusBinding.setContent(strJoinToString$default);
            runItemRunRecordStatusBinding.B(strJoinToString$default.length() > 0);
            String strH = h(item);
            runItemRunRecordStatusBinding.G(strH != null ? strH : "");
            runItemRunRecordStatusBinding.E(!(strH == null || strH.length() == 0));
            runItemRunRecordStatusBinding.F(i(item));
            runItemRunRecordStatusBinding.z(f(item));
            runItemRunRecordStatusBinding.D(item.getStatus() == 0);
            boolean z2 = item.getSourceType() == 1 && this.faceCheck != 2 && (this.faceThumbs.isEmpty() ^ true);
            runItemRunRecordStatusBinding.C(z2);
            if (z2) {
                e(runItemRunRecordStatusBinding);
            }
            runItemRunRecordStatusBinding.executePendingBindings();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRecordStatusAdapter(int i, int i2, @NotNull List<RunRecordFaceThumb> list) {
        super(R.layout.run_item_run_record_status, null, 2, null);
        Intrinsics.checkNotNullParameter(list, "faceThumbs");
        this.appealStatus = i;
        this.faceCheck = i2;
        this.faceThumbs = list;
    }
}
