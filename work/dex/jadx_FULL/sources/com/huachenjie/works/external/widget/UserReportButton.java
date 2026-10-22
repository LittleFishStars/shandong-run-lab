package com.huachenjie.works.external.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.works.R;
import com.huachenjie.works.external.widget.UserReportButton;
import com.noober.background.view.BLImageView;
import com.zj.adlib.gv1;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u001eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/external/widget/UserReportButton;", "Lcom/noober/background/view/BLImageView;", "", "f", "Ljava/lang/String;", "getReportCode", "()Ljava/lang/String;", "setReportCode", "(Ljava/lang/String;)V", UserConstants.CHAT_PARAMS.f, "", "K", "I", "getReportSource", "()I", "setReportSource", "(I)V", UserConstants.CHAT_PARAMS.h, "L", "getReportType", "setReportType", "reportType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class UserReportButton extends BLImageView {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int reportSource;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int reportType;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String reportCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserReportButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportCode = "";
        this.reportType = 2;
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ni9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserReportButton.d(this.f43533a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(final UserReportButton userReportButton, View view) {
        Activity activity;
        Intrinsics.checkNotNullParameter(userReportButton, "this$0");
        if ((userReportButton.reportCode.length() == 0) || (activity = gv1.getActivity((View) userReportButton)) == null) {
            return;
        }
        MoreOptDialog.Companion companion = MoreOptDialog.INSTANCE;
        String strE = ys8.e(R.string.works_detail_menu_report);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.works_detail_menu_report)");
        MoreOptDialog moreOptDialogA = companion.a(CollectionsKt.arrayListOf(new MoreOptBean[]{new MoreOptBean(strE, R.drawable.works_ic_detail_report, 0, 4, null)}), new Function2<MoreOptBean, Integer, Unit>() { // from class: com.huachenjie.works.external.widget.UserReportButton$1$1$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((MoreOptBean) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull MoreOptBean moreOptBean, int i) {
                Intrinsics.checkNotNullParameter(moreOptBean, "<anonymous parameter 0>");
                ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.f, this.this$0.getReportCode()).withInt(UserConstants.CHAT_PARAMS.h, this.this$0.getReportSource()).withInt(UserConstants.CHAT_PARAMS.e, this.this$0.getReportType()).navigation();
            }
        });
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
        moreOptDialogA.show(supportFragmentManager, MoreOptDialog.class.getSimpleName());
    }

    @NotNull
    public final String getReportCode() {
        return this.reportCode;
    }

    public final int getReportSource() {
        return this.reportSource;
    }

    public final int getReportType() {
        return this.reportType;
    }

    public final void setReportCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportCode = str;
    }

    public final void setReportSource(int i) {
        this.reportSource = i;
    }

    public final void setReportType(int i) {
        this.reportType = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserReportButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportCode = "";
        this.reportType = 2;
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ni9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserReportButton.d(this.f43533a, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserReportButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportCode = "";
        this.reportType = 2;
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ni9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserReportButton.d(this.f43533a, view);
            }
        });
    }
}
