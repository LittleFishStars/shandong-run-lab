package com.huachenjie.sport.page.mine.attendance;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceClickHandler;", "", "clickAttendanceCount", "", "v", "Landroid/view/View;", "clickAttendancePlan", "clickAttendanceRule", "clickNextMonth", "clickPreMonth", "clickRefreshTapResult", "clickToday", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AttendanceClickHandler {
    void clickAttendanceCount(@NotNull View v);

    void clickAttendancePlan(@NotNull View v);

    void clickAttendanceRule(@NotNull View v);

    void clickNextMonth(@NotNull View v);

    void clickPreMonth(@NotNull View v);

    void clickRefreshTapResult(@NotNull View v);

    void clickToday(@NotNull View v);
}
