package suite;

public class TestUtil {

	public static boolean compareMatrix(char matrix1[][], char matrix2[][]) {

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
