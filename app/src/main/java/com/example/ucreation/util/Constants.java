package com.example.ucreation.util;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Constants {
    public final static String BASE_URL = "http://192.168.1.70/UCreationWeb/public/api/";
    public static final String BASE_IMAGE_URL = "";

    @Retention(SOURCE)
    @StringDef
    public @interface Type {
        String CREATIONS = "creation";

    }
}
