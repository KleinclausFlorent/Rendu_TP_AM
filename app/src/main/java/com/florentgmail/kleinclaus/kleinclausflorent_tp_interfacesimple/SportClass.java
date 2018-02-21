package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.media.Image;

/**
 * Created by Kleinclaus Florent on 17/02/2018.
 * BUT : Définition de la classe sport afin de réaliser le tableau de sports qui sera utiliser par l'adapter pour remplir la listView
 *
 */

public class SportClass {
    private String sportName;
    private int ImgRes;
    private String sportDef;

    public String getSportName () { return sportName;}

    public void setSportName (String sportName) {this.sportName = sportName;}

    public int getImgRes () { return ImgRes;}

    public void setImgRes (int ImgRes) {this.ImgRes = ImgRes;}

    public String getSportDef () {return sportDef;}

    public void setSportDef (String sportDef) {this.sportDef = sportDef;}

}
