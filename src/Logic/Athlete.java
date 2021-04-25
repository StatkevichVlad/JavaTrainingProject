package Logic;

public class Athlete {

	private String name = null;
	private int age = 0;
	private int weigth = 0;
	private int recommentedCalories = 0;

	private int heigth;
	private boolean sex;
	private double activity; // men true, women false;
	private int coefficient;
	private int goal;

	public Athlete() {
		super();
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	
	

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public double getActivity() {
		return activity;
	}

	public void setActivity(double activity) {
		this.activity = activity;
	}
	
	

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int calcCalories() {

		if (sex == true) {
			coefficient = (5);
		} else {
			coefficient = -161;
		}
		recommentedCalories = (int) ((((10 * weigth) + (6.25 * heigth)) - (5 * age) + coefficient) * activity) + goal;

		return recommentedCalories ;
	}
	




	public int getRecommentedCalories() {
		return recommentedCalories;
	}

	public void setRecommentedCalories(int recommentedCalories) {
		this.recommentedCalories = recommentedCalories;
	}

	public void printInfo() {
		System.out.println("Athlete [name=" + name + ", age=" + age + ", weigth=" + weigth + ", recommentedCalories="
				+ recommentedCalories + ", heigth=" + heigth + ", sex=" + sex + ", activity=" + activity
				+ ", coefficient=" + coefficient + "]");
	}


}
