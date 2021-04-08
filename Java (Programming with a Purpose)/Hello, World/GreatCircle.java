public class GreatCircle {

    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double ratio = 6371.0;

        double firstSin = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double secondSin = Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2), 2);
        double distance = 2.0 * ratio * Math.asin(Math.sqrt(firstSin + secondSin));
        System.out.println(distance + " Kilometers");
    }

}
