/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bowling;
import java.io.*;//標準入力
/**
 *
 * @author otaka
 */
public class Game {
    public static ScoreSheet scoresheet=new ScoreSheet();
    public static Store store=new Store();
    public static String Question;
    public static int count_scan,count_strike,score_target;
    
    
    public static void main(String[] args){
        Game game =new Game();
         
        try{
            game.start();
        }
        catch(IOException e){
           System.out.println("エラー:"+e);
        }
    }
    
    public void start()throws IOException{
        boolean flag_question=true;
        boolean flag_random=true;
        InputStreamReader is = new InputStreamReader(System.in);      
        BufferedReader br = new BufferedReader(is);                   

        while(flag_random){
             System.out.println("git test");
            System.out.println("ランダム？　\"y\" or \"n\"");
           
                Question = br.readLine();
                if(Question.equals("y") || Question.equals("n")){
                    flag_random=false;          
                }
                else{
                    System.out.println("　\"y\" or \"n\"を入力してください");
                          continue;
                }
        }
        
        //ランダム表示実行
        if(Question.equals("y")){
             store.array(scoresheet);
        }
        
        //手入力
        else{
            while(flag_question){
                System.out.print("目標スコア=");
                try{
                     score_target =Integer.parseInt(br.readLine());
                     store.score_target=score_target;
                     if(score_target>300 || score_target<0){
                        System.out.println("0～300の数字を入力してください");
                        continue;
                     }
                         
                }
                catch(IOException | NumberFormatException e){
                        System.out.println("例外" +e+" が発生しました");
                        System.out.println("数字を入力してください");
                        continue;
                }
                flag_question=false;
            }
            store.array_scan(scoresheet);
        }

    }
}
