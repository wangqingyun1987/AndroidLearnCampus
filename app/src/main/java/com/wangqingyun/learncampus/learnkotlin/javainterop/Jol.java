package com.wangqingyun.learncampus.learnkotlin.javainterop;

/**
 * Created by wangqingyun on 25/01/2018.
 */

public class Jol {
    public static void tryIt() {
        /* invalid call, attri is private in Kobj
        String attri = Kobj.attri;
         */
        int count = Kobj.count;
        int member = Kobj.getMember();

        String name = Kol.Companion.getName();
        String gender = Kol.gender;

        /* invalid call, not generated without @JvmStatic
            Kol.toBj();
        */
        Kol.toSg();

        Kol kol = new Kol();
        int weight = kol.getWeight();
        int height = kol.height;
    }
}