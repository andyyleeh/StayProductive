package me.andrewhanselee.stayproductive;

import android.provider.BaseColumns;

/**
 * Created by Andrew on 2017-06-23.
 */

public class dataTable{

    public dataTable(){}

    public static abstract class tableInfo implements BaseColumns {

        public final static String USER_ID = "user_id";
        public final static String USER_SUC = "user_suc";
        public final static String USER_FAIL = "user_fail";
        public final static String Database = "user_info";
        public final static String Table = "table_name";
    }

}
