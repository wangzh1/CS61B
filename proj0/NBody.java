public class NBody {
	
	public static double readRadius (String file) {
		In in = new In(file);
		int first = in.readInt();
		double second = in.readDouble();
		return second;
	}

	public static Planet[] readPlanets (String file) {
		In in = new In(file);
		Planet[] allPlanets = new Planet[5];
		int first = in.readInt();
		double second = in.readDouble();
		for (int i = 0; i < 5; ++i) {
			double arg1 = in.readDouble();
			double arg2 = in.readDouble();
			double arg3 = in.readDouble();
			double arg4 = in.readDouble();
			double arg5 = in.readDouble();
			String arg6 = in.readString();
			allPlanets[i] = new Planet(arg1, arg2, arg3, arg4, arg5, arg6);
		}
		return allPlanets;
	}
}