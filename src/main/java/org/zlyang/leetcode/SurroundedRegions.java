package org.zlyang.leetcode;

/**
 * @author: zlyang
 * @date: 2022-03-25 18:23
 * @description: 并查集实例，思路可取，但有bug
 */
public class SurroundedRegions {

    private static class UnionSet{
        private final int[] set;

        public enum Type{
            EDGE(1), MID(0);

            private final int index;

            Type(int i){
                this.index = i;
            }

            public int getIndex() {
                return index;
            }

            public static Type getType(int i){
                for (Type value : Type.values()) {
                    if(value.getIndex() == i){
                        return value;
                    }
                }
                return EDGE;
            }
        }

        public UnionSet(int m, int n){
            this.set = new int[Math.max(2, m * n)];
        }


        public Type find(int x){
            return Type.getType(set[x]);
        }

        public void join(Type type, int x){
            set[x] = type.getIndex();
        }

        public void join(int x, int y){
            set[x] = set[y];
        }

    }

    public void solve(char[][] board) {
        UnionSet unionSet = new UnionSet(board.length, board[0].length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i == 0 || j == 0 || i + 1 == board.length || j + 1 == board[i].length){
                    unionSet.join(UnionSet.Type.EDGE, i * board[i].length + j);
                } else {
                    unionSet.join(UnionSet.Type.MID, i * board[i].length + j);
                    if(board[i-1][j] == 'O')  unionSet.join(i * board[i].length + j, (i-1) * board[i].length + j);
                    if(board[i+1][j] == 'O')  unionSet.join(i * board[i].length + j, (i+1) * board[i].length + j);
                    if(board[i][j-1] == 'O')  unionSet.join(i * board[i].length + j, i * board[i].length + j - 1);
                    if( board[i][j+1] == 'O') unionSet.join(i * board[i].length + j, i * board[i].length + j + 1);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(unionSet.find(i * board[i].length + j) == UnionSet.Type.MID){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
