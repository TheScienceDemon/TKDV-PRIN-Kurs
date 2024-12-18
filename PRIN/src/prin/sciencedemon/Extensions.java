package prin.ScienceDemon;

public class Extensions {
	public static float Clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static boolean IstZwischen(int value, int min, int max) {
		return value >= min && value <= max;
	}

	public static void PrintToConsole(String line) {
		System.out.println(line);
	}

	public static int Range(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
}
