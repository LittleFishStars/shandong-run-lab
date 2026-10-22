package com.huachenjie.im;

import androidx.fragment.app.FragmentManager;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.huachenjie.im.custom.ShareOrderAttachment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/im/IIMModule;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", ALPParamConstant.SHOPID, "Lkotlin/Function1;", "Lcom/huachenjie/im/custom/ShareOrderAttachment;", "Lkotlin/ParameterName;", "name", "orderAttachment", "", "selCallback", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
public interface IIMModule {
    void a(@NotNull FragmentManager fragmentManager, @NotNull String shopId, @NotNull Function1<? super ShareOrderAttachment, Unit> selCallback);
}
