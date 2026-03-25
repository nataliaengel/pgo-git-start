public class Main {
    public static void main(String[] args) {
        Ksiazka k1 = new Ksiazka("Wiedzmin", "Sapkowski", 300, true);
        Ksiazka k2 = new Ksiazka("Hobbit", "Tolkien", 250, true);
        
        Biblioteka biblioteka = new Biblioteka(10);
        biblioteka.dodajKsiazke(k1);
        biblioteka.dodajKsiazke(k2);
        
        System.out.println("Zasoby biblioteki:");
        biblioteka.wypiszDostepneKsiazki();
    }
}
