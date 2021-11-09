package capstone2021.smartGym_backend.service;

import capstone2021.smartGym_backend.DTO.Reservation.CalHolidayDateDTO;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<String> calAvailableDate(); //헬스장 예약 가능일 반환
    List<Integer> calRegularHolidayDate(CalHolidayDateDTO calRegularHolidayDateDTO);//헬스장 정기 휴무일 반환
    List<Integer> calHolidayDate(CalHolidayDateDTO calRegularHolidayDateDTO);//헬스장 휴무일 반환
}
