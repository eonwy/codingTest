function solution(genres, plays) {
    var answer = [];
    let map = new Map();
    
    genres.forEach((genre, index) => {
        if (!map.has(genre)) {
            map.set(genre, {total : 0, songs: []});
        }
        const gInfo = map.get(genre);
        gInfo.total += plays[index];
        gInfo.songs.push({ index, play: plays[index] });
    })
    
    const sortedMap = [...map.entries()].sort((a, b) => b[1].total - a[1].total);
    
    sortedMap.forEach(([_, gInfo]) => {
        gInfo.songs
            .sort((a, b) => {
                if (a.play == b.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            })
            .slice(0, 2)
            .forEach(song => answer.push(song.index));
    })
    
    return answer;
}