public class Main {
    public static void main(String[] args) {
        ZespolProjektowy zespol = new ZespolProjektowy("Campus App");

        Pracownik p1 = new Programista("E-101", "Anna", "Maj", 12000.0, "Java", 4);
        Pracownik p2 = new Tester("E-201", "Piotr", "Lis", 9800.0, true, 25);
        Pracownik p3 = new Programista("E-102", "Karol", "Wojcik", 11500.0, "Kotlin", 3);

        zespol.dodajPracownika(p1);
        zespol.dodajPracownika(p2);
        zespol.dodajPracownika(p3);

        zespol.wypiszSkladZespolu();
        System.out.println("Laczny koszt zespolu: " + zespol.policzLacznyKoszt());

        System.out.println(p1.przedstawSie());
        System.out.println(p2.przedstawSie());

        if (p1 instanceof Programista) {
            Programista programista = (Programista) p1;
            programista.wypiszTechnologie();
        }

        System.out.println(p2.equals(new Tester("E-201", "Inne", "Dane", 9000.0, false, 10)));
        System.out.println(p2);
    }
}
