package fr.istic.vv;

class Date implements Comparable<Date> {

    int day;
    int month;
    int year;
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1) {
        return false;
        }
        int daysInMonth = getDaysInMonth(month, year);
        return day <= daysInMonth;
    }
    private static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }


    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public Date nextDate() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;
        int daysInMonth = getDaysInMonth(nextMonth, nextYear);
        if (nextDay > daysInMonth) {
            nextDay = 1;
            nextMonth += 1;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear += 1;
            }
        }
        return new Date(nextDay, nextMonth, nextYear);
    }

    public Date previousDate() {
        int prevDay = day - 1;
        int prevMonth = month;
        int prevYear = year;
        if (prevDay < 1) {
            prevMonth -= 1;
            if (prevMonth < 1) {
                prevMonth = 12;
                prevYear -= 1;
            }
            prevDay = getDaysInMonth(prevMonth, prevYear);
        }
        return new Date(prevDay, prevMonth, prevYear);
    }

    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }

}