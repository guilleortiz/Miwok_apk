package com.example.android.miwok;

/**
 * Created by Guille on 15/07/2016.
 */
public class Word {

    private String mDefaultTranslation;
    private  String mMiwokTranslation;
   // private String mKk;

    private int mImageResourceId=NO_IMAGE_PROVIDE;
    private static final int NO_IMAGE_PROVIDE=-1;

    private int mSound;


    //-----------------MULTI CONSTRUCTORES

    public Word(String defaultTranslation, String miwokTranslation,int sound){//solo dos parametro de string

       // mKk=tipo;
         mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;

        mSound=sound;
    }
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceid,int sound){ //dos parametrso de strigng y un in de id resource

        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageResourceid;
        mSound=sound;
    }



//-----------Metodos publicos de la clase---------

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){

        return mMiwokTranslation;
    }

    public  int  getImageResourceId (){

    return mImageResourceId;
    }

    /**
     * returns
     */
    public boolean hasImagen(){

    return mImageResourceId != NO_IMAGE_PROVIDE;

    }

    public int getSoundId(){

        return  mSound;
    }

}

