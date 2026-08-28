class Solution {
    List<List<String>> ans=new ArrayList<>();
    Map<String, List<String>> map=new HashMap<>();
    public List<List<String>> findLadders(String s, String e, List<String> list){
        Set<String> set=new HashSet<>(list);
        if(!set.contains(e)) return ans;
        Queue<String> q=new LinkedList<>(); 
        q.add(s);
        set.remove(s);
        while(!q.isEmpty()){
            Set<String> used=new HashSet<>();
            for(int n=q.size(); n>0; n--){
                String w=q.poll();
                for(int i=0; i<w.length(); i++){
                    char[] a=w.toCharArray();
                    for(char c='a'; c<='z'; c++){
                        a[i]=c;
                        String x=new String(a);
                        if(!set.contains(x)) continue;
                        map.computeIfAbsent(x, k-> new ArrayList<>()).add(w);
                        if(used.add(x)) q.add(x);
                    }
                }
            }
            set.removeAll(used);
            if(used.contains(e)) break;
        }
        dfs(e, s, new ArrayList<>());
        return ans;
    }
    void dfs(String w, String s, List<String> path){
        path.add(w);
        if(w.equals(s)){
            Collections.reverse(path);
            ans.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else{
            for(String p:map.getOrDefault(w, List.of()))
            dfs(p, s, path);
        }
        path.remove(path.size()-1);
    }
}
