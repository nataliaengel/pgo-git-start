import java.util.ArrayList;

public class BiuroUbezpieczen {

    private String nazwa;
    private ArrayList<Polisa> polisy;

    public BiuroUbezpieczen(String nazwa) {
        this.nazwa = nazwa;
        this.polisy = new ArrayList<>();
    }

    public void dodajPolise(Polisa polisa) {
        polisy.add(polisa);
    }

    public void wypiszRaport() {
        System.out.println("===== RAPORT: " + nazwa + " =====");
        for (Polisa p : polisy) {
            System.out.println(p);
            System.out.println("  Skladka koncowa:     " + p.obliczSkladkeKoncowa());
            System.out.println("  Skladka odnowieniowa: " + p.obliczSkladkeOdnowieniowa());
        }
        System.out.println("================================");
    }

    public double policzLacznaSkladke() {
        double suma = 0;
        for (Polisa p : polisy) {
            suma += p.obliczSkladkeKoncowa();
        }
        return Math.round(suma * 100.0) / 100.0;
    }

    public double policzLacznaPrognozeOdnowien() {
        double suma = 0;
        for (Polisa p : polisy) {
            suma += p.obliczSkladkeOdnowieniowa();
        }
        return Math.round(suma * 100.0) / 100.0;
    }

    public int policzPolisyWysokiegoRyzyka() {
        int count = 0;
        for (Polisa p : polisy) {
            if (p.getPoziomRyzyka() >= 4) {
                count++;
            }
        }
        return count;
    }

    public Polisa znajdzPoNumerze(String numer) {
        for (Polisa p : polisy) {
            if (p.getNumerPolisy().equals(numer)) {
                return p;
            }
        }
        return null;
    }

    public void wypiszTanszeNiz(double prog) {
        System.out.println("Polisy tansze niz " + prog + ":");
        for (Polisa p : polisy) {
            if (p.obliczSkladkeKoncowa() < prog) {
                System.out.println("  " + p);
            }
        }
    }
}
