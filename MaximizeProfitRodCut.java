import com.sun.org.apache.xpath.internal.operations.Neg;

/**
 * In this class I implement the maximize profit metaphor base on
 * rod cut algorithms of dynamic programming
 * The problems is that a company want to sell a rod.
 * But it want to maximize profit.
 * It wonder ? What should it cut if it can maximize profit of the
 * rod cut sell
 *
 */
public class MaximizeProfitRodCut {
    public static int[][] extendedBottomUpCutRod(int[] priceTable,int rodSize)
    {
        // For a rod with size 0, revenue is zero as well as it size
        final int rodSizeIncludeZeroSize = rodSize+1;
        // The two dimensions array represent the maximum revenue of the cut
        // And it represent the optimal size that it can be cut
        // Such as A[7][0] => 18, A[7][1] => 1. The size is 7, and the maximum
        // revenue is 18. And it suboptimal size can be cut is 1. So the next
        // sub of optimal of this revenue is size of 6 and so on.
        int[][] optimalRodCutSize = new int[rodSizeIncludeZeroSize][2];
        optimalRodCutSize[0][0] = 0;
        for (int firstCutSize = 1; firstCutSize < rodSizeIncludeZeroSize; firstCutSize++)
        {
            int maxRevenueOnNextCut = Integer.MIN_VALUE;
            for (int contagiousCutSize = 1; contagiousCutSize <= firstCutSize; contagiousCutSize++)
            {

                if(maxRevenueOnNextCut < priceTable[contagiousCutSize] + optimalRodCutSize[firstCutSize-contagiousCutSize][0])
                {

                    maxRevenueOnNextCut = priceTable[contagiousCutSize] + optimalRodCutSize[firstCutSize-contagiousCutSize][0];
                    optimalRodCutSize[firstCutSize][1] = contagiousCutSize;
                }
            }
            optimalRodCutSize[firstCutSize][0] = maxRevenueOnNextCut;
        }
        return optimalRodCutSize;
    }

    public static void printCutRodSolution(int[] priceTable, int rodSize) {
        int [][] solutionCut  = extendedBottomUpCutRod(priceTable,rodSize);

        while (rodSize > 0)
        {
            System.out.print("revenue " + solutionCut[rodSize][0]+"\t");
            System.out.print("size " +    solutionCut[rodSize][1] + "\t\n");
            rodSize = rodSize-solutionCut[rodSize][1];
        }
    }

    public static void main(String args[])
    {
//      TODO TEST SIZE TABLE = {0,1,5,8,9,10,17,17,20,24,30};
        int[] priceTable0 = {0};
        printCutRodSolution(priceTable0,0);
        System.out.println("----------------");
        int[] priceTable1 = {0,1};
        printCutRodSolution(priceTable1,1);
        System.out.println("----------------");
        int[] priceTable2 = {0,1,5};
        printCutRodSolution(priceTable2,2);
        System.out.println("----------------");
        int[] priceTable3 = {0,1,5,8};
        printCutRodSolution(priceTable3,3);
        System.out.println("----------------");
        int[] priceTable4 = {0,1,5,8,9};
        printCutRodSolution(priceTable4,4);
        System.out.println("----------------");
        int[] priceTable5 = {0,1,5,8,9,10};
        printCutRodSolution(priceTable5,5);
        int[] priceTable6 = {0,1,5,8,9,10,17};
        printCutRodSolution(priceTable6,6);
        System.out.println("----------------");
        int[] priceTable7 = {0,1,5,8,9,10,17,17};
        printCutRodSolution(priceTable7,7);
        System.out.println("----------------");
        int[] priceTable8 = {0,1,5,8,9,10,17,17,20};
        printCutRodSolution(priceTable8,8);
        System.out.println("----------------");
        int[] priceTable9 = {0,1,5,8,9,10,17,17,20,24};
        printCutRodSolution(priceTable9,9);
        System.out.println("----------------");
        int[] priceTable10 = {0,1,5,8,9,10,17,17,20,24,30};
        printCutRodSolution(priceTable10,10);
    }
}
