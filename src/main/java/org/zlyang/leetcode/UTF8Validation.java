package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-09-12 11:22
 * @description:
 */
public class UTF8Validation {

    public static void main(String[] args) {
        int[] nums = {250,145,145,145,145};
        UTF8Validation utf8Validation = new UTF8Validation();
        System.out.println(utf8Validation.validUtf8(nums));
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            if(!validStart(data[i])){
                return false;
            }
            int len = getLen(data[i]);
            for (int j = 0; j < len; j++){
                if(j + i + 1 >= data.length || !validFollow(data[j + i + 1])){
                    return false;
                }
            }
            i += (len + 1);
        }
        return true;
    }

    private boolean validStart(int data){
        return !validFollow(data) && !((0b11111000 & data) == 0b11111000);
    }

    private boolean validFollow(int data){
        return (data & 0b11000000) == 0b10000000;
    }


    private int getLen(int data){
        int mask = 0b10000000;
        if((data & mask) == 0){
            return 0;
        }
        mask >>= 1;
        int count = 0;
        while((data & mask) != 0){
            count++;
            mask >>= 1;
        }
        return count;
    }

}
