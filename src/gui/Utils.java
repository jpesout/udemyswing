package gui;

public class Utils {
    public static String getFileExtenstion(String name) {
        int pointIndex = name.lastIndexOf(".");

        if(pointIndex < 0) {
            return null;
        }

        if(pointIndex == name.length() - 1) {
            return null;
        }

        return name.substring(pointIndex + 1);
    }
}
