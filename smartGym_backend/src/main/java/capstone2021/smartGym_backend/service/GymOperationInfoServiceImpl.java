package capstone2021.smartGym_backend.service;

import capstone2021.smartGym_backend.DTO.GymInfo.GymHolidayCreateDTO;
import capstone2021.smartGym_backend.DTO.GymInfo.GymHolidayDeleteDTO;
import capstone2021.smartGym_backend.DTO.GymInfo.GymOperationInfoDTO;
import capstone2021.smartGym_backend.domain.GymHoliday;
import capstone2021.smartGym_backend.domain.GymOperationInfo;
import capstone2021.smartGym_backend.repository.GymOperationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class GymOperationInfoServiceImpl implements GymOperationInfoService{
    private final GymOperationInfoRepository gymOperationInfoRepository;

    @Autowired
    public GymOperationInfoServiceImpl(GymOperationInfoRepository gymOperationInfoRepository) {
        this.gymOperationInfoRepository = gymOperationInfoRepository;
    }

    @Override
    public boolean update(GymOperationInfoDTO gymOperationInfoDTO) {
        GymOperationInfo gymOperationInfo = new GymOperationInfo();
        gymOperationInfo.setGymOperationInfoReservationDuration(gymOperationInfoDTO.getGymOperationInfoReservationDuration());
        gymOperationInfo.setGymOperationInfoRegularHoliday(gymOperationInfoDTO.getGymOperationInfoRegularHoliday());

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            gymOperationInfo.setGymOperationInfoOperatingStartTime(format.parse(gymOperationInfoDTO.getGymOperationInfoOperatingStartTime()));
            gymOperationInfo.setGymOperationInfoOperatingEndTime(format.parse(gymOperationInfoDTO.getGymOperationInfoOperatingEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return gymOperationInfoRepository.update(gymOperationInfo);
    }

    @Override
    public GymOperationInfo read() {
        return gymOperationInfoRepository.read();
    }

    @Override
    public boolean createHoliday(GymHolidayCreateDTO gymHolidayCreateDTO) {
        GymHoliday gymHoliday = new GymHoliday();

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        try {
            gymHoliday.setGymHolidayDate(format.parse(gymHolidayCreateDTO.getGymHolidayDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return gymOperationInfoRepository.createHoliday(gymHoliday);
    }

    @Override
    public boolean deleteHoliday(GymHolidayDeleteDTO gymHolidayDeleteDTO) {
        GymHoliday gymHoliday = new GymHoliday();

        gymHoliday.setGymHolidayID(gymHolidayDeleteDTO.getGymHolidayID());

        return gymOperationInfoRepository.deleteHoliday(gymHoliday);
    }

    @Override
    public List<GymHoliday> readHoliday() {
        return gymOperationInfoRepository.readHoliday();
    }
}
