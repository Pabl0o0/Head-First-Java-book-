import java.util.ArrayList;

public class PortalGraMax {

	private PomocnikGry pomocnik = new PomocnikGry();
	private ArrayList<Portal> listaPortali = new ArrayList<Portal>();
	private int iloscRuchow = 0;
	
	private void przygotujGre(){
		Portal pierwszy = new Portal();
		pierwszy.setNazwa("google.pl");
		Portal drugi = new Portal();
		drugi.setNazwa("youtube.com");
		Portal trzeci = new Portal();
		trzeci.setNazwa("facebook.com");
		listaPortali.add(pierwszy);
		listaPortali.add(drugi);
		listaPortali.add(trzeci);
		
		System.out.println("Cel - zatop wszystkie portale !");
		System.out.println(pierwszy.getNazwa()+" "+drugi.getNazwa()+" "+trzeci.getNazwa());
		
		for(Portal rozmieszczanyPortal : listaPortali){
			ArrayList<String> nowePolozenie = pomocnik.rozmiescPortal(3);
			rozmieszczanyPortal.setPolaPolozenia(nowePolozenie);
		}
	}
	
	private void rozpocznijGre(){
		while(!listaPortali.isEmpty()){
			String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole: ");
			sprawdzRuchGracza(ruchGracza);
		}
		zakonczGre();
	}
	
	private void sprawdzRuchGracza(String ruch){
		iloscRuchow++;
		String wynik = "pud³o";
		
		for(Portal portalDoSprawdzenia : listaPortali){
			wynik = portalDoSprawdzenia.sprawdz(ruch);
			if (wynik.equals("trafiony")){
				break;
			}
			if (wynik.equals("zatopiony")){
				listaPortali.remove(portalDoSprawdzenia);
				break;
			}
		}
		System.out.println(wynik);
	}
	
	private void zakonczGre(){
		System.out.println("Zatopiles wszystkie portale!");
	}
	
	public static void main (String[] args){
		PortalGraMax gra = new PortalGraMax();
		gra.przygotujGre();
		gra.rozpocznijGre();
	}
}
