package org.zlyang.leetcode;

import java.util.*;

/**
 * @author: zlyang
 * @date: 2022-03-25 15:09
 * @description:
 */
public class WordLadderII {

    private List<String> getAllNeighbors(HashSet<String> dict, String word){
        ArrayList<String> res = new ArrayList<>();
        char[] wordArr = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++){
            for (int i = 0; i < word.length(); i++) {
                char oldChar = wordArr[i];
                wordArr[i] = ch;
                if(dict.contains(String.valueOf(wordArr))){
                    res.add(String.valueOf(wordArr));
                }
                wordArr[i] = oldChar;
            }
        }
        return res;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res){
        LinkedList<List<String>> queue = new LinkedList<>();
        ArrayList<String> start = new ArrayList<>();
        start.add(beginWord);
        queue.offer(start);
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        boolean isFound = false;
        for(int i = 1; !isFound && !queue.isEmpty(); i++){
            HashSet<String> nextVisited = new HashSet<>();
            while(!queue.isEmpty() && queue.getFirst().size() == i){
                List<String> current = queue.poll();
                List<String> neighbors = getAllNeighbors(dict, current.get(current.size() - 1));
                for (String neighbor : neighbors) {
                    if(!visited.contains(neighbor)){
                        current.add(neighbor);
                        if(neighbor.equals(endWord)){
                            isFound = true;
                            res.add(new ArrayList<>(current));
                        }
                        queue.offer(new ArrayList<>(current));
                        current.remove(current.size() - 1);
                        nextVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(nextVisited);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return res;
        }
        bfs(beginWord, endWord, wordList, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadderII o = new WordLadderII();
        System.out.println(o.findLadders("hit", "cog", list));
    }
}
