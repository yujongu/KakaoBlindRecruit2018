class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        if(record.length == 0){
            return answer;
        }

        int ansCount = 0;

        String[] users = new String[record.length];
        String[] character = new String[record.length];
        String[] actions = new String[record.length];
        for(int i = 0; i < record.length; i++){
            String[] hold = record[i].split("\\s+");
            if(hold[0].equals("Enter")){ //action is Enter
                users[i] = hold[1]; //store user name
                actions[i] = "님이 들어왔습니다."; //store action name
                character[i] = hold[2]; //store character name
                int j = 0;
                while(j < i){
                        if(users[j].equals(users[i])){
                            character[j] = character[i];
                        }
                        j++;
                }
                ansCount++;
            } else if(hold[0].equals("Leave")){
                users[i] = hold[1];
                actions[i] = "님이 나갔습니다.";
                int j = 0;
                while(j < i){ //fetch character name
                    if(users[j].equals(users[i])){
                        character[i] = character[j]; //store character name
                        break;
                    }
                    j++;
                } //end fetch character name
                ansCount++;
            } else if(hold[0].equals("Change")){
                users[i] = hold[1];
                actions[i] = "변경";
                character[i] = hold[2];
                int j = 0;
                while(j < i){
                        if(users[j].equals(users[i])){
                            character[j] = character[i];
                        }
                        j++;
                }
            }
        }
        answer = new String[ansCount];
        int ind = 0;
        for(int i = 0; i < record.length; i++){
            if(!actions[i].equals("변경")){
                String hold = character[i] + actions[i];
                answer[ind] = hold;
                ind++;
            }
        }

        return answer;
    }
}
