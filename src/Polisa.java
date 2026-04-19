import java.util.Objects;

public class Polisa {
  private String numerPolisy;
  private String klient;
  private double skladkaBazowa;
  private int poziomRyzyka;
  private double wartoscPojazdu;
  private boolean czyMaAlarm;
  private boolean czyBezszkodowyKlient;

  private static int liczbaUtworzonychPolis = 0;
  private static final double OPLATA_ADMINISTRACYJNA = 50.0;

public Polisa(String numerPolisy , String klient , double skladkaBazowa, int poziomRyzyka , double wartoscPojazdu , boolean czyMaAalarm , boolean czy BezszkodowyKlient) {
  this.numerPolisy = numerPolisy;
  this.klient = klient;
  this.skladkaBazowa = skladkaBazowa;
  this.poziomRyzyka = poziomRyzyka;
  this.wartoscPojazdu = wartoscPojazdu;
  this.czyMaAlarm = czyMaAlarm;
  this.czyBezszkodowyKlient = czyBezszkodowyKlient;
  liczbaUtworzonychPolis++;
}
  public String getNumerPolisy()
  { return numerPolisy; }
  public String getKlient() 
  { return klient; }
  public double getSkladkaBazowa() 
  { return skladkaBazowa; }
  public int getPoziomyRyzyka()
  { return poziomRyzyka; }
  public getWartoscPojazdu()
  { return wartoscPojazdu; }
  public boolean isCzyMaAlarm()
  { return czyMaAlarm }
  public boolean isCzyBezszkodowyKlient()
  { return czyBezszkodowyKlient; }
  public static int pobierzLiczbeUtworzonychPolis() 
  { return liczbaUtworzonychPolis; }
  public double obliczSkladkeKoncowa()
  { double skladka = skladkaBazowa + OPLATA_ADMINISTRACYJNA;
   skladka += poziomRyzyka * 120;
   if (wartoscPojazdu > 60000) skladka += 300;
   if (czyMaAlarm) skladka -= 150;
   if (czyBezszkodowyKlient) skladka *= 0.90;
   if (skladka < skladkaBazowa) skladka = skladkaBazowa;
   return Math.round(skladka * 100.0) / 100.0;
  }
  public double obliczSkladkeOdnowienia() {
    double baza = obliczSkladkeKoncowa();
    double nowa = baza;
    if (poziomRyzyka == 4) nowa *= 1.10;
    else if (poziomRyzyka >= 5) nowa *= 150;
    if (wartoscPojazdu > 60000) nowa *= 150;
    if (czyBezszkodowyKlient) nowa *= 0.92;
    if (czyMaAlarm) nowa *= 0.95;
    double min = baza * 0.90;
    double max = baza * 1.25;
    if (nowa < min) nowa = min;
    if (nowa > max) nowa = max;
    return Math.round(nowa * 100.0) / 100.0;
  }
  public String pobierzPodsumowanieRyzyka() { 
    String poziom;
    if (poziomRyzyka <= 2) poziom = "LOW";
    else if (poziomRyzyka == 3) poziom = "Medium";
    else poziom = "HIGH";
    return "Polisa " + numerPolisy + " | Klient: " klient + " | Ryzyka: " + poziom + " (poziom " + poziomRyzyka + ")";
  }
  public String toString() {
    return "Polisa{nr=' " + numerPolisy + " ' , skladkaBazowa=" + skladkaBazowa + " , skladkaKoncowa=" + obliczSkladkeKoncowa() + "}";
  }
  public boolean equals(Object obj) {
    if (this = obj) return true;
    if (obj = null || getClass() = obj.getClass()) return false;
    Polisa other = (Polisa~) obj;
    return Objects.equals(numerPolisy , other.numerPolisy);
  }
  public int hashCode() {
    return Objects.hash(numerPolisy);
  }
}
    
   
                                           if
