public class Programista extends Pracownik {

    private String glownyJezyk;
    private int liczbaRepozytoriow;

    public Programista(String idPracownika, String imie,
                       String nazwisko, double stawkaBazowa,
                       String glownyJezyk, int liczbaRepozytoriow) {
        super(idPracownika, imie, nazwisko, stawkaBazowa);
        this.glownyJezyk = glownyJezyk;
        this.liczbaRepozytoriow = liczbaRepozytoriow;
    }

    public String getGlownyJezyk() { return glownyJezyk; }
    public int getLiczbaRepozytoriow() { return liczbaRepozytoriow; }

    @Override
    public double obliczKosztMiesieczny() {
        return getStawkaBazowa() + (liczbaRepozytoriow * 100);
    }

    @Override
    public String przedstawSie() {
        return "Programista: " + getImie() + " " + getNazwisko()
             + " | Jezyk: " + glownyJezyk
             + " | Repo: " + liczbaRepozytoriow;
    }

    public void wypiszTechnologie() {
        System.out.println(getImie() + " programuje w: " + glownyJezyk);
    }

    @Override
    public String toString() {
        return "Programista{id='" + getIdPracownika() + "', imie='" + getImie()
             + "', jezyk='" + glownyJezyk
             + "', koszt=" + obliczKosztMiesieczny() + "}";
    }
}
