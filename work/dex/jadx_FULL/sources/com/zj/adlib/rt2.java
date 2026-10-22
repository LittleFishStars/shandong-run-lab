package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.alibaba.triver.triver_render.view.input.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/rt2;", "Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroid/content/Context;", "context", "Landroidx/activity/result/PickVisualMediaRequest;", a.f25238a, "Landroid/content/Intent;", "createIntent", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "maxItemsProvider", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class rt2 extends ActivityResultContracts.PickMultipleVisualMedia {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Function0<Integer> maxItemsProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt2(@NotNull Function0<Integer> function0) {
        super(2);
        Intrinsics.checkNotNullParameter(function0, "maxItemsProvider");
        this.maxItemsProvider = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia, androidx.activity.result.contract.ActivityResultContract
    @NotNull
    public Intent createIntent(@NotNull Context context, @NotNull PickVisualMediaRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, a.f25238a);
        return new ActivityResultContracts.PickMultipleVisualMedia(RangesKt.coerceIn(((Number) this.maxItemsProvider.invoke()).intValue(), 2, fq6.f41732a.e())).createIntent(context, input);
    }
}
