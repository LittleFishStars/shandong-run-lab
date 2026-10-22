package com.command.core.logwriter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class LogExportTimeRange {
    private final String endDate;
    private final String startDate;

    public static final class Time {
        private final int day;
        private final int month;
        private final int year;

        public Time(int i, int i2, int i3) {
            this.year = i;
            this.month = i2;
            this.day = i3;
        }

        public String toDateString() {
            return String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day));
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public static final class Builder {
        private static final String PATTERN = "%1$tY-%1$tm-%1$td";
        private String endDate;
        private String startDate;

        public LogExportTimeRange build() {
            return new LogExportTimeRange(this);
        }

        public Builder lastDays(int i) {
            if (i <= 0) {
                return this;
            }
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            calendar.add(5, -(i - 1));
            Date time2 = calendar.getTime();
            Locale locale = Locale.US;
            this.startDate = String.format(locale, PATTERN, time2);
            this.endDate = String.format(locale, PATTERN, time);
            return this;
        }

        public Builder range(Time time, Time time2) {
            this.startDate = time == null ? null : time.toDateString();
            this.endDate = time2 != null ? time2.toDateString() : null;
            return this;
        }

        public Builder singleDay(Time time) {
            if (time == null) {
                return this;
            }
            String dateString = time.toDateString();
            this.startDate = dateString;
            this.endDate = dateString;
            return this;
        }

        public Builder range(String str, String str2) {
            this.startDate = str;
            this.endDate = str2;
            return this;
        }

        public Builder singleDay(String str) {
            this.startDate = str;
            this.endDate = str;
            return this;
        }
    }

    private LogExportTimeRange(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }
}
