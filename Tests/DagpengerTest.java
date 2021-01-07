import org.junit.Test;

import static org.junit.Assert.*;

public class DagpengerTest {

    // Test som sjekker at en ikke faar dagpenger naar en har tjent under 3g de sistre tre aarene, og under 1,5g siste aar.
    @Test
    public void testNullInntekt(){
        Dagpenger dp = new Dagpenger(99858,96883,93634);
        int result = dp.beregnDagpenger(50000,20000,10000);
        assertEquals(0,result);
    }

    //Tester retten til dagpenger ved inntekt kun det siste aaret.
    @Test
    public void inntektSisteAar(){
        Dagpenger dp = new Dagpenger(99858,96883,93634);
        int result = dp.beregnDagpenger(200000,0,0);
        assertEquals(770,result); // 200000/260 = 769,23
    }


    //Tester retten til dagpenger ved aa ha tjent lite siste aar. Dagpenger skal bli beregnet basert paa gjennomsnitt.
    @Test
    public void inntektTreAarGjennomsnitt(){
        Dagpenger dp = new Dagpenger(99858,96883,93634);
        int result = dp.beregnDagpenger(1000,500000,1000000); // Gjenomsnitt: 500333,33
        assertEquals(1925,result); // 500333/260 = 1924,36
    }

    //Tester eksempel i oppgavetekst, med inntekt i 2019: 500000, 2018: 450000, 2017: 400000. Forventet 1924 i dagpenger
    @Test
    public void eksOppgaveTekst(){
        Dagpenger dp = new Dagpenger(99858,96883,93634);
        int result = dp.beregnDagpenger(500000,450000,400000);
        assertEquals(1924,result); // 500000/260 = 1923,08
    }

    //Tester maks dagpenger, med maks grunnlag 6g = 99858*6 = 599148
    @Test
    public void maks6g(){
        Dagpenger dp = new Dagpenger(99858,96883,93634);
        int result = dp.beregnDagpenger(850000,450000,400000);
        assertEquals(2305,result); // 599148/260 = 2304,42
    }
}