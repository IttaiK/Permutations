public class RecurPerm{


    public static void main(String[] args){
        System.out.println(fact(6));

        System.out.println();

        int[] in = new int[]{2,3,4};
        int[][] result = recursivePerm(in);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        int[] in4 = new int[]{1,2,3,4};
        int[][] result4 = recursivePerm(in4);
        for (int i = 0; i < result4.length; i++) {
            for (int j = 0; j < result4[0].length; j++) {
                System.out.print(result4[i][j]);
            }
            System.out.println();
        }
    }


    public static int[][] recursivePerm(int[] nums){
        int num = nums.length;

        int[][] out = new int[fact(num)][num];

        if(num == 2){
            out[0][0] = nums[0];
            out[0][1] = nums[1];
            out[1][0] = nums[1];
            out[1][1] = nums[0];
            return out;
        }

        //creates the smaller array
        int[] tempMini = new int[num-1];
        for (int i = 0; i < tempMini.length; i++) {
            tempMini[i] = nums[i+1];
        }
        int[][] mini = recursivePerm(tempMini);

        //fill array unflipped
        for (int i = 0; i < fact(num); i++) {
            out[i][0] = nums[0];
            for (int j = 1; j < num; j++) {
                out[i][j] = mini[i%fact(num-1)][j-1];
            }
        }
        
        //flipping
        int flipCol = 0;
        for (int i = 0; i < fact(num); i++) {
            if(i%fact(num-1) == 0 && i!=0){
                for (int j = i; j < fact(num); j++) {
                    int temp = out[j][flipCol];
                    out[j][flipCol] = out[j][flipCol+1];
                    out[j][flipCol+1] = temp;
                }
                flipCol++;
            }
        }

        return out;
    }

    public static int fact(int num){
        if (num == 1) return 1;
        return num*fact(num-1);
    }
}