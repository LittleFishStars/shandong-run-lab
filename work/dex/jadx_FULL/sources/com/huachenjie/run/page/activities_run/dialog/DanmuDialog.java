package com.huachenjie.run.page.activities_run.dialog;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogDanmuBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J(\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J(\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R?\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogDanmuBinding;", "Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialogVM;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initView", "initData", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Landroid/view/View;", "view", "position", "onItemClick", "onItemChildClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", "onSend", "Lkotlin/jvm/functions/Function1;", "getOnSend", "()Lkotlin/jvm/functions/Function1;", "setOnSend", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class DanmuDialog extends BaseMVVMBottomDialogFragment<RunDialogDanmuBinding, DanmuDialogVM> implements OnItemClickListener, OnItemChildClickListener {

    @Nullable
    private Function1<? super String, Unit> onSend;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialog$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            DanmuDialog.this.dismiss();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return (fx7.h() * 572) / MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_danmu;
    }

    @Nullable
    public final Function1<String, Unit> getOnSend() {
        return this.onSend;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ((DanmuDialogVM) getMViewModel()).l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        DanmuDialogAdapter value = ((DanmuDialogVM) getMViewModel()).j().getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tv_send);
        }
        if (value != null) {
            value.setOnItemClickListener(this);
        }
        if (value != null) {
            value.setOnItemChildClickListener(this);
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int position) {
        String item;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.tv_send) {
            return;
        }
        String string = null;
        DanmuDialogAdapter danmuDialogAdapter = adapter instanceof DanmuDialogAdapter ? (DanmuDialogAdapter) adapter : null;
        if (danmuDialogAdapter != null && (item = danmuDialogAdapter.getItem(position)) != null) {
            string = StringsKt.trim(item).toString();
        }
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        Function1<? super String, Unit> function1 = this.onSend;
        if (function1 != null) {
            function1.invoke(string);
        }
        dismiss();
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int position) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        DanmuDialogAdapter danmuDialogAdapter = adapter instanceof DanmuDialogAdapter ? (DanmuDialogAdapter) adapter : null;
        if (danmuDialogAdapter != null) {
            danmuDialogAdapter.g(position);
        }
    }

    public final void setOnSend(@Nullable Function1<? super String, Unit> function1) {
        this.onSend = function1;
    }
}
