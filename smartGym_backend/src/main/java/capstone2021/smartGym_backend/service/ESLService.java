package capstone2021.smartGym_backend.service;

import capstone2021.smartGym_backend.DTO.ESL.ESLDeleteDTO;
import capstone2021.smartGym_backend.DTO.ESL.ESLEquipmentMatchingDTO;
import capstone2021.smartGym_backend.domain.ESL;
import capstone2021.smartGym_backend.domain.Equipment;

import java.util.List;

public interface ESLService {
    boolean eslCreate(); //ESL 생성
    boolean eslEquipmentUpdate(ESLEquipmentMatchingDTO eslEquipmentMatchingDTO); //ESL 수정
    boolean eslDelete(ESLDeleteDTO eslDeleteDTO); //ESL 삭제
    List<ESL> eslRead(); //ESL 조회
    void eslReservationUpdate();
    String makeCsvStringAndReservationMatching(Equipment equipment, ESL esl,ESL newEsl);
    void writeCSV(String csvString);
    String recentReservation(Equipment equipment); //현재 시간 기준 가장 최근 예약 조회(모두 사용 가능 상태일 경우)


}

