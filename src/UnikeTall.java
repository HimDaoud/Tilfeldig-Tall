import javax.swing.JOptionPane;


class Tall{
    private int [] verdier;
    public Tall(int length){
        verdier = new int[length];
    }

    private boolean sjekk(int randomTall) {
        for (int i = 0; i < verdier.length; i++) {
            if (randomTall == verdier[i]){
                return true;
            }
        }
        return false;
    }
    public void fylle() {
        boolean variabel = false;

        for (int i = 0; i < verdier.length; i++) {
            int randomTall = (int) (Math.random()*(900)+100);
            while(sjekk(randomTall) == variabel) {
                verdier[i] = randomTall;
            }

            if(sjekk(randomTall) == true) {
                variabel = true;

                while(sjekk(randomTall) == variabel) {
                    randomTall = (int) (Math.random()* (900)+100);

                    if(sjekk(randomTall) == false) {
                        variabel = false;
                        verdier[i] = randomTall;
                    }

                }

            }
        }

        skrivUt();

    }
    public static int min(int[] innArray){
        int minste = innArray[0];
        for (int tall : innArray){
            if (tall < minste){
                minste = tall;
            }
        }
        return minste;
    }
    public static int maks(int[] innArray){
        int største = innArray[0];
        for (int tall : innArray){
            if (tall > største){
                største = tall;
            }
        }
        return største;
    }

    public static double gjennomsnitt(int[] innArray){
        double sum = 0;
        for (int i = 0; i < innArray.length; i++) {
            sum += innArray[i];
        }
        double total = (double) sum/innArray.length;
        return total;
    }

    public void skrivUt() {
        int linjeskift = 0;
        String display = "";

        int minst = min(verdier);
        int størst = maks(verdier);
        String gjennomsnitt =  String.format("%.2f",gjennomsnitt(verdier));
        for(int i = 0; i < verdier.length; i++) {
            display += verdier[i]+ "  ";
            linjeskift++;

            if(linjeskift  % 8 == 0) {
                display+= "\n";
            }
        }

        JOptionPane.showMessageDialog(null,  display + "\n\n" + "Minste tall er "+ minst + "\n" +
                "Største tall er " + størst + "\n" +
                "Gjennomsnittsverdien er " + gjennomsnitt);

    }

}
public class UnikeTall {
    public static void main(String[] args) {
        Tall tall = new Tall(50); //Du kan bestemme lengden til arrayen
        tall.fylle();

    }

}