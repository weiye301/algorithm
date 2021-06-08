package offer.array;

/**
 * @author weiye
 * @date 2021/6/7 11:52
 */
public class J17 {
    class Solution {
        //记录当次填充的结果
        char[] curNum;
        //结果填充的索引
        int curIndex = 0;
        //记录结果
        int[] res;
        //记录位数
        int n;

        public int[] printNumbers(int n) {
            this.n = n;
            curNum = new char[n];
            //最大数 是 10^n - 1   如n=2，最大为99，n=3，最大为999
            res = new int[(int) (Math.pow(10, n) - 1)];
            getNum(0);
            return res;
        }

        /**
         * 填充结果数据
         * curNum的作用是遍历每个位置元素，如n=2时，curNum分别为00,01,02......
         * 因为题目要求从1开始填充，所以需要判断curNum不为0才填充
         * @param x 当前位数
         */
        private void getNum(int x) {
            //如果x==n，说明curNum已经是我们要的数了，需要进行结果填充
            if (x == n) {
                //将curNum转换为数字形式
                String numStr = String.valueOf(curNum);
                int num = Integer.parseInt(numStr);
                //要求从1开始填充，所以需要判断curNum不为0才填充
                if (num != 0) {
                    //填充完数据后，curIndex需要+1
                    res[curIndex++] = num;
                }
                return;
            }
            //如果x！=n 说明curNum还没有填满，需要继续填充
            for (char i = '0'; i <= '9'; i++) {
                curNum[x] = i;
                getNum(x + 1);
            }
        }
    }

    class Solution2 {
        public int[] printNumbers(int n) {
            int max = (int) (Math.pow(10, n) - 1);
            int[] res = new int[max];
            for (int i = 1; i <= max; i++) {
                res[i - 1] = i;
            }
            return res;
        }
    }
}
