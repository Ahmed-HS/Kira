package com.example.projectmanagement.businesslogic.entities;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class LocalDateConverter {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @TypeConverter
    public static LocalDate localDateFromStr(String value) {
        if (value != null) {
            return LocalDate.parse(formatter.format(LocalDate.parse(value)));
        }

        return null;
    }

    @TypeConverter
    public static String StrFromLocalDate(LocalDate date) {
        if (date != null) {
            return formatter.format(date);
        }
        return null;
    }
}
