package prin.sciencedemon;

public class Extensions {
	public static float Clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static boolean IstZwischen(int value, int min, int max) {
		return value >= min && value <= max;
	}
}
