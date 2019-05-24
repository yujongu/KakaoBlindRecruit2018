import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        if(record.length == 0){
            return answer;
        }

        int ansCount = 0;

        HashMap<String, String> userInfo = new HashMap<>();


        for(int i = 0; i < record.length; i++){
            String[] hold = record[i].split("\\s+");
            if(hold[0].equals("Enter")){ //action is Enter
                if(userInfo.containsKey(hold[1])){
                    userInfo.replace(hold[1], hold[2]);
                } else{
                    userInfo.put(hold[1], hold[2]); //store <uid, character>
                }
                ansCount++;
            } else if(hold[0].equals("Leave")){
                ansCount++;
            } else if(hold[0].equals("Change")){
                userInfo.replace(hold[1], hold[2]);
            }
        }

        answer = new String[ansCount];
        int ind = 0;
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split("\\s+");
            if(temp[0].equals("Enter")){
                String hold = userInfo.get(temp[1]) + "님이 들어왔습니다.";
                answer[ind] = hold;
                ind++;
            }  else if(temp[0].equals("Leave")){
                String hold = userInfo.get(temp[1]) + "님이 나갔습니다.";
                answer[ind] = hold;
                ind++;
            }
        }

        return answer;
    }
}