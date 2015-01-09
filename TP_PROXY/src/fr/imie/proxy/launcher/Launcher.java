package fr.imie.proxy.launcher;

public class Launcher {

	public static void main(String[] args) {
		INightClub nightClub = new NightClubProxy(new NightClub());
		Client cust = new Client();
		
		cust.setIsOk(false);
		nightClub.enter(cust);
	}
}

