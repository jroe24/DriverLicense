package com.jacobroe.DriversLicense.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.jacobroe.DriversLicense.models.License;
import com.jacobroe.DriversLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	public static int licenseNumber;
	
	public static int getLicenseNumber() {
		return licenseNumber;
	}
	
	public static void setLicenseNumber(int licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}
	
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	
	public License addLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public Optional<License> getLicense(Long id) {
		return licenseRepository.findById(id);
	}
	
	public String setLicenseNumber() {
		if(licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber);
		}
		else {
			List<License> top = licenseRepository.findTopByOrderByNumberDesc() ;
			licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber);
		}
	}
	
}