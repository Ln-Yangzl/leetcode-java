package org.zlyang.leetcode;

/**
 * @author ：zlyang
 * @description：
 * @date ：2022/2/25 9:16
 */
public class WordSearch {

    /**
     * 直接DFS算法
     * @param board
     * @param word
     * @param i
     * @param j
     * @param pos
     * @return
     */
    private boolean graphDFS(char[][] board, String word, int i, int j, int pos){
        if(pos == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word.charAt(pos)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        pos++;
        boolean res = graphDFS(board, word, i+1, j, pos) || graphDFS(board, word, i-1, j, pos) ||
                graphDFS(board, word, i, j+1, pos) || graphDFS(board, word, i, j-1, pos);
        board[i][j] = temp;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(graphDFS(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


//    /**
//     * 先利用相邻性粗判断，可以省去大量无效board
//     */
//    private boolean isExist(char[][] board, char[] word, int index,int i,int j){
//        if(index>=word.length)
//            return true;
//        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word[index])
//            return false;
//        index++;
//        board[i][j]='*';
//        if(isExist(board,word,index,i+1,j)||
//                isExist(board,word,index,i,j+1)||
//                isExist(board,word,index,i,j-1)||
//                isExist(board,word,index,i-1,j))
//            return true;
//        board[i][j]=word[index-1];
//        return false;
//    }
//
//    /**
//     * 相邻性判断，记录board中word[i]和word[i+1]是否存在相邻
//     * 若不存在，直接返回false
//     * 此时不会存在合法的情况
//     */
//    private boolean charExists(char[][] board, char[] word){
//        int[] charCount= new int['z'-'A'+1];
//        boolean[][] neighbours= new boolean['z'-'A'+1]['z'-'A'+1];
//        int i,j,currentCharIndex,neighbourIndex;
//        for(i=0;i<board.length;i++)
//            for(j=0;j<board[0].length;j++){
//                currentCharIndex=board[i][j]-'A';
//                charCount[currentCharIndex]++;
//                if(i+1<board.length){
//                    neighbourIndex=board[i+1][j]-'A';
//                    neighbours[currentCharIndex][neighbourIndex]=true;
//                    neighbours[neighbourIndex][currentCharIndex]=true;
//                }
//                if(i>1){
//                    neighbourIndex=board[i-1][j]-'A';
//                    neighbours[currentCharIndex][neighbourIndex]=true;
//                    neighbours[neighbourIndex][currentCharIndex]=true;
//                }
//                if(j>1){
//                    neighbourIndex=board[i][j-1]-'A';
//                    neighbours[currentCharIndex][neighbourIndex]=true;
//                    neighbours[neighbourIndex][currentCharIndex]=true;
//                }
//                if(j+1<board[0].length){
//                    neighbourIndex=board[i][j+1]-'A';
//                    neighbours[currentCharIndex][neighbourIndex]=true;
//                    neighbours[neighbourIndex][currentCharIndex]=true;
//                }
//            }
//
//        for(i=0;i<word.length;i++){
//            currentCharIndex=word[i]-'A';
//
//            if(0==charCount[currentCharIndex]--)
//                return false;
//            if(i<word.length-1 && (neighbours[currentCharIndex][word[i+1]-'A']==false ||neighbours[word[i+1]-'A'][currentCharIndex]==false))
//                return false;
//        }
//
//        return true;
//    }
//    public boolean exist(char[][] board, String word) {
//        char[] words= word.toCharArray();
//        //先判断相邻是否存在
//        if(!charExists(board,words))
//            return false;
//        //若存在的情况下再进行DFS
//        for(int i=0;i<board.length;i++)
//            for(int j=0;j<board[0].length;j++)
//                if(isExist(board,words,0,i,j))
//                    return true;
//        return false;
//    }
}
