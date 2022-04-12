package org.zlyang.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-10 20:33
 * @description:
 */
public class MiHaYo3 {

    private static class Stage{
        private int i;
        private int j;
        private boolean hasFlower;
        private boolean hasMeet;

        Stage(int i, int j, Stage stage){
            this.i = i;
            this.j = j;
            this.hasFlower = stage.hasFlower;
            this.hasMeet = stage.hasMeet;
        }

        Stage(int i, int j, boolean stage){
            this.i = i;
            this.j = j;
            this.hasFlower = stage;
            this.hasMeet = stage;
        }

        Stage(int i, int j){
            this.i = i;
            this.j = j;
        }

        public void setStage(char c){
            this.setFlower(c);
            this.setMet(c);
        }

        public boolean isOver(){
            return this.hasFlower && this.hasMeet;
        }

        public void setMet(char c){
            this.hasMeet = this.hasMeet || c == '$';
        }

        public void setFlower(char c){
            this.hasFlower = this.hasFlower || c == '#';
        }

        public boolean canGo(char c){
            return c != 'B' && (c != 'T' || isOver());
        }
    }

    private static boolean checkOver(char[][] board, Stage stage){
        return stage.hasFlower && stage.hasMeet && board[stage.i][stage.j] == '^';
    }

    private static int toGoal(char[][] board, int startI, int startJ){
        LinkedList<Stage> current = new LinkedList<>();
        LinkedList<Stage> next = new LinkedList<>();
        current.add(new Stage(startI, startJ, true));
        int count = 0;

        while(true){
            while(!current.isEmpty()){
                Stage stage = current.poll();
                if(stage.i != 0 && board[stage.i - 1][stage.j] != 'B'){
                    Stage nextStage = new Stage(stage.i - 1, stage.j, stage);
                    if(checkOver(board, nextStage)){
                        return count + 1;
                    }
                    nextStage.setStage(board[stage.i - 1][stage.j]);
                    if(board[stage.i - 1][stage.j] != 'B'){
                        board[stage.i - 1][stage.j] = 'B';
                    }
                    next.add(nextStage);
                }
                if(stage.j != 0 && board[stage.i][stage.j - 1] != 'B'){
                    Stage nextStage = new Stage(stage.i, stage.j - 1, stage);
                    if(checkOver(board, nextStage)){
                        return count + 1;
                    }
                    nextStage.setStage(board[stage.i][stage.j - 1]);
                    if(board[stage.i][stage.j - 1] != 'B'){
                        board[stage.i][stage.j - 1] = 'B';
                    }
                    next.add(nextStage);
                }
                if(stage.i < board.length - 1 && board[stage.i + 1][stage.j] != 'B'){
                    Stage nextStage = new Stage(stage.i + 1, stage.j, stage);
                    if(checkOver(board, nextStage)){
                        return count + 1;
                    }
                    nextStage.setStage(board[stage.i + 1][stage.j]);
                    if(board[stage.i + 1][stage.j] != 'B'){
                        board[stage.i + 1][stage.j] = 'B';
                    }
                    next.add(nextStage);
                }
                if(stage.j < board[0].length - 1 && board[stage.i][stage.j + 1] != 'B'){
                    Stage nextStage = new Stage(stage.i, stage.j + 1, stage);
                    if(checkOver(board, nextStage)){
                        return count + 1;
                    }
                    nextStage.setStage(board[stage.i][stage.j + 1]);
                    if(board[stage.i][stage.j + 1] != 'B'){
                        board[stage.i][stage.j + 1] = 'B';
                    }
                    next.add(nextStage);
                }
            }
            count++;
            LinkedList<Stage> temp = current;
            current = next;
            next = temp;
        }
    }

    private static int helper(char[][] board, Stage stage, int current){
        if(stage.isOver()){
            return current + toGoal(board, stage.i, stage.j);
        }
        int min = Integer.MAX_VALUE;
        if(stage.i != 0 && stage.canGo(board[stage.i - 1][stage.j])){
            Stage nextStage = new Stage(stage.i - 1, stage.j, stage);
            nextStage.setStage(board[stage.i - 1][stage.j]);
            min = Math.min(min, helper(board, nextStage, current + 1));
        }
        if(stage.j != 0 && board[stage.i][stage.j - 1] != 'B'){
            Stage nextStage = new Stage(stage.i, stage.j - 1, stage);
            nextStage.setStage(board[stage.i][stage.j - 1]);
            min = Math.min(min, helper(board, nextStage, current + 1));
        }
        if(stage.i < board.length - 1 && board[stage.i + 1][stage.j] != 'B'){
            Stage nextStage = new Stage(stage.i + 1, stage.j, stage);
            nextStage.setStage(board[stage.i + 1][stage.j]);
            min = Math.min(min, helper(board, nextStage, current + 1));
        }
        if(stage.j < board[0].length - 1 && board[stage.i][stage.j + 1] != 'B'){
            Stage nextStage = new Stage(stage.i, stage.j + 1, stage);
            nextStage.setStage(board[stage.i][stage.j + 1]);
            min = Math.min(min, helper(board, nextStage, current + 1));
        }
        return min;
    }

    public static int getMinStepDfs(char[][] board, int startI, int startJ){
        return helper(board, new Stage(startI, startJ), 0);
    }

    public static int getMinStep(char[][] board, int startI, int startJ){
        LinkedList<Stage> current = new LinkedList<>();
        LinkedList<Stage> next = new LinkedList<>();
        current.add(new Stage(startI, startJ));
        int count = 0;
        int res = Integer.MAX_VALUE;
        int total = board.length * board[0].length;
        int notFlash = 0;
        while(true){
            boolean flag = false;
            while(!current.isEmpty()){
                Stage stage = current.poll();
                if(stage.i != 0 && stage.canGo(board[stage.i - 1][stage.j])){
                    Stage nextStage = new Stage(stage.i - 1, stage.j, stage);
                    nextStage.setStage(board[stage.i - 1][stage.j]);
                    if(nextStage.isOver()){
                        int temp = count + toGoal(board, nextStage.i, nextStage.j) + 1;
                        if(res > temp){
                            res = temp;
                            flag = true;
                        }
                    }

//                    if(board[stage.i - 1][stage.j] != 'B'){
//                        board[stage.i - 1][stage.j] = 'T';
//                    }
                    next.add(nextStage);
                }
                if(stage.j != 0 && board[stage.i][stage.j - 1] != 'B'){
                    Stage nextStage = new Stage(stage.i, stage.j - 1, stage);
                    nextStage.setStage(board[stage.i][stage.j - 1]);
                    if(nextStage.isOver()){
                        int temp = count + toGoal(board, nextStage.i, nextStage.j) + 1;
                        if(res > temp){
                            res = temp;
                            flag = true;
                        }
                    }

//                    if(board[stage.i][stage.j - 1] != 'B'){
//                        board[stage.i][stage.j - 1] = 'T';
//                    }
                    next.add(nextStage);
                }
                if(stage.i < board.length - 1 && board[stage.i + 1][stage.j] != 'B'){
                    Stage nextStage = new Stage(stage.i + 1, stage.j, stage);
                    nextStage.setStage(board[stage.i + 1][stage.j]);
                    if(nextStage.isOver()){
                        int temp = count + toGoal(board, nextStage.i, nextStage.j) + 1;
                        if(res > temp){
                            res = temp;
                            flag = true;
                        }
                    }

//                    if(board[stage.i + 1][stage.j] != 'B'){
//                        board[stage.i + 1][stage.j] = 'T';
//                    }
                    next.add(nextStage);
                }
                if(stage.j < board[0].length - 1 && board[stage.i][stage.j + 1] != 'B'){
                    Stage nextStage = new Stage(stage.i, stage.j + 1, stage);
                    nextStage.setStage(board[stage.i][stage.j + 1]);
                    if(nextStage.isOver()){
                        int temp = count + toGoal(board, nextStage.i, nextStage.j) + 1;
                        if(res > temp){
                            res = temp;
                            flag = true;
                        }
                    }

//                    if(board[stage.i][stage.j + 1] != 'B'){
//                        board[stage.i][stage.j + 1] = 'T';
//                    }
                    next.add(nextStage);
                }
            }
            count++;
            LinkedList<Stage> temp = current;
            current = next;
            next = temp;
            if(!flag){
                notFlash++;
            } else {
                notFlash = 0;
            }
            if(count > res || count > total || notFlash > res){
                return res;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        int startI = -1, startJ = -1;
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'm'){
                    startI = i;
                    startJ = j;
                    board[i][j] = 'T';
                }
            }
        }
        System.out.println(getMinStepDfs(board, startI, startJ));
    }
}
