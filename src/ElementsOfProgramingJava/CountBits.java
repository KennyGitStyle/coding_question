package ElementsOfProgramingJava;

public class CountBits {
    public static short countBits(int x)
    {
        short noBit = 0;
        while(x != 0)
        {
            noBit += (x & 1);
            x >>>= 1;
        }
        return noBit;
    }
}
