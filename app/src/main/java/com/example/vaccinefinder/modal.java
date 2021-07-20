package com.example.vaccinefinder;
public class modal {
                String centerId;
                 String centerName;
                 String centerAddress;
                 String centerStateName;
                 String centerDistrictName;
                 String centerBlockName;
                 String centerPinCode;
                 String centerFrom;
                 String centerTo;
                 String centerFeetype;
                 String centerSessions;
                 String sessionId;
                 String sessionDate;
                 String available_capacity;
                 String min_age_limit;
                 String vaccine;
                 String available_capacity_dose1;
                 String available_capacity_dose2;

    public modal(String centerId, String centerName, String centerAddress, String centerStateName, String centerDistrictName, String centerBlockName, String centerPinCode, String centerFrom, String centerTo, String centerFeetype, String centerSessions, String sessionId, String sessionDate, String available_capacity, String min_age_limit, String vaccine, String available_capacity_dose1, String available_capacity_dose2) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.centerAddress = centerAddress;
        this.centerStateName = centerStateName;
        this.centerDistrictName = centerDistrictName;
        this.centerBlockName = centerBlockName;
        this.centerPinCode = centerPinCode;
        this.centerFrom = centerFrom;
        this.centerTo = centerTo;
        this.centerFeetype = centerFeetype;
        this.centerSessions = centerSessions;
        this.sessionId = sessionId;
        this.sessionDate = sessionDate;
        this.available_capacity = available_capacity;
        this.min_age_limit = min_age_limit;
        this.vaccine = vaccine;
        this.available_capacity_dose1 = available_capacity_dose1;
        this.available_capacity_dose2 = available_capacity_dose2;
    }
}
