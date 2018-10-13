
package com.support.android.dicoding;

import java.util.Random;

public class Burung {

    private static final Random RANDOM = new Random();

    public static int getRandomCheeseDrawable() {
        switch (RANDOM.nextInt(30)) {
            default:
            case 0:
                return R.drawable.accipitriformes_1;
            case 1:
                return R.drawable.falconiformes_2;
            case 2:
                return R.drawable.apodiformes_3;
            case 3:
                return R.drawable.apterygiformes_4;
            case 4:
                return R.drawable.bucerotiformes_5;
            case 5:
                return R.drawable.caprimulgiformes_6;
            case 6:
                return R.drawable.cariamiformes_7;
            case 7:
                return R.drawable.casuariiformes_8;
            case 8:
                return R.drawable.charadriiformes_9;
            case 9:
                return R.drawable.ciconiiformes_10;
            case 10:
                return R.drawable.coliiformes_11;
            case 11:
                return R.drawable.columbiformes_12;
            case 12:
                return R.drawable.coraciiformes_13;
            case 13:
                return R.drawable.cuculiformes_14;
            case 14:
                return R.drawable.falconiformes_15;
            case 15:
                return R.drawable.galliformes_16;
            case 16:
                return R.drawable.gaviiformes_17;
            case 17:
                return R.drawable.gruiformes_18;
            case 18:
                return R.drawable.passeriformes_19;
            case 19:
                return R.drawable.pelecaniformes_20;
            case 20:
                return R.drawable.piciformes_21;
            case 21:
                return R.drawable.podicipediformes_22;
            case 22:
                return R.drawable.procellariiformes_23;
            case 23:
                return R.drawable.psittaciformes_24;
            case 24:
                return R.drawable.rheiformes_25;
            case 25:
                return R.drawable.sphenisciformes_26;
            case 26:
                return R.drawable.strigiformes_27;
            case 27:
                return R.drawable.struthioniformes_28;
            case 28:
                return R.drawable.tinamiformes_29;
            case 29:
                return R.drawable.trogoniformes_30;
        }
    }

    public static final String[] sCheeseStrings = {
            "Ordo Accipitriformes", "Ordo Anseriformes Falconiformes", "Ordo Apodiformes", "Ordo Apterygiformes",
            "Ordo Bucerotiformes", "Ordo Caprimulgiformes", "Ordo Cariamiformes", "Ordo Casuariiformes",
            "Ordo Charadriiformes", "Ordo Ciconiiformes", "Ordo Coliiformes", "Ordo Columbiformes",
            "Ordo Coraciiformes", "Ordo Cuculiformes", "Ordo Falconiformes", "Ordo Galliformes", "Ordo Gaviiformes",
            "Ordo Gruiformes ", "Ordo Passeriformes", "Ordo Pelecaniformes", "Ordo Piciformes", "Ordo Podicipediformes",
            "Ordo Procellariiformes", "Ordo Psittaciformes", "Ordo Rheiformes", "Ordo Sphenisciformes",
            "Order Strigiformes", "Ordo Struthioniformes", "Ordo Tinamiformes", "Ordo Trogoniformes"

    };

}
