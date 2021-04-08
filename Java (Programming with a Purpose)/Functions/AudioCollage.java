public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = a[i] * alpha;
        }
        return newSound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = a[a.length - 1 - i];
        }
        return newSound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] newSound = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) newSound[i] = a[i];
        for (int i = 0; i < b.length; i++) newSound[i + a.length] = b[i];
        return newSound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] largerSound;
        double[] shorterSound;

        if (a.length < b.length) {
            largerSound = b;
            shorterSound = a;
        }
        else {
            largerSound = a;
            shorterSound = b;
        }

        double[] newSound = new double[largerSound.length];
        for (int i = 0; i < largerSound.length; i++) {
            if (i >= shorterSound.length) newSound[i] = largerSound[i] + 0;
            else newSound[i] = a[i] + b[i];
        }
        return newSound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] newSound = new double[(int) (a.length / alpha)];
        for (int i = 0; i < (int) (a.length / alpha); i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] scratch = StdAudio.read("scratch.wav");

        double[] doublePiano = merge(piano, piano);
        double[] pianoAndBox = mix(doublePiano,
                                   merge(merge(merge(beatbox, beatbox), beatbox), beatbox));
        double[] slowDial = changeSpeed(amplify(dialup, 0.2), 1.1);
        double[] revScratch = reverse(scratch);

        double[] newSound = amplify(merge(harp,
                                          merge(mix(merge(merge(doublePiano, pianoAndBox),
                                                          changeSpeed(reverse(harp), 0.45)),
                                                    slowDial),
                                                changeSpeed(amplify(revScratch, 0.3), 3))), 0.6);

        StdAudio.play(newSound);
    }
}
