package Logic;

public class Coach {
	private int pushUps;
	private int sitUps;
	private int airSquats;
	
	
	
	public int getPushUps() {
		return pushUps;
	}

	public void setPushUps(int pushUps) {
		this.pushUps = pushUps;
	}

	public int getSitUps() {
		return sitUps;
	}

	public void setSitUps(int sitUps) {
		this.sitUps = sitUps;
	}

	public int getAirSquats() {
		return airSquats;
	}

	public void setAirSquats(int airSquats) {
		this.airSquats = airSquats;
	}

	public int pushUpsProgression(int pushUpsMax) {
		if(pushUpsMax >=100 ) {
			pushUps = pushUpsMax / 5;
		}
		else if (pushUpsMax >= 70 && pushUpsMax < 100)
		{
			pushUps = pushUpsMax / 4;
		}
		else  {
		pushUps = pushUpsMax / 3;
		}
		
		return pushUps;
	}
	
	public int sitUpsProgression(int sitUpsMax) {
		sitUps = sitUpsMax / 3;	
		return sitUps;
	}
	
	public int airSquatProgression(int airSquatMax) {
		airSquats = airSquatMax / 2;
		return airSquats;
	}
	
	
	
}
