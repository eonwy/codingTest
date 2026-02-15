import java.util.*;

class Solution {
    static ArrayList<Integer> answer = new ArrayList<>();
    static HashMap<String, Integer> bestGenres = new HashMap<>();
    static HashMap<String, List<int[]>> eachSongs = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        
        for (int i = 0; i < genres.length; i++) {
            bestGenres.put(genres[i], bestGenres.getOrDefault(genres[i], 0) + plays[i]);
            
            eachSongs.putIfAbsent(genres[i], new ArrayList<>());
            eachSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(bestGenres.keySet());
        genreList.sort((a, b) -> bestGenres.get(b) - bestGenres.get(a));
        
        for (String g : genreList) {
            
            List<int[]> songs = eachSongs.get(g);
            
            songs.sort((a, b) -> {
                       if (a[1] == b[1]) {
                           return a[0] - b[0];
                       }
                       return b[1] - a[1];
            });
            
            answer.add(songs.get(0)[0]);
            
            if (songs.size() > 1) {
                answer.add(songs.get(1)[0]);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}