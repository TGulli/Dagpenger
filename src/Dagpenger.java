public class Dagpenger {
    private final int ANTALLARBEIDSDAGER = 260;

    private int grunnlag1AarSiden; // Grunnbelopet for 1 aar siden
    private int grunnlag2AarSiden; // Grunneblopet for 2 aar siden
    private int grunnlag3AarSiden; // Grunnbelopet for 3 aar siden

    Dagpenger(int grunnlag1AarSiden, int grunnlag2AarSiden, int grunnlag3AarSiden){
        this.grunnlag1AarSiden = grunnlag1AarSiden;
        this.grunnlag2AarSiden = grunnlag2AarSiden;
        this.grunnlag3AarSiden = grunnlag3AarSiden;
    }


    /* Funksjonen bregenger dagsatsen for dagpenger hvis en har krav paa det.
    * Paramtere:
    * int aarsinntekt1 = fjoraarets aarsinntekt
    * int aarsinntekt2 = aarsintekt for 2 aar siden
    * int aarsinntekt3 = aarsintekt for 3 aar siden
    *
    * Returnerer dagsats belopet. Hvis en ikke har krav paa det, returneres 0.
    */
    public int beregnDagpenger(int aarsInntekt1, int aarsInntekt2, int aarsInntekt3){
        int dagsats = 0;

        if (((aarsInntekt1 + aarsInntekt2 + aarsInntekt3) > (grunnlag1AarSiden+grunnlag2AarSiden+grunnlag3AarSiden)) || (aarsInntekt1 > (grunnlag1AarSiden*1.5))){

            int gjennomsnittInntekt = (int) Math.round((double)(aarsInntekt1 + aarsInntekt2 + aarsInntekt3)/3.0);
            int grunnlag = gjennomsnittInntekt;

            if (aarsInntekt1 > gjennomsnittInntekt){
                grunnlag = aarsInntekt1;
            }

            if (grunnlag > grunnlag1AarSiden*6){ //Maks grunnlag er 6g
                grunnlag = grunnlag1AarSiden*6;
            }

            dagsats = (int) Math.ceil((double)grunnlag/ (double)ANTALLARBEIDSDAGER);
        }
        return dagsats;
    }
}
