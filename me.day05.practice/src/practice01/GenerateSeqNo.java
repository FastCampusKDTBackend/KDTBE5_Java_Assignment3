package practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GenerateSeqNo {

    private LocalDate today;
    private LocalDate nextDay;
    private int seqNo;

    private static GenerateSeqNo generateSeqNo;

    public static GenerateSeqNo getInstance() {
        if (generateSeqNo == null) {
            generateSeqNo = new GenerateSeqNo();
        }
        return generateSeqNo;
    }

    private GenerateSeqNo() {
        initSeq();
//        System.out.println(today);
//        System.out.println(nextDay);
    }
    //seqNo를 넘겨줄 때 today와 nextDay 날짜를 비교해서 하루가 지났다면 초기화
    public String getSeqNo() {
        if (today.isAfter(nextDay)) initSeq();
        seqNo++;
        //seqNo를 16진수로 변환하여 return. 10진수 4자리보다 여유폭을 확대함.
        return today.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + String.format("%04x", seqNo);
    }

    //하루가 지났다면 seqNo 를 0으로 초기화 해서 현재 일자 + 1번부터 부여될 수 있도록 수정
    private void initSeq() {
        today = LocalDate.now(ZoneId.systemDefault());
        nextDay = today.plusDays(1);
        seqNo = 0;
    }

}
