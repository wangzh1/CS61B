public class NBody {
	
	public static double readRadius (String file) {
		In in = new In(file);
		int N = in.readInt();
		double second = in.readDouble();
		return second;
	}

	public static Planet[] readPlanets (String file) {
		In in = new In(file);
		int N = in.readInt();
		Planet[] allPlanets = new Planet[N];

		double second = in.readDouble();
		for (int i = 0; i < N; ++i) {
			double arg1 = in.readDouble();
			double arg2 = in.readDouble();
			double arg3 = in.readDouble();
			double arg4 = in.readDouble();
			double arg5 = in.readDouble();
			String arg6 = in.readString();
			allPlanets[i] = new Planet(arg1, arg2, arg3, arg4, arg5, "./images/"+arg6);
		}
		return allPlanets;
	}

	public static void main (String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] allPlanets = readPlanets(filename);
		double r = readRadius(filename);
		StdDraw.setScale(-r, r);
		String img = "./images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		int time = 0;
		In in = new In(filename);
		int N = in.readInt();

		while (time < T) {
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			
			for (int i = 0; i < N; ++i) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}

			for (int i = 0; i < N; ++i) {
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			/* Draw the background image */
			StdDraw.clear();
			StdDraw.picture(0, 0, img);
			for (Planet x : allPlanets) {
				StdDraw.picture(x.xxPos, x.yyPos, x.imgFileName);
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}

		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < allPlanets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  		  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  	 	  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
}

 	}
}