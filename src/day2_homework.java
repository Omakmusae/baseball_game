import java.util.ArrayList;
import java.util.Scanner;

public class day2_homework {
    public static void main(String[] args) {
        // Math.random() * (5) + 1 -> 1보다 크고 5보다 작은 숫자 랜덤 생성
        // int를 안하면 소수점 자리가 포함되게 난수가 생성됨
        int initValue1 = (int)(Math.random()*10);
        int initValue2 =(int)(Math.random()*10);
        int initValue3 = (int)(Math.random()*10);
        boolean a = true;
        while (true) { //중복으로 생성되는 경우를 막기 위해 반복문 안에 조건문을 넣음
            if (initValue1!=initValue3 && initValue2!=initValue3) {
                break;
            }
            initValue2 = (int)(Math.random()*10);
            initValue3 = (int)(Math.random()*10);
        }
        // 생성된 난수를 문자열로 처리 ex) '1' + '3' + '5' = 135
        String randomComputer = Integer.toString(initValue1) + Integer.toString(initValue2) + Integer.toString(initValue3);
        System.out.println("컴퓨터가 생성한 난수 : "+randomComputer);
        // 문자열 난수를 ArrayList에 넣기
        ArrayList<String> randomList = new ArrayList<>();
        char[] randChar = randomComputer.toCharArray();
        for (char c:randChar) {
            randomList.add(String.valueOf(c)); // [ 1, 3, 5]
        }

        Scanner sc = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        int cnt = 1;

        while (strike < 3) {
            strike =0;
            ball=0;
            String tryNum = sc.nextLine(); //유저가 입력한 숫자
            ArrayList<String> checkList = new ArrayList<>(); // tryNum 처리를 위한 배열 생성
            char[] checkChar = tryNum.toCharArray();
            for (char c : checkChar) {
                checkList.add(String.valueOf(c)); //배열에다 tryNum 넣기
            }
            // [ 1, 3, 5]

            for (int i = 0; i <randomList.size() ; i++) { // randomList 순회를 위한 반복문
                for (int j = 0; j <checkList.size() ; j++) { //checkList 순회를 위한 반복문
                    if (i==j && randomList.get(i).equals(checkList.get(j))) { //strike 조건
                        strike++;
                    } else  {
                        if (randomList.get(i).equals(checkList.get(j))) { // ball 조건
                            ball++;
                        }
                        else {
                            continue;
                        }
                    }
                }
                if (i ==2) { //게임 종료 조건
                    break;
                }
            }
            // 출력 부분
            System.out.println(cnt + "번째 시도 :" + tryNum);
            if (strike!=0 && ball!=0 || strike==0 && ball==0) {
                System.out.println(ball +"B" + strike+"S");
            }
            else if (strike!=0) {
                System.out.println(strike + "S");
            }
            else {
                    System.out.println(ball +"B");
            }
            cnt++;
        }
        System.out.println(cnt-1+"번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다");
    }
}
