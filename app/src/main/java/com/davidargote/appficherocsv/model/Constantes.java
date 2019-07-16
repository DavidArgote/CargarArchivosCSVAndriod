package com.davidargote.appficherocsv.model;

public class Constantes {


    public static String NAME_DB = "DATOS.db";
    public static int VERSION_DB = 1;

    public static String NAME_TABLA_1 = "DATOS";
    public static String COLUMN_1 = "NAME";
    public static String COLUMN_2 = "STATE";
    public static String COLUMN_3 = "STATE_ABBRV";
    public static String COLUMN_4 = "FIPS";

    public static String CREATE_TABLE_1 = "CREATE TABLE " + NAME_TABLA_1 + "(" + COLUMN_1 + " TEXT," + COLUMN_2 + " TEXT," + COLUMN_3 + " TEXT, " +
                                            COLUMN_4 + " TEXT)";

    public static String DROP_TABLE_1 = "DROP TABLE IF EXISTS " + NAME_TABLA_1;

    public static String QUERY_ALL_TABLE_1 = "SELECT * FROM " +  NAME_TABLA_1;

}
