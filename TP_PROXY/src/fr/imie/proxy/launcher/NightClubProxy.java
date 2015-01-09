package fr.imie.proxy.launcher;

public class NightClubProxy implements INightClub {

	public INightClub realObject;

	public NightClubProxy(INightClub realObject)
	{
		this.realObject = realObject;
	}
	
	@Override
	public void enter(Client cust) {
		if (cust.isOk)
			realObject.enter(cust);
		else
			System.out.println("Not ok");
	}

}
