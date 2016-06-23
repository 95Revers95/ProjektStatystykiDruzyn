package client;
/**
* Klasa, która przechowuje informacje na temat druzyny z bazy danych
*/
public class Druzyna {
    int id_druzyny;
    String nazwa;
    String nazwaKrotka;
    String kraj;
    String miasto;
    int budzet;
    StatystykiDruzyny stat;
    /**
     * Funkcja, która zwraca nazwe druzyny
     * @return Nazwe zespołu
     */
    public String toString(){
        return nazwa;
    }
    
    
}

class StatystykiDruzyny{
    int wygrane_k;
    int remisy_k;
    int przegrane_k;
    int wygrane_s;
    int remisy_s;
    int przegrane_s;
    int gole_zd_k;
    int gole_st_k;
    int gole_zd_s;
    int gole_st_s;
    int punkty_k;
    int punkty_s;
}
