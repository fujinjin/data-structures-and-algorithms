package array;

public class GetPrefix {

    public static String getPrefix(String[] array) {
        int n = array.length;
        if (n == 0) {
            return "";
        }
        String firstWorld = array[0];
        if (n == 1) {
            return firstWorld;
        }
        int firstLength = firstWorld.length();
        int sum = 0;
        boolean breakLoop = false;
        for (int j = 0; j < firstLength; j++) {
            for (int i = 0; i < n; i++) {
                String nextWord = array[i];
                int nextLength = nextWord.length();
                if (j < nextLength && firstWorld.charAt(j) == nextWord.charAt(j)) {
                    sum++;
                } else {
                    breakLoop = true;
                    break;
                }
            }
            if (breakLoop) {
                break;
            }
        }
        int sameLength = (int) Math.floor(sum / n);
        if (sameLength == 0) {
            return "";
        }
        return firstWorld.substring(0, sameLength);
    }

    public static void main(String[] args) {
        System.out.println(getPrefix(new String[]{"frrst", "frdf", "frl"}));
    }
}
