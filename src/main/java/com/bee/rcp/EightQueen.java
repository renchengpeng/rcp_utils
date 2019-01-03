package com.bee.rcp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Auther: renchengpeng
 * @Date: 2019/1/3 13:34
 * @Description:八皇后问题---计算八皇后的摆放結果數
 */
public class EightQueen {
    int count = 0;
    int size = 4;

    @Test
    public void test() throws IOException {
        Integer [][]  pan =new  Integer [size][size];

        //第一行
        for (int y=0;y<size;y++) {
            pan[0][y]=1;//放入皇后
            search(pan, 1);
            //清楚本行的皇后
            pan[0][y]=0;

        }

        System.out.println("============总共的放入结果数============:" + count);

    }

    /**
     *
     * 功能描述: 计算某一位置的皇后摆放位置
     *
     * @param:
     * @return:
     * @auther: renchengpeng
     * @date: 2019/1/3 13:37
     */
    private void search(Integer [][] p, int x) {
        if (x >= size) {
            count ++;
            return;
        }
        for (int y = 0; y <size;y++) {
            //检测改位置是否可以放入皇后
            if (check(p, x, y)) {
                p[x][y]=1;//放入皇后
                search(p, x+1);
                //清楚本行的皇后
                p[x][y]=0;
            }
        }
    }

    /**
     *
     * 功能描述:  检测改位置是否可以放入皇后
     *
     * @param:
     * @return:
     * @auther: renchengpeng
     * @date: 2019/1/3 13:37
     */
    private Boolean check(Integer [][] p, int X, int Y) {
        boolean flag = false;
        for (int x = 0; x<size; x++) {
            for (int y=0; y<size; y++) {
                if (null != p[x][y] && p[x][y] == 1 ) {
                    if (x != X && y != Y && ((X-Y) != (x-y)) && ((x + y) != (X +Y))) {
                        flag = true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return flag;
    }
}
