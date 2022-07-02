public class Planet {
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
		 		  double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance (Planet p) {
		return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) 
			+ (yyPos - p.yyPos) * (yyPos - p.yyPos));
	}

	public double calcForceExertedBy (Planet p) {
		double G = 6.67e-11;
		return (G * mass * p.mass / (calcDistance(p) * calcDistance(p)));
	}

	public double calcForceExertedByX (Planet p) {
		return (calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p));
	}

	public double calcForceExertedByY (Planet p) {
		return (calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p));
	}

	public double calcNetForceExertedByX (Planet[] allPlanets) {
		double sumX = 0;
		for (Planet x : allPlanets) {
			if (!this.equals(x)) sumX += this.calcForceExertedByX(x);
		}
		return sumX;
	}

	public double calcNetForceExertedByY (Planet[] allPlanets) {
		double sumY = 0;
		for (Planet x : allPlanets) {
			if (!this.equals(x)) sumY += this.calcForceExertedByY(x);
		}
		return sumY;
	}

	public void update (double t, double F_x, double F_y) {
		double a_x = F_x / mass;
		double a_y = F_y / mass;
		xxVel += t * a_x;
		yyVel += t * a_y;
		xxPos += t * xxVel;
		yyPos += t * yyVel;
		
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}
}