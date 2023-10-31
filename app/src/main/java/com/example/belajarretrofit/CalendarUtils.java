package com.example.belajarretrofit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Kelas CalendarUtils ini berguna untuk melakukan operasi-operasi umum terkait tanggal dan waktu dalam aplikasi Anda,
// terutama dalam konteks pengembangan aplikasi kalender atau aplikasi yang menggunakan tanggal dan waktu secara signifikan.
public class CalendarUtils {

    //tanggal yang dipilih atau digunakan dalam beberapa metode dalam kelas ini akan di simpan di selectedDate
    public static LocalDate selectedDate;

    //Metode ini mengambil objek LocalDate dan mengembalikan tanggal yang diformat dalam format "dd MMMM yyyy".
    // Metode DateTimeFormatter digunakan untuk mengatur format tanggal.
    public static String formattedDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    //Metode ini mengambil objek LocalTime dan mengembalikan waktu yang diformat dalam format "hh:mm:ss a".
    // Ini digunakan untuk mengatur format waktu dalam bentuk jam, menit, detik, dan AM/PM.
    public static String formattedTime(LocalTime time)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }

    //Metode ini mengambil objek LocalDate dan mengembalikan bulan dan tahun yang diformat dalam format "MMMM yyyy".
    public static String monthYearFromDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    //Metode ini mengambil objek LocalDate dan bertujuan untuk menghasilkan daftar LocalDate yang
    // mewakili semua hari dalam bulan tertentu berdasarkan LocalDate yang diberikan sebagai argumen.
    public static ArrayList<LocalDate> daysInMonthArray(LocalDate date)
    {
        // Ini adalah inisialisasi sebuah ArrayList yang akan berisi tanggal-tanggal dalam bulan.
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();
        // Ini membuat objek YearMonth yang mewakili tahun dan bulan dari tanggal yang diberikan sebagai argumen.
        YearMonth yearMonth = YearMonth.from(date);

        //Ini menghitung jumlah hari dalam bulan tersebut dengan menggunakan metode lengthOfMonth() dari objek YearMonth.
        int daysInMonth = yearMonth.lengthOfMonth();

        // Ini mengambil tanggal pertama dalam bulan dengan menetapkan hari dalam bulan tersebut ke 1 (1st day).
        LocalDate firstOfMonth = CalendarUtils.selectedDate.withDayOfMonth(1);

        //Ini mengambil nilai hari dalam seminggu untuk tanggal pertama dalam bulan (misalnya, Senin = 1, Selasa = 2, ..., Minggu = 7).
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        //memberikan sistem LOOP
        //Loop ini berjalan dari 1 hingga 42. Ini mewakili 6 minggu (6x7=42) untuk menampilkan kalender bulan penuh dalam tampilan kalender.
        //Pada setiap iterasi loop:
        for(int i = 1; i <= 42; i++)
        {
            // Ini adalah kondisi yang memeriksa apakah i (indeks hari dalam minggu) lebih kecil atau sama dengan nilai hari
            // dalam seminggu di awal bulan atau lebih besar dari jumlah hari dalam bulan ditambah dengan nilai hari dalam seminggu.
            // Ini digunakan untuk mengisi hari-hari sebelum dan setelah bulan dengan nilai null dalam daftar.
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)

                //null ditambahkan ke dalam daftar daysInMonthArray yang menandakan hari tersebut di luar bulan.
                daysInMonthArray.add(null);

            else
                // yang sesuai dengan hari dalam bulan ditambahkan ke dalam daftar. LocalDate dibuat dengan tahun yang sama, bulan yang sama,
                // dan hari yang dihitung berdasarkan indeks hari dalam minggu dan nilai hari dalam seminggu di awal bulan.
                daysInMonthArray.add(LocalDate.of(selectedDate.getYear(),selectedDate.getMonth(),i - dayOfWeek));
        }
        return  daysInMonthArray;
    }

    //Metode ini mengambil objek LocalDate (hari apa yang dipilih dalam minggu) dan mengembalikan daftar LocalDate yang mewakili
    // semua hari dalam minggu tersebut.
    public static ArrayList<LocalDate> daysInWeekArray(LocalDate selectedDate)
    {
        // Ini adalah inisialisasi sebuah ArrayList yang akan berisi tanggal-tanggal dalam satu minggu.
        ArrayList<LocalDate> days = new ArrayList<>();

        //Metode ini mengambil hari Minggu dalam minggu yang sesuai dengan selectedDate. Metode sundayForDate
        //digunakan untuk menemukan hari Minggu dalam minggu tersebut.
        LocalDate current = sundayForDate(selectedDate);

        //ini menghitung tanggal akhir dari minggu tersebut dengan menambahkan satu minggu (7 hari) ke current,
        // sehingga menghasilkan tanggal awal minggu berikutnya.
        LocalDate endDate = current.plusWeeks(1);

        // Ini adalah loop while yang berjalan selama current kurang dari endDate. Dalam kata lain,
        // loop ini akan berjalan selama kita masih dalam rentang minggu yang sama.
        while (current.isBefore(endDate))
        {
            //Setiap kali satu iterasi loop selesai, kita meningkatkan current satu hari ke depan, sehingga kita
            // dapat melanjutkan ke hari berikutnya dalam minggu.
            days.add(current);
            current = current.plusDays(1);
        }
        return days;
    }

    //Metode ini digunakan untuk menemukan tanggal hari Minggu yang sesuai dengan tanggal yang diberikan sebagai argumen.
    private static LocalDate sundayForDate(LocalDate current)
    {
        //Pada awalnya, metode ini menginisialisasi variabel oneWeekAgo dengan tanggal yang berjarak satu minggu sebelum tanggal yang diberikan (current)
        // menggunakan metode minusWeeks(1).
        LocalDate oneWeekAgo = current.minusWeeks(1);

        // Ini adalah loop while yang akan berjalan selama current (tanggal saat ini) lebih besar dari oneWeekAgo (tanggal satu minggu yang lalu).
        while (current.isAfter(oneWeekAgo))
        {
            //Pada setiap iterasi loop, metode ini memeriksa apakah current adalah hari Minggu dengan menggunakan metode getDayOfWeek().
            // Jika current adalah hari Minggu (DayOfWeek.SUNDAY), maka blok berikutnya akan dieksekusi.
            if(current.getDayOfWeek() == DayOfWeek.SUNDAY)
                return current;

            //Jika current bukan hari Minggu, maka tanggal current akan dikurangi satu hari dengan menggunakan metode minusDays(1).
            // Ini dilakukan untuk memeriksa tanggal sebelumnya dalam upaya menemukan hari Minggu.
            current = current.minusDays(1);
        }

        return null;
    }
}
