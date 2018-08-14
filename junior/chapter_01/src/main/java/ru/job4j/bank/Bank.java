package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bank {

    public static class Visit {

        private final long in;
        private final long out;

        public Visit(final long in, final long out) {
            this.in = in;
            this.out = out;
        }

        public long getIn() {
            return this.in;
        }

        public long getOut() {
            return this.out;
        }

        public boolean isCross(Visit visit) {
            return this.in <= visit.getIn() && visit.getIn() <= this.out;
        }
    }

    public static class Info {
        private long max;
        private long start;
        private long end;

        public Info() {
            this(0, 0, 0);
        }

        public Info(long max, long start, long end) {
            this.max = max;
            this.start = start;
            this.end = end;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public boolean isCross(Visit visit) {
            return this.start <= visit.getIn() && visit.getIn() <= this.end;
        }

        public boolean isPartOf(Visit visit) {
            return visit.getOut() < this.end;
        }

        public Info cutTall(Visit visit) {
            Info result = new Info();
            result.setMax(this.max);
            result.setStart(visit.getOut());
            result.setEnd(this.end);
            return result;
        }

        public void includeVisit(Visit visit) {
            this.start = visit.getIn();
            this.max++;
            if (visit.getOut() < this.end) {
                this.end = visit.getOut();
            }
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Info info = (Info) o;

            if (max != info.max) {
                return false;
            }
            if (start != info.start) {
                return false;
            }
            return end == info.end;
        }

        @Override
        public int hashCode() {
            int result = (int) (max ^ (max >>> 32));
            result = 31 * result + (int) (start ^ (start >>> 32));
            result = 31 * result + (int) (end ^ (end >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "max="
                    + max
                    + ", start="
                    + this.toTime(this.start)
                    + ", end="
                    + this.toTime(this.end)
                    + '}';
        }

        public String toTime(long time) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time);
            return String.format("%s:%s", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
        }
    }

    public Info createInfo(Visit visit) {
        return new Info(1, visit.getIn(), visit.getOut());
    }

    public List<Info> max(List<Visit> visits) {
        List<Info> periods = new ArrayList<>();
        Info temp1 = this.createInfo(visits.get(0));
        Info max = temp1;
        for (int i = 1; i < visits.size(); i++) {
            if (temp1.isCross(visits.get(i))) {
                temp1.includeVisit(visits.get(i));
            }
            if (temp1.getMax() > max.getMax()) {
                max = temp1;
            }
        }
        periods.add(max);
        return periods;
    }
}

